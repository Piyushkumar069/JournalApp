package com.project.journalApp.service;

import com.project.journalApp.entity.User;
import com.project.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@Disabled
@SpringBootTest // this is to start the spring boot context.
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void testFindByUserName(){
        assertNotNull(userRepository.findByUserName("hariOm"));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "ram",
            "shyam",
            "vipul"
    })
    public void testFindJournalEntryPresentOrNot(String name){
        User byUserName = userRepository.findByUserName(name);
        assertTrue(!byUserName.getJournalEntries().isEmpty());
    }

    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testSaveNewUser(User user){
        assertTrue(userService.saveNewUser(user));
    }

    @ParameterizedTest // used when test contains parameters
    @CsvSource({ // used when We want to send multiple inputs at a time
            "1, 2, 3",
            "2, 10, 12",
            "3, 3, 6"
    })
    public void test(int a, int b, int expected){
        assertEquals(expected, a+b);
    }
}
