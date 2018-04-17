package by.grsu.solomenskay.datamodel;
import java.time.*;

public class HorseRun {
	private int runCode;
	private LocalTime time;
	private Horse horse;
	private int score;
	private RunType type;
	private int winRate;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((horse == null) ? 0 : horse.hashCode());
		result = prime * result + runCode;
		result = prime * result + score;
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		HorseRun other = (HorseRun) obj;
		if (horse == null) {
			if (other.horse != null)
				return false;
		} else if (!horse.equals(other.horse))
			return false;
		if (runCode != other.runCode)
			return false;
		if (score != other.score)
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@SuppressWarnings("static-access")
	public HorseRun(int runCode, Horse horse, RunType type) {
		this.runCode = runCode;
		this.time = time.now();
		this.setHorse(horse);
		this.setType(type);
	}

	public int getRunCode() {
		return runCode;
	}

	public LocalTime getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "Horse Run: "+ this.runCode+" Time: "+this.time.toString();
	}

	public Horse getHorse() {
		return horse;
	}

	public void setHorse(Horse horse) {
		this.horse = horse;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public RunType getType() {
		return type;
	}

	public void setType(RunType type) {
		this.type = type;
	}

	public int getWinRate() {
		return winRate;
	}

	public void setWinRate(int winRate) throws Exception {
		if(winRate <=0)
		{
			throw new Exception("Win Rare cant be less to 0");
		}
		this.winRate = winRate;
	}
}
