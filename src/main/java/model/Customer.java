package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@Table(name = "customer")
@NamedQuery(name="getAll", query="SELECT u from Customer u")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer custid;

	private String firstname;

	private String lastname;

	public Customer(Integer custid, String firstname, String lastname) {
		super();
		this.custid = custid;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Customer() {
	}
	
	public Integer getCustid() {
		return this.custid;
	}

	public void setCustid(Integer custid) {
		this.custid = custid;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}