create table countries (
	countryId int NOT NULL IDENTITY(1,1) PRIMARY KEY,
	CountryName nvarchar(50) not null 
);
create table provinces(
	provinceId int NOT NULL IDENTITY(1,1) PRIMARY KEY,
	ProvinceName nvarchar(50) not null,
	provinceFk int not null FOREIGN KEY REFERENCES countries(countryId)
);