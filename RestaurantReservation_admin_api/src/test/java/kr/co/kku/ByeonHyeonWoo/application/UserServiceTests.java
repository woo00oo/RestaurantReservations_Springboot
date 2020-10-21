package kr.co.kku.ByeonHyeonWoo.application;

import kr.co.kku.ByeonHyeonWoo.domain.User;
import kr.co.kku.ByeonHyeonWoo.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

public class UserServiceTests {


    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        userService =  new UserService(userRepository);
    }


    @Test
    public void getUsers(){
        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(User.builder()
                .email("tester@example.com")
                .name("tester").level(1L).build());
        given(userRepository.findAll()).willReturn(mockUsers);


        List<User> users = userService.getUsers();

        User user = users.get(0);

        assertThat(user.getName(), is("tester"));
    }

    @Test
    public void addUser(){
        String email = "admin@example.com";
        String name = "Administrator";
        User mockUser = User.builder().email(email).name(name).build();

        given(userRepository.save(any())).willReturn(mockUser);

        User user = userService.addUser(email, name);

        assertThat(user.getName(),is(name));
    }

}