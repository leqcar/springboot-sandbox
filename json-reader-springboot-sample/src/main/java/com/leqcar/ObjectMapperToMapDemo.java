package com.leqcar;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by JONGT on 5/29/2016.
 */
public class ObjectMapperToMapDemo {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public void readJsonWithObjectMapper() throws URISyntaxException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        URL resource = getClass().getResource("/jsonfile/employee.json");

        Map<?,?> empMap = objectMapper.readValue(new File(resource.toURI()), Map.class);
        for (Map.Entry<?, ?> entry: empMap.entrySet()) {
            logger.info("\n----------------------------\n"+entry.getKey() + "=" + entry.getValue()+"\n");
        }

    }
}
