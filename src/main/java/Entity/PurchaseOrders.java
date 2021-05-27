package Entity;

import java.util.List;

public class PurchaseOrders {
	String Key,
		   No,
		   Buy_from_Vendor_No,
		   Buy_from_Vendor_Name,
		   Posting_Description,
	       Status;
	public String getKey() {
		return Key;
	}


	public void setKey(String key) {
		Key = key;
	}

	List<PurchaseLine> PurchLines;
	
	public PurchaseOrders() {
		super();
	}

	
	public PurchaseOrders(String key, String no, String buy_from_Vendor_No, String buy_from_Vendor_Name,
			String posting_Description, String status, List<PurchaseLine> purchLines) {
		super();
		Key = key;
		No = no;
		Buy_from_Vendor_No = buy_from_Vendor_No;
		Buy_from_Vendor_Name = buy_from_Vendor_Name;
		Posting_Description = posting_Description;
		Status = status;
		PurchLines = purchLines;
	}


	public PurchaseOrders(String key, String no, String buy_from_Vendor_No, String buy_from_Vendor_Name,
			String posting_Description, List<PurchaseLine> purchLines) {
		super();
		Key = key;
		No = no;
		Buy_from_Vendor_No = buy_from_Vendor_No;
		Buy_from_Vendor_Name = buy_from_Vendor_Name;
		Posting_Description = posting_Description;
		PurchLines = purchLines;
	}


	public PurchaseOrders(String no, String buy_from_Vendor_No, String buy_from_Vendor_Name, String posting_Description,
			List<PurchaseLine> purchLines) {
		super();
		No = no;
		Buy_from_Vendor_No = buy_from_Vendor_No;
		Buy_from_Vendor_Name = buy_from_Vendor_Name;
		Posting_Description = posting_Description;
		PurchLines = purchLines;
	}

	public String getNo() {
		return No;
	}

	public void setNo(String no) {
		No = no;
	}

	public String getBuy_from_Vendor_No() {
		return Buy_from_Vendor_No;
	}

	public void setBuy_from_Vendor_No(String buy_from_Vendor_No) {
		Buy_from_Vendor_No = buy_from_Vendor_No;
	}

	public String getBuy_from_Vendor_Name() {
		return Buy_from_Vendor_Name;
	}

	public void setBuy_from_Vendor_Name(String buy_from_Vendor_Name) {
		Buy_from_Vendor_Name = buy_from_Vendor_Name;
	}

	public String getPosting_Description() {
		return Posting_Description;
	}

	public void setPosting_Description(String posting_Description) {
		Posting_Description = posting_Description;
	}

	public List<PurchaseLine> getPurchLines() {
		return PurchLines;
	}

	public void setPurchLines(List<PurchaseLine> purchLines) {
		PurchLines = purchLines;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}
	
	
	
}
