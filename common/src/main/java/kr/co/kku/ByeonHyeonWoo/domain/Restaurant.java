package kr.co.kku.ByeonHyeonWoo.domain;

//import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    @NotNull
    private Long categoryId;

    @NotEmpty
    private String name;

    @NotEmpty
    private String address;

    @Transient //엔티티 클래스 내의 특정 변수를 영속 필드에서 제외할 때 사용함.
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<MenuItem> menuItems;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ArrayList<Review> reviews;


    public String getInformation() {
        return name+" in "+address;
    }


    public void updateInformation(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void setMenuItems(List<MenuItem> menuItems) {

        this.menuItems = new ArrayList<>(menuItems);

    }

    public void setReviews(List<Review> reviews) {
        this.reviews = new ArrayList<>(reviews);
    }
}
