package com.iut.as2021.config;

import static com.iut.as2021.config.IutConstants.PAGE_DIRECTORY;
import static com.iut.as2021.config.IutConstants.PAGE_TYPE_EXTENSION;
import static com.iut.as2021.config.IutConstants.RESOURCE_HANDLER;
import static com.iut.as2021.config.IutConstants.RESOURCE_LOCATION;
import static org.springframework.context.annotation.EnableLoadTimeWeaving.AspectJWeaving.ENABLED;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.LoadTimeWeavingConfigurer;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.instrument.classloading.ReflectiveLoadTimeWeaver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

// -------------------------------------
// Specifies the class as configuration.
// -------------------------------------
@Configuration
@ComponentScan({ "com.iut.as2021.config", "com.iut.as2021.controller", "com.iut.as2021.facade", "com.iut.as2021.metier",
		"com.iut.as2021.dao", "com.iut.as2021.dao.mysql" })
@EnableAspectJAutoProxy
@EnableSpringConfigured
@EnableLoadTimeWeaving(aspectjWeaving = ENABLED)
public class WebApplicationConfig<FilterRegistrationBean> extends WebMvcConfigurationSupport
		implements LoadTimeWeavingConfigurer {

	/* Mise en place du répertoire contenant les JSP. */
	@Bean
	public ViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix(PAGE_DIRECTORY);
		resolver.setSuffix(PAGE_TYPE_EXTENSION);
		return resolver;
	}

	/*
	 * Mise en place des répertoires de ressources - fichier de configuration et
	 * 'css'.
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(RESOURCE_HANDLER).addResourceLocations(RESOURCE_LOCATION);
	}

	@Override
	public LoadTimeWeaver getLoadTimeWeaver() {
		return new ReflectiveLoadTimeWeaver();
	}
}
