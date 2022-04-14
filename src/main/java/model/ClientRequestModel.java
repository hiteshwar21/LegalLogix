package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRequestModel {
    private Integer clientId;
    private String clientName;
    private Integer advId;
    private String address;
    private Integer phoneNumber;
    private String email;

    //toString usage? why?
}
