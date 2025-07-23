-- Insertion FastFood
INSERT INTO fast_food (id, name, address, phone, email, opening_time, closing_time, logo_url) VALUES
    ('11111111-1111-1111-1111-111111111111', 'Burger Zone', '123 Avenue du Goût, Paris', '0601020304', 'contact@burgerzone.fr', '11:00:00', '23:00:00', 'https://tb-static.uber.com/prod/image-proc/processed_images/5e08979b4ce854f9282b70730b54acae/db809eadd12d21eb61044e0f3bf7c9b7.jpeg');


-- Insertion Menu
INSERT INTO menu (id, name, description, is_active, fast_food_id) VALUES
    ('a1b2c3d4-e5f6-7890-1234-567890abcdef', 'Menu Principal', 'Notre menu principal', TRUE, '11111111-1111-1111-1111-111111111111');

-- Insertion MenuCategory
INSERT INTO menu_category (id, name, display_order, menu_id) VALUES
    ('33333333-3333-3333-3333-333333333333', 'Burgers', 1, 'a1b2c3d4-e5f6-7890-1234-567890abcdef'),
    ('44444444-4444-4444-4444-444444444444', 'Boissons', 2, 'a1b2c3d4-e5f6-7890-1234-567890abcdef'),
    ('55555555-5555-5555-5555-555555555555', 'Desserts', 3, 'a1b2c3d4-e5f6-7890-1234-567890abcdef');

-- Insertion MenuItem
INSERT INTO menu_item (id, name, description, price, is_available, image_url, display_order, category_id) VALUES
('66666666-6666-6666-6666-666666666666', 'Cheeseburger', 'Burger au fromage', 5.50, TRUE, 'https://luma-delikatessen.ch/cdn-cgi/image/w=3420,f=webp,q=80/https://storage.googleapis.com/luma-du-shop-production/original_images/LUMA-rezept-wagyu-burger-001.jpg', 1, '33333333-3333-3333-3333-333333333333'),
('77777777-7777-7777-7777-777777777777', 'Coca-Cola', 'Boisson gazeuse', 2.00, TRUE, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.sospizza-mamirolle.fr%2Fproduct%2Fburger-simple%2F&psig=AOvVaw1M3pGbIDYb1SCbYfqDagna&ust=1753376217675000&source=images&cd=vfe&opi=89978449&ved=0CBUQjRxqFwoTCPi3usa5044DFQAAAAAdAAAAABAK', 2, '44444444-4444-4444-4444-444444444444');
