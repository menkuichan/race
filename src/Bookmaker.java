
public class Bookmaker extends Person {
		private int workExperience;
		private String workAddress;
		private String workNumber;
		
		public Bookmaker(String name, String surname, int age,
				int workExperience, String workAddress, String workNumber) {
			super(name, surname, age);
			this.workExperience = workExperience;
			this.workAddress = workAddress;
			this.workNumber = workNumber;
		}
		
		/**
		 * @return the workExperience
		 */
		public int getWorkExperience() {
			return workExperience;
		}
		/**
		 * @param workExperience the workExperience to set
		 * @throws Exception 
		 */
		public void setWorkExperience(int workExperience) throws Exception {
			if(workExperience < 0)
			{
				throw new Exception("Work Experience cant be less to 0");
			}
			this.workExperience = workExperience;
		}
		/**
		 * @return the workAddress
		 */
		public String getWorkAddress() {
			return workAddress;
		}
		/**
		 * @param workAddress the workAddress to set
		 */
		public void setWorkAddress(String workAddress) {
			this.workAddress = workAddress;
		}
		/**
		 * @return the workNumber
		 */
		public String getWorkNumber() {
			return workNumber;
		}
		/**
		 * @param workNumber the workNumber to set
		 */
		public void setWorkNumber(String workNumber) {
			this.workNumber = workNumber;
		}

		public void setWinRateForRate(HorseRun run, int winRate) {
			try {
				run.setWinRate(winRate);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + ((workAddress == null) ? 0 : workAddress.hashCode());
			result = prime * result + workExperience;
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
			Bookmaker other = (Bookmaker) obj;
			if (workAddress == null) {
				if (other.workAddress != null)
					return false;
			} else if (!workAddress.equals(other.workAddress))
				return false;
			if (workExperience != other.workExperience)
				return false;
			if (workNumber == null) {
				if (other.workNumber != null)
					return false;
			} else if (!workNumber.equals(other.workNumber))
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			return super.toString()+" Work Experience: "+this.workExperience+
					" Work Number: "+this.workNumber+" Work Address: "+this.workAddress;
		}
}
