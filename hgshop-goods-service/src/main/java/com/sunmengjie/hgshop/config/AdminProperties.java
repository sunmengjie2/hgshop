/**   
 *
 */
package com.sunmengjie.hgshop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 配置类读取属性文件
 * @author Administrator
 *
 */
@Configuration
@PropertySource("classpath:hgshop-admin.properties")
public class AdminProperties {

	@Value("${admin.name}")
	String admingName;
	@Value("${admin.pwd}")
	String password;
	public String getAdmingName() {
		return admingName;
	}
	public void setAdmingName(String admingName) {
		this.admingName = admingName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
