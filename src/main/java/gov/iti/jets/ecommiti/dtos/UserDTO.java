package gov.iti.jets.ecommiti.dtos;

import lombok.Data;

@Data
public class UserDTO {
    private Integer id;
    private String username;
    private String phone;
    private String email;
    private String password;
    private Long walletBalance;
    private String address;
}
