package alessia.U2W3D1.Spring.Security.controllers;

import alessia.U2W3D1.Spring.Security.exceptions.BadRequestException;
import alessia.U2W3D1.Spring.Security.payloads.EmployeeLogin;
import alessia.U2W3D1.Spring.Security.payloads.EmployeeLoginResponse;
import alessia.U2W3D1.Spring.Security.payloads.NewEmployeeResponse;
import alessia.U2W3D1.Spring.Security.payloads.PayloadEmployee;
import alessia.U2W3D1.Spring.Security.services.AuthService;
import alessia.U2W3D1.Spring.Security.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public EmployeeLoginResponse login(@RequestBody EmployeeLogin loginPayload){
    return new EmployeeLoginResponse(this.authService.authenticateEmployeeAndGenerateToken(loginPayload));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public NewEmployeeResponse saveEmployee(@RequestBody @Validated PayloadEmployee loginPayload, BindingResult validation) {

        if(validation.hasErrors()) {  throw new BadRequestException(validation.getAllErrors());
        }

        return new NewEmployeeResponse(this.employeeService.saveEmployee(loginPayload).getId());
    }

}
