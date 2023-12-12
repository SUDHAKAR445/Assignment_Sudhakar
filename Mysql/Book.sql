create database Book_Music;
use Book_music;
CREATE TABLE Customer (
    CustomerID INT PRIMARY KEY,
    Name VARCHAR(255),
    Email VARCHAR(255),
    Phone VARCHAR(20),
    Address VARCHAR(255)
);

CREATE TABLE Orders (
    OrderID INT PRIMARY KEY,
    OrderDate DATE,
    TotalAmount DECIMAL(10, 2),
    CustomerID INT,
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
);

CREATE TABLE Book (
    ISBN VARCHAR(13) PRIMARY KEY,
    Title VARCHAR(255),
    Price DECIMAL(10, 2),
    Author VARCHAR(255),
    Publisher VARCHAR(255),
    PublicationYear INT,
    StockCount INT,
    AuthorId INT,
    PublisherId INT,
    foreign key(AuthorId) references Author(AuthorID),
    foreign key(PublisherId) references Publisher(PublisherId)
);

CREATE TABLE Author (
    AuthorID INT PRIMARY KEY,
    AuthorName VARCHAR(255)
);

CREATE TABLE Publisher (
    PublisherID INT PRIMARY KEY,
    PublisherName VARCHAR(255)
);

CREATE TABLE MusicItem (
    MusicItemID INT PRIMARY KEY,
    Title VARCHAR(255),
    Artist VARCHAR(255),
    Format ENUM('Cassette', 'CD') NOT NULL,
    Price DECIMAL(10, 2),
    StockCount INT
);

CREATE TABLE Item (
    ItemID INT PRIMARY KEY,
    Title VARCHAR(255),
    Price DECIMAL(10, 2)
);

CREATE TABLE BookIsAnItem (
    ISBN VARCHAR(13) PRIMARY KEY,
    ItemID INT,
    FOREIGN KEY (ItemID) REFERENCES Item(ItemID),
    foreign key (ISBN) references Book(ISBN)
);

CREATE TABLE MusicCassette (
    MusicCassetteID INT PRIMARY KEY,
    ItemID INT,
    Format ENUM('Cassette') NOT NULL,
    FOREIGN KEY (ItemID) REFERENCES Item(ItemID)
);

CREATE TABLE CompactDisc (
    CompactDiscID INT PRIMARY KEY,
    ItemID INT,
    Format ENUM('CD') NOT NULL,
    FOREIGN KEY (ItemID) REFERENCES Item(ItemID)
);

CREATE TABLE Basket (
    BasketID INT PRIMARY KEY,
    CustomerID INT,
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
);

CREATE TABLE Contains (
    BasketID INT,
    ItemID INT,
    FOREIGN KEY (BasketID) REFERENCES Basket(BasketID),
    FOREIGN KEY (ItemID) REFERENCES Item(ItemID)
);

CREATE TABLE Stock (
    WarehouseID INT,
    ItemID INT,
    ItemType ENUM('Book', 'MusicCassette', 'CompactDisc') NOT NULL,
    StockCount INT,
    PRIMARY KEY (WarehouseID, ItemID, ItemType),
    FOREIGN KEY (WarehouseID) REFERENCES Warehouse(WarehouseID),
    FOREIGN KEY (ItemID) REFERENCES Item(ItemID)
);

CREATE TABLE Warehouse (
    WarehouseID INT PRIMARY KEY,
    WarehouseName VARCHAR(255),
    Location VARCHAR(255)
);

CREATE TABLE paymentMethod(
	paymentMethodId int primary key auto_increment,
    PaymentMethodName varchar(255),
    CustomerId int,
    result varchar(255)
);

ALTER TABLE Paymentmethod
ADD CONSTRAINT FK_Order_payment FOREIGN KEY (customerId) REFERENCES customer(customerId);

alter table contains add orderId int primary key;
ALTER TABLE contains
ADD CONSTRAINT FK_Order_Contains FOREIGN KEY (OrderID) REFERENCES Orders(OrderID);

ALTER TABLE Contains
ADD CONSTRAINT FK_Contains_Item FOREIGN KEY (ItemID) REFERENCES Item(ItemID);

ALTER TABLE Stock
ADD CONSTRAINT FK_Stock_Warehouse FOREIGN KEY (WarehouseID) REFERENCES Warehouse(WarehouseID);

ALTER TABLE Stock CONSTRAINT FK_Stock_Item FOREIGN KEY (ItemID) REFERENCES Item(ItemID);