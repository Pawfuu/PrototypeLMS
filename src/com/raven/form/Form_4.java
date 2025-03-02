
package com.raven.form;


import com.raven.form.DBConnection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;


public class Form_4 extends javax.swing.JPanel {

    String studentName, course;
    int studentId, level;
    DefaultTableModel model;
   
    public Form_4() {
        initComponents();
        setStudentDetailsToTable();
    }
    
    
    // to set the student details into the table
    public void setStudentDetailsToTable(){
         
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
           Statement st = con.createStatement();
           ResultSet rs =  st.executeQuery("select * from student_details");
           
           while (rs.next()){
                   String studentId = rs.getString("student_id");
                   String studentName = rs.getString("name");
                   String course = rs.getString("course");
                   String level  = rs.getString("level");
                   
                   Object[] obj = {studentId, studentName, course, level};
                   model = (DefaultTableModel) tbl_studentDetails.getModel();
                   model.addRow(obj);
           }
           
        } catch (Exception e) {
            // Handle the exception and print an error message
            e.printStackTrace();
        }
    }
    
    // to add student to student_details table
    public boolean addStudent(){
        boolean isAdded = false;
        //to get the text typed in the textbox
        studentId = Integer.parseInt(txt_studentId.getText());
        studentName = combo_level.getText();
        course = combo_CourseName.getSelectedItem().toString();
        level =  Integer.parseInt(combo_level.getText());
        
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into student_details values(?,?,?,?)";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studentId);
            pst.setString(2, studentName);
            pst.setString(3, course);
            pst.setInt(4, level);
            
            /*
            SQL COMMANDS
            non-select query refers to any SQL statemnt that does not RETRIEVE date from a database. Instead these queries typically 
            perform actions that MODIFY the databse or its structure. 
            INSERT - adds new record ito a table
            UPDATE - modifies existing records in a table
            DELETE - removes records from a t able
            CREATE - creates a new table or database
            ALTER -  modifies the structure of an existing tbale (e.g., adding a column)
            DROP - deletes a table or database
            */
            //(4) EXECUTES THE UPDATE. IT RETURNS AN 'INT' INDICATING THE NUMBER OF ROWS AFFECTED
            int rowCount = pst.executeUpdate();
            if (rowCount > 0){
                  isAdded = true;
            }
            else{
                  isAdded = false;
            }
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return isAdded;
    }  
    
    
    //to update student details 
    public boolean updateStudent(){
         boolean isUpdated = false;
        studentId = Integer.parseInt(txt_studentId.getText());
        studentName = txt_studentName.getText();
        course = combo_CourseName.getSelectedItem().toString();
        level = Integer.parseInt(combo_level.getText());


         try {
            Connection con = DBConnection.getConnection();
            // WHERE - filter records in a sql query and adds a condition to include only the rows that meet the specified criteria
            String sql = "update student_details set name = ?, course = ?, branch = ? where student_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, studentName);
            pst.setString(2, course);
            pst.setInt(3, level);
            pst.setInt(4, studentId);
            
            //It checks if the command was updated
            int rowCount = pst.executeUpdate();
            if (rowCount > 0){
                  isUpdated = true;
            }else{
                isUpdated = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         return isUpdated;
    }
    
    //to delete student in student_details table
    public boolean deleteStudent(){
         boolean isDeleted = false;
         studentId = Integer.parseInt(txt_studentId.getText());
    
         try {
             // (1) ESTABLISH CONNECTION 
            Connection con = DBConnection.getConnection();
            
            // (2)  PUT PLACEHOLDERS(' ? ') FOR PARAMETERS
            String sql = "delete from student_details where student_id = ? ";
            //prepStatement string named sql goes to database MySQL
            PreparedStatement pst = con.prepareStatement(sql);
            
            // (3) SETS THE VALUES FOR THE PLACEHOLDER
            pst.setInt(1, studentId);
            
            //(4) EXECUTES THE UPDATE. IT RETURNS AN 'INT' INDICATING THE NUMBER OF ROWS AFFECTED
            int rowCount = pst.executeUpdate();
            
            if(rowCount > 0){
            isDeleted = true;
            }else{
            isDeleted = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         return isDeleted;
    }
    
    //method to clear table
    public void clearTable(){
         DefaultTableModel model = (DefaultTableModel) tbl_studentDetails.getModel();
         model.setRowCount(0);
    }
 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.raven.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();
        jPanel17 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        combo_level = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        combo_CourseName = new javax.swing.JComboBox<>();
        txt_studentName = new app.bolivia.swing.JCTextField();
        jLabel2 = new javax.swing.JLabel();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle5 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle6 = new rojerusan.RSMaterialButtonCircle();

        setBackground(new java.awt.Color(242, 242, 242));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Course", "Branch"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(0, 0, 70));
        tbl_studentDetails.setColorBordeFilas(new java.awt.Color(0, 0, 70));
        tbl_studentDetails.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_studentDetails.setRowHeight(40);
        tbl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_studentDetails);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(1626, 1626, 1626)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(5, 5, 5))
        );

        add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 1200, 350));

        jPanel17.setBackground(new java.awt.Color(0, 0, 70));
        jPanel17.setForeground(new java.awt.Color(0, 0, 70));
        jPanel17.setToolTipText("");
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Enter Student Level");
        jPanel17.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 230, 70));

        txt_studentId.setBackground(new java.awt.Color(242, 242, 242));
        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_studentId.setForeground(new java.awt.Color(0, 0, 0));
        txt_studentId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_studentId.setPlaceholder("Enter Student Id...");
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        jPanel17.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 360, 50));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Enter Student Id");
        jPanel17.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 360, 70));

        combo_level.setBackground(new java.awt.Color(242, 242, 242));
        combo_level.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        combo_level.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        combo_level.setPlaceholder("Enter Grade Level...");
        jPanel17.add(combo_level, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 360, 50));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Enter Student Name");
        jPanel17.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 400, 70));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/student (2).png"))); // NOI18N
        jPanel17.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 80, 300, 280));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Select Strand");
        jPanel17.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 160, 70));

        combo_CourseName.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        combo_CourseName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ICT", "ABM", "STEM ", "HUMMS", " " }));
        jPanel17.add(combo_CourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 360, 50));

        txt_studentName.setBackground(new java.awt.Color(242, 242, 242));
        txt_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_studentName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_studentName.setPlaceholder("Enter Student Name...");
        jPanel17.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 360, 50));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/student-with-graduation-cap.png"))); // NOI18N
        jLabel2.setText("MANAGE STUDENTS");
        jPanel17.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 330, 90));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 255, 255));
        rSMaterialButtonCircle3.setBorder(null);
        rSMaterialButtonCircle3.setForeground(new java.awt.Color(0, 0, 70));
        rSMaterialButtonCircle3.setText("ADD");
        rSMaterialButtonCircle3.setToolTipText("");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel17.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 190, 80));

        rSMaterialButtonCircle5.setBackground(new java.awt.Color(255, 255, 255));
        rSMaterialButtonCircle5.setBorder(null);
        rSMaterialButtonCircle5.setForeground(new java.awt.Color(0, 0, 70));
        rSMaterialButtonCircle5.setText("UPDATE");
        rSMaterialButtonCircle5.setToolTipText("");
        rSMaterialButtonCircle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle5ActionPerformed(evt);
            }
        });
        jPanel17.add(rSMaterialButtonCircle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 190, 80));

        rSMaterialButtonCircle6.setBackground(new java.awt.Color(255, 255, 255));
        rSMaterialButtonCircle6.setBorder(null);
        rSMaterialButtonCircle6.setForeground(new java.awt.Color(0, 0, 70));
        rSMaterialButtonCircle6.setText("DELETE");
        rSMaterialButtonCircle6.setToolTipText("");
        rSMaterialButtonCircle6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle6ActionPerformed(evt);
            }
        });
        jPanel17.add(rSMaterialButtonCircle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 190, 80));

        add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 380));
    }// </editor-fold>//GEN-END:initComponents

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
           if (updateStudent() == true) {
            JOptionPane.showMessageDialog(this, "Student Updated");
            clearTable();
            setStudentDetailsToTable();
        }else{
            JOptionPane.showMessageDialog(this, "Student Updation Failed");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentDetailsMouseClicked

        int rowNo = tbl_studentDetails.getSelectedRow();
        TableModel model = tbl_studentDetails.getModel();

        txt_studentId.setText(model.getValueAt(rowNo, 0).toString());
        txt_studentName.setText(model.getValueAt(rowNo, 1).toString());
        combo_CourseName.setSelectedItem(model.getValueAt(rowNo, 2).toString());
        combo_level.setText(model.getValueAt(rowNo , 3).toString());

    }//GEN-LAST:event_tbl_studentDetailsMouseClicked

    private void rSMaterialButtonCircle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle5ActionPerformed

    private void rSMaterialButtonCircle6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_CourseName;
    private app.bolivia.swing.JCTextField combo_level;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JScrollPane jScrollPane2;
    private com.raven.swing.PanelBorder panelBorder1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle5;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle6;
    private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
    private app.bolivia.swing.JCTextField txt_studentId;
    private app.bolivia.swing.JCTextField txt_studentName;
    // End of variables declaration//GEN-END:variables
}
