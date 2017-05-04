import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.json.JSONException;

public class proccessfriends {
	
	
		
		
		public ArrayList<String> processlist(String id,ArrayList<String> profile,ArrayList<String> processed) throws IOException, URISyntaxException, JSONException {
			
			friendslist fl = new friendslist();
			ArrayList<String> coll = new ArrayList<String>();
			ArrayList<String> tcoll = new ArrayList<String>();
			ArrayList<String> stcoll = new ArrayList<String>();
			
			coll=fl.getlist(id);
			boolean flag  ;
					
			
			for(int i =0 ;i<coll.size();i++){
				flag = true ;
				for (int j=0; j<profile.size(); j++){
				
			    if (coll.get(i).equals(profile.get(j))){
			       flag = false;
			       break;
			    }
				
			 }
				if(flag ){
					tcoll.add(coll.get(i));
				}
			}
			
	
			for(int i =0 ;i<tcoll.size();i++){
				flag =true;
				for (int j=0; j<processed.size(); j++){
				
			    if (coll.get(i).equals(processed.get(j))){
			       flag = false;
			       break;
			    }
				
			 }
				if(flag){
					stcoll.add(tcoll.get(i));
				}
			}
			
			for (int k =0 ; k<stcoll.size();k++)
				 profile.add(stcoll.get(k));
					
					
				
					return profile;
				
				}
			 
			}
		
		


