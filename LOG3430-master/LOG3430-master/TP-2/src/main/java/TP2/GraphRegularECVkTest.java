package TP2;

import static org.junit.jupiter.api.Assertions.*;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.GraphGenerator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphRegularECVkTest {
	
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
	
	@Test
	// V, k, V*k impair
	void test1() {
		assertThrows(Exception.class, () -> {
			int V = 3;
			int k = 3;
			graph = GraphGenerator.regular(V, k);
		});
	}
	
	@Test
	// V min-
	void test2() {
		assertThrows(Exception.class, () -> {
			int V = -1;
			int k = 3;
			graph = GraphGenerator.regular(V, k);
		});
	}
	
	@Test
	// k min-
	void test3() {
		assertThrows(Exception.class, () -> {
			int V = 2;
			int k = -1;
			graph = GraphGenerator.regular(V, k);
		});
	}
	
	@Test
	// v min k min
	void test4() {
		int V = 0;
		int k = 0;
		graph = GraphGenerator.regular(V, k);
		assertEquals(graph.V(), V);
	}
	
	@Test
	// v nom k nom pair
	void test5() {
		int V = 5;
		int k = 4;
		graph = GraphGenerator.regular(V, k);
		assertEquals(graph.V(), V);
	}
}
