/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Sam
 */
public class EStoreSearch {

    
    public static ArrayList<Product> product = new ArrayList<>();
    //ArrayList<Integer> value = new ArrayList<>();
    public static HashMap<String,ArrayList<Integer>> map = new HashMap();
    public static int i = 1;
    public static int turn = 0;
    public static String input;

    public static String t = "";
    public static String id = "";
    public static String day = "";
    public static String n = "";
    public static String p = "";
    public static String a = "";
    public static String pub = "";
    public static String m = "";
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner number = new Scanner(System.in);
        Scanner type = new Scanner(System.in);
        Scanner pId = new Scanner(System.in);
        Scanner called = new Scanner(System.in);
        Scanner money = new Scanner(System.in);
        Scanner date = new Scanner(System.in);
        Scanner make = new Scanner(System.in);
        Scanner person = new Scanner(System.in);
        Scanner publish = new Scanner(System.in);
        String fileName = args[0];
        
        if(args.length ==1)
        {
            System.out.println("FILE: "+fileName);
        }
        else
        {
            System.out.println("Wrong number of arguments in the command line");
            System.exit(0);
        }

        
      
        try{
            File f = new File(fileName);
            Scanner scanner = new Scanner(new FileInputStream(fileName));
            int counter = 0;
            /* parsing file and adding all valid things to arraylist*/
            while(scanner.hasNextLine()) {
                
                String line = scanner.nextLine();
                
                if(!line.equals(""))
                {
                    /*tokenizes string based on lines in the file*/
                    if(counter == 0)
                    {
                        String[] parts1 = line.split("[\"]+");
                        counter ++;
                        /*adds everything relevant to the string*/
                        for(int qwop =0;qwop< parts1.length - 1;qwop++)
                        {
                            if(qwop==0)
                            {
                                t = parts1[qwop+1];
                            }
                            else
                            {
                                System.out.println("Too many arguments in type");
                            }
                        }
                    }
                    else if(counter == 1)
                    {
                        String[] parts2 = line.split("[\"]+");
                        counter++;
                        for(int qwop =0;qwop< parts2.length - 1;qwop++)
                        {
                            if(qwop==0)
                            {
                                id = parts2[qwop+1];
                            }
                            else
                            {
                                System.out.println("Too many arguments in type");
                            }
                        }
                    }
                    else if(counter == 2)
                    {
                        String[] parts3 = line.split("[\"]+");
                        
                        counter++;
                        for(int qwop =0;qwop< parts3.length - 1;qwop++)
                        {
                            if(qwop==0)
                            {
                                n = parts3[qwop+1];
                            }
                            else if(qwop>=1)
                            {
                                /*appends the substrings to one big string because i tokenize it by quotations, so I add the quotation back if it's part of the string*/
                                /*not sure what the difference between .concat and .append is, but I found .concat online first and it works so I'm scared to switch*/
                                n = n.concat("\"");
                                n = n.concat(parts3[qwop+1]);
                            }
                        }
                        String[] splitname = n.split("[ ]+");
                        for(int asd = 0;asd<splitname.length;asd++)
                        {
                            map.putIfAbsent(splitname[asd].toLowerCase(), new ArrayList<Integer>());
                            map.get(splitname[asd].toLowerCase()).add(product.size());
                        }
                        
                    }
                    else if(counter ==3)
                    {
                        String[] parts4 = line.split("[\"]+");
                        counter++;
                        for(int qwop =0;qwop< parts4.length - 1;qwop++)
                        {
                            if(qwop==0)
                            {
                                p = parts4[qwop+1];
                            }
                            else
                            {
                                System.out.println("Too many arguments in type");
                            }
                        }
                    }
                    else if(counter == 4)
                    {
                        String[] parts5 = line.split("[\"]+");
                        counter++;
                        for(int qwop =0;qwop< parts5.length - 1;qwop++)
                        {
                            if(qwop==0)
                            {
                                day = parts5[qwop+1];
                            }
                            else
                            {
                                System.out.println("Too many arguments in type");
                            }
                        }
                    }
                    else if(counter == 5)
                    {
                        String[] parts6 = line.split("[\"]+");
                        counter++;
                        if(parts6[0].contains("author"))
                        {
                            for(int qwop =0;qwop< parts6.length - 1;qwop++)
                            {
                                if(qwop==0)
                                {
                                    a = parts6[qwop+1];
                                }
                                else if(qwop>=1)
                                {
                                    a = a.concat("\"");
                                    a = a.concat(parts6[qwop+1]);
                                }
                            }
                        }
                        else if(parts6[0].contains("maker"))
                        {
                            for(int qwop =0;qwop< parts6.length - 1;qwop++)
                            {
                                if(qwop==0)
                                {
                                    m = parts6[qwop+1];
                                }
                                else if(qwop>=1)
                                {
                                    m = m.concat("\"");
                                    m = m.concat(parts6[qwop+1]);
                                }
                            }
                        }
                    }
                    else if(counter == 6)
                    {
                        String[] parts7 = line.split("[\"]+");
                        for(int qwop =0;qwop< parts7.length - 1;qwop++)
                            {
                                if(qwop==0)
                                {
                                    pub = parts7[qwop+1];
                                }
                                else if(qwop>=1)
                                {
                                    pub = pub.concat("\"");
                                    pub = pub.concat(parts7[qwop+1]);
                                }
                            }
                    }
                }
                else
                {
                    /* The prof said there is no need for error checking for this part so I just did this*/
                    if(t.matches("book"))
                    {
                        product.add(new Book(id,day,n,p,a,pub));
                        turn++;
                    }
                    else if(t.matches("electronics"))
                    {
                        product.add(new Electronics(id,day,n,p,m));
                        turn++;
                    }
                    counter = 0;
                }
            }
        }catch (FileNotFoundException e) 
        {
            System.out.println("Error opening the file input.txt.");
            System.exit(0);
        }catch(Exception e) {
            System.out.println("Could not open file.");
            System.exit(0);
        }
        try{
            GUI win = new GUI();
            win.setVisible(true);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
        
    }
    
}
