package TP2;

import static org.junit.jupiter.api.Assertions.*;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.GraphGenerator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphBipartiteECV1V2ETest {
	
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
	 E:
	 	min-	E < 0
	 	nom		0 <= E <= V1*V2 
	 	max+	E > V1*V2
	 */
	
	@Test
	// V1 min-, V2 nom,  E nom, 
	void test1() {
		assertThrows(Exception.class, () -> {
			int V1 = -1;
			int V2 = 4;
			int E = 3;
			graph = GraphGenerator.bipartite(V1, V2, E);
		});
	}
	
	@Test
	// V1 nom, V min-, E nom, 
	void test2() {
		assertThrows(Exception.class, () -> {
			int V1 = 3;
			int V2 = -1;
			int E = 5;
			graph = GraphGenerator.bipartite(V1, V2, E);
		});
	}
	
	@Test
	// V1 nom, V2 nom, E max+, 
	void test3() {
		assertThrows(Exception.class, () -> {
			int V1 = 11;
			int V2 = 22;
			int E = V1*V2 + 1;
			graph = GraphGenerator.bipartite(V1, V2, E);
		});
	}

	@Test
	// V1 nom, V2 nom, E nom
	void test4() {
		int V1 = 11;
		int V2 = 22;
		int E = V1*V2;
		graph = GraphGenerator.bipartite(V1, V2, E);
		assertEquals(graph.V(), V1+V2);
	}
	
	@Test
	// V1 min, V2 min, E nom
	void test5() {
		int V1 = 0;
		int V2 = 0;
		int E = 0;
		graph = GraphGenerator.bipartite(V1, V2, E);
		assertEquals(graph.V(), V1+V2);
	}
	
	@Test
	// V1 nom, V2 nom, E min-,
	void test6() {
		assertThrows(Exception.class, () -> {
			int V1 = 1;
			int V2 = 1;
			int E = -1;
			graph = GraphGenerator.bipartite(V1, V2, E);
		});
	}
}
