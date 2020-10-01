package kr.co.kku.ByeonHyeonWoo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity //클래스와 테이블과 매핑한다고 JPA에게 알려
public class Restaurant {

    @Id //엔티티 클래스의 필드를 테이블에 기본키로 매핑한다.
    @GeneratedValue //자동으로 식별자 생성
    private Long id;

    private String name;
    private String address;

    @Transient
    private List<MenuItem> menuItems = new ArrayList<MenuItem>();

    public Restaurant(){

    }

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Restaurant(Long id,String name,String address){
        this.id = id;
        this.name = name;
        this.address = address;

    }

    public void setId(long id) {
        this.id = id;
    }


    public Long getId(){
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

    public List<MenuItem> getMenuItems(){
        return menuItems;
    }


    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }


    public void setMenuItems(List<MenuItem> menuItems) {
        for (MenuItem menuItem : menuItems){
            addMenuItem(menuItem);
        }
    }


    public void updateInformation(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
