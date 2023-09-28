create database Books_DB;
use books_db;

create table customer(
	CustomerId int primary key auto_increment,
    Name varchar(255),
    Email varchar(255),
    Phone varchar(10),
    Address varchar(255)
);

create table Orders(
	OrderId int primary key auto_increment,
    OrderDate date,
    TotalAmount decimal(10,2)
);

create table Book(
	ISBN varchar(13) primary key,
    Title varchar(255),
    Price decimal(10,2),
    Author varchar(255),
    Publisher varchar(255),
    PublicationYear int,
    Category varchar(255)
);

create table Author(
	AuthorId int primary key auto_increment,
    AuthorName varchar(100)
);

create table Publisher(
	PublisherID int primary key auto_increment,
    PublisherName varchar(100)
);

create table Category(
	CategoryID int primary key auto_increment,
    CategeoryName varchar(200)
);

create table Supplier(
	SupplierID int primary key auto_increment,
    SupplierName varchar(255)
);

create table Employee(
	EmployeeID int primary key auto_increment,
    EmployeeName varchar(255)
);

create table MusicItem(
	MusicItemID int primary key auto_increment,
    Title varchar(255),
    Artist varchar(255),
    format ENUM ('Cassette','CD'),
    Price decimal(10,2)
);

create table Item(
	ItemID int primary key auto_increment,
    Title varchar(200),
    Price decimal(10,2)
);

create table BookIsAnItem(
	ISBN varchar(13) primary key,
    ItemID int,
    foreign key (ISBN) references Book(ISBN),
    foreign key (ItemID) references Item(ItemID)
);

create table MusicCassette(
	MusicCassetteID int primary key auto_increment,
    ItemID int,
    Artist varchar(255),
    format ENUM('Cassette'),
    Price decimal(10,2),
    foreign key (ItemID) references Item(ItemID)
);


create table CompactDisc (
    CompactDiscID int primary key auto_increment,
    ItemID int,
    Artist varchar(255),
    Format ENUM('CD'),
    Price decimal(10, 2),
    foreign key (ItemID) references Item(ItemID)
);

create table Basket(
	BasketId int primary key auto_increment
);

create table contains(
	BasketId int,
    ItemId int,
    foreign key(BasketId) references Basket(BasketId),
    foreign key (ItemId) references Item(ItemId)
);

create table ContainsOrder(
	OrderId int,
    ISBN varchar(13),
    foreign key(Orderid) references orders(orderId),
    foreign key (ISBN) references Book(ISBN)
);

create table PublishedBy(
	ISBN varchar(13),
    PublisherID int,
    foreign key (ISBN) references Book(ISBN),
    foreign key (PublisherID) references Publisher(PublisherID)
);
use books_db;
CREATE TABLE Sells (
    SupplierID INT,
    MusicItemID INT,
    FOREIGN KEY (SupplierID) REFERENCES Supplier(SupplierID),
    FOREIGN KEY (MusicItemID) REFERENCES MusicItem(MusicItemID)
);