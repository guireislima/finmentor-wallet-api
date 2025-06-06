CREATE TABLE users
(
    id         UUID PRIMARY KEY,
    login      VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    name       VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    role       VARCHAR(50)  NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);
