package pkgfinal;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Admin extends JFrame implements ActionListener{
    
    JTextField tx_ad;
    JPasswordField tx_pass;
    JButton bt_login, exit;
    JLabel lb_admin, lb_user, lb_pass, lb_login, img;
    JPanel bgbox, side, ad_panel;
    JLabel background;
    ImageIcon bg, icon, intro, logo;
    
    public Admin(){
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
        
        ad_panel= new JPanel();
        ad_panel.setBorder(out);
        ad_panel.setBackground(new Color(255,204,51));
        ad_panel.setBounds(-7,30,200,50);
        ad_panel.setLayout(null);
        bgbox.add(ad_panel);
        
        //label
        lb_admin = new JLabel("ADMIN");
        lb_admin.setFont(new Font("Serif",Font.PLAIN,25));
        lb_admin.setBounds(55,0,100,50);
        lb_admin.setForeground(Color.black);
        ad_panel.add(lb_admin);
        
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
        
        tx_ad = new JTextField();
        tx_ad.setBounds(48,170,380,35);
        side.add(tx_ad);
        
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
        this.setTitle("Admin");
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
            String Ad = tx_ad.getText();
            String Ps = tx_pass.getText();

            if(Ad.equals("") && Ps.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Input Details");
                }
            else if(Ad.equals("Admin") && Ps.equals("admin")){
                dispose();
                new Admin_Frame();
            }
            else{
                JOptionPane.showMessageDialog(null, "Incorrect Details");
                tx_ad.setText("");
                tx_pass.setText("");
            }
        }
        else if(e.getSource()==exit){
            dispose();
            new Final();
        }
    }
}
