package com.mostafaabdel_fatah.volleydemo4;

/**
 * Created by Mostafa AbdEl_Fatah on 9/8/2017.
 */

public class Doctor {

    private  String name , spec , address,phone;

    public Doctor(String name, String spec, String address, String phone) {
        this.name = name;
        this.spec = spec;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getSpec() {
        return spec;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
