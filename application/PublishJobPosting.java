package ca.mcgill.esce321.TAMAS.application;

import ca.mcgill.ecse321.TAMAS.model.ManagementSystem;
import ca.mcgill.ecse321.TAMAS.persistence.PersistenceXStream;
import ca.mcgill.ecse321.TAMAS.view.PublishPJobPostingPage;

public class PublishJobPosting {
	private static String fileName = "output/eventregistration.xml";

	public static void main(String[] args) {
	    final ManagementSystem rm = PersistenceXStream.initializeModelManager(fileName);

	    // start UI
	    java.awt.EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            new PublishPJobPostingPage(rm).setVisible(true);
	        }
	    });

	}
}