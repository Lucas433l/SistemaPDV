/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import dao.CouponDAO;
import dao.ProductDAO;
import dao.SellDAO;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Coupon;
import model.Product;
import model.Sell;

/**
 *
 * @author lucas
 */
public class Cash extends javax.swing.JFrame {

    /**
     * Creates new form Cash
     */
    public Cash() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    public void readTable(List<Sell> sales){
        DefaultTableModel model = (DefaultTableModel) jTCoupon.getModel();
        model.setNumRows(0);
        
        for(Sell p : sales){
            model.addRow(new Object[]{
               p.getBarCode(),
               p.getName(),
               p.getQuantity(),
               p.getPrice()
            });
        }
    }
    
    public void printCoupon(List<Sell> sales){
        String dateF = "dd/MM/yyyy";
        String hourF = "hh:mm - a";
        String date, hour;
        Date dateCurrent = new Date();
        SimpleDateFormat format = new SimpleDateFormat(dateF);
        date = format.format(dateCurrent);
        format = new SimpleDateFormat(hourF);
        hour = format.format(dateCurrent);
        
        Coupon coupon = new Coupon();
        Long idCoupon = Long.valueOf(jTIdCoupon.getText());
        float total = Float.valueOf(jTTotal.getText());
        
        coupon.setDateHour(date + " - " + hour);
        coupon.setPrice(total);
        coupon.setIdCoupon(idCoupon);
        CouponDAO dao = new CouponDAO();
        
        dao.update(coupon);
        
        String print = "";
        
        for(int i = 0; i < sales.size(); i++){
            print += sales.get(i).getName() + "   " +
                    sales.get(i).getQuantity() + "       " +
                    sales.get(i).getPrice() + "\n";
        }
        
        this.printer( "          MERCADINHO RDR        \n"
                    +               "\n"
                    +        date + " - " + hour +    "\n"
                    + "--------------------------------\n"
                    + "         CUPOM NAO FISCAL       \n"
                    + "--------------------------------\n"
                    + "NOME       | QTD   |   PRECO(R$)\n"
                    + print
                    + "--------------------------------\n"
                    + "TOTAL R$            " + jTTotal.getText() + "\n"
                    + "DINHEIRO            " + jTTotalReceived.getText() + "\n"
                    + "TROCO R$            " + jTChange.getText() + "\n"
                    + "--------------------------------\n"
                    + "\n"
                    + "     OBRIGADO E VOLTE SEMPRE    \n"
                    + "\n"
                    + "\n"
                    + "\f");
    }
    public void printer(String coupon){
        try{
            InputStream prin = new ByteArrayInputStream(coupon.getBytes( "8859_1" ));
            DocFlavor docFlavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            SimpleDoc documentText = new SimpleDoc(prin, docFlavor, null);
            PrintService printer = PrintServiceLookup.lookupDefaultPrintService();
            
            PrintRequestAttributeSet printerAttributes = new HashPrintRequestAttributeSet();
            printerAttributes.add(new JobName("Cupom Não Fiscal", null));
            printerAttributes.add(OrientationRequested.PORTRAIT);
            printerAttributes.add(MediaSizeName.ISO_A4);
            
            DocPrintJob printJob = printer.createPrintJob();
            try{
                printJob.print(documentText, (PrintRequestAttributeSet) printerAttributes);
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Ocorreu um erro na hora da impressão.");
            }
            
            prin.close();
        }catch(Exception e){
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTCoupon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTBarCode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTQuantity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTPriceUnit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTTotal = new javax.swing.JTextField();
        jBOpen = new javax.swing.JButton();
        jBWithdraw = new javax.swing.JButton();
        jBAdd = new javax.swing.JButton();
        jBFinally = new javax.swing.JButton();
        jBPrint = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTTotalReceived = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTChange = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTIdCoupon = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jTName.setEditable(false);
        jTName.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jTName.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jTCoupon.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTCoupon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código de Barras", "Nome", "Quantidade", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTCoupon.setFillsViewportHeight(true);
        jTCoupon.setRowHeight(26);
        jScrollPane1.setViewportView(jTCoupon);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.jpg"))); // NOI18N

        jTBarCode.setEditable(false);
        jTBarCode.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jTBarCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTBarCodeKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel2.setText("Código de Barras:");

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel3.setText("Quantidade:");

        jTQuantity.setEditable(false);
        jTQuantity.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jTQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTQuantityKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel4.setText("Valor Unitário:");

        jTPriceUnit.setEditable(false);
        jTPriceUnit.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jTPriceUnit.setText("0.00");

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel5.setText("Total de Item:");

        jTPrice.setEditable(false);
        jTPrice.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jTPrice.setText("0.00");

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel6.setText("Subtotal da Compra:");

        jTTotal.setEditable(false);
        jTTotal.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jTTotal.setText("0.00");

        jBOpen.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jBOpen.setText("Abrir Caixa");
        jBOpen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBOpenMouseClicked(evt);
            }
        });

        jBWithdraw.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jBWithdraw.setText("Retirar Produto");
        jBWithdraw.setEnabled(false);
        jBWithdraw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBWithdrawMouseClicked(evt);
            }
        });

        jBAdd.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jBAdd.setText("Adicionar Produto");
        jBAdd.setEnabled(false);
        jBAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBAddMouseClicked(evt);
            }
        });
        jBAdd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jBAddKeyReleased(evt);
            }
        });

        jBFinally.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jBFinally.setText("Finalizar Compra");
        jBFinally.setEnabled(false);
        jBFinally.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBFinallyMouseClicked(evt);
            }
        });

        jBPrint.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jBPrint.setText("Imprimir Cupom");
        jBPrint.setEnabled(false);
        jBPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBPrintMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel7.setText("Total Recebido:");

        jTTotalReceived.setEditable(false);
        jTTotalReceived.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jTTotalReceived.setText("0.00");
        jTTotalReceived.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTTotalReceivedKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel8.setText("Troco:");

        jTChange.setEditable(false);
        jTChange.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jTChange.setText("0.00");

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel9.setText("Código:");

        jTIdCoupon.setEditable(false);
        jTIdCoupon.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel10.setText("Nome:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBWithdraw, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBFinally, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTIdCoupon))
                                .addComponent(jBOpen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTName)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jTBarCode)
                            .addComponent(jTQuantity)
                            .addComponent(jLabel4)
                            .addComponent(jTPriceUnit, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(jTPrice)
                            .addComponent(jLabel6)
                            .addComponent(jTTotal)
                            .addComponent(jLabel7)
                            .addComponent(jTTotalReceived)
                            .addComponent(jLabel8)
                            .addComponent(jTChange))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTName, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTPriceUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jTIdCoupon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBOpen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTTotalReceived, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBWithdraw)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBFinally)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBPrint)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBOpenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBOpenMouseClicked
        CouponDAO dao = new CouponDAO();
        Long idCoupon = dao.insert();
        jTIdCoupon.setText(idCoupon.toString());
        
        DefaultTableModel model = (DefaultTableModel) jTCoupon.getModel();
        model.setNumRows(0);
        
        jBAdd.setEnabled(true);
        jBFinally.setEnabled(true);
        jBWithdraw.setEnabled(true);
        jTBarCode.setEditable(true);
        jTQuantity.setEditable(true);
        jBOpen.setEnabled(false);
    }//GEN-LAST:event_jBOpenMouseClicked

    private void jTBarCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTBarCodeKeyReleased
        ProductDAO dao = new ProductDAO();
        Long barCode = Long.valueOf(jTBarCode.getText());
        try{
            Product product = dao.selectUniqueBarCode(barCode);
            jTName.setText(product.getName());
            jTPriceUnit.setText(product.getPrice().toString());
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_jTBarCodeKeyReleased

    private void jBAddKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBAddKeyReleased
        
    }//GEN-LAST:event_jBAddKeyReleased

    private void jBAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBAddMouseClicked
        ProductDAO productDAO = new ProductDAO();
        if(!jTBarCode.getText().isEmpty()){
            Long barCode = Long.valueOf(jTBarCode.getText());
            Product product = productDAO.selectUniqueBarCode(barCode);
            float quantity = Float.valueOf(jTQuantity.getText().replace(",","."));
            if(quantity <= product.getStock() && quantity > 0){
                Sell sell = new Sell();
                sell.setBarCode(barCode);
                sell.setIdCoupon(Long.valueOf(jTIdCoupon.getText()));
                sell.setName(product.getName());
                sell.setPrice(product.getPrice() * quantity);
                sell.setQuantity(quantity);
                
                SellDAO sellDAO = new SellDAO();
                sellDAO.insert(sell);
                
                float priceTotal = Float.valueOf(jTTotal.getText()) + (product.getPrice() * quantity);
                
                jTTotal.setText(String.valueOf(priceTotal));
                readTable(sellDAO.selectAll(Long.valueOf(jTIdCoupon.getText())));
                
                jTBarCode.setText("");
                jTQuantity.setText("");
                jTName.setText("");
                jTPriceUnit.setText("0.00");
                jTPrice.setText("0.00");
            }
            else
                JOptionPane.showMessageDialog(null,"Quantidade inválida");
        }
        else
            JOptionPane.showMessageDialog(null,"Nenhum produto selecionado.");
    }//GEN-LAST:event_jBAddMouseClicked

    private void jTQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTQuantityKeyReleased
        try{
            float quantity = Float.valueOf(jTQuantity.getText().replace(",","."));
            float price = Float.valueOf(jTPriceUnit.getText());
            float priceTotal = quantity * price;

            jTPrice.setText(String.valueOf(priceTotal));
        }catch(Exception e){
            jTPrice.setText("0.00");
        }
    }//GEN-LAST:event_jTQuantityKeyReleased

    private void jBWithdrawMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBWithdrawMouseClicked
        int row = jTCoupon.getSelectedRow();
        if(row >= 0){
            Long idCoupon = Long.valueOf(jTIdCoupon.getText());
            Long barCode = (Long) jTCoupon.getValueAt(row, 0);
            SellDAO dao = new SellDAO();
            dao.delete(barCode, idCoupon);
            readTable(dao.selectAll(idCoupon));
        }else
            JOptionPane.showMessageDialog(null,"Selecione um produto.");
    }//GEN-LAST:event_jBWithdrawMouseClicked

    private void jBFinallyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBFinallyMouseClicked
        Long idCoupon = Long.valueOf(jTIdCoupon.getText());
        
        jBOpen.setEnabled(true);
        jBOpen.setEnabled(true);
        jTTotalReceived.setEditable(true);
        jBPrint.setEnabled(true);
        
        SellDAO dao = new SellDAO();
        for(Sell sell: dao.selectAll(idCoupon)){
            ProductDAO pDAO = new ProductDAO();
            Product product = pDAO.selectUniqueBarCode(sell.getBarCode());
            float stock = product.getStock();
            float quantity = sell.getQuantity();
            product.setStock( stock - quantity);
            
            pDAO.update(product);
        }
        
        jBAdd.setEnabled(false);
        jBWithdraw.setEnabled(false);
    }//GEN-LAST:event_jBFinallyMouseClicked

    private void jTTotalReceivedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTotalReceivedKeyReleased
        try{
            float change = Float.valueOf(jTTotalReceived.getText()) - Float.valueOf(jTTotal.getText());
            int casasDecimais = 2;
            BigDecimal aNumber = new BigDecimal(change);
            aNumber = aNumber.setScale(casasDecimais, BigDecimal.ROUND_HALF_UP);	
            double value = aNumber.doubleValue();
            jTChange.setText(String.valueOf(value));
        }catch(Exception e){}
    }//GEN-LAST:event_jTTotalReceivedKeyReleased

    private void jBPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBPrintMouseClicked
        Long idCoupon = Long.valueOf(jTIdCoupon.getText());
        SellDAO dao = new SellDAO();
        printCoupon(dao.selectAll(idCoupon));
    }//GEN-LAST:event_jBPrintMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBFinally;
    private javax.swing.JButton jBOpen;
    private javax.swing.JButton jBPrint;
    private javax.swing.JButton jBWithdraw;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTBarCode;
    private javax.swing.JTextField jTChange;
    private javax.swing.JTable jTCoupon;
    private javax.swing.JTextField jTIdCoupon;
    private javax.swing.JTextField jTName;
    private javax.swing.JTextField jTPrice;
    private javax.swing.JTextField jTPriceUnit;
    private javax.swing.JTextField jTQuantity;
    private javax.swing.JTextField jTTotal;
    private javax.swing.JTextField jTTotalReceived;
    // End of variables declaration//GEN-END:variables
}
