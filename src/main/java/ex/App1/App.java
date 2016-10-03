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
    // TODO tudor, change to annotation injection.
    public static void main( String[] args )
    {
    	URL resource = App.class.getResource("Config.xml");
    	
    	ApplicationContext context =
    		    new ClassPathXmlApplicationContext(new String[] {resource.toString()});
    	
    	// TODO tudor, dc beanul network se numeste DAQ ? 
    	networkController networkObj=(networkController) context.getBean("ControllerBean");
    	
    	 //TODO tudor,  schimba architectura ca sa consumi obiectele in caller
    	// astfel un get x poate fi refolosit.
    	networkObj.printNetwork();
    	
    	
    }
}
