import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class processgroup {

	public ArrayList<String> processlist(String gname) throws URISyntaxException, MalformedURLException,  IOException, ParserConfigurationException, SAXException  {
		ArrayList<String> profiles = new ArrayList<String>();
		
		
		String url = "http://steamcommunity.com/groups/"+gname+"/memberslistxml/?xml=1";
		
		
	
		do{
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new URL(url).openStream());
			
			doc.getDocumentElement().normalize();
			
			NodeList members = doc.getElementsByTagName("members");
			
			
			Node node = members.item(0);
			
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) node;
				NodeList steamid = e.getElementsByTagName("steamID64");
			
	         
				for (int i = 0; i < steamid.getLength(); i++) {
				profiles.add(steamid.item(i).getChildNodes().item(0).getNodeValue());     
			
				}
			}
			NodeList nextpage = doc.getElementsByTagName("nextPageLink");
			
			if (nextpage != null && nextpage.getLength()>0)
				url = nextpage.item(0).getChildNodes().item(0).getNodeValue();
			else
				url = null;
			
		}while(url != null);
				
		return profiles;
	}
}