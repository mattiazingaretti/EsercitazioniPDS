package esercizioLezione;

public class MYInstructions implements Runnable{

	private String value ;
	
	public MYInstructions(String val) {
		this.value = val;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(this.value);
		}
			
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
