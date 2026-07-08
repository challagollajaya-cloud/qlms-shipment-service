package com.microsoft.quantum.qlmsshipmentservice.repository;

import com.microsoft.quantum.qlmsshipmentservice.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShipmentRepository
        extends JpaRepository<Shipment, Long> {

    List<Shipment> findByStatus(String status);
    List<Shipment> findBySourceLab(String sourceLab);
    List<Shipment> findByDestinationLab(String destinationLab);
    Optional<Shipment> findByShipmentNumber(String shipmentNumber);
    Optional<Shipment> findByTrackingNumber(String trackingNumber);
}