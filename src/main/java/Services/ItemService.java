package Services;

import java.util.ArrayList;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;

import Configuration.Config;
import Entity.Item;
import Ntlm.NtlmTransport;

public class ItemService {

	Config config = new Config("http://192.168.1.4:7047/BC130/WS/CRONUS%20France%20S.A./Page/ListItem");
	List<Item> listItem = new ArrayList<Item>();
	public Item getOneItem(String idItem) {
		Item item = new Item();
		SoapObject result;

		//creation de l'envelope soap
				SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
				soapEnvelope.dotNet = true;
				soapEnvelope.avoidExceptionForUnknownProperty = true;
				soapEnvelope.setAddAdornments(false);
				
				
				//initialisation de la requette soap                 Targetnamesapce                    operation name
				SoapObject soapRequest = new SoapObject("urn:microsoft-dynamics-schemas/page/listitem", "Read");
				
				////Ajout des parametre a la requette soap
		      	soapRequest.addProperty("No", idItem);
		      
				
				soapEnvelope.setOutputSoapObject(soapRequest);
				
				NtlmTransport httpTransport = new NtlmTransport(config.url);
				httpTransport.setCredentials(config.login,config.pwd, config.domaine, config.worksattion);
			    httpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				httpTransport.debug = true;
				
				
				try {
					 httpTransport.call("urn:microsoft-dynamics-schemas/page/listitem:Read", soapEnvelope);
					 //recuperation de la reponce 
					result = (SoapObject) soapEnvelope.getResponse();
					if (result!=null) {
						item.setKey(result.getProperty("Key").toString());
						item.setDescription(result.getProperty("Description").toString());
						item.setNo(result.getProperty("No").toString());
						item.setInventory(result.getProperty("Inventory").toString());
						item.setBase_Unit_of_Measure(result.getProperty("Base_Unit_of_Measure").toString());
						
						System.out.println("The getOneItem methode have been requested successfully Congrats ;)");
					}else {
						item.setNo("null");
						System.out.println("Error in retreiving data because item not found");
					}
				
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error in retreiving item ");
				}
		return item;
	}
	
	public List<Item>getAllItems(){
		
		SoapObject result;
		
		
		//creation de l'envelope soap
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.dotNet = true;
		soapEnvelope.avoidExceptionForUnknownProperty = true;
		soapEnvelope.setAddAdornments(false);
		
		
		//initialisation de la requette soap                 Targetnamesapce                    operation name
		SoapObject soapRequest = new SoapObject("urn:microsoft-dynamics-schemas/page/listitem", "ReadMultiple");
	
		soapEnvelope.setOutputSoapObject(soapRequest);
		
		NtlmTransport httpTransport = new NtlmTransport(config.url);
		httpTransport.setCredentials(config.login,config.pwd, config.domaine, config.worksattion);
	    httpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		httpTransport.debug = true;
		try {
			httpTransport.call("urn:microsoft-dynamics-schemas/page/listitem:ReadMultiple", soapEnvelope);
			 //recuperation de la reponce 
			result = (SoapObject) soapEnvelope.getResponse();
			String 	Key=null,
					Base_Unit_of_Measure=null,
					Description=null,
					Inventory=null,
					No=null;
			for(int i=0; i<result.getPropertyCount();i++) {
				Item item =new Item();
				SoapObject oneElement= (SoapObject)result.getProperty(i);
				if(oneElement.hasProperty("Key")==true) {
					Key =oneElement.getProperty("Key").toString();
				}
				if(oneElement.hasProperty("Base_Unit_of_Measure")==true) {
					Base_Unit_of_Measure =oneElement.getProperty("Base_Unit_of_Measure").toString();
				}
				if(oneElement.hasProperty("Description")==true) {
					Description =oneElement.getProperty("Description").toString();
				}
				if(oneElement.hasProperty("Inventory")==true) {
					Inventory =oneElement.getProperty("Inventory").toString();
				}
				if(oneElement.hasProperty("No")==true) {
					No =oneElement.getProperty("No").toString();
				}
				item.setKey(Key);
				item.setBase_Unit_of_Measure(Base_Unit_of_Measure);
				item.setDescription(Description);
				item.setInventory(Inventory);
				item.setNo(No);
				System.out.println("description :"+item.getDescription()+"\n");
				listItem.add(item);
			}
		
			
			//System.out.println("result size:"+result.getPropertyCount());
			System.out.println("The getAllItems methode have been requested successfully Congrats ;)");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in retreiving item");
			e.printStackTrace();
		}
		return listItem;
	}
}
