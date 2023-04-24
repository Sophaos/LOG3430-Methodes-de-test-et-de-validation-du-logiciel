package TP2;

import static org.junit.jupiter.api.Assertions.*;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.GraphGenerator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphBipartiteECV1V2pTest {
	
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
	 V1:
	 	min-	V1 < 0
	 	min		V1 = 0
	 	nom		V1 > 0
	 V2:
	 	min-	V2 < 0
	 	min		V2 = 0
	 	nom		V2 > 0
	 p:
	 	min-	p < 0
	 	nom		0 <= p <= 1
	 	max+	p > 1
	 */
	
	@Test
	// V1 min-, V2 nom,  p nom, 
	void test1() {
		assertThrows(Exception.class, () -> {
			int V1 = -8;
			int V2 = 6;
			double p = 0.213;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}
	
	@Test
	// V1 nom, V min-, p nom, 
	void test2() {
		assertThrows(Exception.class, () -> {
			int V1 = 6;
			int V2 = -8;
			double p = 0.5;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}
	
	@Test
	// V1 nom, V2 nom, p max+, 
	void test3() {
		assertThrows(Exception.class, () -> {
			int V1 = 11;
			int V2 = 22;
			double p = 1.00001;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}

	@Test
	// V1 nom, V2 nom, p nom
	void test4() {
		int V1 = 11;
		int V2 = 22;
		double p = 0.124214;
		graph = GraphGenerator.bipartite(V1, V2, p);
		assertEquals(graph.V(), V1+V2);
	}
	
	@Test
	// V1 min, V2 min, p nom
	void test5() {
		int V1 = 0;
		int V2 = 0;
		double p = 0;
		graph = GraphGenerator.bipartite(V1, V2, p);
		assertEquals(graph.V(), V1+V2);
	}
	
	@Test
	// V1 nom, V2 nom, p min-,
	void test6() {
		assertThrows(Exception.class, () -> {
			int V1 = 1;
			int V2 = 1;
			double p = -0.00001;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}
	

}
