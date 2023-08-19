package com.cavsteek.CrudRestApi.Controller;

import com.cavsteek.CrudRestApi.Model.User;
import com.cavsteek.CrudRestApi.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;
   /* @GetMapping("/")
    public String getPage() {
        return "Welcome";
    }
    */
   @GetMapping("/hello")
   public ResponseEntity<String> sayHello() {
       String message = "User, welcome";
       HttpStatus status = HttpStatus.OK;
       HttpHeaders headers = new HttpHeaders();
       headers.add("Custom-Header", "HelloHeader");

       ResponseEntity<String> responseEntity = new ResponseEntity<>(message, headers, status);
       return responseEntity;
   }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping("/save")
    public String saveUser (@RequestBody User user){
        userRepo.save(user);
        return "Done.....";
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable long id,@RequestBody User user){
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setAge(user.getAge());
        updatedUser.setOccupation(user.getOccupation());
        userRepo.save(updatedUser);
        return "updated....";
    }

    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable long id){
       User deleteUser = userRepo.findById(id).get();
       userRepo.delete(deleteUser);
       return "Deleted user with id: "+id;
    }


}
