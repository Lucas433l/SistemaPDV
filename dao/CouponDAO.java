package dao;

import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Coupon;

/**
 *
 * @author lucas
 */
public class CouponDAO {
    public Long insert(){
        String sql = "INSERT INTO coupon() VALUES ()";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Long idCoupon = null;
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.execute();
            
            sql = "SELECT LAST_INSERT_ID()";
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            
            while(rset.next()){
                idCoupon = rset.getLong(1);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocorreu algum erro, informe o suporte.");
            e.printStackTrace();
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
                JOptionPane.showMessageDialog(null,"Ocorreu algum erro,informe o suporte.");
            }
        }
        return idCoupon;
    }
    
    public void update(Coupon coupon){
        String sql = "UPDATE coupon SET date_hour=?,price=? WHERE id_coupon = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, coupon.getDateHour());
            pstm.setFloat(2, coupon.getPrice());
            pstm.setLong(3, coupon.getIdCoupon());
            
            pstm.execute();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocorreu algum erro, informe o suporte.");
            e.printStackTrace();
            
        }finally{
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Ocorreu algum erro,informe o suporte.");
                e.printStackTrace();
            }
        }
    }
}
