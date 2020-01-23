package dao;

import Connection.ConnectionFactory;
import java.sql.PreparedStatement;
import model.Product;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class ProductDAO {
    public void insert(Product product){
        String sql = "INSERT INTO product(bar_code, name,  stock, price) VALUES(?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            pstm.setLong(1, product.getBarCode());
            pstm.setString(2, product.getName());
            pstm.setFloat(3, product.getStock());
            pstm.setFloat(4, product.getPrice());
            
            pstm.execute();
            JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso.");
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado, informe o suporte.");
        }finally{
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado, informe o suporte.");
            }
        }
    }
}












