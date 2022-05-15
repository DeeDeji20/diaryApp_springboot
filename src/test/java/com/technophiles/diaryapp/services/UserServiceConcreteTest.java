package com.technophiles.diaryapp.services;

import com.technophiles.diaryapp.dtos.UserDto;
import com.technophiles.diaryapp.exceptions.DiaryApplicationException;
import com.technophiles.diaryapp.models.User;
import com.technophiles.diaryapp.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class UserServiceConcreteTest {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserRepository userRepository;

    @Test
    void testThatCanBeDeleted() throws DiaryApplicationException {
        UserDto userDto = userService.createAccount("lota@gmail.com", "lotachukwu");
        User user = userRepository.findById(userDto.getId()).get();
        userService.deleteUser(user);

        Optional<User> foundUser = userRepository.findById(userDto.getId());
        assertThat(foundUser).isEmpty();

    }
}
