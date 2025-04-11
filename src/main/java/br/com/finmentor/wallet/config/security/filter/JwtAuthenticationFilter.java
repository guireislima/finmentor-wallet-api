package br.com.finmentor.wallet.config.security.filter;

import br.com.finmentor.wallet.config.security.exception.UserNotFoundException;
import br.com.finmentor.wallet.config.security.provider.JwtProvider;
import br.com.finmentor.wallet.external_interfaces.database.jpa.user.entity.UserEntity;
import br.com.finmentor.wallet.external_interfaces.database.jpa.user.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.Instant;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = Optional.ofNullable(request.getHeader("Authorization"))
                .filter(string -> string.startsWith("Bearer "))
                .map(string -> string.substring(7))
                .orElse("");

        var decodedJWT = jwtProvider.validateAccessToken(token);

        if (decodedJWT != null && Instant.now().isBefore(decodedJWT.getExpiresAtAsInstant())) {

            UserEntity user = userRepository.findByLogin(decodedJWT.getSubject())
                    .orElseThrow(() -> new UserNotFoundException("User " + decodedJWT.getSubject() + " not found"));

            log.info("User name: " + user.getName());
            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

        }

        filterChain.doFilter(request, response);
    }
}
