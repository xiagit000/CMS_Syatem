package com.boventech.cms.namegenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

public class DaoBeanNameGenerator extends AnnotationBeanNameGenerator{

	private static final Logger LOGGER = LoggerFactory.getLogger(DaoBeanNameGenerator.class);
	
	private static final String DAO_IMPL = "DaoImpl";

	public String generateBeanName(BeanDefinition definition,
			BeanDefinitionRegistry registry) {
		String beanName = super.generateBeanName(definition, registry);
		if(beanName != null && beanName.endsWith(DAO_IMPL))
			beanName = beanName.substring(0, beanName.length()-4);
		LOGGER.info("Dao Bean Name Generator generates:" + beanName);
		return beanName;
	}
}
