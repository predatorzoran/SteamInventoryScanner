
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.json.JSONException;

public class runonce {

 public	String search(int line) throws MalformedURLException, URISyntaxException, JSONException, IOException{
		String steamidf;
		String steamid64;
		FileOperations p = new FileOperations();

		if((steamidf=p.ReadOneLine(line)) != null){
			CheckIdFormat t = new CheckIdFormat();
			if((steamid64 = t.check(steamidf))== null){
				System.out.println("Invalid Steam Id ");
			}
			else
			{
				
				

				return steamid64;
						
		
			
					
			}
		}
		return null;
 }
 


 
 
}

			
		
	

