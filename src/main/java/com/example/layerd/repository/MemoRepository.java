package com.example.layerd.repository;

import com.example.layerd.dto.MemoResponseDto;
import com.example.layerd.entity.Memo;

import java.util.List;

public interface MemoRepository {

    MemoResponseDto savaMemo(Memo memo);

    List<MemoResponseDto> findAllMemos();

    Memo findMemoById(Long id);

    void deleteMemo(Long id);
}
