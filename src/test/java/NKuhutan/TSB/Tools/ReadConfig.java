package NKuhutan.TSB.Tools;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfig {
	
	private InputStream inputStream;
	
	public Properties getProp(String configFile) throws IOException{
		
		Properties prop = new Properties();
		
		try {			
			String propFileName = configFile;
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
									
		}catch(Exception e) {
			System.out.println("Error Reading the Config file => " + e.getMessage());
			
		}finally {
			inputStream.close();
		}
						
		return prop;		
	}
	

}
