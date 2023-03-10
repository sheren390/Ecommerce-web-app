// default package
// Generated Mar 6, 2023, 7:37:22 PM by Hibernate Tools 6.0.0.Alpha2
package gov.iti.jets.ecommiti.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "category", catalog = "healthifymedb")
public class Category implements java.io.Serializable {

    private Integer id;
    private String name;
    private String image;
    private String description;
    private Set<Product> products = new HashSet<Product>(0);

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, String image, String description, Set<Product> products) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.products = products;
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

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "image", length = 150)
    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "description", length = 150)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    public Set<Product> getProducts() {
        return this.products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

}
