package com.shipper.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shipper.domain.DeliveryList;
import com.shipper.domain.Equipment;
import com.shipper.domain.Message;
import com.shipper.repository.DeliveryListRepository;
import com.shipper.repository.EquipmentRepository;

@Service
public class EquipmentService {

	private EquipmentRepository equipmentRepo;
	private DeliveryListRepository deliveryRepository;
	private DeliveryList deliveryList;
	private Equipment equipment;
	
	@Autowired
	public void setEquipmentrepo(EquipmentRepository equipmentRepo) {
		this.equipmentRepo = equipmentRepo;
	}
	
	@Autowired
	public void setDeliveryRepository(DeliveryListRepository deliveryRepository) {
		this.deliveryRepository = deliveryRepository;
	}

	public void deleteEquipment(Long id) {
		equipmentRepo.deleteById(id);
	}

	public Long createEquipment(String equipmentName, int quantity, Long id) {
		deliveryList = deliveryRepository.findFirstById(id);
		Equipment eq = new Equipment(equipmentName,quantity,deliveryList);
		equipmentRepo.save(eq);
		return eq.getId();
	}
	public List<Equipment> getEquipments(Long id) {
		return  equipmentRepo.findAllByDeliveryListId(id);
	}
	
	public void createDeliveryList(String name, String eq) {
		DeliveryList delivery = new DeliveryList(name,"Halux");
		deliveryRepository.save(delivery);
		
		Equipment equipment = new Equipment(eq, 6,delivery);
		equipmentRepo.save(equipment);
	}
	
	public void updateList(Message message) {
		equipment = equipmentRepo.findFirstById(message.getId());
		equipment.setName(message.getName());
		equipment.setQuantity(message.getQuantity());
		equipmentRepo.save(equipment);
	}
	
//	@PostConstruct
//	private void init() {
//		DeliveryList delivery = new DeliveryList("Bela","Halux");
//		deliveryRepository.save(delivery);
//		
//		Equipment equipment = new Equipment("Kalapacs", 6,delivery);
//		equipmentRepo.save(equipment);
//	}
	
}
