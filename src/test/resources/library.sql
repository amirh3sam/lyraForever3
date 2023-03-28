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
select count(*)
from book_borrow
where is_returned = 0;

-- US06

SELECT books.name, isbn, year, author, bc.name
from books
         join book_categories bc
              on books.book_category_id = bc.id
where books.name = 'Lyra Forever'and isbn='20230423' and year=2023 and author='Joe Sky' and bc.name='Horror';
