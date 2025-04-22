CREATE TABLE wallets_assets
(
    id         UUID PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    wallet_id  UUID NOT NULL,
    asset_id   UUID NOT NULL,
    amount     NUMERIC(18,9),
    custody    VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

ALTER TABLE wallets_assets
ADD CONSTRAINT fk_wallets_assets_wallets
FOREIGN KEY (wallet_id)
REFERENCES wallets (id);

ALTER TABLE wallets_assets
ADD CONSTRAINT fk_wallets_assets_assets
FOREIGN KEY (asset_id)
REFERENCES assets (id);
