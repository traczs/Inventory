/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_3;

/**
 *
 * @author Sam
 */
public class Book extends Product{
    private String author;
    private String publisher;
    
    public Book(String id, String day, String n, String p, String a, String pub) throws Exception {
        super(id, day, n, p);
        this.publisher = pub;
        this.author = a;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }
    
    public String getAuthor()
    {
        return author;
    }
    public String getPublisher()
    {
        return publisher;
    }
    
    @Override
    public String dataDump2()
    {
        return ("\r\nAuthor = \""+ this.author + "\"\r\nPublisher = \""+this.publisher+"\"\r\n");
       
    }
    
    @Override
    public String type()
    {
        return "type = \"book\"\r\n";
    }
}
