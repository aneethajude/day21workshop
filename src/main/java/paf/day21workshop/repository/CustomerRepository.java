package paf.day21workshop.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import paf.day21workshop.model.Customers;
import paf.day21workshop.model.Orders;

@Repository
public class CustomerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String findattributesSQL="select id,company,first_name,last_name,email_address,job_title,business_phone from customers";

    private final String findattributesbyIdSQL="select id,company,first_name,last_name,business_phone from customers where id=?";

    private final String findAllAttributesSQL="select * from customers where id = ?";

    private final String findattributesWithLimitOffsetSQL ="select * from customers limit ? offset ?";

    private final String findByCustomerIdSQL="select id,ship_name,shipped_date from orders where customer_id = ?";
   
    public List<Customers> getattributes(){

        
        final List<Customers> custList = new ArrayList<Customers>();
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(findattributesSQL);

        while(rs.next()){
            Customers cust = new Customers();
            cust.setId(rs.getInt("id"));
            cust.setCompany(rs.getString("company"));
            cust.setFirstName(rs.getString("first_name"));
            cust.setLastName(rs.getString("last_name"));
            cust.setEmail_address(rs.getString("email_address"));
            cust.setJobTitle(rs.getString("job_title"));
            cust.setBusinessPhone(rs.getString("business_phone"));
            custList.add(cust);

        }

        return Collections.unmodifiableList(custList);
    }

    public List<Customers> getattributesWithLimitOffset(int limit,int offset){

        final List<Customers> custList = new ArrayList<Customers>();
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(findattributesWithLimitOffsetSQL, limit,offset);

        while(rs.next()){
            Customers cust = new Customers();
            cust.setId(rs.getInt("id"));
            cust.setCompany(rs.getString("company"));
            cust.setFirstName(rs.getString("first_name"));
            cust.setLastName(rs.getString("last_name"));         
            cust.setBusinessPhone(rs.getString("business_phone"));
            custList.add(cust);

        }

        return Collections.unmodifiableList(custList);
    }

    public Customers getCustomerById(int id){

        return jdbcTemplate.queryForObject(findattributesbyIdSQL, BeanPropertyRowMapper.newInstance(Customers.class),id);
        

    }

    public List<Orders> getOrdersbyCustomerId(int custid){

        final List<Orders> orderList = new ArrayList<Orders>();
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(findByCustomerIdSQL, custid);

        while(rs.next()){
            Orders order = new Orders();
            order.setId(rs.getInt("id"));
            order.setShipName(rs.getString("ship_name"));
            LocalDateTime shipdate = (LocalDateTime)rs.getObject("shipped_date");
           order.setShippedDate(shipdate);
            orderList.add(order);
        }

     

        return Collections.unmodifiableList(orderList);
    }

    
}
