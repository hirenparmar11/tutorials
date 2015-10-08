package com.learn.intermediate.jpa;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity(name="ORDERS")
public class Order {

	@Id 
    @Column(name = "ORDER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;
    
    @Column(name = "CUST_ID")
    private long custId;
    
    @Column(name = "TOTAL_PRICE", precision = 2)
    private double totPrice;
    
    @Column(name = "OREDER_DESC")
    private String orderDesc;
    
    @Column(name = "ORDER_DATE")  
    private Date orderDt;
    
    @Version
    @Column(name = "LAST_UPDATED_TIME")
    private Date updatedTime;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="CUST_ID", referencedColumnName="CUST_ID")
    private Customer customer;
    
    //optional - join (true - inner, false - outer)
    //mappedBy - order field of 'targetEntity' Invoice
    //cascade - any operation like insert, update, delete on this entity
    //also cascades to do same for its joining entity
    //ALL, REFRESH(update), PERSIST(insert), REMOVE(delete) are options
    @OneToOne(optional=false,cascade=CascadeType.ALL, 
    mappedBy="order",targetEntity=Invoice.class)
    private Invoice invoice;

    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="ORDER_DETAIL", joinColumns=@JoinColumn(name="ORDER_ID", referencedColumnName="ORDER_ID"), inverseJoinColumns=@JoinColumn(name="PROD_ID", referencedColumnName="PROD_ID"))
    private Collection<Product> productList;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public double getTotPrice() {
		return totPrice;
	}

	public void setTotPrice(double totPrice) {
		this.totPrice = totPrice;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public Date getOrderDt() {
		return orderDt;
	}

	public void setOrderDt(Date orderDt) {
		this.orderDt = orderDt;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<Product> getProducts() {
		return productList;
	}

	public void setProducts(Collection<Product> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
