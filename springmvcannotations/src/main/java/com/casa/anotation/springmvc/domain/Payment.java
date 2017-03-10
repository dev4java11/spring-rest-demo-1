package com.casa.anotation.springmvc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the payments database table.
 * 
 */
@Entity
@Table(name="payments")
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PaymentPK id;

	@Column(nullable=false)
	private double amount;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date paymentDate;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customerNumber", nullable=false, insertable=false, updatable=false)
	private Customer customer;

	public Payment() {
	}

	public PaymentPK getId() {
		return this.id;
	}

	public void setId(PaymentPK id) {
		this.id = id;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}