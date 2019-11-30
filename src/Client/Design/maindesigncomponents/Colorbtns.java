package Client.design.maindesigncomponents;

public class Colorbtns {
	
	private Brush brush;
	private Blackbtn blackbtn;
	private Redbtn redbtn;
	private Bluebtn bluebtn;
	private Greenbtn greenbtn;
	private Yellowbtn yellowbtn;
	private Eraserbtn eraserbtn;
	
	public void makeButtons() {
		makeBlackButton();
		makeRedButton();
		makeBlueButton();
		makeGreenButton();
		makeYellowButton();
		makeEraserButton();
		makeClearButton();
	}
	
	private void makeBlackButton() {
		blackbtn = new Blackbtn();
		blackbtn.setBrush(brush);
	}
	
	private void makeRedButton() {
		redbtn = new Redbtn();
		redbtn.setBrush(brush);
	}
	
	private void makeBlueButton() {
		bluebtn = new Bluebtn();
		bluebtn.setBrush(brush);
	}
	
	private void makeGreenButton() {
		greenbtn = new Greenbtn();
		greenbtn.setBrush(brush);
	}
	
	private void makeYellowButton() {
		yellowbtn = new Yellowbtn();
		yellowbtn.setBrush(brush);
	}
	
	private void makeEraserButton() {
		eraserbtn = new Eraserbtn();
		eraserbtn.setBrush(brush);
	}
	
	private void makeClearButton() {
		
	}
	
	public void setBrush(Brush brush) {
		this.brush = brush;
	}
	
	public Blackbtn blackbtn() {
		return blackbtn;
	}
	
	public Redbtn redbtn() {
		return redbtn;
	}
	
	public Bluebtn bluebtn() {
		return bluebtn;
	}
	
	public Greenbtn greenbtn() {
		return greenbtn;
	}
	
	public Yellowbtn yellowbtn() {
		return yellowbtn;
	}
	
	public Eraserbtn eraserbtn() {
		return eraserbtn;
	}
}
