package com.ecommerce.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "address")
public class AddressDTO 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="address_id")
	private int addressId;
	@Column(name = "house_details")
	private String houseDetails;
	private String city;
	private String state;
	private String country;
	@Column(name = "zip_code")
	private String zipCode;
	/*
	 * @Column(name = "user_id") private int userId;
	 */
	@Column(name = "created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Column(name = "modified_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@Transient
	private String message;
	@Transient
	private int statusCode;
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getHouseDetails() {
		return houseDetails;
	}
	public void setHouseDetails(String houseDetails) {
		this.houseDetails = houseDetails;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public AddressDTO() {
		super();
	}
	@Override
	public String toString() {
		return "AddressDTO [addressId=" + addressId + ", houseDetails=" + houseDetails + ", city=" + city + ", state="
				+ state + ", country=" + country + ", zipCode=" + zipCode + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate + ", message=" + message + "]";
	}
	
	
}
