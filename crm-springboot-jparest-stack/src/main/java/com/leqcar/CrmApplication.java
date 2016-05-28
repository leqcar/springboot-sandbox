package com.leqcar;

import com.leqcar.controller.UserController;
import com.leqcar.domain.Customer;
import com.leqcar.domain.User;
import com.leqcar.repository.UserRepository;
import org.h2.server.web.WebServlet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import java.util.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by jongtenerife on 22/05/2016.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class CrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(UserRepository userRepository) {

        return arg -> {
            User user = new User();
            user.setFirstName("Jong");
            user.setLastName("Tenerife");
            user.setPassword("pazz");
            user.setSignupDate(new Date());
            user.setUsername("jongt");

            Set<Customer> customers = new HashSet<>();
            Customer me = new Customer();
            me.setId(null);
            me.setFirstName("Deriq");
            me.setLastName("Tenerife");
            me.setSignupDate(new Date());
            me.setUser(user);
            customers.add(me);
            user.setCustomers(customers);
            userRepository.save(user);

            userRepository.findAll().forEach(System.out::println);
        };
    }
/*    @Bean
    public MultipartResolver multipartResolver() {
        int maxUploadSizeInMb = 10 * 1024 * 1024; //10mb
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(maxUploadSizeInMb);

        return multipartResolver;
    }*/

    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

    @Bean
    ResourceAssembler<User, Resource<User>> userResourceAssembler() {
        return (u) -> {
            try {
                String customersRel = "customers", photoRel = "photo";
                User user = new User(u);
                user.setPassword(null);
                long userId = u.getId();
                Collection<Link> links = new ArrayList<Link>();
                links.add(linkTo(methodOn(UserController.class).loadUser(userId)).withSelfRel());
                //links.add(linkTo(methodOn(UserController.class).loadUserCustomers(userId)).withRel(customersRel));
                //links.add(linkTo(methodOn(UserProfilePhotoController.class).loadUserProfilePhoto(user.getId())).withRel(photoRel));
                return new Resource<>(user, links);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    @Bean
    ResourceAssembler<Customer, Resource<Customer>> customerResourceResourceAssembler() {
        return (customer) -> {
            String usersRel = "user";
            Class<UserController> controllerClass = UserController.class;
            Long userId = customer.getUser().getId();
            customer.setUser(null);
            Resource<Customer> customerResource = new Resource<>(customer);
            customerResource.add(linkTo(methodOn(controllerClass).loadSingleUserCustomer(
                    userId, customer.getId())).withSelfRel());
            customerResource.add(linkTo(methodOn(controllerClass).loadUser(userId)).withRel(usersRel));
            return customerResource;
        };
    }

    //Enables web based H2 database console.  Also, check out the application properties setting.
    @Bean
    ServletRegistrationBean h2ServletRegistration() {
        ServletRegistrationBean srb = new ServletRegistrationBean(new WebServlet());
        srb.addUrlMappings("/console/*");
        return srb;
    }
}
