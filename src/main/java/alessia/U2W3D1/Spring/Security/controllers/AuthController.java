package alessia.U2W3D1.Spring.Security.controllers;

import alessia.U2W3D1.Spring.Security.payloads.EmployeeLogin;
import alessia.U2W3D1.Spring.Security.payloads.PayloadEmployee;
import alessia.U2W3D1.Spring.Security.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody EmployeeLogin loginPayload){
    return this.authService.authenticateEmployeeAndGenerateToken(loginPayload);
    }

}
