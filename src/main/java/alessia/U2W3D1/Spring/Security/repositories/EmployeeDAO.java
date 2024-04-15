package alessia.U2W3D1.Spring.Security.repositories;

import alessia.U2W3D1.Spring.Security.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByeMail(String eMail);
}
