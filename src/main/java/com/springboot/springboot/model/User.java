package com.springboot.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long User_ID;

    @Column
    private String User_name;

    @Column
    private String User_Address;

    @Column
    private String Phone_Number;

    @Column
    private String Email;

    //@OneToMany(cascade = CascadeType.ALL, targetEntity = Books_Out_On_Loan.class)
    //private Set<Books_Out_On_Loan> Borrowed_Books;
}
