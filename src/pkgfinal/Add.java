package pkgfinal;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import static pkgfinal.Admin_Frame.addframe;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import static pkgfinal.Admin_Frame.checker;
import static pkgfinal.Payment_Record.modellist;


public class Add implements ActionListener{


    Border blackline = BorderFactory.createBevelBorder(BevelBorder.RAISED);   
    
    static ArrayList<Student> studentlist;
    
    static JTable tb = new JTable();
    JTableHeader theader;
    static String col[]={"Last Name"," First Name","Middle Name","Grade level","Age","Gender","Citizenship","Strand","Section","Student No.","Status","Account"};
    static String name[][] = new String [0][4];
    static DefaultTableModel model = new DefaultTableModel(name,col) ;
    static String status[]={"Student"}, acct="Accessible", kurso, citizen, Sec, hello, hi;;
    Font font = new Font("",1,16);
    JScrollPane pane = new JScrollPane(tb);
    JButton  save, exit, clear, up, authentication, ref, bt_pay, bt_cancel, drop, s, to12, p;
    JFrame auth, CASH, MONTHLY;
    JLabel label, last, first, mid, yr, crs, st, gulang, kasarian, lahi, sec, addBG, 
            stat, un, pw, backgroundAUTH, mode, lb_cash, lb_note, background;
    JPanel bt_panel;
    static JTextField lname, fname, mname, genId, subj, age, txt_un, tx_cash, search;
    JPasswordField txt_pw;
    static JRadioButton rb, rb1, rb2, male, female, cash, monthly;
    static ButtonGroup bg, bg1, bg2;
    JComboBox cmb,cmb1, cmb2, stats;
    static int idRAND, i, change;
    Scanner sc = new Scanner(System.in);
    
    String id;
    
    public Add() {
       
            addframe = new JFrame(); 
           
            
            studentlist= new ArrayList<>();
            
            model.setColumnIdentifiers(col);
            theader = tb.getTableHeader();       //TABLE_HEADER
            theader.setFont(new Font("Dialog",Font.ITALIC, 14));
            theader.setBackground(new Color(0x226b2c));
            theader.setForeground(Color.white);
            tb.setModel(model);
            tb.setGridColor(Color.gray);
            tb.setBackground(new Color(204,204,204));
            tb.setForeground(Color.black);
            tb.setFont(new Font("",Font.CENTER_BASELINE, 16));
            tb.setRowHeight(25);
            
            
            pane.setBounds(60, 80, 1250, 260);
            addframe.add(pane);
            
            //BORDER------------------
            
            Border lower = BorderFactory.createLoweredSoftBevelBorder();
            
            
            //PANEL-------------------
            
            bt_panel = new JPanel();
            bt_panel.setBackground(new Color(153,255,153));
            bt_panel.setBounds(0, 690, 1500,80);
            bt_panel.setLayout(null);
            addframe.add(bt_panel);
            
            
            //LABEL---------------
            
            label= new JLabel("Enrollment");
            label.setFont(new Font("Serif",Font.PLAIN,40));
            label.setBounds(580,20,250,30);
            label.setForeground(Color.white);
            addframe.add(label);
            
            first= new JLabel("Student First Name:");
            first.setFont(new Font("Minion Variable Concept",Font.PLAIN,18));
            first.setBounds(553,370,200,30);
            first.setForeground(Color.WHITE);
            addframe.add(first);
            
            last= new JLabel("Student Last Name:");
            last.setFont(new Font("Minion Variable Concept",Font.PLAIN,18));
            last.setBounds(223,370,200,30);
            last.setForeground(Color.WHITE);
            addframe.add(last);
            
            mid= new JLabel("Student Middle Name:");
            mid.setFont(new Font("Minion Variable Concept",Font.PLAIN,18));
            mid.setBounds(873,370,200,30);
            mid.setForeground(Color.WHITE);
            addframe.add(mid);
            
            yr= new JLabel("Grade Level:");
            yr.setFont(new Font("Minion Variable Concept",Font.PLAIN,22));
            yr.setBounds(233,500,200,30);
            yr.setForeground(Color.WHITE);
            addframe.add(yr);
            
            crs= new JLabel("Strand:");
            crs.setFont(new Font("Minion Variable Concept",Font.PLAIN,22));
            crs.setBounds(553,500,100,60);
            crs.setForeground(Color.WHITE);
            addframe.add(crs);
            
            gulang= new JLabel("Age:");
            gulang.setFont(new Font("Minion Variable Concept",Font.PLAIN,22));
            gulang.setBounds(363,450,200,30);
            gulang.setForeground(Color.WHITE);
            addframe.add(gulang);
            
            kasarian= new JLabel("Gender:");
            kasarian.setFont(new Font("Minion Variable Concept",Font.PLAIN,22));
            kasarian.setBounds(553,450,200,30);
            kasarian.setForeground(Color.WHITE);
            addframe.add(kasarian); 
            
            lahi= new JLabel("Citizenship:");
            lahi.setFont(new Font("Minion Variable Concept",Font.PLAIN,22));
            lahi.setBounds(873,450,200,30);
            lahi.setForeground(Color.WHITE);
            addframe.add(lahi); 
            
            sec= new JLabel("Section:");
            sec.setFont(new Font("Minion Variable Concept",Font.PLAIN,22));
            sec.setBounds(873,500,100,60);
            sec.setForeground(Color.WHITE);
            addframe.add(sec); 
            
//            stat= new JLabel("Status:");
//            stat.setFont(new Font("Minion Variable Concept",Font.PLAIN,22));
//            stat.setBounds(490,575,100,30);
//            stat.setForeground(Color.WHITE);
//            addframe.add(stat); 
            
            mode= new JLabel("Payment:");
            mode.setFont(new Font("Minion Variable Concept",Font.PLAIN,22));
            mode.setBounds(570,575,100,30);
            mode.setForeground(Color.WHITE);
            addframe.add(mode); 
            
            
            
            //TEXTFIELD---------------
            
            search= new JTextField();
            search.setBounds(1100,20,150,30);
            addframe.add(search);
            
            lname= new JTextField();
            lname.setBounds(223,400,250,30);
            addframe.add(lname);
            
            fname = new JTextField();
            fname.setBounds(553,400,250,30);
            addframe.add(fname);
            
            mname = new JTextField();
            mname.setBounds(873,400,250,30);
            addframe.add(mname);
            
            age = new JTextField();
            age.setBounds(413,455,50,25);
            addframe.add(age);
            
            
            
            //RADIO BUTTON------------
            
            rb = new JRadioButton("Grade 11");
            rb.setFont(new Font("Serif",Font.PLAIN,20));
            rb.setForeground(Color.white);
            rb.setBounds(373,485,100,60);
            rb.setOpaque(false);
            addframe.add(rb);
            
            rb1 = new JRadioButton("Grade 12");
            rb1.setFont(new Font("Serif",Font.PLAIN,20));
            rb1.setForeground(Color.white);
            rb1.setBounds(373,515,100,60);
            rb1.setOpaque(false);
            addframe.add(rb1);
            
            bg = new ButtonGroup();
            bg.add(rb);
            bg.add(rb1);
            
            male= new JRadioButton("Male");
            male.setFont(new Font("Serif",Font.PLAIN,20));
            male.setForeground(Color.white);
            male.setBounds(653,435,100,60);
            male.setOpaque(false);
            addframe.add(male);
            
            female= new JRadioButton("Female");
            female.setFont(new Font("Serif",Font.PLAIN,20));
            female.setForeground(Color.white);
            female.setBounds(723,435,100,60);
            female.setOpaque(false);
            addframe.add(female);
            
            bg1 = new ButtonGroup();
            bg1.add(male);
            bg1.add(female);
            
            cash= new JRadioButton("Cash");
            cash.setFont(new Font("Serif",Font.PLAIN,20));
            cash.setForeground(Color.white);
            cash.setBounds(680,560,100,60);
            cash.setOpaque(false);
            addframe.add(cash);
            
            monthly= new JRadioButton("Monthly");
            monthly.setFont(new Font("Serif",Font.PLAIN,20));
            monthly.setForeground(Color.white);
            monthly.setBounds(680,590,100,60);
            monthly.setOpaque(false);
            addframe.add(monthly);
            
            bg2 = new ButtonGroup();
            bg2.add(cash);
            bg2.add(monthly);
            
            
            //COMBO BOX-----------
            
            String Course[]={"STEM","ABM","HUMSS","GAS"}; 
            cmb = new JComboBox(Course);
            cmb.setBounds(638,515,148,30);
            addframe.add(cmb);
            
            String citizen[]={"Filipino","Japanese","Korean","Chinese"}; 
            cmb1 = new JComboBox(citizen);
            cmb1.setBounds(993,450,130,30);
            addframe.add(cmb1);
            
            String Section[]={"1","2","3","4","5","6"}; 
            cmb2 = new JComboBox(Section);
            cmb2.setBounds(993,515,50,30);
            addframe.add(cmb2);
            
//            stats= new JComboBox(status);
//            stats.setBounds(570, 575, 80, 25);
//            stats.setEditable(false);
//            addframe.add(stats);
            
            
            
            //JBUTTON----------------
            ImageIcon sear = new ImageIcon("search.png");
            s= new JButton(sear);
            s.setFont(new Font("Minion Variable Concept",Font.PLAIN,15));
            s.setForeground(Color.white);
            s.setBorder(lower);
            s.setBounds(1250,20,30,30);
            s.setBackground(Color.white);
            s.setCursor(new Cursor(Cursor.HAND_CURSOR));
            addframe.add(s);
            s.addActionListener(this);
            
            save= new JButton("Proceed");
            save.setFont(new Font("Minion Variable Concept",Font.PLAIN,15));
            save.setForeground(Color.white);
            save.setBorder(lower);
            save.setBounds(413,20,100,30);
            save.setBackground(new Color(0x226b2c));
            save.setCursor(new Cursor(Cursor.HAND_CURSOR));
            bt_panel.add(save);
            save.addActionListener(this);
            
            up= new JButton("Update");
            up.setFont(new Font("Minion Variable Concept",Font.PLAIN,15));
            up.setForeground(Color.white);
            up.setBorder(lower);
            up.setBackground(new Color(0xeaa532));
            up.setBounds(550,20, 100,30);
            up.setCursor(new Cursor(Cursor.HAND_CURSOR));
            bt_panel.add(up);
            up.addActionListener(this);
            
            ref= new JButton("Refresh");
            ref.setFont(new Font("Minion Variable Concept",Font.PLAIN,15));
            ref.setBackground(new Color(0xea8032));
            ref.setForeground(Color.white);
            ref.setBorder(lower);
            ref.setBounds(693,20, 100,30);
            ref.setCursor(new Cursor(Cursor.HAND_CURSOR));
            bt_panel.add(ref);
            ref.addActionListener(this);
            
            drop= new JButton("Drop");
            drop.setFont(new Font("Minion Variable Concept",Font.PLAIN,15));
            drop.setForeground(Color.white);
            drop.setBorder(lower);
            drop.setBackground(new Color(0xeaa532));
            drop.setBounds(830, 20, 100,30);
            drop.setCursor(new Cursor(Cursor.HAND_CURSOR));
            bt_panel.add(drop);
            drop.addActionListener(this);
            
            clear= new JButton("Clear");
            clear.setFont(new Font("Minion Variable Concept",Font.PLAIN,15));
            clear.setForeground(Color.white);
            clear.setBorder(lower);
            clear.setBackground(new Color(0xeaa532));
            clear.setBounds(1150, 20, 80,30);
            clear.setCursor(new Cursor(Cursor.HAND_CURSOR));
            bt_panel.add(clear);
            clear.addActionListener(this);
            
            exit= new JButton("Cancel");
            exit.setFont(new Font("Minion Variable Concept",Font.PLAIN,15));
            exit.setForeground(Color.white);
            exit.setBorder(lower);
            exit.setBackground(new Color(0xea8032));
            exit.setBounds(1250, 20, 80,30);
            exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
            bt_panel.add(exit);
            exit.addActionListener(this);
            
            to12= new JButton("Grade 12 Enrollment");
            to12.setFont(new Font("Minion Variable Concept",Font.PLAIN,13));
            to12.setForeground(Color.white);
            to12.setBorder(lower);
            to12.setBackground(new Color(0xeaa532));
            to12.setBounds(10,20, 200,30);
            to12.setCursor(new Cursor(Cursor.HAND_CURSOR));
            bt_panel.add(to12);
            to12.addActionListener(this);
            
            p= new JButton("Print");
            p.setFont(new Font("Minion Variable Concept",Font.PLAIN,15));
            p.setForeground(Color.white);
            p.setBorder(lower);
            p.setBackground(new Color(0xeaa532));
            p.setBounds(20,600, 100,30);
            p.setCursor(new Cursor(Cursor.HAND_CURSOR));
            addframe.add(p);
            p.addActionListener(this);
            
            
            
            //ICON----------------
            
            ImageIcon addOP = new ImageIcon("addop.png");
            addBG = new JLabel();
            addBG.setVisible(true);
            addBG.setBounds(1040,395,300,300);
            addBG.setIcon(addOP);
            addframe.add(addBG);
            
            addframe.setLayout(null);
            addframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
            addframe.setUndecorated(true);
            addframe.setVisible(true);
            addframe.setBackground(new Color(0.0f,0.1f,0.0f,0.8f));
            
            
            
            //MOUSE CLICK------------------
        
            tb.addMouseListener(new MouseAdapter(){
                public void mouseClicked(java.awt.event.MouseEvent evt){
//                    if(!(search.getText().isEmpty())){
//                        String text = search.getText();
//        
//                        DefaultTableModel tbmodel = (DefaultTableModel) tb.getModel();
//                        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tbmodel);
//
//                        tb.setRowSorter(rowSorter);
//
//                        rowSorter.setRowFilter(RowFilter.regexFilter(text));
//                        
//                        int row = tb.getSelectedRow();
//                    
//                    String last= rowSorter.getModel().getValueAt(row, 0).toString();
//                    String first= tbmodel.getValueAt(row, 1).toString();
//                    String middle= tbmodel.getValueAt(row, 2).toString();
//                    String level= model.getValueAt(row, 3).toString();
//                    String Age= model.getValueAt(row, 4).toString();
//                    String GENDER= model.getValueAt(row, 5).toString();
//                    String CITIZEN= model.getValueAt(row, 6).toString();
//                    String STRAND= model.getValueAt(row, 7).toString();
//                    String SECTION= model.getValueAt(row, 8).toString();
//                    String STATS= model.getValueAt(row, 10).toString();
//                    int SECTION1= Integer.parseInt(SECTION);
                    
//                    save.setEnabled(false);
//                    
//                    if(level.equals("Grade 11")) {
//                        rb.setSelected(true);
//                    } 
//                    else{ 
//                        rb1.setSelected(true);
//                    }
//                    if(GENDER.equals("Male")) {
//                        male.setSelected(true);
//                    } 
//                    else{ 
//                        female.setSelected(true);
//                    }
//                    
//                    
//                    
//                    if(STRAND.equals("STEM")){
//                        cmb.setSelectedIndex(0);
//                    }
//                    else if(STRAND.equals("ABM")){
//                        cmb.setSelectedIndex(1);
//                    }
//                    else if(STRAND.equals("HUMSS")){
//                        cmb.setSelectedIndex(2);
//                    }
//                    else if(STRAND.equals("GAS")){
//                        cmb.setSelectedIndex(3);
//                    }
//                    
//                    
//                    
//                    if(CITIZEN.equals("Filipino")){
//                        cmb1.setSelectedIndex(0);
//                    }
//                    else if(CITIZEN.equals("Japanese")){
//                        cmb1.setSelectedIndex(1);
//                    }
//                    else if(CITIZEN.equals("Korean")){
//                        cmb1.setSelectedIndex(2);
//                    }
//                    else if(CITIZEN.equals("Chinese")){
//                        cmb1.setSelectedIndex(3);
//                    }
//                    
//                    
//                    
//                    if(SECTION1==1){
//                        cmb2.setSelectedIndex(0);
//                    }
//                    else if(SECTION1==2){
//                        cmb2.setSelectedIndex(1);
//                    }
//                    else if(SECTION1==3){
//                        cmb2.setSelectedIndex(2);
//                    }
//                    else if(SECTION1==4){
//                        cmb2.setSelectedIndex(3);
//                    }
//                    else if(SECTION1==5){
//                        cmb2.setSelectedIndex(4);
//                    }
//                    else if(SECTION1==6){
//                        cmb2.setSelectedIndex(5);
//                    }
//                    
//                    
//                    lname.setText(last);
//                    fname.setText(first);
//                    mname.setText(middle);
//                    age.setText(Age);
//                        
//                    }
//                    else{
                    int row = tb.getSelectedRow();
                    
                    String last= model.getValueAt(row, 0).toString();
                    String first= model.getValueAt(row, 1).toString();
                    String middle= model.getValueAt(row, 2).toString();
                    String level= model.getValueAt(row, 3).toString();
                    String Age= model.getValueAt(row, 4).toString();
                    String GENDER= model.getValueAt(row, 5).toString();
                    String CITIZEN= model.getValueAt(row, 6).toString();
                    String STRAND= model.getValueAt(row, 7).toString();
                    String SECTION= model.getValueAt(row, 8).toString();
                    String STATS= model.getValueAt(row, 10).toString();
                    int SECTION1= Integer.parseInt(SECTION);
                    
                    save.setEnabled(false);
                    
                    if(level.equals("Grade 11")) {
                        rb.setSelected(true);
                    } 
                    else{ 
                        rb1.setSelected(true);
                    }
                    if(GENDER.equals("Male")) {
                        male.setSelected(true);
                    } 
                    else{ 
                        female.setSelected(true);
                    }
                    
                    
                    
                    if(STRAND.equals("STEM")){
                        cmb.setSelectedIndex(0);
                    }
                    else if(STRAND.equals("ABM")){
                        cmb.setSelectedIndex(1);
                    }
                    else if(STRAND.equals("HUMSS")){
                        cmb.setSelectedIndex(2);
                    }
                    else if(STRAND.equals("GAS")){
                        cmb.setSelectedIndex(3);
                    }
                    
                    
                    
                    if(CITIZEN.equals("Filipino")){
                        cmb1.setSelectedIndex(0);
                    }
                    else if(CITIZEN.equals("Japanese")){
                        cmb1.setSelectedIndex(1);
                    }
                    else if(CITIZEN.equals("Korean")){
                        cmb1.setSelectedIndex(2);
                    }
                    else if(CITIZEN.equals("Chinese")){
                        cmb1.setSelectedIndex(3);
                    }
                    
                    
                    
                    if(SECTION1==1){
                        cmb2.setSelectedIndex(0);
                    }
                    else if(SECTION1==2){
                        cmb2.setSelectedIndex(1);
                    }
                    else if(SECTION1==3){
                        cmb2.setSelectedIndex(2);
                    }
                    else if(SECTION1==4){
                        cmb2.setSelectedIndex(3);
                    }
                    else if(SECTION1==5){
                        cmb2.setSelectedIndex(4);
                    }
                    else if(SECTION1==6){
                        cmb2.setSelectedIndex(5);
                    }
                    
                    
                    lname.setText(last);
                    fname.setText(first);
                    mname.setText(middle);
                    age.setText(Age);
                    }
//                }
        });
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
            if(e.getSource()==save){
                if(lname.getText().isEmpty()|| fname.getText().isEmpty()||mname.getText().isEmpty()||age.getText().isEmpty()||
                  !(rb.isSelected()==true || rb1.isSelected()==true)||!(male.isSelected()==true || female.isSelected()==true)||
                        !(cash.isSelected()==true || monthly.isSelected()==true)){
                    JOptionPane.showMessageDialog(null,"Please Complete All the Details");
                    
                }
                else if(cash.isSelected()==true){
                    String down= String.valueOf(6230);
                    int total =20300;
                    
                    CASH = new JFrame("Cash");

                    
                    
                    //label------------
                    lb_cash= new JLabel("CASH");
                    lb_cash.setFont(new Font("Serif",Font.PLAIN,40));
                    lb_cash.setBounds(100,20,200,50);
                    lb_cash.setForeground(Color.black);
                    CASH.add(lb_cash);

                    lb_note= new JLabel("Total Payment: 20,300");
                    lb_note.setFont(new Font("Serif",Font.PLAIN,20));
                    lb_note.setBounds(30,100,200,50);
                    lb_note.setForeground(Color.black);
                    CASH.add(lb_note);
                    
                    
                    //textfield
                    tx_cash= new JTextField();
                    tx_cash.setBounds(80,150,150,30);
                    CASH.add(tx_cash);
                    
                    
                    
                    bt_pay= new JButton("Pay");
                    bt_pay.setFont(new Font("Minion Variable Concept",Font.PLAIN,15));
                    bt_pay.setForeground(Color.black);
                    bt_pay.setBorder(blackline);
                    bt_pay.setBounds(170,220,100,30);
                    bt_pay.setBackground(new Color(255,204,102));
                    bt_pay.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    CASH.add(bt_pay);
                    
                    bt_pay.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                if(Integer.parseInt(tx_cash.getText())>=total){
                                    change=Math.abs(total-Integer.parseInt(tx_cash.getText()));
                                    JOptionPane.showMessageDialog(null, "Your change is: "+change);
                                    CASH.dispose();

                                    if(rb.isSelected()==true){
                                        hello=rb.getText();
                                        System.out.println(hello);
                                    }
                                    else if(rb1.isSelected()==true){
                                        hello=rb1.getText();
                                        System.out.println(hello);
                                    }
                                    if(male.isSelected()==true){
                                        hi=male.getText();
                                    }
                                    else if(female.isSelected()==true){
                                        hi=female.getText();
                                    }

                        //----------------------ComboBox--------------------------------------
                                    if(cmb.getSelectedItem().equals("STEM")){
                                        kurso = String.valueOf(cmb.getSelectedItem());
                                    }
                                    else if(cmb.getSelectedItem().equals("ABM")){
                                        kurso = String.valueOf(cmb.getSelectedItem());
                                    }
                                    else if(cmb.getSelectedItem().equals("HUMSS")){
                                        kurso = String.valueOf(cmb.getSelectedItem());
                                    }
                                    else if(cmb.getSelectedItem().equals("GAS")){
                                        kurso = String.valueOf(cmb.getSelectedItem());
                                    }
                                    if(cmb1.getSelectedItem().equals("Filipino")){
                                        citizen= String.valueOf(cmb1.getSelectedItem());
                                    }
                                    else if(cmb1.getSelectedItem().equals("Japanese")){
                                        citizen= String.valueOf(cmb1.getSelectedItem());
                                    }
                                    else if(cmb1.getSelectedItem().equals("Korean")){
                                        citizen= String.valueOf(cmb1.getSelectedItem());
                                    }
                                    else if(cmb1.getSelectedItem().equals("Chinese")){
                                        citizen= String.valueOf(cmb1.getSelectedItem());
                                    }
                                    if(cmb2.getSelectedItem().equals("1")){
                                        Sec= String.valueOf(cmb2.getSelectedItem());
                                    }
                                    else if(cmb2.getSelectedItem().equals("2")){
                                        Sec= String.valueOf(cmb2.getSelectedItem());
                                    }
                                    else if(cmb2.getSelectedItem().equals("3")){
                                        Sec= String.valueOf(cmb2.getSelectedItem());
                                    }
                                    else if(cmb2.getSelectedItem().equals("4")){
                                        Sec= String.valueOf(cmb2.getSelectedItem());
                                    }
                                    else if(cmb2.getSelectedItem().equals("5")){
                                        Sec= String.valueOf(cmb2.getSelectedItem());
                                    }
                                    else if(cmb2.getSelectedItem().equals("6")){
                                        Sec= String.valueOf(cmb2.getSelectedItem());
                                    }
                                    //DATABASE VARIABLE
                                    String Lname=lname.getText();
                                    String Fname=fname.getText();
                                    String Mname=mname.getText();
                                    int edad = Integer.parseInt(age.getText());
                                    int section = Integer.parseInt(Sec);
                                    String stud_stat = status[0];
                                    String acct_stat = acct;
                                    String Age= age.getText();


                                    idRAND = Math.abs((int)(Math.random()*10000000));
                                    String id=String.valueOf(idRAND);
                             
                                    studentlist.add(new Student(Lname,Fname,Mname,hello,Age,hi,citizen,kurso,Sec, id, status[0], acct ));

                                    for(i=0; i< studentlist.size(); i++){
                                        String[] objs ={studentlist.get(i).Lname,studentlist.get(i).Fname,studentlist.get(i).Mname,studentlist.get(i).year,studentlist.get(i).gulang,studentlist.get(i).Gender,studentlist.get(i).Citizenship,studentlist.get(i).strand,studentlist.get(i).section,studentlist.get(i).id,status[0],acct};
                                        String[] objs1 = {studentlist.get(i).id,Lname+","+Fname+" "+Mname ,down, "1480", "1480", "1480", "1480", "1630", "1630", "1630", "1630", "1630", "Paid"};
                                        model.addRow(objs);
                                        modellist.addRow(objs1);
                                        addframe.dispose();
                                    }
                                    lname.setText("");
                                    fname.setText("");
                                    mname.setText("");
                                    age.setText("");
                                    bg.clearSelection();
                                    bg1.clearSelection();
                                    cmb.setSelectedIndex(0);
                                    cmb1.setSelectedIndex(0);
                                    cmb2.setSelectedIndex(0);


                                    try{

                                        Class.forName("com.mysql.cj.jdbc.Driver");

                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment","root","root");

                                        PreparedStatement stm = con.prepareStatement("INSERT INTO student(Lname,Fname,Mname, Age, Gender, Citizenship,Stud_ID, Status, Acct_stat, Username, Password)"
                                                        +"VALUES(?,?,?,?,?,?,?,?,?,?,?)");
                                        PreparedStatement stm2 = con.prepareStatement("INSERT INTO enrollment(Stud_ID, StrandCode, Section, Grd_lvl)"
                                                        +"VALUES(?,?,?,?)");
                                        PreparedStatement stm3 = con.prepareStatement("INSERT INTO payment(Stud_ID, Down, Sept, Oct, Nov, Dece, Jan, Feb, Mar, Apr, May, Stat)"+"VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");

                                        stm.setString(1, Lname);
                                        stm.setString(2, Fname);
                                        stm.setString(3, Mname);
                                        stm.setInt(4, edad);
                                        stm.setString(5, hi);
                                        stm.setString(6, citizen);
                                        stm.setInt(7, idRAND);
                                        stm.setString(8, stud_stat);
                                        stm.setString(9, acct_stat);
                                        stm.setString(10, id);
                                        stm.setString(11, Lname);
                                        
                                        stm2.setInt(1, idRAND);
                                        stm2.setString(2, kurso);
                                        stm2.setInt(3, section);
                                        stm2.setString(4, hello);
                                        
                                        stm3.setInt(1, idRAND);
                                        stm3.setInt(2, Integer.parseInt(down));
                                        stm3.setInt(3, 1480);
                                        stm3.setInt(4, 1480);
                                        stm3.setInt(5, 1480);
                                        stm3.setInt(6, 1480);
                                        stm3.setInt(7, 1630);
                                        stm3.setInt(8, 1630);
                                        stm3.setInt(9, 1630);
                                        stm3.setInt(10, 1630);
                                        stm3.setInt(11, 1630);
                                        stm3.setString(12, "Paid");

                                        stm.executeUpdate();
                                        stm2.executeUpdate();
                                        stm3.executeUpdate();

                                        con.close();

                                        JOptionPane.showMessageDialog(null, "Saved");
                                        System.out.println("Success");
                                    }
                                    catch(Exception ex){
                                        System.out.println("Invalid");
                                    }

                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "         Invalid Payment");
                                }
                            }catch(Exception ex){
                                JOptionPane.showMessageDialog(null, "         Invalid Payment");
                            }
                            
                        }
                        
                    });
                    
                    bt_cancel= new JButton("Cancel");
                    bt_cancel.setFont(new Font("Minion Variable Concept",Font.PLAIN,15));
                    bt_cancel.setForeground(Color.black);
                    bt_cancel.setBorder(blackline);
                    bt_cancel.setBounds(170,260,100,30);
                    bt_cancel.setBackground(new Color(255,204,102));
                    bt_cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    CASH.add(bt_cancel);
                    bt_cancel.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            CASH.dispose();
                        }
                        
                    });
                    ImageIcon icon = new ImageIcon("AU_logo_green_emboss.png");
                    CASH.setIconImage(icon.getImage());
        
                    ImageIcon bg_img = new ImageIcon("regp.png");
                    background= new JLabel("",bg_img,JLabel.CENTER);
                    background.setBounds(0,0,320,400);
                    CASH.add(background);

                    CASH.setLayout(null);
                    CASH.setBounds(520,180, 320, 400);
                    CASH.setVisible(true);
                    CASH.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    }
                
                
                
                else if(monthly.isSelected()==true){
                    String down= String.valueOf(6230);
                    int total =6230;
                    
                    MONTHLY = new JFrame("Monthly");

                    
                    
                    //label------------
                    lb_cash= new JLabel("MONTHLY");
                    lb_cash.setFont(new Font("Serif",Font.PLAIN,40));
                    lb_cash.setBounds(55,20,200,50);
                    lb_cash.setForeground(Color.black);
                    MONTHLY.add(lb_cash);

                    lb_note= new JLabel("Total Down Payment: 6230");
                    lb_note.setFont(new Font("Serif",Font.PLAIN,18));
                    lb_note.setBounds(30,100,300,50);
                    lb_note.setForeground(Color.black);
                    MONTHLY.add(lb_note);
                    
                    
                    //textfield
                    tx_cash= new JTextField();
                    tx_cash.setBounds(80,150,150,30);
                    MONTHLY.add(tx_cash);
                    
                    
                    
                    bt_pay= new JButton("Pay");
                    bt_pay.setFont(new Font("Minion Variable Concept",Font.PLAIN,15));
                    bt_pay.setForeground(Color.black);
                    bt_pay.setBorder(blackline);
                    bt_pay.setBounds(170,220,100,30);
                    bt_pay.setBackground(new Color(255,204,102));
                    bt_pay.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    MONTHLY.add(bt_pay);
                    bt_pay.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                            if(Integer.parseInt(tx_cash.getText())>=total){
                                change=Math.abs(total-Integer.parseInt(tx_cash.getText()));
                                JOptionPane.showMessageDialog(null, "Your change is: "+change);
                                MONTHLY.dispose();
                            
                                if(rb.isSelected()==true){
                                    hello=rb.getText();
                                    System.out.println(hello);
                                }
                                else if(rb1.isSelected()==true){
                                    hello=rb1.getText();
                                    System.out.println(hello);
                                }
                                if(male.isSelected()==true){
                                    hi=male.getText();
                                }
                                else if(female.isSelected()==true){
                                    hi=female.getText();
                                }

                    //----------------------ComboBox--------------------------------------
                                if(cmb.getSelectedItem().equals("STEM")){
                                    kurso = String.valueOf(cmb.getSelectedItem());
                                }
                                else if(cmb.getSelectedItem().equals("ABM")){
                                    kurso = String.valueOf(cmb.getSelectedItem());
                                }
                                else if(cmb.getSelectedItem().equals("HUMSS")){
                                    kurso = String.valueOf(cmb.getSelectedItem());
                                }
                                else if(cmb.getSelectedItem().equals("GAS")){
                                    kurso = String.valueOf(cmb.getSelectedItem());
                                }
                                if(cmb1.getSelectedItem().equals("Filipino")){
                                    citizen= String.valueOf(cmb1.getSelectedItem());
                                }
                                else if(cmb1.getSelectedItem().equals("Japanese")){
                                    citizen= String.valueOf(cmb1.getSelectedItem());
                                }
                                else if(cmb1.getSelectedItem().equals("Korean")){
                                    citizen= String.valueOf(cmb1.getSelectedItem());
                                }
                                else if(cmb1.getSelectedItem().equals("Chinese")){
                                    citizen= String.valueOf(cmb1.getSelectedItem());
                                }
                                if(cmb2.getSelectedItem().equals("1")){
                                    Sec= String.valueOf(cmb2.getSelectedItem());
                                }
                                else if(cmb2.getSelectedItem().equals("2")){
                                    Sec= String.valueOf(cmb2.getSelectedItem());
                                }
                                else if(cmb2.getSelectedItem().equals("3")){
                                    Sec= String.valueOf(cmb2.getSelectedItem());
                                }
                                else if(cmb2.getSelectedItem().equals("4")){
                                    Sec= String.valueOf(cmb2.getSelectedItem());
                                }
                                else if(cmb2.getSelectedItem().equals("5")){
                                    Sec= String.valueOf(cmb2.getSelectedItem());
                                }
                                else if(cmb2.getSelectedItem().equals("6")){
                                    Sec= String.valueOf(cmb2.getSelectedItem());
                                }
                                //DATABASE VARIABLE
                                String Lname=lname.getText();
                                String Fname=fname.getText();
                                String Mname=mname.getText();
                                int edad = Integer.parseInt(age.getText());
                                int section = Integer.parseInt(Sec);
                                String stud_stat = status[0];
                                String acct_stat = acct;
                                

                                String Age= age.getText();
                                idRAND = Math.abs((int)(Math.random()*10000000));
                                String id=String.valueOf(idRAND);
                                
                                studentlist.add(new Student(Lname,Fname,Mname,hello,Age,hi,citizen,kurso,Sec, id, status[0], acct ));
                                

                                for(i=0; i< studentlist.size(); i++){
                                    String[] objs ={studentlist.get(i).Lname,studentlist.get(i).Fname,studentlist.get(i).Mname,studentlist.get(i).year,studentlist.get(i).gulang,studentlist.get(i).Gender,studentlist.get(i).Citizenship,studentlist.get(i).strand,studentlist.get(i).section,studentlist.get(i).id,status[0],acct};
                                    model.addRow(objs);
                                    String[] objs1 = {studentlist.get(i).id,Lname+","+Fname+" "+Mname ,down};
                                    modellist.addRow(objs1);
                                    addframe.dispose();
                                }
                                lname.setText("");
                                fname.setText("");
                                mname.setText("");
                                age.setText("");
                                bg.clearSelection();
                                bg1.clearSelection();
                                cmb.setSelectedIndex(0);
                                cmb1.setSelectedIndex(0);
                                cmb2.setSelectedIndex(0);


                                try{

                                    Class.forName("com.mysql.cj.jdbc.Driver");

                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment","root","root");

                                    PreparedStatement stm = con.prepareStatement("INSERT INTO student(Lname,Fname,Mname, Age, Gender, Citizenship, Stud_ID, Status, Acct_stat, Username, Password)"
                                                    +"VALUES(?,?,?,?,?,?,?,?,?,?,?)");
                                    PreparedStatement stm2 = con.prepareStatement("INSERT INTO enrollment(Stud_ID, StrandCode, Section, Grd_lvl)"
                                                        +"VALUES(?,?,?,?)");
                                    PreparedStatement stm3 = con.prepareStatement("INSERT INTO payment(Stud_ID, Down, Sept, Oct, Nov, Dece, Jan, Feb, Mar, Apr, May, Stat)"+"VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");

                                    stm.setString(1, Lname);
                                    stm.setString(2, Fname);
                                    stm.setString(3, Mname);
                                    stm.setInt(4, edad);
                                    stm.setString(5, hi);
                                    stm.setString(6, citizen);
                                    stm.setInt(7, idRAND);
                                    stm.setString(8, stud_stat);
                                    stm.setString(9, acct_stat);
                                    stm.setString(10, id);
                                    stm.setString(11, Lname);
                                    
                                    stm2.setInt(1, idRAND);
                                    stm2.setString(2, kurso);
                                    stm2.setInt(3, section);
                                    stm2.setString(4, hello);
                                    
                                    stm3.setInt(1, idRAND);
                                    stm3.setInt(2, Integer.parseInt(down));
                                    stm3.setInt(3, 0);
                                    stm3.setInt(4, 0);
                                    stm3.setInt(5, 0);
                                    stm3.setInt(6, 0);
                                    stm3.setInt(7, 0);
                                    stm3.setInt(8, 0);
                                    stm3.setInt(9, 0);
                                    stm3.setInt(10, 0);
                                    stm3.setInt(11, 0);
                                    stm3.setString(12, "");


                                    stm.executeUpdate();
                                    stm2.executeUpdate();
                                    stm3.executeUpdate();
                                    
                                    con.close();
                                    
                                    JOptionPane.showMessageDialog(null, "Saved");
                                    System.out.println("Success");
                                }
                                catch(Exception ex){
                                    System.out.println("Invalid");
                                }
                                
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "         Invalid Payment");
                            }
                            }catch(Exception ex){
                                JOptionPane.showMessageDialog(null, "         Invalid Payment");
                            }
                            
                        }
                        
                    });
                    
                    bt_cancel= new JButton("Cancel");
                    bt_cancel.setFont(new Font("Minion Variable Concept",Font.PLAIN,15));
                    bt_cancel.setForeground(Color.black);
                    bt_cancel.setBorder(blackline);
                    bt_cancel.setBounds(170,260,100,30);
                    bt_cancel.setBackground(new Color(255,204,102));
                    bt_cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    MONTHLY.add(bt_cancel);
                    bt_cancel.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            MONTHLY.dispose();
                        }
                        
                    });
                    ImageIcon icon = new ImageIcon("AU_logo_green_emboss.png");
                    MONTHLY.setIconImage(icon.getImage());
        
                    ImageIcon bg_img = new ImageIcon("regp.png");
                    background= new JLabel("",bg_img,JLabel.CENTER);
                    background.setBounds(0,0,320,400);
                    MONTHLY.add(background);

                    MONTHLY.setLayout(null);
                    MONTHLY.setBounds(520,180, 320, 400);
                    MONTHLY.setVisible(true);
                    MONTHLY.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    }
                
                }
                
            

            else if(e.getSource()==exit){
                addframe.hide();
            }
            else if(e.getSource()==s){
                String text = search.getText();
        
                DefaultTableModel tbmodel = (DefaultTableModel) tb.getModel();
                TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tbmodel);

                tb.setRowSorter(rowSorter);

                rowSorter.setRowFilter(RowFilter.regexFilter(text));
                
                
            }
            else if(e.getSource()==up){
                DefaultTableModel tbmodel = (DefaultTableModel) tb.getModel();
                if(tb.getSelectedRowCount()==1){
                    auth= new JFrame("Admin Authentication");
                    ImageIcon icon = new ImageIcon("AU_logo_green.png");
                    auth.setIconImage(icon.getImage());

                    label= new JLabel("AUTHENTICATION");
                    label.setBounds(35,30,300,50);
                    label.setFont(new Font("POPPINS", Font.BOLD, 26));
                    label.setForeground(Color.white);
                    auth.add(label);

                    un = new JLabel("Username:");
                    un.setBounds(25,110, 230,30);
                    un.setForeground(Color.white);
                    un.setFont(new Font("Minion Variable Concept",Font.PLAIN,18));
                    auth.add(un);

                    txt_un = new JTextField();
                    txt_un.setBounds(25,140,250,30);
                    auth.add(txt_un);

                    pw = new JLabel("Password:");
                    pw.setBounds(25,190,230,30);
                    pw.setForeground(Color.white);
                    pw.setFont(new Font("Minion Variable Concept",Font.PLAIN,18));
                    auth.add(pw);

                    txt_pw = new JPasswordField();
                    txt_pw.setBounds(25,220,250,30);
                    auth.add(txt_pw);

                    authentication= new JButton("SAVE");
                    authentication.setBounds(25,300,250,30);
                    authentication.setFont(new Font("Serif", Font.BOLD, 15));
                    authentication.setForeground(Color.white);
                    authentication.setBackground(new Color(0x226b2c));
                    authentication.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    auth.add(authentication);
                    authentication.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String sta = tbmodel.getValueAt(tb.getSelectedRow(),10).toString();
                            
                            if(sta.equals("Drop")){
                                auth.dispose();
                                JOptionPane.showMessageDialog(null, "The student is dropped");
                            }
                            else if(sta.equals("Student")){
                                if(txt_un.getText().equals("Admin")&&txt_pw.getText().equals("admin")){
                                    auth.dispose();
                                    addframe.dispose();

                                    String Lname=lname.getText();
                                    String Fname=fname.getText();
                                    String Mname=mname.getText();
                                    String taon=age.getText();
                                    String lahi= String.valueOf(cmb1.getSelectedItem());
                                    String Section= String.valueOf(cmb2.getSelectedItem());
                                    String Strand= String.valueOf(cmb.getSelectedItem());

                                    if(rb.isSelected()==true){
                                        hello=rb.getText();
                                        tbmodel.setValueAt(hello,tb.getSelectedRow(),3);
                                    }
                                    else if(rb1.isSelected()==true){
                                        hello=rb1.getText();
                                        tbmodel.setValueAt(hello,tb.getSelectedRow(),3);
                                    }
                                    if(male.isSelected()==true){
                                        hi=male.getText();
                                        tbmodel.setValueAt(hi,tb.getSelectedRow(),5);
                                    }
                                    else if(female.isSelected()==true){
                                        hi=female.getText();
                                        tbmodel.setValueAt(hi,tb.getSelectedRow(),5);
                                    }


                                tbmodel.setValueAt(Lname,tb.getSelectedRow(),0);
                                tbmodel.setValueAt(Fname,tb.getSelectedRow(),1);
                                tbmodel.setValueAt(Mname,tb.getSelectedRow(),2);
                                tbmodel.setValueAt(taon,tb.getSelectedRow(),4);
                                tbmodel.setValueAt(lahi,tb.getSelectedRow(),6);
                                tbmodel.setValueAt(Section,tb.getSelectedRow(),8);
                                tbmodel.setValueAt(Strand,tb.getSelectedRow(),7);
                                tbmodel.setValueAt("Student",tb.getSelectedRow(),10);

                                //DATABASE VARIABLE--------------------------
                                int id = Integer.parseInt(tbmodel.getValueAt(tb.getSelectedRow(), 9).toString());
                                int edad = Integer.parseInt(tbmodel.getValueAt(tb.getSelectedRow(),4).toString());
                                int section = Integer.parseInt(tbmodel.getValueAt(tb.getSelectedRow(),8).toString());
                            
                                try{

                                        Class.forName("com.mysql.cj.jdbc.Driver");

                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment","root","root");

                                        PreparedStatement stm = con.prepareStatement
            ("UPDATE student Set Lname=?, Fname=?, Mname=?, Age=?, Gender=?, Citizenship=?, Status=? WHERE Stud_ID="+id);
                                        PreparedStatement stm2 = con.prepareStatement("UPDATE enrollment SET StrandCode=?, Section=?, Grd_lvl=? WHERE Stud_ID="+id);

                                        stm.setString(1, Lname);
                                        stm.setString(2, Fname);
                                        stm.setString(3, Mname);
                                        stm.setInt(4, edad);
                                        stm.setString(5, hi);
                                        stm.setString(6, lahi);
                                        stm.setString(7, "Student");

                                        stm2.setString(1, Strand);
                                        stm2.setInt(2, section);
                                        stm2.setString(3, hello);


                                        stm.executeUpdate();
                                        stm2.executeUpdate();

                                        con.close();

                                        JOptionPane.showMessageDialog(null, "Successfully Updated");
                                        System.out.println("Success");
                                    }
                                    catch(Exception ex){
                                        System.out.println("Invalid");
                                    }
                                }
                            }
                            else if(!(txt_un.getText().equals("Admin")&&txt_pw.getText().equals("admin"))){
                                JOptionPane.showMessageDialog(null, "Wrong Username and Password");
                                txt_un.setText("");
                                txt_pw.setText("");
                            }
                            else if(txt_un.getText().equals("")&&txt_pw.getText().equals("")){
                                JOptionPane.showMessageDialog(null, "Please Input Details");
                            }
                        }
                        

                    });
                    ImageIcon authBG = new ImageIcon("auth_bg.png");
                    backgroundAUTH= new JLabel("",authBG,JLabel.CENTER);
                    backgroundAUTH.setBounds(0,0,320,400);
                    auth.add(backgroundAUTH);

                    auth.setBounds(520,150,320,400);
                    auth.setLayout(null);
                    auth.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please Select a row");
                }
            }
            else if (e.getSource()==drop){
                DefaultTableModel tbdrop = (DefaultTableModel) tb.getModel();
                if(tb.getSelectedRowCount()==1){
                    if(tb.getValueAt(tb.getSelectedRow(), 10).toString().equals("Drop")){
                        JOptionPane.showMessageDialog(null, "Student is already dropped");
                    }
                    else{
                        auth= new JFrame("Admin Authentication");
                        ImageIcon icon = new ImageIcon("AU_logo_green.png");
                        auth.setIconImage(icon.getImage());

                        label= new JLabel("AUTHENTICATION");
                        label.setBounds(35,30,300,50);
                        label.setFont(new Font("POPPINS", Font.BOLD, 26));
                        label.setForeground(Color.white);
                        auth.add(label);

                        un = new JLabel("Username:");
                        un.setBounds(25,110, 230,30);
                        un.setForeground(Color.white);
                        un.setFont(new Font("Minion Variable Concept",Font.PLAIN,18));
                        auth.add(un);

                        txt_un = new JTextField();
                        txt_un.setBounds(25,140,250,30);
                        auth.add(txt_un);

                        pw = new JLabel("Password:");
                        pw.setBounds(25,190,230,30);
                        pw.setForeground(Color.white);
                        pw.setFont(new Font("Minion Variable Concept",Font.PLAIN,18));
                        auth.add(pw);

                        txt_pw = new JPasswordField();
                        txt_pw.setBounds(25,220,250,30);
                        auth.add(txt_pw);

                        authentication= new JButton("SAVE");
                        authentication.setBounds(25,300,250,30);
                        authentication.setFont(new Font("Serif", Font.BOLD, 15));
                        authentication.setForeground(Color.white);
                        authentication.setBackground(new Color(0x226b2c));
                        authentication.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        auth.add(authentication);
                        authentication.addActionListener(new ActionListener(){
                        @Override
                            public void actionPerformed(ActionEvent e) {
                                if(txt_un.getText().equals("Admin")&&txt_pw.getText().equals("admin")){
                                    auth.dispose();
                                    addframe.dispose();
                                    int id = Integer.parseInt(tbdrop.getValueAt(tb.getSelectedRow(), 9).toString());
                                    try{

                                        Class.forName("com.mysql.cj.jdbc.Driver");

                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment","root","root");

                                        PreparedStatement drop = con.prepareStatement("UPDATE student SET Status = ?, Acct_stat = ? WHERE Stud_ID = "+id);

                                        Statement st= con.createStatement();

                                        String sql="SELECT student.*, enrollment.*, payment.* FROM student,enrollment,payment WHERE student.Stud_ID = enrollment.Stud_ID AND student.Stud_ID = payment.Stud_ID AND student.Stud_ID= "+id;
                                        
                                        drop.setString(1, "Drop");
                                        drop.setString(2, "Unaccessible");
                                        drop.executeUpdate();
                                        
                                        ResultSet rs =st.executeQuery(sql);
                                        
                                        while(rs.next()){
                                            String Lname= rs.getString("Lname");
                                            String Fname=rs.getString("Fname");
                                            String Mname=rs.getString("Mname");
                                            String Year=rs.getString("Grd_lvl");
                                            int Age = rs.getInt("Age");
                                            String Gender = rs.getString("Gender");
                                            String Citizen = rs.getString("Citizenship");
                                            String Strand = rs.getString("StrandCode");
                                            int Section = rs.getInt("Section");
                                            int ID= rs.getInt("Stud_ID");
                                            String stud_stat = rs.getString("Status");
                                            String acct_stat = rs.getString("Acct_stat");
                                            String user = rs.getString("Username");
                                            String pass = rs.getString("Password");
                                            int Down = rs.getInt("Down");
                                            int Sept = rs.getInt("Sept");
                                            int Oct = rs.getInt("Oct");
                                            int Nov = rs.getInt("Nov");
                                            int Dece = rs.getInt("Dece");
                                            int Jan = rs.getInt("Jan");
                                            int Feb = rs.getInt("Feb");
                                            int Mar = rs.getInt("Mar");
                                            int Apr = rs.getInt("Apr");
                                            int May = rs.getInt("May");
                                            String Stat = rs.getString("Stat");
                                            
                                            PreparedStatement stm = con.prepareStatement("INSERT INTO archive(Lname,Fname,Mname, Grd_lvl, Age, Gender, Citizenship,StrandCode,Section,Stud_ID, Status, Acct_stat, Username, Password, Down, Sept, Oct, Nov, Dece, Jan, Feb, Mar, Apr, May, Stat)"
                                                        +"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                                            
                                            stm.setString(1, Lname);
                                            stm.setString(2, Fname);
                                            stm.setString(3, Mname);
                                            stm.setString(4, Year);
                                            stm.setInt(5, Age);
                                            stm.setString(6, Gender);
                                            stm.setString(7, Citizen);
                                            stm.setString(8, Strand);
                                            stm.setInt(9, Section);
                                            stm.setInt(10, ID);
                                            stm.setString(11, stud_stat);
                                            stm.setString(12, acct_stat);
                                            stm.setString(13, user);
                                            stm.setString(14, pass);
                                            stm.setInt(15, Down);
                                            stm.setInt(16, Sept);
                                            stm.setInt(17, Oct);
                                            stm.setInt(18, Nov);
                                            stm.setInt(19, Dece);
                                            stm.setInt(20, Jan);
                                            stm.setInt(21, Feb);
                                            stm.setInt(22, Mar);
                                            stm.setInt(23, Apr);
                                            stm.setInt(24, May);
                                            stm.setString(25, Stat);
                                            
                                            stm.executeUpdate();
                                            
                                        }
//                                        PreparedStatement del = con.prepareStatement("DELETE FROM student WHERE Stud_ID = "+id);
//                                        PreparedStatement del1 = con.prepareStatement("DELETE FROM enrollment WHERE Stud_ID = "+id);
//                                        PreparedStatement del2 = con.prepareStatement("DELETE FROM payment WHERE Stud_ID = "+id);
//
//                                        
//                                        del1.executeUpdate();
//                                        del2.executeUpdate();
//                                        del.executeUpdate();

                                        con.close();

                                        JOptionPane.showMessageDialog(null, "Successfully Updated");
                                        System.out.println("Success");
                                    }
                                    catch(Exception ex){
                                        System.out.println("Invalid");
                                    }
                                }
                                else if(!(txt_un.getText().equals("Admin")&&txt_pw.getText().equals("admin"))){
                                    JOptionPane.showMessageDialog(null, "Wrong Username and Password");
                                    txt_un.setText("");
                                    txt_pw.setText("");
                                }
                                else if(txt_un.getText().equals("")&&txt_pw.getText().equals("")){
                                    JOptionPane.showMessageDialog(null, "Please Input Details");
                                }
                            }
                        });
                        ImageIcon authBG = new ImageIcon("auth_bg.png");
                        backgroundAUTH= new JLabel("",authBG,JLabel.CENTER);
                        backgroundAUTH.setBounds(0,0,320,400);
                        auth.add(backgroundAUTH);
                    
                        auth.setBounds(520,150,320,400);
                        auth.setLayout(null);
                        auth.setVisible(true);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please Select a row");
                }
            }
            else if(e.getSource().equals(ref)){
                DefaultTableModel tbmodel = (DefaultTableModel) tb.getModel();
                if(tb.getSelectedRowCount()==1){
                    tbmodel.setValueAt("Accessible", tb.getSelectedRow(),11);
                    int id = Integer.parseInt(tbmodel.getValueAt(tb.getSelectedRow(), 9).toString());
                    try{
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment","root","root");

                        PreparedStatement ref = con.prepareStatement("UPDATE student SET Acct_stat = ? WHERE Stud_ID = "+id);

                        ref.setString(1, "Accessible");
                        ref.executeUpdate();

                        con.close();

                        JOptionPane.showMessageDialog(null, "Refreshed");
                        System.out.println("Success");
                    }
                    catch(Exception ex){
                        System.out.println("Invalid");
                    }
                }
            }
            else if(e.getSource()==to12){
                id=  JOptionPane.showInputDialog(null,"Please Enter Student ID: ");
            
            if(id==null){
                
            }
            else if(!id.isEmpty()){
                try{
                    String Lname, Fname, Mname, Year, Age, Gender, Citizen, Strand, Section, ID, stud_stat, acct_stat, statu;
                    
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment","root","root");

                    Statement st1= con.createStatement();

                    String sql="SELECT student.*,payment.* , enrollment.* FROM student,payment,enrollment WHERE student.Stud_ID = enrollment.Stud_ID AND student.Stud_ID = payment.Stud_ID AND student.Stud_ID= "+id;
                    ResultSet rs =st1.executeQuery(sql);

                    if(rs.next()){
                        Lname= rs.getString("Lname");
                        Fname= rs.getString("Fname");
                        Mname= rs.getString("Mname");
                        Year=rs.getString("Grd_lvl");
                        Age = String.valueOf(rs.getInt("Age"));
                        Gender = rs.getString("Gender");
                        Citizen = rs.getString("Citizenship");
                        Strand = rs.getString("StrandCode");
                        Section = String.valueOf(rs.getInt("Section"));
                        ID= String.valueOf(rs.getInt("Stud_ID"));
                        stud_stat = rs.getString("Status");
                        acct_stat = rs.getString("Acct_stat");
                        statu= rs.getString("Stat");
                        
                        
                        if(Year.equals("Grade 12")){
                            JOptionPane.showMessageDialog(null,"Student is currently in Grade 12");
                        }
                        else if(statu.equals("")){
                            JOptionPane.showMessageDialog(null,"Student Hasn't Finished Paying for the Current Year");
                        }
                        else{
                            
                            
                            JFrame bt = new JFrame();
                            
                            JButton c= new JButton("CASH");
                            c.setFont(new Font("Minion Variable Concept",Font.PLAIN,20));
                            c.setForeground(Color.white);
                            c.setBorder(blackline);
                            c.setBounds(30,20,150,50);
                            c.setBackground(new Color(0x226b2c));
                            c.setCursor(new Cursor(Cursor.HAND_CURSOR));
                            bt.add(c);
                            c.addActionListener(new ActionListener(){
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    JFrame hi = new JFrame();
                                    
                                    //Label

                                    label= new JLabel("PAYMENT");
                                    label.setFont(new Font("Serif",Font.PLAIN,50));
                                    label.setForeground(Color.white);
                                    label.setBounds(320,30,300,40);
                                    hi.add(label);

                                    JLabel Name = new JLabel("Name: ");
                                    Name.setFont(new Font("Serif",Font.PLAIN,25));
                                    Name.setForeground(Color.white);
                                    Name.setBounds(40,100,150,40);
                                    hi.add(Name);

                                    JLabel lbID = new JLabel("Student ID: ");
                                    lbID.setFont(new Font("Serif",Font.PLAIN,25));
                                    lbID.setForeground(Color.white);
                                    lbID.setBounds(40,160,150,40);
                                    hi.add(lbID);

                                    JLabel lbGr = new JLabel("Grade Level: ");
                                    lbGr.setFont(new Font("Serif",Font.PLAIN,25));
                                    lbGr.setForeground(Color.white);
                                    lbGr.setBounds(40,220,150,40);
                                    hi.add(lbGr);

                                    JLabel lbGender = new JLabel("Gender: ");
                                    lbGender.setFont(new Font("Serif",Font.PLAIN,25));
                                    lbGender.setForeground(Color.white);
                                    lbGender.setBounds(380,100,150,40);
                                    hi.add(lbGender);

                                    JLabel lbCitizen = new JLabel("Citizenship: ");
                                    lbCitizen.setFont(new Font("Serif",Font.PLAIN,25));
                                    lbCitizen.setForeground(Color.white);
                                    lbCitizen.setBounds(320,160,150,40);
                                    hi.add(lbCitizen);

                                    JLabel lbAge = new JLabel("Age: ");
                                    lbAge.setFont(new Font("Serif",Font.PLAIN,25));
                                    lbAge.setForeground(Color.white);
                                    lbAge.setBounds(330,220,150,40);
                                    hi.add(lbAge);

                                    JLabel lbStrand = new JLabel("Strand: ");
                                    lbStrand.setFont(new Font("Serif",Font.PLAIN,25));
                                    lbStrand.setForeground(Color.white);
                                    lbStrand.setBounds(580,100,150,40);
                                    hi.add(lbStrand);

                                    JLabel lbSec = new JLabel("Section: ");
                                    lbSec.setFont(new Font("Serif",Font.PLAIN,25));
                                    lbSec.setForeground(Color.white);
                                    lbSec.setBounds(580,160,150,40);
                                    hi.add(lbSec);

                                    JLabel buwan = new JLabel("Cash");
                                    buwan.setFont(new Font("Serif",Font.PLAIN,35));
                                    buwan.setForeground(Color.white);
                                    buwan.setBounds(400,330,300,40);
                                    hi.add(buwan);

                                    JLabel total = new JLabel("Total of: 20300");
                                    total.setFont(new Font("Serif",Font.PLAIN,35));
                                    total.setForeground(Color.white);
                                    total.setBounds(340,380,300,40);
                                    hi. add(total);




                                    //TextFields

                                    JTextField name= new JTextField(Lname+", "+Fname+" "+Mname);
                                    name.setEditable(false);
                                    name.setFont(new Font("Serif",Font.PLAIN,18));
                                    name.setBounds(120,100,230,40);
                                    hi.add(name);

                                    JTextField txID= new JTextField(ID);
                                    txID.setEditable(false);
                                    txID.setFont(new Font("Serif",Font.PLAIN,18));
                                    txID.setBounds(170,160,100,40);
                                    hi.add(txID);

                                    JTextField txGr= new JTextField(Year);
                                    txGr.setEditable(false);
                                    txGr.setFont(new Font("Serif",Font.PLAIN,18));
                                    txGr.setBounds(190,220,100,40);
                                    hi.add(txGr);

                                    JTextField txGender= new JTextField(Gender);
                                    txGender.setEditable(false);
                                    txGender.setFont(new Font("Serif",Font.PLAIN,18));
                                    txGender.setBounds(470,100,80,40);
                                    hi.add(txGender);

                                    JTextField txCitizen= new JTextField(Citizen);
                                    txCitizen.setEditable(false);
                                    txCitizen.setFont(new Font("Serif",Font.PLAIN,18));
                                    txCitizen.setBounds(450,160,100,40);
                                    hi.add(txCitizen);

                                    JTextField txAge= new JTextField(Age);
                                    txAge.setEditable(false);
                                    txAge.setFont(new Font("Serif",Font.PLAIN,18));
                                    txAge.setBounds(390,220,100,40);
                                    hi.add(txAge);

                                    JTextField txStrand= new JTextField(Strand);
                                    txStrand.setEditable(false);
                                    txStrand.setFont(new Font("Serif",Font.PLAIN,18));
                                    txStrand.setBounds(680,100,100,40);
                                    hi.add(txStrand);

                                    JTextField txSec= new JTextField(Section);
                                    txSec.setEditable(false);
                                    txSec.setFont(new Font("Serif",Font.PLAIN,18));
                                    txSec.setBounds(680,160,50,40);
                                    hi.add(txSec);

                                    JTextField txPay= new JTextField();
                                    txPay.setFont(new Font("Serif",Font.PLAIN,18));
                                    txPay.setBounds(365,440,150,40);
                                    hi.add(txPay);



                                    //JButton

                                    JButton btPay= new JButton("PAY");
                                    btPay.setBounds(315,500,250,40);
                                    btPay.setBorder(blackline);
                                    btPay.setFont(new Font("Serif", Font.BOLD, 20));
                                    btPay.setForeground(Color.white);
                                    btPay.setBackground(new Color(0x226b2c));
                                    btPay.setCursor(new Cursor(Cursor.HAND_CURSOR));
                                    hi.add(btPay);
                                    btPay.addActionListener(new ActionListener(){
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            String down= String.valueOf(6230);
                                            int total =20300;
                                            
                                            try{
                                                if(Integer.parseInt(txPay.getText())>=total){
                                                    change=Math.abs(total-Integer.parseInt(txPay.getText()));
                                                    JOptionPane.showMessageDialog(null, "Your change is: "+change);
                                                    bt.dispose();

                                                    try{


                                                        Class.forName("com.mysql.cj.jdbc.Driver");

                                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment","root","root");


                                                        PreparedStatement mon = con.prepareStatement("UPDATE payment SET Down = ?, Sept = ?, Oct = ?, Nov= ?, Dece= ?, Jan= ?, Feb= ?, Mar= ?, Apr= ?, May= ?, Stat= ? WHERE Stud_ID="+id);
                                                        PreparedStatement up = con.prepareStatement("UPDATE enrollment SET Grd_lvl = ? WHERE Stud_ID="+id);
                                                        
                                                        mon.setInt(1, Integer.parseInt(down));
                                                        mon.setInt(2, 1480);
                                                        mon.setInt(3, 1480);
                                                        mon.setInt(4, 1480);
                                                        mon.setInt(5, 1480);
                                                        mon.setInt(6, 1630);
                                                        mon.setInt(7, 1630);
                                                        mon.setInt(8, 1630);
                                                        mon.setInt(9, 1630);
                                                        mon.setInt(10, 1630);
                                                        mon.setString(11, "Paid");
                                                        
                                                        up.setString(1, "Grade 12");


                                                        mon.executeUpdate();
                                                        up.executeUpdate();


                                                        con.close();

                                                        JOptionPane.showMessageDialog(null, "Saved");
                                                        bt.dispose();
                                                        hi.dispose();
                                                        addframe.dispose();
                                                        System.out.println("Success");
                                                    }
                                                    catch(Exception ex){
                                                        System.out.println("Invalid");
                                                    }
                                                }
                                                else{
                                                    JOptionPane.showMessageDialog(null, "         Invalid Payment");
                                                }
                                            } 
                                            catch(Exception ex){
                                                JOptionPane.showMessageDialog(null, "         Invalid Payment");
                                            }
                                        }

                                    });
                                    
                                    ImageIcon icon = new ImageIcon("AU_logo_green_emboss.png");
                                    hi.setTitle("Payment");
                                    hi.setIconImage(icon.getImage());

                                    ImageIcon bg = new ImageIcon("payment_bg.png");
                                    background= new JLabel("",bg,JLabel.CENTER);
                                    background.setBounds(0,0,900,650);
                                    hi.add(background);


                                    hi.setLayout(null);
                                    hi.setBounds(230,40,900,650);
                                    hi.setVisible(true);
                                }
                                
                            });
                            
                            JButton m= new JButton("MONTHLY");
                            m.setFont(new Font("Minion Variable Concept",Font.PLAIN,20));
                            m.setForeground(Color.white);
                            m.setBorder(blackline);
                            m.setBounds(210,20,150,50);
                            m.setBackground(new Color(0x226b2c));
                            m.setCursor(new Cursor(Cursor.HAND_CURSOR));
                            bt.add(m);
                            m.addActionListener(new ActionListener(){
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    JFrame hi = new JFrame();
                                    
                                    //Label

                                    label= new JLabel("PAYMENT");
                                    label.setFont(new Font("Serif",Font.PLAIN,50));
                                    label.setForeground(Color.white);
                                    label.setBounds(320,30,300,40);
                                    hi.add(label);

                                    JLabel Name = new JLabel("Name: ");
                                    Name.setFont(new Font("Serif",Font.PLAIN,25));
                                    Name.setForeground(Color.white);
                                    Name.setBounds(40,100,150,40);
                                    hi.add(Name);

                                    JLabel lbID = new JLabel("Student ID: ");
                                    lbID.setFont(new Font("Serif",Font.PLAIN,25));
                                    lbID.setForeground(Color.white);
                                    lbID.setBounds(40,160,150,40);
                                    hi.add(lbID);

                                    JLabel lbGr = new JLabel("Grade Level: ");
                                    lbGr.setFont(new Font("Serif",Font.PLAIN,25));
                                    lbGr.setForeground(Color.white);
                                    lbGr.setBounds(40,220,150,40);
                                    hi.add(lbGr);

                                    JLabel lbGender = new JLabel("Gender: ");
                                    lbGender.setFont(new Font("Serif",Font.PLAIN,25));
                                    lbGender.setForeground(Color.white);
                                    lbGender.setBounds(380,100,150,40);
                                    hi.add(lbGender);

                                    JLabel lbCitizen = new JLabel("Citizenship: ");
                                    lbCitizen.setFont(new Font("Serif",Font.PLAIN,25));
                                    lbCitizen.setForeground(Color.white);
                                    lbCitizen.setBounds(320,160,150,40);
                                    hi.add(lbCitizen);

                                    JLabel lbAge = new JLabel("Age: ");
                                    lbAge.setFont(new Font("Serif",Font.PLAIN,25));
                                    lbAge.setForeground(Color.white);
                                    lbAge.setBounds(330,220,150,40);
                                    hi.add(lbAge);

                                    JLabel lbStrand = new JLabel("Strand: ");
                                    lbStrand.setFont(new Font("Serif",Font.PLAIN,25));
                                    lbStrand.setForeground(Color.white);
                                    lbStrand.setBounds(580,100,150,40);
                                    hi.add(lbStrand);

                                    JLabel lbSec = new JLabel("Section: ");
                                    lbSec.setFont(new Font("Serif",Font.PLAIN,25));
                                    lbSec.setForeground(Color.white);
                                    lbSec.setBounds(580,160,150,40);
                                    hi.add(lbSec);

                                    JLabel buwan = new JLabel("Down Payment");
                                    buwan.setFont(new Font("Serif",Font.PLAIN,35));
                                    buwan.setForeground(Color.white);
                                    buwan.setBounds(330,330,300,40);
                                    hi.add(buwan);

                                    JLabel total = new JLabel("Total of: 6230");
                                    total.setFont(new Font("Serif",Font.PLAIN,35));
                                    total.setForeground(Color.white);
                                    total.setBounds(340,380,300,40);
                                    hi. add(total);




                                    //TextFields

                                    JTextField name= new JTextField(Lname+", "+Fname+" "+Mname);
                                    name.setEditable(false);
                                    name.setFont(new Font("Serif",Font.PLAIN,18));
                                    name.setBounds(120,100,230,40);
                                    hi.add(name);

                                    JTextField txID= new JTextField(ID);
                                    txID.setEditable(false);
                                    txID.setFont(new Font("Serif",Font.PLAIN,18));
                                    txID.setBounds(170,160,100,40);
                                    hi.add(txID);

                                    JTextField txGr= new JTextField(Year);
                                    txGr.setEditable(false);
                                    txGr.setFont(new Font("Serif",Font.PLAIN,18));
                                    txGr.setBounds(190,220,100,40);
                                    hi.add(txGr);

                                    JTextField txGender= new JTextField(Gender);
                                    txGender.setEditable(false);
                                    txGender.setFont(new Font("Serif",Font.PLAIN,18));
                                    txGender.setBounds(470,100,80,40);
                                    hi.add(txGender);

                                    JTextField txCitizen= new JTextField(Citizen);
                                    txCitizen.setEditable(false);
                                    txCitizen.setFont(new Font("Serif",Font.PLAIN,18));
                                    txCitizen.setBounds(450,160,100,40);
                                    hi.add(txCitizen);

                                    JTextField txAge= new JTextField(Age);
                                    txAge.setEditable(false);
                                    txAge.setFont(new Font("Serif",Font.PLAIN,18));
                                    txAge.setBounds(390,220,100,40);
                                    hi.add(txAge);

                                    JTextField txStrand= new JTextField(Strand);
                                    txStrand.setEditable(false);
                                    txStrand.setFont(new Font("Serif",Font.PLAIN,18));
                                    txStrand.setBounds(680,100,100,40);
                                    hi.add(txStrand);

                                    JTextField txSec= new JTextField(Section);
                                    txSec.setEditable(false);
                                    txSec.setFont(new Font("Serif",Font.PLAIN,18));
                                    txSec.setBounds(680,160,50,40);
                                    hi.add(txSec);

                                    JTextField txPay= new JTextField();
                                    txPay.setFont(new Font("Serif",Font.PLAIN,18));
                                    txPay.setBounds(365,440,150,40);
                                    hi.add(txPay);



                                    //JButton

                                    JButton btPay= new JButton("PAY");
                                    btPay.setBounds(315,500,250,40);
                                    btPay.setBorder(blackline);
                                    btPay.setFont(new Font("Serif", Font.BOLD, 20));
                                    btPay.setForeground(Color.white);
                                    btPay.setBackground(new Color(0x226b2c));
                                    btPay.setCursor(new Cursor(Cursor.HAND_CURSOR));
                                    hi.add(btPay);
                                    btPay.addActionListener(new ActionListener(){
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            String down= String.valueOf(6230);
                                            int total =6230;
                                            
                                            try{
                                                if(Integer.parseInt(txPay.getText())>=total){
                                                    change=Math.abs(total-Integer.parseInt(txPay.getText()));
                                                    JOptionPane.showMessageDialog(null, "Your change is: "+change);
                                                    bt.dispose();

                                                    try{


                                                        Class.forName("com.mysql.cj.jdbc.Driver");

                                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment","root","root");


                                                        PreparedStatement mon = con.prepareStatement("UPDATE payment SET Down = ?, Sept = ?, Oct = ?, Nov= ?, Dece= ?, Jan= ?, Feb= ?, Mar= ?, Apr= ?, May= ?, Stat= ? WHERE Stud_ID="+id);
                                                        PreparedStatement up = con.prepareStatement("UPDATE enrollment SET Grd_lvl = ? WHERE Stud_ID="+id);
                                                        
                                                        mon.setInt(1, Integer.parseInt(down));
                                                        mon.setInt(2, 0);
                                                        mon.setInt(3, 0);
                                                        mon.setInt(4, 0);
                                                        mon.setInt(5, 0);
                                                        mon.setInt(6, 0);
                                                        mon.setInt(7, 0);
                                                        mon.setInt(8, 0);
                                                        mon.setInt(9, 0);
                                                        mon.setInt(10, 0);
                                                        mon.setString(11, "");
                                                        
                                                        up.setString(1, "Grade 12");


                                                        mon.executeUpdate();
                                                        up.executeUpdate();


                                                        con.close();

                                                        JOptionPane.showMessageDialog(null, "Saved");
                                                        bt.dispose();
                                                        hi.dispose();
                                                        addframe.dispose();
                                                        System.out.println("Success");
                                                    }
                                                    catch(Exception ex){
                                                        System.out.println("Invalid");
                                                    }
                                                }
                                                else{
                                                    JOptionPane.showMessageDialog(null, "         Invalid Payment");
                                                }
                                            } 
                                            catch(Exception ex){
                                                JOptionPane.showMessageDialog(null, "         Invalid Payment");
                                            }
                                        }

                                    });
                                    
                                    ImageIcon icon = new ImageIcon("AU_logo_green_emboss.png");
                                    hi.setTitle("Payment");
                                    hi.setIconImage(icon.getImage());

                                    ImageIcon bg = new ImageIcon("payment_bg.png");
                                    background= new JLabel("",bg,JLabel.CENTER);
                                    background.setBounds(0,0,900,650);
                                    hi.add(background);


                                    hi.setLayout(null);
                                    hi.setBounds(230,40,900,650);
                                    hi.setVisible(true);
                                }
                                
                            });
                            
                            ImageIcon icon = new ImageIcon("AU_logo_green_emboss.png");
                            bt.setIconImage(icon.getImage());
                            
                            bt.getContentPane().setBackground(new Color(0xeaa532));
                            bt.setLayout(null);
                            bt.setBounds(480,250,400,150);
                            bt.setVisible(true);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Student ID Not Found");
                    }
                }
                catch(Exception ex){
                    System.out.println("Invalid");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Input ID");
            }
            }
            else if(e.getSource()==p){
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment","root","root");
                                                        
                    JasperDesign design = JRXmlLoader.load("src\\pkgfinal\\newReport.jrxml");
                    String q = "SELECT student.*, enrollment.* FROM student, enrollment WHERE student.Stud_ID = enrollment.Stud_ID AND student.Status = 'Student'";
                    JRDesignQuery updateQuery = new JRDesignQuery();
                    updateQuery.setText(q);
                    design.setQuery(updateQuery);
                    
                    JasperReport report = JasperCompileManager.compileReport(design);
                    JasperPrint print = JasperFillManager.fillReport(report, null, con);
                    JasperViewer.viewReport(print, false);
                }
                catch(Exception ev){
                    
                }
            }
            else{
                lname.setText("");
                fname.setText("");
                mname.setText("");
                age.setText("");
                bg.clearSelection();
                bg1.clearSelection();
                cmb.setSelectedIndex(0);
                cmb1.setSelectedIndex(0);
                cmb2.setSelectedIndex(0);
            }
        }
    }


    

    
