package com.cavsteek.CrudRestApi.Controller;

import com.cavsteek.CrudRestApi.Model.User;
import com.cavsteek.CrudRestApi.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;
    @GetMapping("/")
    public String getPage() {
        return "Welcome";
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }


}
