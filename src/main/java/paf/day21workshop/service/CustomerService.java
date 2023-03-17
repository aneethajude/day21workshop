package paf.day21workshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paf.day21workshop.repository.CustomerRepository;
import java.util.List;
import paf.day21workshop.model.Customers;
import paf.day21workshop.model.Orders;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository custRepo;

    public List<Customers> getattributesRepo(){

        return custRepo.getattributes();
    }
    public List<Customers> getattributesRepoWithLimitOffset(int limit,int offset){

        return custRepo.getattributesWithLimitOffset(limit,offset);
    }

    public Customers getRepCustomerById(int id){

        return custRepo.getCustomerById(id); 

    }

    public List<Orders> getOrdersbycustId(int custid){

        return custRepo.getOrdersbyCustomerId(custid);
    }

}
