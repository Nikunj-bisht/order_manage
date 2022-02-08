package com.example.demo.repository.userdao;

import com.example.demo.pojo.userpojo.OrderPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Orderrepository extends JpaRepository<OrderPojo , Integer> {

    @Query("SELECT u FROM OrderPojo u")
     List<OrderPojo> getorders();

}
