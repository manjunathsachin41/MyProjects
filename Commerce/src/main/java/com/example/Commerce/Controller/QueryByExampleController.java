package com.example.Commerce.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.Commerce.Model.Customer;
import jakarta.validation.Valid;
import com.example.Commerce.Service.CustomerServiceForExampleQuery;

@RestController
public class QueryByExampleController {

	@Autowired
	CustomerServiceForExampleQuery customerServiceForExampleQuery;
	
    @GetMapping("/search")
    public ResponseEntity<List<Customer>> searchCustomer(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {

        List<Customer> customers = customerServiceForExampleQuery
                .findCustomerWithCustomMatcher(name, email);
        return ResponseEntity.ok(customers);
    }
	
    @PostMapping("/search/example")
    public List<Customer> findByExample(@RequestBody @Valid Customer customer) {
        return customerServiceForExampleQuery.findEmployeesByExample(customer);
    }
    
 /* Example JSON 
    {
        "customerId": 102,
        "customerName": "Virender Sehway",
        "email": "virender@gmail.com",
        "phone": 987654322
    }
*/

    @PostMapping("/search/example/one")
    public Customer findOneByExample(@RequestBody @Valid Customer customer) {
        return customerServiceForExampleQuery.findOneEmployeeByExample(customer)
                .orElseThrow();
    }

    @PostMapping("/count")
    public long countByExample(@RequestBody @Valid Customer employee) {
        return customerServiceForExampleQuery.countCustomersByExample(employee);
    }

    @PostMapping("/exists")
    public boolean existsByExample(@RequestBody @Valid Customer employee) {
        return customerServiceForExampleQuery.existsByExample(employee);
    }
}
