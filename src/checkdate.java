import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class checkdate {
	 

		 
		 public  boolean fetchd(JSONObject tag, long unixTime ) throws JSONException {
			 
		 	 parsedate pd = new parsedate();
		     long time = pd.date(tag) * 1000;
		  
		     if(time>unixTime)
		     {
		    	 return true;
		     }
		     
		   
			return false;

		 }

		 
}


class parsedate {
	
	public long date (JSONObject tag) throws JSONException {
		
		JSONArray values = tag.getJSONArray("descriptions");
		for(int i=0 ;!(values.isNull(i));i++){
			JSONObject dates = values.getJSONObject(i);
			String valuesingle =	dates.getString("value");
			if(valuesingle.indexOf("Valid until")!= -1){
			Long	date = Long.parseLong(valuesingle.replaceAll("[^0-9]", ""), 10);
				return date;
			}
		}
		
		
	
		return 0;

	}
}