package webproject.blagodem.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "disabled")
@Table(name="disabled")
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

    @Column(name = "role")
    private String role;


    public Disabled() {
        this.role = "DISABLED";
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
        this.role = "DISABLED";
    }

    public Disabled(
                    final String email,
                    final String password
    ) {
        this.email = email;
        this.password = password;
        this.role = "DISABLED";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public int getDis_group() {
        return dis_group;
    }

    public void setDis_group(int dis_group) {
        this.dis_group = dis_group;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
