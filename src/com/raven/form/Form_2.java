
package com.raven.form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

public class Form_2 extends javax.swing.JPanel {

   
    public Form_2() {
        initComponents();
    }
    
    
    //To fetch the book details from the database and display it to book details panel 
    public void getBookDetails(){
        int bookId = Integer.parseInt(txt_bookId.getText());
    
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from book_details where book_id = ?");
            pst.setInt(1, bookId);
            /*
            ResultSet in Java is an object that holds data retrieved from a database after executing a SELECT
            */
             // Execute a SELECT query
            ResultSet rs = pst.executeQuery();
            /*
                 The ResultSet object has a method called next(). This method moves the cursor to the next row in the ResultSet.
            */
            if(rs.next()){
                  lbl_bookId.setText(rs.getString("book_Id"));
                  lbl_bookName.setText(rs.getString("book_name"));
                  lbl_author.setText(rs.getString("author"));
                  lbl_quantity.setText(rs.getString("quantity"));
            }
            else{
                  lbl_bookError.setText("Invalid Book Id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }

    
    //To fetch the student details from the database and display it to student details panel 
    public void getStudentDetails(){
        int studentId = Integer.parseInt(txt_studentId.getText());
    
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from student_details where student_id = ?");
            pst.setInt(1, studentId);
            /*
            ResultSet in Java is an object that holds data retrieved from a database after executing a SELECT
            */
             // Execute a SELECT query
            ResultSet rs = pst.executeQuery();
            /*
                 The ResultSet object has a method called next(). This method moves the cursor to the next row in the ResultSet.
            */
            if(rs.next()){
                  lbl_studentId.setText(rs.getString("student_Id"));
                  lbl_studentName.setText(rs.getString("name"));
                  lbl_course.setText(rs.getString("course"));
                  lbl_branch.setText(rs.getString("branch"));
            }
            else{
                    lbl_studentError.setText("Invalid Student Id");
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
    
    //insert issue book details to database
    public boolean issueBook(){
        boolean isIssued = false;
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        String bookName = lbl_bookName.getText();
        String studentName = lbl_studentName.getText();
        
        Date uIssueDate = date_issueDate.getDatoFecha();
        Date uDueDate = date_dueDate.getDatoFecha();
        
        Long l1 = uIssueDate.getTime();
        Long l2 = uDueDate.getTime();
        
        java.sql.Date sIssueDate = new java.sql.Date(l1);
        java.sql.Date sDueDate = new java.sql.Date(l2);
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into issue_book_details(book_id, book_name, student_id," 
                    + "student_name, issue_date, due_date, status) values(?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setString(2, bookName);
            pst.setInt(3, studentId);
            pst.setString(4, studentName);
            pst.setDate(5, sIssueDate);
            pst.setDate(6, sDueDate);
            pst.setString(7, "pending");
            
            //(4) EXECUTES THE UPDATE. IT RETURNS AN 'INT' INDICATING THE NUMBER OF ROWS AFFECTED
            int rowCount = pst.executeUpdate();
            if(rowCount > 0){
                isIssued = true;
            }else{
                    isIssued = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
      return isIssued;
    }
    
    //updating the amount of books issued
    public void updateBookCount() {
        int bookId = Integer.parseInt(txt_bookId.getText());
        try {
            //(1) establish database connection
            Connection con = DBConnection.getConnection();
            //(2) sql command to decrease the book quantity by 1
            String sql = "update book_details set quantity = quantity - 1 where book_id = ?";
            //(3) Prepare the SQL statement
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);

            //(4) EXECUTES THE UPDATE. IT RETURNS AN 'INT' INDICATING THE NUMBER OF ROWS AFFECTED
            int RowCount = pst.executeUpdate();
            if (RowCount > 0) {
                JOptionPane.showMessageDialog(this, "Book count updated");
                int initialCount = Integer.parseInt(lbl_quantity.getText());
                lbl_quantity.setText(Integer.toString(initialCount - 1));
            } else {
                JOptionPane.showMessageDialog(this, "Can't update book count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // RESULT SET SINCE IT NEEDS TO SEE IF DATA RECORD EXIST FROM DATABASE (MYSQL)
    //checking wether book already allocated or not to a user
    public boolean isAlreadyIssued() {
        boolean isAlreadyIssued = false;
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());

        try {
            Connection con = DBConnection.getConnection();
            String sql = "Select * from issue_book_details where book_id = ? and student_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setInt(2, studentId);
            pst.setString(3, "pending");
        
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                isAlreadyIssued = true;
            } else {
                isAlreadyIssued = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAlreadyIssued;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        lbl_studentId = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        lbl_studentError = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        lbl_bookName1 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        jLabel51 = new javax.swing.JLabel();
        date_issueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel12 = new javax.swing.JLabel();
        date_dueDate = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        lbl_bookError = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();

        setBackground(new java.awt.Color(242, 242, 242));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 120, 70));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ISSUE BOOKS");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 310, 70));

        jPanel17.setBackground(new java.awt.Color(0, 0, 70));
        jPanel17.setForeground(new java.awt.Color(255, 255, 255));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Book Id:");
        jPanel17.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 150, -1));

        lbl_bookId.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel17.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 210, 30));

        jLabel44.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Book name:");
        jPanel17.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 150, -1));

        lbl_bookName.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel17.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 210, 30));

        jLabel47.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Author:");
        jPanel17.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 150, -1));

        lbl_author.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel17.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 210, 30));

        jLabel53.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Quantity:");
        jPanel17.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 150, -1));

        lbl_quantity.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel17.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 210, 30));

        add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 590, 340));

        jPanel18.setBackground(new java.awt.Color(28, 181, 224));
        jPanel18.setForeground(new java.awt.Color(255, 255, 255));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_studentId.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_studentId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel18.add(lbl_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 210, 30));

        jLabel38.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Student Id:");
        jPanel18.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 150, -1));

        lbl_studentName.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel18.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 210, 30));

        jLabel36.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Student name:");
        jPanel18.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 150, -1));

        lbl_course.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));
        jPanel18.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 210, 30));

        jLabel37.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Course:");
        jPanel18.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 150, -1));

        jLabel35.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Branch:");
        jPanel18.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 150, -1));

        lbl_branch.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_branch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel18.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 210, 30));

        lbl_studentError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_studentError.setForeground(new java.awt.Color(255, 255, 0));
        jPanel18.add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 250, 40));

        add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, 590, 340));

        jLabel45.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Book name:");
        add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 250, -1));

        lbl_bookName1.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookName1.setForeground(new java.awt.Color(255, 255, 255));
        add(lbl_bookName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 310, 30));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 51, 51));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel50.setText("Book Id:");
        add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 150, 70));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 51, 51));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel52.setText("Student Id:");
        add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 150, 70));

        txt_bookId.setBackground(new java.awt.Color(255, 255, 255));
        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 120, 70)));
        txt_bookId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_bookId.setPlaceholder("Enter Book Id...");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 350, 50));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 51, 51));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel51.setText("Issue Date:");
        add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 100, 70));

        date_issueDate.setColorBackground(new java.awt.Color(255, 120, 70));
        date_issueDate.setColorForeground(new java.awt.Color(255, 120, 70));
        date_issueDate.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        date_issueDate.setPlaceholder("Select Issue Date");
        add(date_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 310, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Issue Date:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 100, 70));

        date_dueDate.setForeground(new java.awt.Color(255, 255, 255));
        date_dueDate.setColorBackground(new java.awt.Color(255, 120, 70));
        date_dueDate.setColorForeground(new java.awt.Color(255, 120, 70));
        date_dueDate.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        date_dueDate.setPlaceholder("Select Due Date");
        add(date_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, 310, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 120, 70));
        rSMaterialButtonCircle1.setText("ISSUE BOOK");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 400, 70));

        lbl_bookError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 0));
        add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 250, 30));

        txt_studentId.setBackground(new java.awt.Color(255, 255, 255));
        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 120, 70)));
        txt_studentId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_studentId.setPlaceholder("Enter Student Id...");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 350, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
       
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
           if (lbl_quantity.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Book is not available");
        } else {
            if (isAlreadyIssued() == false) {
                if (issueBook() == true) {
                    updateBookCount(); // call updateBookCount here
                    JOptionPane.showMessageDialog(this, "Book issued successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Can't issue the book");
                }
            } else {
                JOptionPane.showMessageDialog(this, "This student already issued this book");
            }
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
         if (!txt_studentId.getText().equals("")){
            getStudentDetails();
    }                                       
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        if (!txt_bookId.getText().equals("")){
            getBookDetails();
        }
    }//GEN-LAST:event_txt_studentIdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_dueDate;
    private rojeru_san.componentes.RSDateChooser date_issueDate;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookId;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_bookName1;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_studentError;
    private javax.swing.JLabel lbl_studentId;
    private javax.swing.JLabel lbl_studentName;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
