package com.springboot.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Category_ID;

    @Column
    private String Category_Name;

    //@OneToMany(cascade = CascadeType.ALL, targetEntity = Book.class)
    //private Set<Book> Books;
}
