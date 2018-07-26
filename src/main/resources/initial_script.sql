CREATE SEQUENCE customer_seq;
INSERT INTO CUSTOMERS VALUES (customer_seq.nextVal, NULL, NULL, false, NULL, NULL, NULL, 0, 'Savska 1', 'e@mail.com', 'P@ssw0rd', random_uuid());
INSERT INTO CUSTOMERS VALUES (customer_seq.nextVal, NULL, NULL, false, NULL, NULL, NULL, 0, 'Savska 2', 'ex@mail.com', 'P@ssw0rd', random_uuid());
INSERT INTO CUSTOMERS VALUES (customer_seq.nextVal, NULL, NULL, false, NULL, NULL, NULL, 0, 'Savska 3', 'exa@mail.com', 'P@ssw0rd', random_uuid());
INSERT INTO CUSTOMERS VALUES (customer_seq.nextVal, NULL, NULL, false, NULL, NULL, NULL, 0, 'Savska 4', 'exam@mail.com', 'P@ssw0rd', random_uuid());
INSERT INTO CUSTOMERS VALUES (customer_seq.nextVal, NULL, NULL, false, NULL, NULL, NULL, 0, 'Savska 5', 'examp@mail.com', 'P@ssw0rd', random_uuid());
INSERT INTO CUSTOMERS VALUES (customer_seq.nextVal, NULL, NULL, false, NULL, NULL, NULL, 0, 'Savska 6', 'exampl@mail.com', 'P@ssw0rd', random_uuid());
INSERT INTO CUSTOMERS VALUES (customer_seq.nextVal, NULL, NULL, false, NULL, NULL, NULL, 0, 'Savska 7', 'example@mail.com', 'P@ssw0rd', random_uuid());

CREATE SEQUENCE product_seq;
INSERT INTO PRODUCTS VALUES (product_seq.nextVal, NULL, NULL, false, NULL, NULL, NULL, 0, 'Product 1', 'EUR', '10.99', random_uuid());
INSERT INTO PRODUCTS VALUES (product_seq.nextVal, NULL, NULL, false, NULL, NULL, NULL, 0, 'Product 2', 'EUR', '100.99', random_uuid());
INSERT INTO PRODUCTS VALUES (product_seq.nextVal, NULL, NULL, false, NULL, NULL, NULL, 0, 'Product 3', 'USD', '1000.99', random_uuid());
INSERT INTO PRODUCTS VALUES (product_seq.nextVal, NULL, NULL, false, NULL, NULL, NULL, 0, 'Product 4', 'RSD', '10000.99', random_uuid());
INSERT INTO PRODUCTS VALUES (product_seq.nextVal, NULL, NULL, false, NULL, NULL, NULL, 0, 'Product 5', 'RSD', '100000.99', random_uuid());
INSERT INTO PRODUCTS VALUES (product_seq.nextVal, NULL, NULL, false, NULL, NULL, NULL, 0, 'Product 6', 'RSD', '1000000.99', random_uuid());
INSERT INTO PRODUCTS VALUES (product_seq.nextVal, NULL, NULL, false, NULL, NULL, NULL, 0, 'Product 7', 'RSD', '10000000.99', random_uuid());
