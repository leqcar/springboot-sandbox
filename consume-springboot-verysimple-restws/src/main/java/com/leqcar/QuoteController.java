package com.leqcar;

import com.leqcar.domain.Quote;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jongtenerife on 28/12/2016.
 */
@RestController
@RequestMapping("/quotes")
public class QuoteController {

    @GetMapping
    public String quoteOftheDay() {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random ", Quote.class);
        return quote.toString();
    }
}
