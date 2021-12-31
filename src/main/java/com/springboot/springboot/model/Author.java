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
@Table(name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Author_ID;

    @Column
    private String Author_Name;

    //@OneToMany(cascade = CascadeType.ALL, targetEntity = Book.class)
    //private Set<Book> Books;
}
