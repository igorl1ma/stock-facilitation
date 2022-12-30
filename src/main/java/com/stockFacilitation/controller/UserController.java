package com.stockFacilitation.controller;

import com.stockFacilitation.dto.UserDto;
import com.stockFacilitation.entity.User;
import com.stockFacilitation.model.UserModel;
import com.stockFacilitation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping(value = "/users")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> allUsers() {
        return userService.findAllUsers()
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/user")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public UserDto userByUsername(@RequestBody UserDto userDto) {
        return modelMapper.map(userService.findByUsername(userDto.getUsername()),UserDto.class);
    }

    @PostMapping(value = "/user")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void newUser(@RequestBody UserModel userModel) {
       userService.saveUser(modelMapper.map(userModel, User.class));
    }

    @PutMapping(value = "/user")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putUser(@RequestBody UserModel userModel) {
        userService.saveUser(modelMapper.map(userModel, User.class));
    }

    @PatchMapping(value = "/user")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patchUser(@RequestBody UserModel userModel) {
        userService.patchUser(modelMapper.map(userModel, User.class));
    }

}
