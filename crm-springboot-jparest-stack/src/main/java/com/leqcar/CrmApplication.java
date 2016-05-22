package com.leqcar;

import com.leqcar.controller.UserController;
import com.leqcar.domain.Customer;
import com.leqcar.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import java.util.ArrayList;
import java.util.Collection;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by jongtenerife on 22/05/2016.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class CrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmApplication.class, args);
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
                long userId = user.getId();
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
}
