package businesslogic;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import API.FakeAPI;

public class ImageProcessing {

	String workingImage;

	public ImageProcessing(String workingImage2) {
		this.workingImage = workingImage2;
	}

	public String filtreX()
	{

		String APIanswer = FakeAPI.filtreX_API(this.workingImage);
		return APIanswer;

	}

	public String Crop4goc()
	{
		String separator = System.getProperty("file.separator");
		String originalPath = System.getProperty("user.dir");
		String pathAPI = originalPath + separator + "API" + separator + "Crop4goc_v2.exe";
		
		ProcessBuilder pb = new ProcessBuilder(pathAPI, this.workingImage);

		Process process;
		try {
			process = pb.start();

		BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream())); 
		FileHandler fh;
			fh = new FileHandler("D:/resultAPI.txt");
		Logger logger = Logger.getLogger("global");
		logger.addHandler(fh);
		SimpleFormatter formatter = new SimpleFormatter();
		fh.setFormatter(formatter);
		String line = null;
		
			while ((line = stdInput.readLine()) != null) {
			    logger.log(Level.INFO, "OK" + line);
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Logging Completed...");
		

		return "OK";
	}

}
