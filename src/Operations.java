
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AsusPc
 */
public class Operations {
    //import edilecekler
    Connection con = null;
    Statement sta = null;
    PreparedStatement psta= null;
    
    
    //kitap sayma fonksiyonu
    public int bookCount(){
        int label = 0;
        String sorgu = "SELECT COUNT(*) FROM books_database";
        try {
            sta = con.createStatement();
            ResultSet rs = sta.executeQuery(sorgu);
            rs.next();
            label = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return label;
    }
    
    //kitap silme fonksiyonu
    public void bookDelete(int id){
        String sorgu = "DELETE FROM books_database WHERE id=?";
        try {
            psta= con.prepareStatement(sorgu);
            psta.setInt(1,id);
            psta.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void talepDelete(int id){
        String sorgu = "DELETE FROM talepler WHERE id=?";
        try {
            psta= con.prepareStatement(sorgu);
            psta.setInt(1, id);
            psta.executeUpdate();
          
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    //kitap düzenleme fonksiyonu
    public void bookUpdate(int id, String new_name, String new_writer, String new_type, String new_publisher){
        String sorgu = "UPDATE books_database SET book_name=?, book_writer=?,book_type=?,book_publisher=? WHERE id=?";
        
        try {
            psta = con.prepareStatement(sorgu);
            psta.setString(1, new_name);
            psta.setString(2, new_writer);
            psta.setString(3, new_type);
            psta.setString(4, new_publisher);
            psta.setInt(5, id);
            psta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
           
       
    }
    
    //odunc alma-verme fonksiyonu 
    public void oduncAlVer(int id, String oduncte){
        String sorgu = "UPDATE books_database SET oduncte=? WHERE id=?";
        try{
            psta = con.prepareStatement(sorgu);
            psta.setString(1, oduncte);
            psta.setInt(2, id);
            psta.executeUpdate();
        
        }catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    //kitap ekleme fonksiyonu
    public void bookAdd(String name, String writer, String type, String publisher,String oduncte){
        String sorgu = "INSERT INTO books_database(book_name, book_writer, book_type, book_publisher, oduncte) VALUES (?,?,?,?,?)";
        try {
            psta = con.prepareStatement(sorgu);
            psta.setString(1,name);
            psta.setString(2,writer);
            psta.setString(3,type);
            psta.setString(4,publisher);
            psta.setString(5, oduncte);
            psta.executeUpdate();
            
                    
                    } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    //talep ekleme fonksiyonu, studenttalepler
    public void requestAdd(String ogr_no, String name, String writer, String publisher){
        String sorgu = "INSERT INTO talepler(ogr_no,book_name, book_writer, book_publisher) VALUES (?,?,?,?)";
        try {
            psta = con.prepareStatement(sorgu);
            psta.setString(1,ogr_no);
            psta.setString(2,name);
            psta.setString(3,writer);
            psta.setString(4,publisher);
            psta.executeUpdate();
            
                    
                    } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }    

    //veritabanından kitap listesini çağırma fonksiyonu
    public ArrayList<Book> bookCome(){
        ArrayList<Book> list = new ArrayList<Book>();
        String sorgu = "Select * from books_database" ;
        try {
            sta = con.createStatement();
            ResultSet rs = sta.executeQuery(sorgu);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String book_name =rs.getString("book_name");
                String book_writer = rs.getString("book_writer");
                String book_type = rs.getString("book_type");
                String book_publisher = rs.getString("book_publisher");
                String oduncte = rs.getString("oduncte");
                list.add(new Book(id, book_name, book_writer, book_type, book_publisher, oduncte));
            }return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    //veritabanından talep listesini çağırma fonksiyonu
     public ArrayList<DemandedBook> bookReqCome(){
        ArrayList<DemandedBook> reqlist = new ArrayList<DemandedBook>();
        String sorgu = "Select * from talepler" ;
        try {
            sta = con.createStatement();
            ResultSet rs = sta.executeQuery(sorgu);
            
            while(rs.next()){
                
                String ogr_no = rs.getString("ogr_no");
                int id = rs.getInt("id");
                String book_name =rs.getString("book_name");
                String book_writer = rs.getString("book_writer");
                String book_publisher = rs.getString("book_publisher");
                reqlist.add(new DemandedBook( ogr_no, id, book_name, book_writer, book_publisher));
            }return reqlist;
            
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
   
    //login fonksiyonu, veritabanı admin bilgisi alır
    public boolean Login(String id, String password){
        String sorgu = "Select * from admin where id= ? and password= ?";
       
        try {
            psta = con.prepareStatement(sorgu);
            psta.setString(1,id);
            psta.setString(2, password);
            ResultSet rs= psta.executeQuery();
            return rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
     
    }
  
    
    //login fonksiyonu, veritabanı öğrenci bilgisi alır
    public boolean Login1(String id, String password){
        String sorgu = "Select * from ogrenci where id= ? and password= ?";
       
        try {
            psta = con.prepareStatement(sorgu);
            psta.setString(1,id);
            psta.setString(2, password);
            ResultSet rs= psta.executeQuery();
            return rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
     
    }
    
    //veritabanını bağlama
    public Operations() {
        String url = "jdbc:mysql://"+Database.host+":"+Database.port+"/"+Database.db_name+"?useUnicode=True&characterEncoding=UTF-8";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,Database.id,Database.password);
            System.out.println("Veritabanına bağlanıldı. ");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Driver çalışmadı :/");
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection çalışmadı :/");
        }
        
        
    }
    
    //main fonksiyonu
    public static void main(String[] args) {
        Operations op = new Operations();
    }
    
}
