// default package
// Generated Mar 6, 2023, 7:37:22 PM by Hibernate Tools 6.0.0.Alpha2
package gov.iti.jets.ecommiti.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

/**
 * Roles generated by hbm2java
 */
@Entity
@Table(name="roles"
    ,catalog="healthifymedb"
)
public class Roles  implements java.io.Serializable {


//     private Integer id;
//     private String name;
//     private Set<User> users = new HashSet<User>(0);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Roles() {
    }

    public Roles(ERole name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }

	
//    public Roles(String name) {
//        this.name = name;
//    }
//    public Roles(String name, Set<User> users) {
//       this.name = name;
//       this.users = users;
//    }
//
//     @Id @GeneratedValue(strategy=IDENTITY)
//
//
//    @Column(name="id", unique=true, nullable=false)
//    public Integer getId() {
//        return this.id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//
//    @Column(name="name", nullable=false, length=45)
//    public String getName() {
//        return this.name;
//    }
//
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//@ManyToMany(fetch=FetchType.LAZY)
//    @JoinTable(name="user_has_roles", catalog="healthifymedb", joinColumns = {
//        @JoinColumn(name="roles_id", nullable=false, updatable=false) }, inverseJoinColumns = {
//        @JoinColumn(name="user_id", nullable=false, updatable=false) })
//    public Set<User> getUsers() {
//        return this.users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
//



}


