package Entity;

public class Reception {
	String idCommande;
	String IDItem;
	String IDUser;
	public Reception() {
		super();
	}
	public Reception(String idCommande, String iDItem, String iDUser) {
		super();
		this.idCommande = idCommande;
		IDItem = iDItem;
		IDUser = iDUser;
	}
	public String getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(String idCommande) {
		this.idCommande = idCommande;
	}
	public String getIDItem() {
		return IDItem;
	}
	public void setIDItem(String iDItem) {
		IDItem = iDItem;
	}
	public String getIDUser() {
		return IDUser;
	}
	public void setIDUser(String iDUser) {
		IDUser = iDUser;
	}
	
	
}
