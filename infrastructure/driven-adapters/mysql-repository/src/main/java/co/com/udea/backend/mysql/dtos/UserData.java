package co.com.udea.backend.mysql.dtos;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class UserData {

    @Id
    private Integer id;

    private String facebookId;

    private String googleId;

    private String email;

    private String firstName;

    private String lastName;

    private String documentId;

    private String documentType;

    private String phoneNumber;

    private String role;

}
