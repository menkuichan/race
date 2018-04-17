package by.grsu.solomenskay.datamodel;

public class Administrator extends Person {	
	private String workNumber;
	
	public Administrator(String name, String surname, int age, String workNumber) {
		super(name, surname, age);
		this.setWorkNumber(workNumber);
	}

	public String getWorkNumber() {
		return workNumber;
	}

	public void setWorkNumber(String workNumber) {
		this.workNumber = workNumber;
	}
	
	public void SetScoreForHorseRun(HorseRun run, int score) {
		run.setScore(score);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((workNumber == null) ? 0 : workNumber.hashCode());
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
		Administrator other = (Administrator) obj;
		if (workNumber == null) {
			if (other.workNumber != null)
				return false;
		} else if (!workNumber.equals(other.workNumber))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString()+" Work Number: "+this.workNumber;
	}
}
