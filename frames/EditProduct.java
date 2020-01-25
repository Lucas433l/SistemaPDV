package frames;

import dao.ProductDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Product;

/**
 *
 * @author lucas
 */
public class EditProduct extends javax.swing.JFrame {

    public EditProduct() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel) jTProducts.getModel();
        jTProducts.setRowSorter(new TableRowSorter(model));
        
        readTable();
        
    }
    
    public void readTable(){
        DefaultTableModel model = (DefaultTableModel) jTProducts.getModel();
        model.setNumRows(0);
        
        ProductDAO dao = new ProductDAO();
        
        for(Product p : dao.selectAll()){
            model.addRow(new Object[]{
               p.getBarCode(),
               p.getName(),
               p.getStock(),
               p.getPrice()
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProducts = new javax.swing.JTable();
        jBEdit = new javax.swing.JButton();
        jBDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTBarCode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTProducts.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTProducts.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jTProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código de Barras", "Nome", "Estoque", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTProducts.setRowHeight(28);
        jScrollPane1.setViewportView(jTProducts);

        jBEdit.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jBEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editproduct.png"))); // NOI18N
        jBEdit.setText("Editar");
        jBEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBEditMouseClicked(evt);
            }
        });

        jBDelete.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jBDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trash.png"))); // NOI18N
        jBDelete.setText("Deletar");
        jBDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBDeleteMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("Código de Barras:");

        jTBarCode.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jTBarCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTBarCodeKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel2.setText("Nome:");

        jTName.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jTName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNameKeyReleased(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(jBEdit)
                .addGap(143, 143, 143)
                .addComponent(jBDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTName, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addContainerGap(434, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBDelete)
                    .addComponent(jBEdit))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jBEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBEditMouseClicked
        int row = jTProducts.getSelectedRow();
        if(row >= 0){
            Long barCode = (Long) jTProducts.getValueAt(row, 0);
            new UpdateProduct(barCode).setVisible(true);
            this.setVisible(false);
        }else
            JOptionPane.showMessageDialog(null,"Selecione um produto");
    }//GEN-LAST:event_jBEditMouseClicked

    private void jBDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBDeleteMouseClicked
        int row = jTProducts.getSelectedRow();
        if(row >= 0){
            Long barCode = (Long) jTProducts.getValueAt(row, 0);
            ProductDAO dao = new ProductDAO();
            dao.delete(barCode);
            readTable();
        }else
            JOptionPane.showMessageDialog(null,"Selecione um produto");
    }//GEN-LAST:event_jBDeleteMouseClicked

    private void jTBarCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTBarCodeKeyReleased
        DefaultTableModel model = (DefaultTableModel) jTProducts.getModel();
        model.setNumRows(0);
        
        ProductDAO dao = new ProductDAO();
        String barCode = jTBarCode.getText();
        for(Product p : dao.selectForBarCode(barCode)){
            model.addRow(new Object[]{
               p.getBarCode(),
               p.getName(),
               p.getStock(),
               p.getPrice()
            });
        }
    }//GEN-LAST:event_jTBarCodeKeyReleased

    private void jTNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNameKeyReleased
        DefaultTableModel model = (DefaultTableModel) jTProducts.getModel();
        model.setNumRows(0);
        
        ProductDAO dao = new ProductDAO();
        String name = jTName.getText();
        for(Product p : dao.selectForName(name)){
            model.addRow(new Object[]{
               p.getBarCode(),
               p.getName(),
               p.getStock(),
               p.getPrice()
            });
        }
    }//GEN-LAST:event_jTNameKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBDelete;
    private javax.swing.JButton jBEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTBarCode;
    private javax.swing.JTextField jTName;
    private javax.swing.JTable jTProducts;
    // End of variables declaration//GEN-END:variables
}
