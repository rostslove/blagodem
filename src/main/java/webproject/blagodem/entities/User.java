package webproject.blagodem.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name="user")
@Table(name="USERS")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @NotNull
    @Column(name="username")
    private String username;

    @NotNull
    @Column(name="password")
    private String password;

    @Column(name = "role")
    private String role;

    @OneToMany
    private List<Application> applications;

    @JoinColumn(name = "image")
    @OneToOne(fetch = FetchType.EAGER)
    private Image image;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = null;
    }

    public User() {
    }
}