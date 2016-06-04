package com.leqcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.leqcar.domain.Account;
import com.leqcar.domain.Card;
import com.leqcar.repository.AccountRepository;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Bean
	CommandLineRunner dummyAccount(AccountRepository accountRepository) {
		return arg -> {

			Account fooAccount = new Account("Foo", "12345");
			Account booAccount = new Account("Boo", "67890");


			Card cardA = new Card("A12345");
			Card cardB = new Card("B67890");
			List<Card> fooCards = new ArrayList<>();
			fooCards.add(cardA);
			fooCards.add(cardB);
			fooAccount.setCards(fooCards);


			Card cardC = new Card("C12345");
			Card cardD = new Card("D67890");

			List<Card> booCards = new ArrayList<>();
			booCards.add(cardC);
			booCards.add(cardD);
			booAccount.setCards(booCards);

			Arrays.asList(fooAccount, booAccount).forEach(list -> accountRepository.save(list));
			accountRepository.findAll().forEach(System.out::println);

		};
	}


}
