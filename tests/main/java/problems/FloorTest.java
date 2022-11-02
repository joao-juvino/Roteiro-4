package main.java.problems;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.java.GeneralSetUp;
import problems.Floor;
import problems.FloorBinarySearchImpl;

public class FloorTest {
	GeneralSetUp gs = new GeneralSetUp();
	Floor floor;

	@Before
	public void setUp() {
		this.floor = new FloorBinarySearchImpl();
		this.gs.setUp();
	}

	@Test
	public void testArrayTamParValorNaoExistente() {
		int valor = this.floor.floor(this.gs.arrayTamPar, 4);
		assertEquals(3,  valor);
	}
	
	@Test
	public void testArrayTamParValorExistente() {
		int valor = this.floor.floor(this.gs.arrayTamPar, 3);
		assertEquals(3,  valor);
	}
	
	@Test
	public void testArrayTamParValorExtremoLeft() {
		int valor = this.floor.floor(this.gs.arrayTamPar, 1);
		assertEquals(1,  valor);
	}
	
	@Test
	public void testArrayTamParValorExtremoRight() {
		int valor = this.floor.floor(this.gs.arrayTamPar, 8);
		assertEquals(8,  valor);
	}
	
	@Test
	public void testArrayTamParValorAbaixoExtremoLeft() {
		assertNull(this.floor.floor(this.gs.arrayTamPar, -1));
	}
	
	@Test
	public void testArrayTamParValorAcimaExtremoRight() {
		int valor = this.floor.floor(this.gs.arrayTamPar, 9);
		assertEquals(8,  valor);
	}
	
	@Test
	public void testArrayTamImparValorNaoExistente() {
		int valor = this.floor.floor(this.gs.arrayTamImpar, 4);
		assertEquals(3,  valor);
	}
	
	@Test
	public void testArrayTamImparValorExistente() {
		int valor = this.floor.floor(this.gs.arrayTamImpar, 3);
		assertEquals(3,  valor);
	}
	
	@Test
	public void testArrayTamImparValorExtremoLeft() {
		int valor = this.floor.floor(this.gs.arrayTamImpar, 1);
		assertEquals(1,  valor);
	}
	
	@Test
	public void testArrayTamImparValorExtremoRight() {
		int valor = this.floor.floor(this.gs.arrayTamImpar, 9);
		assertEquals(9,  valor);
	}
	
	@Test
	public void testArrayTamImparValorAbaixoExtremoLeft() {
		assertNull(this.floor.floor(this.gs.arrayTamImpar, -1));
	}
	
	@Test
	public void testArrayTamImparValorAcimaExtremoRight() {
		int valor = this.floor.floor(this.gs.arrayTamImpar, 10);
		assertEquals(9,  valor);
	}
	
	@Test
	public void testArrayNegativoTamParValorNaoExistente() {
		int valor = this.floor.floor(this.gs.arrayNegativoTamPar, 4);
		assertEquals(2,  valor);
	}
	
	@Test
	public void testArrayNegativoTamParValorExistente() {
		int valor = this.floor.floor(this.gs.arrayNegativoTamPar, 2);
		assertEquals(2,  valor);
	}
	
	@Test
	public void testArrayNegativoTamParValorExtremoLeft() {
		int valor = this.floor.floor(this.gs.arrayNegativoTamPar, -8);
		assertEquals(-8,  valor);
	}
	
	@Test
	public void testArrayNegativoTamParValorExtremoRight() {
		int valor = this.floor.floor(this.gs.arrayNegativoTamPar, 9);
		assertEquals(9,  valor);
	}
	
	@Test
	public void testArrayNegativoTamParValorAbaixoExtremoLeft() {
		assertNull(this.floor.floor(this.gs.arrayNegativoTamPar, -9));
	}
	
	@Test
	public void testArrayNegativoTamParValorAcimaExtremoRight() {
		int valor = this.floor.floor(this.gs.arrayNegativoTamPar, 10);
		assertEquals(9,  valor);
	}
	
	@Test
	public void testArrayNegativoTamImparValorNaoExistente() {
		int valor = this.floor.floor(this.gs.arrayNegativoTamImpar, 4);
		assertEquals(2,  valor);
	}
	
	@Test
	public void testArrayNegativoTamImparValorExistente() {
		int valor = this.floor.floor(this.gs.arrayNegativoTamImpar, 2);
		assertEquals(2,  valor);
	}
	
	@Test
	public void testArrayNegativoTamImparValorExtremoLeft() {
		int valor = this.floor.floor(this.gs.arrayNegativoTamImpar, -10);
		assertEquals(-10,  valor);
	}
	
	@Test
	public void testArrayNegativoTamImparValorExtremoRight() {
		int valor = this.floor.floor(this.gs.arrayNegativoTamImpar, 9);
		assertEquals(9,  valor);
	}
	
	@Test
	public void testArrayNegativoTamImparValorAbaixoExtremoLeft() {
		assertNull(this.floor.floor(this.gs.arrayNegativoTamImpar, -11));
	}
	
	@Test
	public void testArrayNegativoTamImparValorAcimaExtremoRight() {
		int valor = this.floor.floor(this.gs.arrayNegativoTamImpar, 10);
		assertEquals(9,  valor);
	}

	@Test
	public void testArrayVazioValorPositivo() {
		assertNull(this.floor.floor(this.gs.arrayVazio, 3));
	}
	
	@Test
	public void testArrayVazioValorNegativo() {
		assertNull(this.floor.floor(this.gs.arrayVazio, -3));
	}
	
	@Test
	public void testArrayFullZerosTamParValorMaiorExtremo() {
		int valor = this.floor.floor(this.gs.arrayFullZerosTamPar, 3);
		assertEquals(valor, 0);
	}
	
	@Test
	public void testArrayFullZerosTamParValorExistente() {
		int valor = this.floor.floor(this.gs.arrayFullZerosTamPar, 0);
		assertEquals(valor, 0);
	}
	
	@Test
	public void testArrayFullZerosTamParValorMenorExtremo() {
		assertNull(this.floor.floor(this.gs.arrayFullZerosTamPar, -3));
	}	
	
	@Test
	public void testArrayFullZerosTamImparValorMaiorExtremo() {
		int valor = this.floor.floor(this.gs.arrayFullZerosTamImpar, 3);
		assertEquals(valor, 0);
	}
	
	@Test
	public void testArrayFullZerosTamImparExistente() {
		int valor = this.floor.floor(this.gs.arrayFullZerosTamImpar, 0);
		assertEquals(valor, 0);
	}
	
	@Test
	public void testArrayFullZerosTamImparValorMenorExtremo() {
		assertNull(this.floor.floor(this.gs.arrayFullZerosTamImpar, -3));
	}
	
	@Test
	public void testArrayNuloTamPar() {
		assertNull(this.floor.floor(this.gs.arrayNuloTamPar, 3));
	}
	
	@Test
	public void testArrayNuloTamImpar() {
		assertNull(this.floor.floor(this.gs.arrayNuloTamImpar, 3));
	}
	
	@Test
	public void testArrayFullNuloTamPar() {
		assertNull(this.floor.floor(this.gs.arrayFullNuloTamPar, 3));
	}
	
	@Test
	public void testArrayFullNuloTamImpar() {
		assertNull(this.floor.floor(this.gs.arrayFullNuloTamImpar, 3));
	}

}
















