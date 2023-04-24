package TP2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.GraphGenerator;

import org.junit.jupiter.api.Test;

class GraphSimpleACVpTest {
	
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
	// V min- = -1 ; p min- = -0.00001
	void test1() {
		assertThrows(Exception.class, () -> {
			int v = -1;
			double p = -0.00001;
			graph = GraphGenerator.simple(v, p);
		});
	}

	@Test
	// V min- = -1 ; p min = 0
	void test2() {
		assertThrows(Exception.class, () -> {
			int v = -1;
			double p = 0.0;
			graph = GraphGenerator.simple(v, p);
		});
	}
	
	@Test
	// V min- = -1 ; p nom = 0.21421421
	void test3() {
		assertThrows(Exception.class, () -> {
			int v = -1;
			double p = 0.21421421;
			graph = GraphGenerator.simple(v, p);
		});
	}
	
	@Test
	// V min- = -1 ; p max = 1;
	void test4() {
		assertThrows(Exception.class, () -> {
			int v = -1;
			double p = 1.0;
			graph = GraphGenerator.simple(v, p);
		});
	}
	
	@Test
	// V min- = -1 ; p max+ = 1.0000001
	void test5() {
		assertThrows(Exception.class, () -> {
			int v = -1;
			double p = 1.0000001;
			graph = GraphGenerator.simple(v, p);
		});
	}
	
	@Test
	// V min = 0 ; p min- = -0.00001
	void test6() {
		assertThrows(Exception.class, () -> {
			int v = 0;
			double p = -0.00001;
			graph = GraphGenerator.simple(v, p);
		});
	}
	
	@Test
	// V min = 0 ; p min = 0
	void test7() {
		int v = 0;
		double p = 0.0;
		graph = GraphGenerator.simple(v, p);
		assertEquals(graph.V(), v);
	}
	
	@Test
	// V min = 0 ; p nom = 0.21412421
	void test8() {
		int v = 0;
		double p = 0.21412421;
		graph = GraphGenerator.simple(v, p);
		assertEquals(graph.V(), v);
	}
	
	@Test
	// V min = 0 ; p max = 1.0
	void test9() {
		int v = 0;
		double p = 1.0;
		graph = GraphGenerator.simple(v, p);
		assertEquals(graph.V(), v);
	}
	
	@Test
	// V min = 0 ; p max+ = 1.00001
	void test10() {
		assertThrows(Exception.class, () -> {
			int v = 0;
			double p = 1.00001;
			graph = GraphGenerator.simple(v, p);
		});
	}
	
	@Test
	// V nom = 10 ; p min- = -0.00001
	void test11() {
		assertThrows(Exception.class, () -> {
			int v = 10;
			double p = -0.00001;
			graph = GraphGenerator.simple(v, p);
		});
	}
	
	@Test
	// V nom = 10 ; p min = 0
	void test12() {
		int v = 10;
		double p = 0.0;
		graph = GraphGenerator.simple(v, p);
		assertEquals(graph.V(), v);
	}
	
	@Test
	// V nom = 10 ; p nom = 0.12421412
	void test13() {
		int v = 10;
		double p = 0.12421412;
		graph = GraphGenerator.simple(v, p);
		assertEquals(graph.V(), v);
	}
	
	@Test
	// V nom = 10 ; p max = 1
	void test14() {
		int v = 10;
		double p = 1;
		graph = GraphGenerator.simple(v, p);
		assertEquals(graph.V(), v);
	}
	
	@Test
	// V nom = 10 ; p max = 1.00001
	void test15() {
		assertThrows(Exception.class, () -> {
			int v = 10;
			double p = 1.00001;
			graph = GraphGenerator.simple(v, p);
		});
	}
	
}
