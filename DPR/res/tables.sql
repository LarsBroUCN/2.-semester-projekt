use dmab0920_1086231

--drop table Productgroups
--drop table Products
--drop table Batches
--drop table Notifications
--drop table Nodes
--drop table Salespot
--drop table BatchSaleSpot
--drop table Edges


--insert into Productgroups (groupname, groupWarningPeriod) values ('Kød', 12)
--insert into Productgroups (groupname, groupWarningPeriod) values ('Kolonial', 12)
--insert into Productgroups (groupname, groupWarningPeriod) values ('husholdning', 12)
--insert into Productgroups (groupname, groupWarningPeriod) values ('frugt & grønt', 12)
--insert into Productgroups (groupname, groupWarningPeriod) values ('Grovvarer', 12)
--insert into Productgroups (groupname, groupWarningPeriod) values ('Tekstil & sko', 12)
--insert into Productgroups (groupname, groupWarningPeriod) values ('Bolig & fritid', 12)
--insert into Productgroups (groupname, groupWarningPeriod) values ('Brød, bageri & mejeri', 12)
--insert into products (barcode, productName, productWarningperiod, price, groupname_fk ) values (122121, 'fisk', 12, 25, 'kød')
--insert into products (barcode, productName, productWarningperiod, price, groupname_fk ) values (11111, 'flåede tomater', 12, 25, 'Kolonial')
--insert into products (barcode, productName, productWarningperiod, price, groupname_fk ) values (22222, 'Helsekost', 12, 25, 'husholdning')
--insert into products (barcode, productName, productWarningperiod, price, groupname_fk ) values (33333, 'Helsekost', 12, 15, 'frugt & grønt')
--insert into products (barcode, productName, productWarningperiod, price, groupname_fk ) values (44444, 'korn,foderstoffer', 12, 50, 'Grovvarer')
--insert into products (barcode, productName, productWarningperiod, price, groupname_fk ) values (55555, 'Dame', 12, 50, 'Tekstil & sko')
--insert into products (barcode, productName, productWarningperiod, price, groupname_fk ) values (66666, 'Hus og Have', 12, 300, 'Bolig & fritid')
--insert into products (barcode, productName, productWarningperiod, price, groupname_fk ) values (77777, 'Hus og Have', 12, 10, 'Brød, bageri & mejeri')
--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('10/05/2021','10/05/2021',  12, 122121)
--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('10/05/2021','10/05/2021',  12, 11111)
--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('10/05/2021','10/05/2021',  12, 22222)
--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('10/05/2021','10/05/2021',  12, 33333)
--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('10/05/2021','10/05/2021',  12, 44444)
--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('10/05/2021','10/05/2021',  12, 55555)
--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('10/05/2021','10/05/2021',  12, 66666)
--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('10/05/2021','10/05/2021',  12, 77777)
--insert into notifications (discount, note, status, batchID_fk) values (25, '', 'pending', 1 )
--insert into notifications (discount, note, status, batchID_fk) values (10, '', 'pending', 4)
--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'pending', 5)
--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'pending', 6)
--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'discount', 7)
--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'complete', 8)
--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'discard', 9)
--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'expired', 10)

 -- update notifications set discount = 30, note = '' , status = 'expired'  where batchid_fk = 5


  select notifications.batchid_fk, notifications.status from notifications
 inner join Batches on batches.batchid = Notifications.batchID_fk where notifications.status = 'discount'

   select notifications.batchid_fk, notifications.status from notifications
 inner join Batches on batches.batchid = Notifications.batchID_fk where notifications.status = 'pending'

  select notifications.batchid_fk, notifications.status from notifications
 inner join Batches on batches.batchid = Notifications.batchID_fk where notifications.status = 'complete'

  select notifications.batchid_fk, notifications.status from notifications
 inner join Batches on batches.batchid = Notifications.batchID_fk where notifications.status = 'discard'

   select notifications.batchid_fk, notifications.status from notifications
 inner join Batches on batches.batchid = Notifications.batchID_fk where notifications.status = 'expired'

 select * from Productgroups
 select * from products
 select * from batches
 select * from notifications
 select * from batchsalespot
 select * from salespot
 select * from nodes
 select * from edges




 -- create table Productgroups(
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
	--status varchar(200) not null check(status IN ('Pending','Discount','Expired','Discard','Complete')),
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

