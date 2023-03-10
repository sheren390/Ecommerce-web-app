package gov.iti.jets.ecommiti.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "images", catalog = "healthifymedb")
public class Images implements java.io.Serializable {

    private Integer id;
    private byte[] imageData;
    private String name;
    private String type;

    public Images() {
    }

    public Images(byte[] imageData, String type) {
        this.imageData = imageData;
        this.type = type;
    }

    public Images(byte[] imageData, String name, String type) {
        this.imageData = imageData;
        this.name = name;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "image_data", nullable = false, length = 5000000)
    public byte[] getImageData() {
        return this.imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    @Column(name = "name", length = 45)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "type", nullable = false, length = 100)
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
