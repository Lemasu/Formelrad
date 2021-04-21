package application;

/**
 * Berechnet das Formelrad
 * @author Gilles Russo und Alex Schaub
 * @version 21.04.2021
 */
public class Calculator {
	private double leistung;
	private double spannung;
	private double strom;
	private double widerstand;
	
	public Calculator(double leistung, double spannung, double strom, double widerstand) {
		super();
		this.leistung = leistung;
		this.spannung = spannung;
		this.strom = strom;
		this.widerstand = widerstand;
		this.calculate();
	}
	
	public double getLeistung() {
		return leistung;
	}
	
	public double getSpannung() {
		return spannung;
	}

	public double getStrom() {
		return strom;
	}

	public double getWiderstand() {
		return widerstand;
	}

	public double pAusUundI(double u, double i) {
		return u*i;
	}

	public double pAusRundI(double r, double i){
		return r*Math.pow(i,2);
	}

	public double pAusUundR(double u, double r){
		return u*u/r;
	}

	public double iAusPundR(double p, double r){
		return Math.sqrt(p/r);
	}

	public double iAusUundP(double u, double p){
		return p/u;
	}

	public double iAusUundR(double u, double r){
		return u/r;
	}

	public double rAusUundI(double u, double i){
		return u/i;
	}

	public double rAusPundI(double p, double i){
		return p/Math.pow(i,2);
	}

	public double rAusUundP(double p, double u){
		return Math.pow(u,2)/p;
	}

	@Override
	public String toString() {
		return "Calculator [leistung=" + leistung + 
				", spannung=" + spannung + 
				", strom=" + strom + 
				", widerstand="	+ widerstand + "]";
	}

	public void calculate() {
		if (leistung != 0.0 && spannung != 0.0) {
			strom = iAusUundP(spannung, leistung);
			widerstand = rAusUundP(leistung, spannung);
			System.out.println("Strom aus Spannung und Leistung " + spannung + ":" + leistung + " = " + iAusUundP(spannung,leistung));
		} else if (leistung != 0.0 && strom != 0.0) {
			spannung = uAusPdurchI(leistung, strom);
			widerstand = rAusPundI(leistung, strom);
		} else if (leistung != 0.0 && widerstand != 0.0) {
			spannung = uAusWurzelPmalR(leistung, widerstand);
			strom = iAusPundR(leistung, widerstand);
		} else if (spannung != 0.0 && strom != 0.0) {
			leistung = pAusUundI(spannung, strom);
			widerstand = rAusUundI(spannung, strom);
			System.out.println("Leistung aus Spannung und Strom " + spannung + "*" + strom + " = " + pAusUundI(spannung,strom));
			System.out.println("Widerstand aus Spannung und Strom " + spannung + ":" + strom + " = " + rAusUundI(spannung,strom));
		} else if (spannung != 0.0 && widerstand != 0.0) {
			leistung = pAusUundR(spannung, widerstand);
			strom = iAusUundR(spannung, widerstand);
			System.out.println("Leistung aus Spannung und Widerstand " + spannung + " * " + spannung + " / " + strom + " = " + pAusUundR(spannung,widerstand));
		} else if (strom != 0.0 && widerstand != 0.0) {
			leistung = pAusRundI(widerstand, strom);
			spannung = uAusRmalI(widerstand, strom);
		}
	}
	
	/* Hier die Methoden mit den Formlen hinzufügen
	 */

	public double uAusRmalI(double r, double i) {
		return r * i;
	}

	public double uAusPdurchI(double p, double i) {
		return p * i;
	}

	public double uAusWurzelPmalR(double p, double r) {
		return Math.sqrt(p * r);
	}
	
}
