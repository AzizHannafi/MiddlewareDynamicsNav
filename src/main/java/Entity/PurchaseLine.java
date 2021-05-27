package Entity;

public class PurchaseLine {	
	String Key,
		   itemNo,
		   Type,
		   Unit_of_Measure_Code,
		   Unit_of_Measure,
		   Document_No,
		   Line_No,
		   Description,
	       Quantity;

	public PurchaseLine() {
		super();
	}

	
	
	public PurchaseLine(String key, String itemNo, String type, String unit_of_Measure_Code, String unit_of_Measure,
			String document_No, String line_No, String description, String quantity) {
		super();
		Key = key;
		this.itemNo = itemNo;
		Type = type;
		Unit_of_Measure_Code = unit_of_Measure_Code;
		Unit_of_Measure = unit_of_Measure;
		Document_No = document_No;
		Line_No = line_No;
		Description = description;
		Quantity = quantity;
	}



	//this can be deleted later
	public PurchaseLine(String key, String type, String unit_of_Measure_Code, String unit_of_Measure,
			String document_No, String line_No) {
		super();
		Key = key;
		Type = type;
		Unit_of_Measure_Code = unit_of_Measure_Code;
		Unit_of_Measure = unit_of_Measure;
		Document_No = document_No;
		Line_No = line_No;
	}

	public String getKey() {
		return Key;
	}

	public void setKey(String key) {
		Key = key;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getUnit_of_Measure_Code() {
		return Unit_of_Measure_Code;
	}

	public void setUnit_of_Measure_Code(String unit_of_Measure_Code) {
		Unit_of_Measure_Code = unit_of_Measure_Code;
	}

	public String getUnit_of_Measure() {
		return Unit_of_Measure;
	}

	public void setUnit_of_Measure(String unit_of_Measure) {
		Unit_of_Measure = unit_of_Measure;
	}

	public String getDocument_No() {
		return Document_No;
	}

	public void setDocument_No(String document_No) {
		Document_No = document_No;
	}

	public String getLine_No() {
		return Line_No;
	}

	public void setLine_No(String line_No) {
		Line_No = line_No;
	}



	public String getItemNo() {
		return itemNo;
	}



	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}



	public String getDescription() {
		return Description;
	}



	public void setDescription(String description) {
		Description = description;
	}



	public String getQuantity() {
		return Quantity;
	}



	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
	
	

}
