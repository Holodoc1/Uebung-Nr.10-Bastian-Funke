package p1;

public class P1_Main {

	public static void main(String[] args) {
		Betrag test = new Betrag(13,60);
		Betrag test2 = new Betrag(10,480);
		Betrag summe = summe(test,test2);
		System.out.println(summe.getEuro());
		System.out.println(summe.getCent());
	}
	
	public static Betrag summe(Betrag a, Betrag b) {
		Betrag result = new Betrag(a.getEuro() + b.getEuro(), a.getCent() + b.getCent());
		return result;
	}
}
