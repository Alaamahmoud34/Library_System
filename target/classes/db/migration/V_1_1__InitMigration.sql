insert into "public".author (author_id,author_name) values
(1,'Alaa'),
(2,'Ahmed');

insert into "public".category (category_id,category_name) values
(1,'Romantic'),
(2,'Drama'),
(3,'Horror'),
(4,'Comedy');

insert into "public".book (book_id,book_name,data_of_publication,author_id,category_id) values
(1,'book1','28/12/2005',1,1),
(2,'book2','20/1/2010',2,2),
(3,'book3','8/11/2007',1,3),
(4,'book4','2/2/2015',2,4);

insert into "public".users (user_id,email,phone_number,user_address,user_name) values
(1,'reham34@gmail.com','01278456756','Helwan','Reham'),
(2,'basmala3@gmail.com','01197646786','Giza','Basmala'),
(3,'gehad4@gmail.com','01008975375','Sadat','Gehad'),
(4,'hanan@gmail.com','0158036740','10 of Ramadan','Hanan');

insert into "public".books_out_on_loan (book_id,user_id,date_issued,date_due_for_return,date_returned,amount_of_fine) values
(1,4,'24/11/2021','24/12/2021','25/12/2021',10),
(2,2,'20/10/2021','20/11/2021','20/11/2021',0),
(3,1,'2/1/2021','2/2/2021','1/2/2021',0),
(4,3,'15/9/2021','15/10/2021','15/11/2021',30);
