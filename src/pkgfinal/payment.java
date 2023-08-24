package pkgfinal;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import static pkgfinal.Admin_Frame.identification;


public class payment extends JFrame{

    static int topay[]={1480,1480,1480,1480,1630,1630,1630,1630,1630};
    int i, sum, n;
    String Month[]={"September", "October", "November", "December", "January", "February", "March", "April", "May"};
    String dbMonth[]={"Sept", "Oct", "Nov", "Dece", "Jan", "Feb", "Mar", "Apr", "May"};
    JLabel label, total, buwan,Name, lbID, lbGr, lbGender, lbCitizen, lbAge,  lbStrand, lbSec, background;
    JTextField name, txID, txGr, txGender, txCitizen, txAge, txStrand, txSec, txPay;
    JButton btPay;
    ImageIcon icon, bg;
    String col, Lname, Fname, Mname, Year, Age, Gender, Citizen, Strand, Section, ID, stud_stat, acct_stat;
    String num;
    
    public payment() {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment","root","root");

            Statement st= con.createStatement();

            String sql="SELECT Sept,Oct,Nov,Dece,Jan,Feb,Mar,Apr,May, Stat FROM payment WHERE Stud_ID="+identification;
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            while(rs.next()){
            String status=rs.getString("Stat");
            
            if(!(status.equals("Paid"))){
                for (i = 1; i < 12; i++) {
                    
                    col = rsmd.getColumnName(i);
                    String month = rs.getString(col);
                    if(month.equals("0")){
                        n = JOptionPane.showConfirmDialog(
                            null,
                            "Would you like to pay multiple months?",
                            "Payment Mode",
                            JOptionPane.YES_NO_OPTION);

                        if(n==JOptionPane.NO_OPTION){
                            pay();
                        }
                        else{
                            num=  JOptionPane.showInputDialog(null,"Please Enter Number of Months to pay: ");
                            
                            if(num==null){
                
                            }
                            else if(!num.isEmpty()){
                                if((10-i)>=Integer.parseInt(num)){
                                    for (int j = i; j < (Integer.parseInt(num)+i); j++) {
                                        sum+=topay[j-1];
                                    }
                                    multiple();
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"Exceeds the months that must be paid");
                                }

                            }
                        }
                        break;
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"This Student is Fully Paid");
                }
            }
            
        }
        catch(Exception ex){
            System.out.println("Invalid");
        }
    }

    private void pay() {
        Border up = BorderFactory.createRaisedBevelBorder();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment","root","root");

            Statement st= con.createStatement();
            String sql="SELECT student.*, enrollment.StrandCode, enrollment.Section, enrollment.Grd_lvl FROM student,enrollment WHERE student.Stud_ID = enrollment.Stud_ID AND student.Stud_ID="+identification;
        
            ResultSet rs =st.executeQuery(sql);

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
                ID= String.valueOf(rs.getInt("Stud_ID"));
                stud_stat = rs.getString("Status");
                acct_stat = rs.getString("Acct_stat");
            }


            //Label
        if(stud_stat.equals("Student")){
            label= new JLabel("PAYMENT");
            label.setFont(new Font("Serif",Font.PLAIN,50));
            label.setForeground(Color.white);
            label.setBounds(320,30,300,40);
            add(label);

            Name = new JLabel("Name: ");
            Name.setFont(new Font("Serif",Font.PLAIN,25));
            Name.setForeground(Color.white);
            Name.setBounds(40,100,150,40);
            add(Name);
            
            lbID = new JLabel("Student ID: ");
            lbID.setFont(new Font("Serif",Font.PLAIN,25));
            lbID.setForeground(Color.white);
            lbID.setBounds(40,160,150,40);
            add(lbID);
            
            lbGr = new JLabel("Grade Level: ");
            lbGr.setFont(new Font("Serif",Font.PLAIN,25));
            lbGr.setForeground(Color.white);
            lbGr.setBounds(40,220,150,40);
            add(lbGr);
            
            lbGender = new JLabel("Gender: ");
            lbGender.setFont(new Font("Serif",Font.PLAIN,25));
            lbGender.setForeground(Color.white);
            lbGender.setBounds(380,100,150,40);
            add(lbGender);
            
            lbCitizen = new JLabel("Citizenship: ");
            lbCitizen.setFont(new Font("Serif",Font.PLAIN,25));
            lbCitizen.setForeground(Color.white);
            lbCitizen.setBounds(320,160,150,40);
            add(lbCitizen);
            
            lbAge = new JLabel("Age: ");
            lbAge.setFont(new Font("Serif",Font.PLAIN,25));
            lbAge.setForeground(Color.white);
            lbAge.setBounds(330,220,150,40);
            add(lbAge);
            
            lbStrand = new JLabel("Strand: ");
            lbStrand.setFont(new Font("Serif",Font.PLAIN,25));
            lbStrand.setForeground(Color.white);
            lbStrand.setBounds(580,100,150,40);
            add(lbStrand);
            
            lbSec = new JLabel("Section: ");
            lbSec.setFont(new Font("Serif",Font.PLAIN,25));
            lbSec.setForeground(Color.white);
            lbSec.setBounds(580,160,150,40);
            add(lbSec);
            
            buwan = new JLabel(Month[i-1]);
            buwan.setFont(new Font("Serif",Font.PLAIN,35));
            buwan.setForeground(Color.white);
            buwan.setBounds(365,330,300,40);
            add(buwan);

            total = new JLabel("Total of: "+ topay[i-1]);
            total.setFont(new Font("Serif",Font.PLAIN,35));
            total.setForeground(Color.white);
            total.setBounds(340,380,300,40);
            add(total);


            
            
            //TextFields

            name= new JTextField(Lname+", "+Fname+" "+Mname);
            name.setEditable(false);
            name.setFont(new Font("Serif",Font.PLAIN,18));
            name.setBounds(120,100,230,40);
            add(name);
            
            txID= new JTextField(ID);
            txID.setEditable(false);
            txID.setFont(new Font("Serif",Font.PLAIN,18));
            txID.setBounds(170,160,100,40);
            add(txID);

            txGr= new JTextField(Year);
            txGr.setEditable(false);
            txGr.setFont(new Font("Serif",Font.PLAIN,18));
            txGr.setBounds(190,220,100,40);
            add(txGr);
            
            txGender= new JTextField(Gender);
            txGender.setEditable(false);
            txGender.setFont(new Font("Serif",Font.PLAIN,18));
            txGender.setBounds(470,100,80,40);
            add(txGender);
            
            txCitizen= new JTextField(Citizen);
            txCitizen.setEditable(false);
            txCitizen.setFont(new Font("Serif",Font.PLAIN,18));
            txCitizen.setBounds(450,160,100,40);
            add(txCitizen);
            
            txAge= new JTextField(Age);
            txAge.setEditable(false);
            txAge.setFont(new Font("Serif",Font.PLAIN,18));
            txAge.setBounds(390,220,100,40);
            add(txAge);
            
            txStrand= new JTextField(Strand);
            txStrand.setEditable(false);
            txStrand.setFont(new Font("Serif",Font.PLAIN,18));
            txStrand.setBounds(680,100,100,40);
            add(txStrand);
            
            txSec= new JTextField(Section);
            txSec.setEditable(false);
            txSec.setFont(new Font("Serif",Font.PLAIN,18));
            txSec.setBounds(680,160,50,40);
            add(txSec);
            
            txPay= new JTextField();
            txPay.setFont(new Font("Serif",Font.PLAIN,18));
            txPay.setBounds(365,440,150,40);
            add(txPay);
            
            
            
            //JButton
            
            btPay= new JButton("PAY");
            btPay.setBounds(315,500,250,40);
            btPay.setBorder(up);
            btPay.setFont(new Font("Serif", Font.BOLD, 20));
            btPay.setForeground(Color.white);
            btPay.setBackground(new Color(0x226b2c));
            btPay.setCursor(new Cursor(Cursor.HAND_CURSOR));
            add(btPay);
            
            btPay.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        if(Integer.parseInt(txPay.getText())>= topay[i-1]){
                            int pls = topay[i-1];
                            String pls2 = dbMonth[i-1];
                            PreparedStatement pay = con.prepareStatement("UPDATE payment SET "+dbMonth[i-1]+"=?  WHERE Stud_ID ="+identification);    
                            pay.setInt(1,pls);

                            if(pls2.equals("May")){
                                PreparedStatement stat = con.prepareStatement("UPDATE payment SET Stat=?  WHERE Stud_ID ="+identification);    
                                stat.setString(1, "Paid");
                                stat.executeUpdate();
                            }
                            dispose();
                            int change=Math.abs(pls-Integer.parseInt(txPay.getText()));
                            JOptionPane.showMessageDialog(null, "Your change is: "+change);
                            JOptionPane.showMessageDialog(null, "         Payment Successful");

                            
                            pay.executeUpdate();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "         Invalid Payment");
                        }
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "         Invalid Payment");
                    }
                }
                
            });


            //ICON
            icon = new ImageIcon("AU_logo_green_emboss.png");
            this.setTitle("Payment");
            this.setIconImage(icon.getImage());
            
            bg = new ImageIcon("payment_bg.png");
            background= new JLabel("",bg,JLabel.CENTER);
            background.setBounds(0,0,900,650);
            this.add(background);

            
            setLayout(null);
            setBounds(350,40,900,650);
            setVisible(true);
            }
        else{
            JOptionPane.showMessageDialog(null, "This Student is dropped");
            }
        }
        catch(Exception ex){
            System.out.println("Invalid");
        }
    }

    private void multiple() {
        Border up = BorderFactory.createRaisedBevelBorder();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment","root","root");

            Statement st= con.createStatement();
            String sql="SELECT student.*, enrollment.StrandCode, enrollment.Section, enrollment.Grd_lvl FROM student,enrollment WHERE student.Stud_ID = enrollment.Stud_ID AND student.Stud_ID="+identification;
        
            ResultSet rs =st.executeQuery(sql);

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
                ID= String.valueOf(rs.getInt("Stud_ID"));
                stud_stat = rs.getString("Status");
                acct_stat = rs.getString("Acct_stat");
            }


            //Label
            if(stud_stat.equals("Student")){
                label= new JLabel("PAYMENT");
                label.setFont(new Font("Serif",Font.PLAIN,50));
                label.setForeground(Color.white);
                label.setBounds(320,30,300,40);
                add(label);

                Name = new JLabel("Name: ");
                Name.setFont(new Font("Serif",Font.PLAIN,25));
                Name.setForeground(Color.white);
                Name.setBounds(40,100,150,40);
                add(Name);

                lbID = new JLabel("Student ID: ");
                lbID.setFont(new Font("Serif",Font.PLAIN,25));
                lbID.setForeground(Color.white);
                lbID.setBounds(40,160,150,40);
                add(lbID);

                lbGr = new JLabel("Grade Level: ");
                lbGr.setFont(new Font("Serif",Font.PLAIN,25));
                lbGr.setForeground(Color.white);
                lbGr.setBounds(40,220,150,40);
                add(lbGr);

                lbGender = new JLabel("Gender: ");
                lbGender.setFont(new Font("Serif",Font.PLAIN,25));
                lbGender.setForeground(Color.white);
                lbGender.setBounds(380,100,150,40);
                add(lbGender);

                lbCitizen = new JLabel("Citizenship: ");
                lbCitizen.setFont(new Font("Serif",Font.PLAIN,25));
                lbCitizen.setForeground(Color.white);
                lbCitizen.setBounds(320,160,150,40);
                add(lbCitizen);

                lbAge = new JLabel("Age: ");
                lbAge.setFont(new Font("Serif",Font.PLAIN,25));
                lbAge.setForeground(Color.white);
                lbAge.setBounds(330,220,150,40);
                add(lbAge);

                lbStrand = new JLabel("Strand: ");
                lbStrand.setFont(new Font("Serif",Font.PLAIN,25));
                lbStrand.setForeground(Color.white);
                lbStrand.setBounds(580,100,150,40);
                add(lbStrand);

                lbSec = new JLabel("Section: ");
                lbSec.setFont(new Font("Serif",Font.PLAIN,25));
                lbSec.setForeground(Color.white);
                lbSec.setBounds(580,160,150,40);
                add(lbSec);

                buwan = new JLabel(Month[i-1]+" to "+Month[i-2+Integer.parseInt(num)]);
                buwan.setFont(new Font("Serif",Font.PLAIN,35));
                buwan.setForeground(Color.white);
                buwan.setBounds(280,330,500,40);
                add(buwan);

                total = new JLabel("Total of: "+ sum);
                total.setFont(new Font("Serif",Font.PLAIN,35));
                total.setForeground(Color.white);
                total.setBounds(340,380,300,40);
                add(total);




                //TextFields

                name= new JTextField(Lname+", "+Fname+" "+Mname);
                name.setEditable(false);
                name.setFont(new Font("Serif",Font.PLAIN,18));
                name.setBounds(120,100,230,40);
                add(name);

                txID= new JTextField(ID);
                txID.setEditable(false);
                txID.setFont(new Font("Serif",Font.PLAIN,18));
                txID.setBounds(170,160,100,40);
                add(txID);

                txGr= new JTextField(Year);
                txGr.setEditable(false);
                txGr.setFont(new Font("Serif",Font.PLAIN,18));
                txGr.setBounds(190,220,100,40);
                add(txGr);

                txGender= new JTextField(Gender);
                txGender.setEditable(false);
                txGender.setFont(new Font("Serif",Font.PLAIN,18));
                txGender.setBounds(470,100,80,40);
                add(txGender);

                txCitizen= new JTextField(Citizen);
                txCitizen.setEditable(false);
                txCitizen.setFont(new Font("Serif",Font.PLAIN,18));
                txCitizen.setBounds(450,160,100,40);
                add(txCitizen);

                txAge= new JTextField(Age);
                txAge.setEditable(false);
                txAge.setFont(new Font("Serif",Font.PLAIN,18));
                txAge.setBounds(390,220,100,40);
                add(txAge);

                txStrand= new JTextField(Strand);
                txStrand.setEditable(false);
                txStrand.setFont(new Font("Serif",Font.PLAIN,18));
                txStrand.setBounds(680,100,100,40);
                add(txStrand);

                txSec= new JTextField(Section);
                txSec.setEditable(false);
                txSec.setFont(new Font("Serif",Font.PLAIN,18));
                txSec.setBounds(680,160,50,40);
                add(txSec);

                txPay= new JTextField();
                txPay.setFont(new Font("Serif",Font.PLAIN,18));
                txPay.setBounds(365,440,150,40);
                add(txPay);



                //JButton

                btPay= new JButton("PAY");
                btPay.setBounds(315,500,250,40);
                btPay.setBorder(up);
                btPay.setFont(new Font("Serif", Font.BOLD, 20));
                btPay.setForeground(Color.white);
                btPay.setBackground(new Color(0x226b2c));
                btPay.setCursor(new Cursor(Cursor.HAND_CURSOR));
                add(btPay);

                btPay.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            if(Integer.parseInt(txPay.getText())>= sum){
                                int j = i;
                                while (j<(i+Integer.parseInt(num))) {
                                    PreparedStatement pay = con.prepareStatement("UPDATE payment SET "+dbMonth[j-1]+"=?  WHERE Stud_ID ="+identification);    
                                    pay.setInt(1,topay[j-1]);

                                    pay.executeUpdate();

                                    if(dbMonth[j-1].equals("May")){
                                        PreparedStatement stat = con.prepareStatement("UPDATE payment SET Stat=?  WHERE Stud_ID ="+identification);    
                                        stat.setString(1, "Paid");
                                        stat.executeUpdate();
                                    }
                                    j++;
                                }

                                dispose();
                                int change=Math.abs(sum-Integer.parseInt(txPay.getText()));
                                JOptionPane.showMessageDialog(null, "Your change is: "+change);
                                JOptionPane.showMessageDialog(null, "         Payment Successful");

                            }
                            else{
                                JOptionPane.showMessageDialog(null, "         Invalid Payment");
                            }
                        }catch(Exception ex){
                            JOptionPane.showMessageDialog(null, "         Invalid Payment");
                        }
                    }

                });


                //ICON
                icon = new ImageIcon("AU_logo_green_emboss.png");
                this.setTitle("Payment");
                this.setIconImage(icon.getImage());

                bg = new ImageIcon("payment_bg.png");
                background= new JLabel("",bg,JLabel.CENTER);
                background.setBounds(0,0,900,650);
                this.add(background);


                setLayout(null);
                setBounds(350,40,900,650);
                setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "This Student is dropped");
                }
            }
        catch(Exception ex){
            System.out.println("Invalid");
        }
    }
    
}
