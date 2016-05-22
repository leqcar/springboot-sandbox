package com.leqcar.controller;

import com.leqcar.domain.Customer;
import com.leqcar.domain.User;
import com.leqcar.service.CrmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

/**
 * Created by jongtenerife on 23/05/2016.
 */
@Controller
@ExposesResourceFor(User.class)
@RequestMapping(value = "users",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private CrmService crmService;
    private ResourceAssembler<User, Resource<User>> userResourceAssembler;
    private ResourceAssembler<Customer, Resource<Customer>> customerResourceAssembler;

    @Autowired
    public UserController(CrmService crmService, ResourceAssembler<User, Resource<User>> userResourceAssembler, ResourceAssembler<Customer, Resource<Customer>> customerResourceAssembler) {
        this.crmService = crmService;
        this.userResourceAssembler = userResourceAssembler;
        this.customerResourceAssembler = customerResourceAssembler;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{user}")
    public ResponseEntity<Resource<User>> loadUser(@PathVariable Long user) {
        return Optional.of(crmService.findById(user))
                .map(u -> new ResponseEntity<>(userResourceAssembler.toResource(u), HttpStatus.OK))
                .orElse(new ResponseEntity<Resource<User>>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping (method = RequestMethod.GET, value = "/{user}/customers/{customer}")
    public HttpEntity<Resource<Customer>> loadSingleUserCustomer(@PathVariable Long user, @PathVariable Long customer ) {
        Resource<Customer> customerResource = customerResourceAssembler.toResource( this.crmService.findCustomerById(customer ));
        return new ResponseEntity<Resource<Customer>>(customerResource, HttpStatus.OK);
    }
}
