package com.sparta.springcore.service;

import com.sparta.springcore.dto.CommentDto;
import com.sparta.springcore.model.Comment;
import com.sparta.springcore.model.Memo;
import com.sparta.springcore.repository.CommentRepository;
import com.sparta.springcore.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class CommentService {

    private final MemoService memoService;
    private final CommentRepository commentRepository;

    public Long update(Long memoId, CommentDto commentDto) {
        Memo memo = memoService.findById(memoId);
        List<Comment> commentList = memo.getCommentList();

        for (Comment comment : commentList) {
            if (memo.getId() == comment.getMemo().getId()) {
                comment.update(commentDto);
                return comment.getId();
            }
        }
        return null;
    }

    public Comment createComment(CommentDto commentDto, Long memoId) {
        String contents = commentDto.getContents();

        if (Objects.equals(contents, "")) {
            throw new NullPointerException("댓글내용을 입력해주세요");
        }
        Memo byId = memoService.findById(memoId);
        Comment comment = new Comment(commentDto);
        byId.getCommentList().add(comment);
        comment.setMemo(byId);
        return commentRepository.save(comment);
    }

    public Long delete(Long commentId) {
        Optional<Comment> byId = commentRepository.findById(commentId);
        Comment comment = byId.get();
        Memo memo = comment.getMemo();

        memo.getCommentList().remove(comment);
        commentRepository.deleteById(commentId);

        return comment.getId();
    }
}
