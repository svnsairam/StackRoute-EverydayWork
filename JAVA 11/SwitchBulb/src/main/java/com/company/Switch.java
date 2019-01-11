package com.company;

public class Switch {


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
