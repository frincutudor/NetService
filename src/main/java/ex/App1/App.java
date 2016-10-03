package ex.App1;

/**
 * Hello world!
 *
 */
import java.io.File;
import java.net.URI;
import java.net.URL;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println(new File(".").getAbsolutePath());
    	
    	URL resource = App.class.getResource("Config.xml");
    	
    	ApplicationContext context =
    		    new ClassPathXmlApplicationContext(new String[] {resource.toString()});
    	
    	networkController networkObj=(networkController) context.getBean("ControllerBean");
    	
    	networkObj.printNetwork();
    	
    	
    }
}
