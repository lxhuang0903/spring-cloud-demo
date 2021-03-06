package com.yc;

import com.yc.entity.Account;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RefreshScope
@EnableEurekaClient
public class AccountServiceApplication {

	@Value("${description}")
	private String description;
	@Value("${password:}")
	private String password;

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@RequestMapping("/index")
	public String index(){
		return description;
	}

	@RequestMapping("/password")
	public String getPassword(){
		return password;
	}

	@RequestMapping("/account")
	public Account getAccount(){
		return new Account("yuchao", "password");
	}
}
