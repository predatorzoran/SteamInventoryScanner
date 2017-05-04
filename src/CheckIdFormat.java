
public class CheckIdFormat {

	
	
	String check (String steamid){
		
		if(steamid.indexOf("http://")!= -1)
		steamid = steamid.replace("http://", "");
		
		if(steamid.indexOf("steamcommunity.com/profiles/")!= -1){
			steamid = steamid.replace("steamcommunity.com/profiles/", "");
			if(steamid.indexOf("/")!= -1)
				steamid = steamid.replace("/", "");
			return steamid;
			
		}
		
		if(steamid.indexOf("steamcommunity.com/id/")!= -1){
			steamid = steamid.replace("steamcommunity.com/id/", "");
			if(steamid.indexOf("/")!= -1)
				steamid = steamid.replace("/", "");
			resolvevanity p=new resolvevanity();
			try {
			steamid =	p.vanitytosteam64(steamid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 return steamid;			
		}
		
		
		return null;
		
	}
}
