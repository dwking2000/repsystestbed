package cu.rst.gwt.server.tests;



public class SimpleTest
{

//	public static void main(String[] args) throws Exception
//	{
//		BasicConfigurator.configure();
//		
//		EigenTrust repAlg = (EigenTrust) ReputationAlgorithm.getInstance("cu.repsystestbed.gwt.server.algorithms.EigenTrust");
//		//initialize the eigentrust parameters
////		repAlg.setIterations(10);
////		repAlg.setThreshold2Satisfy(0.7);
//		
//		//create a feedback history graph
//		FeedbackHistoryGraph feedbackHistoryGraph = new FeedbackHistoryGraph(new FeedbackHistoryEdgeFactory());
//		
//		//parse the feedbacks from the arff file
//		DefaultArffFeedbackGenerator feedbackGen = new DefaultArffFeedbackGenerator();
//		List<Feedback> feedbacks = feedbackGen.generateHardcoded("feedbacks.arff");
//		
//		//add the feedbacks to the feedback history graph
//		for(Feedback f : feedbacks)
//		{
//			feedbackHistoryGraph.addFeedback(f);
//		}
//		
//		//eigentrust needs to use the feedback history graph
//		repAlg.setGraph2Listen(feedbackHistoryGraph);
//		
//		//add eigentrust as an observer to the feedback history graph
//		feedbackHistoryGraph.addObserver(repAlg);
//		
//		//make eigentrust calculate the reputation of all the agents
//		feedbackHistoryGraph.notifyObservers(false);
//		
//		ReputationGraph repGraph = (ReputationGraph) repAlg.getGraph2Output();
//		//TODO display the reputation graph.
//		
//		RankbasedTrustAlg trustAlg = (RankbasedTrustAlg) TrustAlgorithm.getInstance("cu.repsystestbed.gwt.server.algorithms.RankbasedTrustAlg");
//		trustAlg.setRatio(0.7);
//		trustAlg.setGraph2Listen(repGraph);
//		
//		repGraph.addObserver(trustAlg);
//		
//		repGraph.notifyObservers(null);
//		
//		TrustGraph trustGraph = (TrustGraph) trustAlg.getGraph2Output();
//		//TODO display the trust graph.
//		
//
//		
//		
//		
//	}
}
