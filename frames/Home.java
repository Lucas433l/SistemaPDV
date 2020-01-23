/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.awt.GridLayout;
import javax.swing.JFrame;
import utils.Wallpaper;

/**
 *
 * @author lucas
 */
public class Home extends javax.swing.JFrame {

    Wallpaper frame;
    JFrame openFrame;
    boolean open = false;
    public Home() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH); 
        setLayout(new GridLayout());
        frame = new Wallpaper("src/images/background.png");
        getContentPane().add(frame);
    }
     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        newProduct = new javax.swing.JMenu();
        editProduct = new javax.swing.JMenu();
        cash = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");

        newProduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        newProduct.setText("Cadastrar Produto");
        newProduct.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        newProduct.setMargin(new java.awt.Insets(5, 0, 5, 0));
        newProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newProductMouseClicked(evt);
            }
        });
        jMenuBar1.add(newProduct);

        editProduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        editProduct.setText("Editar Produto");
        editProduct.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        editProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editProductMouseClicked(evt);
            }
        });
        jMenuBar1.add(editProduct);

        cash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cash.setText("Caixa");
        cash.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        cash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cashMouseClicked(evt);
            }
        });
        jMenuBar1.add(cash);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 366, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void newProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newProductMouseClicked
        if(open)
            openFrame.setVisible(false);
        openFrame = new NewProduct();
        openFrame.setVisible(true);
        open = true;
    }//GEN-LAST:event_newProductMouseClicked

    private void editProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editProductMouseClicked
        if(open)    
            openFrame.setVisible(false);
        openFrame = new EditProduct();
        openFrame.setVisible(true);
        open = true;
    }//GEN-LAST:event_editProductMouseClicked

    private void cashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cashMouseClicked
        if(open)
            openFrame.setVisible(false);
        openFrame = new Cash();
        openFrame.setVisible(true);
        open = true;
    }//GEN-LAST:event_cashMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu cash;
    private javax.swing.JMenu editProduct;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu newProduct;
    // End of variables declaration//GEN-END:variables
}
