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
import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame{
    public static JPanel bigPanel = new JPanel();
    public static JPanel bottomPanel = new JPanel();
    public static JPanel welcomePanel = new JPanel(); 
    public static JPanel addProduct = new JPanel();
    public static JPanel bookPanel = new JPanel();
    public static JPanel rightPanel = new JPanel();
    public static JPanel searchPanel = new JPanel();
    public static JPanel right2Panel = new JPanel();
    private static JMenuBar menuBar;
    private static JMenu commandMenu;
    private static JMenuItem addItem, searchItem, quitItem;
    public static JTextField idField, nameField, priceField, yearField, makerField,authorField,pubField,idsearchField,keywordField,year1Field,year2Field;//////////
    private static TextPrompt idPrompt, namePrompt,pricePrompt,yearPrompt,makerPrompt,authorPrompt,pubPrompt, idsearchPrompt,keywordPrompt,year1Prompt,year2Prompt; //////////
    public static JLabel welcome; 
    public static JTextArea dump = new JTextArea(10,60);
    public static JComboBox productList;
    public static JButton add, reset ,add2, search;
    
    protected GUI()throws Exception{
        super("EStoreSearch");
        Listener ear = new Listener();
        
        /*welcome screen text*/
        GUI.welcome = new JLabel("<html><span style='font-size:18px'>WELCOME to eStore <br> Choose a command from the \"Command\" menu above for <br> adding a product,searching products or quitting the program</span></html>");
        /*settiing up the gui*/
        setSize(750,500);
        //setTitle("eStore Search");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        bigPanel.setLayout(new BorderLayout());         
        
        /*welcome panel creation*/              
        welcomePanel.setBackground(Color.pink);
        welcomePanel.setLayout(new FlowLayout());
        bigPanel.add(welcomePanel);
        welcomePanel.setVisible(true);
        welcomePanel.add(welcome);
        add(bigPanel,BorderLayout.CENTER);
        
        /*messages panel creation*/
        JScrollPane scrolledText = new JScrollPane(dump);
        scrolledText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrolledText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        bottomPanel.add(scrolledText);
        
        /*menuBar creation*/	        
	//MenuBar
        menuBar = new JMenuBar();
        //Create the Menu Options
        commandMenu = new JMenu("Command");
        //Add them to the Menu Bar
        menuBar.add(commandMenu);
        //Give each Menu Option a dropdown list
        addItem = new JMenuItem("Add");
        searchItem = new JMenuItem("Search");
        quitItem = new JMenuItem("Quit");
        //Adds it to the menu
        commandMenu.add(addItem);
        commandMenu.add(searchItem);
        commandMenu.add(quitItem);
        addItem.addActionListener(ear);
        searchItem.addActionListener(ear);
        quitItem.addActionListener(ear);
        menuBar.setVisible(true);
        setJMenuBar(menuBar);
        
        //addproduct panel is for electronics        
        addProduct.setLayout(new BoxLayout(addProduct ,BoxLayout.Y_AXIS));
        addProduct.setBackground(Color.yellow);
        
        //add book panel
        bookPanel.setLayout(new BoxLayout(bookPanel ,BoxLayout.Y_AXIS));
        
        //comboBox creation
        String[] productString = {"Book","Electronics"};
        productList = new JComboBox(productString);
        
        productList.setSelectedIndex(1);
        productList.addActionListener(ear);
        productList.setMaximumSize(new Dimension(200,25));
        addProduct.add(productList);      
        
        //rest of panel
        idField = new JTextField(20);
	idPrompt = new TextPrompt("ProductID", idField);
        idPrompt.changeAlpha(0.7f);	
	idField.setMargin(new Insets(2, 2, 2, 2));
        nameField = new JTextField(20);
        namePrompt = new TextPrompt("Name", nameField);
        namePrompt.changeAlpha(0.7f);	
	nameField.setMargin(new Insets(2, 2, 2, 2));
        priceField = new JTextField(20);
        pricePrompt = new TextPrompt("Price", priceField);
        pricePrompt.changeAlpha(0.7f);	
	priceField.setMargin(new Insets(2, 2, 2, 2));
        yearField = new JTextField(20);
        yearPrompt = new TextPrompt("Year", yearField);
        yearPrompt.changeAlpha(0.7f);	
	yearField.setMargin(new Insets(2, 2, 2, 2));
        makerField = new JTextField(20);
        makerPrompt = new TextPrompt("Maker", makerField);
        makerPrompt.changeAlpha(0.7f);	
	makerField.setMargin(new Insets(2, 2, 2, 2));
        authorField = new JTextField(20);
	authorPrompt = new TextPrompt("Author", authorField);
        authorPrompt.changeAlpha(0.7f);	
	authorField.setMargin(new Insets(2, 2, 2, 2));
        pubField = new JTextField(20);
	pubPrompt = new TextPrompt("Publisher", pubField);
        pubPrompt.changeAlpha(0.7f);	
	pubField.setMargin(new Insets(2, 2, 2, 2));
        idField.setMaximumSize(new Dimension(200,25));
        nameField.setMaximumSize(new Dimension(200,25));
        priceField.setMaximumSize(new Dimension(200,25));
        yearField.setMaximumSize(new Dimension(200,25));
        makerField.setMaximumSize(new Dimension(200,25));
        authorField.setMaximumSize(new Dimension(200,25));
        pubField.setMaximumSize(new Dimension(200,25));
        addProduct.add(idField);
        addProduct.add(nameField);
        addProduct.add(priceField);
        addProduct.add(yearField);
        addProduct.add(makerField);
        addProduct.add(authorField);
        addProduct.add(pubField);
        
        /*right panel creation*/
        add = new JButton("add");
        reset = new JButton("reset");
        add.addActionListener(ear);
        reset.addActionListener(ear);
        rightPanel.add(add);
        rightPanel.add(reset);
        
        /*search panel creation*/
        searchPanel.setLayout(new BoxLayout(searchPanel ,BoxLayout.Y_AXIS));
        idsearchField = new JTextField(20);
	idsearchPrompt = new TextPrompt("ProductID", idsearchField);
        idsearchPrompt.changeAlpha(0.7f);	
	idsearchField.setMargin(new Insets(2, 2, 2, 2));
        idsearchField.setMaximumSize(new Dimension(200,25));
        searchPanel.add(idsearchField);
        keywordField = new JTextField(20);
	keywordPrompt = new TextPrompt("Search Keywords", keywordField);
        keywordPrompt.changeAlpha(0.7f);	
	keywordField.setMargin(new Insets(2, 2, 2, 2));
        keywordField.setMaximumSize(new Dimension(200,25));
        searchPanel.add(keywordField);
        year1Field = new JTextField(20);
	year1Prompt = new TextPrompt("Start Year", year1Field);
        year1Prompt.changeAlpha(0.7f);	
	year1Field.setMargin(new Insets(2, 2, 2, 2));
        year1Field.setMaximumSize(new Dimension(200,25));
        searchPanel.add(year1Field);
        year2Field = new JTextField(20);
	year2Prompt = new TextPrompt("End Year", year2Field);
        year2Prompt.changeAlpha(0.7f);	
	year2Field.setMargin(new Insets(2, 2, 2, 2));
        year2Field.setMaximumSize(new Dimension(200,25));
        searchPanel.add(year2Field);
        
        /*search button and reset button*/
        add2 = new JButton("search");
        search = new JButton("Reset");
        add2.addActionListener(ear);
        search.addActionListener(ear);
        right2Panel.add(add2);
        right2Panel.add(search);
        
    }
    
}

