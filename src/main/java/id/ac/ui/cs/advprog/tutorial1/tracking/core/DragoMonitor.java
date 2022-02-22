package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DragoMonitor implements EventMonitor {

    private List<RoadUser> subscriber = new ArrayList<>();;
    @Override
    public void addRoadUser(RoadUser roadUser) {
        subscriber.add(roadUser);
    }

    @Override
    public void notifyRoadUsers(String newDragoLocation) {
        Iterator<RoadUser> iterator = subscriber.iterator();
        while (iterator.hasNext()){
            iterator.next().handleNotification(this.getName(), newDragoLocation);
        }
    }

    @Override
    public String getName() {
        return "Drago Monitor";
    }
    
}
