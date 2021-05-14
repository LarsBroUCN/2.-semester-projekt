use dmab0920_1086231









--insert into Productgroups (groupname, groupWarningPeriod) values ('Kød', 12)
--insert into Productgroups (groupname, groupWarningPeriod) values ('Kolonial', 12)
--insert into Productgroups (groupname, groupWarningPeriod) values ('husholdning', 12)
--insert into Productgroups (groupname, groupWarningPeriod) values ('frugt & grønt', 12)
--insert into Productgroups (groupname, groupWarningPeriod) values ('Grovvarer', 12)
--insert into Productgroups (groupname, groupWarningPeriod) values ('Tekstil & sko', 12)
--insert into Productgroups (groupname, groupWarningPeriod) values ('Bolig & fritid', 12)
--insert into Productgroups (groupname, groupWarningPeriod) values ('Brød, bageri & mejeri', 12)
--insert into products (barcode, productName, productWarningperiod, price, groupname_fk ) values (11111, 'fisk', 12, 25, 'Kød')
--insert into products (barcode, productName, productWarningperiod, price, groupname_fk ) values (22222, 'flåede tomater', 12, 5, 'Kolonial')
--insert into products (barcode, productName, productWarningperiod, price, groupname_fk ) values (33333, 'Dyremad og tilbehør', 12, 49, 'husholdning')
--insert into products (barcode, productName, productWarningperiod, price, groupname_fk ) values (44444, 'Blomster', 12, 15, 'frugt & grønt')
--insert into products (barcode, productName, productWarningperiod, price, groupname_fk ) values (55555, 'korn,foderstoffer', 12, 50, 'Grovvarer')
--insert into products (barcode, productName, productWarningperiod, price, groupname_fk ) values (66666, 'Dame', 12, 99, 'Tekstil & sko')
--insert into products (barcode, productName, productWarningperiod, price, groupname_fk ) values (77777, 'Hus og Have', 12, 300, 'Bolig & fritid')
--insert into products (barcode, productName, productWarningperiod, price, groupname_fk ) values (88888, 'Ost', 12, 59, 'Brød, bageri & mejeri')
--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('2021/05/13','2021/06/01',  12, 11111) --burde ikke lave en notifikation
--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('2021/05/13','2021/06/01',  12, 44444)  --burde ikke lave en notifikation
--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('2021/05/13','2021/05/24',  12, 22222)  --burde lave en notifikation og sætte status til pending
--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('2021/05/13','2021/05/24',  12, 55555)	--burde lave en notifikation og sætte status til pending
--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('2021/05/13','2021/05/20',  12, 66666)	--sættes til discount 
--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('2021/05/13','2021/05/24',  12, 77777)	--sættes til complete 
--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('2021/05/13','2021/05/14',  12, 33333)	--sættes til discard 
--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('2021/05/13','2021/05/24',  12, 88888)	--sættes  til pending
--yyyy-mm-dd

--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'DISCOUNT', 5)
--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'COMPLETE', 6)
--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'DISCARD', 7)
--insert into notifications (discount, note, status, batchID_fk) values (25, '', 'PENDING', 8)

--insert into notifications (discount, note, status, batchID_fk) values (25, '', 'PENDING', 8)
--insert into notifications (discount, note, status, batchID_fk) values (10, '', 'PENDING', 1)
--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'PENDING', 3)
--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'PENDING', 5)
--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'DISCOUNT', 5)
--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'COMPLETE', 6)
--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'DISCARD', 7)
--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'EXPIRED', 4)

 -- update notifications set discount = 30, note = '' , status = 'expired'  where batchid_fk = 5


 -- select notifications.batchid_fk, notifications.status from notifications
 --inner join Batches on batches.batchid = Notifications.batchID_fk where notifications.status = 'discount'

 --  select notifications.batchid_fk, notifications.status from notifications
 --inner join Batches on batches.batchid = Notifications.batchID_fk where notifications.status = 'pending'

 -- select notifications.batchid_fk, notifications.status from notifications
 --inner join Batches on batches.batchid = Notifications.batchID_fk where notifications.status = 'complete'

 -- select notifications.batchid_fk, notifications.status from notifications
 --inner join Batches on batches.batchid = Notifications.batchID_fk where notifications.status = 'discard'

 --  select notifications.batchid_fk, notifications.status from notifications
 --inner join Batches on batches.batchid = Notifications.batchID_fk where notifications.status = 'expired'

-- select batches.batchID where not.ba
 --select * from batches where batches.batchID  in (select * from notifications where Notifications.batchID_fk =batches.batchID ) 
--select notifications.batchid_fk, notifications.status, batches.batchID, batches.arrivaldate, 
--				batches.warningperiod, batches.expirationdate, batches.barcode_fk from notifications
--				inner join Batches on batches.batchid = Notifications.batchID_fk where notifications.status = 'PENDING'

--select notifications.batchid_fk, notifications.status, batches.batchID, batches.arrivaldate, 
--			 batches.warningperiod, batches.expirationdate, batches.barcode_fk from notifications
--			 inner join Batches on batches.batchid = Notifications.batchID_fk where notifications.status = 'EXPIRED'

--select Products.barcode, Products.productName, Products.productWarningperiod, Products.price, Products.groupname_fk from Products
--inner join batches on batches.barcode_fk = Products.barcode

--select * from batches where barcode_fk = 122121

--update batches set arrivaldate =?, expirationdate=?, warningperiod=?, barcode_fk=? where batchID=4
 select * from Productgroups
 select * from products
 select * from batches
 select * from notifications
 select * from batchsalespot
 select * from salespot
 select * from nodes
 select * from edges

 --select * from Products where Products.barcode in (select * from batches where Batches.barcode_fk) 

 --finder de batches som ikke er knyttet til notifikationer--
 --select * from batches where batches.batchID not in (select Notifications.batchID_fk from notifications)



--drop table BatchSaleSpot
--drop table Salespot
--drop table Edges
--drop table Nodes
--drop table Notifications
--drop table Batches
--drop table Products
--drop table Productgroups



 -- create table Productgroups(
 --   groupname varchar(64) primary key,
 --   groupWarningPeriod int    
 --)

 --create table Products (
 --    barcode varchar(64) primary key,
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
	--barcode_fk varchar(64) not null,
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

