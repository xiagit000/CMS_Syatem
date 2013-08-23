package com.boventech.permalink;

public class GenericPermalinkDefinition implements PermalinkDefinition{

	private String definition;
	private Class<?> type;
	private PermalinkVariable[] supportedVariables;

	private String definitionReguarExpr;

	public GenericPermalinkDefinition(Class<?> type, String definition, String string2) {
		this.type = type;
		this.definition = definition;
	}

	public Class<?> getType() {
		return this.type;
	}

	public String generatePermalink(Object obj) {
		String result = this.getDefinition();
		PermalinkVariable<?>[] variables = supportedVariables();
		for (PermalinkVariable v : variables) {
			String temp = v.encode(obj);
			result = result.replace(v.getVariable(), temp);
		}
		return result;

	}

	public PermalinkVariable<?>[] supportedVariables() {
		return this.supportedVariables;
	}

	public void setSupportedVariables(PermalinkVariable[] supportedVariables) {
		this.supportedVariables = supportedVariables;
	}

	public String definitionReguarExpression() {
		if (this.definitionReguarExpr == null) {
			String result = this.getDefinition();
			PermalinkVariable[] variables = supportedVariables();
			for (PermalinkVariable v : variables) {
				String temp = v.pattern();
				result = result.replace(v.getVariable(), temp);
			}
			this.definitionReguarExpr = result;
		}
		return this.definitionReguarExpr;
	}


	public String getDefinition() {
		return this.definition;
	}
	
}
