package alessia.U2W3D1.Spring.Security.repositories;

import alessia.U2W3D1.Spring.Security.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceDAO extends JpaRepository<Device, Integer> {
}
