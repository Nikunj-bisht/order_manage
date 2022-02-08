package com.example.demo.pojo.userpojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrderPojo {


//    order_id INT PRIMARY KEY auto_increment,
//    order_desc VARCHAR(40),
//    customer_id INT NOT NULL,
//    total_amount DOUBLE NOT NULL,
//    total_qty INT NOT NULL

   @Id
   @Column(name = "order_id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int order_id;

   @Column(name = "order_desc")
    private String order_desc;

   @Column(name = "total_amount")
    private int total_amount;

   @Column(name = "total_qty")
    private int total_qty;

   @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
@JsonIgnore
    User user;


}
