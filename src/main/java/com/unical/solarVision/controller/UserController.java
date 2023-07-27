package com.unical.solarVision.controller;

import com.unical.solarVision.dto.UserDTO;
import com.unical.solarVision.dto.UserRegistrationDTO;
import com.unical.solarVision.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable("id") Long id) {
        if(userService.existsById(id))
            return new ResponseEntity<UserDTO>(userService.findById(id), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @GetMapping("all")
    public ResponseEntity<List<UserDTO>> getAll() {
        return new ResponseEntity<List<UserDTO>>(userService.findAll(), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<UserDTO> getByEmail(@RequestParam(value = "email") String email) {
        if(userService.findByEmail(email) != null) {
            return new ResponseEntity<UserDTO>(userService.findByEmail(email), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserRegistrationDTO newUserDTO) {
        if(userService.findByEmail(newUserDTO.getEmail()) == null) {
            return new ResponseEntity<UserDTO>(userService.create(newUserDTO), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDTO> modify(@PathVariable("id") Long id, @RequestBody UserDTO userDto) {
        if(userService.findById(id) != null) {
            return new ResponseEntity<UserDTO>(userService.modify(id, userDto), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        if(userService.findById(id) != null){
            userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
