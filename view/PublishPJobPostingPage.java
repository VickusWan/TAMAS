package ca.mcgill.ecse321.TAMAS.view;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

//import ca.mcgill.ecse321.eventregistration.controller.EventRegistrationController;
//import ca.mcgill.ecse321.eventregistration.controller.InvalidInputException;
import ca.mcgill.ecse321.TAMAS.model.ManagementSystem;

// This deals with an error message for the participant
public class PublishPJobPostingPage extends JFrame {
	private static final long serialVersionUID = -3813819647258555349L;
	
	private JLabel semester;
	private JComboBox<String> semesterList;
	private JLabel courseName;
	private JTextField courseInfo;
	private JLabel numTutorials;
	private JTextField numTutorialBox;
	
	
	
	private ManagementSystem rm;
	
	private String error = null;
	private JLabel errorMessage;

	/** Creates new form ParticipantPage 
	 * @return */
	public PublishPJobPostingPage(ManagementSystem rm) {
	    this.rm = rm;
	    initComponents();
	}
	
	private void refreshData() {
	    // error
	    errorMessage.setText(error);
	    if (error == null || error.length() == 0) {
	        // participant
	        courseName.setText("");
	    }
	    // this is needed because the size of the window changes depending on whether an error message is shown or not
	    pack();
	}
//	private void addParticipantButtonActionPerformed() {
//	    // call the controller
//	    EventRegistrationController erc = new EventRegistrationController(rm);
//	    error = null;
//	    try {
//	        erc.createParticipant(participantNameTextField.getText());
//	    } catch (InvalidInputException e) {
//	        error = e.getMessage();
//	    }
//	    // update visuals
//	    refreshData();
//	}
	
	private void initComponents() {
		
		
		semester = new JLabel();
		semesterList = new JComboBox<String>(new String[0]);
		courseName = new JLabel();
		courseInfo = new JTextField();
		numTutorials = new JLabel();
		numTutorialBox = new JTextField();
		
		semester.setText("Select a Semester:");
	    courseName.setText("Enter the course Code:");
	    numTutorials.setText("Enter the number of Tutorials:");

	    // elements for error message
	    errorMessage = new JLabel();
	    errorMessage.setForeground(Color.RED);

	    // global settings and listeners
	    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    setTitle("Publish Job Posting");


	    // layout
	    GroupLayout layout = new GroupLayout(getContentPane());
	    getContentPane().setLayout(layout);
	    layout.setAutoCreateGaps(true);
	    layout.setAutoCreateContainerGaps(true);
	    
	    layout.setHorizontalGroup(
	            layout.createSequentialGroup()
	            .addGroup(layout.createParallelGroup()
	                .addComponent(semester, 200, 200, 400)
	                .addComponent(courseName, 200, 200, 400)
	                .addComponent(numTutorials, 200, 200, 400))
	            .addGroup(layout.createParallelGroup()
		                .addComponent(semesterList)
		                .addComponent(courseInfo)
		                .addComponent(numTutorialBox))
	            );

	    layout.setVerticalGroup(
	            layout.createSequentialGroup()
	            .addGroup(layout.createParallelGroup()
	                .addComponent(semester)
	                .addComponent(semesterList))
	            .addGroup(layout.createParallelGroup()
		                .addComponent(courseName)
		                .addComponent(courseInfo))
	            .addGroup(layout.createParallelGroup()
		                .addComponent(numTutorials)
		                .addComponent(numTutorialBox))
	            );

	    

	    pack();
//	    addParticipantButton.addActionListener(new java.awt.event.ActionListener() {
//	        public void actionPerformed(java.awt.event.ActionEvent evt) {
//	            addParticipantButtonActionPerformed();
//	        }
//	    });
	}

}