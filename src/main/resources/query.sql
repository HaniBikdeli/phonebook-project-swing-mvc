use PhoneBook;

Create table users (
	userId int NOT NULL IDENTITY(1,1) PRIMARY KEY,
	username nvarchar(50) not null ,
	password varchar(50) not null,
	access int not null
);

Create table contacts (
	contactId int NOT NULL IDENTITY(1,1) PRIMARY KEY,
	FullName nvarchar(50) not null ,
	PhoneNumber varchar(50) not null,
	ownerId int not null,
	auth int not null
);

insert into dbo.users (username , password , access)
values('admin','1234','1'), 
('userA','1234a','2'),
('userB','1234b','2');

insert into dbo.contacts (FullName , PhoneNumber , ownerId , auth)
values('hani bikdeli','09104204453','1' , '1'), 
('contact1','09123456789','2' , '2'),
('contact2','09912223344','2' , '2'),
('contact3','09381905580','3' , '1');


select * from dbo.users;
select * from dbo.contacts;