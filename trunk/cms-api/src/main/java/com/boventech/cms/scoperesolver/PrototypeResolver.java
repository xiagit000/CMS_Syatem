package com.boventech.cms.scoperesolver;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationScopeMetadataResolver;
import org.springframework.context.annotation.ScopeMetadata;

public class PrototypeResolver extends AnnotationScopeMetadataResolver{

	@Override
	public ScopeMetadata resolveScopeMetadata(BeanDefinition definition) {
		ScopeMetadata metadata = super.resolveScopeMetadata(definition);
		metadata.setScopeName(BeanDefinition.SCOPE_PROTOTYPE);
		return metadata;
	}

}
