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
public class Electronics extends Product{
    private String maker;

    public Electronics(String id, String day, String n, String p, String maker) throws Exception{
        super(id, day, n, p);
        this.maker = maker;
    }
    public void setMaker(String maker)
    {
        this.maker = maker;
    }
    
    @Override
    public String dataDump2()
    {
        return ("\r\nMaker = \""+this.maker+"\"\r\n");
       
    }
    
    @Override
    public String type()
    {
        return "type = \"electronics\"\r\n";
    }
}
