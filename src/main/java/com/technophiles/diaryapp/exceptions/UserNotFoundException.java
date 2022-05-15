package com.technophiles.diaryapp.exceptions;

public class UserNotFoundException extends DiaryApplicationException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
