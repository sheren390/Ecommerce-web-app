package gov.iti.jets.ecommiti.services;

import gov.iti.jets.ecommiti.mappers.CategoryMapper;
import gov.iti.jets.ecommiti.mappers.UserMapper;
import gov.iti.jets.ecommiti.models.ResponseViewModel;
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

    public ResponseViewModel getAll() {
        ResponseViewModel responseViewModel = new ResponseViewModel();
        responseViewModel.setData(UserMapper.INSTANCE.map(userRepository.findAll()));
        return responseViewModel;
//        return userRepository.findAll();
    }

    public User add(User user){

        userRepository.save(user);
        return user;
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public ResponseViewModel updateUser(Integer id, User user) {
        ResponseViewModel responseViewModel = new ResponseViewModel();
        Optional<User> existingUser = userRepository.findById(id);

        // if (existingUser.isEmpty()) {
        //     throw new ResourceNotFoundException("User", "id", id);
        // }
        User updatedUser = existingUser.get();
        updatedUser.setUsername(user.getUsername());
        updatedUser.setPhone(user.getPhone());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setWalletBalance(user.getWalletBalance());
        updatedUser.setAddress(user.getAddress());
        updatedUser.setProducts(user.getProducts());
        updatedUser.setOrders(user.getOrders());
        responseViewModel.setData(UserMapper.INSTANCE.map(userRepository.save(updatedUser)));

        return responseViewModel;

    }

    public ResponseViewModel updateBalanceService(int id,User user){
        ResponseViewModel responseViewModel = new ResponseViewModel();
        Optional<User> existUser = userRepository.findById(id);
        User userWithUpdatedBalance = existUser.get();
        userWithUpdatedBalance.setWalletBalance(user.getWalletBalance());
        responseViewModel.setData(UserMapper.INSTANCE.map(userRepository.save(userWithUpdatedBalance)));
        return responseViewModel;
    }

    public ResponseViewModel getuserById(Integer id) {
        ResponseViewModel responseViewModel = new ResponseViewModel();
        responseViewModel.setData(UserMapper.INSTANCE.map(userRepository.findById(id).get())); 
        return responseViewModel;
    }

}