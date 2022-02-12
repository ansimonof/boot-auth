package org.myorg.module.auth.controller;

import org.myorg.module.auth.AuthModuleConsts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AuthModuleConsts.REST_API_PREFIX)
public class AuthController {

    @GetMapping("/hello")
    public ResponseEntity<?> getResult() {
        return ResponseEntity.ok("qwe");
    }
}
