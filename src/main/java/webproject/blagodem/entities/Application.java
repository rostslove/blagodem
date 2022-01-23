package webproject.blagodem.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity(name = "application")
@Table(name = "APPLICATION")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @NotNull
    @Column(name = "text")
    private String text;

    @Column(name = "file")
    private String file;

    @NotNull
    @Column(name = "disabled")
    private Long disabled;

    @NotNull
    @Column(name = "status")
    private String status;

    public Application() {
    }

    public Application(final String text,
                       final String file,
                       final Long disabled,
                       final String status) {
        this.text = text;
        this.file = file;
        this.disabled = disabled;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
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
}
