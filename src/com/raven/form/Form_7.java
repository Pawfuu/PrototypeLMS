
package com.raven.form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Form_7 extends javax.swing.JPanel {

    DefaultTableModel model;
    public Form_7() {
        initComponents();
        setIssueBookDetailsToTable();
    }
    
    
   // to set the book details into the table
    public void setIssueBookDetailsToTable(){
    
        //get the current time and date. It returns a long value 
        long l = System.currentTimeMillis();
        java.sql.Date todaysDate = new java.sql.Date(l);
         
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
           PreparedStatement pst = con.prepareStatement("select * from issue_book_details where due_date  < ? and status = ? ");
           pst.setDate(1, todaysDate);
           pst.setString(2, "pending");
           ResultSet rs =  pst.executeQuery();
           
           while (rs.next()){
                   String id = rs.getString("id");
                   String bookName = rs.getString("book_name");
                   String studentName = rs.getString("student_name");
                   String issueDate = rs.getString("issue_date");
                   String dueDate = rs.getString("due_date");
                   String status = rs.getString("status");
                   
                   Object[] obj = {id,bookName,studentName,issueDate,dueDate,status};
                   model = (DefaultTableModel)tbl_issueBookDetails .getModel();
                   model.addRow(obj);
           }
           
           
        } catch (Exception e) {
            // Handle the exception and print an error message
            e.printStackTrace();
        }
    }
 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_bookError = new javax.swing.JLabel();
        card_background1 = new com.raven.component.Card_background();
        jLabel2 = new javax.swing.JLabel();
        panelBorder1 = new com.raven.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_issueBookDetails = new rojeru_san.complementos.RSTableMetro();

        setBackground(new java.awt.Color(242, 242, 242));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_bookError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 0));
        add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 150, 30));

        card_background1.setColor1(new java.awt.Color(255, 51, 51));
        card_background1.setColor2(new java.awt.Color(253, 185, 185));

        jLabel2.setBackground(new java.awt.Color(0, 0, 70));
        jLabel2.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(" DEFAULTER LIST");

        javax.swing.GroupLayout card_background1Layout = new javax.swing.GroupLayout(card_background1);
        card_background1.setLayout(card_background1Layout);
        card_background1Layout.setHorizontalGroup(
            card_background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card_background1Layout.createSequentialGroup()
                .addGap(316, 316, 316)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(354, Short.MAX_VALUE))
        );
        card_background1Layout.setVerticalGroup(
            card_background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card_background1Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        add(card_background1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1180, 170));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Standard Table Design");

        tbl_issueBookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book Name", "Student Name", "Issue Date", "Due Date", "Status"
            }
        ));
        tbl_issueBookDetails.setColorBackgoundHead(new java.awt.Color(255, 51, 51));
        tbl_issueBookDetails.setColorBordeFilas(new java.awt.Color(255, 51, 51));
        tbl_issueBookDetails.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tbl_issueBookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_issueBookDetails.setRowHeight(40);
        jScrollPane2.setViewportView(tbl_issueBookDetails);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(422, 422, 422)
                .addComponent(jLabel1)
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1180, 520));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Card_background card_background1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_bookError;
    private com.raven.swing.PanelBorder panelBorder1;
    private rojeru_san.complementos.RSTableMetro tbl_issueBookDetails;
    // End of variables declaration//GEN-END:variables
}
