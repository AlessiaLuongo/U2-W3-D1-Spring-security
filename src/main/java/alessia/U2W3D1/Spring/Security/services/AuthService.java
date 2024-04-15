package alessia.U2W3D1.Spring.Security.services;


import alessia.U2W3D1.Spring.Security.entities.Employee;
import alessia.U2W3D1.Spring.Security.exceptions.UnauthorizedException;
import alessia.U2W3D1.Spring.Security.payloads.EmployeeLogin;
import alessia.U2W3D1.Spring.Security.payloads.PayloadEmployee;
import alessia.U2W3D1.Spring.Security.repositories.EmployeeDAO;
import alessia.U2W3D1.Spring.Security.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JWTTools jwtTools;

    public String authenticateEmployeeAndGenerateToken(EmployeeLogin payload) {
        Employee employee = this.employeeService.findByeMail(payload.eMail());
        if (employee.getPassword().equals(payload.password())) {
            return jwtTools.createToken(employee);
        } else {
            throw new UnauthorizedException("Credenziali non validi, Effettua nuovamente il login");
        }


    }
}
