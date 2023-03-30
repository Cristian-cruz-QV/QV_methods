package com.qvision.peticiones.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;

//@EnableWebMvc
@Configuration
//public class MvcConfig {
public class MvcConfig implements WebMvcConfigurer {
   @Override
    public void addResourceHandlers(
      ResourceHandlerRegistry registry) {
 
        /*registry.addResourceHandler("/static/**")
          .addResourceLocations("/WEB-INF/view/react/build/static/");
        registry.addResourceHandler("/*.js")
          .addResourceLocations("/WEB-INF/view/react/build/");
        registry.addResourceHandler("/*.json")
          .addResourceLocations("/WEB-INF/view/react/build/");
        registry.addResourceHandler("/*.ico")
          .addResourceLocations("/WEB-INF/view/react/build/");*/
        registry.addResourceHandler("/*.css")
          .addResourceLocations("/WEB-INF/templates/css/");
   }
    
    
  /*@Bean
  ViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
	
	@Bean
	  ViewResolver getInternalResourceViewResolver() {
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("classpath:/templates/");
	        resolver.setSuffix(".html");
	        return resolver;
	    }*/
	@Bean
	SpringResourceTemplateResolver templateResolver() {
	    SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
	    templateResolver.setPrefix("/WEB-INF/templates/");
	    templateResolver.setSuffix(".html");
	    return templateResolver;
	}
	

}