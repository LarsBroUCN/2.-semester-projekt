use dmab0920_1086231



create table Productgroups(
    groupname varchar(64) primary key,
    groupWarningPeriod int  
 )

 create table Products (
     barcode varchar(64)  primary key,
     productName varchar(64) not null,
     productWarningperiod int,
     price float not null,
     groupname_fk VARCHAR(64),
     foreign key (groupname_fk) references Productgroups(groupname)
 )

 create table Batches(
	batchID int primary key identity(1,1),
	arrivaldate date not null,
	expirationdate date not null,
	warningperiod int not null,
	barcode_fk varchar(64) not null,
	foreign key (barcode_fk) references Products(barcode)
 )


 create table Notifications(
	notificationID int primary key identity(1,1),
	discount float,
	note varchar(300),
<<<<<<< HEAD
	status varchar(200) not null check(status IN ('Pending','Discount','Expired','Discard','Complete')),
=======
	status varchar(200) not null check(status IN ('PENDING','DISCOUNT','EXPIRED','DISCARD','COMPLETE')),
>>>>>>> c6bd0a4a945583b43a78a6786a5537e60f30f81a
	batchID_fk int unique not null,
	foreign key (batchID_fk) references Batches(batchID) 
 )


 create table Nodes(
	nodeName varchar(200) primary key 
 )

 
 create table Salespot(
	locationID int primary key identity(1,1),
	nodename_fk varchar(200) not null,
	foreign key (nodename_fk) references Nodes(nodeName) 
 )

 create table BatchSaleSpot(
	locationID_fk int unique not null,
	batchID_fk int unique not null,
	primary key (locationID_fk,	batchID_fk),
	foreign key (locationID_fk) references Salespot(locationID), 
	foreign key (batchID_fk) references Batches(batchID) 
 )

 create table Edges(
	distance float primary key,
	nodename1_fk varchar(200) not null,
	nodename2_fk varchar(200) not null,
	foreign key (nodename1_fk) references Nodes(nodeName),
	foreign key (nodename2_fk) references Nodes(nodeName)	
 )