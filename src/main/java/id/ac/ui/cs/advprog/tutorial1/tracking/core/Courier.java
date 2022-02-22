package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.ArrayList;
import java.util.List;

public class Courier implements RoadUser {

    private String name;
    private int speed;
    private List<String> allowedRoutes = new ArrayList<>();
    private List<String> allRoutes = new ArrayList<>();
    private boolean isSweets = false;
    private String dragoLoc = null;

    /*
        speed: the speed of the courier
        allowedRoutes: name of all possible routes this courier can visit
    */
    public Courier(String name, int speed, List<String> allowedRoutes) {
        this.name = name;
        this.speed = speed;
        this.allowedRoutes.addAll(allowedRoutes);
        this.allRoutes.addAll(allowedRoutes);
    }

    @Override
    public void handleNotification(String notificationFrom, String location) {
        if(this.name.equals("Raiden's Lightning Express")) {
            if (notificationFrom.equals("Drago Monitor")) {
                if (location.equals("None")) {
                    dragoLoc = null;
                    if (isSweets == true) return;
                    this.allowedRoutes.clear();
                    this.allowedRoutes.addAll(allRoutes);
                    return;
                }
                if (isSweets == true) return;
                dragoLoc = location;
                this.allowedRoutes.clear();
                this.allowedRoutes.addAll(allRoutes);
                this.allowedRoutes.remove(location);
            } else if (notificationFrom.equals("Sweets Monitor")){
                if(location.equals("None")) {
                    this.isSweets = false;
                    this.allowedRoutes.clear();
                    this.allowedRoutes.addAll(allRoutes);
                    if(dragoLoc!=null) {
                        this.allowedRoutes.remove(dragoLoc);
                    }
                    return;
                }
                this.isSweets = true;
                this.allowedRoutes.clear();
                this.allowedRoutes.add(location);
            }
        } else {
            if (notificationFrom.equals("Drago Monitor")) {
                if (location.equals("None")) {
                    dragoLoc = null;
                    allowedRoutes.clear();
                    allowedRoutes.addAll(allRoutes);
                    return;
                }
                dragoLoc = location;
                this.allowedRoutes.clear();
                allowedRoutes.addAll(allRoutes);
                allowedRoutes.remove(location);
            }
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
