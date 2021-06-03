package Services;

import java.util.ArrayList;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;

import Configuration.Config;
import Entity.Key;
import Entity.PurchaseLine;
import Ntlm.NtlmTransport;

public class PurchaseLineService {
	Config config = new Config("BC130/WS/CRONUS%20France%20S.A./Page/PurechaseLine");
	ArrayList<PurchaseLine> PurchaseLineList = new ArrayList<PurchaseLine>();
	
	
	public PurchaseLine getOnePurchaseLine(String idPurchaseOrder,String LineNo) {
		PurchaseLine  PurchaseLine = new PurchaseLine();
		SoapObject result;
		
		//creation de l'envelope soap
				SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
				soapEnvelope.dotNet = true;
				soapEnvelope.avoidExceptionForUnknownProperty = true;
				soapEnvelope.setAddAdornments(false);
				
				
				//initialisation de la requette soap                 Targetnamesapce                    operation name
				SoapObject soapRequest = new SoapObject("urn:microsoft-dynamics-schemas/page/purechaseline", "Read");
				
				////Ajout des parametre a la requette soap
		      	soapRequest.addProperty("Document_No", idPurchaseOrder);
		      	soapRequest.addProperty("Line_No", LineNo);
				
				soapEnvelope.setOutputSoapObject(soapRequest);
				
				NtlmTransport httpTransport = new NtlmTransport(config.url);
				httpTransport.setCredentials(config.login,config.pwd, config.domaine, config.worksattion);
			    httpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				httpTransport.debug = true;
				
				try {
					//appele du web service en affectant l'envolpe soap deja crée
					 httpTransport.call("urn:microsoft-dynamics-schemas/page/purechaseline:Read", soapEnvelope);
					 //recuperation de la reponce 
					result = (SoapObject) soapEnvelope.getResponse();
					
					PurchaseLine.setKey(result.getProperty("Key").toString());
					PurchaseLine.setType(result.getProperty("Type").toString());
					PurchaseLine.setDocument_No(result.getProperty("Document_No").toString());
					PurchaseLine.setLine_No(result.getProperty("Line_No").toString());
					PurchaseLine.setUnit_of_Measure_Code(result.getProperty("Unit_of_Measure_Code").toString());
					PurchaseLine.setUnit_of_Measure(result.getProperty("Unit_of_Measure").toString());
					System.out.println("The getOnePurchaseLine methode have been requested successfully Congrats ;)");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error in retreiving purchase line");
				}
				return PurchaseLine;
	}

	public List<PurchaseLine> GetAllPurchaseLine(){
		SoapObject result;
		
		
		
		//creation de l'envelope soap
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.dotNet = true;
		soapEnvelope.avoidExceptionForUnknownProperty = true;
		soapEnvelope.setAddAdornments(false);
		
		
		//initialisation de la requette soap                 Targetnamesapce                        operation name
		SoapObject soapRequest = new SoapObject("urn:microsoft-dynamics-schemas/page/purechaseline", "ReadMultiple");
		soapEnvelope.setOutputSoapObject(soapRequest);
		
		
		//configuration de l'Ntlm et du protocole http
		NtlmTransport httpTransport = new NtlmTransport(config.url);
		httpTransport.setCredentials(config.login,config.pwd, config.domaine, config.worksattion);
	    httpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		httpTransport.debug = true;
		try {
			httpTransport.call("urn:microsoft-dynamics-schemas/page/purechaseline:ReadMultiple", soapEnvelope);
			
			//recuperation de la reponce 
			result = (SoapObject) soapEnvelope.getResponse();
			
			for(int i =0;i<result.getPropertyCount();i++) {
				String  Key="null",
						Type="null",
						itemNo= "null",
						Unit_of_Measure_Code="null",
						Unit_of_Measure="null",
						Document_No="null",
						Description="null",
						Quantity="null",
						Line_No="null";
				SoapObject onePurchaseLine= (SoapObject) result.getProperty(i);
				if(onePurchaseLine.hasProperty("No")==true) {
					itemNo=onePurchaseLine.getProperty("No").toString();
				}
				if(onePurchaseLine.hasProperty("Description")==true) {
					Description=onePurchaseLine.getProperty("Description").toString();
				}
				if(onePurchaseLine.hasProperty("Quantity")==true) {
					Quantity=onePurchaseLine.getProperty("Quantity").toString();
				}
				if(onePurchaseLine.hasProperty("Key")==true) {
					Key=onePurchaseLine.getProperty("Key").toString();
				}
				if(onePurchaseLine.hasProperty("Type")==true) {
					Type=onePurchaseLine.getProperty("Type").toString();
				}
				if(onePurchaseLine.hasProperty("Unit_of_Measure_Code")==true) {
					Unit_of_Measure_Code=onePurchaseLine.getProperty("Unit_of_Measure_Code").toString();
				}
				if(onePurchaseLine.hasProperty("Unit_of_Measure")==true) {
					Unit_of_Measure=onePurchaseLine.getProperty("Unit_of_Measure").toString();
				}
				if(onePurchaseLine.hasProperty("Document_No")==true) {
					Document_No=onePurchaseLine.getProperty("Document_No").toString();
				}
				if(onePurchaseLine.hasProperty("Line_No")==true) {
					Line_No=onePurchaseLine.getProperty("Line_No").toString();
				}
				PurchaseLine pl = new PurchaseLine();
				pl.setQuantity(Quantity);
				pl.setKey(Key);
				pl.setDocument_No(Document_No);
				pl.setItemNo(itemNo);
				pl.setDescription(Description);
				pl.setLine_No(Line_No);
				pl.setType(Type);
				pl.setUnit_of_Measure(Unit_of_Measure);
				pl.setUnit_of_Measure_Code(Unit_of_Measure_Code);
				PurchaseLineList.add(pl);
				
			}
			System.out.println("The GetAllPurchaseLine methode have been requested successfully Congrats ;)");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in reitriving data");
		}
		return PurchaseLineList;
	}

	public void deletePurchaseLine(Key key) {
		SoapObject result;
		
		//creation de l'envelope soap
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.dotNet = true;
		soapEnvelope.avoidExceptionForUnknownProperty = true;
		soapEnvelope.setAddAdornments(false);
		
		//initialisation de la requette soap                 Targetnamesapce                    operation name
		SoapObject soapRequest = new SoapObject("urn:microsoft-dynamics-schemas/page/purechaseline", "Delete");
		soapRequest.addProperty("Key",key.getKey());
		soapEnvelope.setOutputSoapObject(soapRequest);
		
		
		//configuration de l'Ntlm et du protocole http
		NtlmTransport httpTransport = new NtlmTransport(config.url);
		httpTransport.setCredentials(config.login,config.pwd, config.domaine, config.worksattion);
	    httpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		httpTransport.debug = true;
		try {
			 httpTransport.call("urn:microsoft-dynamics-schemas/page/purechaseline:Delete", soapEnvelope);
			// result = (SoapObject) soapEnvelope.getResponse();
			System.out.println("the line with the following key "+key.getKey()+" has been deleted successfully");
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
