package com.example.demo.controller;

import com.example.demo.exception.UserException;
import com.example.demo.pojo.userpojo.OrderPojo;
import com.example.demo.pojo.userpojo.User;
import com.example.demo.repository.userdao.Orderrepository;
import com.example.demo.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/user")
public class Usercontroller {

@Autowired
UserService userService;

@Autowired
    Orderrepository orderrepository;

 @PostMapping(value = "/saveuser")
    public ResponseEntity<User> saveusertodb(@RequestBody User user){

try{
    userService.saveuser(user);
    return new ResponseEntity<>(user , HttpStatus.ACCEPTED);
}catch (UserException e) {
    return new ResponseEntity<>(user , HttpStatus.NOT_IMPLEMENTED);
}


 }

 @GetMapping(value = "/{id}")
    public ResponseEntity<User> getuserbyid(@PathVariable (name = "id") int id) throws UserException {

     try {
       Optional<User> user = userService.getUserByid(id);
       return new ResponseEntity(user , HttpStatus.ACCEPTED);
     }catch (UserException userException){
         throw new UserException("Error with database");

     }

 }

 @GetMapping(value = "/findallusers")
 public ResponseEntity<List<User>> getallusers() throws UserException {

     try{

      Optional<List<User>>  list = userService.getallUsers();
return new ResponseEntity(list , HttpStatus.ACCEPTED);
     }catch (UserException ue){
        throw new UserException("Try again");
     }

 }

 @PostMapping(value = "/placeorder")
    public String placeorder(@RequestBody OrderPojo orderPojo) throws UserException {

//     orderrepository.save(orderPojo);
    return userService.placeuserorder(orderPojo);


 }
    @GetMapping(value = "/findallorders")
    public ResponseEntity<List<OrderPojo>> getallorders() throws UserException {


            List<OrderPojo>  list = orderrepository.getorders();
            return new ResponseEntity(list , HttpStatus.ACCEPTED);


    }




}
