package com.n2.portal.controller;

import com.n2.portal.model.User;
import com.n2.portal.service.UserService;
import com.n2.portal.utils.N2Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dhnhan on 9/27/2016.
 */
@RestController
@RequestMapping("/n2")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private TokenStore tokenStore;

    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public User getUserCurrent() {
        return userService.findBySso(N2Security.getUser());
    }

    @RequestMapping(value = "/api/logout", method = RequestMethod.GET)
    public ResponseEntity<Void> logout(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null) {
            String tokenValue = authHeader.replace("bearer", "").trim();
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
            tokenStore.removeAccessToken(accessToken);
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
