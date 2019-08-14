SELECT * FROM game_store.processing_fee;
use game_storet;

insert into processing_fee (product_type, fee) values ('Consoles', '14.99');
insert into processing_fee (product_type, fee) values ('T-Shirts', '1.98');
insert into processing_fee (product_type, fee) values ('Games', '1.49');
select * from processing_fee;