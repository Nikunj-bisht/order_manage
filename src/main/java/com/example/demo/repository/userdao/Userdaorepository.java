package com.example.demo.repository.userdao;

import com.example.demo.pojo.userpojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userdaorepository extends JpaRepository<User , Integer> {

}
