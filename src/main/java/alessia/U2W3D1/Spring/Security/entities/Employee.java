package alessia.U2W3D1.Spring.Security.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    private String username;
    private String name;
    private String surname;
    private String eMail;
    private String avatarUrl;
    private String password;

    @OneToMany
    private List<Device> devicesList = new ArrayList<>();

    public Employee(String username, String name, String surname, String eMail, String avatarUrl, List<Device> devicesList, String password) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.eMail = eMail;
        this.avatarUrl = avatarUrl;
        this.devicesList = devicesList;
        this.password = password;

    }

    public Employee(String eMail, String password) {
        this.password = password;
        this.eMail = getEMail();
    }


}
