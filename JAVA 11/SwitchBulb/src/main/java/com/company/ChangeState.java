package com.company;

public class ChangeState {
    ConnectBulbWithSwitch connectBulbWithSwitch;

    ChangeState(ConnectBulbWithSwitch connectBulbWithSwitch) {
        this.connectBulbWithSwitch = connectBulbWithSwitch;
    }

    public boolean changeState(Switch aswitch) {
        String currentState = aswitch.getStatus();
        if (currentState.equals("on")) {
            aswitch.setStatus("off");
            Bulb connectedBuld = connectBulbWithSwitch.getConnectionsList().get(aswitch);
            connectedBuld.setBulbStatus("I am not glowing");
        } else {
            aswitch.setStatus("on");
            Bulb connectedBuld = connectBulbWithSwitch.getConnectionsList().get(aswitch);
            connectedBuld.setBulbStatus("I am glowing");
        }
        return true;
    }
}
