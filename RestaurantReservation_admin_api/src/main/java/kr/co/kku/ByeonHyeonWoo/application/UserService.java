package kr.co.kku.ByeonHyeonWoo.application;

import kr.co.kku.ByeonHyeonWoo.domain.User;
import kr.co.kku.ByeonHyeonWoo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public User addUser(String email, String name) {
        User user = User.builder()
                    .email(email)
                    .name(name)
                    .build();

        return userRepository.save(user);
    }

    public User updateUser(Long id, String email, String name, Long level) {
        return null;
    }
}
