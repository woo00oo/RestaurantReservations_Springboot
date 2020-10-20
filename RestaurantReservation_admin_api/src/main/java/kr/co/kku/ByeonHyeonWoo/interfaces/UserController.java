package kr.co.kku.ByeonHyeonWoo.interfaces;

import kr.co.kku.ByeonHyeonWoo.application.UserService;
import kr.co.kku.ByeonHyeonWoo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> list(){
        List<User> users = userService.getUsers();
        return users;
    }

    //1. User list
    //2. User create ->회원가입
    //3. User update
    //4. User delete -> level: 0 => 아무 것도 못함.
    //(1: customer, 2: restaurant owner, 3: admin )
}
