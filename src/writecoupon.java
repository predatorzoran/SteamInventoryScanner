import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class writecoupon {

public  void writef(ArrayList<String> coll ,String profileid ,String date){
		
		try {

			String content = "http://steamcommunity.com/profiles/"+profileid;
			
			File file = new File(System.getProperty("user.dir"),"coupon_"+date+".txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.write("--------------------------------------------------------");
			bw.newLine();
			bw.newLine();
			
			for(int i=0 ;i<coll.size();i++){
				bw.write(coll.get(i));
				bw.newLine();
			}
			bw.newLine();
			bw.newLine();
			
			bw.close();

			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
