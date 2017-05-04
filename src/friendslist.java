import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class friendslist {
	public ArrayList<String> getlist(String id) throws URISyntaxException, MalformedURLException, JSONException, IOException{
		
	
		ArrayList<String> coll = new ArrayList<String>();
		String url = "http://api.steampowered.com/ISteamUser/GetFriendList/v0001/?key=CA0279993F65B5771965D8884D0D7B7E&steamid="+id+"&relationship=friend";
		URI uri = new URI(url);
		try{
		JSONTokener tokener = new JSONTokener(uri.toURL().openStream());
		JSONObject json = new JSONObject(tokener);
		 
	
		JSONObject friendlist = json.getJSONObject("friendslist");
		JSONArray friends = friendlist.getJSONArray("friends");
		for(int i=0 ;!(friends.isNull(i));i++){
			JSONObject steamid = friends.getJSONObject(i);
			String steamid64 =	steamid.getString("steamid");
			coll.add(steamid64);
			
		}	
		
	}	catch (Exception e) {
				
			}
		return coll;
	}
		
}
		

	
	 