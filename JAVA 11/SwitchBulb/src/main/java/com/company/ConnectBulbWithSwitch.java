package com.company;

import java.util.HashMap;
import java.util.Map;

public class ConnectBulbWithSwitch {

    private Map<Switch, Bulb> map = new HashMap<>();

    public ConnectBulbWithSwitch(Map<Switch, Bulb> map) {
        this.map = map;
        setConnectionsProperly();
    }

    public Map<Switch, Bulb> getConnectionsList() {
        return this.map;
    }

    public void setConnectionsProperly() {
        //  sets the connections properly. i.e bulb's status = switch's status
    }

}