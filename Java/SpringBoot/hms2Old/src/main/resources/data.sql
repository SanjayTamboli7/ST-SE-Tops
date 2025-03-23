INSERT INTO menu (id, name, parent_id, level, order_index, content_id) VALUES
(1, 'Home', NULL, 1, 1, 'home-content'),
(2, 'Products', NULL, 1, 2, NULL),
(3, 'Electronics', 2, 2, 1, NULL),
(4, 'Laptops', 3, 3, 1, 'laptops-content'),
(5, 'Mobiles', 3, 3, 2, 'mobiles-content'),
(6, 'Furniture', 2, 2, 2, NULL),
(7, 'Chairs', 6, 3, 1, 'chairs-content'),
(8, 'Tables', 6, 3, 2, 'tables-content'),
(9, 'Contact', NULL, 1, 3, 'contact-content');
