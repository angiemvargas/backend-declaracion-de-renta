package co.com.udea.backend.model.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String facebookId;
    private String googleId;
    private String email;
    private String firstName;
    private String lastName;
    private String documentId;
    private String documentType;

}
