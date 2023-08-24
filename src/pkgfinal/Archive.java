package pkgfinal;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import static pkgfinal.Add.model;

public class Archive extends JFrame{
    
    JLabel label;
    JButton exit, undo;
    JTable droplist = new JTable();
    JTable droplist1 = new JTable();
    JTableHeader theader1, theader;
    String col[]={"Last Name"," First Name","Middle Name","Grade level","Age","Gender","Citizenship","Strand","Section","Student No.","Status","Account"};;
    String col1[]={"Student No.","Name","Down","September","October","November","December","January","February","March","April","May","Status"};
    String list[][] = new String [0][12];
    String list1[][] = new String [0][12];
    DefaultTableModel mlist = new DefaultTableModel(list,col) ;
    DefaultTableModel mlist1 = new DefaultTableModel(list1,col1) ;
    JScrollPane pane = new JScrollPane(droplist);
    JScrollPane pane1 = new JScrollPane(droplist1);

    public Archive() {
        
        Border down = BorderFactory.createLoweredBevelBorder();
        
        label= new JLabel("ARCHIVE");
        label.setFont(new Font("Serif",Font.PLAIN,50));
        label.setBounds(580,20,250,50);
        label.setForeground(Color.white);
        add(label);
            
        mlist.setRowCount(0);
        mlist1.setRowCount(0);
        try{
                
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment","root","root");

                Statement st= con.createStatement();

                String sql="SELECT * FROM archive";
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
                    String user = rs.getString("Username");
                    String pass = rs.getString("Password");
                    String Down = String.valueOf(rs.getInt("Down"));
                    String Sept = String.valueOf(rs.getInt("Sept"));
                    String Oct = String.valueOf(rs.getInt("Oct"));
                    String Nov = String.valueOf(rs.getInt("Nov"));
                    String Dece = String.valueOf(rs.getInt("Dece"));
                    String Jan = String.valueOf(rs.getInt("Jan"));
                    String Feb = String.valueOf(rs.getInt("Feb"));
                    String Mar = String.valueOf(rs.getInt("Mar"));
                    String Apr = String.valueOf(rs.getInt("Apr"));
                    String May = String.valueOf(rs.getInt("May"));
                    String Stat = rs.getString("Stat");
                    

                    String name = Lname+", "+Fname+" "+Mname;
                    
                    String tbData[]={Lname, Fname, Mname, Year, Age, Gender, Citizen, Strand, Section, ID, stud_stat, acct_stat};
                    String tbData2[]={ID, name, Down, Sept, Oct, Nov, Dece, Jan, Feb, Mar, Apr, May, Stat};
                    mlist.addRow(tbData);
                    mlist1.addRow(tbData2);
                }
                
                con.close();

                System.out.println("Success");
            }
            catch(Exception ex){
                System.out.println("Invalid");
            }
        
        mlist.setColumnIdentifiers(col);
        theader = droplist.getTableHeader();       //TABLE_HEADER
        theader.setFont(new Font("Dialog",Font.ITALIC, 14));
        theader.setBackground(new Color(0x226b2c));
        theader.setForeground(Color.white);
        droplist.setModel(mlist);
        droplist.setGridColor(Color.gray);
        droplist.setBackground(new Color(204,204,204));
        droplist.setForeground(Color.black);
        droplist.setFont(new Font("",Font.CENTER_BASELINE, 16));
        droplist.setRowHeight(25);
        
        droplist.getColumnModel().getColumn(11).setPreferredWidth(100);
        
        pane.setBounds(60, 100, 1250, 250);
        pane.setOpaque(false);
        add(pane);
        
        mlist1.setColumnIdentifiers(col1);
        theader1 = droplist1.getTableHeader();       //TABLE_HEADER
        theader1.setFont(new Font("Dialog",Font.ITALIC, 14));
        theader1.setBackground(new Color(0x226b2c));
        theader1.setForeground(Color.white);
        droplist1.setModel(mlist1);
        droplist1.setGridColor(Color.gray);
        droplist1.setBackground(new Color(204,204,204));
        droplist1.setForeground(Color.black);
        droplist1.setFont(new Font("",Font.CENTER_BASELINE, 16));
        droplist1.setRowHeight(25);
        
        droplist1.getColumnModel().getColumn(1).setPreferredWidth(200);
        
        pane1.setBounds(60, 390, 1250, 250);
        pane1.setOpaque(false);
        add(pane1);
        
//        undo= new JButton("Undrop");
//        undo.setFont(new Font("Minion Variable Concept",Font.PLAIN,17));
//        undo.setForeground(Color.white);
//        undo.setBorder(down);
//        undo.setBackground(new Color(0xea8032));
//        undo.setBounds(1000, 680, 120,40);
//        undo.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        add(undo);
//        
//        undo.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(droplist.getSelectedRowCount()==1){
//                    int id = Integer.parseInt(droplist.getValueAt(droplist.getSelectedRow(), 9).toString());
//                
//                    JFrame auth= new JFrame("Admin Authentication");
//                    ImageIcon icon = new ImageIcon("AU_logo_green.png");
//                    auth.setIconImage(icon.getImage());
//
//                    label= new JLabel("AUTHENTICATION");
//                    label.setBounds(35,30,300,50);
//                    label.setFont(new Font("POPPINS", Font.BOLD, 26));
//                    label.setForeground(Color.white);
//                    auth.add(label);
//
//                    JLabel un = new JLabel("Username:");
//                    un.setBounds(25,110, 230,30);
//                    un.setForeground(Color.white);
//                    un.setFont(new Font("Minion Variable Concept",Font.PLAIN,18));
//                    auth.add(un);
//
//                    JTextField txt_un = new JTextField();
//                    txt_un.setBounds(25,140,250,30);
//                    auth.add(txt_un);
//
//                    JLabel pw = new JLabel("Password:");
//                    pw.setBounds(25,190,230,30);
//                    pw.setForeground(Color.white);
//                    pw.setFont(new Font("Minion Variable Concept",Font.PLAIN,18));
//                    auth.add(pw);
//
//                    JPasswordField txt_pw = new JPasswordField();
//                    txt_pw.setBounds(25,220,250,30);
//                    auth.add(txt_pw);
//
//                    JButton authentication= new JButton("SAVE");
//                    authentication.setBounds(25,300,250,30);
//                    authentication.setFont(new Font("Serif", Font.BOLD, 15));
//                    authentication.setForeground(Color.white);
//                    authentication.setBackground(new Color(0x226b2c));
//                    authentication.setCursor(new Cursor(Cursor.HAND_CURSOR));
//                    auth.add(authentication);
//                    authentication.addActionListener(new ActionListener(){
//                        @Override
//                            public void actionPerformed(ActionEvent e) {
//                                if(txt_un.getText().equals("Admin")&&txt_pw.getText().equals("admin")){
//                                    auth.dispose();
//                                    try{
//
//                                        Class.forName("com.mysql.cj.jdbc.Driver");
//
//                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment","root","root");
//
//                                        Statement st= con.createStatement();
//
//                                        PreparedStatement undrop = con.prepareStatement("UPDATE archive SET Status = ?, Acct_stat = ? WHERE Stud_ID = "+id);
//                                        undrop.setString(1, "Student");
//                                        undrop.setString(2, "Accessible");
//                                        undrop.executeUpdate();
//
//                                        String sql1="SELECT * FROM archive WHERE Stud_ID="+id;
//                                        ResultSet rs1 =st.executeQuery(sql1);
//
//
//                                        while(rs1.next()){
//                                            String Lname= rs1.getString("Lname");
//                                            String Fname=rs1.getString("Fname");
//                                            String Mname=rs1.getString("Mname");
//                                            String Year=rs1.getString("Grd_lvl");
//                                            String Age = String.valueOf(rs1.getInt("Age"));
//                                            String Gender = rs1.getString("Gender");
//                                            String Citizen = rs1.getString("Citizenship");
//                                            String Strand = rs1.getString("StrandCode");
//                                            String Section = String.valueOf(rs1.getInt("Section"));
//                                            String ID= String.valueOf(rs1.getInt("Stud_ID"));
//                                            String stud_stat = rs1.getString("Status");
//                                            String acct_stat = rs1.getString("Acct_stat");
//                                            String user = rs1.getString("Username");
//                                            String pass = rs1.getString("Password");
//                                            String Down = String.valueOf(rs1.getInt("Down"));
//                                            String Sept = String.valueOf(rs1.getInt("Sept"));
//                                            String Oct = String.valueOf(rs1.getInt("Oct"));
//                                            String Nov = String.valueOf(rs1.getInt("Nov"));
//                                            String Dece = String.valueOf(rs1.getInt("Dece"));
//                                            String Jan = String.valueOf(rs1.getInt("Jan"));
//                                            String Feb = String.valueOf(rs1.getInt("Feb"));
//                                            String Mar = String.valueOf(rs1.getInt("Mar"));
//                                            String Apr = String.valueOf(rs1.getInt("Apr"));
//                                            String May = String.valueOf(rs1.getInt("May"));
//                                            String Stat = rs1.getString("Stat");
//
//                                            PreparedStatement stm = con.prepareStatement("INSERT INTO student(Lname,Fname,Mname, Age, Gender, Citizenship, Stud_ID, Status, Acct_stat, Username, Password)"
//                                                                    +"VALUES('"+Lname+"','"+Fname+"','"+Mname+"','"+Age+"','"+Gender+"','"+Citizen+"','"+ID+"','"+stud_stat+"','"+acct_stat+"','"+user+"','"+pass+"')");
//
//                                            PreparedStatement stm2 = con.prepareStatement("INSERT INTO enrollment(Stud_ID, StrandCode, Section, Grd_lvl)"
//                                                                    +"VALUES('"+ID+"','"+Strand+"','"+Section+"','"+Year+"')");
//
//                                            PreparedStatement stm3 = con.prepareStatement("INSERT INTO payment(Stud_ID, Down, Sept, Oct, Nov, Dece, Jan, Feb, Mar, Apr, May, Stat)"
//                                                                    +"VALUES('"+ID+"','"+Down+"','"+Sept+"','"+Oct+"','"+Nov+"','"+Dece+"','"+Jan+"','"+Feb+"','"+Mar+"','"+Apr+"','"+May+"','"+Stat+"')");
//
//                                            stm.executeUpdate();
//                                            stm2.executeUpdate();
//                                            stm3.executeUpdate();
//
//
//                                        }
//                                        PreparedStatement del = con.prepareStatement("DELETE FROM archive WHERE Stud_ID = "+id);
//
//                                        del.executeUpdate();
//
//
//                                        con.close();
//
//                                        dispose();
//                                        JOptionPane.showMessageDialog(null, "Successfully Updated");
//                                        System.out.println("Success");
//                                    }
//                                    catch(Exception ex){
//                                        System.out.println("Invalid");
//                                    }
//                                }
//                                else if(!(txt_un.getText().equals("Admin")&&txt_pw.getText().equals("admin"))){
//                                    JOptionPane.showMessageDialog(null, "Wrong Username and Password");
//                                    txt_un.setText("");
//                                    txt_pw.setText("");
//                                }
//                                else if(txt_un.getText().equals("")&&txt_pw.getText().equals("")){
//                                    JOptionPane.showMessageDialog(null, "Please Input Details");
//                                }
//                            }
//                        });
//                        ImageIcon authBG = new ImageIcon("auth_bg.png");
//                        JLabel backgroundAUTH= new JLabel("",authBG,JLabel.CENTER);
//                        backgroundAUTH.setBounds(0,0,320,400);
//                        auth.add(backgroundAUTH);
//                    
//                        auth.setBounds(520,150,320,400);
//                        auth.setLayout(null);
//                        auth.setVisible(true);
//                    }
//                            
//                else if(droplist1.getSelectedRowCount()==1){
//                    int id1 = Integer.parseInt(droplist1.getValueAt(droplist1.getSelectedRow(), 0).toString());
//                
//                    JFrame auth= new JFrame("Admin Authentication");
//                    ImageIcon icon = new ImageIcon("AU_logo_green.png");
//                    auth.setIconImage(icon.getImage());
//
//                    label= new JLabel("AUTHENTICATION");
//                    label.setBounds(35,30,300,50);
//                    label.setFont(new Font("POPPINS", Font.BOLD, 26));
//                    label.setForeground(Color.white);
//                    auth.add(label);
//
//                    JLabel un = new JLabel("Username:");
//                    un.setBounds(25,110, 230,30);
//                    un.setForeground(Color.white);
//                    un.setFont(new Font("Minion Variable Concept",Font.PLAIN,18));
//                    auth.add(un);
//
//                    JTextField txt_un = new JTextField();
//                    txt_un.setBounds(25,140,250,30);
//                    auth.add(txt_un);
//
//                    JLabel pw = new JLabel("Password:");
//                    pw.setBounds(25,190,230,30);
//                    pw.setForeground(Color.white);
//                    pw.setFont(new Font("Minion Variable Concept",Font.PLAIN,18));
//                    auth.add(pw);
//
//                    JPasswordField txt_pw = new JPasswordField();
//                    txt_pw.setBounds(25,220,250,30);
//                    auth.add(txt_pw);
//
//                    JButton authentication= new JButton("SAVE");
//                    authentication.setBounds(25,300,250,30);
//                    authentication.setFont(new Font("Serif", Font.BOLD, 15));
//                    authentication.setForeground(Color.white);
//                    authentication.setBackground(new Color(0x226b2c));
//                    authentication.setCursor(new Cursor(Cursor.HAND_CURSOR));
//                    auth.add(authentication);
//                    authentication.addActionListener(new ActionListener(){
//                        @Override
//                            public void actionPerformed(ActionEvent e) {
//                                if(txt_un.getText().equals("Admin")&&txt_pw.getText().equals("admin")){
//                                    auth.dispose();
//                                try{
//
//                                    Class.forName("com.mysql.cj.jdbc.Driver");
//
//                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment","root","root");
//
//                                    Statement st= con.createStatement();
//
//                                    PreparedStatement undrop = con.prepareStatement("UPDATE archive SET Status = ?, Acct_stat = ? WHERE Stud_ID = "+id1);
//                                    undrop.setString(1, "Student");
//                                    undrop.setString(2, "Accessible");
//                                    undrop.executeUpdate();
//
//                                    String sql1="SELECT * FROM archive WHERE Stud_ID="+id1;
//                                    ResultSet rs1 =st.executeQuery(sql1);
//
//
//                                    while(rs1.next()){
//                                        String Lname= rs1.getString("Lname");
//                                        String Fname=rs1.getString("Fname");
//                                        String Mname=rs1.getString("Mname");
//                                        String Year=rs1.getString("Grd_lvl");
//                                        String Age = String.valueOf(rs1.getInt("Age"));
//                                        String Gender = rs1.getString("Gender");
//                                        String Citizen = rs1.getString("Citizenship");
//                                        String Strand = rs1.getString("StrandCode");
//                                        String Section = String.valueOf(rs1.getInt("Section"));
//                                        String ID= String.valueOf(rs1.getInt("Stud_ID"));
//                                        String stud_stat = rs1.getString("Status");
//                                        String acct_stat = rs1.getString("Acct_stat");
//                                        String user = rs1.getString("Username");
//                                        String pass = rs1.getString("Password");
//                                        String Down = String.valueOf(rs1.getInt("Down"));
//                                        String Sept = String.valueOf(rs1.getInt("Sept"));
//                                        String Oct = String.valueOf(rs1.getInt("Oct"));
//                                        String Nov = String.valueOf(rs1.getInt("Nov"));
//                                        String Dece = String.valueOf(rs1.getInt("Dece"));
//                                        String Jan = String.valueOf(rs1.getInt("Jan"));
//                                        String Feb = String.valueOf(rs1.getInt("Feb"));
//                                        String Mar = String.valueOf(rs1.getInt("Mar"));
//                                        String Apr = String.valueOf(rs1.getInt("Apr"));
//                                        String May = String.valueOf(rs1.getInt("May"));
//                                        String Stat = rs1.getString("Stat");
//
//                                        PreparedStatement stm = con.prepareStatement("INSERT INTO student(Lname,Fname,Mname, Age, Gender, Citizenship, Stud_ID, Status, Acct_stat, Username, Password)"
//                                                                +"VALUES('"+Lname+"','"+Fname+"','"+Mname+"','"+Age+"','"+Gender+"','"+Citizen+"','"+ID+"','"+stud_stat+"','"+acct_stat+"','"+user+"','"+pass+"')");
//
//                                        PreparedStatement stm2 = con.prepareStatement("INSERT INTO enrollment(Stud_ID, StrandCode, Section, Grd_lvl)"
//                                                                +"VALUES('"+ID+"','"+Strand+"','"+Section+"','"+Year+"')");
//
//                                        PreparedStatement stm3 = con.prepareStatement("INSERT INTO payment(Stud_ID, Down, Sept, Oct, Nov, Dece, Jan, Feb, Mar, Apr, May, Stat)"
//                                                                +"VALUES('"+ID+"','"+Down+"','"+Sept+"','"+Oct+"','"+Nov+"','"+Dece+"','"+Jan+"','"+Feb+"','"+Mar+"','"+Apr+"','"+May+"','"+Stat+"')");
//
//                                        stm.executeUpdate();
//                                        stm2.executeUpdate();
//                                        stm3.executeUpdate();
//
//
//                                    }
//                                    PreparedStatement del = con.prepareStatement("DELETE FROM archive WHERE Stud_ID = "+id1);
//
//                                    del.executeUpdate();
//
//
//                                    con.close();
//
//                                    dispose();
//                                    JOptionPane.showMessageDialog(null, "Successfully Updated");
//                                    System.out.println("Success");
//                                }
//                                catch(Exception ex){
//                                    System.out.println("Invalid");
//                                }
//                            }
//                                else if(!(txt_un.getText().equals("Admin")&&txt_pw.getText().equals("admin"))){
//                                    JOptionPane.showMessageDialog(null, "Wrong Username and Password");
//                                    txt_un.setText("");
//                                    txt_pw.setText("");
//                                }
//                                else if(txt_un.getText().equals("")&&txt_pw.getText().equals("")){
//                                    JOptionPane.showMessageDialog(null, "Please Input Details");
//                                }
//                            }
//                        });
//                        ImageIcon authBG = new ImageIcon("auth_bg.png");
//                        JLabel backgroundAUTH= new JLabel("",authBG,JLabel.CENTER);
//                        backgroundAUTH.setBounds(0,0,320,400);
//                        auth.add(backgroundAUTH);
//                    
//                        auth.setBounds(520,150,320,400);
//                        auth.setLayout(null);
//                        auth.setVisible(true);
//                }
//                else{
//                    JOptionPane.showMessageDialog(null, "No Selected Row");
//                }
//                
//            }
//            
//        });
        
        exit= new JButton("Cancel");
        exit.setFont(new Font("Minion Variable Concept",Font.PLAIN,17));
        exit.setForeground(Color.white);
        exit.setBorder(down);
        exit.setBackground(new Color(0xea8032));
        exit.setBounds(1150, 680, 120,40);
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(exit);

        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }

        });
        
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        setBackground(new Color(0.0f,0.0f,0.0f,0.8f));
    }
    
}
