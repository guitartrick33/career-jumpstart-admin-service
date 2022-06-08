package com.careerjumpstart.admin_ms.health;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/actuator/")
public class TestController {
    @GetMapping()
    public String healthCheck() {
        return "SoftFactor microservice is running.";
    }

    @GetMapping("deployment")
    public String healthCheckDeployment() {
        return "SoftFactor Deployment is ok";
    }
}