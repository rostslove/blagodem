package webproject.blagodem.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity(name = "rating")
@Table(name = "RATING")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @NotNull
    @Column(name = "disabled")
    private Long disabled;

    @NotNull
    @Column(name = "grade")
    private Long grade;

    @NotNull
    @Column(name = "volunteer")
    private Long volunteer;

    public Rating() {
    }

    public Rating(final Long disabled,
                  final Long grade,
                  final Long volunteer){
        this.disabled = disabled;
        this.grade = grade;
        this.volunteer = volunteer;
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

    public Long getGrade() {
        return grade;
    }

    public void setGrade(Long grade) {
        this.grade = grade;
    }

    public Long getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Long volunteer) {
        this.volunteer = volunteer;
    }
}
