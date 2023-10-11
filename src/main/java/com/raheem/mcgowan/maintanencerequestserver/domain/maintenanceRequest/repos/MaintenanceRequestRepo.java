package com.raheem.mcgowan.maintanencerequestserver.domain.maintenanceRequest.repos;

import com.raheem.mcgowan.maintanencerequestserver.domain.maintenanceRequest.models.MaintenanceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaintenanceRequestRepo extends JpaRepository<MaintenanceRequest, Long> {
    Optional<MaintenanceRequest> findByEmail(String email);

}
