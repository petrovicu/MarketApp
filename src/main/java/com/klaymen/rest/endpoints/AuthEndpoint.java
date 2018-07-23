package com.klaymen.rest.endpoints;

import com.klaymen.rest.transferobjects.RestResponseObject;
import com.klaymen.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by petrovicu on 23/07/2018.
 */
@RestController
@RequestMapping("/auth")
public class AuthEndpoint {

    @Autowired
    private AuthService authService;

    /**
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "/authenticateUser", method = RequestMethod.POST, headers = "Accept=application/json;charset=utf-8")
    public ResponseEntity<RestResponseObject> authenticateUser(@RequestParam String email, @RequestParam String password) {
        authService.authenticateUser(email, password);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     *
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "/echo", method = RequestMethod.GET, headers = "Accept=application/json;charset=utf-8")
    public ResponseEntity<RestResponseObject> testUser(@RequestParam String email, @RequestParam String password) {
        return new ResponseEntity(authService.authenticateUser(email, password), HttpStatus.OK);
    }
}
