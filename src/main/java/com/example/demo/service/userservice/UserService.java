package com.example.demo.service.userservice;

import com.example.demo.exception.UserException;
import com.example.demo.pojo.userpojo.OrderPojo;
import com.example.demo.pojo.userpojo.User;
import com.example.demo.repository.userdao.Orderrepository;
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
    @Autowired
    Orderrepository orderrepository;

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

    public String placeuserorder(OrderPojo orderPojo , int id) throws UserException {


        User user = userdaorepository.findById(id).get();
        orderPojo.setUser(user);
        orderrepository.save(orderPojo);

        return "Order with  placed";

    }


}
