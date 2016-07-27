package com.wardrobe.planner.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.wardrobe.planner.dao.ColorDao;
import com.wardrobe.planner.dao.ColorDaoImpl;
import com.wardrobe.planner.dao.ItemsDao;
import com.wardrobe.planner.dao.ItemsDaoImpl;
import com.wardrobe.planner.model.Categories;
import com.wardrobe.planner.model.Colors;
import com.wardrobe.planner.model.Items;
import com.wardrobe.planner.model.Material;
import com.wardrobe.planner.model.Collection;

@Configuration
@ComponentScan("com.wardrobe.planner.*")
@EnableWebMvc
@EnableTransactionManagement
public class ApplicationContextConfig {
   /* @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
   */
	
//	  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//	    configurer.defaultContentType(MediaType.ALL);
//	  }
    
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
    	dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
    	dataSource.setUsername("system");
    	dataSource.setPassword("Oracle_1");
    	
    	return dataSource;
    }
    
    
    private Properties getHibernateProperties() {
    	Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
    	properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
    	properties.put("hibernate.hbm2ddl.auto", "update");
    	
    	return properties;
    }
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	sessionBuilder.addAnnotatedClasses(Colors.class,Categories.class, Items.class, Collection.class, Material.class);
    	return sessionBuilder.buildSessionFactory();
    }
    
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}
    
    @Autowired
    @Bean(name = "colorDao")
    public ColorDao getColorDao(HibernateTemplate hibernateTemplate) {
    	return new ColorDaoImpl(hibernateTemplate);
    }
    
    @Autowired
    @Bean(name = "itemsDao")
    public ItemsDao getItemsDao(HibernateTemplate hibernateTemplate) {
    	return new ItemsDaoImpl(hibernateTemplate);
    }
    
    @Autowired
    @Bean(name = "hibernateTemplate")
    public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory){
    	return new HibernateTemplate(sessionFactory);
    }
}
