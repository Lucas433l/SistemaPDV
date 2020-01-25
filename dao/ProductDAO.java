package dao;

import Connection.ConnectionFactory;
import java.sql.PreparedStatement;
import model.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
    
    public void update(Product product){
        String sql = "UPDATE product SET name = ?, stock = ?, price = ? WHERE bar_code = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, product.getName());
            pstm.setFloat(2, product.getStock());
            pstm.setFloat(3, product.getPrice());
            pstm.setLong(4, product.getBarCode());
            
            pstm.execute();
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
    
    public void delete(Long barCode){
        String sql = "DELETE FROM product WHERE bar_code = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            pstm.setLong(1, barCode);
            
            pstm.execute();
            JOptionPane.showMessageDialog(null,"Produto deletado com sucesso.");
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
    
    public List<Product> selectAll(){
        String sql = "SELECT * FROM product";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        List<Product> products = new ArrayList<>();
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            
            while(rset.next()){
                Product product = new Product();
                product.setBarCode(rset.getLong("bar_code"));
                product.setName(rset.getString("name"));
                product.setPrice(rset.getFloat("price"));
                product.setStock(rset.getFloat("stock"));
                
                products.add(product);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocorreu algum erro, informe o suporte.");
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
                JOptionPane.showMessageDialog(null,"Ocorreu algum erro, informe o suporte.");
            }
        }
        return products;
    }
    
    public List<Product> selectForBarCode(String barCode){
        String sql = "SELECT * FROM product WHERE bar_code LIKE ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        List<Product> products = new ArrayList<>();
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, "%"+barCode+"%");
            
            rset = pstm.executeQuery();
            
            while(rset.next()){
                Product product = new Product();
                product.setBarCode(rset.getLong("bar_code"));
                product.setName(rset.getString("name"));
                product.setPrice(rset.getFloat("price"));
                product.setStock(rset.getFloat("stock"));
                
                products.add(product);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocorreu algum erro, informe o suporte.");
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
                JOptionPane.showMessageDialog(null,"Ocorreu algum erro, informe o suporte.");
            }
        }
        return products;
    }
    
    public List<Product> selectForName(String name){
        String sql = "SELECT * FROM product WHERE name LIKE ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        List<Product> products = new ArrayList<>();
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, "%"+name+"%");
            
            rset = pstm.executeQuery();
            
            while(rset.next()){
                Product product = new Product();
                product.setBarCode(rset.getLong("bar_code"));
                product.setName(rset.getString("name"));
                product.setPrice(rset.getFloat("price"));
                product.setStock(rset.getFloat("stock"));
                
                products.add(product);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocorreu algum erro, informe o suporte.");
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
                JOptionPane.showMessageDialog(null,"Ocorreu algum erro, informe o suporte.");
            }
        }
        return products;
    }
    
    public Product selectUniqueBarCode(Long barCode){
        String sql = "SELECT * FROM product WHERE bar_code = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Product product = new Product();
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setLong(1, barCode);

            rset = pstm.executeQuery();

            while(rset.next()){
                product.setBarCode(rset.getLong("bar_code"));
                product.setName(rset.getString("name"));
                product.setPrice(rset.getFloat("price"));
                product.setStock(rset.getFloat("stock"));
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
                JOptionPane.showMessageDialog(null,"Ocorreu algum erro, informe o suporte.");
            }
        }
        return product;
    }
}












