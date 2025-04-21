CREATE TABLE assets
(
    id         UUID PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    short_name VARCHAR(30) NOT NULL,
    type       VARCHAR(30) NOT NULL,
    currency   VARCHAR(30) NOT NULL,
    value      NUMERIC(18,9),
    value_base VARCHAR(30),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);
