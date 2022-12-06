package com.immutable;

public class Address1 {//} extends Address{

    String address;
    Address1(String address) {
       // super(address);
        this.address= address;
    }

   // @Override
    public String getAddress(){
        return address;
    }
}
