package main.java;

public class GeneralSetUp {
	public Integer[] arrayTamPar;
	public Integer[] arrayTamImpar;

	public Integer[] arrayNegativoTamPar;
	public Integer[] arrayNegativoTamImpar;

	public Integer[] arrayVazio;

	public Integer[] arrayNuloTamPar;
	public Integer[] arrayNuloTamImpar;

	public Integer[] arrayFullNuloTamPar;
	public Integer[] arrayFullNuloTamImpar;

	public Integer[] arrayFullZerosTamPar;
	public Integer[] arrayFullZerosTamImpar;

	public void setUp() {
		this.arrayTamPar = new Integer[] { 1, 2, 3, 5, 6, 7, 8 };
		this.arrayTamImpar = new Integer[] { 1, 2, 3, 5, 6, 7, 8, 9 };

		this.arrayNegativoTamPar = new Integer[] { 1, 2, -3, 0, -6, 7, -8, 9 };
		this.arrayNegativoTamImpar = new Integer[] { 1, 2, -3, 0, -6, 7, -8, 9, -10 };

		this.arrayVazio = new Integer[] {};

		this.arrayNuloTamPar = new Integer[] { 1, null, 3, 5, 6, null, 8, null };
		this.arrayNuloTamImpar = new Integer[] { 1, null, 3, 5, 6, null, 8, null, null };

		this.arrayFullNuloTamPar = new Integer[] { null, null, null, null, null, null };
		this.arrayFullNuloTamImpar = new Integer[] { null, null, null, null, null, null, null };

		this.arrayFullZerosTamPar = new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		this.arrayFullZerosTamImpar = new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	}

}
