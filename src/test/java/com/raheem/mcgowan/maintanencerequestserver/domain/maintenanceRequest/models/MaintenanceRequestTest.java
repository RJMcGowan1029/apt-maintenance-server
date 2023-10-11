package com.raheem.mcgowan.maintanencerequestserver.domain.maintenanceRequest.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class MaintenanceRequestTest {
    @Test
    public void constructorTest01(){
        Date date = new Date();
        MaintenanceRequest request = new MaintenanceRequest("RJ", "McGowan", "rj@gmail.com", "10", "jawn", date);
        request.setId(1L);

        String expected = "1 Demo User demo@user.com";
        String actual = request.toString();

        Assertions.assertEquals(expected, actual);
    }
}
