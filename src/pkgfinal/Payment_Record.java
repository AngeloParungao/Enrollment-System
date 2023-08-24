package pkgfinal;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Payment_Record extends JFrame{
    JLabel label, listBG;
    JButton exit;
    static JTable tblist = new JTable();
    JTableHeader theader;
    static String col[]={"Student No.","Name","Down","September","October","November","December","January","February","March","April","May","Status"};
    static String list[][] = new String [0][12];
    static DefaultTableModel modellist = new DefaultTableModel(list,col) ;
    JScrollPane pane1 = new JScrollPane(tblist);
    
    public Payment_Record() {
        Border down = BorderFactory.createLoweredBevelBorder();
        
        modellist.setColumnIdentifiers(col);
        theader = tblist.getTableHeader();       //TABLE_HEADER
        theader.setBackground(new Color(0x226b2c));
        theader.setForeground(Color.white);
        tblist.setModel(modellist);
        tblist.setBackground(new Color(0xeaa532));
        tblist.setForeground(Color.black);
        tblist.setRowHeight(20);
        tblist.setOpaque(false);
        
        tblist.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblist.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblist.getColumnModel().getColumn(3).setPreferredWidth(50);
        tblist.getColumnModel().getColumn(4).setPreferredWidth(50);
        tblist.getColumnModel().getColumn(5).setPreferredWidth(50);
        tblist.getColumnModel().getColumn(6).setPreferredWidth(50);
        tblist.getColumnModel().getColumn(7).setPreferredWidth(50);
        tblist.getColumnModel().getColumn(8).setPreferredWidth(50);
        tblist.getColumnModel().getColumn(9).setPreferredWidth(50);
        tblist.getColumnModel().getColumn(10).setPreferredWidth(50);
        tblist.getColumnModel().getColumn(11).setPreferredWidth(50);
        tblist.getColumnModel().getColumn(12).setPreferredWidth(50);
        
        pane1.setBounds(20, 100, 1070, 400);
        pane1.setOpaque(false);
        add(pane1);
        
        
        //LABEL-------------------
        label= new JLabel("PAYMENT RECORDS");
        label.setFont(new Font("Serif",Font.PLAIN,40));
        label.setForeground(Color.white);
        label.setBounds(350,30,600,40);
        add(label);
        
        exit= new JButton("Cancel");
        exit.setFont(new Font("Minion Variable Concept",Font.PLAIN,17));
        exit.setForeground(Color.white);
        exit.setBorder(down);
        exit.setBackground(new Color(0xea8032));
        exit.setBounds(950, 560, 120,40);
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(exit);

        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }

        });
        
        //ICON--------------------
        
        setLayout(null);
        setBounds(240,25,1110,750);
        setUndecorated(true);
        setVisible(true);
        setBackground(new Color(0.0f,0.0f,0.0f,0.8f));

    }
    
}
