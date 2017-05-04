import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileOperations {
	
	
public	  String ReadOneLine(int line){
		  BufferedReader br = null;
		  String sCurrentLine = null;
		  int i =0;
			try {

				File f = new File(System.getProperty("user.dir"),"input.txt");
				  if(!f.exists())
				  {
					  System.out.println("File not Exists");
					  return null;
				  }
				
				  
				  @SuppressWarnings("resource")
				Scanner scanner = new Scanner(f);
          		while(i<=line){
          			i++;						
				sCurrentLine = scanner.nextLine();
				}
					
				

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br != null)br.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			
			return sCurrentLine;
	  }
	  
}
