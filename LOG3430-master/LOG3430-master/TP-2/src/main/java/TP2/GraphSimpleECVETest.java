package TP2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.GraphGenerator;

class GraphSimpleECVETest {
	
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
	 e:
	 	min-	erreur
	 	min		ok
	 	nom		ok
	 	max		ok
	 	max+	erreur
	 */
	@Test
	// v min- = -1 ; e min = 0
	void test1() {
		assertThrows(Exception.class, () -> {
			int v = -1;
			int e = 0;
			graph = GraphGenerator.simple(v, e);
		});
	}
	
	@Test
	// v min = 0 ; e min- = -1
	void test2() {
		assertThrows(Exception.class, () -> {
			int v = 0;
			int e = -1;
			graph = GraphGenerator.simple(v, e);
		});
	}
	
	@Test
	// v min = 0 ; e min = 0
	void test3() {
		int v = 0;
		int e = 0;
		graph = GraphGenerator.simple(v, e);
		assertEquals(graph.V(), v);
		assertEquals(graph.E(), e);
	}
	
	@Test
	// v nom = 9 ; e nom = 10
	void test4() {
		int v = 9;
		int e = 10;
		graph = GraphGenerator.simple(v, e);
		assertEquals(graph.V(), v);
		assertEquals(graph.E(), e);
	}
	
	@Test
	// v nominal = 5 ; e max = v*(v-1)/2 (v=5)
	void test5() {
		int v = 5;
		int e = v*(v-1)/2;
		graph = GraphGenerator.simple(v, e);
		assertEquals(graph.V(), v);
		assertEquals(graph.E(), e);
	}
	
	@Test
	// v nominal = 5 ; e max+ = v*(v-1)/2 + 1 (v=5)
	void test6() {
		assertThrows(Exception.class, () -> {
			int v = 5;
			int e = (v*(v-1)/2) + 1;
			graph = GraphGenerator.simple(v, e);
		});
	}

}
