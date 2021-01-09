
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AsusPc
 */
public class DemandedBook {
    private String ogr_no;
    private String book_name;
    private String book_writer;
    private String book_publisher;
    private int id;
    
    
    
    public DemandedBook(String ogr_no,int id, String book_name,String book_writer,String book_publisher){
        this.ogr_no = ogr_no;
        this.id = id;
        this.book_name = book_name;
        this.book_writer = book_writer;
        this.book_publisher = book_publisher;
    }
    
   
    
    public String getOgr_no(){
        return ogr_no;
    }
    
    public void setOgr_no(String ogr_no){
        this.ogr_no = ogr_no;
    }
    
      public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_writer() {
        return book_writer;
    }

    public void setBook_writer(String book_writer) {
        this.book_writer = book_writer;
    }
    
     public String getBook_publisher() {
        return book_publisher;
    }

    public void setBook_publisher(String book_publisher) {
        this.book_publisher = book_publisher;
    }
    
}
