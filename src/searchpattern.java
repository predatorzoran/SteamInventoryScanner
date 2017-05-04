import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import org.json.JSONException;

public class searchpattern {
	
		
	public void searchp( int choice,  String id, String date) throws MalformedURLException, URISyntaxException, JSONException, IOException, InterruptedException
		{
		
		//	System.out.println("For Id :"+id);
			fetchinvgift gift = new fetchinvgift();
			fetchinvcoupon coupon = new fetchinvcoupon();
			Thread.sleep(4000);
			
			 switch (choice){
			 case  1:
			 			 
				 gift.fetch(id,date);
				 break;
			 case 2 :
				 
				 coupon.fetch(id,date);
				 break;
			 
			 case 3 :
			
				 gift.fetch(id,date);
				 
				 Thread.sleep(4000);
				 coupon.fetch(id,date);
				 break;
			
				
			 
		}
			
			 
		

		}
	
}



