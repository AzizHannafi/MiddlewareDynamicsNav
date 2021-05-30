package Services;

import java.util.Vector;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;

import Configuration.Config;
import Entity.Rejet;
import Ntlm.NtlmTransport;

public class RejetService {
	Config config = new Config("http://192.168.1.9:7047/BC130/WS/CRONUS%20France%20S.A./Codeunit/Rejet");
	
	public void addToReject(String IDCommande,String IDItem,String IDUser) {

		//creation de l'envelope soap
				SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
				soapEnvelope.dotNet = true;
				soapEnvelope.avoidExceptionForUnknownProperty = true;
				soapEnvelope.setAddAdornments(false);
				
				
				//initialisation de la requette soap                 Targetnamesapce                    operation name
				SoapObject soapRequest = new SoapObject("urn:microsoft-dynamics-schemas/codeunit/Rejet", "Insert");
				
				////Ajout des parametre a la requette soap
		      	soapRequest.addProperty("iDCommande", IDCommande);
		      	soapRequest.addProperty("iDItem", IDItem);
		      	soapRequest.addProperty("iDuser", IDUser);
		      
				
				soapEnvelope.setOutputSoapObject(soapRequest);
				
				NtlmTransport httpTransport = new NtlmTransport(config.url);
				httpTransport.setCredentials(config.login,config.pwd, config.domaine, config.worksattion);
			    httpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				httpTransport.debug = true;
				try {
					 httpTransport.call("urn:microsoft-dynamics-schemas/codeunit/Rejet:Insert", soapEnvelope);
					 System.out.println("the commande with the following ID  "+IDCommande+"and the folloowing idIem "+IDItem +" has been added successfully");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				
	}
	
	public Rejet getItemByID(Rejet rejet) {
		
		Rejet Rejet = new Rejet();
		//SoapObject result =new SoapObject();
		
		
		//creation de l'envelope soap
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.dotNet = true;
		soapEnvelope.avoidExceptionForUnknownProperty = true;
		soapEnvelope.setAddAdornments(false);
		
		
		//initialisation de la requette soap                 Targetnamesapce                    operation name
		SoapObject soapRequest = new SoapObject("urn:microsoft-dynamics-schemas/codeunit/Rejet", "GetOne");
		SoapObject XmlPortRejet = new SoapObject();
		SoapObject rejetObj = new SoapObject();
		
		////Ajout des parametre a la requette soap
      	soapRequest.addProperty("iDCommande", rejet.getIdCommande());
      	soapRequest.addProperty("iDItem", rejet.getIDItem());
      	soapRequest.addProperty("xmlPortRejet", XmlPortRejet);
      
		XmlPortRejet.addProperty("Rejet",rejetObj);
		rejetObj.addProperty("IDRejet", "");
		rejetObj.addProperty("IDCommandeRejet", "");
		rejetObj.addProperty("IDItem", "");
      	
		soapEnvelope.setOutputSoapObject(soapRequest);
		
		NtlmTransport httpTransport = new NtlmTransport(config.url);
		httpTransport.setCredentials(config.login,config.pwd, config.domaine, config.worksattion);
	    httpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		httpTransport.debug = true;
		
		try {
			httpTransport.call("urn:microsoft-dynamics-schemas/codeunit/Rejet:Insert", soapEnvelope);
			SoapObject RejetInfo= new SoapObject();
			
			 Vector<SoapObject> result =  (Vector<SoapObject>)soapEnvelope.getResponse();
			SoapObject resultRejetInfo =result.lastElement();
			
			RejetInfo= (SoapObject) resultRejetInfo.getProperty("Rejet");
			
			if(resultRejetInfo.getPropertyCount()==1) {
				Rejet.setIdCommande(RejetInfo.getProperty("IDCommandeRejet").toString());
				Rejet.setIDItem(RejetInfo.getProperty("IDItem").toString());
				
				System.out.println("the following methode getonerejet has been requested succesfully ");
			}else {
				Rejet.setIdCommande("null");
				Rejet.setIDItem("null");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Rejet;
	}
	
}
