import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 class Switch {

    private String  switchId;
    private String  status;

    public Switch(String switchId, String status){
        this.switchId = switchId;
        this.status   = status;
    }

    public String   getSwitchId(){
        return this.switchId;
    }
    public String   getStatus(){
        return this.status;
    }
    public void    setStatus(String status){
         this.status =status ;
    }

}
 class Bulb {

    private String  bulbId;
    private String  bulbStatus;

    public Bulb(String bulbId,String bulbStatus){
        this.bulbId = bulbId;
        this.bulbStatus =   bulbStatus;
    }

    public String   getSwitchId(){
        return this.bulbId;
    }

     public String getBulbStatus(){
         return this.bulbStatus;
     }
     public void setBulbStatus(String status){
        this.bulbStatus = status;
     }

}

class ConnectBulbWithSwitch {

    private Map<Switch,Bulb> map  =   new HashMap<>();

    public ConnectBulbWithSwitch(Map<Switch,Bulb> map){
        this.map    =   map;
        setConnectionsProperly();
    }

    public Map<Switch,Bulb>  getConnectionsList(){
        return this.map;
    }

    public void setConnectionsProperly(){
        //  sets the connections properly. i.e bulb's status = switch's status
    }

}

class ChangeState{
    ConnectBulbWithSwitch connectBulbWithSwitch;

     ChangeState(ConnectBulbWithSwitch connectBulbWithSwitch){
         this.connectBulbWithSwitch=connectBulbWithSwitch;
     }

    public boolean changeState(Switch aswitch){
        String currentState    =   aswitch.getStatus();
        if(currentState.equals("on")){
            aswitch.setStatus("off");
           Bulb connectedBuld = connectBulbWithSwitch.getConnectionsList().get(aswitch);
           connectedBuld.setBulbStatus("off");
        }else {
            aswitch.setStatus("on");
            Bulb connectedBuld = connectBulbWithSwitch.getConnectionsList().get(aswitch);
            connectedBuld.setBulbStatus("on");
        }
        return true;
    }
}

public  class Main {
    public static void main(String  ar[]){
        Switch  switch1 =   new Switch("s101","on");
        Switch  switch2 =   new Switch("s102","off");

        Bulb    bulb1   =   new Bulb("b101","off");
        Bulb    bulb2   =   new Bulb("b102","off");

        Map<Switch,Bulb> map    = new HashMap<>();
        map.put(switch1,bulb1);
        map.put(switch2,bulb2);

        ConnectBulbWithSwitch   connectBulbWithSwitch   =   new ConnectBulbWithSwitch(map);

        System.out.println("Status switch1 before change "+ switch1.getStatus());
        System.out.println("Status switch2 before change "+ switch2.getStatus());
        System.out.println("Status bulb1 before change "+ bulb1.getBulbStatus());
        System.out.println("Status bulb2 before change "+ bulb2.getBulbStatus());


        ChangeState changeState = new ChangeState(connectBulbWithSwitch);

        changeState.changeState(switch1);
        changeState.changeState(switch2);

        System.out.println("Status switch1 after change "+ switch1.getStatus());
        System.out.println("Status switch2 after change "+ switch2.getStatus());
        System.out.println("Status bulb1 before change "+ bulb1.getBulbStatus());
        System.out.println("Status bulb2 before change "+ bulb2.getBulbStatus());

    }
}