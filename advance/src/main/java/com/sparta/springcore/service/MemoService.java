package com.sparta.springcore.service;

import com.sparta.springcore.dto.MemoRequestDto;
import com.sparta.springcore.model.Memo;
import com.sparta.springcore.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("메모가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return memo.getId();
    }

    @Transactional
    public Memo findById(Long id) {
        return memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("메모가 존재하지 않습니다.")
        );
    }
}
