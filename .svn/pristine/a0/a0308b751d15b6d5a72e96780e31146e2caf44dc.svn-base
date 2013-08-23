package com.boventech.cms.namegenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

public class ServiceBeanNameGenerator extends AnnotationBeanNameGenerator{

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceBeanNameGenerator.class);
	
	private static final String SERVICE_IMPL = "ServiceImpl";

	public String generateBeanName(BeanDefinition definition,
			BeanDefinitionRegistry registry) {
		String beanName = super.generateBeanName(definition, registry);
		if(beanName != null && beanName.endsWith(SERVICE_IMPL))
			beanName = beanName.substring(0, beanName.length()-4);
		LOGGER.info("Service Bean Name Generator generates:" + beanName);
		return beanName;
	}
}
