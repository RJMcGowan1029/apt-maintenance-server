package com.raheem.mcgowan.maintanencerequestserver.domain.maintenanceRequest.services;

import com.raheem.mcgowan.maintanencerequestserver.domain.core.exceptions.ResourceCreationException;
import com.raheem.mcgowan.maintanencerequestserver.domain.core.exceptions.ResourceNotFoundException;
import com.raheem.mcgowan.maintanencerequestserver.domain.maintenanceRequest.models.MaintenanceRequest;
import com.raheem.mcgowan.maintanencerequestserver.domain.maintenanceRequest.repos.MaintenanceRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceRequestServiceImpl implements MaintenanceRequestService{
    private MaintenanceRequestRepo maintenanceRequestRepo;

    @Autowired
    public MaintenanceRequestServiceImpl(MaintenanceRequestRepo maintenanceRequestRepo){
        this.maintenanceRequestRepo = maintenanceRequestRepo;
    }


    @Override
    public MaintenanceRequest create(MaintenanceRequest maintenanceRequest) throws ResourceCreationException {
        Optional<MaintenanceRequest> optional = maintenanceRequestRepo.findByEmail(maintenanceRequest.getEmail());
        if (optional.isPresent())
            throw new ResourceCreationException("Employee with email exists: " + maintenanceRequest.getEmail());
        maintenanceRequest = maintenanceRequestRepo.save(maintenanceRequest);
        return maintenanceRequest;
    }

    @Override
    public MaintenanceRequest getById(Long id) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = maintenanceRequestRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nobody With the Id: " + id));
        return maintenanceRequest;
    }

    @Override
    public MaintenanceRequest getByEmail(String email) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = maintenanceRequestRepo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Nobody With the Email: " + email));
        return maintenanceRequest;
    }

    @Override
    public List<MaintenanceRequest> getAll() {
        return maintenanceRequestRepo.findAll();
    }

    @Override
    public MaintenanceRequest update(Long id, MaintenanceRequest maintenanceRequestDetail) {
        MaintenanceRequest maintenanceRequest = getById(id);
        maintenanceRequest.setFirstName(maintenanceRequestDetail.getFirstName());
        maintenanceRequest.setLastName(maintenanceRequestDetail.getLastName());
        maintenanceRequest.setEmail(maintenanceRequestDetail.getEmail());
        maintenanceRequest.setAptNumber(maintenanceRequestDetail.getAptNumber());
        maintenanceRequest.setDescription(maintenanceRequestDetail.getDescription());
        return maintenanceRequest;
    }

    @Override
    public void delete(Long id) {
        MaintenanceRequest maintenanceRequest = getById(id);
        maintenanceRequestRepo.delete(maintenanceRequest);
    }
}
