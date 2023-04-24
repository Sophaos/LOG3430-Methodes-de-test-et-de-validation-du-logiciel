package TP2;

import static org.junit.jupiter.api.Assertions.*;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.GraphGenerator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphSimpleECVpTest {
	
	Graph graph;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	/*
	 v:
	 	min-	erreur
	 	min		ok
	 	nom		ok
	 p:
	 	min-	erreur
	 	min		ok
	 	nom		ok
	 	max		ok
	 	max+	erreur
	 */
	
	@Test

	// V min- = 0 ; p min- = -0.00001
	void test1() {
		assertThrows(Exception.class, () -> {
			int v = 0;
			double p = -0.00001;
			graph = GraphGenerator.simple(v, p);
		});
	}
	
	@Test
	// v nom = 1, p min = 0
	void test2() {
		int v = 1;
		double p = 0.0;
		graph = GraphGenerator.simple(v, p);
		assertEquals(graph.V(), v);
	}
	
	@Test
	// V min- = -1, p nom = 0.012321
	void test3() {
		assertThrows(Exception.class, () -> {
			int v = -1;
			double p = 0.012321;
			graph = GraphGenerator.simple(v, p);
		});
	}
	
	@Test
	// v min = 0, p nom = 0.000001
	void test4() {
		int v = 0;
		double p = 0.000001;
		graph = GraphGenerator.simple(v, p);
		assertEquals(graph.V(), v);
	}
	
	@Test
	// v nom = 1, p max = 1
	void test5() {
		int v = 1;
		double p = 1;
		graph = GraphGenerator.simple(v, p);
		assertEquals(graph.V(), v);
	}
	
	@Test

	// V min = 0 , p max+ = 1.00001
	void test6() {
		assertThrows(Exception.class, () -> {
			int v = 0;
			double p = 1.00001;
			graph = GraphGenerator.simple(v, p);
		});
	}
	

}
