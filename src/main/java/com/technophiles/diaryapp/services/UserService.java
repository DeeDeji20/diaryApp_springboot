package com.technophiles.diaryapp.services;

import com.technophiles.diaryapp.dtos.UserDto;
import com.technophiles.diaryapp.exceptions.DiaryApplicationException;
import com.technophiles.diaryapp.models.Diary;
import com.technophiles.diaryapp.models.User;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
public interface UserService {
    UserDto createAccount(String email, String password) throws DiaryApplicationException;
    UserDto addDiary(@NotNull Long id, @NotNull Diary diary) throws DiaryApplicationException;

    User findById(Long userId) throws DiaryApplicationException;

    boolean deleteUser(User user);

    User findUserByEmail(String email) throws DiaryApplicationException;
}
