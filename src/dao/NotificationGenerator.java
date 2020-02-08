package dao;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class NotificationGenerator implements ServletContextListener{
    public void contextInitialized(ServletContextEvent event) {
    	Runnable r = new Runnable() {
			
			@Override
			public void run() {
		        while(true) {
		        	try {
						Thread.sleep(60000);
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		        	new NotificationDaoImpl().notificationAllUpdate();
		        	System.out.println("***** Notification table was updated");
		        }
				
			}
		};
    	new Thread(r).start();
    }

    public void contextDestroyed(ServletContextEvent event) {
        // Do stuff during webapp's shutdown.
    }

}
