-- US 01
select count(id)
from users;
--
-- 1855

select count(distinct id)
from users;
-- 1855


-- RESULT --> MANUALLY IT IS PASSED


-- US 02
select *
from users;


-- US 03
select * from book_borrow
join book_categories ;


select bc.name,count(*) from book_borrow bb
                                 inner  join books b on bb.book_id = b.id
                                 inner join book_categories bc on b.book_category_id=bc.id
group by name
order by 2 desc;


-- US06

SELECT books.name, isbn, year, author, bc.name
from books
         join book_categories bc
              on books.book_category_id = bc.id
where books.name = 'Lyra Forever'and isbn='20230423' and year=2023 and author='Joe Sky' and bc.name='Horror';


-- US07

select full_name,b.name,bb.borrowed_date from users u
inner join book_borrow bb on u.id = bb.user_id
inner join books b on bb.book_id = b.id
where full_name='Test Student 5'
order by 3 desc;



