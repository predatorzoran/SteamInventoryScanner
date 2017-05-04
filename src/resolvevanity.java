
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;



public class resolvevanity {
	
		public String vanitytosteam64(String userVanityUrlName) throws URISyntaxException, MalformedURLException, JSONException, IOException  {
			
			String url = "http://api.steampowered.com/ISteamUser/ResolveVanityURL/v0001/?key=CA0279993F65B5771965D8884D0D7B7E&vanityurl="+userVanityUrlName;
					
			URI uri = new URI(url);
			JSONTokener tokener = new JSONTokener(uri.toURL().openStream());
			JSONObject json = new JSONObject(tokener);
			
			JSONObject header = json.getJSONObject("response");
			String value = header.getString("steamid");
			return(value);
			
			

		}
}
	

	

