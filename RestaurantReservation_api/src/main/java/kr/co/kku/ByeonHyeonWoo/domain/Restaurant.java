package kr.co.kku.ByeonHyeonWoo.domain;

public class Restaurant {

    private String name;
    private String address;

    public Restaurant(String name,String address){
        this.name = name;
        this.address = address;
    }



    public String getName() {
        return "test";
    }

    public String getInformation() {
        return name+" in "+address;
    }
}
