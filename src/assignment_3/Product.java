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
abstract class Product {
    private String pID;
    private String name;
    private String price;
    private String year;
    
    Product(String id, String day, String n, String p) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(day.length() != 4)
        {
            throw new Exception("ERROR: wrong date length");
        }
        else if(id.equals(""))
        {
            throw new Exception ("ERROR: no id entered");
        }
        else if(p.contains("-"))
        {
            throw new Exception("ERROR: wrong price input");
        }
        this.pID = id;
        this.name = n;
        this.year = day;
        this.price = p;
    }
    public void setID(String id)
    {
        this.pID = id;
    }
    public void setName(String n)
    {
        this.name = n;
    }
    public void setPrice(String p)
    {
        this.price = p;
    }
    public void setYear(String day)
    {
        this.year = day;
    }
    
    public String getpID()
    {
        return pID;
    }
    public String getName()
    {
        return name;
    }
    public String getPrice()
    {
        return price;
    }
    public String getYear()
    {
        return year;
    }
    
    public String type()
    {
        return " ";
    }
    public String dataDump(/*String year, String brand, String price, String model*/)
    {
        return ("productID = \""+this.pID+"\"\r\nname = \""+ this.name+"\"\r\nprice = \""+ this.price +"\"\r\nyear = \""+ this.year+"\"");
    }
    
    public String dataDump2()
    {
        return "";
    }
}
