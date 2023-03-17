package paf.day21workshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customers {

    private Integer id;
    private String company;
    private String firstName;
    private String lastName;
    private String email_address;
    private String jobTitle;
    private String businessPhone;
    private String homePhone;
    private String mobliePhone;
   // private String faxNumber;
    //private String address;//longtext
    // private String city;
    // private String stateProvince;
    // private String zipPostalCode;
    // private String countryRegion;
    // private String webPage;//longtext
    // private String notes;//longtext

//attachments longblob

}
