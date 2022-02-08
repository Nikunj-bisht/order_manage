package com.example.demo.service.userservice;

import com.example.demo.exception.UserException;
import com.example.demo.pojo.userpojo.OrderPojo;
import com.example.demo.pojo.userpojo.User;
import com.example.demo.repository.userdao.Userdaorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    Userdaorepository userdaorepository;


    public User saveuser(User user) throws UserException {


           User user1 =  userdaorepository.save(user);
           if(user1 == null){
               throw new UserException("Error with db");
           }
        return user1;

    }

    public Optional<User> getUserByid(int id) throws UserException {

        Optional<User> user1 =  userdaorepository.findById(id);
        if(user1.isEmpty()){
            throw new UserException("Error with db");
        }
        return user1;

    }

    public Optional<List<User>> getallUsers() throws UserException {

        Optional<List<User>> list = Optional.of(userdaorepository.findAll());
        if(list.isEmpty()){
            throw new UserException("Try again");
        }
        return list;
    }

    public String placeuserorder(OrderPojo orderPojo) throws UserException {


        User user = getUserByid(1).get();
        user.getOrders().add(orderPojo);
        userdaorepository.save(user);
        return "Order with  placed";

    }


}
