create table author
(
  author_id   bigserial not null
    constraint author_pkey
      primary key,
  author_name varchar(255)
);

create table category
(
  category_id   bigserial not null
    constraint category_pkey
      primary key,
  category_name varchar(255)
);

create table book
(
  book_id             bigserial not null
    constraint book_pkey
      primary key,
  book_name           varchar(255),
  data_of_publication timestamp,
  author_id           bigint    not null
    constraint fkfjixh2vym2cvfj3ufxj91jem7
      references author,
  category_id         bigint    not null
    constraint fkleqa3hhc0uhfvurq6mil47xk0
      references category
);

create table users
(
  user_id      bigserial not null
    constraint user_pkey
      primary key,
  email        varchar(255),
  phone_number varchar(255),
  user_address varchar(255),
  user_name    varchar(255)
);

create table books_out_on_loan
(
  book_id             bigint not null
    constraint fkshox349mcbq7dqcb7mov139l4
      references book,
  user_id             bigint not null
    constraint fkbedk80txlquhygdfjv5084qxq
      references users,
  date_issued         timestamp,
  date_due_for_return timestamp,
  date_returned       timestamp,
  amount_of_fine      real,
  constraint books_out_on_loan_pkey
    primary key (book_id, user_id)
);
