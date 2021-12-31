package com.springboot.springboot.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Book_ID;

    @Column
    private String Book_Name;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Category.class)
    @JoinColumn(name = "category_ID",nullable = false)
    private Category category;

    @Column
    private Date dateOfPublication;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Author.class)
    @JoinColumn(name = "Author_ID" ,nullable = false)
    private Author author;

    //@OneToMany(cascade = CascadeType.ALL, targetEntity = Books_Out_On_Loan.class)
    //private Set<Books_Out_On_Loan> Borrowing_Details;
}
