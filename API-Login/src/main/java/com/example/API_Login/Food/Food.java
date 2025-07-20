package com.example.API_Login.Food;

import jakarta.persistence.*;
import lombok.*;

@Table(name="foods")
@Entity(name="foods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Food {
    @Id@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private Integer price;
    private String email;
    private String senha;
    private String login;

    public Food(FoodRequestDTO data){
        this.image= data.image();
        this.price=data.price();
        this.title= data.title();

    }


}
