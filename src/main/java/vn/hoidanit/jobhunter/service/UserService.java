package vn.hoidanit.jobhunter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleCreateUser(User user) {
        return userRepository.save(user);
    }

    public List<User> fetchAllUser() {
        return userRepository.findAll();
    }

    public User fetchUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User handleUpdateUser(User user) {
        User userCurrent = this.fetchUserById(user.getId());
        if (userCurrent != null) {
            userCurrent.setEmail(user.getEmail());
            userCurrent.setName(user.getName());
            userCurrent.setPassword(user.getPassword());
            userCurrent = this.userRepository.save(userCurrent);
        }
        return userCurrent;
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}
