
package com.raven.form;

import java.sql.PreparedStatement;
import java.sql.DriverManager;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.JOptionPane;

public class Form_1 extends javax.swing.JPanel {

   
    public Form_1() {
        initComponents();
        setBookDetailsToTable();
    }
    
    
     String bookName, author;
    int bookId, quantity;
    DefaultTableModel model;
    
    
//to set the book details into the table
    public void setBookDetailsToTable(){
         
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
           Statement st = con.createStatement();
           ResultSet rs =  st.executeQuery("select * from book_details");
           
           while (rs.next()){
                   String bookId = rs.getString("book_id");
                   String bookName = rs.getString("book_name");
                   String author = rs.getString("author");
                   int quantity = rs.getInt("quantity");
                   
                   Object[] obj = {bookId, bookName, author, quantity};
                   model = (DefaultTableModel) tbl_bookDetails.getModel();
                   model.addRow(obj);
           }
           
        } catch (Exception e) {
            // Handle the exception and print an error message
            e.printStackTrace();
        }
    }
    
    
    // to add book to book_details table
    public boolean addBook(){
        boolean isAdded = false;
        //to get the text typed in the textbox
        bookId = Integer.parseInt(txt_bookId.getText());
        bookName = txt_bookName.getText();
        author = txt_authorName.getText();
        quantity = Integer.parseInt(txt_quantity.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into book_details values(?,?,?,?)";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setString(2, bookName);
            pst.setString(3, author);
            pst.setInt(4, quantity);
            
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
    
     
    //to update book details 
    public boolean updateBook(){
         boolean isUpdated = false;
         //to get the text typed in the textbox
         bookId = Integer.parseInt(txt_bookId.getText());
         bookName = txt_bookName.getText();
         author = txt_authorName.getText();
         //converts string into integer
         quantity = Integer.parseInt(txt_quantity.getText());
         
         try {
            Connection con = DBConnection.getConnection();
            // WHERE - filter records in a sql query and adds a condition to include only the rows that meet the specified criteria
            String sql = "update book_details set book_name = ?, author = ?, quantity = ? where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, bookName);
            pst.setString(2, author);
            pst.setInt(3, quantity);
            pst.setInt(4, bookId);
            
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
    
    //to delete book in book_details table
    public boolean deleteBook(){
         boolean isDeleted = false;
         bookId = Integer.parseInt(txt_bookId.getText());
    
         try {
             // (1) ESTABLISH CONNECTION 
            Connection con = DBConnection.getConnection();
            
            // (2)  PUT PLACEHOLDERS(' ? ') FOR PARAMETERS
            String sql = "delete from book_details where book_id = ? ";
            //prepStatement string named sql goes to database MySQL
            PreparedStatement pst = con.prepareStatement(sql);
            
            // (3) SETS THE VALUES FOR THE PLACEHOLDER
            pst.setInt(1, bookId);
            
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
         DefaultTableModel model = (DefaultTableModel) tbl_bookDetails.getModel();
         model.setRowCount(0);
    }
 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_bookError = new javax.swing.JLabel();
        card_background1 = new com.raven.component.Card_background();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_bookName = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_authorName = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_quantity = new app.bolivia.swing.JCTextField();
        panelBorder1 = new com.raven.swing.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojeru_san.complementos.RSTableMetro();
        rSMaterialButtonCircle5 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle4 = new rojerusan.RSMaterialButtonCircle();

        setBackground(new java.awt.Color(242, 242, 242));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_bookError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 0));
        add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 150, 30));

        card_background1.setColor1(new java.awt.Color(0, 0, 70));
        card_background1.setColor2(new java.awt.Color(0, 51, 80));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MANAGE BOOKS");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Enter Book Id");

        txt_bookId.setBackground(new java.awt.Color(255, 255, 255));
        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 80)));
        txt_bookId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_bookId.setPlaceholder("Enter Book Id...");
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Enter Book Name");

        txt_bookName.setBackground(new java.awt.Color(255, 255, 255));
        txt_bookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 80)));
        txt_bookName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_bookName.setPlaceholder("Enter Book Name...");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Author Name");

        txt_authorName.setBackground(new java.awt.Color(255, 255, 255));
        txt_authorName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 80)));
        txt_authorName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_authorName.setPlaceholder("Enter Author Name...");
        txt_authorName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_authorNameActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Quantity");

        txt_quantity.setBackground(new java.awt.Color(255, 255, 255));
        txt_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 80)));
        txt_quantity.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_quantity.setPlaceholder("Enter Quantity...");
        txt_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quantityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout card_background1Layout = new javax.swing.GroupLayout(card_background1);
        card_background1.setLayout(card_background1Layout);
        card_background1Layout.setHorizontalGroup(
            card_background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card_background1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(card_background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_bookId, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_bookName, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_authorName, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
            .addGroup(card_background1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        card_background1Layout.setVerticalGroup(
            card_background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card_background1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(card_background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(card_background1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(txt_bookId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(card_background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(card_background1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(txt_bookName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(card_background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(card_background1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(txt_authorName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(card_background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(card_background1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        add(card_background1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 560, 660));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 127, 127));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/book.png"))); // NOI18N

        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Name", "Author", "Quantity"
            }
        ));
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(0, 0, 70));
        tbl_bookDetails.setColorBordeFilas(new java.awt.Color(0, 0, 70));
        tbl_bookDetails.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tbl_bookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_bookDetails.setRowHeight(40);
        tbl_bookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_bookDetails);

        rSMaterialButtonCircle5.setBackground(new java.awt.Color(0, 0, 70));
        rSMaterialButtonCircle5.setText("UPDATE");
        rSMaterialButtonCircle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle5ActionPerformed(evt);
            }
        });

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(0, 0, 70));
        rSMaterialButtonCircle1.setText("ADD");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(0, 0, 70));
        rSMaterialButtonCircle4.setText("DELETE");
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(rSMaterialButtonCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSMaterialButtonCircle5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(rSMaterialButtonCircle4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMaterialButtonCircle5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonCircle4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 610));
    }// </editor-fold>//GEN-END:initComponents

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_authorNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_authorNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_authorNameActionPerformed

    private void txt_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantityActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        if (addBook() == true) {
            JOptionPane.showMessageDialog(this, "Book Added");
            clearTable();
            setBookDetailsToTable();
        }else{
            JOptionPane.showMessageDialog(this, "Book Addition Failed");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
        if (deleteBook() == true) {
            JOptionPane.showMessageDialog(this, "Book Deleted");
            clearTable();
            setBookDetailsToTable();
        }else{
            JOptionPane.showMessageDialog(this, "Book DeletionFailed");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void rSMaterialButtonCircle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle5ActionPerformed
        if (updateBook() == true) {
            JOptionPane.showMessageDialog(this, "Book Updated");
            clearTable();
            setBookDetailsToTable();
        }else{
            JOptionPane.showMessageDialog(this, "Book Updation Failed");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle5ActionPerformed

    private void tbl_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookDetailsMouseClicked

        int rowNo = tbl_bookDetails.getSelectedRow();
        TableModel model = tbl_bookDetails.getModel();

        txt_bookId.setText(model.getValueAt(rowNo, 0).toString());
        txt_bookName.setText(model.getValueAt(rowNo, 1).toString());
        txt_authorName.setText(model.getValueAt(rowNo, 2).toString());
        txt_quantity.setText(model.getValueAt(rowNo, 3).toString());
    }//GEN-LAST:event_tbl_bookDetailsMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Card_background card_background1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_bookError;
    private com.raven.swing.PanelBorder panelBorder1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle5;
    private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
    private app.bolivia.swing.JCTextField txt_authorName;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_bookName;
    private app.bolivia.swing.JCTextField txt_quantity;
    // End of variables declaration//GEN-END:variables
}
