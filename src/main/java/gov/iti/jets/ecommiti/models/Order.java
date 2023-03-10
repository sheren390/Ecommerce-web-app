// default package
// Generated Mar 6, 2023, 7:37:22 PM by Hibernate Tools 6.0.0.Alpha2
package gov.iti.jets.ecommiti.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * Order generated by hbm2java
 */
@Entity
@Table(name="order"
    ,catalog="healthifymedb"
)
public class Order  implements java.io.Serializable {


     private Integer id;
     private User user;
     private Date date;
     private long totalPrice;
     private String orderStatus;
     private Set<OrderHasProduct> orderHasProducts = new HashSet<OrderHasProduct>(0);

    public Order() {
    }

	
    public Order(User user, Date date, long totalPrice, String orderStatus) {
        this.user = user;
        this.date = date;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
    }
    public Order(User user, Date date, long totalPrice, String orderStatus, Set<OrderHasProduct> orderHasProducts) {
       this.user = user;
       this.date = date;
       this.totalPrice = totalPrice;
       this.orderStatus = orderStatus;
       this.orderHasProducts = orderHasProducts;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date", nullable=false, length=19)
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    
    @Column(name="total_price", nullable=false, precision=10, scale=0)
    public long getTotalPrice() {
        return this.totalPrice;
    }
    
    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    
    @Column(name="order_status", nullable=false, length=45)
    public String getOrderStatus() {
        return this.orderStatus;
    }
    
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="order")
    public Set<OrderHasProduct> getOrderHasProducts() {
        return this.orderHasProducts;
    }
    
    public void setOrderHasProducts(Set<OrderHasProduct> orderHasProducts) {
        this.orderHasProducts = orderHasProducts;
    }




}


