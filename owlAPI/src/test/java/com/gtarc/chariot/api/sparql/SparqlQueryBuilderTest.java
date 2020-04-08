package com.gtarc.chariot.api.sparql;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gtarc.chariot.api.model.util.sparql.SparqlQueryBuilder;

public class SparqlQueryBuilderTest {

	@Test
	public void testComplexQuery() {
		assertEquals(
				"prefix owl: <http://www.w3.org/2002/07/owl#> "
						+ "prefix test: <http://test.de/ontologies/test.owl#> "
						+ "SELECT * "
						+ "{ "
						+ "GRAPH <http://test-graph.de/> "
						+ "{?x a test:TestClass}"
						+ " }", 
				SparqlQueryBuilder.buildQuery(
						new String[]{
								"prefix owl: <http://www.w3.org/2002/07/owl#>",
								"prefix test: <http://test.de/ontologies/test.owl#>"
								},
						"<http://test-graph.de/>",
						"SELECT *",
						"?x a test:TestClass")
				);
	}
	
	@Test
	public void testQueryWithGraphVariable() {
		assertEquals("SELECT ?x { GRAPH ?x {} }", SparqlQueryBuilder.buildQuery(null, "?x", "SELECT ?x", null));
	}

}
