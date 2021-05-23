package Services;

import java.util.Vector;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;

import Configuration.Config;
import Entity.User;
import Ntlm.NtlmTransport;

public class UserService {
	Config config = new Config("http://192.168.1.10:7047/BC130/WS/CRONUS%20France%20S.A./Codeunit/Users");
	
	public User authentificate(User userparam) {
	
		User User=new User();
		//SoapObject result;

		//creation de l'envelope soap
				SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
				soapEnvelope.dotNet = true;
				soapEnvelope.avoidExceptionForUnknownProperty = true;
				soapEnvelope.setAddAdornments(false);
				
	  //initialisation de la requette soap                 Targetnamesapce                    operation name
	  SoapObject soapRequest = new SoapObject("urn:microsoft-dynamics-schemas/codeunit/Users", "GetOneUser");
	  SoapObject xmlPortUserPDA= new SoapObject();
	  SoapObject user=new SoapObject();
	  
	 
	 soapRequest.addProperty("userName", userparam.getUsername());
	 soapRequest.addProperty("password",userparam.getPassword());
	 soapRequest.addProperty("xmlPortUserPDA",xmlPortUserPDA);
	 
	 xmlPortUserPDA.addProperty("user", user);
	 
	 user.addProperty("ID", "");
	 user.addProperty("Username", "");
	 user.addProperty("Lastname", "");
	 user.addProperty("Password", "");
	 user.addProperty("LocationCode", "");
	 
	  
	  
	  soapEnvelope.setOutputSoapObject(soapRequest);
		
		NtlmTransport httpTransport = new NtlmTransport(config.url);
		httpTransport.setCredentials(config.login,config.pwd, config.domaine, config.worksattion);
	    httpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		httpTransport.debug = true;
		
		try {
			 httpTransport.call("urn:microsoft-dynamics-schemas/codeunit/Users:GetOneUser", soapEnvelope);
			SoapObject infoUser= new SoapObject();
			 //recuperation de la reponce 
			 Vector<SoapObject> result =  (Vector<SoapObject>)soapEnvelope.getResponse();
			 SoapObject resultInfoUser =  result.lastElement();
				 
		
			 infoUser=(SoapObject) resultInfoUser.getProperty("user");
			
			 if (resultInfoUser.getPropertyCount()==1) {
				 User.setId(infoUser.getProperty("ID").toString());
				 User.setLastname(infoUser.getProperty("Lastname").toString());
				 User.setUsername(infoUser.getProperty("Username").toString());
				 User.setPassword(infoUser.getProperty("Password").toString());
				 User.setLocationCode(infoUser.getProperty("LocationCode").toString());
				System.out.println("Welcome "+infoUser.getProperty("Username").toString()); 
			 }else {
				 System.out.println("Password or Username is incorrect"); 
				 User.setId("null");
				 User.setLastname("null");
				 User.setUsername("null");
				 User.setPassword("null");
				 User.setLocationCode("null");
			 }
			
		} catch (Exception e) {
			System.out.println("Error in fetching data");
			e.printStackTrace();
			// TODO: handle exception
		}
				
	return User;
	}
	
	public User getUserByID(int idUser) {
		User User=new User();
		//SoapObject result;

		//creation de l'envelope soap
				SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
				soapEnvelope.dotNet = true;
				soapEnvelope.avoidExceptionForUnknownProperty = true;
				soapEnvelope.setAddAdornments(false);
				
	  //initialisation de la requette soap                 Targetnamesapce                    operation name
	  SoapObject soapRequest = new SoapObject("urn:microsoft-dynamics-schemas/codeunit/Users", "GetUserByID");
	  SoapObject xmlPortUserPDA= new SoapObject();
	  SoapObject user=new SoapObject();
	  
	 
	 soapRequest.addProperty("idUser", idUser);
	 soapRequest.addProperty("xmlPortUserPDA",xmlPortUserPDA);
	 
	 xmlPortUserPDA.addProperty("user", user);
	 
	 user.addProperty("ID", "");
	 user.addProperty("Username", "");
	 user.addProperty("Lastname", "");
	 user.addProperty("Password", "");
	 user.addProperty("LocationCode", "");
	 
	  
	  
	  soapEnvelope.setOutputSoapObject(soapRequest);
		
		NtlmTransport httpTransport = new NtlmTransport(config.url);
		httpTransport.setCredentials(config.login,config.pwd, config.domaine, config.worksattion);
	    httpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		httpTransport.debug = true;
		try {
			 httpTransport.call("urn:microsoft-dynamics-schemas/codeunit/Users:GetUserByID", soapEnvelope);
				SoapObject infoUser= new SoapObject();
				 //recuperation de la reponce 
				 Vector<SoapObject> result =  (Vector<SoapObject>)soapEnvelope.getResponse();
				 SoapObject resultInfoUser =  result.lastElement();
							
				 infoUser=(SoapObject) resultInfoUser.getProperty("user");
				 infoUser=(SoapObject) resultInfoUser.getProperty("user");
					
				 if (resultInfoUser.getPropertyCount()==1) {
					 User.setId(infoUser.getProperty("ID").toString());
					 User.setLastname(infoUser.getProperty("Lastname").toString());
					 User.setUsername(infoUser.getProperty("Username").toString());
					 User.setPassword(infoUser.getProperty("Password").toString());
					 User.setLocationCode(infoUser.getProperty("LocationCode").toString());
					 System.out.println("this user is  "+infoUser.getProperty("Username").toString()); 
				 }else {
					 System.out.println("ID user is incorrect"); 
					 User.setId("null");
					 User.setLastname("null");
					 User.setUsername("null");
					 User.setPassword("null");
					 User.setLocationCode("null");
				 }
		} catch (Exception e) {
			System.out.println("Error in fetching data");
			e.printStackTrace();
			// TODO: handle exception
		}
		return User;
	}
}
