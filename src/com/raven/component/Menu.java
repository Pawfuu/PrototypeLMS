package com.raven.component;

import com.raven.event.EventMenuSelected;
import com.raven.model.Model_Menu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

public class Menu extends javax.swing.JPanel {

    private EventMenuSelected event;

    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        listMenu1.addEventMenuSelected(event);
    }

    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
        init();
    }

    private void init() {
        listMenu1.addItem(new Model_Menu("0", "Dashboard", Model_Menu.MenuType.MENU));
         listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
         
        listMenu1.addItem(new Model_Menu("", "BOOK MANAGEMENT", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("1", "Manage Books", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("2", "Issue Books", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("3", "Return Book", Model_Menu.MenuType.MENU));
        
        listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        
         listMenu1.addItem(new Model_Menu("", "STUDENT MANAGEMENT", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("4", "Manage Students", Model_Menu.MenuType.MENU));
        
          listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));

         listMenu1.addItem(new Model_Menu("", "RECORDS & TRACLOMG", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("5", "View Records", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("6", "View Issued Books", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("7", "Defaulter List", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar1 = new com.raven.swing.ImageAvatar();
        panelMoving = new javax.swing.JPanel();
        imageAvatar3 = new com.raven.swing.ImageAvatar();
        jLabel1 = new javax.swing.JLabel();
        listMenu1 = new com.raven.swing.ListMenu<>();

        panelMoving.setOpaque(false);

        imageAvatar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Copy of MahsIcon (1).png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome Admin");

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(panelMovingLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(imageAvatar3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(imageAvatar3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#000091"), 0, getHeight(), Color.decode("#000046"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }

    private int x;
    private int y;

    public void initMoving(JFrame fram) {
        panelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }

        });
        panelMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.ImageAvatar imageAvatar1;
    private com.raven.swing.ImageAvatar imageAvatar3;
    private javax.swing.JLabel jLabel1;
    private com.raven.swing.ListMenu<String> listMenu1;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables
}
