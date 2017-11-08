package fr.m2miage.geocartebck;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import fr.m2miage.geocartebck.controller.ExempleController;

@SpringBootApplication
public class App extends SpringBootServletInitializer implements CommandLineRunner 
{

    public static Logger log = Logger.getLogger(App.class);
    
	@Autowired
	private ExempleController exCtrl;
	
    public static void main(String[] args) 
    {
        SpringApplication.run(App.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) 
    {
        return application.sources(App.class);
    }

    @Override
    public void run(String... args) throws Exception 
    {
        log.info("L'application geocarte vient de demarrer");
        //
    	exCtrl.TestPersist();
    }
    
}