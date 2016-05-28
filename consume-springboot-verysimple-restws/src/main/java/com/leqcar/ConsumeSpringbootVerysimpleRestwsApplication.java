package com.leqcar;

import com.leqcar.domain.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumeSpringbootVerysimpleRestwsApplication implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(ConsumeSpringbootVerysimpleRestwsApplication.class, args);
	}

	//Consume random quote from a rest service ( http://gturnquist-quoters.cfapps.io/api/random )
	@Override
	public void run(String... strings) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random ", Quote.class);
        logger.info(quote.toString());
	}
}
