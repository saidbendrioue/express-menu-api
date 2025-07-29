-- Insert Users first (required for fast_food foreign key)
INSERT INTO t_user (id, username, password, email, first_name, last_name, phone_number) VALUES
('00000000-0000-0000-0000-000000000001', 'admin1', '$2a$10$xJwL5v5Jz8UZ5Z5Z5Z5Z5e5Z5Z5Z5Z5Z5Z5Z5Z5Z5Z5Z5Z5Z5Z5', 'admin@expressmenu.com', 'Admin', 'User', '0600000000'),
('00000000-0000-0000-0000-000000000002', 'owner1', '$2a$10$xJwL5v5Jz8UZ5Z5Z5Z5Z5e5Z5Z5Z5Z5Z5Z5Z5Z5Z5Z5Z5Z5Z5Z5', 'owner@burgerzone.fr', 'Jean', 'Dupont', '0601020304');

-- Insertion FastFood (now with owner_id reference)
INSERT INTO t_fast_food (id, name, address, phone, email, opening_time, closing_time, logo_url, owner_id) VALUES
('11111111-1111-1111-1111-111111111111', 'Burger Zone', '123 Avenue du Goût, Paris', '0601020304', 'contact@burgerzone.fr', '11:00:00', '23:00:00', 'https://tb-static.uber.com/prod/image-proc/processed_images/5e08979b4ce854f9282b70730b54acae/db809eadd12d21eb61044e0f3bf7c9b7.jpeg', '00000000-0000-0000-0000-000000000002');

-- Insertion Menu
INSERT INTO t_menu (id, name, description, active, fast_food_id) VALUES
('a1b2c3d4-e5f6-7890-1234-567890abcdef', 'Menu Principal', 'Notre menu principal avec toutes nos spécialités', TRUE, '11111111-1111-1111-1111-111111111111');

-- Insertion Sections
INSERT INTO t_section (id, name, display_order, menu_id) VALUES
('33333333-3333-3333-3333-333333333333', 'Nos Burgers', 1, 'a1b2c3d4-e5f6-7890-1234-567890abcdef'),
('44444444-4444-4444-4444-444444444444', 'Boissons Fraîches', 2, 'a1b2c3d4-e5f6-7890-1234-567890abcdef'),
('55555555-5555-5555-5555-555555555555', 'Desserts Maison', 3, 'a1b2c3d4-e5f6-7890-1234-567890abcdef'),
('99999999-9999-9999-9999-999999999999', 'Menus Complets', 4, 'a1b2c3d4-e5f6-7890-1234-567890abcdef');

-- Insertion Products - Burgers
INSERT INTO t_product (id, name, description, price, available, image_url, display_order, section_id) VALUES
-- Burgers
('66666666-6666-6666-6666-666666666666', 'Classic Burger', 'Steak haché 100% bœuf, cheddar, salade, tomate, oignon, sauce maison', 5.90, TRUE, 'https://luma-delikatessen.ch/cdn-cgi/image/w=3420,f=webp,q=80/https://storage.googleapis.com/luma-du-shop-production/original_images/LUMA-rezept-wagyu-burger-001.jpg', 1, '33333333-3333-3333-3333-333333333333'),
('66666666-6666-6666-6666-666666666667', 'Cheeseburger', 'Double steak haché, double cheddar, cornichons, sauce burger', 7.50, TRUE, 'https://www.atablefullofjoy.com/wp-content/uploads/2019/10/blue-cheese-bacon-burger-featured.jpg', 2, '33333333-3333-3333-3333-333333333333'),
('66666666-6666-6666-6666-666666666668', 'Bacon Burger', 'Steak haché, cheddar fumé, bacon croustillant, sauce barbecue', 8.20, TRUE, 'https://img.cuisineaz.com/660x495/2016/05/21/i86551-burger-au-bacon-et-au-cheddar.jpg', 3, '33333333-3333-3333-3333-333333333333'),
('66666666-6666-6666-6666-666666666669', 'Chicken Burger', 'Filet de poulet pané, salade, tomate, sauce mayo-piment', 6.90, TRUE, 'https://www.mrcod.pk/wp-content/uploads/2023/03/1.1.webp', 4, '33333333-3333-3333-3333-333333333333'),
('66666666-6666-6666-6666-666666666670', 'Veggie Burger', 'Steak végétal, avocat, roquette, tomate séchée, sauce tahini', 7.80, TRUE, 'https://ranchhousestores.com/wp-content/uploads/2025/01/intro-1655922152.jpg', 5, '33333333-3333-3333-3333-333333333333'),

      -- Boissons
('77777777-7777-7777-7777-777777777777', 'Coca-Cola', 'Canette 33cl', 2.50, TRUE, 'https://static.wixstatic.com/media/31a0fa_3f2f7030af1d42d593fe9e723a73aac5~mv2.png/v1/fill/w_480,h_470,al_c,q_85,usm_0.66_1.00_0.01,enc_avif,quality_auto/31a0fa_3f2f7030af1d42d593fe9e723a73aac5~mv2.png', 1, '44444444-4444-4444-4444-444444444444'),
('77777777-7777-7777-7777-777777777778', 'Fanta Orange', 'Canette 33cl', 2.50, TRUE, 'https://m.media-amazon.com/images/I/41VRFVh2RyL._UF1000,1000_QL80_.jpg', 2, '44444444-4444-4444-4444-444444444444'),
('77777777-7777-7777-7777-777777777779', 'Sprite', 'Canette 33cl', 2.50, TRUE, 'https://m.media-amazon.com/images/I/61IHYCxJIKL._UF1000,1000_QL80_.jpg', 3, '44444444-4444-4444-4444-444444444444'),
('77777777-7777-7777-7777-777777777780', 'Eau Minérale', 'Bouteille 50cl', 1.80, TRUE, 'https://www.contrex.fr/sites/g/files/xknfdk1996/files/styles/cropped_static_2_column_fallback/public/2024-08/Promo_Two_Column_100CL_8.jpg?itok=ZZaB7oFT', 4, '44444444-4444-4444-4444-444444444444'),
('77777777-7777-7777-7777-777777777781', 'Limonade Maison', 'Verre 25cl', 3.20, TRUE, 'https://media.zummocorp.com/mask-group-2-1687945106KR6W7.webp', 5, '44444444-4444-4444-4444-444444444444'),

      -- Desserts
('88888888-8888-8888-8888-888888888888', 'Fondant au Chocolat', 'Dessert chocolaté coulant accompagné d''une boule de glace vanille', 4.90, TRUE, 'https://img-3.journaldesfemmes.fr/6oqO_pwejtqVj9d-2AQOUsGddEE=/1240x/smart/e2384d1c32d444528e8ec0881c4d632d/ccmcms-jdf/27162578.jpg', 1, '55555555-5555-5555-5555-555555555555'),
('88888888-8888-8888-8888-888888888889', 'Tiramisu', 'Classique italien au café et mascarpone', 5.20, TRUE, 'https://assets.afcdn.com/recipe/20190529/93121_w1024h1024c1cx1060cy707.webp', 2, '55555555-5555-5555-5555-555555555555'),
('88888888-8888-8888-8888-888888888890', 'Cheesecake', 'Cheesecake New-Yorkais avec coulis de fruits rouges', 5.50, TRUE, 'https://assets.afcdn.com/recipe/20221209/138327_w1024h1024c1cx2143cy1756cxt0cyt0cxb4372cyb3846.jpg', 3, '55555555-5555-5555-5555-555555555555'),
('88888888-8888-8888-8888-888888888891', 'Sundae Chocolat', 'Glace vanille, sauce chocolat, chantilly et noisettes concassées', 4.20, TRUE, 'https://www.kingarthurbaking.com/sites/default/files/styles/featured_image/public/recipe_legacy/5463-3-large.jpg?itok=l5_GcsqP', 4, '55555555-5555-5555-5555-555555555555'),
('88888888-8888-8888-8888-888888888892', 'Beignet Chocolat', 'Beignet moelleux fourré au chocolat, sucre glace', 3.80, TRUE, 'https://www.purerecette.com/wp-content/uploads/2025/01/Beignet-Nutella-4.jpg', 5, '55555555-5555-5555-5555-555555555555'),

    -- Menus Complets
('99999999-9999-9999-9999-999999999999', 'Menu Classique', 'Classic Burger + Frites + Boisson 33cl', 10.90, TRUE, 'https://burgerhouse.planetedesign.com/wp-content/uploads/2021/04/m1-1.png', 1, '99999999-9999-9999-9999-999999999999'),
('99999999-9999-9999-9999-999999999998', 'Menu Maxi', 'Cheeseburger + Frites + Nuggets + Boisson 50cl', 13.50, TRUE, 'https://img.argentdubeurre.com/content/7348/illustration/burger-king-2-pour-5-4.jpg', 2, '99999999-9999-9999-9999-999999999999'),
('99999999-9999-9999-9999-999999999997', 'Menu Végétarien', 'Veggie Burger + Salade + Boisson 33cl', 11.20, TRUE, 'https://png.pngtree.com/png-clipart/20250316/original/pngtree-classic-burger-with-fries-and-drink-png-image_19458094.png', 3, '99999999-9999-9999-9999-999999999999');