package ru.kpfu.itis.SoftIlnyr.mvc.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by softi on 02.05.2016.
 */

public class MyAuthSuccess implements AuthenticationSuccessHandler {

    private RedirectStrategy strategy = new DefaultRedirectStrategy();


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String targetUrl = determineTargetUrl(authentication);

        strategy.sendRedirect(httpServletRequest, httpServletResponse, targetUrl);
    }

    private String determineTargetUrl(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        if ("ROLE_ADMIN".equals(user.getRole()) || "ROLE_MANAGER".equals(user.getRole())) {
            return "/tables/books";
        } else {
            return "/test";
        }
    }
}
