package util;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Properties;

public class ANUtil {
	Properties prop;
	
	public ANUtil() {
		
	}
	
	private void getFile() throws IOException {
		InputStream inputStream = null;
		
		try {
			prop = new Properties();
			String propFileName = ANConstants.PROP_FILE_NAME;
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			Date time = new Date(System.currentTimeMillis());

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
	}
	
	public String getURL() throws Exception {
		String url = "";
		try {
			getFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (prop != null) {
			url = prop.getProperty("url");
		} else {
			throw new Exception("Could not find the url in the config.properties file");
		}
		
		return url;
	}

	public String getUser() throws Exception {
		String user = "";
		try {
			getFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (prop != null) {
			user = prop.getProperty("user");
		} else {
			throw new Exception("Could not find the url in the config.properties file");
		}

		return user;
	}

	public String getPassword() throws Exception {
		String pass = "";
		try {
			getFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (prop != null) {
			pass = prop.getProperty("password");
		} else {
			throw new Exception("Could not find the url in the config.properties file");
		}

		return pass;
	}
}
