create table books
(
id bigint not null constraint books_pkey primary key,
isbn varchar(255),
author varchar(255),
title varchar (255)
);

insert into books values(1, "test_1", "test_1", "test_1")