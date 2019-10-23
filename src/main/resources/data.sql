insert into user values(11, sysdate(), 'erhaborosagie@gmail.com', 'Osagie Erhabor')
insert into user values(12, sysdate(), 'osagie.erhabor@upperlink.ng', 'Augustine Erhabor')
insert into user values(13, sysdate(), 'erhaborosagie@gmail.com', 'Osagie Augustine')
insert into post values(12, 'Obi is a Boy', 11)
insert into post values(22, 'Simbi is a Girl', 13)

--delete from user where id in (11, 12, 13)

--(id integer not null, dob timestamp, email varchar(255), name varchar(255), primary key (id))
--create table post (id integer not null, description varchar(255), user_id integer, primary key (id))