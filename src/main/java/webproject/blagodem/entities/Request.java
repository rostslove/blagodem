package webproject.blagodem.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity(name = "request")
@Table(name = "REQUEST")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @NotNull
    @Column(name = "disabled")
    private Long disabled;

    @NotNull
    @Column(name = "status")
    private String status;

    @Column(name = "volunteer")
    private String volunteer;

    public Request(final Long disabled,
                   final String status,
                   final String volunteer) {
        this.id = id;
        this.disabled = disabled;
        this.status = status;
        this.volunteer = volunteer;
    }

    public Request() {
        this.volunteer = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDisabled() {
        return disabled;
    }

    public void setDisabled(Long disabled) {
        this.disabled = disabled;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(String volunteer) {
        this.volunteer = volunteer;
    }
}
