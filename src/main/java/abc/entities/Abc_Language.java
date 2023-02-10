package abc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "Abc_Language")
public class Abc_Language implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLanguage;
	@Column(length = 255)
	private String dLanguage;
	
	public Abc_Language() {
		super();
	}

	public int getIdLanguage() {
		return idLanguage;
	}

	public void setIdLanguage(int idLanguage) {
		this.idLanguage = idLanguage;
	}

	public String getdLanguage() {
		return dLanguage;
	}

	public void setdLanguage(String dLanguage) {
		this.dLanguage = dLanguage;
	}

	
}
