package htw.kbe.priceservice.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Component {
    int id;
    String name;
    String description;
    String componentGroup;
    String nutriscore;
    boolean vegan;
    int price;

}
