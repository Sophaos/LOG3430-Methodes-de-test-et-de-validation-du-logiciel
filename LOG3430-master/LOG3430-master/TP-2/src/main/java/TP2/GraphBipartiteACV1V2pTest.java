package TP2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.GraphGenerator;

import org.junit.jupiter.api.Test;

class GraphBipartiteACV1V2pTest {

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
	// V1 min-, V2 min- , p min-
	void test1() {
		assertThrows(Exception.class, () -> {
			int V1 = -1;
			int V2 = -1;
			double p = -0.00001;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}
	
	@Test
	// V1 min-, V2 min- , p nom
	void test2() {
		assertThrows(Exception.class, () -> {
			int V1 = -1;
			int V2 = -1;
			double p = 0;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}
	
	@Test
	// V1 min-, V2 min- , p max+
	void test3() {
		assertThrows(Exception.class, () -> {
			int V1 = -1;
			int V2 = -1;
			double p = 0.5 + 1;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}
	
	@Test
	// V1 min-, V2 min , p min-
	void test4() {
		assertThrows(Exception.class, () -> {
			int V1 = -1;
			int V2 = 0;
			double p = -0.00001;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}
	
	@Test
	// V1 min-, V2 min , p nom
	void test5() {
		assertThrows(Exception.class, () -> {
			int V1 = -1;
			int V2 = 0;
			double p = 0;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}
	
	@Test
	// V1 min-, V2 min , p max+
	void test6() {
		assertThrows(Exception.class, () -> {
			int V1 = -1;
			int V2 = 0;
			double p = 0.5 + 1;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}
	
	@Test
	// V1 min-, V2 nom , p min-
	void test7() {
		assertThrows(Exception.class, () -> {
			int V1 = -1;
			int V2 = 1;
			double p = -0.00001;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}
	
	@Test
	// V1 min-, V2 nom , p nom
	void test8() {
		assertThrows(Exception.class, () -> {
			int V1 = -1;
			int V2 = 4;
			double p = 2;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}
	
	@Test
	// V1 min-, V2 nom , p max+
	void test9() {
		assertThrows(Exception.class, () -> {
			int V1 = -1;
			int V2 = 5;
			double p = 0.5 + 1;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}
	@Test
	// V1 min, V2 min- , p min-
	void test10() {
		assertThrows(Exception.class, () -> {
			int V1 = 0;
			int V2 = -1;
			double p = -0.00001;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}
	@Test
	// V1 min, V2 min- , p nom
	void test11() {
		assertThrows(Exception.class, () -> {
			int V1 = 0;
			int V2 = -1;
			double p = 0.5;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
		
	}
	@Test
	// V1 min, V2 min- , p max+
	void test12() {
		assertThrows(Exception.class, () -> {
			int V1 = 0;
			int V2 = -1;
			double p = 1.00001;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
		
	}
	@Test
	// V1 min, V2 min , p min-
	void test13() {
		assertThrows(Exception.class, () -> {
			int V1 = 0;
			int V2 = 0;
			double p = -0.00001;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}
	@Test
	// V1 min, V2 min , p nom
	void test14() {
		int V1 = 0;
		int V2 = 0;
		double p = 0.5;
		graph = GraphGenerator.bipartite(V1, V2, p);
		assertEquals(graph.V(), V1+V2);
		
	}
	@Test
	// V1 min, V2 min , p max+
	void test15() {
		assertThrows(Exception.class, () -> {
			int V1 = 0;
			int V2 = 0;
			double p = 1.00001;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}
	
	@Test
	// V1 min, V2 nom , p min-
	void test16() {
		assertThrows(Exception.class, () -> {
			int V1 = 0;
			int V2 = 2;
			double p = -0.00001;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}
	@Test
	// V1 min, V2 nom , p nom
	void test17() {
		int V1 = 0;
		int V2 = 2;
		double p = 0.5;
		graph = GraphGenerator.bipartite(V1, V2, p);
		assertEquals(graph.V(), V1+V2);
	}
	@Test
	// V1 min, V2 nom , p max+
	void test18() {
		assertThrows(Exception.class, () -> {
			int V1 = 0;
			int V2 = 2;
			double p = 1.00001;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}
	
	@Test
	// V1 nom, V2 min- , p min-
	void test19() {
		assertThrows(Exception.class, () -> {
			int V1 = 2;
			int V2 = -1;
			double p = -0.00001;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}
	@Test
	// V1 nom, V2 min- , p nom
	void test20() {
		assertThrows(Exception.class, () -> {
			int V1 = 7;
			int V2 = -8;
			double p = 0.5;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}
	@Test
	// V1 nom, V2 min- , p max+
	void test21() {
		assertThrows(Exception.class, () -> {
			int V1 = 2;
			int V2 = -1;
			double p = 1.00001;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}
	
	@Test
	// V1 nom, V2 min , p min-
	void test22() {
		assertThrows(Exception.class, () -> {
			int V1 = 2;
			int V2 = 0;
			double p = -0.00001;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}
	@Test
	// V1 nom, V2 min , p nom
	void test23() {
		int V1 = 2;
		int V2 = 0;
		double p = 0.5;
		graph = GraphGenerator.bipartite(V1, V2, p);
		assertEquals(graph.V(), V1+V2);
		
	}
	@Test
	// V1 nom, V2 min , p max+
	void test24() {
		assertThrows(Exception.class, () -> {
			int V1 = 2;
			int V2 = 0;
			double p = 1.00001;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}
	
	@Test
	// V1 nom, V2 nom , p min-
	void test25() {
		assertThrows(Exception.class, () -> {
			int V1 = 2;
			int V2 = 2;
			double p = -0.00001;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}
	@Test
	// V1 nom, V2 nom , p nom
	void test26() {
		int V1 = 2;
		int V2 = 2;
		double p = 0.5;
		graph = GraphGenerator.bipartite(V1, V2, p);
		assertEquals(graph.V(), V1+V2);
		
	}
	@Test
	// V1 nom, V2 nom , p max+
	void test27() {
		assertThrows(Exception.class, () -> {
			int V1 = 2;
			int V2 = 2;
			double p = 1.00001;
			graph = GraphGenerator.bipartite(V1, V2, p);
		});
	}
	
	
}
