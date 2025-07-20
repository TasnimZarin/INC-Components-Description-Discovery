// Imports required for working with OWL ontologies, reasoning, and SQWRL querying
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;
import org.swrlapi.factory.SWRLAPIFactory;
import org.swrlapi.sqwrl.SQWRLQueryEngine;
import org.swrlapi.sqwrl.SQWRLResult;
import org.swrlapi.sqwrl.exceptions.SQWRLException;

import java.io.File;
import java.util.*;

public class SWRLQueryRunner {

    // Ontology manager and loaded ontology
    private final OWLOntologyManager manager;
    private final OWLOntology ontology;

    // Reasoner for ontology inference
    private final OWLReasoner reasoner;

    /**
     * Constructor that loads the ontology from the given file path and initializes the reasoner.
     * 
     * @param ontologyPath Path to the OWL ontology file
     * @throws Exception If loading the ontology fails
     */
    public SWRLQueryRunner(String ontologyPath) throws Exception {
        // Initialize OWL API manager
        manager = OWLManager.createOWLOntologyManager();

        // Load ontology from provided file path
        File file = new File(ontologyPath);
        ontology = manager.loadOntologyFromOntologyDocument(file);

        // Initialize structural reasoner
        OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
        reasoner = reasonerFactory.createReasoner(ontology);
    }

    /**
     * Executes a given SQWRL query on the loaded ontology.
     * 
     * @param queryName A unique name for the query
     * @param swrlQuery The SWRL/SQWRL query string to be executed
     * @return A list of result rows, each represented as a map of variable name to value
     */
    public List<Map<String, String>> runSQWRLQuery(String queryName, String swrlQuery) {
        List<Map<String, String>> resultsList = new ArrayList<>();

        try {
            // Create a query engine that uses the ontology and reasoner
            SQWRLQueryEngine queryEngine = SWRLAPIFactory.createSQWRLQueryEngine(ontology, reasoner);

            // Run the query using the given name
            SQWRLResult result = queryEngine.runSQWRLQuery(queryName, swrlQuery);

            // Iterate through the results
            while (result.next()) {
                Map<String, String> row = new HashMap<>();

                // For each result variable, extract its value
                for (String variable : result.getVariableNames()) {
                    if (result.isIndividual(variable)) {
                        row.put(variable, result.getIndividual(variable).toString());
                    } else if (result.isLiteral(variable)) {
                        row.put(variable, result.getLiteral(variable).getLiteral());
                    }
                }
                resultsList.add(row); // Add row to the results list
            }
        } catch (SQWRLException e) {
            e.printStackTrace();
        }

        return resultsList;
    }

    /**
     * Sample main method for testing the query runner with a SWRL query.
     */
    public static void main(String[] args) {
        try {
            // Initialize the processor with your ontology path
            SWRLQueryRunner runner = new SWRLQueryRunner("path/to/your/inc.owl");

            // Define a sample SWRL/SQWRL query (replace with actual rule)
            String swrlQuery = "YourClass(?x) ^ hasAttribute(?x, ?y) -> sqwrl:select(?x, ?y)";

            // Run the query and print results
            List<Map<String, String>> results = runner.runSQWRLQuery("query1", swrlQuery);
            for (Map<String, String> result : results) {
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
