package Entity;

import java.util.List;

public class SalesOrder {

	private String 	Key,
					No,
					Sell_to_Customer_No,
					Sell_to_Customer_Name,
					Posting_Description,
					Sell_to_Address,
					Sell_to_City,
					Sell_to_County,
					Order_Date,
					Due_Date,
					Prepayment_Due_Date,
					Prepmt_Pmt_Discount_Date,
					Location_Code,
					Status;
					List<SalesLine> salesLine;
				/*	No_of_Archived_Versions,
				 * Sell_to_Post_Code,
					Sell_to_Country_Region_Code,
					Sell_to_Contact_No,Sell_to_Contact,
					Document_Date,
					Posting_Date,
					Requested_Delivery_Date,
					Promised_Delivery_Date,
					Salesperson_Code,
					Job_Queue_Status,
					Status,
					Currency_Code,
					Prices_Including_VAT,
					VAT_Bus_Posting_Group,
					Payment_Terms_Code,
					EU_3_Party_Trade,
					SelectedPayments,
					Shortcut_Dimension_1_Code,
					Payment_Discount_Percent,
					Pmt_Discount_Date,
					ShippingOptions,
					Ship_to_Name,
					Ship_to_Address,
					Ship_to_City,
					Ship_to_County,
					Ship_to_Post_Code,
					Ship_to_Country_Region_Code,
					Ship_to_Contact,
					Shipment_Method_Code,
					BillToOptions,
					Bill_to_Name,
					Bill_to_Address,
					Bill_to_City,
					Bill_to_County,
					Bill_to_Post_Code,
					Bill_to_Country_Region_Code,
					Bill_to_Contact_No,
					Bill_to_Contact,
					Shipping_Advice,
					Outbound_Whse_Handling_Time,
					Late_Order_Shipping,
					Prepayment_Percent,
					Compress_Prepayment,
					Prepmt_Payment_Terms_Code,
					Prepmt_Payment_Discount_Percent,*/

					
	public SalesOrder(String no, String sell_to_Customer_No, String sell_to_Customer_Name, String posting_Description,
			String sell_to_Address, String sell_to_City, String sell_to_County, String order_Date, String due_Date,
			String prepayment_Due_Date, String prepmt_Pmt_Discount_Date, String location_Code) {
		super();
		No = no;
		Sell_to_Customer_No = sell_to_Customer_No;
		Sell_to_Customer_Name = sell_to_Customer_Name;
		Posting_Description = posting_Description;
		Sell_to_Address = sell_to_Address;
		Sell_to_City = sell_to_City;
		Sell_to_County = sell_to_County;
		Order_Date = order_Date;
		Due_Date = due_Date;
		Prepayment_Due_Date = prepayment_Due_Date;
		Prepmt_Pmt_Discount_Date = prepmt_Pmt_Discount_Date;
		Location_Code = location_Code;
	}
	
	

	public SalesOrder(String key, String no, String sell_to_Customer_No, String sell_to_Customer_Name,
						String posting_Description, String sell_to_Address, String sell_to_City, String sell_to_County,
						String order_Date, String due_Date, String prepayment_Due_Date, String prepmt_Pmt_Discount_Date,
						String location_Code, String status, List<SalesLine> salesLine) {
					super();
					Key = key;
					No = no;
					Sell_to_Customer_No = sell_to_Customer_No;
					Sell_to_Customer_Name = sell_to_Customer_Name;
					Posting_Description = posting_Description;
					Sell_to_Address = sell_to_Address;
					Sell_to_City = sell_to_City;
					Sell_to_County = sell_to_County;
					Order_Date = order_Date;
					Due_Date = due_Date;
					Prepayment_Due_Date = prepayment_Due_Date;
					Prepmt_Pmt_Discount_Date = prepmt_Pmt_Discount_Date;
					Location_Code = location_Code;
					Status = status;
					this.salesLine = salesLine;
				}



	public String getStatus() {
		return Status;
	}



	public void setStatus(String status) {
		Status = status;
	}



	public SalesOrder(String key, String no, String sell_to_Customer_No, String sell_to_Customer_Name,
						String posting_Description, String sell_to_Address, String sell_to_City, String sell_to_County,
						String order_Date, String due_Date, String prepayment_Due_Date, String prepmt_Pmt_Discount_Date,
						String location_Code, List<SalesLine> salesLine) {
					super();
					Key = key;
					No = no;
					Sell_to_Customer_No = sell_to_Customer_No;
					Sell_to_Customer_Name = sell_to_Customer_Name;
					Posting_Description = posting_Description;
					Sell_to_Address = sell_to_Address;
					Sell_to_City = sell_to_City;
					Sell_to_County = sell_to_County;
					Order_Date = order_Date;
					Due_Date = due_Date;
					Prepayment_Due_Date = prepayment_Due_Date;
					Prepmt_Pmt_Discount_Date = prepmt_Pmt_Discount_Date;
					Location_Code = location_Code;
					this.salesLine = salesLine;
				}



	public SalesOrder(String no, String sell_to_Customer_No, String sell_to_Customer_Name, String posting_Description,
			String sell_to_Address, String sell_to_City, String sell_to_County, String order_Date, String due_Date,
			String prepayment_Due_Date, String prepmt_Pmt_Discount_Date, String location_Code,
			List<SalesLine> salesLine) {
		super();
		No = no;
		Sell_to_Customer_No = sell_to_Customer_No;
		Sell_to_Customer_Name = sell_to_Customer_Name;
		Posting_Description = posting_Description;
		Sell_to_Address = sell_to_Address;
		Sell_to_City = sell_to_City;
		Sell_to_County = sell_to_County;
		Order_Date = order_Date;
		Due_Date = due_Date;
		Prepayment_Due_Date = prepayment_Due_Date;
		Prepmt_Pmt_Discount_Date = prepmt_Pmt_Discount_Date;
		Location_Code = location_Code;
		this.salesLine = salesLine;
	}



	public SalesOrder() {
		super();
	}

	public String getNo() {
		return No;
	}

	public void setNo(String no) {
		No = no;
	}

	public String getSell_to_Customer_No() {
		return Sell_to_Customer_No;
	}

	public void setSell_to_Customer_No(String sell_to_Customer_No) {
		Sell_to_Customer_No = sell_to_Customer_No;
	}

	public String getSell_to_Customer_Name() {
		return Sell_to_Customer_Name;
	}

	public void setSell_to_Customer_Name(String sell_to_Customer_Name) {
		Sell_to_Customer_Name = sell_to_Customer_Name;
	}

	public String getPosting_Description() {
		return Posting_Description;
	}

	public void setPosting_Description(String posting_Description) {
		Posting_Description = posting_Description;
	}

	public String getSell_to_Address() {
		return Sell_to_Address;
	}

	public void setSell_to_Address(String sell_to_Address) {
		Sell_to_Address = sell_to_Address;
	}

	public String getSell_to_City() {
		return Sell_to_City;
	}

	public String getKey() {
		return Key;
	}



	public void setKey(String key) {
		Key = key;
	}



	public void setSell_to_City(String sell_to_City) {
		Sell_to_City = sell_to_City;
	}

	public String getSell_to_County() {
		return Sell_to_County;
	}

	public void setSell_to_County(String sell_to_County) {
		Sell_to_County = sell_to_County;
	}

	public String getOrder_Date() {
		return Order_Date;
	}

	public void setOrder_Date(String order_Date) {
		Order_Date = order_Date;
	}

	public String getDue_Date() {
		return Due_Date;
	}

	public void setDue_Date(String due_Date) {
		Due_Date = due_Date;
	}

	public String getPrepayment_Due_Date() {
		return Prepayment_Due_Date;
	}

	public void setPrepayment_Due_Date(String prepayment_Due_Date) {
		Prepayment_Due_Date = prepayment_Due_Date;
	}

	public String getPrepmt_Pmt_Discount_Date() {
		return Prepmt_Pmt_Discount_Date;
	}

	public void setPrepmt_Pmt_Discount_Date(String prepmt_Pmt_Discount_Date) {
		Prepmt_Pmt_Discount_Date = prepmt_Pmt_Discount_Date;
	}

	public String getLocation_Code() {
		return Location_Code;
	}

	public void setLocation_Code(String location_Code) {
		Location_Code = location_Code;
	}



	public List<SalesLine> getSalesLine() {
		return salesLine;
	}



	public void setSalesLine(List<SalesLine> salesLine) {
		this.salesLine = salesLine;
	}
					

	
	

	
}
