package com.sparta.springcore.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Getter
@NoArgsConstructor
public class CommentDto {
    private String contents;

    public CommentDto(String contents) {
        this.contents = contents;
    }
}
