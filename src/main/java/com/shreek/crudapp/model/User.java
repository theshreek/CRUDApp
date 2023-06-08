package com.shreek.crudapp.model;



import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Data
/*
 * create table in database
 */
@Table(name = "user_tbl")
public class User {
     // define primary key
    @Id

     // to supported for simple primary keys
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;

}
