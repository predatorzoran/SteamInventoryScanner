
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;



public class fetchinvgift {
	public void fetch(String profileid,String date) throws URISyntaxException, MalformedURLException, InterruptedException {
		
		ArrayList<String> coll = new ArrayList<String>();
		boolean cflag = true;     // connection checking flag
		boolean jflag =true;	// JSon object checking flag
		int counter=0;
		String urlgift ="http://steamcommunity.com/profiles/"+profileid+"/inventory/json/753/1";	
		URI uri = new URI(urlgift);
		JSONTokener tokener = null;
		do{
			
			try {
				
				tokener = new JSONTokener(uri.toURL().openStream());
				} catch (IOException | JSONException e) {
					 counter++;
					 Thread.sleep(20000*counter);
				}
				
			 if(counter==5)
				cflag=false;
			
			 
			}while(tokener==null&&counter<5);
		JSONObject json = null;
		if(tokener!=null){
			try {
				json = new JSONObject(tokener);
			} catch (JSONException e) {
				jflag =false;
			}
			}
		boolean flag = true;
		boolean success = false;
		try {
			if(json!=null&&json.length()!=0)
				success = json.getBoolean("success");
				if (json!=null&&json.length()==0)
					cflag=false;
		} catch (JSONException e) {
			jflag =false;
		}
		
		if (success&&jflag==true){
		try {
		Object rgDescriptions = json.get("rgDescriptions");
		
		if (rgDescriptions instanceof JSONArray) {
			
				
			flag =false;
		    
		}
		else if (rgDescriptions instanceof JSONObject) {
		
		
			JSONObject rginv = json.getJSONObject("rgDescriptions");
			Iterator<?> iterator = rginv.keys();
					String key = null;
				 do {
					  key = (String) iterator.next();
					  JSONObject tag = rginv.getJSONObject(key);
					  String name =  tag.getString("name");
					  int tradable = tag.getInt("tradable");
					  
					  if (tradable!= 0)
					  	   coll.add(name +"               tradable");
					  else
						  coll.add(name +"                Not-tradable");
					  
				    } while (iterator.hasNext());
				 
		}
		}catch (JSONException e) {
			log lg = new log();
			lg.writef(e.toString());
			jflag = false ;
		}
		}
		
	    
		if(flag  && success&&jflag && cflag){ 
		writegift gift = new writegift();
		gift.writef(coll, profileid,date);
		}
		if(jflag==false||cflag==false)
		{
			skippedprofile profile = new skippedprofile();
			profile.writef(profileid,date);
		}
		

	}
}
	
