use dmab0920_1086231

--drop table Productgroups
--drop table Products
--drop table Batches
--drop table Notifications
--drop table Nodes
--drop table Salespot
--drop table BatchSaleSpot
--drop table Edges

 --create table Productgroups(
 --   groupname varchar(64) primary key,
 --   groupWarningPeriod int    
 --)


 --create table Products (
 --    barcode int primary key,
 --    productName varchar(64) not null,
 --    productWarningperiod int,
 --    price float not null,
 --    groupname_fk VARCHAR(64),
 --    foreign key (groupname_fk) references Productgroups(groupname)
 --)





 --create table Batches(
	--batchID int primary key identity(1,1),
	--arrivaldate date not null,
	--expirationdate date not null,
	--warningperiod int not null,
	--barcode_fk int not null,
	--foreign key (barcode_fk) references Products(barcode)
 --)


 --create table Notifications(
	--notificationID int primary key identity(1,1),
	--discount float,
	--note varchar(300),
	--status varchar(64) not null,
	--batchID_fk int not null,
	--foreign key (batchID_fk) references Batches(batchID) 
 --)


 --create table Nodes(
	--nodeName varchar(200) primary key 
 --)

 
 --create table Salespot(
	--locationID int primary key,
	--nodename_fk varchar(200) not null,
	--foreign key (nodename_fk) references Nodes(nodeName) 
 --)

 --create table BatchSaleSpot(
	--locationID_fk int not null,
	--batchID_fk int not null,
	--primary key (locationID_fk,	batchID_fk),
	--foreign key (locationID_fk) references Salespot(locationID), 
	--foreign key (batchID_fk) references Batches(batchID) 
 --)

 --create table Edges(
	--distance int primary key,
	--nodename1_fk varchar(200) not null,
	--nodename2_fk varchar(200) not null,
	--foreign key (nodename1_fk) references Nodes(nodeName),
	--foreign key (nodename2_fk) references Nodes(nodeName)
	
 --)

 select * from Productgroups
 select * from products
 select * from batches
 select * from notifications
 select * from batchsalespot
 select * from salespot
 select * from nodes
 select * from edges