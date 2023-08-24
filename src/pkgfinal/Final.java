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
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Final extends JFrame {
    
    JPanel rect, invi;
    ImageIcon icon, center, bg;
    JLabel logo, background, scname;
    JButton admin,user;
    
    public Final(){
        

        //border
        Border blackline = BorderFactory.createLoweredBevelBorder();
        Border out = BorderFactory.createRaisedBevelBorder();
        Border line = BorderFactory.createLineBorder(Color.white, 20);
        
        
        //JLabel
        scname= new JLabel("ADEIA UNIVERSITY",JLabel.CENTER);
        scname.setFont(new Font("Serif",Font.PLAIN,60));
        scname.setForeground(Color.white);
        scname.setBounds(385,340,580,50);
        this.add(scname);
        
        //JButton
        admin= new JButton("ADMIN");
        admin.setBounds(600,420,150,40);
        admin.setBorder(blackline);
        admin.setBackground(new Color(0x226b2c));
        admin.setFont(new Font("Serif",Font.PLAIN,23));
        admin.setForeground(Color.white);
        admin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(admin);
        admin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Admin();
            }
            
        });
        
        user= new JButton("STUDENT");
        user.setBackground(new Color(0xea8032));
        user.setBounds(600,480,150,40);
        user.setBorder(blackline);
        user.setFont(new Font("Serif",Font.PLAIN,23));
        user.setForeground(Color.white);
        user.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(user);
        user.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new User();
            }
            
        });
        
        //icon
        center = new ImageIcon("AU_logo_green_emboss.png");
        logo =new JLabel();
        logo.setVisible(true);
        logo.setBounds(575,130,300,200);
        logo.setIcon(center);
        this.add(logo);
        
        icon = new ImageIcon("AU_logo_green_emboss.png");
        this.setTitle("ADEIA University");
        this.setIconImage(icon.getImage());
        
        bg = new ImageIcon("BG1.png");
        background= new JLabel("",bg,JLabel.CENTER);
        background.setBounds(0,0,1500,700);
        this.add(background);
        
        //JPanel
        rect = new JPanel();
        rect.setBackground(new Color(0.100f,0.200f,0.100f,0.6f));
        rect.setBounds(-10,110,1500,450);
        rect.setBorder(out);
        rect.setLayout(null);
        background.add(rect);
        
        invi = new JPanel();
        invi.setBounds(-10,20,1500,400);
        invi.setBorder(line);
        invi.setOpaque(false);
        invi.setBorder(out);
        invi.setLayout(null);
        rect.add(invi);
        
        
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(500, 600));
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Final();
    }
    
}
