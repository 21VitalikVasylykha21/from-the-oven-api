CREATE
DATABASE from_the_oven;

CREATE TABLE ingredient
(
    ingredient_id SERIAL PRIMARY KEY,
    name          VARCHAR(100) UNIQUE NOT NULL,
    image         VARCHAR(255),
    description   TEXT
);

CREATE TABLE category
(
    category_id SERIAL PRIMARY KEY,
    name        VARCHAR(50) UNIQUE NOT NULL
);


CREATE TABLE size
(
    size_id SERIAL PRIMARY KEY,
    name    VARCHAR(50) NOT NULL,
    size_cm NUMERIC(10) NOT NULL
);


CREATE TABLE pizza
(
    pizza_id    SERIAL PRIMARY KEY,
    name        VARCHAR(255) UNIQUE NOT NULL,
    image       VARCHAR(255),
    description TEXT
);


CREATE TABLE pizza_category
(
    pizza_id    INTEGER REFERENCES pizza (pizza_id),
    category_id INTEGER REFERENCES category (category_id),
    PRIMARY KEY (pizza_id, category_id)
);

CREATE TABLE pizza_price
(
    pizza_id INTEGER REFERENCES pizza (pizza_id),
    size_id  INTEGER REFERENCES size (size_id),
    price    DECIMAL(6, 2),
    PRIMARY KEY (pizza_id, size_id)
);

CREATE TABLE pizza_ingredient
(
    pizza_id      INTEGER REFERENCES pizza (pizza_id),
    ingredient_id INTEGER REFERENCES ingredient (ingredient_id),
    PRIMARY KEY (pizza_id, ingredient_id)
);