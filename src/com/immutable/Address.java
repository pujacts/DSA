package com.immutable;

final public class Address {

    String address;

    Address(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public static void main(String[] args) {
        Address address = new Address("7 No");
        System.out.println(address.getAddress());

        Address1 address1 = new Address1("8 No");
        System.out.println(address1.getAddress());
    }
}
