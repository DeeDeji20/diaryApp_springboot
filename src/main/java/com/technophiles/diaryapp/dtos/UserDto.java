package com.technophiles.diaryapp.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.technophiles.diaryapp.models.Diary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties("diaries")
public class UserDto {
    private Long id;
    private String email;
    private Set<Diary> diaries;
}
