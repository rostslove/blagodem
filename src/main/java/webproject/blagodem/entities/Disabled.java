package webproject.blagodem.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "disabled")
@Table(name="disabled")
@Data
public class Disabled {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name= "birthdate")
    private LocalDate birthdate;

    @Column(name="sex")
    private char sex;

    @Column(name="city")
    private String city;

    @Column(name="disease")
    private String disease;

    @Column(name="dis_group")
    private int dis_group;

    @Column(name="phone")
    private String phone;

    @NotNull
    @Column(name="email")
    private String email;

    @NotNull
    @Column(name="password")
    private String password;

    @OneToMany
    private List<Request> requests;

    public Disabled() {

    }

    public Disabled(final String firstname,
                    final String lastname,
                    final LocalDate birthdate,
                    final char sex,
                    final String city,
                    final String disease,
                    final int dis_group,
                    final String phone,
                    final String email,
                    final String password
                    ) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.sex = sex;
        this.city = city;
        this.disease = disease;
        this.dis_group = dis_group;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }
}
