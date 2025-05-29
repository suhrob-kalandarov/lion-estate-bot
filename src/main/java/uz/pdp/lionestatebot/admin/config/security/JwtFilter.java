package uz.pdp.lionestatebot.admin.config.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.pdp.lionestatebot.admin.entity.Admin;
import uz.pdp.lionestatebot.admin.service.AdminService;
import uz.pdp.lionestatebot.bot.models.entity.User;
import uz.pdp.lionestatebot.bot.service.model.faces.UserService;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final AdminService adminService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String token = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
        }

        if (token != null && jwtService.isTokenValid(token)) {
            String username = jwtService.extractUsername(token);
            Admin admin = adminService.getByUsername(username);

            if (admin != null && admin.getUser().getIsAdmin()) {
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        admin, null, null);
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        filterChain.doFilter(request, response);
    }
}
