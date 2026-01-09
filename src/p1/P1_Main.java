package p1;

public class P1_Main {

	public static void main(String[] args) {

	}
	
	public static Betrag summe(Betrag a, Betrag b) {
		Betrag result = new Betrag(a.getEuro() + b.getEuro(), a.getCent() + b.getCent());
		return result;
	}
}
