package kr.co.kku.ByeonHyeonWoo.domain;

public class Restaurant {

    private Long id;
    private String name;
    private String address;

    public Restaurant(Long id,String name,String address){
        this.id = id;
        this.name = name;
        this.address = address;

    }


    public Long getID(){
        return  id;
    }

    public String getName() {
        return name;
    }

    public String getInformation() {
        return name+" in "+address;
    }

    public String getAddress() {
        return  address;
    }


}
