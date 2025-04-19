package br.com.finmentor.wallet.core.wallet.projection;

import java.time.LocalDateTime;

public record WalletProjection(
        String name,
        LocalDateTime createdAt
){
}
