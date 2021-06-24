package com.shipper.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shipper.domain.DeliveryList;
import com.shipper.domain.Equipment;
import com.shipper.repository.DeliveryListRepository;
import com.shipper.repository.EquipmentRepository;

@Service
public class DeliveryListService {

	
	private DeliveryListRepository deliveryRepository;
	private DeliveryList deliveryList;
	
	@Autowired
	public void setDeliveryRepository(DeliveryListRepository deliveryRepository) {
		this.deliveryRepository = deliveryRepository;
	}
	
	public List<DeliveryList> getDeliveries() {
		return  deliveryRepository.findAll();
	}
	public List<DeliveryList> getDeliveriesById(String driver) {
		return  deliveryRepository.findAllByDriver(driver);
	}
	public void deleteList(Long id) {
		deliveryRepository.deleteById(id);
	}
	public DeliveryList createDeliveryList(String driver, String supplier) {
		DeliveryList delivery = new DeliveryList(driver,supplier);
		deliveryRepository.save(delivery);
		return delivery;
	}
	public void updateList(DeliveryList newDelivery) {
		deliveryList = deliveryRepository.findFirstById(newDelivery.getId());
		deliveryList = newDelivery;
		deliveryRepository.save(deliveryList);
	}
}
