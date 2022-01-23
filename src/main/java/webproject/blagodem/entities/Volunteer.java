package webproject.blagodem.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "volunteer")
@Table(name="VOLUNTEER")
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

    @Column(name = "rating")
    private Long rating;

    @Column(name = "role")
    private String role;

    public Volunteer() {
        this.role = "VOLUNTEER";
        this.rating = Long.valueOf(0);
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
        this.role = "VOLUNTEER";
        this.rating = Long.valueOf(0);
    }

    public Volunteer(
                     final String email,
                     final String password){
        this.email = email;
        this.password = password;
        this.role = "VOLUNTEER";
        this.rating = Long.valueOf(0);
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

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
