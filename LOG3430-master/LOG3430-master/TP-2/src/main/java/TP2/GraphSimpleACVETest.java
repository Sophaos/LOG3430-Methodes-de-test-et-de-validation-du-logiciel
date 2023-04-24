package TP2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.GraphGenerator;

import org.junit.jupiter.api.Test;

class GraphSimpleACVETest {
	
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
	// v min- = -1 ; e min- = -1
	void test1() {
		assertThrows(Exception.class, () -> {
			int v = -1;
			int e = -1;
			graph = GraphGenerator.simple(v, e);
		});
	}
	
	@Test
	// v min- = -1 ; e min = 0
	void test2() {
		assertThrows(Exception.class, () -> {
			int v = -1;
			int e = 0;
			graph = GraphGenerator.simple(v, e);
		});
	}
	
	@Test
	// v min- = -1 ; e nom = 3
	void test3() {
		assertThrows(Exception.class, () -> {
			int v = -1;
			int e = 3;
			graph = GraphGenerator.simple(v, e);
		});
	}
	
	@Test
	// v min- = -1 ; e max = v*(v-1)/2 (v=-1)
	void test4() {
		assertThrows(Exception.class, () -> {
			int v = -1;
			int e = v*(v-1)/2;
			graph = GraphGenerator.simple(v, e);
		});
	}
	
	@Test
	// v min- = -1 ; e max+ = v*(v-1)/2 + 1 (v=-1)
	void test5() {
		assertThrows(Exception.class, () -> {
			int v = -1;
			int e = v*(v-1)/2 + 1;
			graph = GraphGenerator.simple(v, e);
		});
	}
	
	@Test
	// v min = 0 ; e max- = -1
	void test6() {
		assertThrows(Exception.class, () -> {
			int v = 0;
			int e = -1;
			graph = GraphGenerator.simple(v, e);
		});
	}
	
	@Test
	// v min = 0, e min = 0 ET vmin = 0 emax = 0
	void test7() {
		int v = 0;
		int e = 0;
		graph = GraphGenerator.simple(v, e);
		assertEquals(graph.V(), v);
		assertEquals(graph.E(), e);
	}
	
	@Test
	// v min = 0, e max+ = (v*(v-1)/2) + 1 (v=0)
	void test8() {
		assertThrows(Exception.class, () -> {
			int v = 0;
			int e = (v*(v-1)/2) + 1;
			graph = GraphGenerator.simple(v, e);
		});
	}
	
	@Test
	// v nom = 5 ; e min- = -1
	void test9() {
		assertThrows(Exception.class, () -> {
			int v = 5;
			int e = -1;
			graph = GraphGenerator.simple(v, e);
		});
	}
	
	@Test
	// v nom = 5 ; e min = 0
	void test10() {
		int v = 5;
		int e = 0;
		graph = GraphGenerator.simple(v, e);
		assertEquals(graph.V(), v);
		assertEquals(graph.E(), e);
	}
	
	
	@Test
	// v nominal = 5, e nominal = 5
	void test11() {
		int v = 5;
		int e = 6;
		graph = GraphGenerator.simple(v, e);
		assertEquals(graph.V(), v);
		assertEquals(graph.E(), e);
	}
	@Test
	// v nominal = 5, e max = v*(v-1)/2 (v = 5)
	void test12() {
		int v = 5;
		int e = v*(v-1)/2;
		graph = GraphGenerator.simple(v, e);
		assertEquals(graph.V(), v);
		assertEquals(graph.E(), e);
	}
	
	@Test
	// v nominal = 5, e max+ = v*(v-1)/2 + 1 (v = 5)
	void test13() {
		assertThrows(Exception.class, () -> {
			int v = 5;
			int e = (v*(v-1)/2) + 1;
			graph = GraphGenerator.simple(v, e);
		});
	}
	
	@Test
	// v min = 0, e nom
	void test14() {
		assertThrows(Exception.class, () -> {
			int v = 0;
			int e = 5;
			graph = GraphGenerator.simple(v, e);
		});
	}
	

}
