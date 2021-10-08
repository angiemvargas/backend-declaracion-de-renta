package co.com.udea.backend.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Documment {

    private Integer id;
    private Integer userId;
    private String name;
    private String url;

}
