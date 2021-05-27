use dmab0920_1086231


 select * from Productgroups
 select * from products
 select * from batches
 select * from notifications
 select * from batchsalespot
 select * from salespot
 select * from nodes
 select * from edges
  

--BatchDB 
--FINDSTATUSQ
--select notifications.batchid_fk, notifications.status, batches.batchID, batches.arrivaldate, batches.warningperiod, batches.expirationdate, batches.barcode_fk from notifications
--			inner join Batches on batches.batchid = Notifications.batchID_fk where notifications.status = '?'
--SEARCH_BATCH_Q
--select * from batches where BatchID = 1
--UPDATE_BATCH_Q 
--update batches set arrivaldate =?, expirationdate =?, warningperiod =?, barcode_fk =? where batchID =?
--FIND_ALL_NOT_NOTIFICATION
--select * from batches where batches.batchID not in (select Notifications.batchID_fk from notifications)


--NotificationDB
--FINDSTATEQ
--select * from notifications where status =?
--UPDATEQ
--update notifications set discount =?, note =?, status=? where batchID_fk =?
--FINDBYBATCHFKQ
--select * from notifications where batchID_fk =?
--INSERTQ
--insert into notifications (discount, note, status, batchID_fk) values (?, ?, ?, ?)

--ProductDB
--FINDBARCODEQ
--select * from products where barcode =?