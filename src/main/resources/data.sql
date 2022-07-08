INSERT INTO hibernate_sequence (next_val) VALUES (4);


INSERT INTO BOOK_TYPES VALUES(1, "Literature", "LITBOOK");
INSERT INTO BOOK_TYPES VALUES(2, "Nonfiction", "NFBOOK");
INSERT INTO BOOK_TYPES VALUES(3, "Action", "ACBOOK");
INSERT INTO BOOK_TYPES VALUES(4, "Thriller", "THBOOK");
INSERT INTO BOOK_TYPES VALUES(5, "Drama", "ESBOOK");
INSERT INTO BOOK_TYPES VALUES(6, "Poetry", "ALBOOK");
INSERT INTO BOOK_TYPES VALUES(7, "Media", "MEBOOK");
INSERT INTO BOOK_TYPES VALUES(8, "Others", "OTBOOK");
INSERT INTO BOOK_TYPES VALUES(9, "fiction", "FICBOOK");
INSERT INTO BOOK_TYPES VALUES(10, "Comic", "COBOOK");

INSERT INTO promotions (promo_id, description, name, promo_code) VALUES(1, 'Test Promo 1', 'Test Promo 1', 'T-PROMO');

INSERT INTO discounts (discount_id, book_type_id, discount_percentage, promo_id) VALUES(1, 9, 10, 1);
INSERT INTO discounts (discount_id, book_type_id, discount_percentage, promo_id) VALUES(2, 10, 0, 1);

INSERT INTO books (book_id, author, price, description, isbn, name, book_type_id) VALUES(4, 'Author 1', 100.0, 'Book Description', 'ISBN-1', 'Book 1', 9);
INSERT INTO books (book_id, author, price, description, isbn, name, book_type_id) VALUES(5, 'Author 2', 150.0, 'Book Description 2', 'ISBN-2', 'Book 2', 9);
INSERT INTO books (book_id, author, price, description, isbn, name, book_type_id) VALUES(6, 'Author 3', 140.0, 'Book Description 3', 'ISBN-3', 'Book 3', 10);
INSERT INTO books (book_id, author, price, description, isbn, name, book_type_id) VALUES(7, 'Author 4', 200.0, 'Book Description 4', 'ISBN-4', 'Book 4', 10);
