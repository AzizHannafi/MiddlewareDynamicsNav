package Services;

import java.util.ArrayList;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;

import Configuration.Config;
import Entity.Key;
import Entity.SalesLine;
import Ntlm.NtlmTransport;

public class SalesLineService {

	Config config = new Config("http://192.168.1.7:7047/BC130/WS/CRONUS%20France%20S.A./Page/SalesOrderLine");
	ArrayList<SalesLine> SalesLineList = new ArrayList<SalesLine>();
	
	public SalesLine getOneSalesLine(String idSaleOrder,String LineNo) {
		SalesLine  salesline = new SalesLine();
		SoapObject result;
		
		
		//creation de l'envelope soap
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.dotNet = true;
		soapEnvelope.avoidExceptionForUnknownProperty = true;
		soapEnvelope.setAddAdornments(false);
		
		
		//initialisation de la requette soap                 Targetnamesapce                    operation name
		SoapObject soapRequest = new SoapObject("urn:microsoft-dynamics-schemas/page/salesorderline", "Read");
		
		////Ajout des parametre a la requette soap
      	soapRequest.addProperty("Document_No", idSaleOrder);
      	soapRequest.addProperty("Line_No", LineNo);
		
		soapEnvelope.setOutputSoapObject(soapRequest);
		
		NtlmTransport httpTransport = new NtlmTransport(config.url);
		httpTransport.setCredentials(config.login,config.pwd, config.domaine, config.worksattion);
	    httpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		httpTransport.debug = true;
		
		try {
			//appele du web service en affectant l'envolpe soap deja crée
			 httpTransport.call("urn:microsoft-dynamics-schemas/page/salesorderline:Read", soapEnvelope);
			
			 //recuperation de la reponce 
			result = (SoapObject) soapEnvelope.getResponse();
			
			salesline.setKey(result.getProperty("Key").toString());
			salesline.setNo(result.getProperty("No").toString());
			salesline.setType(result.getProperty("Type").toString());
			salesline.setDocument_No(result.getProperty("Document_No").toString());
			salesline.setLine_No(result.getProperty("Line_No").toString());
			salesline.setQuantity(result.getProperty("Quantity").toString());
			salesline.setUnit_of_Measure_Code(result.getProperty("Unit_of_Measure_Code").toString());
			salesline.setUnit_of_Measure(result.getProperty("Unit_of_Measure").toString());
			salesline.setQuantity_Shipped(result.getProperty("Quantity_Shipped").toString());
			salesline.setQty_to_Invoice(result.getProperty("Qty_to_Invoice").toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("The getOneSalesLine methode have been requested successfully Congrats ;)");
		return salesline;
	}
	
	public List<SalesLine> GetAllSalesLine(){

		SoapObject result;
		
		
		
		//creation de l'envelope soap
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.dotNet = true;
		soapEnvelope.avoidExceptionForUnknownProperty = true;
		soapEnvelope.setAddAdornments(false);
		
		
		//initialisation de la requette soap                 Targetnamesapce                        operation name
		SoapObject soapRequest = new SoapObject("urn:microsoft-dynamics-schemas/page/salesorderline", "ReadMultiple");
		soapEnvelope.setOutputSoapObject(soapRequest);
		
		
		//configuration de l'Ntlm et du protocole http
		NtlmTransport httpTransport = new NtlmTransport(config.url);
		httpTransport.setCredentials(config.login,config.pwd, config.domaine, config.worksattion);
	    httpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		httpTransport.debug = true;
		
		try {
			httpTransport.call("urn:microsoft-dynamics-schemas/page/salesorderline:ReadMultiple", soapEnvelope);
			
			//recuperation de la reponce 
			result = (SoapObject) soapEnvelope.getResponse();
			
			for(int i =0;i<result.getPropertyCount();i++) {
				String Key=null;
				String NoLine=null;
				String TypeLine=null;
				String Document_NoLine=null;
				String QuantityLine=null;
				String LineNoLine=null;
				String Unit_of_Measure_CodeLine=null;
				String Unit_of_MeasureLine=null;
				String Quantity_ShippedLine=null;
				String Qty_to_InvoiceLine=null;
				SoapObject oneSaleLine= (SoapObject) result.getProperty(i);
				
				if(oneSaleLine.hasProperty("Key")==true) {
					Key=oneSaleLine.getProperty("Key").toString();
				}
				if(oneSaleLine.hasProperty("No")==true) {
					NoLine=oneSaleLine.getProperty("No").toString();
				}
				if(oneSaleLine.hasProperty("Type")==true) {
					TypeLine=oneSaleLine.getProperty("Type").toString();
				}
				if(oneSaleLine.hasProperty("Document_No")==true) {
					Document_NoLine=oneSaleLine.getProperty("Document_No").toString();
				}
				if(oneSaleLine.hasProperty("Line_No")==true) {
					LineNoLine=oneSaleLine.getProperty("Line_No").toString();
				}
				if(oneSaleLine.hasProperty("Quantity")==true) {
					QuantityLine=oneSaleLine.getProperty("Quantity").toString();
				}
				if(oneSaleLine.hasProperty("Unit_of_Measure_Code")==true) {
					Unit_of_Measure_CodeLine=oneSaleLine.getProperty("Unit_of_Measure_Code").toString();
				}
				if(oneSaleLine.hasProperty("Unit_of_Measure")==true) {
					Unit_of_MeasureLine=oneSaleLine.getProperty("Unit_of_Measure").toString();
				}
				if(oneSaleLine.hasProperty("Quantity_Shipped")==true) {
					Quantity_ShippedLine=oneSaleLine.getProperty("Quantity_Shipped").toString();
				}
				if(oneSaleLine.hasProperty("Qty_to_Invoice")==true) {
					Qty_to_InvoiceLine=oneSaleLine.getProperty("Qty_to_Invoice").toString();
				}
				SalesLine sl = new SalesLine();
				sl.setKey(Key);
				sl.setNo(NoLine);
				sl.setType(TypeLine);
				sl.setDocument_No(Document_NoLine);
				sl.setLine_No(LineNoLine);
				sl.setQuantity(QuantityLine);
				sl.setUnit_of_Measure_Code(Unit_of_Measure_CodeLine);
				sl.setUnit_of_Measure(Unit_of_MeasureLine);
				sl.setQuantity_Shipped(Quantity_ShippedLine);
				sl.setQty_to_Invoice(Qty_to_InvoiceLine);
				SalesLineList.add(sl);
		
			}
		System.out.println("The GetAllSalesLine methode have been requested successfully Congrats ;)");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return SalesLineList;
	}
	
	public void DeleteSalesLine(Key key) {
		SoapObject result;
		
		
		
		//creation de l'envelope soap
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.dotNet = true;
		soapEnvelope.avoidExceptionForUnknownProperty = true;
		soapEnvelope.setAddAdornments(false);
		
		//initialisation de la requette soap                 Targetnamesapce                    operation name
		SoapObject soapRequest = new SoapObject("urn:microsoft-dynamics-schemas/page/salesorderline", "Delete");
		soapRequest.addProperty("Key",key.getKey());
		soapEnvelope.setOutputSoapObject(soapRequest);
		
		
		//configuration de l'Ntlm et du protocole http
		NtlmTransport httpTransport = new NtlmTransport(config.url);
		httpTransport.setCredentials(config.login,config.pwd, config.domaine, config.worksattion);
	    httpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		httpTransport.debug = true;
		
		
		try {
			 httpTransport.call("urn:microsoft-dynamics-schemas/page/salesorderline:Delete", soapEnvelope);
			// result = (SoapObject) soapEnvelope.getResponse();
			System.out.println("the line with the following key "+key.getKey()+" has been deleted successfully");
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	
		
	}

	public void UpdateLine(SalesLine salesLine) {
		//creation de l'envelope soap
				SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
				soapEnvelope.dotNet = true;
				soapEnvelope.avoidExceptionForUnknownProperty = true;
				soapEnvelope.setAddAdornments(false);
				
				//initialisation de la requette soap                 Targetnamesapce                    operation name
				SoapObject soapRequest = new SoapObject("urn:microsoft-dynamics-schemas/page/salesorderline", "Update");
				soapRequest.addProperty("Key",salesLine.getKey());
				soapRequest.addProperty("Quantity",salesLine.getQuantity());
				
				soapEnvelope.setOutputSoapObject(soapRequest);
				
				
				//configuration de l'Ntlm et du protocole http
				NtlmTransport httpTransport = new NtlmTransport(config.url);
				httpTransport.setCredentials(config.login,config.pwd, config.domaine, config.worksattion);
			    httpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				httpTransport.debug = true;
				try {
					 httpTransport.call("urn:microsoft-dynamics-schemas/page/salesorderline:Update", soapEnvelope);
					// result = (SoapObject) soapEnvelope.getResponse();
					System.out.println("the line with the following key "+salesLine.getKey()+" has been Updated successfully");
					 
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error in updating line");
				}
				
	}
	
}
