package vn.edu.likelion.movie_tickets_online_bookings.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader(SecurityConstant.JWT_HEADER);
        System.out.println("token " + token);

        if( token!=null ){

            // Ignore Bearer char
            token = token.substring(7);

            SecretKey key = Keys.hmacShaKeyFor(SecurityConstant.JWT_KEY.getBytes());

            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            System.out.println("claims " + claims);

            // Get Email
            String email = claims.getSubject();
            System.out.println("email " + email);
            String authorities = claims.get("authorities").toString();
            System.out.println("authorities " + authorities);

            Authentication auth = new UsernamePasswordAuthenticationToken(
                    email,
                    null,
                    AuthorityUtils.commaSeparatedStringToAuthorityList(authorities)
            );
            System.out.println("auth " + auth);

            SecurityContextHolder.getContext().setAuthentication(auth);

        }

        filterChain.doFilter(request, response);
    }
}
