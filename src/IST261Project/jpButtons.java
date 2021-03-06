/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IST261Project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author msb5626
 */
public class jpButtons extends javax.swing.JPanel {

    /**
     * Creates new form jpMain
     */
    
    MySQLDBConnector mySQL;
    
    public jpButtons(MySQLDBConnector mySQLIn) {
        initComponents();
        mySQL = mySQLIn;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jbAddSection = new javax.swing.JButton();
        jbNewProfessor = new javax.swing.JButton();
        jbNewClass = new javax.swing.JButton();
        jbNewSchedule = new javax.swing.JButton();
        jbConstraints = new javax.swing.JButton();

        jbAddSection.setText("Add Section");
        jbAddSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddSectionActionPerformed(evt);
            }
        });

        jbNewProfessor.setText("New Professor");
        jbNewProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                try {
//                    jbNewProfessorActionPerformed(evt);
//                } catch (SQLException ex) {
//                    Logger.getLogger(jpButtons.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
        });

        jbNewClass.setText("New Class");
        jbNewClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNewClassActionPerformed(evt);
            }
        });

        jbNewSchedule.setText("New Schedule");
        jbNewSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNewScheduleActionPerformed(evt);
            }
        });

        jbConstraints.setText("Check Constraints");
        jbConstraints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConstraintsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbAddSection)
                .addGap(18, 18, 18)
                .addComponent(jbNewProfessor)
                .addGap(18, 18, 18)
                .addComponent(jbNewClass)
                .addGap(18, 18, 18)
                .addComponent(jbNewSchedule)
                .addGap(18, 18, 18)
                .addComponent(jbConstraints)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAddSection)
                    .addComponent(jbNewProfessor)
                    .addComponent(jbNewClass)
                    .addComponent(jbNewSchedule)
                    .addComponent(jbConstraints))
                .addContainerGap())
        );
    }// </editor-fold>                        

    private void jbNewProfessorActionPerformed(java.awt.event.ActionEvent evt) {                                               
        try {                                               
            // TODO add your handling code here:
            
            Statement stmt = mySQL.myConnection.createStatement();
            String sql = "Select professor.pDept from professor";
            ResultSet myRS = stmt.executeQuery(sql);
            
            int RSLength = 0;
            while(myRS.next())
            {
                RSLength++;
            }
            myRS.first();
//            timeslots = new Timeslot[RSLength];
//            for (int i = 0; i < RSLength; i++) {
//                char[] timeSlotDays = myRS.getString(4).toCharArray();
//                timeslots[i] = new Timeslot(myRS.getInt(1), myRS.getTime(2), myRS.getTime(3), timeSlotDays);
//                myRS.next();
//            }

    }
        catch (SQLException ex) {
                Logger.getLogger(jpButtons.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String strProfessorID;
            String strFName;
            String strLName;
            String strCourseLoad;
            String strUsername;
            String strDepartment;
            
            JTextField jtfProfessorID = new JTextField();
            JTextField jtfFName = new JTextField();
            JTextField jtfLName = new JTextField();
            JTextField jtfCourseLoad = new JTextField();
            JTextField jtfUsername = new JTextField();
            JComboBox jcbDepartment = new JComboBox();
            
            final JComponent[] inputs = new JComponent[]
            {
                new JLabel("Professor ID"),
                jtfProfessorID,
                new JLabel("First Name"),
                jtfFName,
                new JLabel("Last Name"),
                jtfLName,
                new JLabel("Courseload (credits)"),
                jtfCourseLoad,
                new JLabel("Username"),
                jtfUsername,
                new JLabel("Department"),
                jcbDepartment
            };
            
            int result = JOptionPane.showConfirmDialog(null, inputs, "New Professor Info", JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION)
            {
                strProfessorID = jtfProfessorID.getText();
                int intProfessorID = Integer.parseInt(strProfessorID);
                strFName = jtfFName.getText();
                strLName = jtfLName.getText();
                strCourseLoad = jtfCourseLoad.getText();
                int intCourseLoad = Integer.parseInt(strCourseLoad);
                strUsername = jtfUsername.getText();
                strDepartment = jcbDepartment.getActionCommand();
                System.out.println("You entered \n"
                        + "Professor ID  "  + strProfessorID + "\n"
                                + "First Name  "  + strFName + "\n"
                                        + "Last Name  "  +  strLName + "\n"
                                                + "Courseload    "  + strCourseLoad + "\n"
                                                        + "Username    "  + strUsername + "\n"
                                                                + "Department   " + strDepartment + "\n"
                );
                String strSQL =  "INSERT into ctg5117.professor (Professor_ID, Professor_FName, Professor_LName, Professor_CourseLoad, Professor_Username, Professor_Department) VALUES (?,?,?,?,?,?);";
                PreparedStatement myPS1;
                try {
                    myPS1 = mySQL.myConnection.prepareStatement(strSQL);
                    myPS1.setInt(1, intProfessorID);
                    myPS1.setString(2, strFName);
                    myPS1.setString(3, strLName);
                    myPS1.setInt(4, intCourseLoad);
                    myPS1.setString(5, strUsername);
                    myPS1.setString(6, strDepartment);
                    myPS1.executeUpdate();
                }
                catch (SQLException ex)
                {
                    Logger.getLogger(jpButtons.class.getName()).log(Level.SEVERE, null, ex);
                }
//System.out.println(intProfessorID);
            }
            else {
                System.out.println("User canceled / closed the dialog, result = " + result);
            } 
//String strSQL =  "INSERT into ctg5117.professor (Professor_ID, Professor_FName, Professor_LName, Professor_CourseLoad, Professor_Username, Professor_Department) VALUES (?,?,?,?,?,?);";
//PreparedStatement myPS1;
//strProfessorID = jtfProfessorID.getText();
//strFName = jtfFName.getText();
//strLName = jtfLName.getText();
//strCourseLoad = jtfCourseLoad.getText();
//strUsername = jtfUsername.getText();
//strDepartment = jtfDepartment.getText();
//try {
//myPS1 = myDBConnector.myConnection.prepareStatement(strSQL);
//myPS1.setString(1, strProfessorID);
//myPS1.setString(2, strFName);
//myPS1.setString(3, strLName);
//myPS1.setString(4, strCourseLoad);
//myPS1.setString(5, strUsername);
//myPS1.setString(6, strDepartment);
//myPS1.executeUpdate();
//myDBConnector.myConnection.close();
//}
//catch (SQLException ex) 
//{
//            Logger.getLogger(jpButtons.class.getName()).log(Level.SEVERE, null, ex);
//}
    }                                             

    private void jbAddSectionActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        String strSectionID;
        String strProfessorCourseID;
        String strRoomTimeID;
        String strSectionNumber;
                
        JTextField jtfSectionID = new JTextField();
        JComboBox jcbProfessorCourseID = new JComboBox();
        JComboBox jcbRoomTimeID = new JComboBox();
        JTextField jtfSectionNumber = new JTextField();
        
        final JComponent[] inputs = new JComponent[] 
        {
           new JLabel("Section ID"),
           jtfSectionID,
           new JLabel("Professor Course ID"),
           jcbProfessorCourseID,
           new JLabel("Room Time ID"),
           jcbRoomTimeID,
           new JLabel("Section Number"),
           jtfSectionNumber,
        };
        
int result = JOptionPane.showConfirmDialog(null, inputs, "New Section Info", JOptionPane.PLAIN_MESSAGE);
if (result == JOptionPane.OK_OPTION) 
{
   strSectionID = jtfSectionID.getText();
   strProfessorCourseID = jcbProfessorCourseID.getActionCommand();
   strRoomTimeID = jcbRoomTimeID.getActionCommand();
   strSectionNumber = jtfSectionNumber.getText();
    System.out.println("You entered \n" 
            + "Section ID  "  + strSectionID + "\n"
            + "Professor Course ID  "  + strProfessorCourseID + "\n"
            + "Room Time ID  "  +  strRoomTimeID + "\n"
            + "SectionNumber    "  + strSectionNumber + "\n"
    );
} else {
    System.out.println("User canceled / closed the dialog, result = " + result);
}
String strSQL =  "INSERT into ctg5117.section (Section_ID, ProfessorCourse_ProfessorCourseID, RoomTime_RoomTimeID, Section_SectionNumber) VALUES (?,?,?,?)";
PreparedStatement myPS1;
strSectionID = jtfSectionID.getText();
strProfessorCourseID = jcbProfessorCourseID.getActionCommand();
strRoomTimeID = jcbRoomTimeID.getActionCommand();
strSectionNumber = jtfSectionNumber.getText();
try {
myPS1 = mySQL.myConnection.prepareStatement(strSQL);
myPS1.setString(1, strSectionID);
myPS1.setString(2, strProfessorCourseID);
myPS1.setString(3, strRoomTimeID);
myPS1.setString(4, strSectionNumber);
}
catch (SQLException ex) 
{
            Logger.getLogger(jpButtons.class.getName()).log(Level.SEVERE, null, ex);
}
    }                                            

    private void jbNewClassActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        String strCourseID;
        String strCredits;
        String strEstStudents;
        String strName;
        String strMajor;
        String strLevel;
        
        JTextField jtfCourseID = new JTextField();
        JTextField jtfCredits = new JTextField();
        JTextField jtfEstStudents = new JTextField();
        JTextField jtfName = new JTextField();
        JTextField jtfMajor = new JTextField();
        JTextField jtfLevel = new JTextField();
        
        final JComponent[] inputs = new JComponent[] 
        {
           new JLabel("Course ID"),
           jtfCourseID,
           new JLabel("Credits"),
           jtfCredits,
           new JLabel("Estimated Students"),
           jtfEstStudents,
           new JLabel("Name"),
           jtfName,
           new JLabel("Major"),
           jtfMajor,
           new JLabel("Level"),
           jtfLevel
        };
        
int result = JOptionPane.showConfirmDialog(null, inputs, "New Course Info", JOptionPane.PLAIN_MESSAGE);
if (result == JOptionPane.OK_OPTION) 
{
   strCourseID = jtfCourseID.getText();
   strCredits = jtfCredits.getText();
   strEstStudents = jtfEstStudents.getText();
   strName = jtfName.getText();
   strMajor = jtfMajor.getText();
   strLevel = jtfLevel.getText();
    System.out.println("You entered \n" 
            + "Course ID  "  + strCourseID + "\n"
            + "Credits  "  + strCredits + "\n"
            + "Estimated Students  "  +  strEstStudents + "\n"
            + "Name    "  + strName + "\n"
            + "Major    "  + strMajor + "\n"
            + "Level   " + strLevel + "\n");

            String strSQL =  "INSERT into ctg5117.course (Course_ID, Course_Credits, Course_EstStudents, Course_Name, Course_Major, Course_Level) VALUES (?,?,?,?,?,?)";
PreparedStatement myPS1;
try {
myPS1 = mySQL.myConnection.prepareStatement(strSQL);
myPS1.setString(1, strCourseID);
myPS1.setString(2, strCredits);
myPS1.setString(3, strEstStudents);
myPS1.setString(4, strName);
myPS1.setString(5, strMajor);
myPS1.setString(6, strLevel);
myPS1.executeUpdate();
}
catch (SQLException ex) 
{
            Logger.getLogger(jpButtons.class.getName()).log(Level.SEVERE, null, ex);
}

} else {
    System.out.println("User canceled / closed the dialog, result = " + result);
}
//String strSQL =  "INSERT into ctg5117.course (Course_ID, Course_Credits, Course_EstStudents, Course_Name, Course_Major, Course_Level) VALUES (?,?,?,?,?,?)";
//PreparedStatement myPS1;
//try {
//myPS1 = myDBConnector.myConnection.prepareStatement(strSQL);
//myPS1.setString(1, strCourseID);
//myPS1.setString(2, strCredits);
//myPS1.setString(3, strEstStudents);
//myPS1.setString(4, strName);
//myPS1.setString(5, strMajor);
//myPS1.setString(6, strLevel);
//}
//catch (SQLException ex) 
//{
//            Logger.getLogger(jpButtons.class.getName()).log(Level.SEVERE, null, ex);
//}
    }                                          

    private void jbNewScheduleActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        
    }                                             

    private void jbConstraintsActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        
    }                                             


    // Variables declaration - do not modify                     
    private javax.swing.JButton jbAddSection;
    private javax.swing.JButton jbConstraints;
    private javax.swing.JButton jbNewClass;
    private javax.swing.JButton jbNewProfessor;
    private javax.swing.JButton jbNewSchedule;
    // End of variables declaration                   
}

