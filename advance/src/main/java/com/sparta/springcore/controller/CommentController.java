package com.sparta.springcore.controller;

import com.sparta.springcore.dto.CommentDto;
import com.sparta.springcore.model.Comment;
import com.sparta.springcore.model.Memo;
import com.sparta.springcore.model.UserRoleEnum;
import com.sparta.springcore.repository.CommentRepository;
import com.sparta.springcore.repository.MemoRepository;
import com.sparta.springcore.service.CommentService;
import com.sparta.springcore.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final MemoService memoService;



    //CREATE
    @PostMapping("/api/comment/{memoId}")
    public Comment createComment(@RequestBody CommentDto commentDto,
                                 @PathVariable Long memoId) {
        return commentService.createComment(commentDto, memoId);
    }
    //READ
    @GetMapping("/api/comment/{memoId}")
    public List<Comment> readComment(@PathVariable Long memoId) {
        return memoService.findById(memoId).getCommentList();
    }

    //UPDATE
    @PutMapping("/api/comment/{memoId}")
    public Long updateComment(@PathVariable Long memoId,
                              @RequestBody CommentDto commentDto
    ) {
        return commentService.update(memoId, commentDto);
    }
    //DELETE
    @DeleteMapping("/api/comment/{commentId}")
    public Long deleteMemo(@PathVariable Long commentId) {
        return commentService.delete(commentId);
    }

    @ExceptionHandler({
            IllegalArgumentException.class,
            NullPointerException.class
    })
    public ResponseEntity<Object> InternalServerError(final Exception ex) {
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }
}
