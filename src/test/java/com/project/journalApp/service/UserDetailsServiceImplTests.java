package com.project.journalApp.service;

import com.project.journalApp.entity.User;
import com.project.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@Disabled
public class UserDetailsServiceImplTests {

    // if we use @SpringBootTest we need to use @MockBean annotation on userRepository
    // but if we test without @SpringBootTest then we use @InjectMocks and @Mock only

    // testing using Mockito

    //InjectMocks automatically creates the instances and then find variables with Mock dependencies
    // and then injects here
    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setup(){
        // here we are initializing all the mocks of this class.
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void loadUserByUsernameTest(){
        // here we are mocking the database that whenever (userRepository.findByUserName(ArgumentMatchers.anyString()))) this method is called
        // then you have to return (thenReturn(User.builder().userName("hariOm").password("jdjdjdjd").build()) this not actually call the method.
        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("hariOm").password("jdjdjdjd").roles(new ArrayList<>()).build());
        UserDetails user = userDetailsService.loadUserByUsername("hariOm");
        Assertions.assertNotNull(user);
    }
}
