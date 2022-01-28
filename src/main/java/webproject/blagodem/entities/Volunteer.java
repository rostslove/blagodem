package webproject.blagodem.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "volunteer")
@Table(name="VOLUNTEER")
@Data
public class Volunteer {

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

    @Column(name="phone")
    private String phone;

    @NotNull
    @Column(name="email")
    private String email;

    @NotNull
    @Column(name="password")
    private String password;

    @OneToMany
    private List<Rating> rating;

    @OneToMany
    private List<Request> requests;


    public Volunteer() {
    }

    public Volunteer(final String firstname,
                     final String lastname,
                     final LocalDate birthdate,
                     final char sex,
                     final String city,
                     final String phone,
                     final String email,
                     final String password){
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.sex = sex;
        this.city = city;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }
}
