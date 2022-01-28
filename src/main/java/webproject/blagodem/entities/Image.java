package webproject.blagodem.entities;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name = "imageName")
    private String imageName;

    @Column(name = "imageType")
    private String imageType;

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] fileData;

    public Image(String imageName, String imageType, byte[] fileData) {
        this.imageName = imageName;
        this.imageType = imageType;
        this.fileData = fileData;
    }

    public Image() {

    }
}
