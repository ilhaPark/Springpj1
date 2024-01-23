package com.sparta.spring_pj2.controller;


import com.sparta.spring_pj2.dto.MemoRequestDto;
import com.sparta.spring_pj2.dto.MemoResponseDto;
import com.sparta.spring_pj2.enity.Memo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MemoController {

    private final Map<Long, Memo> memoList = new HashMap<>();

    @PostMapping("/memos")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
        //데이터는 제이슨형태로 넘어오면 RequestBody ...?
        //@RequestBody와 @ResponseBody의 차이?


        //RequestDto -> Entity
        Memo memo = new Memo(requestDto);

        //Memo Max ID Check
        Long maxID = memoList.size() > 0 ? Collections.max(memoList.keySet()) + 1 : 1;
        memo.setId(maxID);


        //DB 저장
        memoList.put(memo.getId(), memo);

        //Entity -> ResponseDto
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);

        return memoResponseDto;

    }

    @GetMapping("/memos")
    public List<MemoResponseDto> getMemos() {
        //Map To List
        List<MemoResponseDto> responseList = memoList.values().stream()
                .map(MemoResponseDto::new).toList();
        //여기서는 왜 MemoResponseDto?


        return responseList;

    }
}
