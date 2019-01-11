package com.company;

public class Bulb {


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
