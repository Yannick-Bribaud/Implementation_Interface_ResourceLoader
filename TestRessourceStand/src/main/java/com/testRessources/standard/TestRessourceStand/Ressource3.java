package com.testRessources.standard.TestRessourceStand;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import lombok.extern.java.Log;

@Log
public class Ressource3 {

	public static void traiterRessource(Resource resources) {
		try {
			
			InputStream is = resources.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String ligne;
			
			while((ligne = br.readLine()) !=null) {
				log.info(ligne);
				System.out.println();
			}
			
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		RessourceHelperService svc = ctx.getBean("rsrcHelperService",RessourceHelperService.class);
		
		String rep = System.getProperty("user.dir");
		log.info("Rep courant"+rep);
		
		Resource r0 = svc.getRessource("file:"+rep+"/src/main/resources/textRss.txt");
		traiterRessource(r0);
		System.out.println();
		
		Resource r1 = svc.getRessource("classpath:textRss.txt");
		traiterRessource(r1);
		
		Resource r2 = svc.getRessource("url:http://echo.jsontest.com/key/value/one/two");
		traiterRessource(r2);
	}

}
