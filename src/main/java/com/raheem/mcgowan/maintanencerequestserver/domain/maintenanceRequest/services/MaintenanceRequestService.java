package com.raheem.mcgowan.maintanencerequestserver.domain.maintenanceRequest.services;
import com.raheem.mcgowan.maintanencerequestserver.domain.core.exceptions.ResourceCreationException;

import com.raheem.mcgowan.maintanencerequestserver.domain.core.exceptions.ResourceNotFoundException;
import com.raheem.mcgowan.maintanencerequestserver.domain.maintenanceRequest.models.MaintenanceRequest;

import java.util.List;

public interface MaintenanceRequestService {

    MaintenanceRequest create(MaintenanceRequest maintenanceRequest) throws ResourceCreationException;

    MaintenanceRequest getById(Long id) throws ResourceNotFoundException;

    MaintenanceRequest getByEmail(String email) throws  ResourceNotFoundException;

    List<MaintenanceRequest> getAll();

    MaintenanceRequest update(Long id, MaintenanceRequest maintenanceRequestDetail);

    void delete(Long id);
}
