
public class Rate {
	private int cashAmount;
	private Horse horse;
	private Currency currency;
	private Client client;
	
	public Rate(int cash, Horse horse, Currency currency, Client client) {
		this.cashAmount = cash;
		this.horse = horse;
		this.currency = currency;
		this.client = client;
	}

	public int getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(int cashAmount) throws Exception {
		if (cashAmount<=0)
		{
			throw new Exception("Cash Amount cant be equal or less to 0");
		}
		this.cashAmount = cashAmount;
	}

	public Horse getHorse() {
		return horse;
	}

	public void setHorse(Horse horse) {
		this.horse = horse;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cashAmount;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((horse == null) ? 0 : horse.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rate other = (Rate) obj;
		if (cashAmount != other.cashAmount)
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (currency != other.currency)
			return false;
		if (horse == null) {
			if (other.horse != null)
				return false;
		} else if (!horse.equals(other.horse))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rate: Client "+ this.client.getName()+" cash: "+
				this.cashAmount+" "+this.currency.name()+" Horse:"+this.horse.getName();
	}
}
