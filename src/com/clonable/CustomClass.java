package com.clonable;

import java.util.ArrayList;
import java.util.List;

public class CustomClass implements Cloneable {

    List<String> listOfObj;
    List<CustomObject> customObjList;

    CustomClass(List<String> listOfObj, List<CustomObject> customObjList){
        this.listOfObj =  listOfObj;
        this.customObjList = customObjList;
    }

    @Override
    public CustomClass clone() throws CloneNotSupportedException {
        CustomClass cc = (CustomClass) super.clone();
        cc.listOfObj = new ArrayList<>();
        cc.customObjList = new ArrayList<>();
        return cc;
    }


/*    public List<String> getListOfObj() {
        return listOfObj;
    }

    public void setListOfObj(List<String> listOfObj) {
        this.listOfObj = listOfObj;
    }

    public List<CustomObject> getCustomObjList() {
        return customObjList;
    }

    public void setCustomObjList(List<CustomObject> customObjList) {
        this.customObjList = customObjList;
    }*/

    @Override
    public String toString() {
        return "CustomClass{" +
                "listOfObj=" + listOfObj +
                ", customObjList=" + customObjList +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        List<String> listOfObj = new ArrayList<>();
        List<CustomObject> customObjList = new ArrayList<>();

        listOfObj.add("List Of Object");
        CustomObject co = new CustomObject("I am Custom Object");
        customObjList.add(co);

        CustomClass cc = new CustomClass(listOfObj, customObjList);
        System.out.println(cc);

        CustomClass cc1 = (CustomClass) cc.clone();
        cc1.listOfObj.add("List Of another Object");
        cc1.customObjList.add(co);
        System.out.println(cc1);

        System.out.println(cc);
    }
}

class CustomObject{
    private String nameOfClass;

    CustomObject(String name){
        this.nameOfClass = name;
    }


    /*protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }*/
    @Override
    public String toString() {
        return "CustomObject{" +
                "nameOfClass='" + nameOfClass + '\'' +
                '}';
    }
}
