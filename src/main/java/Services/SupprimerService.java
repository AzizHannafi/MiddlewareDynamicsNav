package Services;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;

import Configuration.Config;
import Ntlm.NtlmTransport;

public class SupprimerService {
Config config = new Config("http://192.168.1.9:7047/BC130/WS/CRONUS%20France%20S.A./Codeunit/Suppression");
	
	public void addToDelete(String IDCommande,String IDItem,String IDUser) {

		//creation de l'envelope soap
				SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
				soapEnvelope.dotNet = true;
				soapEnvelope.avoidExceptionForUnknownProperty = true;
				soapEnvelope.setAddAdornments(false);
				
				
				//initialisation de la requette soap                 Targetnamesapce                    operation name
				SoapObject soapRequest = new SoapObject("urn:microsoft-dynamics-schemas/codeunit/Suppression", "Insert");
				
				////Ajout des parametre a la requette soap
		      	soapRequest.addProperty("iDCommande", IDCommande);
		      	soapRequest.addProperty("iDArticle", IDItem);
		      	soapRequest.addProperty("iDUser", IDUser);
				
				soapEnvelope.setOutputSoapObject(soapRequest);
				
				NtlmTransport httpTransport = new NtlmTransport(config.url);
				httpTransport.setCredentials(config.login,config.pwd, config.domaine, config.worksattion);
			    httpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				httpTransport.debug = true;
				try {
					 httpTransport.call("urn:microsoft-dynamics-schemas/codeunit/Suppression:Insert", soapEnvelope);
					 System.out.println("the commande with the following ID  "+IDCommande+"and the folloowing idIem "+IDItem +" has been added successfully");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				
	}
}
