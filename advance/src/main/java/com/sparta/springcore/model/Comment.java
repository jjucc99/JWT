package com.sparta.springcore.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sparta.springcore.dto.CommentDto;
import com.sparta.springcore.utiles.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMMENT_ID")
    private Long id;

    @Column(nullable = false)
    private String contents;

    @JsonManagedReference // 순환참조 방지
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMO_ID")
    private Memo memo;

    public Comment(CommentDto commentDto) {
        this.contents = commentDto.getContents();
    }

    public void update(CommentDto commentDto) {
        this.contents = commentDto.getContents();
    }

    public void setMemo(Memo memo) {
        this.memo = memo;
    }
}
