package abc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Driver implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDriver;
	@Column(length = 255)
	private String driverName;
	
	public Driver() {
		super();
	}

	public int getIdDriver() {
		return idDriver;
	}

	public void setIdDriver(int idDriver) {
		this.idDriver = idDriver;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	
	
}
