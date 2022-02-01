drop table book cascade;
create table book
(
  book_id             bigserial not null
    constraint book_pkey
      primary key,
  book_name           varchar(255),
  date_of_publication timestamp,
  author_id           bigint    not null
    constraint fkklnrv3weler2ftkweewlky958
      references author ON DELETE CASCADE ,
  category_id         bigint    not null
    constraint fkam9riv8y6rjwkua1gapdfew4j
      references category ON DELETE CASCADE
);

drop table books_out_on_loan cascade;
create table books_out_on_loan
(
  date_issued         timestamp,
  date_due_for_return timestamp,
  date_returned       timestamp,
  amount_of_fine      real,
  user_id             bigint not null
    constraint fkbedk80txlquhygdfjv5084qxq
      references users ON DELETE CASCADE ,
  book_id             bigint not null
    constraint fkdo6r07u9nuhp3486hmgpxbyfu
      references book ON DELETE CASCADE ,
  constraint books_out_on_loan_pkey
    primary key (book_id, user_id)

);