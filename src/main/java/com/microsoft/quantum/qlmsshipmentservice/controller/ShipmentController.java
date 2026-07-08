package com.microsoft.quantum.qlmsshipmentservice.controller;

import com.microsoft.quantum.qlmsshipmentservice.model.Shipment;
import com.microsoft.quantum.qlmsshipmentservice.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/shipments")
@CrossOrigin(origins = "*")
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;

    @GetMapping
    public List<Shipment> getAllShipments() {
        return shipmentService.getAllShipments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shipment> getById(@PathVariable Long id) {
        return shipmentService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Shipment createShipment(@RequestBody Shipment shipment) {
        return shipmentService.createShipment(shipment);
    }

    @PutMapping("/{id}/status")
    public Shipment updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return shipmentService.updateStatus(id, status);
    }

    @GetMapping("/status/{status}")
    public List<Shipment> getByStatus(@PathVariable String status) {
        return shipmentService.getByStatus(status);
    }
}