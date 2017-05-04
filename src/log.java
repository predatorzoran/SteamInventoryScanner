import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class log {
public void writef(String string){
		
		try {

			

			File file = new File(System.getProperty("user.dir"),"log.txt");

			
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			
				bw.newLine();	
				bw.write(string);
											
			bw.close();

			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
