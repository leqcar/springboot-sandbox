package com.leqcar;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leqcar.domain.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by JONGT on 5/29/2016.
 */
public class ObjectMapperDemo {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public Employee readJsonWithObjectMapper() throws IOException, URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();
        URL resource = getClass().getResource("/jsonfile/employee.json");
        Employee employee = objectMapper.readValue(new File(resource.toURI()), Employee.class);
        logger.info(employee.toString());
        return employee;
    }
}
