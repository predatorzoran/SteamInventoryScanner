import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class fetchgroupname {

	public String fetchname() throws FileNotFoundException{
		String groupname = null ;
		File f = new File(System.getProperty("user.dir"),"input.txt");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(f);
		groupname=scanner.nextLine();
		
		
		if(groupname != null){
		if(groupname.indexOf("http://")!= -1)
		groupname = groupname.replace("http://", "");
		
		if(groupname.indexOf("steamcommunity.com/groups/")!= -1){
			groupname = groupname.replace("steamcommunity.com/groups/", "");
			if(groupname.indexOf("/")!= -1)
				groupname = groupname.replace("/", "");
			return groupname;
			
		}
		
	/*	if(groupname.indexOf("steamcommunity.com/gid/")!= -1){
			groupname = groupname.replace("steamcommunity.com/gid/", "");
			if(groupname.indexOf("/")!= -1)
				groupname = groupname.replace("/", "");
			
			resolvevanity p=new resolvevanity();
			try {
			groupname =	p.vanitytosteam64(groupname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 return groupname;			
		} */
		
		}
	
		return null;
	}
}
