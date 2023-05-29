CREATE
    DATABASE from_the_oven;

CREATE TABLE IF NOT EXISTS ingredient
(
    ingredient_id SERIAL PRIMARY KEY,
    name          VARCHAR(100) UNIQUE NOT NULL,
    image         VARCHAR(255),
    description   TEXT
);

CREATE TABLE IF NOT EXISTS category
(
    category_id SERIAL PRIMARY KEY,
    name        VARCHAR(50) UNIQUE NOT NULL
);


CREATE TABLE IF NOT EXISTS size
(
    size_id SERIAL PRIMARY KEY,
    name    VARCHAR(50) UNIQUE NOT NULL,
    size_cm NUMERIC(10)        NOT NULL
);


CREATE TABLE IF NOT EXISTS pizza
(
    pizza_id    SERIAL PRIMARY KEY,
    name        VARCHAR(255) UNIQUE NOT NULL,
    image       VARCHAR(255),
    rating      INT                 NOT NULL DEFAULT 0,
    description TEXT
);


CREATE TABLE IF NOT EXISTS pizza_category
(
    pizza_id    INTEGER REFERENCES pizza (pizza_id),
    category_id INTEGER REFERENCES category (category_id),
    PRIMARY KEY (pizza_id, category_id)
);

CREATE TABLE IF NOT EXISTS pizza_price
(
    pizza_price_id SERIAL PRIMARY KEY,
    pizza_id       INTEGER REFERENCES pizza (pizza_id),
    size_id        INTEGER REFERENCES size (size_id),
    price          DECIMAL(6, 2) NOT NULL,
    mass           NUMERIC(10)   NOT NULL,
    UNIQUE (pizza_id, size_id)
);

CREATE TABLE IF NOT EXISTS pizza_ingredient
(
    pizza_id      INTEGER REFERENCES pizza (pizza_id),
    ingredient_id INTEGER REFERENCES ingredient (ingredient_id),
    PRIMARY KEY (pizza_id, ingredient_id)
);

CREATE TABLE IF NOT EXISTS pizza_order
(
    pizza_order_id     SERIAL PRIMARY KEY,
    order_date         TIMESTAMP      DEFAULT NOW(),
    is_delivered       BOOLEAN        DEFAULT FALSE,
    call_user          BOOLEAN        DEFAULT TRUE,
    delivery_address   TEXT           NOT NULL,
    total_amount       DECIMAL(10, 2) NOT NULL,
    customer_name      VARCHAR(100)   NOT NULL,
    customer_telephone VARCHAR(20)    NOT NULL,
    customer_comment   TEXT           NULL
);

CREATE TABLE IF NOT EXISTS pizza_order_info
(
    pizza_order_info_id SERIAL PRIMARY KEY,
    pizza_order_id      INTEGER NOT NULL REFERENCES pizza_order (pizza_order_id),
    pizza_price_id      INTEGER NOT NULL REFERENCES pizza_price (pizza_price_id),
    pizza_count         INTEGER,
    UNIQUE (pizza_order_id, pizza_price_id)
);

CREATE TABLE IF NOT EXISTS admin_user
(
    admin_user_id  SERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255)        NOT NULL,
    email    VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS contact_us
(
    contact_us_id SERIAL PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    email         VARCHAR(255) NOT NULL,
    message       TEXT         NOT NULL,
    created_date  TIMESTAMP DEFAULT NOW()
);