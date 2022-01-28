package webproject.blagodem.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "application")
@Table(name = "APPLICATION")
@Data
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "text")
    private String text;

    @OneToOne
    private File file;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @NotNull
    @Column(name = "status")
    private String status;

    public Application() {
    }
}

