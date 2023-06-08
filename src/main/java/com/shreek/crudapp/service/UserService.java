package com.shreek.crudapp.service;

import com.shreek.crudapp.dto.ResponseDTO;
import com.shreek.crudapp.exception.CustomException;
import com.shreek.crudapp.model.User;
import com.shreek.crudapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * Method to create new user
     *
     * @param user User detail from client
     * @return Saved User Object
     */
    public ResponseEntity<User> create(User user) {
        User addUser = new User();

        // get form input and set it into object
        addUser.setFirstName(user.getFirstName());
        addUser.setLastName(user.getLastName());
        addUser.setEmail(user.getEmail());
        addUser.setPhoneNumber(user.getPhoneNumber());
        addUser.setPassword(user.getPassword());

        // save user in database
        User savedUser = userRepository.save(addUser);

        // return save user with status-code 200
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    /**
     * Method to Get All User
     *
     * @return List of All Users or Blank List
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Method to Get User By id
     *
     * @param id User id form client
     * @return User or Error message
     */
    @GetMapping("/{id}")
    public Optional<User> getUserById(int id) {
        return Optional.ofNullable(userRepository.findById(id).orElseThrow(() ->
                new CustomException("User Not Found By Id" + id)));
    }

    /**
     * Method to Update Old User By id
     *
     * @param id User id and user form client
     * @return Updated User Object  or Error message
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserById(int id, User user) {
        User oldUser = userRepository.findById(id).orElseThrow(() ->
                new CustomException("User Not Found By id" + id));
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setPhoneNumber(user.getPhoneNumber());

        User updatedOldUser = userRepository.save(oldUser);

        return new ResponseEntity<>(updatedOldUser, HttpStatus.OK);
    }

    /**
     * Method to Delete User By id
     *
     * @return success message or Error
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteUserById(int id) {
        // User find by id in user repository
        Optional<User> user = userRepository.findById(id);

        // if user is present then @deleteById deleted User
        if (user.isPresent()) userRepository.deleteById(id);

            //error user not found message
        else throw new CustomException("User Not Found By Id " + id);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatusCode(200);
        responseDTO.setMessage("Delete User Successfully");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
