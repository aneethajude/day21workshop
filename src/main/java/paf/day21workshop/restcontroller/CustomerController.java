package paf.day21workshop.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import paf.day21workshop.model.Customers;
import paf.day21workshop.model.Orders;
import paf.day21workshop.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService custSvc;

    @GetMapping
    public List<Customers> getattributespart(){

        return custSvc.getattributesRepo();

    }

    @GetMapping("/limit")
    public List<Customers> getattributespartWithLimitOffset(@RequestParam("limit") int limit,@RequestParam("offset") int offset ){

        return custSvc.getattributesRepoWithLimitOffset(limit,offset);

    }

    @GetMapping("/{id}")
    public Customers getattributebyId(@PathVariable int id){

        return custSvc.getRepCustomerById(id);
    }

    @GetMapping("/orders/{id}")
    public List<Orders> getattributebyCustId(@PathVariable int id){

        return custSvc.getOrdersbycustId(id);
    }
    
}
