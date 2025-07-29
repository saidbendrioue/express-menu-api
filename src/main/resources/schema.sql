CREATE TABLE t_user (
    id UUID PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    phone_number VARCHAR(20)
);

CREATE TABLE t_fast_food (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    phone VARCHAR(20),
    email VARCHAR(100),
    opening_time TIME,
    closing_time TIME,
    logo_url VARCHAR(500),
    owner_id UUID NOT NULL,
    CONSTRAINT fk_fastfood_user FOREIGN KEY (owner_id) REFERENCES t_user (id)
);

CREATE TABLE t_menu (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(500),
    active BOOLEAN NOT NULL DEFAULT TRUE,
    fast_food_id UUID NOT NULL,
    CONSTRAINT fk_menu_fastfood FOREIGN KEY (fast_food_id) REFERENCES t_fast_food (id)
);

CREATE TABLE t_section (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(500),
    display_order INT NOT NULL,
    menu_id UUID NOT NULL,
    CONSTRAINT fk_section_menu FOREIGN KEY (menu_id) REFERENCES t_menu (id)
);

CREATE TABLE t_product (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(500),
    price DECIMAL(10,2) NOT NULL,
    available BOOLEAN NOT NULL DEFAULT TRUE,
    display_order INT NOT NULL,
    section_id UUID NOT NULL,
    image_url VARCHAR(500),
    CONSTRAINT fk_item_section FOREIGN KEY (section_id) REFERENCES t_section (id)
);