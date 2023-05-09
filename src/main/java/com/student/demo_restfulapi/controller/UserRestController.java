package com.student.demo_restfulapi.controller;


import com.student.demo_restfulapi.model.User;
import com.student.demo_restfulapi.model.UserAccount;
import com.student.demo_restfulapi.model.request.UserRequest;
import com.student.demo_restfulapi.service.UserService;
import com.student.demo_restfulapi.utils.Response;
import org.mapstruct.control.MappingControl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserRestController {
//    inject userService
    private final UserService userService;
    UserRestController (UserService userService){
        this.userService = userService;
    }

    @GetMapping("/allusers")
    List<User> getAllUser(){
        return userService.allUsers();
    }

    @GetMapping("/user/{id}")
    public User findUserByID(@PathVariable int id){
        return userService.findUserByID(id);
    }

    @PostMapping("/new-user")
    public String createUser(@RequestBody User user){
        try{
            int affectRow = userService.createNewUser(user);
            System.out.println("Affect Row : " + affectRow);
            if(affectRow>0)
                return "Create user successfully !";
            else
                return "Cannat create a new user ! ";
        }catch (Exception exception){
            return exception.getMessage();
        }
    }

    @GetMapping("/user-accounts")
    public Response<List<UserAccount>> getAllUserAccount(){
        try{
            List<UserAccount> data = userService.getAllUserAccounts();
            return Response.<List<UserAccount>>ok().setPayload(data).setMessage("Successfully retrieved all user accounts !");
        }catch (Exception ex){
            return Response.<List<UserAccount>>exception().setMessage(" Exception occurs !Failed to retrieved all users accounts").setSuccess(false);

        }
    }
}
