package com.gtarc.chariot.api.model.util.sparql;

/**
 * A SPARQL builder class that eases the SPARQL query building.
 * 
 * @author ckuster
 *
 */
public final class SparqlQueryBuilder {
	
	private SparqlQueryBuilder() {}
	
	/**
	 * Creates a SPARQL query.
	 * 
	 * @param prefixes Prefixes in Form {@code prefix abc: <http://long-uri-abc.org/ontology.owl#>"}.
	 * @param selectClause The select clause, e.g. {@code SELECT *} or {@code SELECT ?x ?y ?z}.
	 * @param whereClause The where clause without outer curly brackets.
	 * @param graphName The name of the graph; can be a URI in angle brackets or a variable.
	 * @return A valid SPARQL query string.
	 */
	public static String buildQuery(String[] prefixes, String graphName, String selectClause, String whereClause) {
		StringBuilder sb = new StringBuilder();
		if (prefixes != null && prefixes.length > 0) {
			for (String prefix: prefixes) {
				sb.append(prefix).append(" ");
			}
		}
		sb.append(selectClause).append(" { ");
		if (graphName != null && !graphName.isEmpty()) {
			sb.append("GRAPH " + graphName + " {");
		}
		if (whereClause != null && !whereClause.isEmpty()) {
			sb.append(whereClause);
		}
		sb.append("}");
		if (graphName != null && !graphName.isEmpty()) {
			sb.append(" }");
		}
		return sb.toString();
	}
	
	/**
	 * Creates a SPARQL query.
	 * 
	 * @param prefixes Prefixes in Form {@code prefix abc: <http://long-uri-abc.org/ontology.owl#>"}.
	 * @param selectClause The select clause, e.g. {@code SELECT *} or {@code SELECT ?x ?y ?z}.
	 * @param whereClause The where clause without outer curly brackets.
	 * @param graphName The name of the graph; can be a URI in angle brackets or a variable.
	 * @param limit Limit of results to show.
	 * @return A valid SPARQL query string.
	 */
	public static String buildQuery(String[] prefixes, String graphName, String selectClause, String whereClause,
			int limit) {
		String query = buildQuery(prefixes, graphName, selectClause, whereClause);
		return query + " LIMIT " + limit;
		
	}

}
