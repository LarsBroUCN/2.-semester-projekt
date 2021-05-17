use dmab0920_1086231


 select * from Productgroups
 select * from products
 select * from batches
 select * from notifications
 select * from batchsalespot
 select * from salespot
 select * from nodes
 select * from edges




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


 --select * from Products where Products.barcode in (select * from batches where Batches.barcode_fk) 

 --finder de batches som ikke er knyttet til notifikationer--
 --select * from batches where batches.batchID not in (select Notifications.batchID_fk from notifications)




 --select notifications.batchid_fk, notifications.status, batches.batchID, batches.arrivaldate,  batches.warningperiod, batches.expirationdate, batches.barcode_fk from notifications
	--		inner join Batches on batches.batchid = Notifications.batchID_fk where notifications.status = 'PENDING'

