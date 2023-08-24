package pkgfinal;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.sql.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import static pkgfinal.User.ID;

public class Tuition extends JFrame{

    JPanel black;
    JLabel name, backgroundpay, gr, st, gd, ci, age, sn, sec, label, label2;
    JTextField txnm, txgr, txst, txgd, txci, txage, txsn, txsec;
    JTable table, table1;
    JTableHeader theader;
    
    String sem1[]={"Down Payment","September","October","November","December","Status"};
    String sem2[]={"January","February","March","April","May","Status"};
    
    String topay[][]= {{"6230","1480","1480","1480","1480","----------------------------------------"},
        {"","","","","",""}};
    String topay2[][]= {{"1630","1630","1630","1630","1630","----------------------------------------"},
        {"","","","","",""}};
    
    String Lname, Fname, Mname, Year, Age, Gender, Citizen, Strand, StrDesc, Section, id, stud_stat, acct_stat
            ,Down , Sept, Oct, Nov, Dece, Jan, Feb, Mar, Apr, May, Stat;
    
    
    Border line = BorderFactory.createLineBorder(Color.white,5);
    
    public Tuition() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment","root","root");

            String sql = "SELECT student.*, enrollment.*, payment.* FROM student,enrollment, payment WHERE student.Stud_ID = enrollment.Stud_ID AND student.Stud_ID= payment.Stud_ID AND student.Stud_ID="+ID;
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Lname= rs.getString("Lname");
                Fname= rs.getString("Fname");
                Mname= rs.getString("Mname");
                Year=rs.getString("Grd_lvl");
                Age = String.valueOf(rs.getInt("Age"));
                Gender = rs.getString("Gender");
                Citizen = rs.getString("Citizenship");
                Strand = rs.getString("StrandCode");
                Section = String.valueOf(rs.getInt("Section"));
                id= String.valueOf(rs.getInt("Stud_ID"));
                stud_stat = rs.getString("Status");
                acct_stat = rs.getString("Acct_stat");
                Down=String.valueOf(rs.getString("Down"));
                Sept=String.valueOf(rs.getString("Sept"));
                Oct = String.valueOf(rs.getInt("Oct"));
                Nov = String.valueOf(rs.getString("Nov"));
                Dece = String.valueOf(rs.getString("Dece"));
                Jan = String.valueOf(rs.getString("Jan"));
                Feb = String.valueOf(rs.getInt("Feb"));
                Mar = String.valueOf(rs.getInt("Mar"));
                Apr = String.valueOf(rs.getString("Apr"));
                May = String.valueOf(rs.getString("May"));
                Stat = String.valueOf(rs.getString("Stat"));
                
            }
            
            for (int i = 1; i < 2; i++) {
                for (int j = 0; j < 6; j++) {
                    if(j==0){
                        topay[i][j]=Down;
                        topay2[i][j]=Jan;
                    }
                    else if(j==1){
                        topay[i][j]=Sept;
                        topay2[i][j]=Feb;
                    }
                    else if(j==2){
                        topay[i][j]=Oct;
                        topay2[i][j]=Mar;
                    }
                    else if(j==3){
                        topay[i][j]=Nov;
                        topay2[i][j]=Apr;
                    }
                    else if(j==4){
                        topay[i][j]=Dece;
                        topay2[i][j]=May;
                    }
                    else if(j==5){
                        topay2[i][j]=Stat;               
                        if(Dece.equals("1480")){
                            topay[i][j]="Paid";
                        }
                    }
                }        
            }
            
            String sql1 = "SELECT StrandDesc FROM strand WHERE StrandCode = '"+Strand+"'";
            PreparedStatement pstmt1 = con.prepareStatement(sql1);
            ResultSet rs1 = pstmt1.executeQuery();
            
            while(rs1.next()){
                StrDesc = rs1.getString("StrandDesc");
            }

        
            setTitle("Tuition");
            ImageIcon icon = new ImageIcon("payment-icon.png");
            setIconImage(icon.getImage());

            //JLABEL

            name= new JLabel("Student Name:");
            name.setFont(new Font("Serif",Font.PLAIN,30));
            name.setBounds(30,50,200,50);
            name.setForeground(Color.white);
            add(name);
            
            gr= new JLabel("Grade Level:");
            gr.setFont(new Font("Serif",Font.PLAIN,30));
            gr.setBounds(30,110,200,50);
            gr.setForeground(Color.white);
            add(gr);

            st= new JLabel("Strand:");
            st.setFont(new Font("Serif",Font.PLAIN,30));
            st.setBounds(30,170,150,50);
            st.setForeground(Color.white);
            add(st);
            
            gd= new JLabel("Gender:");
            gd.setFont(new Font("Serif",Font.PLAIN,30));
            gd.setBounds(570,60,150,30);
            gd.setForeground(Color.white);
            add(gd);
                
            ci= new JLabel("Citizenship:");
            ci.setFont(new Font("Serif",Font.PLAIN,30));
            ci.setBounds(380,120,150,30);
            ci.setForeground(Color.white);
            add(ci);
                
            age= new JLabel("Age:");
            age.setFont(new Font("Serif",Font.PLAIN,30));
            age.setBounds(630,170,150,40);
            age.setForeground(Color.white);
            add(age);
            
            sn= new JLabel("Student Number:");
            sn.setFont(new Font("Serif",Font.PLAIN,30));
            sn.setBounds(820,55,250,40);
            sn.setForeground(Color.white);
            add(sn);
            
            sec= new JLabel("Section:");
            sec.setFont(new Font("Serif",Font.PLAIN,30));
            sec.setBounds(750,110,250,40);
            sec.setForeground(Color.white);
            add(sec);
            
            label= new JLabel("FIRST SEMESTER");
            label.setFont(new Font("Century Gothic",Font.ITALIC,40));
            label.setBounds(490,250,300,40);
            label.setForeground(Color.white);
            add(label);
            
            label2= new JLabel("SECOND SEMESTER");
            label2.setFont(new Font("Century Gothic",Font.ITALIC,40));
            label2.setBounds(450,400,400,40);
            label2.setForeground(Color.white);
            add(label2);
                
                
            
             //TXT

            txnm= new JTextField(Lname+", "+Fname+" "+Mname);
            txnm.setFont(new Font("Serif",Font.PLAIN,20));
            txnm.setBounds(220,60,300,30);
            txnm.setForeground(Color.black);
            txnm.setEditable(false);
            add(txnm);
            
            txgr= new JTextField(Year);
            txgr.setFont(new Font("Serif",Font.PLAIN,20));
            txgr.setBounds(220,120,100,30);
            txgr.setForeground(Color.black);
            txgr.setEditable(false);
            add(txgr);
            
            txst= new JTextField(StrDesc);
            txst.setFont(new Font("Serif",Font.PLAIN,20));
            txst.setBounds(150,180,450,30);
            txst.setForeground(Color.black);
            txst.setEditable(false);
            add(txst);
            
            txgd= new JTextField(Gender);
            txgd.setFont(new Font("Serif",Font.PLAIN,20));
            txgd.setBounds(680,60,100,30);
            txgd.setForeground(Color.black);
            txgd.setEditable(false);
            add(txgd);
            
            txci= new JTextField(Citizen);
            txci.setFont(new Font("Serif",Font.PLAIN,20));
            txci.setBounds(530,120,170,30);
            txci.setForeground(Color.black);
            txci.setEditable(false);
            add(txci);  
            
            txage= new JTextField(Age);
            txage.setFont(new Font("Serif",Font.PLAIN,20));
            txage.setBounds(700,180,50,30);
            txage.setForeground(Color.black);
            txage.setEditable(false);
            add(txage);
            
            txsn= new JTextField(id);
            txsn.setFont(new Font("Serif",Font.PLAIN,20));
            txsn.setBounds(1040,60,150,30);
            txsn.setForeground(Color.black);
            txsn.setEditable(false);
            add(txsn);
            
            txsec= new JTextField(Section);
            txsec.setFont(new Font("Serif",Font.PLAIN,20));
            txsec.setBounds(860,120,50,30);
            txsec.setForeground(Color.black);
            txsec.setEditable(false);
            add(txsec);
            
            
            
            //JTABLE
            
            DefaultTableModel model =new DefaultTableModel(topay, sem1);
            table = new JTable(model);
            table.setBackground(Color.LIGHT_GRAY);
            table.setForeground(Color.black);
            table.setRowHeight(20);
            JScrollPane pane = new JScrollPane(table);
            theader = table.getTableHeader();       //TABLE_HEADER
            theader.setBackground(new Color(0x226b2c));
            theader.setForeground(Color.white);
            pane.setBounds(130,300,1000,70);
            add(pane);
            
            DefaultTableModel model1 =new DefaultTableModel(topay2,sem2);
            table1 = new JTable(model1);
            table1.setBackground(Color.LIGHT_GRAY);
            table1.setForeground(Color.black);
            table1.setRowHeight(20);
            JScrollPane pane1 = new JScrollPane(table1);
            theader = table1.getTableHeader();       //TABLE_HEADER
            theader.setBackground(new Color(0x226b2c));
            theader.setForeground(Color.white);
            pane1.setBounds(130,450,1000,70);
            add(pane1);
            

            black = new JPanel();
            black.setLayout(null);
            black.setBounds(0,0,1255,610);
            black.setBorder(line);
            black.setBackground(new Color(0.0f,0.0f,0.0f,0.5f));
            black.setVisible(true);
            add(black);

            ImageIcon paymentIMG = new ImageIcon("mth.png");
            backgroundpay= new JLabel("",paymentIMG,JLabel.CENTER);
            backgroundpay.setBounds(0,0,1270,650);
            add(backgroundpay);

            setLocationRelativeTo(null);
            setLayout(null);
            setResizable(false);
            setVisible(true);
            setBounds(40, 40, 1270, 650);
        }catch(Exception e){
            
        }
    }
    
}
