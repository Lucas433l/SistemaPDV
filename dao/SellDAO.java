package dao;

import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Sell;

/**
 *
 * @author lucas
 */
public class SellDAO {
    public void insert(Sell sell){
        String sql = "INSERT INTO sell(bar_code, name, quantity, price, id_coupon) VALUES (?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            pstm.setLong(1, sell.getBarCode());
            pstm.setString(2, sell.getName());
            pstm.setFloat(3, sell.getQuantity());
            pstm.setFloat(4, sell.getPrice());
            pstm.setLong(5, sell.getIdCoupon());
            
            pstm.execute();
        }catch(Exception e){
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
    
    public void delete(Long barCode, Long idCoupon){
        String sql = "DELETE FROM sell WHERE bar_code = ? AND id_coupon = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            pstm.setLong(1, barCode);
            pstm.setLong(2, idCoupon);
            
            pstm.execute();
        }catch(Exception e){
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
    
    public List<Sell> selectAll(Long idCoupon){
        String sql = "SELECT * FROM sell WHERE id_coupon = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        List<Sell> sales = new ArrayList<>();
        
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            pstm.setLong(1, idCoupon);
            
            rset = pstm.executeQuery();
            
            while(rset.next()){
                Sell sell = new Sell();
                
                sell.setBarCode(rset.getLong("bar_code"));
                sell.setIdCoupon(rset.getLong("id_coupon"));
                sell.setName(rset.getString("name"));
                sell.setPrice(rset.getFloat("price"));
                sell.setQuantity(rset.getFloat("quantity"));
                
                sales.add(sell);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado, informe o suporte.");
        }finally{
            try{
                if(rset != null){
                    rset.close();
                }
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
        return sales;
    }
}
