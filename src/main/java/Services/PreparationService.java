package Services;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;

import Configuration.Config;
import Ntlm.NtlmTransport;

public class PreparationService {
	Config config = new Config("BC130/WS/CRONUS%20France%20S.A./Codeunit/Preparation");
	
	public void addToPreparetion(String IDUser,String IDCommande) {

		//creation de l'envelope soap
				SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
				soapEnvelope.dotNet = true;
				soapEnvelope.avoidExceptionForUnknownProperty = true;
				soapEnvelope.setAddAdornments(false);
				
				
				//initialisation de la requette soap                 Targetnamesapce                    operation name
				SoapObject soapRequest = new SoapObject("urn:microsoft-dynamics-schemas/codeunit/Preparation", "InsertOne");
				
				////Ajout des parametre a la requette soap
		      	soapRequest.addProperty("iDUser", IDUser);
		      	soapRequest.addProperty("iDCommande", IDCommande);
		     
		      
				soapEnvelope.setOutputSoapObject(soapRequest);
				
				NtlmTransport httpTransport = new NtlmTransport(config.url);
				httpTransport.setCredentials(config.login,config.pwd, config.domaine, config.worksattion);
			    httpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				httpTransport.debug = true;
				try {
					 httpTransport.call("urn:microsoft-dynamics-schemas/codeunit/Preparation:InsertOne", soapEnvelope);
					 System.out.println("the commande with the following ID  "+IDCommande+"and the folloowing idUser "+IDUser +" has been added successfully");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				
	}
}
