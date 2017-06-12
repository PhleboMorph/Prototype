package businesslogic;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

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
		String pathAPI = originalPath + separator + "API" + separator + "HELLO" + separator + "hello.jar";
		Process process;
		try {
			process = new ProcessBuilder(pathAPI).start();
		
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;

		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "OK";
	}

}
