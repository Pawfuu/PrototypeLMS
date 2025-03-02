
package com.raven.form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

public class Form_3 extends javax.swing.JPanel {

   
    public Form_3() {
        initComponents();
    }
    
    
  public void getIssueBookDetails(){
    // get text method gets string not integer, thats why we use parse int
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where book_id = ? and student_id = ? and status = ?";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setInt(2, studentId);
            pst.setString(3, "pending");
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                   lbl_issueId.setText(rs.getString("id"));
                   lbl_bookName.setText(rs.getString("book_name"));
                   lbl_studentName.setText(rs.getString("student_name"));
                   lbl_issueDate.setText(rs.getString("issue_date"));
                   lbl_dueDate.setText(rs.getString("due_date"));
                   lbl_bookError.setText("");   
            }else{
                   lbl_bookError.setText("No Record Found");
                   
                    lbl_issueId.setText(rs.getString(""));
                   lbl_bookName.setText(rs.getString(""));
                   lbl_studentName.setText(rs.getString(""));
                   lbl_issueDate.setText(rs.getString(""));
                   lbl_dueDate.setText(rs.getString(""));
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    //return the book 
    public boolean returnBook() {
        boolean isReturn = false;
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        /*BETTER UNDERSTANDING  = SQL IS 1 IS DESIGNATED TO STATUS , 
        2 STUDENT_ID (WHICH ARE FOUND IN THE DATABASE) (2, ___ ) THE Y PLACEHOLDER IS THE studentId var
        that gets the text from the app. [SO IN SUMMARY THE GET.TEXT INPUTS THE DATA TO THE MYSQL
        */ 
        try {
            Connection con = DBConnection.getConnection();
            //Creating a querie
            String sql = " update issue_book_details set status = ? where student_id =? and book_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            //set values of placeholders
            pst.setString(1, "returned");
            pst.setInt(2, studentId);
            pst.setInt(3, bookId);
            pst.setString(4, "pending");
            
            int rowCount = pst.executeUpdate();
            if (rowCount > 0){
                isReturn = true;
            }else{
                isReturn = false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isReturn;
    }
    
   
    //updating the amount of books issued
    public void updateBookCount() {
        int bookId = Integer.parseInt(txt_bookId.getText());
        try {
            //(1) establish database connection
            Connection con = DBConnection.getConnection();
            //(2) sql command to decrease the book quantity by 1
            String sql = "update book_details set quantity = quantity + 1 where book_id = ?";
            //(3) Prepare the SQL statement
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);

            //(4) EXECUTES THE UPDATE. IT RETURNS AN 'INT' INDICATING THE NUMBER OF ROWS AFFECTED
            int RowCount = pst.executeUpdate();
            if (RowCount > 0) {
                JOptionPane.showMessageDialog(this, "Book count updated");
            } else {
                JOptionPane.showMessageDialog(this, "Can't update book count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel21 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        lbl_issueId = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        lbl_issueDate = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        lbl_dueDate = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        lbl_bookName1 = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        jPanel20 = new javax.swing.JPanel();
        card_background2 = new com.raven.component.Card_background();
        card_background3 = new com.raven.component.Card_background();
        card_background1 = new com.raven.component.Card_background();

        setBackground(new java.awt.Color(242, 242, 242));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel21.setBackground(new java.awt.Color(113, 115, 153));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 450, 10));

        jPanel17.setBackground(new java.awt.Color(0, 0, 70));
        jPanel17.setForeground(new java.awt.Color(255, 255, 255));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/open-book.png"))); // NOI18N
        jLabel42.setText("  Book Details");
        jPanel17.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 230, 80));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel17.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 330, 5));

        lbl_issueId.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_issueId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel17.add(lbl_issueId, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 210, 30));

        jLabel47.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Issue Id :");
        jPanel17.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 150, -1));

        jLabel44.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Book Name :");
        jPanel17.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 150, -1));

        lbl_bookName.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel17.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 210, 30));

        lbl_studentName.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel17.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 210, 30));

        jLabel46.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Student Name:");
        jPanel17.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 150, -1));

        jLabel53.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Issue Date :");
        jPanel17.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 150, -1));

        lbl_issueDate.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_issueDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel17.add(lbl_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 210, 30));

        jLabel54.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Due Date :");
        jPanel17.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 150, -1));

        lbl_dueDate.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_dueDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel17.add(lbl_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 210, 30));

        add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 660));

        jLabel45.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Book name:");
        add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 150, -1));

        lbl_bookName1.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookName1.setForeground(new java.awt.Color(255, 255, 255));
        add(lbl_bookName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 210, 30));

        lbl_bookError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 0));
        add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 150, 30));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel50.setText("Student Id:");
        add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, 180, 70));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(211, 47, 47));
        rSMaterialButtonCircle2.setText("RETURN BOOK");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 430, 480, 70));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(0, 0, 70));
        rSMaterialButtonCircle1.setText("FIND");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, 480, 70));

        txt_studentId.setBackground(new java.awt.Color(255, 255, 255));
        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 70)));
        txt_studentId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_studentId.setPlaceholder("Enter Student Id....");
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
        add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 370, 50));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/return .png"))); // NOI18N
        jLabel2.setText("RETURN BOOK");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 430, 70));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel51.setText("Book Id:");
        add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 180, 70));

        txt_bookId.setBackground(new java.awt.Color(255, 255, 255));
        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 70)));
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
        add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 180, 370, 50));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 330, 5));

        card_background2.setBackground(new java.awt.Color(0, 0, 70));
        card_background2.setColor1(new java.awt.Color(0, 0, 70));
        card_background2.setColor2(new java.awt.Color(113, 115, 153));
        add(card_background2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 490, 210));

        card_background3.setBackground(new java.awt.Color(0, 0, 70));
        card_background3.setColor1(new java.awt.Color(0, 0, 70));
        card_background3.setColor2(new java.awt.Color(113, 115, 153));
        add(card_background3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 490, 210));

        card_background1.setBackground(new java.awt.Color(0, 0, 70));
        card_background1.setColor1(new java.awt.Color(0, 0, 70));
        card_background1.setColor2(new java.awt.Color(113, 115, 153));
        add(card_background1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 630, 680));
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
getIssueBookDetails();      
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
  if (returnBook() == true){
        JOptionPane.showMessageDialog(this, "Book Returned Successfully");
        updateBookCount();
        }else{
        JOptionPane.showMessageDialog(this, "Book Returned Failed ");
        }        
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost

    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Card_background card_background1;
    private com.raven.component.Card_background card_background2;
    private com.raven.component.Card_background card_background3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_bookName1;
    private javax.swing.JLabel lbl_dueDate;
    private javax.swing.JLabel lbl_issueDate;
    private javax.swing.JLabel lbl_issueId;
    private javax.swing.JLabel lbl_studentName;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
