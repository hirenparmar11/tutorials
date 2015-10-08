package com.learn.intermediate.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity(name="PRODUCT")
public class Product {

	@Id
	@Column(name="PROD_ID", nullable=false)
	private long prodId;
	
	@Column(name="PROD_NAME", nullable=false, length=50)
	private String prodName;
	
	@Column(name = "PROD_DESC", length = 200)
	private String prodDescription;
	
	@Column(name = "REGULAR_PRICE", precision = 2)
	private String price;
	
	@Column(name = "LAST_UPDATED_TIME")
	private Date updatedTime;
	
	@ManyToMany(mappedBy="productList", targetEntity=Order.class, fetch=FetchType.EAGER)
	private List<Order> orderList;
	
	
	public long getProdId() {
		return prodId;
	}
	public void setProdId(long prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdDescription() {
		return prodDescription;
	}
	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
