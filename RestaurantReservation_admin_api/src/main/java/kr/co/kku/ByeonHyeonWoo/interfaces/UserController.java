package kr.co.kku.ByeonHyeonWoo.interfaces;

import kr.co.kku.ByeonHyeonWoo.application.UserService;
import kr.co.kku.ByeonHyeonWoo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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

    @PostMapping("/users")
    public ResponseEntity<?> create(
            @RequestBody User resource
    ) throws URISyntaxException {

        String email = resource.getEmail();
        String name = resource.getName();
        User user = userService.addUser(email,name);

        String url = "/users/" + user.getId();

        return ResponseEntity.created(new URI(url)).body("{}");
    }

    @PatchMapping("/users/{id}")
    public void update(
            @PathVariable("id") Long id,
            @RequestBody User resource
    ){
        String email = resource.getEmail();
        String name = resource.getName();
        Long level = resource.getLevel();

        User user = userService.updateUser(id,email,name,level);
    }

    @DeleteMapping("/users/{id}")
    public String delete(
                @PathVariable("id") Long id
    ){
        userService.deactiveUser(id);
        return "{}";
    }


    //1. User list
    //2. User create ->회원가입
    //3. User update
    //4. User delete -> level: 0 => 아무 것도 못함.
    //(1: customer, 2: restaurant owner, 3: admin )
}
