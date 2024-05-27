package org.ncu.ecommerce_app.service;

import java.util.List;
import java.util.Optional;

import org.ncu.ecommerce_app.dao.UserDao;
import org.ncu.ecommerce_app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User registerUser(User user) {
        // Logic for user registration, e.g., validation, setting default values, etc.
        // Then save the user
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String username, String password) {
        // Logic for user authentication
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
