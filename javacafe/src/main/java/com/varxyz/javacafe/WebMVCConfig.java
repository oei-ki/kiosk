package com.varxyz.javacafe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration		//설정파일에
@EnableWebMvc		//스프링 MVC 설정에 대한 기본 구성 제공
@ComponentScan(basePackages = "com.varxyz.javacafe")
public class WebMVCConfig implements WebMvcConfigurer{
	
	//일단 밑에 메소드 다 경로를 줄이기 위한 칭구들
	
	/**
	 * DispatcherServlet의 매핑 경로를 "/"로 주었을 때, JSP/HTML/CSS 등을 바르게 처리하도록 한다.
	 * 옛날 스프링 방식 : <mvc : default-servler-handler>
	 * HTML/CSS의 경우 경로를 잘 못 찾기 때문에 기본값으로 오버라이드 해줘야 찾는다 함
	 */  
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurur) {
		configurur.enable();
	}
	
	/**
	 * 컨트롤러의 처리 결과를 jsp로 표시하기 위한 설정
	 * 이걸로 ("example1/hello") 앞 뒤를 다 잘라낸거임
	 * jsp경로를 간편하게 만든거
	 */
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	/**
	 * src/main/webapp/resources 위치의 정적 리소스를 설정
	 * 핸들러를 호출해야 하는 URL 경로 패턴을 제공("/resources/**")
	 * 이것도 리소스안에 있는 css나 js사용하려고 만들어 둔듯
	 * @param registry
	 */
	public void addResourceHandler(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
	   CommonsMultipartResolver resolver = new CommonsMultipartResolver();
	   resolver.setDefaultEncoding("utf-8");
	   return resolver;
	}
	
}