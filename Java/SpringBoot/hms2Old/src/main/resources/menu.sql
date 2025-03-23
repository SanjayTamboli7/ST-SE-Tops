CREATE TABLE menu (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    parent_id BIGINT,
    level INT NOT NULL,
    order_index INT NOT NULL,
    content_id VARCHAR(100),
    FOREIGN KEY (parent_id) REFERENCES menu(id)
);
