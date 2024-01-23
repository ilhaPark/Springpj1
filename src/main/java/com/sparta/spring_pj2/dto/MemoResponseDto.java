package com.sparta.spring_pj2.dto;



import com.sparta.spring_pj2.enity.Memo;
import lombok.Getter;


//메모클래스 : 데이터베이스와 소통하는 클래스와 똑같은경우가 은근 많을꺼다. 그럼에도 불구하고 분리하는 이유는 데이터베이스와 분류해야되기 때ㄴ문이다.
@Getter
public class MemoResponseDto {
    private Long id;
    private String username;
    private String contents;

    public MemoResponseDto(Memo memo) {
        this.id = memo.getId();
        this.username = memo.getUsername();
        this.contents = memo.getContents();
    }
}