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
import com.shipper.responses.Message;
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
	
	
	/*List*/
	
		@RequestMapping("/all-list")
	public List<DeliveryList> Alllist() {
		return deliveryService.getDeliveries(); 
	}
		
	@GetMapping("/list/{driver}")
	public List<DeliveryList> list(@PathVariable String driver ) {
		return deliveryService.getDeliveriesById(driver); 
	}
	
		@PostMapping("/create")
	public Long createList(@RequestBody DeliveryList deliveryList){ 
		return deliveryService.createDeliveryList(deliveryList.getDriver(),deliveryList.getSupplier());
	}
		
	@DeleteMapping("/delete/{id}")
	public String deleteList(@PathVariable Long id){ 	
		deliveryService.deleteList(id);
		return "delete";
	}	
	
		@PutMapping("/update")
	public String updateList(@RequestBody DeliveryList deliveryList){ 
		deliveryService.updateList(deliveryList);
		return "sik";
	}	
		
		
	/*Equipment*/
	@GetMapping("/equipments/{id}")
	public List<Equipment> retreiveEquipments(@PathVariable Long id) {
		return equipmentService.getEquipments(id); 
	}
	
	@PostMapping("/createEquipment")
	public Long createEquipment(@RequestBody Message message){
		System.out.println(message);
		return equipmentService.createEquipment(message.getName(),message.getQuantity(),message.getDeliveryListId());
	}
	
		@DeleteMapping("/deleteEquipment/{id}")
	public String deleteEquipment(@PathVariable Long id){ 
		equipmentService.deleteEquipment(id);
		return "deleteEquipment";
	}
	
	@PutMapping("/updateEquipment")
	public String updateEquipment(@RequestBody Message message){ 
		System.out.println(message);
		equipmentService.updateList(message);
		return "sik";
	}
	
	

	

	

	
}
