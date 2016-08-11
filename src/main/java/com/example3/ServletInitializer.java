//package com.example3;
//
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.support.SpringBootServletInitializer;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.support.SpringBootServletInitializer;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
//@Configuration
//@EnableAutoConfiguration
//@EnableJpaRepositories(basePackages={"com.course.repository"})
//@EntityScan(basePackages={"com.course.app"})
//@ComponentScan(basePackages={"com.course.exceptions","com.course.rest","com.course.restapp.validations","com.course.service"})
//
//
//public class ServletInitializer extends SpringBootServletInitializer {
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(CourseAppMvcApplication.class);
//	}
//
//}
//
//
////import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
////import org.springframework.boot.autoconfigure.domain.EntityScan;
////import org.springframework.boot.builder.SpringApplicationBuilder;
////import org.springframework.boot.web.support.SpringBootServletInitializer;
////import org.springframework.context.annotation.ComponentScan;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
//
////@Configuration
////@EnableAutoConfiguration
////@EnableJpaRepositories(basePackages={"com.course.repository"})
////@EntityScan(basePackages={"com.course.app"})
////@ComponentScan(basePackages={"com.course.exceptions","com.course.rest","com.course.restapp.validations","com.course.service"})
//
//
////public class ServletInitializer extends SpringBootServletInitializer {
////
//// @Override
//// protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
////  return application.sources(CourseAppMvcApplication.class);
//// }
////
////}