package Services;

import java.util.ArrayList;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;

import Configuration.Config;
import Entity.Item;
import Entity.PurchaseLine;
import Entity.SalesLine;
import Ntlm.NtlmTransport;

public class ItemService {

	Config config = new Config("BC130/WS/CRONUS%20France%20S.A./Page/ListItem");
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
			String 	Key="null",
					Base_Unit_of_Measure="null",
					Description="null",
					Inventory="null",
					No="null";
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
	
	public List<Item>getAllItemsWithShelf(){
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
			String 	Key="null",
					Base_Unit_of_Measure="null",
					Description="null",
					Inventory="null",
					No="null",
				   Shelf_No="null";
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
				if(oneElement.hasProperty("Shelf_No")==true) {
					Shelf_No =oneElement.getProperty("Shelf_No").toString();
				}
				item.setKey(Key);
				item.setBase_Unit_of_Measure(Base_Unit_of_Measure);
				item.setDescription(Description);
				item.setInventory(Inventory);
				item.setNo(No);
				item.setShelf_No(Shelf_No);
				
				if(item.getShelf_No()!="null") {
					if(Float.parseFloat(item.getInventory().toString())>=0) {
						listItem.add(item);
					}
					
				}
				
			}
			//System.out.println("result size:"+result.getPropertyCount());
			System.out.println("The getAllItemsWithShelf methode have been requested successfully Congrats ;)");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in retreiving item");
			e.printStackTrace();
		}
		return listItem;
	}
	
	
	public Item GetOneItemWithShelf(String idItem) {
		Item item = new Item();
		item.setNo("null");
		listItem=getAllItemsWithShelf();
		
		for(int i = 0;i<listItem.size();i++) {
			if(listItem.get(i).getNo().toString().equals(idItem)) {
				item.setNo(listItem.get(i).getNo().toString());
				item.setDescription(listItem.get(i).getDescription().toString());
				item.setShelf_No(listItem.get(i).getShelf_No().toString());
				item.setInventory(listItem.get(i).getInventory());
				item.setBase_Unit_of_Measure(listItem.get(i).getBase_Unit_of_Measure().toString());
			}
		}
		return item;
		
	}
	public void updateEmplacement(String idArticle, String emplacement) {
		
		
		//SoapObject result =new SoapObject();
		Config config = new Config("BC130/WS/CRONUS%20France%20S.A./Codeunit/ItemInfo");
		
		
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.dotNet = true;
		soapEnvelope.avoidExceptionForUnknownProperty = true;
		soapEnvelope.setAddAdornments(false);
		
		
		//initialisation de la requette soap                 Targetnamesapce                    operation name
		SoapObject soapRequest = new SoapObject("urn:microsoft-dynamics-schemas/codeunit/ItemInfo", "UpdateOne");
		
		////Ajout des parametre a la requette soap
      	soapRequest.addProperty("no", idArticle);
      	soapRequest.addProperty("shelf_No", emplacement);
      
		
		soapEnvelope.setOutputSoapObject(soapRequest);
		
		NtlmTransport httpTransport = new NtlmTransport(config.url);
		httpTransport.setCredentials(config.login,config.pwd, config.domaine, config.worksattion);
	    httpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		httpTransport.debug = true;
		try {
			 httpTransport.call("urn:microsoft-dynamics-schemas/codeunit/ItemInfo:UpdateOne", soapEnvelope);
			 System.out.println("the Article with the following ID  "+idArticle+"and the folloowing emplacment "+emplacement +" has been updated successfully");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public Item GetPurchaseItem(String IDItem) {
		PurchaseLineService purchaseLineService= new PurchaseLineService();
		List<PurchaseLine> PurchaseLineList =purchaseLineService.GetAllPurchaseLine();
		Item item = new Item();
		item.setNo("null");
		item.setDescription("null");
		item.setInventory("null");
		item.setBase_Unit_of_Measure("null");
		float quantity=0;
		for(int i=0;i<PurchaseLineList.size();i++) {
			if(PurchaseLineList.get(i).getItemNo().toString().equals(IDItem)) {
				quantity+=Float.parseFloat(PurchaseLineList.get(i).getQuantity().toString());
				item.setNo(PurchaseLineList.get(i).getItemNo().toString());
				item.setDescription(PurchaseLineList.get(i).getDescription().toString());
				item.setBase_Unit_of_Measure(PurchaseLineList.get(i).getUnit_of_Measure().toString());
				
		}
			item.setInventory(String.valueOf(quantity));
		
	}
		return item;
	
}
	

	public Item GetSalesItem(String IDItem) {
		SalesLineService SalesLineService= new SalesLineService();
		 List<SalesLine> SalesLineList =SalesLineService.GetAllSalesLine();
		Item item = new Item();
		item.setNo("null");
		item.setDescription("null");
		item.setInventory("null");
		item.setBase_Unit_of_Measure("null");
		float quantity=0;
		for(int i=0;i<SalesLineList.size();i++) {
			if(SalesLineList.get(i).getNo().toString().equals(IDItem)) {
				quantity+=Float.parseFloat(SalesLineList.get(i).getQuantity().toString());
				item.setNo(SalesLineList.get(i).getNo().toString());
				item.setDescription(SalesLineList.get(i).getDescription().toString());
				item.setBase_Unit_of_Measure(SalesLineList.get(i).getUnit_of_Measure().toString());
				
		}
			item.setInventory(String.valueOf(quantity));
		
	}
		return item;
	
}
}
