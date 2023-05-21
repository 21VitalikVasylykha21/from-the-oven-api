INSERT INTO ingredient (name, description, image)
VALUES ('Tomatoes', 'Fresh, ripe tomatoes', 'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/ingredients/tomatoes.png'),
       ('Mushrooms', 'Sliced mushrooms', 'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/ingredients/Mushrooms.png'),
       ('Pepperoni', 'Spicy Italian sausage',
        'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/ingredients/Pepperoni.png'),
       ('Green Peppers', 'Fresh, green bell peppers',
        'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/ingredients/Green-Peppers.png'),
       ('Onions', 'Sweet, sliced onions', 'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/ingredients/Onions.png'),
       ('Black Olives', 'Sliced black olives',
        'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/ingredients/Black-Olives.png'),
       ('Garlic', 'Minced garlic', 'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/ingredients/Garlic.png'),
       ('Italian Sausage', 'Ground Italian sausage',
        'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/ingredients/Italian-Sausage.png'),
       ('Bacon', 'Crispy bacon pieces', 'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/ingredients/Bacon.png'),
       ('Pineapple', 'Juicy pineapple chunks',
        'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/ingredients/Pepperoni.png'),
       ('Ham', 'Sliced ham', 'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/ingredients/Ham.png'),
       ('Jalapenos', 'Spicy jalapeno peppers',
        'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/ingredients/Jalapenos.png'),
       ('Artichokes', 'Marinated artichoke hearts',
        'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/ingredients/Artichokes.png'),
       ('Feta Cheese', 'Crumbed feta cheese',
        'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/ingredients/Feta-Cheese.png'),
       ('Anchovies', 'Salty anchovy fillets',
        'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/ingredients/Anchovies.png'),
       ('Basil', 'Fresh basil leaves', 'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/ingredients/Basil.png'),
       ('Spinach', 'Fresh spinach leaves', 'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/ingredients/Spinach.png'),
       ('Chicken', 'Grilled chicken pieces', 'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/ingredients/Chicken.png'),
       ('Ground Beef', 'Seasoned ground beef',
        'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/ingredients/Ground-Beef.pngg'),
       ('Ricotta Cheese', 'Creamy ricotta cheese',
        'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/ingredients/Ricotta-Cheese.png')
ON CONFLICT DO NOTHING;

INSERT INTO category (name)
VALUES ('Meat Lovers'),
       ('Vegetarian'),
       ('Hawaiian'),
       ('Margherita'),
       ('BBQ Chicken'),
       ('Seafood'),
       ('Cheese'),
       ('Vegan'),
       ('Gluten-Free'),
       ('Spicy')
ON CONFLICT DO NOTHING;

INSERT INTO size (name, size_cm)
VALUES ('Small', 25),
       ('Large', 45)
ON CONFLICT DO NOTHING;

INSERT INTO pizza (name, image, description, rating)
VALUES ('Margherita', 'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/pizzas/Margherita.jpg',
        'A classic pizza topped with tomato sauce, mozzarella cheese, and fresh basil.', 2),
       ('Pepperoni', 'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/pizzas/Pepperoni.png',
        'A delicious pizza topped with tomato sauce, mozzarella cheese, and spicy pepperoni slices.', 2),
       ('Hawaiian', 'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/pizzas/Hawaiian.png',
        'A tropical pizza topped with tomato sauce, mozzarella cheese, ham, and pineapple.', 3),
       ('Meat Lovers', 'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/pizzas/Meat-Lovers.png',
        'A hearty pizza loaded with tomato sauce, mozzarella cheese, pepperoni, sausage, bacon, and ground beef.', 3),
       ('Veggie', 'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/pizzas/Veggie.png',
        'A healthy pizza topped with tomato sauce, mozzarella cheese, mushrooms, onions, bell peppers, and olives.', 4),
       ('Supreme', 'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/pizzas/Supreme.png',
        'A loaded pizza topped with tomato sauce, mozzarella cheese, pepperoni, sausage, mushrooms, onions, bell peppers, and black olives.',
        4),
       ('BBQ Chicken', 'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/pizzas/BBQ-Chicken.png',
        'A sweet and tangy pizza topped with BBQ sauce, mozzarella cheese, chicken, and red onions.', 5),
       ('Buffalo Chicken', 'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/pizzas/Buffalo-Chicken.png',
        'A spicy pizza topped with buffalo sauce, mozzarella cheese, chicken, and blue cheese.', 5),
       ('Margarita', 'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/pizzas/Margarita.png',
        'A refreshing pizza topped with tomato sauce, fresh mozzarella, and fresh basil.', 2),
       ('Four Cheese', 'https://artgallery-bucket.s3.eu-central-1.amazonaws.com/pizzas/Four-Cheese.png',
        'A cheesy pizza topped with tomato sauce, mozzarella, gouda, cheddar, and parmesan cheeses.', 3)
ON CONFLICT DO NOTHING;

INSERT INTO pizza_category (pizza_id, category_id)
VALUES ((SELECT pizza_id FROM pizza WHERE name = 'Margherita'),
        (SELECT category_id FROM category WHERE name = 'Margherita')),
       ((SELECT pizza_id FROM pizza WHERE name = 'Margherita'),
        (SELECT category_id FROM category WHERE name = 'Vegetarian')),
       ((SELECT pizza_id FROM pizza WHERE name = 'Pepperoni'),
        (SELECT category_id FROM category WHERE name = 'Meat Lovers')),
       ((SELECT pizza_id FROM pizza WHERE name = 'Hawaiian'),
        (SELECT category_id FROM category WHERE name = 'Hawaiian')),
       ((SELECT pizza_id FROM pizza WHERE name = 'Meat Lovers'),
        (SELECT category_id FROM category WHERE name = 'Meat Lovers')),
       ((SELECT pizza_id FROM pizza WHERE name = 'Veggie'),
        (SELECT category_id FROM category WHERE name = 'Vegetarian')),
       ((SELECT pizza_id FROM pizza WHERE name = 'Supreme'),
        (SELECT category_id FROM category WHERE name = 'Meat Lovers')),
       ((SELECT pizza_id FROM pizza WHERE name = 'Supreme'), (SELECT category_id FROM category WHERE name = 'Spicy')),
       ((SELECT pizza_id FROM pizza WHERE name = 'BBQ Chicken'),
        (SELECT category_id FROM category WHERE name = 'BBQ Chicken')),
       ((SELECT pizza_id FROM pizza WHERE name = 'Buffalo Chicken'),
        (SELECT category_id FROM category WHERE name = 'Spicy')),
       ((SELECT pizza_id FROM pizza WHERE name = 'Four Cheese'),
        (SELECT category_id FROM category WHERE name = 'Cheese'))
ON CONFLICT DO NOTHING;

INSERT INTO pizza_price (pizza_id, size_id, price, mass)
SELECT pizza.pizza_id,
       size.size_id,
       ROUND(CAST(size.size_id * (RANDOM() * (20 - 10) + 10) AS NUMERIC), 2),
       ROUND(CAST(size.size_id * (RANDOM() * (500 - 400) + 400) AS NUMERIC), 0)
FROM pizza
         CROSS JOIN size
ON CONFLICT DO NOTHING;

INSERT INTO pizza_ingredient (pizza_id, ingredient_id)
SELECT p.pizza_id,
       i.ingredient_id
FROM pizza p
         CROSS JOIN ingredient i
WHERE p.name = 'Margherita' AND i.name IN ('Tomatoes', 'Mozzarella', 'Basil')
   OR p.name = 'Pepperoni' AND i.name IN ('Tomatoes', 'Mozzarella', 'Pepperoni')
   OR p.name = 'Hawaiian' AND i.name IN ('Tomatoes', 'Mozzarella', 'Ham', 'Pineapple')
   OR p.name = 'Meat Lovers' AND
      i.name IN ('Tomatoes', 'Mozzarella', 'Pepperoni', 'Italian Sausage', 'Bacon', 'Ground Beef')
   OR p.name = 'Veggie' AND i.name IN ('Tomatoes', 'Mozzarella', 'Mushrooms', 'Green Peppers', 'Onions', 'Black Olives')
   OR p.name = 'Supreme' AND i.name IN
                             ('Tomatoes', 'Mozzarella', 'Pepperoni', 'Italian Sausage', 'Mushrooms', 'Green Peppers',
                              'Onions', 'Black Olives')
   OR p.name = 'BBQ Chicken' AND i.name IN ('BBQ Sauce', 'Mozzarella', 'Chicken', 'Red Onions')
   OR p.name = 'Buffalo Chicken' AND i.name IN ('Buffalo Sauce', 'Mozzarella', 'Chicken', 'Blue Cheese')
   OR p.name = 'Four Cheese' AND i.name IN ('Tomatoes', 'Mozzarella', 'Gouda', 'Cheddar', 'Parmesan')
ON CONFLICT DO NOTHING;


INSERT INTO pizza_order (order_date, total_amount, customer_name, customer_telephone, delivery_address)
SELECT NOW() - INTERVAL '1 day' * (random() * 30),
       (random() * 50 + 10),
       'Customer ' || generate_series,
       'Telephone ' || generate_series,
       CONCAT(
               CAST((random() * 999) + 1 AS INT), ' ',
               (SELECT unnest(ARRAY [
                   'Main Street',
                   'Park Avenue',
                   'Elm Street',
                   'Maple Avenue',
                   'Oak Street'
                   ])
                LIMIT 1),
               ', ',
               (SELECT unnest(ARRAY [
                   'New York',
                   'Los Angeles',
                   'Chicago',
                   'Houston',
                   'Philadelphia'
                   ])
                LIMIT 1)
           ) AS random_address
FROM generate_series(1, 10)
ON CONFLICT DO NOTHING;

DO $$
    BEGIN
        FOR i IN 1..10 LOOP
                INSERT INTO pizza_order_info (pizza_order_id, pizza_price_id, pizza_count)
                SELECT (SELECT pizza_order_id FROM pizza_order WHERE pizza_order_id = (SELECT FLOOR(random() * 10) + 1)),
                       (SELECT pizza_price_id FROM pizza_price WHERE pizza_price_id = (SELECT FLOOR(random() * 20) + 1)),
                       FLOOR(random() * 5) + 1 AS random_number
                ON CONFLICT DO NOTHING;
        END LOOP;
    END
$$;

INSERT INTO admin_user (username, password, email, is_admin)
VALUES ('admin', 'admin', 'admin@example.com', true);

INSERT INTO contact_us (name, email, message)
VALUES
    ('John Smith', 'johnsmith@example.com', 'Hi, I would like to know if you deliver to my area. I live in downtown.'),
    ('Sarah Johnson', 'sarahjohnson@example.com', 'I ordered a pizza from your restaurant yesterday, and I must say it was delicious! The crust was perfectly crispy, and the toppings were fresh. Keep up the great work!'),
    ('Mike Thompson', 'mikethompson@example.com', 'I ordered a Margherita pizza, but it came with mushrooms on top. I specifically requested no mushrooms. Please ensure such mistakes dont happen in the future.'),
    ('Emily Davis', 'emilydavis@example.com', 'Im a regular customer, and I absolutely love your pizza. I have a suggestion for a new flavor combination – how about a BBQ chicken pizza with caramelized onions and bacon? I think it would be a hit!'),
    ('Alexandra Lee', 'alexandralee@example.com', 'Im a vegetarian, and I wanted to inquire about the availability of vegetarian pizza options on your menu. Could you please provide more details?');