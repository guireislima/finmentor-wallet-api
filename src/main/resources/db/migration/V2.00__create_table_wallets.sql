CREATE TABLE wallets
(
    id         UUID PRIMARY KEY,
    user_id    UUID NOT NULL,
    name       VARCHAR(255) NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

ALTER TABLE wallets
ADD CONSTRAINT fk_wallets_users
FOREIGN KEY (user_id)
REFERENCES users (id);
