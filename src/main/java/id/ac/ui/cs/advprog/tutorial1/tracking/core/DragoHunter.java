package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.ArrayList;
import java.util.List;

public class DragoHunter implements RoadUser {

    private String name;
    private int speed;
    private List<String> allowedRoutes = new ArrayList<>();
    private List<String> allRoutes = new ArrayList<>();
    private boolean isDrago = false;
    /*
        speed: the speed of the courier
        allowedRoutes: name of all possible routes this courier can visit
    */
    public DragoHunter(String name, int speed, List<String> allowedRoutes) {
        this.name = name;
        this.speed = speed;
        this.allowedRoutes.addAll(allowedRoutes);
        this.allRoutes.addAll(allowedRoutes);
    }

    @Override
    public void handleNotification(String notificationFrom, String location) {
        if(notificationFrom.equals("Drago Monitor")) {
            if(location.equals("None")) {
                isDrago = false;
                allowedRoutes.clear();
                allowedRoutes.addAll(allRoutes);
                return;
            }
            isDrago = true;
            allowedRoutes.clear();
            allowedRoutes.add(location);
        }
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getAllowedRoutes(){ return this.allowedRoutes; }
    
}
