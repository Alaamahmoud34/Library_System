package com.springboot.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Books_Out_On_Loan")
@IdClass(PK_BooksOutOnLoan.class)
public class Books_Out_On_Loan {

    @Id
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "userId" ,nullable=false)
    private User user;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Book.class)
    @JoinColumn(name="bookId",nullable = false)
    private Book book;

    @Column
    private Date Date_Issued;

    @Column
    private Date Date_due_for_return;

    @Column
    private Date Date_returned;

    @Column
    private float amount_of_fine;

    public Books_Out_On_Loan(User user, Book book) {
        this.user = user;
        this.book = book;
        Date date=new Date();
        Date_Issued = date;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        if (calendar.get(Calendar.MONTH) == Calendar.DECEMBER) {
            calendar.set(Calendar.MONTH, Calendar.JANUARY);
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + 1);
        } else {
            calendar.roll(Calendar.MONTH, true);
        }
        this.setDate_due_for_return(calendar.getTime());
    }
}
