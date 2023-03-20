/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Swing.Table;

import Swing.Scroll.ScrollBar;
import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author YAN
 */
public class Table extends JTable {
    int borderWidth = 3;
    Border borderLine = BorderFactory.createMatteBorder(0, borderWidth, 0, 0, Color.decode("#4F62CB")); 
    Border borderSpace = BorderFactory.createEmptyBorder(0, borderWidth, 0, 0); 
    Border compoundBorder = BorderFactory.createCompoundBorder(borderLine, borderSpace); 
    Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0); 
    Border centeredBorder = BorderFactory.createCompoundBorder(emptyBorder, compoundBorder); 

    public Table() {
        setRowHeight(50);
        setRowMargin(10);
        
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader h = new TableHeader(o + "");
                return h;
            }
        });
        
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1, int i, int i1) {
                Component com = super.getTableCellRendererComponent(jtable, o, selected, bln1, i, i1); 
                if (selected) {
                    com.setBackground(Color.decode("#4F62CB"));
                    com.setForeground(Color.WHITE);
                } else {
                    com.setBackground(Color.WHITE);
                        //com.setBackground(jtable.getBackground());
                    com.setForeground(Color.decode("#444343"));
                }
                if(i1 == 0)  
                    ((JComponent) com).setBorder(centeredBorder);
                else  
                {
                    ((JComponent) com).setBorder(BorderFactory.createEmptyBorder());
                }
                //((JComponent) com).setBorder(BorderFactory.createCompoundBorder(new DropShadowBorder(), BorderFactory.createMatteBorder(0, 0, 1, 0, jtable.getBackground())));
                return com;
            }
        });
    }


    public void fixTable(JScrollPane scroll) {
        scroll.setBorder(null);
        scroll.setVerticalScrollBar(new ScrollBar());
        scroll.getVerticalScrollBar().setBackground(Color.WHITE);
        scroll.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
    }
}
