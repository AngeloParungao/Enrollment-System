    package pkgfinal;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import static pkgfinal.Add.model;
import static pkgfinal.Payment_Record.modellist;



public class Admin_Frame extends JFrame implements ActionListener {
    
    static JFrame addframe;
    JButton Add, bt_pay, bt_payment, logout, drop;
    JLabel lb_admin, img, mid, scname;
    JPanel side_menu, rect, ad_panel;
    ImageIcon bg, icon, add, record, payment, back, logo, Mid, DROP;
    JLabel background;
    
    static int count=1;
    static String identification, checker[];
    String ID;
    
    //border
    Border popup = BorderFactory.createRaisedBevelBorder();
    Border down = BorderFactory.createEtchedBorder(Color.GREEN, Color.LIGHT_GRAY);
    
    Scanner sc = new Scanner(System.in);
    
    public Admin_Frame(){
       
        //Jpanel
        
        side_menu= new JPanel();
        side_menu.setBackground(new Color(204,255,204));
        side_menu.setBounds(0,0,230,700);
        side_menu.setLayout(null);
        this.add(side_menu);
        
        ad_panel= new JPanel();
        ad_panel.setBorder(popup);
        ad_panel.setBackground(new Color(255,204,51));
        ad_panel.setBounds(-7,30,200,50);
        ad_panel.setLayout(null);
        side_menu.add(ad_panel);
        
//        rect = new JPanel();
//        rect.setBackground(new Color(0.9f,0.9f,0.9f,0.4f));
//        rect.setBounds(0,0,1500,700);
//        rect.setLayout(null);
//        this.add(rect);
        
        //label
        scname= new JLabel("ADEIA UNIVERSITY",JLabel.CENTER);
        scname.setFont(new Font("Serif",Font.PLAIN,80));
        scname.setForeground(Color.white);
        scname.setBounds(360,470,900,100);
        add(scname);
        
        lb_admin = new JLabel("ADMIN");
        lb_admin.setFont(new Font("Serif",Font.PLAIN,25));
        lb_admin.setBounds(55,0,100,50);
        lb_admin.setForeground(Color.black);
        ad_panel.add(lb_admin);
        
        //button
        add = new ImageIcon("add.png");
        Add= new JButton(add);
        Add.setText(" Enroll Student    ");
        Add.setBorder(down);
        Add.setFont(new Font("Serif",Font.PLAIN,23));
        Add.setBounds(0,120,230,60);
        Add.setBackground(new Color(204,255,204));
        Add.setCursor(new Cursor(Cursor.HAND_CURSOR));
        side_menu.add(Add);
        
        record = new ImageIcon("list.png");
        bt_pay = new JButton(record);
        bt_pay .setBounds(0,180,230,60);
        bt_pay .setText(" Payment Record ");
        bt_pay.setBorder(down);
        bt_pay.setFont(new Font("Serif",Font.PLAIN,23));
        bt_pay .setBackground(new Color(204,255,204));
        bt_pay .setCursor(new Cursor(Cursor.HAND_CURSOR));
        side_menu.add(bt_pay);
        
        payment = new ImageIcon("credit-card.png");
        bt_payment = new JButton(payment);
        bt_payment.setBounds(0,240,230,60);
        bt_payment.setText(" Add Payment      ");
        bt_payment.setBorder(down);
        bt_payment.setFont(new Font("Serif",Font.PLAIN,23));
        bt_payment.setBackground(new Color(204,255,204));
        bt_payment.setCursor(new Cursor(Cursor.HAND_CURSOR));
        side_menu.add(bt_payment);
        
        DROP = new ImageIcon("archive.png");
        drop = new JButton(DROP);
        drop.setBounds(0,530,230,60);
        drop.setText(" Archive Records ");
        drop.setBorder(down);
        drop.setFont(new Font("Serif",Font.PLAIN,23));
        drop.setBackground(new Color(204,255,204));
        drop.setCursor(new Cursor(Cursor.HAND_CURSOR));
        side_menu.add(drop);
        
        back = new ImageIcon("exit.png");
        logout = new JButton(back);
        logout.setBounds(0,630,230,40);
        logout.setText(" Logout            ");
        logout.setBorder(down);
        logout.setFont(new Font("Serif",Font.PLAIN,20));
        logout.setBackground(new Color(204,255,204));
        logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        side_menu.add(logout);
        
        //Action
        Add.addActionListener(this);
        bt_pay.addActionListener(this);
        bt_payment.addActionListener(this);
        drop.addActionListener(this);
        logout.addActionListener(this);
        
        //icon
        icon = new ImageIcon("AU_logo_green_emboss.png");
        this.setTitle("Admin");
        this.setIconImage(icon.getImage());
                    
        bg = new ImageIcon("BG1.png");
        background= new JLabel("",bg,JLabel.CENTER);
        background.setBounds(0,0,1920,700);
        this.add(background);
        
        
        logo = new ImageIcon("AU_logo_green_nocirc1.png");
        img =new JLabel();
        img.setVisible(true);
        img.setBounds(600,20,800,600);
        img.setIcon(logo);
        background.add(img);
        
        
        
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(500, 600));
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Add){
            
            bt_pay.setBackground(new Color(204,255,204));
            bt_pay.setForeground(Color.black);
            bt_pay.setBorder(down);
            bt_pay.setEnabled(true);
            bt_payment.setBackground(new Color(204,255,204));
            bt_payment.setForeground(Color.black);
            bt_payment.setBorder(down);
            bt_payment.setEnabled(true);
            
            Add.setBackground(new Color(0,153,51));
            Add.setBorder(popup);
            Add.setForeground(Color.white);
//            Add.setEnabled(false);
            

model.setRowCount(0);
            try{
                
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment","root","root");

                Statement st= con.createStatement();

                String sql="SELECT student.*, enrollment.StrandCode, enrollment.Section, enrollment.Grd_lvl FROM student,enrollment WHERE student.Stud_ID = enrollment.Stud_ID;";
                ResultSet rs =st.executeQuery(sql);

                                
                while(rs.next()){
                    String Lname= rs.getString("Lname");
                    String Fname=rs.getString("Fname");
                    String Mname=rs.getString("Mname");
                    String Year=rs.getString("Grd_lvl");
                    String Age = String.valueOf(rs.getInt("Age"));
                    String Gender = rs.getString("Gender");
                    String Citizen = rs.getString("Citizenship");
                    String Strand = rs.getString("StrandCode");
                    String Section = String.valueOf(rs.getInt("Section"));
                    String ID= String.valueOf(rs.getInt("Stud_ID"));
                    String stud_stat = rs.getString("Status");
                    String acct_stat = rs.getString("Acct_stat");
                    

                    String tbData[]={Lname, Fname, Mname, Year, Age, Gender, Citizen, Strand, Section, ID, stud_stat, acct_stat};
                    model.addRow(tbData);
                    
                }
                
                con.close();

                System.out.println("Success");
            }
            catch(Exception ex){
                System.out.println("Invalid");
            }
         
            new Add();
        
        }
        else if(e.getSource()==bt_pay){
            
            Add.setBackground(new Color(204,255,204));
            Add.setForeground(Color.black);
            Add.setBorder(down);
            bt_payment.setBackground(new Color(204,255,204));
            bt_payment.setForeground(Color.black);
            bt_payment.setBorder(down);
            bt_payment.setEnabled(true);
            
            bt_pay.setBackground(new Color(0,153,51));
            bt_pay.setBorder(popup);
            bt_pay.setForeground(Color.white);
//            bt_pay.setEnabled(false);


modellist.setRowCount(0);
            try{
                
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment","root","root");

                Statement st= con.createStatement();

                String sql1="SELECT payment.*, concat (student.Lname,', ', student.Fname,' ',student.Mname) AS Name FROM payment,student WHERE payment.Stud_ID = student.Stud_ID";
                ResultSet rs1 =st.executeQuery(sql1);

                
                while(rs1.next()){
                    String id= String.valueOf(rs1.getString("Stud_ID"));
                    String Name= rs1.getString("Name");
                    String Down=String.valueOf(rs1.getString("Down"));
                    String Sept=String.valueOf(rs1.getString("Sept"));
                    String Oct = String.valueOf(rs1.getInt("Oct"));
                    String Nov = String.valueOf(rs1.getString("Nov"));
                    String Dece = String.valueOf(rs1.getString("Dece"));
                    String Jan = String.valueOf(rs1.getString("Jan"));
                    String Feb = String.valueOf(rs1.getInt("Feb"));
                    String Mar = String.valueOf(rs1.getInt("Mar"));
                    String Apr = String.valueOf(rs1.getString("Apr"));
                    String May = String.valueOf(rs1.getString("May"));
                    String Stat = String.valueOf(rs1.getString("Stat"));

                    
                    
                    String tbData1[]={id, Name, Down, Sept, Oct, Nov, Dece, Jan, Feb, Mar, Apr, May, Stat};
                    modellist.addRow(tbData1);
                }
                
                con.close();

                System.out.println("Success");
            }
            catch(Exception ex){
                System.out.println("Invalid");
            }
            
            new Payment_Record(); 

        }
        else if(e.getSource()==bt_payment){
            Add.setBackground(new Color(204,255,204));
            Add.setForeground(Color.black);
            Add.setBorder(down);
            bt_pay.setBackground(new Color(204,255,204));
            bt_pay.setForeground(Color.black);
            bt_pay.setBorder(down);
            bt_pay.setEnabled(true);
            
            bt_payment.setBackground(new Color(0,153,51));
            bt_payment.setBorder(popup);
            bt_payment.setForeground(Color.white);
//            bt_payment.setEnabled(false);

            
            identification=  JOptionPane.showInputDialog(null,"Please Enter Student ID: ");
            
            if(identification==null){
                
            }
            else if(!identification.isEmpty()){
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment","root","root");

                    Statement st= con.createStatement();

                    String sql="SELECT * FROM student WHERE Stud_ID="+identification;
                    ResultSet rs =st.executeQuery(sql);

                    if(rs.next()){
                        new payment();

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
        else if(e.getSource()==drop){
            new Archive();
        }
        else if(e.getSource()==logout){
            dispose();
            new Final();
        }
    }
}
