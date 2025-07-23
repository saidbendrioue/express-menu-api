CREATE TABLE fast_food (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    phone VARCHAR(20),
    email VARCHAR(100),
    opening_time TIME,
    closing_time TIME,
    logo_url VARCHAR(500)
);


CREATE TABLE menu
(
    id           UUID PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    description  VARCHAR(500),
    is_active    BOOLEAN      NOT NULL,
    fast_food_id UUID,
    CONSTRAINT fk_menu_fastfood FOREIGN KEY (fast_food_id) REFERENCES fast_food (id)
);

CREATE TABLE menu_category
(
    id            UUID PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    description   VARCHAR(500),
    display_order INT          NOT NULL,
    menu_id       UUID,
    CONSTRAINT fk_category_menu FOREIGN KEY (menu_id) REFERENCES menu (id)
);

CREATE TABLE menu_item
(
    id            UUID PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    description   VARCHAR(500),
    price         DOUBLE       NOT NULL,
    is_available  BOOLEAN      NOT NULL,
    display_order INT          NOT NULL,
    category_id   UUID,
    image_url VARCHAR(500),
    CONSTRAINT fk_item_category FOREIGN KEY (category_id) REFERENCES menu_category (id)
);
