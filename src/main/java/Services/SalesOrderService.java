package Services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.xmlpull.v1.XmlPullParserException;

import Configuration.Config;
import Entity.Key;
import Entity.SalesLine;
import Entity.SalesOrder;
import Ntlm.NtlmTransport;

public class SalesOrderService {
		SalesOrder salesOrder= new SalesOrder();
		
		ArrayList<SalesLine> SalesLineList = new ArrayList<SalesLine>();
	
		Config config = new Config("http://172.16.23.9:7047/BC130/WS/CRONUS%20France%20S.A./Page/SalesHeader");
		
		
		
		//The get one sales order  methode
		public SalesOrder getOneSalesOrder(String idSaleOrder){
				SalesLineList.clear();
				SoapObject result;
				String 	Key=null,
						No=null,
						Sell_to_Customer_No=null,
						Sell_to_Customer_Name=null,
						Posting_Description=null,
						Sell_to_Address=null,
						Sell_to_City=null,
						Sell_to_County=null,
						Order_Date=null,
						Due_Date=null,
						Prepayment_Due_Date=null,
						Prepmt_Pmt_Discount_Date=null,
						Location_Code=null;
				
				
				//creation de l'envelope soap
				SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
				soapEnvelope.dotNet = true;
				soapEnvelope.avoidExceptionForUnknownProperty = true;
				soapEnvelope.setAddAdornments(false);
				
				//initialisation de la requette soap                 Targetnamesapce                    operation name
				SoapObject soapRequest = new SoapObject("urn:microsoft-dynamics-schemas/page/salesheader", "Read");
				
				////Ajout des parametre a la requette soap
		      	soapRequest.addProperty("No", idSaleOrder);
				
				soapEnvelope.setOutputSoapObject(soapRequest);
				
			
				//configuration de l'Ntlm et du protocole http
				NtlmTransport httpTransport = new NtlmTransport(config.url);
				httpTransport.setCredentials(config.login,config.pwd, config.domaine, config.worksattion);
			    httpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				httpTransport.debug = true;
				
				try {
					
					//appele du web service en affectant l'envolpe soap deja crée
					 httpTransport.call("urn:microsoft-dynamics-schemas/page/salesheader:Read", soapEnvelope);
					
					//recuperation de la reponce 
					result = (SoapObject) soapEnvelope.getResponse();
					
					if(result.hasProperty("Key")==true) {
						Key=result.getProperty("Key").toString();
					};
					if(result.hasProperty("No")==true) {
						No=result.getProperty("No").toString();
					};
					if(result.hasProperty("Sell_to_Customer_No")==true) {
						Sell_to_Customer_No=result.getProperty("Sell_to_Customer_No").toString();
					};
					if(result.hasProperty("Sell_to_Customer_Name")==true) {
							Sell_to_Customer_Name=result.getProperty("Sell_to_Customer_Name").toString();
						};
					if(result.hasProperty("Posting_Description")==true) {
						Posting_Description=result.getProperty("Posting_Description").toString();
						};
					if(result.hasProperty("Sell_to_Address")==true) {
						Sell_to_Address=result.getProperty("Sell_to_Address").toString();
						};
					if(result.hasProperty("Sell_to_City")==true) {
						Sell_to_City=result.getProperty("Sell_to_City").toString();
					}
					if(result.hasProperty("Sell_to_County")==true) {
						Sell_to_County=result.getProperty("Sell_to_County").toString();
					};
					if(result.hasProperty("Order_Date")==true) {
						Order_Date=result.getProperty("Order_Date").toString();
					};
					if(result.hasProperty("Due_Date")==true) {
						Due_Date=result.getProperty("Due_Date").toString();
					};
					if(result.hasProperty("Prepayment_Due_Date")==true) {
						Prepayment_Due_Date=result.getProperty("Prepayment_Due_Date").toString();
					};
					if(result.hasProperty("Prepmt_Pmt_Discount_Date")==true) {
						Prepmt_Pmt_Discount_Date=result.getProperty("Prepmt_Pmt_Discount_Date").toString();
					};
					if(result.hasProperty("Location_Code")==true) {
						Location_Code=result.getProperty("Location_Code").toString();
					};
					
					SoapObject tableLine=(SoapObject) result.getProperty("SalesLines");
					System.out.println("size of sales line is :"+tableLine.getPropertyCount());
					for(int j=0;j<tableLine.getPropertyCount();j++) {
						SalesLine sl = new SalesLine();
						SoapObject resTable= (SoapObject)tableLine.getProperty(j);
						
						sl.setKey(((SoapObject) tableLine.getProperty(j)).getProperty("Key").toString());
						sl.setNo(((SoapObject) tableLine.getProperty(j)).getProperty("No").toString());
						sl.setType(((SoapObject) tableLine.getProperty(j)).getProperty("Type").toString());
						sl.setDocument_No(((SoapObject) tableLine.getProperty(j)).getProperty("Document_No").toString());
						sl.setLine_No(((SoapObject) tableLine.getProperty(j)).getProperty("Line_No").toString());
						sl.setQuantity(((SoapObject) tableLine.getProperty(j)).getProperty("Quantity").toString());
						sl.setUnit_of_Measure_Code(((SoapObject) tableLine.getProperty(j)).getProperty("Unit_of_Measure_Code").toString());
						sl.setUnit_of_Measure(((SoapObject) tableLine.getProperty(j)).getProperty("Unit_of_Measure").toString());
						sl.setQuantity_Shipped(((SoapObject) tableLine.getProperty(j)).getProperty("Quantity_Shipped").toString());
						sl.setQty_to_Invoice(((SoapObject) tableLine.getProperty(j)).getProperty("Qty_to_Invoice").toString());
						SalesLineList.add(sl);
						
					}
					 salesOrder.setKey(Key);
					 salesOrder.setNo(No);
					 salesOrder.setSell_to_Customer_No(Sell_to_Customer_No);
					 salesOrder.setSell_to_Customer_Name(Sell_to_Customer_Name);
					 salesOrder.setPosting_Description(Posting_Description);
					 salesOrder.setSell_to_Address(Sell_to_Address);
					 salesOrder.setSell_to_City(Sell_to_City);
					 salesOrder.setSell_to_County(Sell_to_County);
					 salesOrder.setOrder_Date(Order_Date);
					 salesOrder.setDue_Date(Due_Date);
					 salesOrder.setPrepayment_Due_Date(Prepayment_Due_Date);
					 salesOrder.setPrepmt_Pmt_Discount_Date(Prepmt_Pmt_Discount_Date);
					 salesOrder.setLocation_Code(Location_Code);
					 salesOrder.setSalesLine(SalesLineList);
					
					
					System.out.println("The getOneSalesOrder methode have been requested successfully Congrats ;)");
					
		        } catch (NullPointerException exception) {
					exception.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (XmlPullParserException e) {
					e.printStackTrace();
				}
				
				return salesOrder;}
					
		public List<SalesOrder> GetAllSalesOrder(){
				SoapObject result;
				
				ArrayList<SalesOrder> SalesOrderList = new ArrayList<SalesOrder>();
				ArrayList<SalesLine> SalesLineListGetAll = new ArrayList<SalesLine>();
				String 	key_Order=null,
						No=null,
						Sell_to_Customer_No=null,
						Sell_to_Customer_Name=null,
						Posting_Description=null,
						Sell_to_Address=null,
						Sell_to_City=null,
						Sell_to_County=null,
						Order_Date=null,
						Due_Date=null,
						Prepayment_Due_Date=null,
						Prepmt_Pmt_Discount_Date=null,
						Location_Code=null;
				
				
				//creation de l'envelope soap
				SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
				soapEnvelope.dotNet = true;
				soapEnvelope.avoidExceptionForUnknownProperty = true;
				soapEnvelope.setAddAdornments(false);
				
				
				//initialisation de la requette soap                 Targetnamesapce                        operation name
				SoapObject soapRequest = new SoapObject("urn:microsoft-dynamics-schemas/page/salesheader", "ReadMultiple");
				soapEnvelope.setOutputSoapObject(soapRequest);
				
				
				//configuration de l'Ntlm et du protocole http
				NtlmTransport httpTransport = new NtlmTransport(config.url);
				httpTransport.setCredentials(config.login,config.pwd, config.domaine, config.worksattion);
			    httpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				httpTransport.debug = true;
				
				
				try {
					
					//appele du web service en affectant l'envolpe soap deja crée
					 httpTransport.call("urn:microsoft-dynamics-schemas/page/SalesHeader:ReadMultiple", soapEnvelope);
					
					//recuperation de la reponce 
					result = (SoapObject) soapEnvelope.getResponse();
					String NoLine=null;
					String Unit_of_Measure_Code=null;
					String Unit_of_Measure= null;
					
					for (int i = 0; i < result.getPropertyCount(); i++) {
						
						SoapObject oneElemnetofResult = (SoapObject) result.getProperty(i);
						SoapObject SalesLinestable=(SoapObject) oneElemnetofResult.getProperty("SalesLines");
						ArrayList<SalesLine> TableOfSaleLinePerElement = new ArrayList<SalesLine>();
						for(int j=0;j<SalesLinestable.getPropertyCount();j++) {
							SalesLine sl = new SalesLine();
							SoapObject ElementOfSalesLinestable= (SoapObject) SalesLinestable.getProperty(j);
							
							if (ElementOfSalesLinestable.hasProperty("No")==true) {
								NoLine=ElementOfSalesLinestable.getProperty("No").toString();
							}
							if (ElementOfSalesLinestable.hasProperty("Unit_of_Measure_Code")) {
								Unit_of_Measure_Code=ElementOfSalesLinestable.getProperty("Unit_of_Measure_Code").toString();
							}
							if (ElementOfSalesLinestable.hasProperty("Unit_of_Measure")) {
								Unit_of_Measure=ElementOfSalesLinestable.getProperty("Unit_of_Measure").toString();
							}
							
							sl.setKey(ElementOfSalesLinestable.getProperty("Key").toString());
							sl.setNo(NoLine);
							sl.setType(ElementOfSalesLinestable.getProperty("Type").toString());
							sl.setDocument_No(ElementOfSalesLinestable.getProperty("Document_No").toString());
							sl.setLine_No(ElementOfSalesLinestable.getProperty("Line_No").toString());
							sl.setQuantity(ElementOfSalesLinestable.getProperty("Quantity").toString());
							sl.setUnit_of_Measure(Unit_of_Measure);
							sl.setUnit_of_Measure_Code(Unit_of_Measure_Code);
							sl.setQty_to_Invoice(ElementOfSalesLinestable.getProperty("Qty_to_Invoice").toString());
							TableOfSaleLinePerElement.add(sl);
							}
						
						
						
						if(oneElemnetofResult.hasProperty("Key")==true) {
							key_Order=oneElemnetofResult.getProperty("Key").toString();
							
						};
						if(oneElemnetofResult.hasProperty("No")==true) {
							No=oneElemnetofResult.getProperty("No").toString();
						};
						if(oneElemnetofResult.hasProperty("Sell_to_Customer_No")==true) {
							Sell_to_Customer_No=oneElemnetofResult.getProperty("Sell_to_Customer_No").toString();
						};
						if(oneElemnetofResult.hasProperty("Sell_to_Customer_Name")==true) {
								Sell_to_Customer_Name=oneElemnetofResult.getProperty("Sell_to_Customer_Name").toString();
							};
						if(oneElemnetofResult.hasProperty("Posting_Description")==true) {
							Posting_Description=oneElemnetofResult.getProperty("Posting_Description").toString();
							};
						if(oneElemnetofResult.hasProperty("Sell_to_Address")==true) {
							Sell_to_Address=oneElemnetofResult.getProperty("Sell_to_Address").toString();
							};
						if(oneElemnetofResult.hasProperty("Sell_to_City")==true) {
							Sell_to_City=oneElemnetofResult.getProperty("Sell_to_City").toString();
						}
						if(oneElemnetofResult.hasProperty("Sell_to_County")==true) {
							Sell_to_County=oneElemnetofResult.getProperty("Sell_to_County").toString();
						};
						if(oneElemnetofResult.hasProperty("Order_Date")==true) {
							Order_Date=oneElemnetofResult.getProperty("Order_Date").toString();
						};
						if(oneElemnetofResult.hasProperty("Due_Date")==true) {
							Due_Date=oneElemnetofResult.getProperty("Due_Date").toString();
						};
						if(oneElemnetofResult.hasProperty("Prepayment_Due_Date")==true) {
							Prepayment_Due_Date=oneElemnetofResult.getProperty("Prepayment_Due_Date").toString();
						};
						if(oneElemnetofResult.hasProperty("Prepmt_Pmt_Discount_Date")==true) {
							Prepmt_Pmt_Discount_Date=oneElemnetofResult.getProperty("Prepmt_Pmt_Discount_Date").toString();
						};
						if(oneElemnetofResult.hasProperty("Location_Code")==true) {
							Location_Code=oneElemnetofResult.getProperty("Location_Code").toString();
						};
						SalesOrder salesOrder =new SalesOrder(
								key_Order,
								No,
								Sell_to_Customer_No,
								Sell_to_Customer_Name,
								Posting_Description,
								Sell_to_Address,
								Sell_to_City,
								Sell_to_County,
								Order_Date,
								Due_Date,
								Prepmt_Pmt_Discount_Date,
								Location_Code, Location_Code,
								TableOfSaleLinePerElement);
					
						SalesOrderList.add(salesOrder);						
						}
						
					System.out.println("The get all sells orders methode have been requested successfully Congrats ;)");
				
					
		        } catch (NullPointerException exception) {
					exception.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				} catch (XmlPullParserException e) {
					e.printStackTrace();
				}
				return SalesOrderList;
			}
		
		public List<SalesOrder> GetAllReleasedSalesOrder(){
			SoapObject result;
			
			ArrayList<SalesOrder> SalesOrderList = new ArrayList<SalesOrder>();
			ArrayList<SalesLine> SalesLineListGetAll = new ArrayList<SalesLine>();
			String 	key_Order=null,
					No=null,
					Sell_to_Customer_No=null,
					Sell_to_Customer_Name=null,
					Posting_Description=null,
					Sell_to_Address=null,
					Sell_to_City=null,
					Sell_to_County=null,
					Order_Date=null,
					Due_Date=null,
					Prepayment_Due_Date=null,
					Prepmt_Pmt_Discount_Date=null,
					Location_Code=null;
			
			
			//creation de l'envelope soap
			SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			soapEnvelope.dotNet = true;
			soapEnvelope.avoidExceptionForUnknownProperty = true;
			soapEnvelope.setAddAdornments(false);
			
			
			//initialisation de la requette soap                 Targetnamesapce                        operation name
			SoapObject soapRequest = new SoapObject("urn:microsoft-dynamics-schemas/page/salesheader", "ReadMultiple");
			soapEnvelope.setOutputSoapObject(soapRequest);
			
			
			//configuration de l'Ntlm et du protocole http
			NtlmTransport httpTransport = new NtlmTransport(config.url);
			httpTransport.setCredentials(config.login,config.pwd, config.domaine, config.worksattion);
		    httpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			httpTransport.debug = true;
			
			
			try {
				
				//appele du web service en affectant l'envolpe soap deja crée
				 httpTransport.call("urn:microsoft-dynamics-schemas/page/SalesHeader:ReadMultiple", soapEnvelope);
				
				//recuperation de la reponce 
				result = (SoapObject) soapEnvelope.getResponse();
				String NoLine=null;
				String Unit_of_Measure_Code=null;
				String Unit_of_Measure= null;
				
				for (int i = 0; i < result.getPropertyCount(); i++) {
					//System.out.println("all"+i);
						
					SoapObject oneElemnetofResult = (SoapObject) result.getProperty(i);
					//System.out.println(oneElemnetofResult.getProperty("Status").toString());
					if(oneElemnetofResult.getProperty("Status").toString().equals("Released")) {
						SoapObject SalesLinestable=(SoapObject) oneElemnetofResult.getProperty("SalesLines");
						ArrayList<SalesLine> TableOfSaleLinePerElement = new ArrayList<SalesLine>();
						
						for(int j=0;j<SalesLinestable.getPropertyCount();j++) {
							SalesLine sl = new SalesLine();
							SoapObject ElementOfSalesLinestable= (SoapObject) SalesLinestable.getProperty(j);
							
							if (ElementOfSalesLinestable.hasProperty("No")==true) {
								NoLine=ElementOfSalesLinestable.getProperty("No").toString();
							}
							if (ElementOfSalesLinestable.hasProperty("Unit_of_Measure_Code")) {
								Unit_of_Measure_Code=ElementOfSalesLinestable.getProperty("Unit_of_Measure_Code").toString();
							}
							if (ElementOfSalesLinestable.hasProperty("Unit_of_Measure")) {
								Unit_of_Measure=ElementOfSalesLinestable.getProperty("Unit_of_Measure").toString();
							}
							
							
							sl.setKey(ElementOfSalesLinestable.getProperty("Key").toString());
							sl.setNo(NoLine);
							sl.setType(ElementOfSalesLinestable.getProperty("Type").toString());
							sl.setDocument_No(ElementOfSalesLinestable.getProperty("Document_No").toString());
							sl.setLine_No(ElementOfSalesLinestable.getProperty("Line_No").toString());
							sl.setQuantity(ElementOfSalesLinestable.getProperty("Quantity").toString());
							sl.setUnit_of_Measure(Unit_of_Measure);
							sl.setUnit_of_Measure_Code(Unit_of_Measure_Code);
							sl.setQty_to_Invoice(ElementOfSalesLinestable.getProperty("Qty_to_Invoice").toString());
							TableOfSaleLinePerElement.add(sl);
							}
						if(oneElemnetofResult.hasProperty("Key")==true) {
							key_Order=oneElemnetofResult.getProperty("Key").toString();
							
						};
						if(oneElemnetofResult.hasProperty("No")==true) {
							No=oneElemnetofResult.getProperty("No").toString();
						};
						if(oneElemnetofResult.hasProperty("Sell_to_Customer_No")==true) {
							Sell_to_Customer_No=oneElemnetofResult.getProperty("Sell_to_Customer_No").toString();
						};
						if(oneElemnetofResult.hasProperty("Sell_to_Customer_Name")==true) {
								Sell_to_Customer_Name=oneElemnetofResult.getProperty("Sell_to_Customer_Name").toString();
							};
						if(oneElemnetofResult.hasProperty("Posting_Description")==true) {
							Posting_Description=oneElemnetofResult.getProperty("Posting_Description").toString();
							};
						if(oneElemnetofResult.hasProperty("Sell_to_Address")==true) {
							Sell_to_Address=oneElemnetofResult.getProperty("Sell_to_Address").toString();
							};
						if(oneElemnetofResult.hasProperty("Sell_to_City")==true) {
							Sell_to_City=oneElemnetofResult.getProperty("Sell_to_City").toString();
						}
						if(oneElemnetofResult.hasProperty("Sell_to_County")==true) {
							Sell_to_County=oneElemnetofResult.getProperty("Sell_to_County").toString();
						};
						if(oneElemnetofResult.hasProperty("Order_Date")==true) {
							Order_Date=oneElemnetofResult.getProperty("Order_Date").toString();
						};
						if(oneElemnetofResult.hasProperty("Due_Date")==true) {
							Due_Date=oneElemnetofResult.getProperty("Due_Date").toString();
						};
						if(oneElemnetofResult.hasProperty("Prepayment_Due_Date")==true) {
							Prepayment_Due_Date=oneElemnetofResult.getProperty("Prepayment_Due_Date").toString();
						};
						if(oneElemnetofResult.hasProperty("Prepmt_Pmt_Discount_Date")==true) {
							Prepmt_Pmt_Discount_Date=oneElemnetofResult.getProperty("Prepmt_Pmt_Discount_Date").toString();
						};
						if(oneElemnetofResult.hasProperty("Location_Code")==true) {
							Location_Code=oneElemnetofResult.getProperty("Location_Code").toString();
						};
						
						SalesOrder salesOrder =new SalesOrder(key_Order,No,
								Sell_to_Customer_No,
								Sell_to_Customer_Name,
								Posting_Description,
								Sell_to_Address,
								Sell_to_City,
								Sell_to_County,
								Order_Date,
								Due_Date,
								Prepmt_Pmt_Discount_Date,
								Location_Code, Location_Code,
								TableOfSaleLinePerElement);
						
						SalesOrderList.add(salesOrder);	
						}
					}
					
					
					
				System.out.println("The GetAllReleasedSalesOrder methode have been requested successfully Congrats ;)");
			
				
	        } catch (NullPointerException exception) {
				exception.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (XmlPullParserException e) {
				e.printStackTrace();
			}
			return SalesOrderList;
		}
		
		public List<SalesOrder> GetAllOpenSalesOrder(){
			SoapObject result;
			
			ArrayList<SalesOrder> SalesOrderList = new ArrayList<SalesOrder>();
			ArrayList<SalesLine> SalesLineListGetAll = new ArrayList<SalesLine>();
			String 	key_Order=null,
					No=null,
					Sell_to_Customer_No=null,
					Sell_to_Customer_Name=null,
					Posting_Description=null,
					Sell_to_Address=null,
					Sell_to_City=null,
					Sell_to_County=null,
					Order_Date=null,
					Due_Date=null,
					Prepayment_Due_Date=null,
					Prepmt_Pmt_Discount_Date=null,
					Location_Code=null;
			
			
			//creation de l'envelope soap
			SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			soapEnvelope.dotNet = true;
			soapEnvelope.avoidExceptionForUnknownProperty = true;
			soapEnvelope.setAddAdornments(false);
			
			
			//initialisation de la requette soap                 Targetnamesapce                        operation name
			SoapObject soapRequest = new SoapObject("urn:microsoft-dynamics-schemas/page/salesheader", "ReadMultiple");
			soapEnvelope.setOutputSoapObject(soapRequest);
			
			
			//configuration de l'Ntlm et du protocole http
			NtlmTransport httpTransport = new NtlmTransport(config.url);
			httpTransport.setCredentials(config.login,config.pwd, config.domaine, config.worksattion);
		    httpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			httpTransport.debug = true;
			
			
			try {
				
				//appele du web service en affectant l'envolpe soap deja crée
				 httpTransport.call("urn:microsoft-dynamics-schemas/page/SalesHeader:ReadMultiple", soapEnvelope);
				
				//recuperation de la reponce 
				result = (SoapObject) soapEnvelope.getResponse();
				String NoLine=null;
				String Unit_of_Measure_Code=null;
				String Unit_of_Measure= null;
				
				for (int i = 0; i < result.getPropertyCount(); i++) {
					//System.out.println("all"+i);
						
					SoapObject oneElemnetofResult = (SoapObject) result.getProperty(i);
					//System.out.println(oneElemnetofResult.getProperty("Status").toString());
					if(oneElemnetofResult.getProperty("Status").toString().equals("Open")) {
						SoapObject SalesLinestable=(SoapObject) oneElemnetofResult.getProperty("SalesLines");
						ArrayList<SalesLine> TableOfSaleLinePerElement = new ArrayList<SalesLine>();
						
						for(int j=0;j<SalesLinestable.getPropertyCount();j++) {
							SalesLine sl = new SalesLine();
							SoapObject ElementOfSalesLinestable= (SoapObject) SalesLinestable.getProperty(j);
							
							if (ElementOfSalesLinestable.hasProperty("No")==true) {
								NoLine=ElementOfSalesLinestable.getProperty("No").toString();
							}
							if (ElementOfSalesLinestable.hasProperty("Unit_of_Measure_Code")) {
								Unit_of_Measure_Code=ElementOfSalesLinestable.getProperty("Unit_of_Measure_Code").toString();
							}
							if (ElementOfSalesLinestable.hasProperty("Unit_of_Measure")) {
								Unit_of_Measure=ElementOfSalesLinestable.getProperty("Unit_of_Measure").toString();
							}
							
							sl.setKey(ElementOfSalesLinestable.getProperty("Key").toString());
							sl.setNo(NoLine);
							sl.setType(ElementOfSalesLinestable.getProperty("Type").toString());
							sl.setDocument_No(ElementOfSalesLinestable.getProperty("Document_No").toString());
							sl.setLine_No(ElementOfSalesLinestable.getProperty("Line_No").toString());
							sl.setQuantity(ElementOfSalesLinestable.getProperty("Quantity").toString());
							sl.setUnit_of_Measure(Unit_of_Measure);
							sl.setUnit_of_Measure_Code(Unit_of_Measure_Code);
							sl.setQty_to_Invoice(ElementOfSalesLinestable.getProperty("Qty_to_Invoice").toString());
							TableOfSaleLinePerElement.add(sl);
							}
						if(oneElemnetofResult.hasProperty("Key")==true) {
							key_Order=oneElemnetofResult.getProperty("Key").toString();
							
						};
						if(oneElemnetofResult.hasProperty("No")==true) {
							No=oneElemnetofResult.getProperty("No").toString();
						};
						if(oneElemnetofResult.hasProperty("Sell_to_Customer_No")==true) {
							Sell_to_Customer_No=oneElemnetofResult.getProperty("Sell_to_Customer_No").toString();
						};
						if(oneElemnetofResult.hasProperty("Sell_to_Customer_Name")==true) {
								Sell_to_Customer_Name=oneElemnetofResult.getProperty("Sell_to_Customer_Name").toString();
							};
						if(oneElemnetofResult.hasProperty("Posting_Description")==true) {
							Posting_Description=oneElemnetofResult.getProperty("Posting_Description").toString();
							};
						if(oneElemnetofResult.hasProperty("Sell_to_Address")==true) {
							Sell_to_Address=oneElemnetofResult.getProperty("Sell_to_Address").toString();
							};
						if(oneElemnetofResult.hasProperty("Sell_to_City")==true) {
							Sell_to_City=oneElemnetofResult.getProperty("Sell_to_City").toString();
						}
						if(oneElemnetofResult.hasProperty("Sell_to_County")==true) {
							Sell_to_County=oneElemnetofResult.getProperty("Sell_to_County").toString();
						};
						if(oneElemnetofResult.hasProperty("Order_Date")==true) {
							Order_Date=oneElemnetofResult.getProperty("Order_Date").toString();
						};
						if(oneElemnetofResult.hasProperty("Due_Date")==true) {
							Due_Date=oneElemnetofResult.getProperty("Due_Date").toString();
						};
						if(oneElemnetofResult.hasProperty("Prepayment_Due_Date")==true) {
							Prepayment_Due_Date=oneElemnetofResult.getProperty("Prepayment_Due_Date").toString();
						};
						if(oneElemnetofResult.hasProperty("Prepmt_Pmt_Discount_Date")==true) {
							Prepmt_Pmt_Discount_Date=oneElemnetofResult.getProperty("Prepmt_Pmt_Discount_Date").toString();
						};
						if(oneElemnetofResult.hasProperty("Location_Code")==true) {
							Location_Code=oneElemnetofResult.getProperty("Location_Code").toString();
						};
						
						SalesOrder salesOrder =new SalesOrder(key_Order,No,
								Sell_to_Customer_No,
								Sell_to_Customer_Name,
								Posting_Description,
								Sell_to_Address,
								Sell_to_City,
								Sell_to_County,
								Order_Date,
								Due_Date,
								Prepmt_Pmt_Discount_Date,
								Location_Code, Location_Code,
								TableOfSaleLinePerElement);
						
						SalesOrderList.add(salesOrder);	
						}
					}
					
					
					
				System.out.println("The GetAllOpenSalesOrder methode have been requested successfully Congrats ;)");
			
				
	        } catch (NullPointerException exception) {
				exception.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (XmlPullParserException e) {
				e.printStackTrace();
			}
			return SalesOrderList;
		}

		public void deleteSalesOrder(Key key) {
			SoapObject result;
			
			
			
			//creation de l'envelope soap
			SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			soapEnvelope.dotNet = true;
			soapEnvelope.avoidExceptionForUnknownProperty = true;
			soapEnvelope.setAddAdornments(false);
			
			//initialisation de la requette soap                 Targetnamesapce                    operation name
			SoapObject soapRequest = new SoapObject("urn:microsoft-dynamics-schemas/page/salesheader", "Delete");
			soapRequest.addProperty("Key",key.getKey());
			soapEnvelope.setOutputSoapObject(soapRequest);
			
			
			//configuration de l'Ntlm et du protocole http
			NtlmTransport httpTransport = new NtlmTransport(config.url);
			httpTransport.setCredentials(config.login,config.pwd, config.domaine, config.worksattion);
		    httpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			httpTransport.debug = true;
			
			
			try {
				 httpTransport.call("urn:microsoft-dynamics-schemas/page/salesheader:Delete", soapEnvelope);
				// result = (SoapObject) soapEnvelope.getResponse();
				System.out.println("the line with the following key "+key.getKey()+" has been deleted successfully");
				 
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		
		}
}
