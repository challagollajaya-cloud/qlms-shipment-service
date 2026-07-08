package com.microsoft.quantum.qlmsshipmentservice.service;

import com.microsoft.quantum.qlmsshipmentservice.model.Shipment;
import com.microsoft.quantum.qlmsshipmentservice.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShipmentService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    public Optional<Shipment> getById(Long id) {
        return shipmentRepository.findById(id);
    }

    public Shipment createShipment(Shipment shipment) {
        shipment.setShipmentNumber("QLMS-"
                + UUID.randomUUID().toString()
                .substring(0, 8).toUpperCase());
        return shipmentRepository.save(shipment);
    }

    public Shipment updateStatus(Long id, String status) {
        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Shipment not found!"));
        shipment.setStatus(status);
        return shipmentRepository.save(shipment);
    }

    public List<Shipment> getByStatus(String status) {
        return shipmentRepository.findByStatus(status);
    }
}