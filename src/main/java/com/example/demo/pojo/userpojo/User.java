package com.example.demo.pojo.userpojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int user_id;

  @Column(name = "user_name")
  private String user_name;
 // mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false
  @Column(name = "age")
  private int age;

  @Column(name = "address")
  private String address;

  @Column(name = "mobile_no")
  private int mobile_no;

  @Column(name = "email")
  private String email;

  @OneToMany(cascade = CascadeType.ALL)
          @JoinColumn(name = "user_id",referencedColumnName = "user_id")
  List<OrderPojo> orders;



}
