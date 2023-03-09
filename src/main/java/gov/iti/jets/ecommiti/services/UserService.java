package gov.iti.jets.ecommiti.services;

import gov.iti.jets.ecommiti.models.User;
import gov.iti.jets.ecommiti.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User add(User user){

        userRepository.save(user);
        return user;
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Integer id, User user) {
        Optional<User> existingUser = userRepository.findById(id);

        // if (existingUser.isEmpty()) {
        //     throw new ResourceNotFoundException("User", "id", id);
        // }

        User updatedUser = existingUser.get();
        updatedUser.setUsername(user.getUsername());
        updatedUser.setPhone(user.getPhone());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setWalletBalance(user.getWalletBalance());
        updatedUser.setAddress(user.getAddress());
        updatedUser.setProducts(user.getProducts());
        updatedUser.setOrders(user.getOrders());
        return userRepository.save(updatedUser);
    }

}