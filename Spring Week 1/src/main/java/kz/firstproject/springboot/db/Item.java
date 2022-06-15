package kz.firstproject.springboot.db;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Long id;
    private String name;
    private String description;
    private double price;
    Brand brand;
}
