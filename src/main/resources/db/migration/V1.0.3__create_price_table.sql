CREATE TABLE price
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    brand_id   INT            NOT NULL,
    product_id INT            NOT NULL,
    start_date TIMESTAMP      NOT NULL,
    end_date   TIMESTAMP      NOT NULL,
    price_list INT            NOT NULL,
    priority   INT            NOT NULL,
    price      DECIMAL(10, 2) NOT NULL,
    currency       ENUM('EUR') NOT NULL,
    FOREIGN KEY (brand_id) REFERENCES brand (id),
    FOREIGN KEY (product_id) REFERENCES product (id),
    UNIQUE (brand_id, product_id, price_list, start_date, end_date)
);