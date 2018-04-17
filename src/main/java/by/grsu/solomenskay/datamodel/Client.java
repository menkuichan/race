package by.grsu.solomenskay.datamodel;
public class Client extends Person {
	private String address;
	private String telephoneNumber;
	private String eMail;
	
	public Client(String name, String surname, int age, 
			String address, String telephone, String eMail) {
		super(name,surname,age);
		this.address = address;
		this.telephoneNumber = telephone;
		this.eMail = eMail;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the telephoneNumber
	 */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	/**
	 * @param telephoneNumber the telephoneNumber to set
	 */
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	/**
	 * @return the eMail
	 */
	public String geteMail() {
		return eMail;
	}
	/**
	 * @param eMail the eMail to set
	 */
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	@Override
	public String toString() {
		return "Person: "+this.getName()+" "+this.getSurname()+" Age: "+this.getAge()
		+" telephone: "+this.getTelephoneNumber()+" email: "+this.geteMail()+" address:"
		+this.getAddress();		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		result = prime * result + ((telephoneNumber == null) ? 0 : telephoneNumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		if (telephoneNumber == null) {
			if (other.telephoneNumber != null)
				return false;
		} else if (!telephoneNumber.equals(other.telephoneNumber))
			return false;
		return true;
	}
}
