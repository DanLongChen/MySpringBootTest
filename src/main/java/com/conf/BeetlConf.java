package com.conf;

import javax.annotation.PostConstruct;

import org.beetl.core.GroupTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author:DanLongChen
 * @versioin:2018年11月21日下午3:48:23
 **/
@Configuration
public class BeetlConf {
	@Autowired
	GroupTemplate groupTemplate;

	@PostConstruct
	public void config() {
		groupTemplate.getSharedVars().put("version", "1.2.3");
	}
}
