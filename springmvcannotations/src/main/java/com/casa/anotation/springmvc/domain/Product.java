package com.casa.anotation.springmvc.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
@NamedStoredProcedureQuery(name="Product.spgenerateProductCode", procedureName = "spGenerateProductCode", parameters={
		@StoredProcedureParameter(mode = ParameterMode.IN, name="scaleProduct", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name= "codeProductGenerate", type = String.class)
})
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, length=15)
	private String productCode;

	@Column(nullable=false)
	private double buyPrice;

	@Column(nullable=false)
	private double msrp;

	@Lob
	@Column(nullable=false)
	private String productDescription;

	@Column(nullable=false, length=70)
	private String productName;

	@Column(nullable=false, length=10)
	private String productScale;

	@Column(nullable=false, length=50)
	private String productVendor;

	@Column(nullable=false)
	private short quantityInStock;

	//bi-directional many-to-one association to Orderdetail
	@OneToMany(mappedBy="product")
	private List<Orderdetail> orderdetails;

	//bi-directional many-to-one association to Productline
	@ManyToOne
	@JoinColumn(name="productLine", nullable=false)
	private Productline productline;

	public Product() {
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public double getBuyPrice() {
		return this.buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public double getMsrp() {
		return this.msrp;
	}

	public void setMsrp(double msrp) {
		this.msrp = msrp;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductScale() {
		return this.productScale;
	}

	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}

	public String getProductVendor() {
		return this.productVendor;
	}

	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	public short getQuantityInStock() {
		return this.quantityInStock;
	}

	public void setQuantityInStock(short quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public List<Orderdetail> getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(List<Orderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}

	public Orderdetail addOrderdetail(Orderdetail orderdetail) {
		getOrderdetails().add(orderdetail);
		orderdetail.setProduct(this);

		return orderdetail;
	}

	public Orderdetail removeOrderdetail(Orderdetail orderdetail) {
		getOrderdetails().remove(orderdetail);
		orderdetail.setProduct(null);

		return orderdetail;
	}

	public Productline getProductline() {
		return this.productline;
	}

	public void setProductline(Productline productline) {
		this.productline = productline;
	}
	
}