package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author:DanLongChen
 * @versioin:2018年11月19日上午9:56:47
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Ch3Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		SpringApplication.run(Ch3Application.class, args);
	}

}
