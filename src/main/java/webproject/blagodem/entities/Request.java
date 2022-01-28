package webproject.blagodem.entities;

import com.sun.istack.NotNull;

import lombok.Data;
import webproject.blagodem.utils.Statuses;

import javax.persistence.*;

@Entity(name = "request")
@Table(name = "REQUEST")
@Data
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Disabled disabled;

    @NotNull
    @Column(name = "status")
    private String status;

    public String getStatus() {
        return Statuses.valueOf(this.status).getName();
    }

    @ManyToOne
    private Volunteer volunteer;

    @OneToOne
    private Rating rating;

    public Request() {

    }
}