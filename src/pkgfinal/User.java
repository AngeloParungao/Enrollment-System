package pkgfinal;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class User extends JFrame implements ActionListener{
    
    JTextField tx_us;
    JPasswordField tx_pass;
    JButton bt_login, exit;
    JLabel lb_admin, lb_user, lb_pass, lb_login, img;
    JPanel bgbox, side, us_panel;
    JLabel background;
    ImageIcon bg, icon, intro, logo;
    
    static int ID;
    
    int count=3;

    public User() {
        
        //border
        Border out = BorderFactory.createRaisedBevelBorder();
        Border in = BorderFactory.createEtchedBorder();
        Border lower = BorderFactory.createLoweredSoftBevelBorder();
        Border blackline = BorderFactory.createCompoundBorder(in, out);
        
        
        //panel
        bgbox = new JPanel();
        bgbox.setBackground(new Color(0.0f,0.5f,0.0f,0.3f));
        bgbox.setBounds(0,0,1500,900);
        bgbox.setLayout(null);
        this.add(bgbox);
      
        side = new JPanel();
        side.setBorder(blackline);
        side.setBackground(new Color(0.9f,0.9f,0.9f,0.8f));
        side.setBounds(850,50,480,580);
        side.setLayout(null);
        bgbox.add(side);
        
        us_panel= new JPanel();
        us_panel.setBorder(out);
        us_panel.setBackground(new Color(255,204,51));
        us_panel.setBounds(-7,30,200,50);
        us_panel.setLayout(null);
        bgbox.add(us_panel);
        
        //label
        lb_admin = new JLabel("STUDENT");
        lb_admin.setFont(new Font("Serif",Font.PLAIN,25));
        lb_admin.setBounds(45,0,150,50);
        lb_admin.setForeground(Color.black);
        us_panel.add(lb_admin);
        
        lb_login = new JLabel("LOGIN",JLabel.CENTER);
        lb_login.setFont(new Font("Century Gothic",Font.BOLD,40));
        lb_login.setForeground(Color.white);
        lb_login.setBounds(110,40,250,50);
        side.add(lb_login);
        
        lb_user= new JLabel("Enter Username:");
        lb_user.setFont(new Font("Serif",Font.PLAIN,23));
        lb_user.setForeground(Color.black);
        lb_user.setBounds(35,130,230,30);
        side.add(lb_user);
        
        lb_pass= new JLabel("Enter Password:");
        lb_pass.setFont(new Font("Serif",Font.PLAIN,23));
        lb_pass.setForeground(Color.black);
        lb_pass.setBounds(35,250,230,30);
        side.add(lb_pass);
        
        //txt
        
        tx_us = new JTextField();
        tx_us.setBounds(48,170,380,35);
        side.add(tx_us);
        
        tx_pass = new JPasswordField();
        tx_pass.setBounds(48,290,380,35);
        side.add(tx_pass);
        
        //button
        bt_login = new JButton("LOGIN");
        bt_login.setBounds(34,380,140,30);
        bt_login.setBorder(lower);
        bt_login.setBackground(new Color(0,153,51));
        bt_login.setFont(new Font("Serif",Font.PLAIN,20));
        bt_login.setForeground(Color.white);
        bt_login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        side.add(bt_login);
        
        exit = new JButton("CANCEL");
        exit.setBounds(34,430,140,30);
        exit.setBorder(lower);
        exit.setBackground(new Color(0xea8032));
        exit.setFont(new Font("Serif",Font.PLAIN,20));
        exit.setForeground(Color.white);
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        side.add(exit);
        
        //action
        bt_login.addActionListener(this);
        exit.addActionListener(this);
        
        //icon
        icon = new ImageIcon("AU_logo_green_emboss.png");
        this.setTitle("Student");
        this.setIconImage(icon.getImage());
        
        intro = new ImageIcon("ADEIA_logo_m_v_green.png");
        img =new JLabel();
        img.setVisible(true);
        img.setBounds(10,50,800,600);
        img.setIcon(intro);
        bgbox.add(img);
        
        logo = new ImageIcon("AU_logo.png");
        img =new JLabel();
        img.setVisible(true);
        img.setBounds(110,200,800,600);
        img.setIcon(logo);
        side.add(img);
        
        bg = new ImageIcon("bg.jpg");
        background= new JLabel("",bg,JLabel.CENTER);
        background.setBounds(0,0,1500,700);
        this.add(background);
        
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(500, 600));
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bt_login){
            String Us = tx_us.getText();
            String Ps = tx_pass.getText();
            int NUMBER=0;

            try{
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment","root","root");
          
                String sql = "SELECT Stud_ID, Status, Acct_stat, Username, Password FROM student WHERE Status = '"+"Student"+"'";
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet result = pstmt.executeQuery();
                
                String sql1 = "SELECT count(*) AS number FROM student WHERE Status = '"+"Student"+"'";
                PreparedStatement number = con.prepareStatement(sql1);
                ResultSet rs = number.executeQuery();
                
                while(rs.next()){
                NUMBER = rs.getInt("number");
                }
                
                if(Us.isEmpty() || Ps.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please Input Details");
                }
                else{
                    int inc =0;
                    while (result.next()){
                        String getName = result.getString("Username");
                        String getPass = result.getString("Password");
                        String getAcct = result.getString("Acct_stat");
                        
                        
                        inc++;
                        if(getName.equals(Us)){
                            if(getPass.equals(Ps)){
                                if(getAcct.equals("Blocked")){
                                    JOptionPane.showMessageDialog(null, "Account Has Been Blocked");
                                    break;
                                }
                                else{
                                    ID= result.getInt("Stud_ID");
                                    dispose();
                                    new User_Frame();
                                    break;
                                }
                            }
                            else{
                                if(count==3){
                                    JOptionPane.showMessageDialog(null, "Wrong Password");
                                    count--;
                                }
                                else if(count>0){
                                    JOptionPane.showMessageDialog(null, "Wrong Password \nRemaining attempt: "+count);
                                    count--;
                                    break;
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "Account Blocked Due to Multiple Login Attempts");
                                    PreparedStatement stm = con.prepareStatement("UPDATE student Set Acct_stat = '"+"Blocked"+"' WHERE Username ="+Us);
                                    stm.executeUpdate();
                                    break;
                                }
                            }
                        }
                        else if(NUMBER == inc){
                            JOptionPane.showMessageDialog(null, "Account Not Found");
                            tx_us.setText("");
                            tx_pass.setText("");
                            inc=0;
                            break;
                        }
                    }
                }
            }  
            catch(Exception ex){
                System.out.println("Invalid");
            }
        }
        else if(e.getSource()==exit){
            dispose();
            new Final();
        }
    }
    
}
