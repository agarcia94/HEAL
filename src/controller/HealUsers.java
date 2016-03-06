package controller;

public class HealUsers {
	
	private String fullName;
	private String email;
	private String password;
	private String retypePassword;

	
		public HealUsers (String fullName, String email , String password , String retypePassword){
		
		
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.retypePassword = retypePassword;
	}

		public HealUsers() {
			// TODO Auto-generated constructor stub
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}


		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRetypePassword() {
			return retypePassword;
		}

		public void setRetypePassword(String retypePassword) {
			this.retypePassword = retypePassword;
		}

		public String toString(){
			
			return email + "  " + password;
		}

}