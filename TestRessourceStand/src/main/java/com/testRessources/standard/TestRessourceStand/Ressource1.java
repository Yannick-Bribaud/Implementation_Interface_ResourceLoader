package com.testRessources.standard.TestRessourceStand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import lombok.extern.java.Log;

@Log //remplace le system de log de java.util.logging
public class Ressource1 {
	
	
	void myMethode() {
		System.out.println("je suis l'instance de la classe");
	}
	
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
        Resource rsrc= new FileSystemResource("src/main/resources/textRss.txt");
        traiterRessource(rsrc);
        
        String fichier = System.getProperty("user.dir")+"/src/main/resources/textRss.txt";
        log.info("Fichier"+fichier);
        
        
        Resource r1 = new UrlResource("file:"+fichier);
        traiterRessource(r1);
        
        /*une URL qui pointe sur fichier
         * Url resource permet de pointer sur flux HTTP*/
        Resource r2 = new ClassPathResource("textRss.txt");
        traiterRessource(r2);
        
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Ressource1 myrsrce = context.getBean("rsrc",Ressource1.class);
        
        
        System.out.println("Affichage Après instanciation");
        myrsrce.myMethode();
        
        
        
    }
	
}
