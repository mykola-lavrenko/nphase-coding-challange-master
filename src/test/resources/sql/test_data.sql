insert into users(id, first_name, last_name, email) values
    (1, 'Taras', 'Shevchenko', 'taras.shevchenko@gmail.com'),
    (2, 'Vasyl', 'Stus', 'vasyl.stus@gmail.com');

insert into shopping_cart (id, user_id) values
    (1, 1),
    (2, 2);

insert into product(id, name, price_per_unit, quantity, shopping_cart_id) values
    (1, 'Tea', 5.0, 2, 1),
    (2, 'Coffee', 6.5, 1, 1);