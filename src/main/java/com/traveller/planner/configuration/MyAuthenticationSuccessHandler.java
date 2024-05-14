package com.traveller.planner.configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import java.io.IOException;

/**
 * Custom authentication success handler that redirects the user to the default target URL upon successful authentication.
 */
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    /**
     * Handles a successful authentication event.
     *
     * @param request the HTTP request
     * @param response the HTTP response
     * @param authentication the Authentication object
     * @throws ServletException if an error occurs during the handling of the request
     * @throws IOException if an input or output error occurs during the handling of the request
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        setDefaultTargetUrl("/");
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
