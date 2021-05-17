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
--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('2021/05/14','2021/06/01',  12, 11111) --burde ikke lave en notifikation                            -- virker korrekt
--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('2021/05/14','2021/05/20',  12, 22222)  --burde lave en notifikation og sætte status til pending    -- virker korrekt
--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('2021/05/13','2021/05/12',  12, 44444)	--burde sætte sig selv til expired                          -- virker korrekt
--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('2021/05/13','2021/05/20',  12, 66666)	--sættes til discount 
--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('2021/05/13','2021/05/24',  12, 77777)	--sættes til complete 
--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('2021/05/13','2021/05/14',  12, 33333)	--sættes til discard 


--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'DISCOUNT', 3)
--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'COMPLETE', 4)
--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'DISCARD', 5)










--yyyy-mm-dd
--Ikke i brug

--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('2021/05/13','2021/06/01',  12, 44444)  --burde ikke lave en notifikation
--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('2021/05/13','2021/05/24',  12, 55555)	--burde lave en notifikation og sætte status til pending
--insert into batches (arrivaldate, expirationdate, warningperiod, barcode_fk ) values ('2021/05/13','2021/05/24',  12, 88888)	--sættes  til pending


--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'DISCOUNT', 3)
--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'COMPLETE', 4)
--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'DISCARD', 5)
--insert into notifications (discount, note, status, batchID_fk) values (25, '', 'PENDING', 8)

--insert into notifications (discount, note, status, batchID_fk) values (25, '', 'PENDING', 8)
--insert into notifications (discount, note, status, batchID_fk) values (10, '', 'PENDING', 1)
--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'PENDING', 3)
--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'PENDING', 5)
--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'DISCOUNT', 5)
--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'COMPLETE', 6)
--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'DISCARD', 7)
--insert into notifications (discount, note, status, batchID_fk) values (5, '', 'EXPIRED', 4)




