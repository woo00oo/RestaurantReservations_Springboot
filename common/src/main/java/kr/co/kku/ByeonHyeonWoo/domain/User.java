package kr.co.kku.ByeonHyeonWoo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Setter
    private String email;

    @NotEmpty
    @Setter
    private String name;

    @NotNull
    @Setter
    private Long level;

    private String password;


    public boolean isAdmin() {
        return level >= 100;
    }

    public boolean isActive() {
        return level > 0;
    }

    public void deativate() {
        level = 0L;
    }
}
