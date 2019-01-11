package com.company;

import java.util.HashMap;
import java.util.Map;

public  class Main {
    public static void main(String  ar[]){
        Switch  switch1 =   new Switch("s101","on");
        Switch  switch2 =   new Switch("s102","off");

        Bulb    bulb1   =   new Bulb("b101","I am not glowing");
        Bulb    bulb2   =   new Bulb("b102","I am not glowing");

        Map<Switch,Bulb> map    = new HashMap<>();
        map.put(switch1,bulb1);
        map.put(switch2,bulb2);

        ConnectBulbWithSwitch   connectBulbWithSwitch   =   new ConnectBulbWithSwitch(map);

        System.out.println("Status switch1 before change "+ switch1.getStatus());
        System.out.println("Status switch2 before change "+ switch2.getStatus());
        System.out.println("Status bulb1 before change "+ bulb1.getBulbStatus());
        System.out.println("Status bulb2 before change "+ bulb2.getBulbStatus());

        // Change the state of bulbs
        ChangeState changeState = new ChangeState(connectBulbWithSwitch);
        changeState.changeState(switch1);
        changeState.changeState(switch2);

        // Print the outputs
        System.out.println("Status switch1 after change "+ switch1.getStatus());
        System.out.println("Status switch2 after change "+ switch2.getStatus());
        System.out.println("Status bulb1 before change "+ bulb1.getBulbStatus());
        System.out.println("Status bulb2 before change "+ bulb2.getBulbStatus());

    }
}