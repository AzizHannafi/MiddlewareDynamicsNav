package Configuration;

import org.springframework.stereotype.Component;

@Component
public  class Config {
	
	
	public    String url;
	public    String login;
	public    String pwd;
	public    String domaine;
	public    String worksattion;

		
	public String getLogin() {
		return login;
	}

	public Config() {
		super();
	}

	//here the configuration of username, domaine, password and workstation that's allow you to authentificate as Ntlm 
	public Config(String url) {
		super();
		this.url=url;
		this.login="AzizHannafi";
		this.pwd="azizhannafi@123";
		this.domaine="http://desktop-91llbl1:7047/BC130/WS/";
		this.worksattion="";
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	
	
	
}