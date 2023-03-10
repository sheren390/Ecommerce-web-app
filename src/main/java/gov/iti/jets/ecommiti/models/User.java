// default package
// Generated Mar 6, 2023, 7:37:22 PM by Hibernate Tools 6.0.0.Alpha2
package gov.iti.jets.ecommiti.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

/**
 * User generated by hbm2java
 */
//@Entity
//@Table(name="user"
//    ,catalog="healthifymedb"
//)
@Entity
@Table(	name = "user",
    uniqueConstraints = {
            @UniqueConstraint(columnNames = "username"),
            @UniqueConstraint(columnNames = "email")
    })
public class User  implements java.io.Serializable {



     private Integer id;
     private String username;
     private String phone;
     private String email;
     private String password;
     private Long walletBalance;
     private String address;
     private Set<Product> products = new HashSet<Product>(0);
     private Set<Order> orders = new HashSet<Order>(0);
     private Set<Roles> roleses = new HashSet<Roles>(0);

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
	
//    public User(String phone, String email, String password) {
//        this.phone = phone;
//        this.email = email;
//        this.password = password;
//    }
    public User(String username, String phone, String email, String password, Long walletBalance, String address, Set<Product> products, Set<Order> orders, Set<Roles> roleses) {
       this.username = username;
       this.phone = phone;
       this.email = email;
       this.password = password;
       this.walletBalance = walletBalance;
       this.address = address;
       this.products = products;
       this.orders = orders;
       this.roleses = roleses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="username")
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="phone", nullable=true, length=45)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    @Column(name="email", length=45)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="password", length=45)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="wallet_balance", precision=10, scale=0)
    public Long getWalletBalance() {
        return this.walletBalance;
    }
    
    public void setWalletBalance(Long walletBalance) {
        this.walletBalance = walletBalance;
    }

    
    @Column(name="address", length=150)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public Set<Order> getOrders() {
        return this.orders;
    }
    
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="user_has_roles", catalog="healthifymedb", joinColumns = { 
        @JoinColumn(name="user_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="roles_id", nullable=false, updatable=false) })
    public Set<Roles> getRoleses() {
        return this.roleses;
    }
    
    public void setRoleses(Set<Roles> roleses) {
        this.roleses = roleses;
    }




}


