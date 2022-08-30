insert into users(id, first_name, last_name, email) values
    (1, 'Taras', 'Shevchenko', 'taras.shevchenko@gmail.com'),
    (2, 'Vasyl', 'Stus', 'vasyl.stus@gmail.com'),
    (3, 'Pylyp', 'Orlyk', 'pylyp.orlyk@gmail.com'),
    (4, 'Borys', 'Paton', 'borys.paton@gmail.com');

insert into shopping_cart (id, user_id) values
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4);

insert into product(id, name, category, price_per_unit, quantity, shopping_cart_id) values
    (1, 'Tea', 'drinks', 5.0, 2, 1),
    (2, 'Coffee', 'drinks', 6.5, 1, 1),
    (3, 'Tea', 'drinks', 5.0, 5, 3),
    (4, 'Coffee', 'drinks', 3.5, 3, 3),
    (5, 'Tea', 'drinks', 5.3, 2, 4),
    (6, 'Coffee', 'drinks', 3.5, 2, 4),
    (7, 'Cheese', 'food', 8, 2, 4);