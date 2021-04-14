package application;

/**
 * Berechnet das Formelrad
 * @author Gilles Russo und Alex Schaub
 * @version 14.04.2021
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
