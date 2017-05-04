import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class skippedprofile {

public void writef(String profileid , String date){
		
		try {

			String content = "http://steamcommunity.com/profiles/"+profileid;
			
			File file = new File(System.getProperty("user.dir"),"skippedprofile_"+date+".txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			
			bw.newLine();
				
			bw.close();

			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


