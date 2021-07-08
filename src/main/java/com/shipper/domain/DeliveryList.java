package com.shipper.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;




@Entity
public class DeliveryList {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String driver;
	private String supplier;
	
	@JsonBackReference
	@OneToMany(mappedBy = "deliveryList")
	private List<Equipment> equipments;
	
	private int quantitySum;
	
	private DeliveryList() {}
	
	public DeliveryList(String driver, String supplier) {
		this.driver = driver;
		this.supplier = supplier;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getDriver() {
		return driver;
	}


	public void setDriver(String driver) {
		this.driver = driver;
	}


	public String getSupplier() {
		return supplier;
	}


	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}


	public List<Equipment> getEquipments() {
		return equipments;
	}


	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}

	
	public int getQuantitySum() {
		return quantitySum;
	}

	public void setQuantitySum(int quantitySum) {
		this.quantitySum = quantitySum;
	}

	@Override
	public String toString() {
		return "DeliveryList [id=" + id + ", driver=" + driver + ", supplier=" + supplier + "]";
	}



	
}
