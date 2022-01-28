package webproject.blagodem.entities;

import com.sun.istack.NotNull;
import lombok.Data;


import javax.persistence.*;

@Entity(name = "rating")
@Table(name = "RATING")
@Data
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @NotNull
    @OneToOne
    private Disabled disabled;

    @NotNull
    @Column(name = "grade")
    private Long grade;

    @ManyToOne(fetch = FetchType.LAZY)
    private Volunteer volunteer;

    public Rating() {
    }
}