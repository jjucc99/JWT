package com.sparta.springcore.memo;

import com.sparta.springcore.dto.CommentDto;
import com.sparta.springcore.model.Comment;
import com.sparta.springcore.model.Memo;
import com.sparta.springcore.repository.CommentRepository;
import com.sparta.springcore.repository.MemoRepository;
import com.sparta.springcore.service.CommentService;
import com.sparta.springcore.service.MemoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootTest
@Transactional
public class MemoTest {

    @PersistenceContext
    EntityManager em;



    private final CommentService commentService;

    private final CommentRepository commentRepository;

    private final MemoService memoService;

    private final MemoRepository memoRepository;


    @Autowired
    public MemoTest(CommentService commentService, CommentRepository commentRepository, MemoService memoService, MemoRepository memoRepository) {
        this.commentService = commentService;
        this.commentRepository = commentRepository;
        this.memoService = memoService;
        this.memoRepository = memoRepository;
    }

}
