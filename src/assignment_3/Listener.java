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
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Listener implements ActionListener {
    public void actionPerformed(ActionEvent e){
        String s = (String) GUI.productList.getSelectedItem();
        /*the add action taken from last assignment*/
        if(e.getActionCommand().equals("Add"))
        {
            GUI.dump.setText("");
            GUI.bigPanel.remove(GUI.welcomePanel);
            GUI.bigPanel.remove(GUI.searchPanel);
            GUI.bigPanel.remove(GUI.right2Panel);
            GUI.bigPanel.add(GUI.addProduct,BorderLayout.WEST);
            GUI.bigPanel.add(GUI.bottomPanel,BorderLayout.SOUTH);
            GUI.bigPanel.add(GUI.rightPanel,BorderLayout.EAST);
            /*I don't understand why none of these would not fix the problem I'm having*/
            GUI.addProduct.setVisible(true);
            GUI.bottomPanel.setVisible(true);
            GUI.bigPanel.setVisible(true);
            GUI.bigPanel.repaint();
            GUI.addProduct.repaint();
            GUI.bigPanel.isDisplayable();
            GUI.bigPanel.revalidate();
        }
        else if(e.getActionCommand().equals("add"))
        {
            int idValid= 1;//int for checking if the id exists
                    
         
            /*case when user chooses book*/
            if(s.equalsIgnoreCase("Book"))
            {
               //*checking if product id is correct*/
               EStoreSearch.id = GUI.idField.getText();
               if(EStoreSearch.id.matches("[0-9]+") && EStoreSearch.id.length()==6)
               {
                   if(EStoreSearch.product.isEmpty() == false)
                    {
                        for(int j =0; j< EStoreSearch.product.size(); j++)
                        {
                            if(EStoreSearch.product.get(j).getpID().equals(EStoreSearch.id))
                            {
                                GUI.dump.setText("Product id already exists.");
                                //System.out.println("Product id already exists.");
                                idValid = 0;
                                //break;
                                return;
                            }
                            else
                            {
                                idValid = 1;
                            }
                        }
                    }


                   /*if the id does not already exist, continue to check for year*/
                   if(idValid == 1)
                   {
                        //*checking if year is valid*/
                        EStoreSearch.day = GUI.yearField.getText();
                        /*checks if the year is within range of 1000-9999*/
                        if(EStoreSearch.day.length()==4)
                        {
                            if(EStoreSearch.day.charAt(0)=='1'||EStoreSearch.day.charAt(0)=='2'||EStoreSearch.day.charAt(0)=='3'||EStoreSearch.day.charAt(0)=='4'||EStoreSearch.day.charAt(0)=='5'||EStoreSearch.day.charAt(0)=='6'||EStoreSearch.day.charAt(0)=='7'||EStoreSearch.day.charAt(0)=='8'||EStoreSearch.day.charAt(0)=='9')
                            {
                                if(EStoreSearch.day.charAt(1)=='0'||EStoreSearch.day.charAt(1)=='1'||EStoreSearch.day.charAt(1)=='2'||EStoreSearch.day.charAt(1)=='3'||EStoreSearch.day.charAt(1)=='4'||EStoreSearch.day.charAt(1)=='5'||EStoreSearch.day.charAt(1)=='6'||EStoreSearch.day.charAt(1)=='7'||EStoreSearch.day.charAt(1)=='8'||EStoreSearch.day.charAt(1)=='9')
                                {
                                    if(EStoreSearch.day.charAt(2)=='0'||EStoreSearch.day.charAt(2)=='1'||EStoreSearch.day.charAt(2)=='2'||EStoreSearch.day.charAt(2)=='3'||EStoreSearch.day.charAt(2)=='4'||EStoreSearch.day.charAt(2)=='5'||EStoreSearch.day.charAt(2)=='6'||EStoreSearch.day.charAt(2)=='7'||EStoreSearch.day.charAt(2)=='8'||EStoreSearch.day.charAt(2)=='9')
                                    {
                                        if(EStoreSearch.day.charAt(3)=='0'||EStoreSearch.day.charAt(3)=='1'||EStoreSearch.day.charAt(3)=='2'||EStoreSearch.day.charAt(3)=='3'||EStoreSearch.day.charAt(3)=='4'||EStoreSearch.day.charAt(3)=='5'||EStoreSearch.day.charAt(3)=='6'||EStoreSearch.day.charAt(3)=='7'||EStoreSearch.day.charAt(3)=='8'||EStoreSearch.day.charAt(3)=='9')
                                        {
                                            //*checking if name is correct*/
                                            EStoreSearch.n = GUI.nameField.getText();
                                            if(EStoreSearch.n.equals(""))
                                            {
                                                GUI.dump.setText("Requires a name.");
                                                //System.out.println("Requires a name.");
                                                return;
                                            }
                                            else
                                            {
                                                //*prompting for price*/
                                                EStoreSearch.p = GUI.priceField.getText();
                                                if(EStoreSearch.p.matches("[0-9]+") || EStoreSearch.p.equals(""))
                                                {
                                                    //*prompting for author*/
                                                    EStoreSearch.a = GUI.nameField.getText();
                                                    EStoreSearch.pub = GUI.pubField.getText();
                                                    try{
                                                        EStoreSearch.product.add(new Book(EStoreSearch.id,EStoreSearch.day,EStoreSearch.n,EStoreSearch.p,EStoreSearch.a,EStoreSearch.pub));
                                                        //temp.add(new Temp(id,day,n,p,a,pub,null));//////////////////////////////////////////////////////////////////////////////////////////////
                                                        EStoreSearch.turn ++;
                                                        GUI.dump.setText("Add Successful");
                                                    }catch(Exception ee){
                                                        GUI.dump.setText(ee.getMessage());
                                                    }
                                                    return;

                                                }
                                                else
                                                {
                                                    GUI.dump.setText("Please enter numbers only");
                                                    //System.out.println("Please enter numbers only.");
                                                    return;
                                                }
                                            }

                                        } 
                                        else
                                        {
                                            GUI.dump.setText("Wrong year was entered.");
                                            //System.out.println("Wrong year was entered.");
                                            return;
                                        }
                                    } 
                                    else
                                    {
                                        GUI.dump.setText("Wrong year was entered.");
                                        //System.out.println("Wrong year was entered.");
                                        return;
                                    }
                                } 
                                else
                                {
                                    GUI.dump.setText("Wrong year was enterd.");
                                    //System.out.println("Wrong year was entered.");
                                    return;
                                }
                            } 
                            else
                            {
                                GUI.dump.setText("Wrong year was entered.");
                                //System.out.println("Wrong year was entered.");
                                return;
                            }
                        }
                        else
                        {
                            GUI.dump.setText("Wrong date length");
                            //System.out.println("Wrong date length");
                            return;
                        }
                    }

                }
                else
                {
                    GUI.dump.setText("Something other than numbers was entered or length was wrong");
                    //System.out.println("Something other than numbers was entered or lenght was wrong.");
                    return;
                }
            }
            /*case when user enters an electronic device*/
            else if(s.equalsIgnoreCase("Electronics"))
            {
               //*checking if product id is correct*/
               EStoreSearch.id = GUI.idField.getText();
               if(EStoreSearch.id.matches("[0-9]+") && EStoreSearch.id.length()==6)
               {
                        if(EStoreSearch.product.isEmpty() == false)
                        {
                            for(int j =0; j< EStoreSearch.product.size(); j++)
                            {
                                if(EStoreSearch.product.get(j).getpID().equals(EStoreSearch.id))
                                {
                                    GUI.dump.setText("Product id already exists.");
                                    //System.out.println("Product id already exists.");
                                    idValid = 0;
                                    //break;
                                    return;
                                }
                                else
                                {
                                    idValid = 1;
                                }
                            }
                        }
                   if(idValid == 1)
                   {
                        //*checking if year is valid*/
                        EStoreSearch.day = GUI.yearField.getText();
                        if(EStoreSearch.day.length()==4)
                        {
                            if(EStoreSearch.day.charAt(0)=='1'||EStoreSearch.day.charAt(0)=='2'||EStoreSearch.day.charAt(0)=='3'||EStoreSearch.day.charAt(0)=='4'||EStoreSearch.day.charAt(0)=='5'||EStoreSearch.day.charAt(0)=='6'||EStoreSearch.day.charAt(0)=='7'||EStoreSearch.day.charAt(0)=='8'||EStoreSearch.day.charAt(0)=='9')
                            {
                                if(EStoreSearch.day.charAt(1)=='0'||EStoreSearch.day.charAt(1)=='1'||EStoreSearch.day.charAt(1)=='2'||EStoreSearch.day.charAt(1)=='3'||EStoreSearch.day.charAt(1)=='4'||EStoreSearch.day.charAt(1)=='5'||EStoreSearch.day.charAt(1)=='6'||EStoreSearch.day.charAt(1)=='7'||EStoreSearch.day.charAt(1)=='8'||EStoreSearch.day.charAt(1)=='9')
                                {
                                    if(EStoreSearch.day.charAt(2)=='0'||EStoreSearch.day.charAt(2)=='1'||EStoreSearch.day.charAt(2)=='2'||EStoreSearch.day.charAt(2)=='3'||EStoreSearch.day.charAt(2)=='4'||EStoreSearch.day.charAt(2)=='5'||EStoreSearch.day.charAt(2)=='6'||EStoreSearch.day.charAt(2)=='7'||EStoreSearch.day.charAt(2)=='8'||EStoreSearch.day.charAt(2)=='9')
                                    {
                                        if(EStoreSearch.day.charAt(1)=='0'||EStoreSearch.day.charAt(1)=='1'||EStoreSearch.day.charAt(1)=='2'||EStoreSearch.day.charAt(1)=='3'||EStoreSearch.day.charAt(1)=='4'||EStoreSearch.day.charAt(1)=='5'||EStoreSearch.day.charAt(1)=='6'||EStoreSearch.day.charAt(1)=='7'||EStoreSearch.day.charAt(1)=='8'||EStoreSearch.day.charAt(1)=='9')
                                        {
                                            //*checking if name is correct*/
                                            EStoreSearch.n = GUI.nameField.getText();
                                            if(EStoreSearch.n.equals(""))
                                            {
                                                GUI.dump.setText("Requires a name.");
                                                //System.out.println("Requires a name.");
                                                return;
                                            }
                                            else
                                            {
                                                //*prompting for price*/
                                                EStoreSearch.p = GUI.priceField.getText();
                                                if(EStoreSearch.p.matches("[0-9]+") || EStoreSearch.p.equals(""))
                                                {
                                                    //*prompting for make*/
                                                    EStoreSearch.m = GUI.makerField.getText();
                                                    try{
                                                        EStoreSearch.product.add(new Electronics(EStoreSearch.id,EStoreSearch.day,EStoreSearch.n,EStoreSearch.p,EStoreSearch.m));
                                                        //temp.add(new Temp(id,day,n,p,null,null,m));/////////////////////////////////////////////////////////////
                                                        EStoreSearch.turn ++;
                                                        GUI.dump.setText("Add Successful");
                                                    }catch(Exception ee){
                                                        GUI.dump.setText(ee.getMessage());
                                                    }
                                                    return;

                                                }
                                                else
                                                {
                                                    GUI.dump.setText("Please enter numbers only.");
                                                    //System.out.println("Please enter numbers only.");
                                                    return;
                                                }
                                            }

                                        } 
                                        else
                                        {
                                            GUI.dump.setText("Wrong year was entered.");
                                            //System.out.println("Wrong year was entered.");
                                            return;
                                        }
                                    } 
                                    else
                                    {
                                        GUI.dump.setText("Wrong year was entered.");
                                        //System.out.println("Wrong year was entered.");
                                        return;
                                    }
                                } 
                                else
                                {
                                    GUI.dump.setText("Wrong year was entered.");
                                    //System.out.println("Wrong year was entered.");
                                    return;
                                }
                            } 
                            else
                            {
                                GUI.dump.setText("Wrong year was entered.");
                                //System.out.println("Wrong year was entered.");
                                return;
                            }
                        }
                        else
                        {
                            GUI.dump.setText("Wrong date length.");
                            //System.out.println("Wrong date length");
                            return;
                        }
                    }

                }
                else
                {
                    GUI.dump.setText("Something other than numbers was entered or length was wrong.");
                    //System.out.println("Something other than numbers was entered or lenght was wrong.");
                    return;
                }
            }
            else
            {
                GUI.dump.setText("Wrong input");
                //System.out.println("Wrong input");
                return;
            }
        }
        
        if(s.equals("Electronics"))
        {
            GUI.bigPanel.remove(GUI.welcomePanel);
            GUI.bigPanel.add(GUI.addProduct,BorderLayout.WEST);
            GUI.bigPanel.add(GUI.bottomPanel,BorderLayout.SOUTH);
            GUI.addProduct.setVisible(true);
            GUI.bottomPanel.setVisible(true);            
            GUI.bigPanel.repaint();
            GUI.bigPanel.revalidate();
            GUI.bigPanel.isDisplayable();
            GUI.addProduct.remove(GUI.authorField);
            GUI.addProduct.remove(GUI.pubField);
            GUI.addProduct.add(GUI.makerField);
            GUI.addProduct.repaint();
            
        }
        if(s.equals("Book"))
        {
            GUI.bigPanel.remove(GUI.welcomePanel);
            GUI.bigPanel.add(GUI.addProduct,BorderLayout.WEST);
            GUI.bigPanel.add(GUI.bottomPanel,BorderLayout.SOUTH);
            GUI.addProduct.setVisible(true);
            GUI.bottomPanel.setVisible(true);            
            GUI.bigPanel.repaint();
            GUI.bigPanel.revalidate();
            GUI.bigPanel.isDisplayable();
            GUI.addProduct.remove(GUI.makerField);
            GUI.addProduct.add(GUI.authorField);
            GUI.addProduct.add(GUI.pubField);
            GUI.addProduct.repaint();
        }
        
        if(e.getActionCommand().equals("Search"))
        {
            GUI.dump.setText("");
            GUI.bigPanel.remove(GUI.welcomePanel);
            GUI.bigPanel.remove(GUI.addProduct);
            GUI.bigPanel.remove(GUI.rightPanel);
            GUI.bigPanel.add(GUI.searchPanel,BorderLayout.WEST);
            GUI.bigPanel.add(GUI.bottomPanel,BorderLayout.SOUTH);
            GUI.bigPanel.add(GUI.right2Panel,BorderLayout.EAST);
            /*I don't understand why none of these would not fix the problem I'm having*/
            GUI.addProduct.setVisible(true);
            GUI.bottomPanel.setVisible(true);            
            GUI.bigPanel.repaint();
            GUI.bigPanel.revalidate();
            GUI.bigPanel.isDisplayable();
            
        }
        
        /* the garbage search action from last assignment that I'm scared to change*/
        if(e.getActionCommand().equals("search"))
        {
            GUI.dump.setText("");
            EStoreSearch.id = GUI.idsearchField.getText();
            EStoreSearch.day = GUI.year1Field.getText()+"-"+GUI.year2Field.getText();
            EStoreSearch.n = GUI.keywordField.getText();
            
            /*printing if user only enters id*/
            if(EStoreSearch.day.equals("-") && EStoreSearch.n.equals("") && !EStoreSearch.id.equals(""))
            {
                if(EStoreSearch.id.matches("[0-9]+") && EStoreSearch.id.length()==6)
                {
                    if(EStoreSearch.turn != 0)
                    {
                        for(int j = 0; j<EStoreSearch.product.size();j++)
                        {
                            if(EStoreSearch.product.get(j).getpID().equals(EStoreSearch.id))
                            {
                                GUI.dump.setText(GUI.dump.getText()+"\nPRODUCT");
                                GUI.dump.setText(GUI.dump.getText()+"\n"+EStoreSearch.product.get(j).dataDump() + EStoreSearch.product.get(j).dataDump2());
                                //System.out.println("PRODUCT");
                                //System.out.println(EStoreSearch.product.get(j).dataDump() + EStoreSearch.product.get(j).dataDump2());
                            }
                        }
                        return;
                    }
                }
                else if(EStoreSearch.id.equals(""))
                {
                    System.out.println("Left intentionally blank");
                }
                else
                {
                    GUI.dump.setText("does not exist");
                    //System.out.println("does not exist");
                }
            }
            /*if year is the only thing entered*/
            else if(EStoreSearch.id.equals("") && EStoreSearch.n.equals("") && !EStoreSearch.day.equals("-"))
            {
                String subStr;
                String subStr2;
                int sub1;
                int sub2;
                int sub3;
                if(EStoreSearch.day.length()==5)
                {
                    if(EStoreSearch.day.charAt(0)=='-')
                    {
                        subStr = EStoreSearch.day.substring(1);
                        if(subStr.matches("[0-9]+"))
                        {
                            sub1 = Integer.parseInt(subStr);
                            for(int q = 0; q<EStoreSearch.product.size();q++)
                            {
                                sub2 = Integer.parseInt(EStoreSearch.product.get(q).getYear());
                                if(sub2<sub1)
                                {
                                    GUI.dump.setText(GUI.dump.getText()+"\n"+"PRODUCT");
                                    GUI.dump.setText(GUI.dump.getText()+"\n"+EStoreSearch.product.get(q).dataDump() + EStoreSearch.product.get(q).dataDump2());
                                    //System.out.println("PRODUCT");
                                    //System.out.println(EStoreSearch.product.get(q).dataDump() + EStoreSearch.product.get(q).dataDump2());
                                }
                            }
                            return;
                        }
                    }
                    else if(EStoreSearch.day.charAt(4)=='-')
                    {
                        String[] parts = EStoreSearch.day.split("[-]+");
                        subStr = parts[0];
                        if(subStr.matches("[0-9]+"))
                        {
                            sub1 = Integer.parseInt(subStr);
                            for(int q = 0; q<EStoreSearch.product.size();q++)
                            {
                                sub2 = Integer.parseInt(EStoreSearch.product.get(q).getYear());
                                if(sub2>sub1)
                                {
                                    GUI.dump.setText(GUI.dump.getText()+"\n"+"PRODUCT");
                                    GUI.dump.setText(GUI.dump.getText()+"\n"+EStoreSearch.product.get(q).dataDump() + EStoreSearch.product.get(q).dataDump2());
                                    //System.out.println("PRODUCT");
                                    //System.out.println(EStoreSearch.product.get(q).dataDump() + EStoreSearch.product.get(q).dataDump2());
                                }
                            }
                            return;
                        }
                    }
                    else
                    {
                        GUI.dump.setText("Wrong Format");
                        //System.out.println("Wrong format");
                        return;
                    }
                }
                else if(EStoreSearch.day.length()==9)
                {
                    System.out.println("day"+ EStoreSearch.day);
                    String[] parts = EStoreSearch.day.split("[-]+");
                    subStr = parts[0];
                    subStr2 = parts[1];
                    if(subStr.matches("[0-9]+") && subStr2.matches("[0-9]+"))
                    {
                        sub1 = Integer.parseInt(subStr);
                        sub2 = Integer.parseInt(subStr2);
                        for(int q = 0; q<EStoreSearch.product.size();q++)
                        {
                            sub3 = Integer.parseInt(EStoreSearch.product.get(q).getYear());
                            if(sub3>=sub1 && sub3<=sub2)
                            {
                                GUI.dump.setText(GUI.dump.getText()+"\n"+"PRODUCT");
                                GUI.dump.setText(GUI.dump.getText()+"\n"+EStoreSearch.product.get(q).dataDump() + EStoreSearch.product.get(q).dataDump2());
                                //System.out.println("PRODUCT");
                                //System.out.println(EStoreSearch.product.get(q).dataDump() + EStoreSearch.product.get(q).dataDump2());
                            }
                        }
                        return;
                    }
                    else
                    {
                        GUI.dump.setText("Wrong format./Does not exist.");
                        //System.out.println("Wrong format./Does not exist.");
                        return;
                    }
                }
                else if(EStoreSearch.day.length()==4 && EStoreSearch.day.matches("[0-9]+"))
                {
                    sub1 = Integer.parseInt(EStoreSearch.day);
                    for(int q = 0; q<EStoreSearch.product.size();q++)
                    {
                        sub2 = Integer.parseInt(EStoreSearch.product.get(q).getYear());
                        if(sub2==sub1)
                        {
                            GUI.dump.setText(GUI.dump.getText()+"\n"+"PRODUCT");
                            GUI.dump.setText(GUI.dump.getText()+"\n"+EStoreSearch.product.get(q).dataDump() + EStoreSearch.product.get(q).dataDump2());
                            //System.out.println("PRODUCT");
                            //System.out.println(EStoreSearch.product.get(q).dataDump() + EStoreSearch.product.get(q).dataDump2());
                        }
                    }
                }
                else if(EStoreSearch.day.equals("-"))
                {
                    System.out.println("Left intentionally blank");
                }
            }
            /*if name is left blank*/
            else if(EStoreSearch.n.equals("") && !EStoreSearch.id.equals("") && !EStoreSearch.day.equals("-"))
            {
                if(EStoreSearch.id.matches("[0-9]+") && EStoreSearch.id.length()==6)
                {
                    if(EStoreSearch.turn != 0)
                    {
                        for(int j = 0; j<EStoreSearch.product.size();j++)
                        {
                            if(EStoreSearch.product.get(j).getpID().equals(EStoreSearch.id) && EStoreSearch.product.get(j).getYear().equals(EStoreSearch.day))
                            {
                                String subStr;
                                String subStr2;
                                int sub1;
                                int sub2;
                                int sub3;
                                if(EStoreSearch.day.length()==5)
                                {
                                    if(EStoreSearch.day.charAt(0)=='-')
                                    {
                                        subStr = EStoreSearch.day.substring(1);
                                        if(subStr.matches("[0-9]+"))
                                        {
                                            sub1 = Integer.parseInt(subStr);
                                            for(int q = 0; q<EStoreSearch.product.size();q++)
                                            {
                                                sub2 = Integer.parseInt(EStoreSearch.product.get(q).getYear());
                                                if(sub2<sub1)
                                                {
                                                    GUI.dump.setText(GUI.dump.getText()+"\n"+"PRODUCT");
                                                    GUI.dump.setText(GUI.dump.getText()+"\n"+EStoreSearch.product.get(q).dataDump() + EStoreSearch.product.get(q).dataDump2());
                                                    //System.out.println("PRODUCT");
                                                    //System.out.println(EStoreSearch.product.get(q).dataDump() + EStoreSearch.product.get(q).dataDump2());
                                                }
                                            }
                                            return;
                                        }
                                    }
                                    else if(EStoreSearch.day.charAt(4)=='-')
                                    {
                                        String[] parts = EStoreSearch.day.split("[-]+");
                                        subStr = parts[0];
                                        if(subStr.matches("[0-9]+"))
                                        {
                                            sub1 = Integer.parseInt(subStr);
                                            for(int q = 0; q<EStoreSearch.product.size();q++)
                                            {
                                                sub2 = Integer.parseInt(EStoreSearch.product.get(q).getYear());
                                                if(sub2>sub1)
                                                {
                                                    GUI.dump.setText(GUI.dump.getText()+"\n"+"PRODUCT");
                                                    GUI.dump.setText(GUI.dump.getText()+"\n"+EStoreSearch.product.get(q).dataDump() + EStoreSearch.product.get(q).dataDump2());
                                                    //System.out.println("PRODUCT");
                                                    //System.out.println(EStoreSearch.product.get(q).dataDump() + EStoreSearch.product.get(q).dataDump2());
                                                }
                                            }
                                            return;
                                        }
                                    }
                                    else
                                    {
                                        GUI.dump.setText("Wrong format");
                                        //System.out.println("Wrong format");
                                        return;
                                    }
                                }
                                else if(EStoreSearch.day.length()==9)
                                {
                                    String[] parts = EStoreSearch.day.split("[-]+");
                                    subStr = parts[0];
                                    subStr2 = parts[1];
                                    if(subStr.matches("[0-9]+") && subStr2.matches("[0-9]+"))
                                    {
                                        sub1 = Integer.parseInt(subStr);
                                        sub2 = Integer.parseInt(subStr2);
                                        for(int q = 0; q<EStoreSearch.product.size();q++)
                                        {
                                            sub3 = Integer.parseInt(EStoreSearch.product.get(q).getYear());
                                            if(sub3>=sub1 && sub3<=sub2)
                                            {
                                                GUI.dump.setText(GUI.dump.getText()+"\n"+"PRODUCT");
                                                GUI.dump.setText(GUI.dump.getText()+"\n"+EStoreSearch.product.get(q).dataDump() + EStoreSearch.product.get(q).dataDump2());
                                                //System.out.println("PRODUCT");
                                                //System.out.println(EStoreSearch.product.get(q).dataDump() + EStoreSearch.product.get(q).dataDump2());
                                            }
                                        }
                                        return;
                                    }
                                    else
                                    {
                                        GUI.dump.setText("Wrong format./Does not exist.");
                                        //System.out.println("Wrong format./Does not exist.");
                                        return;
                                    }
                                }
                                else if(EStoreSearch.day.length()==4 && EStoreSearch.day.matches("[0-9]+"))
                                {
                                    sub1 = Integer.parseInt(EStoreSearch.day);
                                    for(int q = 0; q<EStoreSearch.product.size();q++)
                                    {
                                        sub2 = Integer.parseInt(EStoreSearch.product.get(q).getYear());
                                        if(sub2==sub1)
                                        {
                                            GUI.dump.setText(GUI.dump.getText()+"\n"+"PRODUCT");
                                            GUI.dump.setText(GUI.dump.getText()+"\n"+EStoreSearch.product.get(q).dataDump() + EStoreSearch.product.get(q).dataDump2());
                                            //System.out.println("PRODUCT");
                                            //System.out.println(EStoreSearch.product.get(q).dataDump() + EStoreSearch.product.get(q).dataDump2());
                                        }
                                    }
                                }
                                else if(EStoreSearch.day.equals("-"))
                                {
                                    System.out.println("Left intentionally blank");
                                }
                            }
                        }
                        return;
                    }
                }
            }
            /*if name is the only thing entered*/
            else if(!EStoreSearch.n.equals("") && EStoreSearch.id.equals("") && EStoreSearch.day.equals("-"))
            {
                EStoreSearch.n = EStoreSearch.n.toLowerCase();
                String[] token = EStoreSearch.n.split("[ ]+");

                ArrayList<Integer> temp = new ArrayList<>();
                ArrayList<Integer> temp2 = new ArrayList<>();

                if(EStoreSearch.map.containsKey(token[0]))
                {
                    temp = new ArrayList<>(EStoreSearch.map.get(token[0]));
                }
                else
                {
                    GUI.dump.setText("Not Found");
                    //System.out.println("Not Found");
                }
                if(token.length>1)
                {
                    for(int v =1; v<token.length;v++)
                    {
                        if(EStoreSearch.map.containsKey(token[v]))
                        {
                            temp2 = new ArrayList<>(EStoreSearch.map.get(token[v]));
                            temp.retainAll(temp2);
                        }
                        else
                        {
                            GUI.dump.setText("Not Found");
                            //System.out.println("NOT Found");
                        }
                    }
                }
                for(int a:temp)
                {
                    GUI.dump.setText(GUI.dump.getText()+"\n"+"PRODUCT");
                    GUI.dump.setText(GUI.dump.getText()+"\n"+EStoreSearch.product.get(a).dataDump() + EStoreSearch.product.get(a).dataDump2());
                    //System.out.println("PRODUCT");
                    //System.out.println(EStoreSearch.product.get(a).dataDump() + EStoreSearch.product.get(a).dataDump2());
                }
            }
            /*if year is left blank*/
            else if(!EStoreSearch.n.equals("") && !EStoreSearch.id.equals("") && EStoreSearch.day.equals("-"))
            {
                EStoreSearch.n = EStoreSearch.n.toLowerCase();
                String[] token = EStoreSearch.n.split("[ ]+");

                ArrayList<Integer> temp = new ArrayList<>();
                ArrayList<Integer> temp2 = new ArrayList<>();

                if(EStoreSearch.map.containsKey(token[0]))
                {
                    temp = new ArrayList<>(EStoreSearch.map.get(token[0]));
                }
                else
                {
                    GUI.dump.setText("Not Found");
                    //System.out.println("Not Found");
                }
                if(token.length>1)
                {
                    for(int v =1; v<token.length;v++)
                    {
                        if(EStoreSearch.map.containsKey(token[v]))
                        {
                            temp2 = new ArrayList<>(EStoreSearch.map.get(token[v]));
                            temp.retainAll(temp2);
                        }
                        else
                        {
                            GUI.dump.setText("Not Found");
                            //System.out.println("NOT Found");
                        }
                    }
                }
                for(int a:temp)
                {
                    if(EStoreSearch.id.matches("[0-9]+") && EStoreSearch.id.length()==6)
                    {
                        if(EStoreSearch.product.get(a).getpID().equals(EStoreSearch.id))
                        {
                            GUI.dump.setText(GUI.dump.getText()+"\n"+"PRODUCT");
                            GUI.dump.setText(GUI.dump.getText()+"\n"+EStoreSearch.product.get(a).dataDump() + EStoreSearch.product.get(a).dataDump2());
                            //System.out.println("PRODUCT");
                            //System.out.println(EStoreSearch.product.get(a).dataDump() + EStoreSearch.product.get(a).dataDump2());
                        }
                    }
                    else if(EStoreSearch.id.equals(""))
                    {
                        System.out.println("Left intentionally blank");
                    }
                    else
                    {
                        GUI.dump.setText("does not exist");
                        //System.out.println("does not exist");
                    }
                }
            }
            else if(!EStoreSearch.n.equals("") && EStoreSearch.id.equals("") && !EStoreSearch.day.equals("-"))
            {
                EStoreSearch.n = EStoreSearch.n.toLowerCase();
                String[] token = EStoreSearch.n.split("[ ]+");

                ArrayList<Integer> temp = new ArrayList<>();
                ArrayList<Integer> temp2 = new ArrayList<>();

                if(EStoreSearch.map.containsKey(token[0]))
                {
                    temp = new ArrayList<>(EStoreSearch.map.get(token[0]));
                }
                else
                {
                    GUI.dump.setText("Not Found");
                    //System.out.println("Not Found");
                }
                if(token.length>1)
                {
                    for(int v =1; v<token.length;v++)
                    {
                        if(EStoreSearch.map.containsKey(token[v]))
                        {
                            temp2 = new ArrayList<>(EStoreSearch.map.get(token[v]));
                            temp.retainAll(temp2);
                        }
                        else
                        {
                            GUI.dump.setText("Not found");
                            //System.out.println("NOT Found");
                        }
                    }
                }
                for(int a:temp)
                {
                    String subStr;
                    String subStr2;
                    int sub1;
                    int sub2;
                    int sub3;
                    if(EStoreSearch.day.length()==5)
                    {
                        if(EStoreSearch.day.charAt(0)=='-')
                        {
                            subStr = EStoreSearch.day.substring(1);
                            if(subStr.matches("[0-9]+"))
                            {
                                sub1 = Integer.parseInt(subStr);
                                sub2 = Integer.parseInt(EStoreSearch.product.get(a).getYear());
                                    if(sub2<sub1)
                                    {
                                        GUI.dump.setText(GUI.dump.getText()+"\n"+"PRODUCT");
                                        GUI.dump.setText(GUI.dump.getText()+"\n"+EStoreSearch.product.get(a).dataDump() + EStoreSearch.product.get(a).dataDump2());
                                        //System.out.println("PRODUCT");
                                        //System.out.println(EStoreSearch.product.get(a).dataDump() + EStoreSearch.product.get(a).dataDump2());
                                    }
                            }
                        }
                        else if(EStoreSearch.day.charAt(4)=='-')
                        {
                            String[] parts = EStoreSearch.day.split("[-]+");
                            subStr = parts[0];
                            if(subStr.matches("[0-9]+"))
                            {
                                sub1 = Integer.parseInt(subStr);
                                sub2 = Integer.parseInt(EStoreSearch.product.get(a).getYear());
                                if(sub2>sub1)
                                {
                                    GUI.dump.setText(GUI.dump.getText()+"\n"+"PRODUCT");
                                    GUI.dump.setText(GUI.dump.getText()+"\n"+EStoreSearch.product.get(a).dataDump() + EStoreSearch.product.get(a).dataDump2());
                                    //System.out.println("PRODUCT");
                                    //System.out.println(EStoreSearch.product.get(a).dataDump() + EStoreSearch.product.get(a).dataDump2());
                                }
                            }
                        }
                        else
                        {
                            GUI.dump.setText("Wrong format");
                            //System.out.println("Wrong format");
                            return;
                        }
                    }
                    else if(EStoreSearch.day.length()==9)
                    {
                        System.out.println("day"+ EStoreSearch.day);
                        String[] parts = EStoreSearch.day.split("[-]+");
                        subStr = parts[0];
                        subStr2 = parts[1];
                        if(subStr.matches("[0-9]+") && subStr2.matches("[0-9]+"))
                        {
                            sub1 = Integer.parseInt(subStr);
                            sub2 = Integer.parseInt(subStr2);
                            sub3 = Integer.parseInt(EStoreSearch.product.get(a).getYear());
                            if(sub3>=sub1 && sub3<=sub2)
                            {
                                GUI.dump.setText(GUI.dump.getText()+"\n"+"PRODUCT");
                                GUI.dump.setText(GUI.dump.getText()+"\n"+EStoreSearch.product.get(a).dataDump() + EStoreSearch.product.get(a).dataDump2());
                                //System.out.println("PRODUCT");
                                //System.out.println(EStoreSearch.product.get(a).dataDump() + EStoreSearch.product.get(a).dataDump2());
                            }
                        }
                        else
                        {
                            GUI.dump.setText("Wrong format./Does not exist.");
                            //System.out.println("Wrong format./Does not exist.");
                            return;
                        }
                    }
                    else if(EStoreSearch.day.length()==4 && EStoreSearch.day.matches("[0-9]+"))
                    {
                        sub1 = Integer.parseInt(EStoreSearch.day);
                        sub2 = Integer.parseInt(EStoreSearch.product.get(a).getYear());
                        if(sub2==sub1)
                        {
                            GUI.dump.setText(GUI.dump.getText()+"\n"+"PRODUCT");
                            GUI.dump.setText(GUI.dump.getText()+"\n"+EStoreSearch.product.get(a).dataDump() + EStoreSearch.product.get(a).dataDump2());
                            //System.out.println("PRODUCT");
                            //System.out.println(EStoreSearch.product.get(a).dataDump() + EStoreSearch.product.get(a).dataDump2());
                        }

                    }
                    else if(EStoreSearch.day.equals("-"))
                    {
                        System.out.println("Left intentionally blank");
                    }
                }
            }
            else if(!EStoreSearch.n.equals("") && !EStoreSearch.id.equals("") && !EStoreSearch.day.equals("-"))
            {
                EStoreSearch.n = EStoreSearch.n.toLowerCase();
                String[] token = EStoreSearch.n.split("[ ]+");

                ArrayList<Integer> temp = new ArrayList<>();
                ArrayList<Integer> temp2 = new ArrayList<>();

                if(EStoreSearch.map.containsKey(token[0]))
                {
                    temp = new ArrayList<>(EStoreSearch.map.get(token[0]));
                }
                else
                {
                    GUI.dump.setText("Not found");
                    //System.out.println("Not Found");
                }
                if(token.length>1)
                {
                    System.out.println("PRODUCT SIZE"+EStoreSearch.product.size());
                    for(int v =1; v<token.length;v++)
                    {
                        if(EStoreSearch.map.containsKey(token[v]))
                        {
                            temp2 = new ArrayList<>(EStoreSearch.map.get(token[v]));
                            temp.retainAll(temp2);
                        }
                        else
                        {
                            GUI.dump.setText("Not Found");
                            //System.out.println("NOT Found");
                        }
                    }
                }
                for(int a:temp)
                {
                    String subStr;
                    String subStr2;
                    int sub1;
                    int sub2;
                    int sub3;
                    if(EStoreSearch.day.length()==5 && EStoreSearch.product.get(a).getpID().equals(EStoreSearch.id))
                    {
                        if(EStoreSearch.day.charAt(0)=='-')
                        {
                            subStr = EStoreSearch.day.substring(1);
                            if(subStr.matches("[0-9]+"))
                            {
                                sub1 = Integer.parseInt(subStr);
                                sub2 = Integer.parseInt(EStoreSearch.product.get(a).getYear());
                                if(sub2<sub1)
                                {
                                    GUI.dump.setText(GUI.dump.getText()+"\n"+"PRODUCT");
                                    GUI.dump.setText(GUI.dump.getText()+"\n"+EStoreSearch.product.get(a).dataDump() + EStoreSearch.product.get(a).dataDump2());
                                    //System.out.println("PRODUCT");
                                    //System.out.println(EStoreSearch.product.get(a).dataDump() + EStoreSearch.product.get(a).dataDump2());
                                }
                            }
                        }
                        else if(EStoreSearch.day.charAt(4)=='-')
                        {
                            String[] parts = EStoreSearch.day.split("[-]+");
                            subStr = parts[0];
                            if(subStr.matches("[0-9]+"))
                            {
                                sub1 = Integer.parseInt(subStr);
                                sub2 = Integer.parseInt(EStoreSearch.product.get(a).getYear());
                                if(sub2>sub1)
                                {
                                    GUI.dump.setText(GUI.dump.getText()+"\n"+"PRODUCT");
                                    GUI.dump.setText(GUI.dump.getText()+"\n"+EStoreSearch.product.get(a).dataDump() + EStoreSearch.product.get(a).dataDump2());
                                    //System.out.println("PRODUCT");
                                    //System.out.println(EStoreSearch.product.get(a).dataDump() + EStoreSearch.product.get(a).dataDump2());
                                }
                            }
                        }
                        else
                        {
                            GUI.dump.setText("Wrong format");
                            System.out.println("Wrong format");
                            return;
                        }
                    }
                    else if(EStoreSearch.day.length()==9 && EStoreSearch.product.get(a).getpID().equals(EStoreSearch.id))
                    {
                        System.out.println("day"+ EStoreSearch.day);
                        String[] parts = EStoreSearch.day.split("[-]+");
                        subStr = parts[0];
                        subStr2 = parts[1];
                        if(subStr.matches("[0-9]+") && subStr2.matches("[0-9]+"))
                        {
                            sub1 = Integer.parseInt(subStr);
                            sub2 = Integer.parseInt(subStr2);
                            sub3 = Integer.parseInt(EStoreSearch.product.get(a).getYear());
                            if(sub3>=sub1 && sub3<=sub2)
                            {
                                GUI.dump.setText(GUI.dump.getText()+"\n"+"PRODUCT");
                                GUI.dump.setText(GUI.dump.getText()+"\n"+EStoreSearch.product.get(a).dataDump() + EStoreSearch.product.get(a).dataDump2());
                                //System.out.println("PRODUCT");
                                //System.out.println(EStoreSearch.product.get(a).dataDump() + EStoreSearch.product.get(a).dataDump2());
                            }
                        }
                        else
                        {
                            System.out.println("Wrong format./Does not exist.");
                            return;
                        }
                    }
                    else if(EStoreSearch.day.length()==4 && EStoreSearch.day.matches("[0-9]+") && EStoreSearch.product.get(a).getpID().equals(EStoreSearch.id))
                    {
                        sub1 = Integer.parseInt(EStoreSearch.day);
                        sub2 = Integer.parseInt(EStoreSearch.product.get(a).getYear());
                        if(sub2==sub1)
                        {
                            GUI.dump.setText(GUI.dump.getText()+"\n"+"PRODUCT");
                            GUI.dump.setText(GUI.dump.getText()+"\n"+EStoreSearch.product.get(a).dataDump() + EStoreSearch.product.get(a).dataDump2());
                            //System.out.println("PRODUCT");
                            //System.out.println(EStoreSearch.product.get(a).dataDump() + EStoreSearch.product.get(a).dataDump2());
                        }

                    }
                    else if(EStoreSearch.day.equals("-"))
                    {
                        System.out.println("Left intentionally blank");
                    }
                }
            }
        }
        /*resets the page*/
        if(e.getActionCommand().equals("reset"))
        {
            GUI.idField.setText("");
            GUI.nameField.setText("");
            GUI.priceField.setText("");
            GUI.yearField.setText("");
            GUI.makerField.setText("");
            GUI.authorField.setText("");
            GUI.pubField.setText("");
            GUI.dump.setText("");

        }
        /*resets the page*/
        if(e.getActionCommand().equals("Reset"))
        {
            GUI.idsearchField.setText("");
            GUI.keywordField.setText("");
            GUI.year2Field.setText("");
            GUI.year1Field.setText("");
            GUI.dump.setText("");
        }
        /*saves everything into input.txt and closes program*/
        if(e.getActionCommand().equals("Quit"))
        {
            EStoreSearch.i = 0;
            PrintWriter outputStream = null;
            try {
                outputStream = new PrintWriter(new FileOutputStream("input.txt"));
            } catch (FileNotFoundException ee) {
                System.out.println("Error opening the file input.txt.");
                System.exit(0);
            }
            for(int k = 0;k<EStoreSearch.product.size();k++)
            {
                outputStream.println(EStoreSearch.product.get(k).type()+EStoreSearch.product.get(k).dataDump()+EStoreSearch.product.get(k).dataDump2());
            }
            outputStream.close();
            System.exit(0);
        }
    }
}
