package com.bankaccountkata;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("com.bankaccountkata")
@Import({RestTemplate.class})
public class BankAccountKataApplicationTests {

}
