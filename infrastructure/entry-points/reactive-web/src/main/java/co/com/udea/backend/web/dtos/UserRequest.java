package co.com.udea.backend.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String idGoogle;
    private String email;
    private String firstName;
    private String lastName;
    private String documentId;
    private String documentType;
    private String phoneNumber;
}
