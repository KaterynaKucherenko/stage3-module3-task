//package com.mjc.school.main;
//
//import com.mjc.school.repository.model.AuthorModel;
//import com.mjc.school.repository.model.NewsModel;
//import com.mjc.school.repository.model.TagModel;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.service.Service;
//import org.hibernate.service.ServiceRegistry;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class HibernateConfiguration {
//
////@Bean
////    public SessionFactory sessionFactory(){
////
////    if(sessionFactory!=null){
////        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
////        MetadataSources sources = new MetadataSources(registry);
////        sources.addAnnotatedClass(AuthorModel.class);
////        sources.addAnnotatedClass(NewsModel.class);
////        sources.addAnnotatedClass(TagModel.class);
////        sessionFactory = sources.buildMetadata().buildSessionFactory();}
////    return sessionFactory;}
//@Bean
//public DataSource dataSource(){
//    DriverManagerDataSource dataSource= new DriverManagerDataSource();
//    dataSource.setDriverClassName("org.postgresql.Driver");
//    dataSource.setUrl("jdbc:postgresql://localhost:5432/news");
//    dataSource.setUsername("news");
//    dataSource.setPassword("password");
//return dataSource;
//}
//
//
//
//}
