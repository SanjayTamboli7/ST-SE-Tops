package crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblcustomerquery")
public class QueryModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pkqueryid;
	private String customeremailid, description, suggestion;

	
	public int getPkqueryid() {
		return pkqueryid;
	}
	public void setPkqueryid(int pkqueryid) {
		this.pkqueryid = pkqueryid;
	}
	public String getCustomeremailid() {
		return customeremailid;
	}
	public void setCustomeremailid(String customeremailid) {
		this.customeremailid = customeremailid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
}
