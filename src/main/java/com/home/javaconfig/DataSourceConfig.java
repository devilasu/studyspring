package com.home.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * DB와 연동해서 데이터 교환을 위한 설정 클래스
 * @author 김영제
 *
 */

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {	
	
	/**
	 * 데이터 소스 설정
	 * @return
	 * @throws Exception
	 */
	@Bean
	public DriverManagerDataSource dataSource() throws Exception{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521/XE");
		dataSource.setUsername("studydb");
		dataSource.setPassword("apmsetup");
		return dataSource;
	}
	
	/**
	 * 트랜잭션 매니저 등록
	 * @return
	 * @throws Exception 
	 */
	@Bean
	public DataSourceTransactionManager transactionManager() throws Exception {
		return new DataSourceTransactionManager(dataSource());
	}

}
