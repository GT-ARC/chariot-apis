package com.gtarc.chariot.api.sparql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.jena.fuseki.embedded.FusekiServer;
import org.apache.jena.query.Dataset;
import org.apache.jena.query.DatasetFactory;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.RDF;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.gtarc.chariot.api.model.util.sparql.SmartCityObjectVocabulary;
import com.gtarc.chariot.api.model.util.sparql.SparqlQueryBuilder;

/**
 * @deprecated Test not used any more. Stays as reference for SPARQL queries.
 * 
 * @author ckuster
 *
 */
@Ignore
@Deprecated
public class SPARQLTest {
	
	private static final String DATASET_NAME = "serviceDirectory";
	private static final String FUSEKI_INSTANCE = "http://localhost:3330/";
	private static final String GRAPH_MODEL = FUSEKI_INSTANCE + DATASET_NAME + "/data/smart_city_services/"; 
	private static FusekiServer server;
	
	@BeforeClass
	public static void setUpClass() {
		Dataset ds = DatasetFactory.createTxnMem();
		ds.addNamedModel(GRAPH_MODEL, RDFDataMgr.loadModel("electricCar.goTo.owl"));
		ds.getNamedModel(GRAPH_MODEL).add(RDFDataMgr.loadModel("findCarPark.owl"));
		server = FusekiServer.create()
				.add(DATASET_NAME, ds, true)
				.build();
		server.start();
	}
	
	@AfterClass
	public static void tearDownClass() {
		if (server != null) {
			server.stop();
		}
	}
	
	@Test
	public void receiveServices() {
		try (QueryExecution q = QueryExecutionFactory.sparqlService(FUSEKI_INSTANCE + DATASET_NAME,
				SparqlQueryBuilder.buildQuery(
				new String[]{
						"prefix owl: <http://www.w3.org/2002/07/owl#>",
						"prefix sco: <http://isco-dev.aot.tu-berlin.de/ontologies/smart_city_objects.owl#>"
						},
				"<" + GRAPH_MODEL + ">",
				"SELECT *",
				"?x a sco:Service"))) {
			ResultSet results = q.execSelect();
			assertTrue("SELECT received no results!", results.hasNext());
			
			int i = 0;
			while (results.hasNext()) {
				results.nextSolution();
				i++;
			}
			assertEquals(i, 2);
		}
	}
	
	@Test
	public void receiveSpecificService() {
		try (QueryExecution q = QueryExecutionFactory.sparqlService(FUSEKI_INSTANCE + DATASET_NAME,
				SparqlQueryBuilder.buildQuery(
				new String[]{
						"prefix owl: <http://www.w3.org/2002/07/owl#>",
						"prefix sco: <http://isco-dev.aot.tu-berlin.de/ontologies/smart_city_objects.owl#>"
						},
				"<" + GRAPH_MODEL + ">",
				"SELECT *",
				"?x ?y ?z . ?x a sco:Service . ?x sco:hasID \"fa4541b2-aad8-4cc5-af25-75f50c8bebdf\" "
				+ "OPTIONAL {?z ?u ?v}"))) {
			ResultSet results = q.execSelect();
			assertTrue("SELECT received no results!", results.hasNext());
			
			// Variable to store whether the type of the Smart city Object was found
			boolean foundSCOType = false;
			// Variable to store the number of retrieved triples.
			int i = 0;
			while (results.hasNext()) {
				QuerySolution solution = results.nextSolution();
				assertEquals(
						"http://isco-dev.aot.tu-berlin.de/ontologies/mobility/findCarPark.owl#findCarPark",
						solution.get("?x").toString());
				foundSCOType = foundSCOType || 
						RDF.type.equals(solution.get("?y")) 
						&& SmartCityObjectVocabulary.SERVICE.equals(solution.get("?z"));
				i++;
			}
			assertEquals(8, i);
			assertTrue(foundSCOType);
		}
	}
	
	@Test
	public void receiveNamedGraphs() {
		try (QueryExecution q = QueryExecutionFactory.sparqlService(FUSEKI_INSTANCE + DATASET_NAME,
				SparqlQueryBuilder.buildQuery(null, "?x", "SELECT *", null))) {
			ResultSet results = q.execSelect();
			assertTrue("SELECT received no results!", results.hasNext());
			
			while (results.hasNext()) {
				QuerySolution soln = results.nextSolution();
				// assumes that you have an "?x" in your query
				RDFNode x = soln.get("x");
				assertEquals(x.toString(), GRAPH_MODEL);
			}
		}
	}
	
	@Test
	public void receiveAllTriples() {
		try (QueryExecution q = QueryExecutionFactory.sparqlService(FUSEKI_INSTANCE + DATASET_NAME,
				SparqlQueryBuilder.buildQuery(null, "?g", "SELECT *", "?x ?y ?z"))) {
			ResultSet results = q.execSelect();
			assertTrue("SELECT received no results!", results.hasNext());
			
			int i = 0;
			while (results.hasNext()) {
				results.nextSolution();
				i++;
			}
			assertEquals(i, 59);
		}
	}

}
