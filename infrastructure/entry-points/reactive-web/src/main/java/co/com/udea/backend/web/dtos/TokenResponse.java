package co.com.udea.backend.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponse {

    private String email;
    private List<String> roles;
    private String token;
    private String typeToken = "Bearer";
}
