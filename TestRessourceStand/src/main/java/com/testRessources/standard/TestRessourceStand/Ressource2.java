package com.testRessources.standard.TestRessourceStand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import lombok.extern.java.Log;


@Log
public class Ressource2 {
	
	// manipulation des ressources standars 
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
	
	
	public static void main( String[] args ) throws IOException
    {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Ressource2 myrsrce2 = context.getBean("rsrc2",Ressource2.class);
        
        String rep = System.getProperty("user.dir");
        log.info("Rep courant - "+rep);
        
        /*La methode get ressource permet de charger tout type de ressource File ou flux HTTP*/
        Resource r0 = context.getResource("file:"+rep+"/src/main/resources/textRss.txt");
        traiterRessource(r0);
        
        Resource r1 =  context.getResource("classpath:textRss.txt");
        traiterRessource(r1);
        
        Resource r2=context.getResource("url:http://echo.jsontest.com/key/value/one/two");
        traiterRessource(r2);
        
        System.out.println("Affichage Après instanciation");
        
        
        
    }
	
	
	
	
	
}
