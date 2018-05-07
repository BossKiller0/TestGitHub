package Com;

public class ValTime {

	private int Hours;
	private int Minutes;
	private int Sec;

	public ValTime(int hours, int minutes, int sec) {
		this.setHours(hours);
		this.setMinutes(minutes);
		this.setSec(sec);
		this.validate();
	}

	public int getSec() {
		return Sec;
	}

	public void setSec(int sec) {
		Sec = sec;
	}

	public int getMinutes() {
		return Minutes;
	}

	public void setMinutes(int minutes) {
		Minutes = minutes;
	}

	public int getHours() {
		return Hours;
	}

	public void setHours(int hours) {
		Hours = hours;
	}

	public void validate() {

		while (this.getSec() > 59) {
			this.setSec(this.getSec() - 59);
			this.setMinutes(this.getMinutes() + 1);
		}

		while (this.getMinutes() > 59) {
			this.setMinutes(this.getMinutes() - 59);
			this.setHours(this.getHours() + 1);
		}
		
		System.out.println(this.Hours +" Hours "+ this.getMinutes()+" Minutes "+this.getSec()+" Seconds ");

	}

}
