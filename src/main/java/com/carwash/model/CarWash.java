package com.carwash.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "CarWash")
public class CarWash {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "car_no", nullable = false, unique = true)
	@NotEmpty(message = "Please provide Car No")
	private String carNo;
	
	@Column(name = "owner_name")
	@Transient
	private String ownerName;
	
	@Column(name = "mobile_no")
	@NotEmpty(message = "Please provide your Mobile No")
	private String mobileNo;
	
	@Column(name = "address")
	@NotEmpty(message = "Please provide your Address")
	private String address;
	
	@Column(name = "request_date")
	private boolean requestDate;
	
	@Column(name = "wash_date")
	private String washDate;
	
	@Column(name = "status")
	private String status;

	@Column(name = "payment_status")
	private String paymentStatus;
	
	@Column(name = "package_type")
	private String packageTpe;
	
	@Column(name = "amount")
	private Double amount;
	

	public String getPackageTpe() {
	    return packageTpe;
	}

	public void setPackageTpe(String packageTpe) {
	    this.packageTpe = packageTpe;
	}

	public Double getAmount() {
	    return amount;
	}

	public void setAmount(Double amount) {
	    this.amount = amount;
	}

	public int getId() {
	    return id;
	}

	public void setId(int id) {
	    this.id = id;
	}

	public String getCarNo() {
	    return carNo;
	}

	public void setCarNo(String carNo) {
	    this.carNo = carNo;
	}

	public String getOwnerName() {
	    return ownerName;
	}

	public void setOwnerName(String ownerName) {
	    this.ownerName = ownerName;
	}

	public String getMobileNo() {
	    return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
	    this.mobileNo = mobileNo;
	}

	public String getAddress() {
	    return address;
	}

	public void setAddress(String address) {
	    this.address = address;
	}

	public boolean isRequestDate() {
	    return requestDate;
	}

	public void setRequestDate(boolean requestDate) {
	    this.requestDate = requestDate;
	}

	public String getWashDate() {
	    return washDate;
	}

	public void setWashDate(String washDate) {
	    this.washDate = washDate;
	}

	public String getStatus() {
	    return status;
	}

	public void setStatus(String status) {
	    this.status = status;
	}

	public String getPaymentStatus() {
	    return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
	    this.paymentStatus = paymentStatus;
	}
	
	
}