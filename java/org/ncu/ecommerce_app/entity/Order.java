package org.ncu.ecommerce_app.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

//Order.java
@Entity
public class Order {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @ManyToOne
 private User user;

 @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
 private List<OrderItem> items;

 private LocalDateTime orderDate;
 private String status;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public List<OrderItem> getItems() {
	return items;
}
public void setItems(List<OrderItem> items) {
	this.items = items;
}
public LocalDateTime getOrderDate() {
	return orderDate;
}
public void setOrderDate(LocalDateTime orderDate) {
	this.orderDate = orderDate;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

 // Getters and Setters
}
