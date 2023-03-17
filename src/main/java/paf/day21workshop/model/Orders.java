package paf.day21workshop.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.TimeZone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    private Integer id;
   // private Integer employeeId;
    private Integer customerId;
    private LocalDateTime orderDate;
    private LocalDateTime shippedDate;
    private String shipName;

    
}
