package DDTest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerClass {

	
	public static final Logger log = Logger.getLogger(LoggerClass.class);
			
	public void start()
	{
		log.info("Started Test");
	}
	
	public void errorMsg()
	{
		log.error("Error Occured");
	}
}
