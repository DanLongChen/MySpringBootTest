package com.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

/**
 * @author:DanLongChen
 * @versioin:2018年11月19日下午8:30:58
 **/
@Service
@ConfigurationProperties(prefix = "server")
public class Server {
	public String port;

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

}
