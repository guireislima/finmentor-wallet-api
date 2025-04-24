package br.com.finmentor.wallet.core.wallet.projection;

import java.time.LocalDateTime;
import java.util.UUID;

public record WalletProjection(
        UUID id,
        String name,
        LocalDateTime createdAt
){
}
