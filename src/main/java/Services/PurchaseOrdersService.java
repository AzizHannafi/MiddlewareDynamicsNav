package Services;

import java.util.ArrayList;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;

import Configuration.Config;
import Entity.Key;
import Entity.PurchaseLine;
import Entity.PurchaseOrders;
import Ntlm.NtlmTransport;

public class PurchaseOrdersService {

	ArrayList<PurchaseLine> PurchaseLineList = new ArrayList<PurchaseLine>();
	PurchaseOrders purchaseorders= new PurchaseOrders();
	Config config = new Config("http://172.16.23.9:7047/BC130/WS/CRONUS%20France%20S.A./Page/PurchaseOrders");
	
	
	public PurchaseOrders getOnePurchaseOrder(String idPurchaseOrder) {
		
		PurchaseLineList.clear();
		SoapObject result;
		
		String 
		   Key=null,
		   No=null,
		   Buy_from_Vendor_No=null,
		   Buy_from_Vendor_Name=null,
		   Posting_Description=null;
		//creation de l'envelope soap
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.dotNet = true;
		soapEnvelope.avoidExceptionForUnknownProperty = true;
		soapEnvelope.setAddAdornments(false);
		
		//initialisation de la requette soap                 Targetnamesapce                    operation name
		SoapObject soapRequest = new SoapObject("urn:microsoft-dynamics-schemas/page/purchaseorders", "Read");
		
		////Ajout des parametre a la requette soap
      	soapRequest.addProperty("No", idPurchaseOrder);
		
		soapEnvelope.setOutputSoapObject(soapRequest);
		
	
		//configuration de l'Ntlm et du protocole http
		NtlmTransport httpTransport = new NtlmTransport(config.url);
		httpTransport.setCredentials(config.login,config.pwd, config.domaine, config.worksattion);
	    httpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		httpTransport.debug = true;
		try {
			 httpTransport.call("urn:microsoft-dynamics-schemas/page/purchaseorders:Read", soapEnvelope);
			 result=(SoapObject)soapEnvelope.getResponse();
			 if(result.hasProperty("Key")==true) {
				 Key=result.getProperty("Key").toString();
				};
			 if(result.hasProperty("No")==true) {
					No=result.getProperty("No").toString();
				};
			if(result.hasProperty("Buy_from_Vendor_No")==true) {
				Buy_from_Vendor_No=result.getProperty("Buy_from_Vendor_No").toString();
				};
			if(result.hasProperty("Buy_from_Vendor_Name")==true) {
				Buy_from_Vendor_Name=result.getProperty("Buy_from_Vendor_Name").toString();
				};
			if(result.hasProperty("Posting_Description")==true) {
				Posting_Description=result.getProperty("Posting_Description").toString();
				};
			SoapObject tableLine=(SoapObject) result.getProperty("PurchLines");
			System.out.println("size of sales line is :"+tableLine.getPropertyCount());
			for(int j=0;j<tableLine.getPropertyCount();j++) {
				PurchaseLine pl = new PurchaseLine();
				SoapObject resTable= (SoapObject)tableLine.getProperty(j);
				
				pl.setKey(((SoapObject) tableLine.getProperty(j)).getProperty("Key").toString());
				pl.setLine_No(((SoapObject) tableLine.getProperty(j)).getProperty("Line_No").toString());
				pl.setType(((SoapObject) tableLine.getProperty(j)).getProperty("Type").toString());
				pl.setDocument_No(((SoapObject) tableLine.getProperty(j)).getProperty("Document_No").toString());
				pl.setUnit_of_Measure_Code(((SoapObject) tableLine.getProperty(j)).getProperty("Unit_of_Measure_Code").toString());
				pl.setUnit_of_Measure(((SoapObject) tableLine.getProperty(j)).getProperty("Unit_of_Measure").toString());
				PurchaseLineList.add(pl);
				
			}
			purchaseorders.setKey(Key);
			purchaseorders.setNo(No);
			purchaseorders.setBuy_from_Vendor_Name(Buy_from_Vendor_Name);
			purchaseorders.setBuy_from_Vendor_No(Buy_from_Vendor_No);
			purchaseorders.setPosting_Description(Posting_Description);
			purchaseorders.setPurchLines(PurchaseLineList);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return purchaseorders;
	}
	
	public List<PurchaseOrders> getAllPurchaseOrder() {
		ArrayList<PurchaseOrders> PurchaseOrdersList = new ArrayList<PurchaseOrders>();
		//System.out.println("get all  methode");
		SoapObject result;
		
		ArrayList<PurchaseLine> PurchaseLineListGetAll = new ArrayList<PurchaseLine>();
		
		String 		key_Orders=null,
					No=null,
					Buy_from_Vendor_No=null,
					Buy_from_Vendor_Name=null,
					Posting_Description=null;
		
		
		//creation de l'envelope soap
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.dotNet = true;
		soapEnvelope.avoidExceptionForUnknownProperty = true;
		soapEnvelope.setAddAdornments(false);
		
		
		//initialisation de la requette soap                 Targetnamesapce                        operation name
		SoapObject soapRequest = new SoapObject("urn:microsoft-dynamics-schemas/page/purchaseorders", "ReadMultiple");
		soapEnvelope.setOutputSoapObject(soapRequest);
		
		
		//configuration de l'Ntlm et du protocole http
		NtlmTransport httpTransport = new NtlmTransport(config.url);
		httpTransport.setCredentials(config.login,config.pwd, config.domaine, config.worksattion);
	    httpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		httpTransport.debug = true;
	
		try {
			//appele du web service en affectant l'envolpe soap deja crée
			 httpTransport.call("urn:microsoft-dynamics-schemas/page/purchaseorders:ReadMultiple", soapEnvelope);
			 result = (SoapObject) soapEnvelope.getResponse();
			 String Key=null,
					Type=null,
					Unit_of_Measure_Code=null,
					Unit_of_Measure=null,
					Document_No=null,
					Line_No=null;
			 for (int i = 0; i < result.getPropertyCount(); i++) {
				 SoapObject oneElemnetofResult = (SoapObject) result.getProperty(i);
				 SoapObject PurchaseLinetable=(SoapObject) oneElemnetofResult.getProperty("PurchLines");
				 ArrayList<PurchaseLine> TableOfPurchaseLinePerElement = new ArrayList<PurchaseLine>();
				 for(int j=0;j<PurchaseLinetable.getPropertyCount();j++) {
					 PurchaseLine pl = new PurchaseLine();
					 SoapObject ElementOfPurchaseLinetable= (SoapObject) PurchaseLinetable.getProperty(j);
					 if (ElementOfPurchaseLinetable.hasProperty("Key")==true) {
						 Key=ElementOfPurchaseLinetable.getProperty("Key").toString();
						}
						if (ElementOfPurchaseLinetable.hasProperty("Unit_of_Measure_Code")) {
							Unit_of_Measure_Code=ElementOfPurchaseLinetable.getProperty("Unit_of_Measure_Code").toString();
						}
						if (ElementOfPurchaseLinetable.hasProperty("Unit_of_Measure")) {
							Unit_of_Measure=ElementOfPurchaseLinetable.getProperty("Unit_of_Measure").toString();
						}
						if (ElementOfPurchaseLinetable.hasProperty("Document_No")) {
							Document_No=ElementOfPurchaseLinetable.getProperty("Document_No").toString();
						}
						if (ElementOfPurchaseLinetable.hasProperty("Line_No")) {
							Line_No=ElementOfPurchaseLinetable.getProperty("Line_No").toString();
						}
						if (ElementOfPurchaseLinetable.hasProperty("Type")) {
							Type=ElementOfPurchaseLinetable.getProperty("Type").toString();
						}
						pl.setKey(Key);
						pl.setUnit_of_Measure(Unit_of_Measure);
						pl.setUnit_of_Measure_Code(Unit_of_Measure_Code);
						pl.setDocument_No(Document_No);
						pl.setLine_No(Line_No);
						pl.setType(Type);
						TableOfPurchaseLinePerElement.add(pl);
				 }
				 	if(oneElemnetofResult.hasProperty("Key")==true) {
					 key_Orders=oneElemnetofResult.getProperty("Key").toString();
						
					};
				 	
				 	if(oneElemnetofResult.hasProperty("No")==true) {
						No=oneElemnetofResult.getProperty("No").toString();
					};
					if(oneElemnetofResult.hasProperty("Buy_from_Vendor_No")==true) {
						Buy_from_Vendor_No=oneElemnetofResult.getProperty("Buy_from_Vendor_No").toString();
					};
					if(oneElemnetofResult.hasProperty("Buy_from_Vendor_Name")==true) {
						Buy_from_Vendor_Name=oneElemnetofResult.getProperty("Buy_from_Vendor_Name").toString();
					};
					if(oneElemnetofResult.hasProperty("Posting_Description")==true) {
						Posting_Description=oneElemnetofResult.getProperty("Posting_Description").toString();
					};
					PurchaseOrders purchaseOrder = new PurchaseOrders(key_Orders,No,Buy_from_Vendor_No,Buy_from_Vendor_Name,Posting_Description,TableOfPurchaseLinePerElement);
					PurchaseOrdersList.add(purchaseOrder);
			 }
			
			 System.out.println("The get all PurchaseOrders methode have been requested successfully Congrats ;)");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error in retriving data");
		}
		return PurchaseOrdersList;
	}
	
	public void deletePurchaseOrders(Key key) {
		SoapObject result;
		
		
		
		//creation de l'envelope soap
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.dotNet = true;
		soapEnvelope.avoidExceptionForUnknownProperty = true;
		soapEnvelope.setAddAdornments(false);
		
		//initialisation de la requette soap                 Targetnamesapce                    operation name
		SoapObject soapRequest = new SoapObject("urn:microsoft-dynamics-schemas/page/purchaseorders", "Delete");
		soapRequest.addProperty("Key",key.getKey());
		soapEnvelope.setOutputSoapObject(soapRequest);
		
		
		//configuration de l'Ntlm et du protocole http
		NtlmTransport httpTransport = new NtlmTransport(config.url);
		httpTransport.setCredentials(config.login,config.pwd, config.domaine, config.worksattion);
	    httpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		httpTransport.debug = true;
		
		
		try {
			 httpTransport.call("urn:microsoft-dynamics-schemas/page/purchaseorders:Delete", soapEnvelope);
			// result = (SoapObject) soapEnvelope.getResponse();
			System.out.println("the line with the following key "+key.getKey()+" has been deleted successfully");
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	
	}
}
