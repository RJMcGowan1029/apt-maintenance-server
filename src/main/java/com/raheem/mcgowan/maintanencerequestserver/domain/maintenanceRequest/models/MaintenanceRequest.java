package com.raheem.mcgowan.maintanencerequestserver.domain.maintenanceRequest.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity // For JPA to save to database
@NoArgsConstructor // Generate our non argument constructor
@RequiredArgsConstructor
@Data // Generate our getters and setters

public class MaintenanceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private String aptNumber;

    @NonNull
    private String description;

    @NonNull
    private Date createAt;

    public String toString(){
        return String.format("%d %s %s %s %s %s %tF",id, firstName, lastName, email, aptNumber, description, createAt);
    }

}
