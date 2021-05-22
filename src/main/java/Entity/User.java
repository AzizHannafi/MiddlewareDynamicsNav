package Entity;

public class User {
		private String id;
		private String Username;
		private String Lastname;
		private String Password;
		private String LocationCode;
		
		public User() {
			super();
		}

	
		public User(String username, String lastname, String password, String locationCode) {
			super();
			Username = username;
			Lastname = lastname;
			Password = password;
			LocationCode = locationCode;
		}
		
		
		public User(String id, String username, String lastname, String password, String locationCode) {
			super();
			this.id = id;
			Username = username;
			Lastname = lastname;
			Password = password;
			LocationCode = locationCode;
		}


		public String getId() {
			return id;
		}


		public void setId(String id) {
			this.id = id;
		}


		public String getUsername() {
			return Username;
		}


		public void setUsername(String username) {
			Username = username;
		}


		public String getLastname() {
			return Lastname;
		}


		public void setLastname(String lastname) {
			Lastname = lastname;
		}


		public String getPassword() {
			return Password;
		}


		public void setPassword(String password) {
			Password = password;
		}


		public String getLocationCode() {
			return LocationCode;
		}


		public void setLocationCode(String locationCode) {
			LocationCode = locationCode;
		}
		
		
		
	}
