INSERT INTO ingredient (name, description)
VALUES ('Tomatoes', 'Fresh, ripe tomatoes'),
       ('Mushrooms', 'Sliced mushrooms'),
       ('Pepperoni', 'Spicy Italian sausage'),
       ('Green Peppers', 'Fresh, green bell peppers'),
       ('Onions', 'Sweet, sliced onions'),
       ('Black Olives', 'Sliced black olives'),
       ('Garlic', 'Minced garlic'),
       ('Italian Sausage', 'Ground Italian sausage'),
       ('Bacon', 'Crispy bacon pieces'),
       ('Pineapple', 'Juicy pineapple chunks'),
       ('Ham', 'Sliced ham'),
       ('Jalapenos', 'Spicy jalapeno peppers'),
       ('Artichokes', 'Marinated artichoke hearts'),
       ('Feta Cheese', 'Crumbed feta cheese'),
       ('Anchovies', 'Salty anchovy fillets'),
       ('Basil', 'Fresh basil leaves'),
       ('Spinach', 'Fresh spinach leaves'),
       ('Chicken', 'Grilled chicken pieces'),
       ('Ground Beef', 'Seasoned ground beef'),
       ('Ricotta Cheese', 'Creamy ricotta cheese')
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
       ('Medium', 35),
       ('Large' , 45)
ON CONFLICT DO NOTHING;

INSERT INTO pizza (name, image, description)
VALUES
  ('Margherita', 'margherita.jpg', 'A classic pizza topped with tomato sauce, mozzarella cheese, and fresh basil.'),
  ('Pepperoni', 'pepperoni.jpg', 'A delicious pizza topped with tomato sauce, mozzarella cheese, and spicy pepperoni slices.'),
  ('Hawaiian', 'hawaiian.jpg', 'A tropical pizza topped with tomato sauce, mozzarella cheese, ham, and pineapple.'),
  ('Meat Lovers', 'meatlovers.jpg', 'A hearty pizza loaded with tomato sauce, mozzarella cheese, pepperoni, sausage, bacon, and ground beef.'),
  ('Veggie', 'veggie.jpg', 'A healthy pizza topped with tomato sauce, mozzarella cheese, mushrooms, onions, bell peppers, and olives.'),
  ('Supreme', 'supreme.jpg', 'A loaded pizza topped with tomato sauce, mozzarella cheese, pepperoni, sausage, mushrooms, onions, bell peppers, and black olives.'),
  ('BBQ Chicken', 'bbqchicken.jpg', 'A sweet and tangy pizza topped with BBQ sauce, mozzarella cheese, chicken, and red onions.'),
  ('Buffalo Chicken', 'buffalochicken.jpg', 'A spicy pizza topped with buffalo sauce, mozzarella cheese, chicken, and blue cheese.'),
  ('Margarita', 'margarita.jpg', 'A refreshing pizza topped with tomato sauce, fresh mozzarella, and fresh basil.'),
  ('Four Cheese', 'fourcheese.jpg', 'A cheesy pizza topped with tomato sauce, mozzarella, gouda, cheddar, and parmesan cheeses.')
  ON CONFLICT DO NOTHING;

INSERT INTO pizza_category (pizza_id, category_id)
VALUES
    ((SELECT pizza_id FROM pizza WHERE name = 'Margherita'), (SELECT category_id FROM category WHERE name = 'Margherita')),
    ((SELECT pizza_id FROM pizza WHERE name = 'Margherita'), SELECT category_id FROM category WHERE name = 'Vegetarian')),
    ((SELECT pizza_id FROM pizza WHERE name = 'Pepperoni'), (SELECT category_id FROM category WHERE name = 'Meat Lovers')),
    ((SELECT pizza_id FROM pizza WHERE name = 'Hawaiian'), (SELECT category_id FROM category WHERE name = 'Hawaiian')),
    ((SELECT pizza_id FROM pizza WHERE name = 'Meat Lovers'), (SELECT category_id FROM category WHERE name = 'Meat Lovers')),
    ((SELECT pizza_id FROM pizza WHERE name = 'Veggie'), (SELECT category_id FROM category WHERE name = 'Vegetarian')),
    ((SELECT pizza_id FROM pizza WHERE name = 'Supreme'), (SELECT category_id FROM category WHERE name = 'Meat Lovers')),
    ((SELECT pizza_id FROM pizza WHERE name = 'Supreme'), (SELECT category_id FROM category WHERE name = 'Spicy')),
    ((SELECT pizza_id FROM pizza WHERE name = 'BBQ Chicken'), (SELECT category_id FROM category WHERE name = 'BBQ Chicken')),
    ((SELECT pizza_id FROM pizza WHERE name = 'Buffalo Chicken'), (SELECT category_id FROM category WHERE name = 'Spicy')),
    ((SELECT pizza_id FROM pizza WHERE name = 'Four Cheese'), (SELECT category_id FROM category WHERE name = 'Cheese'))
ON CONFLICT DO NOTHING;

INSERT INTO pizza_price (pizza_id, size_id, price)
SELECT
    pizza.pizza_id,
    size.size_id,
    ROUND(CAST(RANDOM() * (20 - 10) + 10 AS NUMERIC), 2)
FROM pizza
         CROSS JOIN size
ON CONFLICT DO NOTHING;

INSERT INTO pizza_ingredient (pizza_id, ingredient_id)
SELECT
    p.pizza_id,
    i.ingredient_id
FROM
    pizza p
    CROSS JOIN ingredient i
WHERE
   p.name = 'Margherita' AND i.name IN ('Tomatoes', 'Mozzarella', 'Basil')
   OR p.name = 'Pepperoni' AND i.name IN ('Tomatoes', 'Mozzarella', 'Pepperoni')
   OR p.name = 'Hawaiian' AND i.name IN ('Tomatoes', 'Mozzarella', 'Ham', 'Pineapple')
   OR p.name = 'Meat Lovers' AND i.name IN ('Tomatoes', 'Mozzarella', 'Pepperoni', 'Italian Sausage', 'Bacon', 'Ground Beef')
   OR p.name = 'Veggie' AND i.name IN ('Tomatoes', 'Mozzarella', 'Mushrooms', 'Green Peppers', 'Onions', 'Black Olives')
   OR p.name = 'Supreme' AND i.name IN ('Tomatoes', 'Mozzarella', 'Pepperoni', 'Italian Sausage', 'Mushrooms', 'Green Peppers', 'Onions', 'Black Olives')
   OR p.name = 'BBQ Chicken' AND i.name IN ('BBQ Sauce', 'Mozzarella', 'Chicken', 'Red Onions')
   OR p.name = 'Buffalo Chicken' AND i.name IN ('Buffalo Sauce', 'Mozzarella', 'Chicken', 'Blue Cheese')
   OR p.name = 'Four Cheese' AND i.name IN ('Tomatoes', 'Mozzarella', 'Gouda', 'Cheddar', 'Parmesan')
   ON CONFLICT DO NOTHING;
