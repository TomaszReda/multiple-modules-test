package pl.test.testbackend.ldap.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LdapController {


    @GetMapping("/ldap")
    @ResponseBody
    public Map<String, String> ldap() {
        Map<String, String> map = new HashMap<>();
        map.put("success", "Success authorization!");
        return map;
    }
}
