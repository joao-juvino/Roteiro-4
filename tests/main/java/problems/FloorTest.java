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
	public void testeArrayTamPar() {
		this.floor.floor(this.gs.arrayTamPar, 4);
	}

	@Test
	public void testeArrayTamImpar() {
		this.floor.floor(this.gs.arrayTamImpar, 4);
	}
}
