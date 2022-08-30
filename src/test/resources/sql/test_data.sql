insert into users(id, first_name, last_name, email) values
    (1, 'Taras', 'Shevchenko', 'taras.shevchenko@gmail.com'),
    (2, 'Vasyl', 'Stus', 'vasyl.stus@gmail.com'),
    (3, 'Pylyp', 'Orlyk', 'pylyp.orlyk@gmail.com');

insert into shopping_cart (id, user_id) values
    (1, 1),
    (2, 2),
    (3, 3);

insert into product(id, name, price_per_unit, quantity, shopping_cart_id) values
    (1, 'Tea', 5.0, 2, 1),
    (2, 'Coffee', 6.5, 1, 1),
    (3, 'Tea', 5.0, 5, 3),
    (4, 'Coffee', 3.5, 3, 3);