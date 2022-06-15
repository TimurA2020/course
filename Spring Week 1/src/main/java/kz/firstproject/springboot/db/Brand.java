package kz.firstproject.springboot.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Brand {
    private Long id;
    private String name;
    private String country;
}
