package kr.co.kku.ByeonHyeonWoo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity //클래스와 테이블과 매핑한다고 JPA에게 알려줌
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id //엔티티 클래스의 필드를 테이블에 기본키로 매핑한다.
    @GeneratedValue //자동으로 식별자 생성
    @Setter
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String address;

    @Transient
    private List<MenuItem> menuItems;

//    public Restaurant(String name, String address) {
//        this.name = name;
//        this.address = address;
//    }
//
//    public Restaurant(Long id,String name,String address){
//        this.id = id;
//        this.name = name;
//        this.address = address;
//
//    }

    public String getInformation() {
        return name+" in "+address;
    }


    public void setMenuItems(List<MenuItem> menuItems) {

        this.menuItems = new ArrayList<>(menuItems);

    }

    public void updateInformation(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
