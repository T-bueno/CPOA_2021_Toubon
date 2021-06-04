package com.iut.as2021.tools;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class Loader {

	public static Properties getProperties(String fileName) throws IOException {
		return PropertiesLoaderUtils.loadProperties(new ClassPathResource(fileName));
	}
}
