package br.com.finmentor.wallet.core.wallet.projection;

import java.time.LocalDateTime;
import java.util.UUID;

public interface WalletProjection {
    UUID getId();
    String getName();
    LocalDateTime getCreatedAt();
    Double getSum();
}
