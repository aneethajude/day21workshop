package paf.day21workshop.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    private final String findAllSQL ="select id,customer_id,order_date,shipped_date,ship_name from order";


}
