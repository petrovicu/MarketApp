package com.klaymen.rest.endpoints;

import com.klaymen.rest.transferobjects.RestResponseObject;
import com.klaymen.rest.transferobjects.TOLoginRequest;
import com.klaymen.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
     * Authenticate user against internal Customer DB using unique email and password
     *
     * @param loginRequest
     * @return
     */
    @RequestMapping(value = "/authenticateUser", method = RequestMethod.POST, headers = "Accept=application/json;charset=utf-8")
    public ResponseEntity<RestResponseObject> authenticateUser(@RequestBody TOLoginRequest loginRequest) {
        authService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());
        return new ResponseEntity(new RestResponseObject(true, "User with email: " + loginRequest.getEmail() + " successfully logged in."),
                HttpStatus.OK);
    }
}
