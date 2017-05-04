import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONException;
import org.xml.sax.SAXException;



 

public class INVScanner {
	
	
	
	
	public static void main(String[] args)   {
        
		
		
		ArrayList<String> profile = new ArrayList<String>();
		ArrayList<String> processed = new ArrayList<String>();
		proccessfriends fl = new proccessfriends();
		log lg = new log();
		int input = 0;
		int choice = 0 ;
		int profiles =0;
		String id=null;
		long seed;
		boolean flag = true;
		runonce once = new runonce();
		searchpattern sp = new searchpattern();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String date_gc=dateFormat.format(date);
		date_gc= date_gc.replace('/','-');
		date_gc= date_gc.replace(':',';');
		
		System.out.println("Press 1 = Continuous Search || 2 = Friendslist only Search || 3 = Group Search" );
        
        			@SuppressWarnings("resource")
					Scanner reader3 = new Scanner(System.in);
        			input = reader3.nextInt();
        			
        			System.out.println("Press 1 = Search for gift only || 2 = Search for Coupon only || 3 = Search for Both   ");
        			choice = reader3.nextInt();
        				
        switch (input){
            case 1:  
            	
            	
            	
            			System.out.println("How Many Profile Do you Want to Search ");
            			profiles = reader3.nextInt();
				
            			try {
            				profile.add(once.search(0));
     
            			} catch (URISyntaxException | JSONException | IOException e1) {
				
            						lg.writef(e1.toString());
            				}
				
            			for (int i= 0 ;i<profiles;i++)
            			{
            				if((i%100)==0){
            				seed = System.nanoTime();
            				Collections.shuffle(profile, new Random(seed));
            				}
            				id = profile.get(0);				
            				processed.add(profile.get(0));
            				profile.remove(0);
            			try {
            				sp.searchp(choice,id,date_gc);
            				} catch (URISyntaxException | JSONException | IOException | InterruptedException e) {
						
            						lg.writef(e.toString());
            						break;
            				}
					
            			if(profile.size() > profiles)
            					flag = false;
            			if(flag)
						try {
								profile=fl.processlist(id,profile,processed);
							} catch (IOException | URISyntaxException | JSONException e) {
							
										lg.writef(e.toString());
							}
				
					
            				System.out.println("Profile Searched :"+processed.size()+" Profiles to Go :"+profile.size());
					
            				}
                     break;
            case 2:
            		int line =0;
            		int size;
            		File f = new File(System.getProperty("user.dir"),"input.txt");
            		Scanner scanner = null;
            		try {
            			scanner = new Scanner(f);
            			} catch (FileNotFoundException e) {
				
            				lg.writef(e.toString());
				
            			}	
            		while(scanner.hasNextLine()){
            			scanner.nextLine();
            		try {
						profile.add(once.search(line));
						} catch (URISyntaxException | JSONException | IOException e) {
						
								lg.writef(e.toString());
						}
            			id = profile.get(0);
            			processed.add(profile.get(0));
            			profile.remove(0);
					try {
						sp.searchp(choice,id,date_gc);
						} catch (URISyntaxException | JSONException | IOException | InterruptedException e) {
						
								lg.writef(e.toString());
						}
					try {
						profile=fl.processlist(id,profile,processed);
						} catch (IOException | URISyntaxException | JSONException e) {
						
								lg.writef(e.toString());
						}
					size=profile.size();
					for (int i=0;i<size;i++){
						
						if((i%100)==0){
						seed = System.nanoTime();
        				Collections.shuffle(profile, new Random(seed));
						}
						id = profile.get(0);
	            		processed.add(profile.get(0));
						profile.remove(0);
						try {
							sp.searchp(choice,id,date_gc);
						} catch (URISyntaxException | JSONException | IOException | InterruptedException e) {
							lg.writef(e.toString());
							break;
						}
						System.out.println("Profile Searched :"+processed.size()+" of link :"+(line+1)+" Profiles to Go :"+profile.size());
					
						}
								line++;
					
            			}
            			break;
                     
            case 3 :
            			String gname = null;
            			fetchgroupname grname = new fetchgroupname();
            			int count;
            			processgroup grouplist = new processgroup();
            			try {
            				gname = grname.fetchname();
            				} catch (FileNotFoundException e2) {
				
            					lg.writef(e2.toString());
            				}
            			if(gname != null){
            			try {
            				profile = grouplist.processlist(gname);
            				} catch (URISyntaxException | IOException | ParserConfigurationException | SAXException e1) {
            					
            					lg.writef(e1.toString());
            				}
            			count=profile.size();
    					for (int i=0;i<count;i++){
    						
    						if((i%100)==0){
    						seed = System.nanoTime();
            				Collections.shuffle(profile, new Random(seed));
    						}
            				id = profile.get(0);
            				processed.add(profile.get(0));
    						profile.remove(0);
    						try {
    							sp.searchp(choice,id,date_gc);
    						} catch (URISyntaxException | JSONException | IOException | InterruptedException e) {
    							lg.writef(e.toString());
    							break;
    						}
    						System.out.println("Profile Searched :"+processed.size()+"    Profiles to Go :"+profile.size());
    					
    						}
            			}
            			else
            				{
            				System.out.println("Invalid Group Name");
            				lg.writef("Invalid Group Name");
            				}
                 break;
                     
                      
            default: 
            		System.out.println("your input is invalid!");
            		lg.writef("your input is invalid!");
            		break;
        }
    }
   
}



