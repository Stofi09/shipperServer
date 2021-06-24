package com.shipper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shipper.domain.DeliveryList;
import com.shipper.domain.Equipment;
import com.shipper.domain.Message;
import com.shipper.service.DeliveryListService;
import com.shipper.service.EquipmentService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class APIContoller {
	
	private EquipmentService equipmentService; 
	private DeliveryListService deliveryService;
	
	@Autowired
	public void setEquipmentService(EquipmentService equipmentService) {
		this.equipmentService = equipmentService;
	}

	@Autowired
	public void setDeliveryService(DeliveryListService deliveryService) {
		this.deliveryService=deliveryService;
	}


	@GetMapping("/equipments/{id}")
	public List<Equipment> retreiveEquipments(@PathVariable Long id) {
		return equipmentService.getEquipments(id); 
	}
	@RequestMapping("/all-list")
	public List<DeliveryList> Alllist() {
		return deliveryService.getDeliveries(); 
	}
	@GetMapping("/list/{driver}")
	public List<DeliveryList> list(@PathVariable String driver ) {
		return deliveryService.getDeliveriesById(driver); 
	}
	
	@PostMapping("/create")
	public String createList(@RequestBody DeliveryList deliveryList){ 
			deliveryService.createDeliveryList(deliveryList.getDriver(),deliveryList.getSupplier());
		return "create";
	}
	
	@PostMapping("/createEquipment")
	public Long createEquipment(@RequestBody Message message){
		return equipmentService.createEquipment(message.getName(),message.getQuantity(),message.getDeliveryListId());
	}

	@DeleteMapping("/delete/{id}")
	public String deleteList(@PathVariable Long id){ 	
		deliveryService.deleteList(id);
		return "delete";
	}
	
	@DeleteMapping("/deleteEquipment/{id}")
	public String deleteEquipment(@PathVariable Long id){ 
		System.out.println(id);
		equipmentService.deleteEquipment(id);
		return "deleteEquipment";
	}
	
	@PutMapping("/update")
	public String updateList(@RequestBody DeliveryList deliveryList){ 
		deliveryService.updateList(deliveryList);
		return "sik";
	}
	
	@PutMapping("/updateEquipment")
	public String updateEquipment(@RequestBody Message message){ 
		equipmentService.updateList(message);
		return "sik";
	}
	
}
