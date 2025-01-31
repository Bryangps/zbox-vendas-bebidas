INSERT INTO tb_user(name, email, password) VALUES ('Maria Borge', 'maria@gmail.com', '12345');
INSERT INTO tb_user(name, email, password) VALUES ('Gustavo Borge', 'gustavo@gmail.com', '12345');
INSERT INTO tb_user(name, email, password) VALUES ('Marcelo Borge', 'marcelo@gmail.com', '12345');

INSERT INTO tb_order(moment, order_status, client_id) VALUES (TIMESTAMP WITH TIME ZONE '2025-01-25T17:00:00Z', 1, 1);
INSERT INTO tb_order(moment, order_status, client_id) VALUES (TIMESTAMP WITH TIME ZONE '2025-01-25T18:00:00Z', 2, 1);
INSERT INTO tb_order(moment, order_status, client_id) VALUES (TIMESTAMP WITH TIME ZONE '2025-01-18T20:00:00Z', 2, 2);
INSERT INTO tb_order(moment, order_status, client_id) VALUES (TIMESTAMP WITH TIME ZONE '2025-01-10T08:00:00Z', 1, 3);
INSERT INTO tb_order(moment, order_status, client_id) VALUES (TIMESTAMP WITH TIME ZONE '2025-01-12T08:00:00Z', 2, 3);

INSERT INTO tb_payment(payment_method, payment_date, order_id) VALUES (1, TIMESTAMP WITH TIME ZONE '2025-01-25T18:00:00Z', 2);
INSERT INTO tb_payment(payment_method, payment_date, order_id) VALUES (3, TIMESTAMP WITH TIME ZONE '2025-01-18T20:00:00Z', 3);
INSERT INTO tb_payment(payment_method, payment_date, order_id) VALUES (4, TIMESTAMP WITH TIME ZONE '2025-01-12T08:00:00Z', 5);

INSERT INTO tb_category(name) VALUES ('Refrigerante');
INSERT INTO tb_category(name) VALUES ('Energetico');
INSERT INTO tb_category(name) VALUES ('Serveja');
INSERT INTO tb_category(name) VALUES ('Chopp de vinho ');


INSERT INTO tb_product(name, price, ml, img_url) VALUES ('Coca', 5.0, '350 ml', 'https://images.tcdn.com.br/img/img_prod/858764/refrigerante_coca_cola_lata_350ml_c_12_359_1_20201021152315.jpg');
INSERT INTO tb_product(name, price, ml, img_url) VALUES ('Stempel', 14.0, '500 ml', 'https://www.americanas.com.br/produto/7464149366/chopp-vinho-aveludado-bebida-mista-gaseificada-600ml-stempel#&gid=1&pid=1');
INSERT INTO tb_product(name, price, ml, img_url) VALUES ('Stella', 12.0, '350 ml', 'https://images.tcdn.com.br/img/img_prod/858764/refrigerante_coca_cola_lata_350ml_c_12_359_1_20201021152315.jpg');
INSERT INTO tb_product(name, price, ml, img_url) VALUES ('Baly', 7.50, '350 ml', 'https://images.tcdn.com.br/img/img_prod/858764/refrigerante_coca_cola_lata_350ml_c_12_359_1_20201021152315.jpg');
INSERT INTO tb_product(name, price, ml, img_url) VALUES ('Tijuca', 10.0, '350 ml', 'https://images.tcdn.com.br/img/img_prod/858764/refrigerante_coca_cola_lata_350ml_c_12_359_1_20201021152315.jpg');

INSERT INTO tb_product_category(product_id, category_id) VALUES (1, 1);
INSERT INTO tb_product_category(product_id, category_id) VALUES (2, 4);
INSERT INTO tb_product_category(product_id, category_id) VALUES (3, 3);
INSERT INTO tb_product_category(product_id, category_id) VALUES (4, 2);
INSERT INTO tb_product_category(product_id, category_id) VALUES (5, 3);

INSERT INTO tb_ordem_item(order_id, product_id, quantity, price) VALUES (1, 1, 2, 5.0);
INSERT INTO tb_ordem_item(order_id, product_id, quantity, price) VALUES (2,2, 1, 14.0);
INSERT INTO tb_ordem_item(order_id, product_id, quantity, price) VALUES (3,3,4, 12.0);
INSERT INTO tb_ordem_item(order_id, product_id, quantity, price) VALUES (4, 4, 3, 7.50);
INSERT INTO tb_ordem_item(order_id, product_id, quantity, price) VALUES (5,5, 1, 10.0);

INSERT INTO tb_stock(total_qty, product_id) VALUES (50, 1);
INSERT INTO tb_stock(total_qty, product_id) VALUES (70, 2);
INSERT INTO tb_stock(total_qty, product_id) VALUES (60, 3);
INSERT INTO tb_stock(total_qty, product_id) VALUES (30, 4);
INSERT INTO tb_stock(total_qty, product_id) VALUES (80, 5);