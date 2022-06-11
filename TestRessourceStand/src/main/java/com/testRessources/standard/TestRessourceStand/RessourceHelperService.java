package com.testRessources.standard.TestRessourceStand;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class RessourceHelperService implements ResourceLoaderAware{

	/*Centraliser le chargement de resource*/ 
	private ResourceLoader ressourceLoader;
	
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.ressourceLoader=resourceLoader;
	}
	
	public Resource getRessource(String location) {
		return ressourceLoader.getResource(location);
	}

}
