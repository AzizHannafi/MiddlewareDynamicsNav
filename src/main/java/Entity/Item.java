package Entity;

public class Item {
		String Key,No,Description,Inventory,Base_Unit_of_Measure;

		
		
		public Item() {
			super();
		}

		public Item(String key, String no, String description, String inventory, 
				String base_Unit_of_Measure) {
			super();
			Key = key;
			No = no;
			Description = description;
			Inventory = inventory;
		
			Base_Unit_of_Measure = base_Unit_of_Measure;
		}

		public String getKey() {
			return Key;
		}

		public void setKey(String key) {
			Key = key;
		}

		public String getNo() {
			return No;
		}

		public void setNo(String no) {
			No = no;
		}

		public String getDescription() {
			return Description;
		}

		public void setDescription(String description) {
			Description = description;
		}

		public String getInventory() {
			return Inventory;
		}

		public void setInventory(String inventory) {
			Inventory = inventory;
		}

		
		public String getBase_Unit_of_Measure() {
			return Base_Unit_of_Measure;
		}

		public void setBase_Unit_of_Measure(String base_Unit_of_Measure) {
			Base_Unit_of_Measure = base_Unit_of_Measure;
		}
		
		
}
