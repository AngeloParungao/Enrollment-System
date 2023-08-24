package pkgfinal;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import static pkgfinal.User.ID;


public class User_Frame extends JFrame implements ActionListener{
    
    JFrame fees, Sub, tui, setting;
    JTableHeader theader;
    JLabel background, backgroundset, change, scname, introStud, logoCenter, Sample, button1Label, button2Label, button3Label, Label, feeBG, backgroundfee, label
            ,new_un, new_pw, old_pw;
    JTextField txfee, tx_un, tx_pw, tx_old;
    JButton studentDtls, studentFees, listOfSubj , exit, Settings, save;
    JPanel panel, black;
    ImageIcon icon, imgBG, center, sample;
    
    Border line = BorderFactory.createLineBorder(Color.white,5);
    Border out = BorderFactory.createRaisedBevelBorder();

    public User_Frame() {
        
        //BORDER
        
        Border in = BorderFactory.createEtchedBorder();
        Border blackline = BorderFactory.createCompoundBorder(in, out);
        
        //JPanel
        
        panel= new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,0,1400,80);
        panel.setBackground(new Color(0x226b2c));
        panel.setVisible(true);
        add(panel);
        
        
        
        //JLabel
        
        introStud = new JLabel("WELCOME");
        introStud.setFont(new Font("Serif",Font.PLAIN,40));
        introStud.setForeground(Color.white);
        introStud.setBounds(570,15,400,50);
        panel.add(introStud);
 
        
        
        //JButton
        studentDtls =new JButton();
        ImageIcon details = new ImageIcon("payment-icon.png");
        Image img = details.getImage();
        Image img2 = img.getScaledInstance(130, 130,Image.SCALE_SMOOTH);
        ImageIcon detailsImage = new ImageIcon(img2);
        studentDtls.setIcon(detailsImage);
        studentDtls.setBorder(blackline);
        studentDtls.setBackground(new Color(0xeaa532 ));
        studentDtls.setBounds(300,300,200,200);
        studentDtls.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(studentDtls);
        
        button1Label =new JLabel("PAYMENT SLIP",JLabel.CENTER);
        button1Label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        button1Label.setFont(new Font("Serif",Font.BOLD,20));
        button1Label.setForeground(Color.white);
        studentDtls.add(button1Label);
        
        studentFees =new JButton();
        ImageIcon fee = new ImageIcon("stud_det_400x414.png");
        Image feeimg = fee.getImage();
        Image feeimg2 = feeimg.getScaledInstance(130, 130,Image.SCALE_SMOOTH);
        ImageIcon feeImage = new ImageIcon(feeimg2);
        studentFees.setIcon(feeImage);
        studentFees.setBorder(blackline);
        studentFees.setBackground(new Color(0xea8032 ));
        studentFees.setBounds(570,300,200,200);
        studentFees.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(studentFees);
        
        button2Label =new JLabel("STUDENT FEES",JLabel.CENTER);
        button2Label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        button2Label.setFont(new Font("Serif",Font.BOLD,20));
        button2Label.setForeground(Color.white);
        studentFees.add(button2Label);
        
        listOfSubj =new JButton();
        ImageIcon subj = new ImageIcon("subj.png");
        Image imgSubj = subj.getImage();
        Image imgSubj2 = imgSubj.getScaledInstance(130, 100,Image.SCALE_SMOOTH);
        ImageIcon subjImage = new ImageIcon(imgSubj2);
        listOfSubj.setIcon(subjImage);
        listOfSubj.setBorder(blackline);
        listOfSubj.setBackground(new Color(0x226b2c ));
        listOfSubj.setBounds(840,300,200,200);
        listOfSubj.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(listOfSubj);
        
        button3Label =new JLabel("SUBJECTS ENROLLED");
        button3Label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        button3Label.setFont(new Font("Serif",Font.BOLD,17));
        button3Label.setForeground(Color.white);
        listOfSubj.add(button3Label);
        
        exit = new JButton("LOGOUT");
        exit.setBorder(in);
        exit.setFont(new Font("Serif",Font.PLAIN,17));
        exit.setBackground(new Color(0,102,0));
        exit.setForeground(Color.white);
        exit.setBounds(1250,20,100,40);
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(exit);
        
        ImageIcon accInfo = new ImageIcon("settings_30x30.png");
        Settings = new JButton(accInfo);
        Settings.setBorder(in);
        Settings.setBackground(new Color(0,102,0));
        Settings.setBounds(1200,20,40,40);
        Settings.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(Settings);
        
        
        //ACTION
        
        studentFees.addActionListener(this);
        listOfSubj.addActionListener(this);
        studentDtls.addActionListener(this);
        exit.addActionListener(this);
        Settings.addActionListener(this);
        
        //ICON
        
        icon = new ImageIcon("AU_logo_green_emboss.png");
        this.setTitle("Student");
        this.setIconImage(icon.getImage());
        
        sample = new ImageIcon("CROP.png");
        Sample =new JLabel();
        Sample.setVisible(true);
        Sample.setBounds(230,90,800,100);
        Sample.setIcon(sample);
        add(Sample);
        
        center = new ImageIcon("AU_logo_green_nocirc1(1).png");
        logoCenter =new JLabel();
        logoCenter.setVisible(true);
        logoCenter.setBounds(0,60,300,300);
        logoCenter.setIcon(center);
        add(logoCenter);
        
        imgBG = new ImageIcon("BG1.png");
        background= new JLabel("",imgBG,JLabel.CENTER);
        background.setBounds(0,0,1500,700);
        add(background);
        
        
        
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
        if(e.getSource()==listOfSubj){
            String code="", grd="";
            String Sub1[] = new String[9];
            String Sub2[] = new String[9];
            String Unit1[] = new String[9];
            String Unit2[] = new String[9];
            String SUB[][] = new String[9][4];
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment","root","root");
          
                String sql = "SELECT StrandCode, Grd_lvl FROM enrollment WHERE Stud_ID =" + ID;
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                    code = rs.getString("StrandCode");
                    grd = rs.getString("Grd_lvl");
                }
                
                String sql1 = "SELECT * FROM subject WHERE StrandCode = '"+code+"' AND Grd_lvl = '"+grd+"'";
                PreparedStatement pstmt1 = con.prepareStatement(sql1);
                ResultSet rs1 = pstmt1.executeQuery();
                
                int i=0, j=0;
                while(rs1.next()){
                    int sem = rs1.getInt("Semester");
                    if(sem==1){
                        Sub1[i] = rs1.getString("Subj_Desc"); 
                        Unit1[i] = String.valueOf(rs1.getInt("Units"));
                        i++;
                    }  
                    else if (sem==2){
                        Sub2[j] = rs1.getString("Subj_Desc");
                        Unit2[j] = String.valueOf(rs1.getInt("Units"));
                        j++;  
                    }
                }
                
                for (int k = 0; k < 9; k++) {
                    for (int l = 0; l < 4; l++) {
                        if(l==0){
                            SUB[k][l]= Sub1[k];
                        }
                        else if(l==1){
                            SUB[k][l]= Unit1[k];
                        }
                        else if(l==2){
                            SUB[k][l]= Sub2[k];
                        }
                        else if(l==3){
                            SUB[k][l]= Unit2[k];
                        }
                    }
                }
                
                
                    String colu[]={"First Semester", "Units", "Second Semester", "Units"};
                    
                    Sub = new JFrame("Subjects");
                    ImageIcon icon = new ImageIcon("subj.png");
                    Sub.setIconImage(icon.getImage());

                    label= new JLabel(grd+" : "+code);
                    label.setFont(new Font("Serif",Font.PLAIN,50));
                    label.setBounds(440,35,550,55);
                    label.setForeground(Color.white);
                    Sub.add(label);

                    JTable tb1= new JTable();
                    DefaultTableModel model =new DefaultTableModel(SUB,colu);
                    theader = tb1.getTableHeader();       //TABLE_HEADER
                    theader.setFont(new Font("Dialog",Font.ITALIC, 14));
                    theader.setBackground(new Color(0x226b2c));
                    theader.setForeground(Color.white);
                    tb1.setModel(model);
                    tb1.setBackground(Color.LIGHT_GRAY);
                    tb1.setForeground(Color.black);
                    tb1.setFont(new Font("Serif",Font.CENTER_BASELINE, 14));
                    tb1.setRowHeight(40);
                    
                    tb1.getColumnModel().getColumn(0).setPreferredWidth(400);
                    tb1.getColumnModel().getColumn(2).setPreferredWidth(400);
                    
                    JScrollPane pane = new JScrollPane(tb1);
                    pane.setBounds(70,100,1100,400);
                    Sub.add(pane);


                    black = new JPanel();
                    black.setLayout(null);
                    black.setBounds(0,0,1255,610);
                    black.setBorder(line);
                    black.setBackground(new Color(0.0f,0.0f,0.0f,0.5f));
                    black.setVisible(true);
                    Sub.add(black);

                    Sub.setLocationRelativeTo(null);
                    Sub.setLayout(null);
                    Sub.setResizable(false);
                    ImageIcon stemSubIMG = new ImageIcon("mth.png");
                    background= new JLabel("",stemSubIMG,JLabel.CENTER);
                    background.setBounds(0,0,1270,650);
                    Sub.add(background);
                    Sub.setVisible(true);
                    Sub.setBounds(40, 40, 1270, 650);
            
            }  
            catch(Exception ex){
                System.out.println("Invalid");
            }
        }
        
        
        
        
        else if(e.getSource()==studentDtls){         
            new Tuition();
        }
        
        
        
        
        
        else if(e.getSource()==studentFees){
            
            fees= new JFrame("Student Fees");
            ImageIcon icon = new ImageIcon("stud_det.png");
            fees.setIconImage(icon.getImage());


            Label =new JLabel("FIRST SEMESTER");
            Label.setFont(new Font("Serif",Font.BOLD,40));
            Label.setForeground(Color.white);
            Label.setBounds(140,30,400,30);
            fees.add(Label);

            Label =new JLabel("Tuition Fees:");
            Label.setFont(new Font("Serif",Font.PLAIN,25));
            Label.setForeground(Color.white);
            Label.setBounds(70,100,200,30);
            fees.add(Label);

            txfee= new JTextField("9,054.00");
            txfee.setFont(new Font("Serif",Font.PLAIN,18));
            txfee.setBounds(350,100,200,30);
            txfee.setEditable(false);
            fees.add(txfee);

            Label =new JLabel("Energy:");
            Label.setFont(new Font("Serif",Font.PLAIN,25));
            Label.setForeground(Color.white);
            Label.setBounds(70,150,200,30);
            fees.add(Label);

            txfee= new JTextField("302.00");
            txfee.setFont(new Font("Serif",Font.PLAIN,18));
            txfee.setBounds(350,150,200,30);
            txfee.setEditable(false);
            fees.add(txfee);

            Label =new JLabel("Intergrated Learning Sys:");
            Label.setFont(new Font("Serif",Font.PLAIN,22));
            Label.setForeground(Color.white);
            Label.setBounds(70,200,250,30);
            fees.add(Label);

            txfee= new JTextField("4,220.00");
            txfee.setFont(new Font("Serif",Font.PLAIN,18));
            txfee.setBounds(350,200,200,30);
            txfee.setEditable(false);
            fees.add(txfee);

            Label =new JLabel("Miscellaneous Fees:");
            Label.setFont(new Font("Serif",Font.PLAIN,25));
            Label.setForeground(Color.white);
            Label.setBounds(70,250,250,30);
            fees.add(Label);

            txfee= new JTextField("3,971.00");
            txfee.setFont(new Font("Serif",Font.PLAIN,18));
            txfee.setBounds(350,250,200,30);
            txfee.setEditable(false);
            fees.add(txfee);

            Label =new JLabel("Depository Fees:");
            Label.setFont(new Font("Serif",Font.PLAIN,25));
            Label.setForeground(Color.white);
            Label.setBounds(70,300,200,30);
            fees.add(Label);

            txfee= new JTextField("3,342.00");
            txfee.setFont(new Font("Serif",Font.PLAIN,18));
            txfee.setBounds(350,300,200,30);
            txfee.setEditable(false);
            fees.add(txfee);

            Label =new JLabel("SHS Voucher: ");
            Label.setFont(new Font("Serif",Font.PLAIN,25));
            Label.setForeground(Color.white);
            Label.setBounds(70,400,200,30);
            fees.add(Label);

            txfee= new JTextField("8,750.00");
            txfee.setFont(new Font("Serif",Font.PLAIN,18));
            txfee.setBounds(350,400,200,30);
            txfee.setEditable(false);
            fees.add(txfee);

            Label =new JLabel("Total Amount:");
            Label.setFont(new Font("Serif",Font.PLAIN,25));
            Label.setForeground(Color.white);
            Label.setBounds(70,450,200,30);
            fees.add(Label);

            txfee= new JTextField("12,139.00");
            txfee.setFont(new Font("Serif",Font.PLAIN,18));
            txfee.setBounds(350,450,200,30);
            txfee.setEditable(false);
            fees.add(txfee);


            Label =new JLabel("SECOND SEMESTER");
            Label.setFont(new Font("Serif",Font.BOLD,40));
            Label.setForeground(Color.white);
            Label.setBounds(750,30,400,30);
            fees.add(Label);

            Label =new JLabel("Tuition Fees:");
            Label.setFont(new Font("Serif",Font.PLAIN,25));
            Label.setForeground(Color.white);
            Label.setBounds(700,100,200,30);
            fees.add(Label);

            txfee= new JTextField("7408.00");
            txfee.setFont(new Font("Serif",Font.PLAIN,18));
            txfee.setBounds(980,100,200,30);
            txfee.setEditable(false);
            fees.add(txfee);

            Label =new JLabel("Energy:");
            Label.setFont(new Font("Serif",Font.PLAIN,25));
            Label.setForeground(Color.white);
            Label.setBounds(700,150,200,30);
            fees.add(Label);

            txfee= new JTextField("247.00");
            txfee.setFont(new Font("Serif",Font.PLAIN,18));
            txfee.setBounds(980,150,200,30);
            txfee.setEditable(false);
            fees.add(txfee);

            Label =new JLabel("Intergrated Learning Sys:");
            Label.setFont(new Font("Serif",Font.PLAIN,22));
            Label.setForeground(Color.white);
            Label.setBounds(700,200,300,30);
            fees.add(Label);

            txfee= new JTextField("3,459.00");
            txfee.setFont(new Font("Serif",Font.PLAIN,18));
            txfee.setBounds(980,200,200,30);
            txfee.setEditable(false);
            fees.add(txfee);

            Label =new JLabel("Miscellaneous Fees:");
            Label.setFont(new Font("Serif",Font.PLAIN,25));
            Label.setForeground(Color.white);
            Label.setBounds(700,250,300,30);
            fees.add(Label);

            txfee= new JTextField("3,249.00");
            txfee.setFont(new Font("Serif",Font.PLAIN,18));
            txfee.setBounds(980,250,200,30);
            txfee.setEditable(false);
            fees.add(txfee);

            Label =new JLabel("Depository Fees:");
            Label.setFont(new Font("Serif",Font.PLAIN,25));
            Label.setForeground(Color.white);
            Label.setBounds(700,300,200,30);
            fees.add(Label);

            txfee= new JTextField("2,510.00");
            txfee.setFont(new Font("Serif",Font.PLAIN,18));
            txfee.setBounds(980,300,200,30);
            txfee.setEditable(false);
            fees.add(txfee);

            Label =new JLabel("SHS Voucher: ");
            Label.setFont(new Font("Serif",Font.PLAIN,25));
            Label.setForeground(Color.white);
            Label.setBounds(700,400,200,30);
            fees.add(Label);

            txfee= new JTextField("8,750.00");
            txfee.setFont(new Font("Serif",Font.PLAIN,18));
            txfee.setBounds(980,400,200,30);
            txfee.setEditable(false);
            fees.add(txfee);

            Label =new JLabel("Total Amount:");
            Label.setFont(new Font("Serif",Font.PLAIN,25));
            Label.setForeground(Color.white);
            Label.setBounds(700,450,200,30);
            fees.add(Label);

            txfee= new JTextField("8,123.00");
            txfee.setFont(new Font("Serif",Font.PLAIN,18));
            txfee.setBounds(980,450,200,30);
            txfee.setEditable(false);
            fees.add(txfee);
            
            black = new JPanel();
            black.setLayout(null);
            black.setBounds(0,0,1255,610);
            black.setBorder(line);
            black.setBackground(new Color(0.0f,0.0f,0.0f,0.5f));
            black.setVisible(true);
            fees.add(black);

            ImageIcon feeOP = new ImageIcon("feeop.png");
            feeBG = new JLabel();
            feeBG.setVisible(true);
            feeBG.setBounds(900,405,300,300);
            feeBG.setIcon(feeOP);
            fees.add(feeBG);

            fees.setLayout(null);
            ImageIcon feeIMG = new ImageIcon("mth.png");
            backgroundfee= new JLabel("",feeIMG,JLabel.CENTER);
            backgroundfee.setBounds(0,0,1270,650);
            fees.add(backgroundfee);

            fees.setResizable(false);
            fees.setBounds(40, 40, 1270, 650);
            fees.setVisible(true);
        }
        
        
        
        else if(e.getSource()==Settings){
            setting= new JFrame("Account Settings");
            
            //JLABEL
            
            change= new JLabel("Change Password");
            change.setBounds(30,20,300,50);
            change.setFont(new Font("Serif", Font.PLAIN, 22));
            change.setForeground(Color.white);
            setting.add(change);
            
            new_un = new JLabel("New Password:");
            new_un.setBounds(25,80, 230,20);
            new_un.setForeground(Color.white);
            new_un.setFont(new Font("Minion Variable Concept",Font.PLAIN,18));
            setting.add(new_un);
            
            new_pw = new JLabel("Confirm Password:");
            new_pw.setBounds(25,150,230,20);
            new_pw.setForeground(Color.white);
            new_pw.setFont(new Font("Minion Variable Concept",Font.PLAIN,18));
            setting.add(new_pw);
            
            old_pw = new JLabel("Old Password:");
            old_pw.setBounds(25,220,230,20);
            old_pw.setForeground(Color.white);
            old_pw.setFont(new Font("Minion Variable Concept",Font.PLAIN,18));
            setting.add(old_pw);
            
            
            //TXT
            
            tx_un = new JTextField();
            tx_un.setBounds(25,110,250,30);
            setting.add(tx_un);
            
            tx_pw = new JTextField();
            tx_pw.setBounds(25,180,250,30);
            setting.add(tx_pw);
                
            tx_old = new JTextField();
            tx_old.setBounds(25,250,250,30);
            setting.add(tx_old);
            
            save= new JButton("SAVE");
            save.setBounds(25,300,250,30);
            save.setBorder(out);
            save.setFont(new Font("Serif", Font.BOLD, 15));
            save.setForeground(Color.white);
            save.setBackground(new Color(0x226b2c));
            save.setCursor(new Cursor(Cursor.HAND_CURSOR));
            setting.add(save);
            
            save.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment","root","root");

                        String sel = "SELECT Username, Password FROM student";
                        PreparedStatement Sel = con.prepareStatement(sel);
                        ResultSet result = Sel.executeQuery();
                        
                        String sql1 = "SELECT count(*) AS number FROM student";
                        PreparedStatement number = con.prepareStatement(sql1);
                        ResultSet rs = number.executeQuery();

                        int NUMBER =0;
                        while(rs.next()){
                            NUMBER = rs.getInt("number");
                        }
                        
                        String old[] = new String[NUMBER];
                        
                        int count=0, incre =1;
                        
                        while(result.next()){
                            for (; count < incre; count ++) {
                                old[count] = result.getString("Password");
//                                System.out.println(old[i]);
//                                System.out.println(old_un[i]);
                            }
                            incre++;
                        }
                                                
                        if(tx_un.getText().isEmpty() ||tx_pw.getText().isEmpty() || tx_old.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Complete the Details");
                        }
                        else{
                            if(tx_un.getText().equals(tx_pw.getText())){
                                for (int i = 0; i < old.length; i++) { 
                                    
                                    if(tx_old.getText().equals(old[i])){
                                        System.out.println(old[i]);
                                        PreparedStatement up = con.prepareStatement("UPDATE student SET Password = ? WHERE Stud_ID = "+ID);

                                        up.setString(1, tx_un.getText());
                                    
                                        up.executeUpdate();

                                        JOptionPane.showMessageDialog(null, "Successfully Updated");
                                        setting.dispose();

                                        break;
                                    }
                                    else if(i==(NUMBER-1)){
                                        JOptionPane.showMessageDialog(null, "Wrong Old Password");
                                        break;
                                    }
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Unmatched Password");
                            }
                        }
                        
                        
                    }catch(Exception ex){
                        
                    }
                }
                
            });
                
            black = new JPanel();
            black.setLayout(null);
            black.setBounds(0,0,305,370);
            black.setBorder(line);
            black.setBackground(new Color(0.0f,0.0f,0.0f,0.4f));
            black.setVisible(true);
            setting.add(black);
            
            ImageIcon icon = new ImageIcon("settings.png");
            setting.setIconImage(icon.getImage());
            
            ImageIcon regBG = new ImageIcon("auth_bg.png");
            backgroundset= new JLabel("",regBG,JLabel.CENTER);
            backgroundset.setBounds(0,0,320,400);
            setting.add(backgroundset);
            
            setting.setBounds(510,170,320,400);
            setting.setResizable(false);
            setting.setLayout(null);
            setting.setVisible(true);
        }
        
        else if(e.getSource()==exit){
            dispose();
            new Final();
        }
    }
    
}
