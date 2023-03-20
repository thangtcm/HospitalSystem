/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Swing.Table;

import Swing.Scroll.ScrollBar;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author couni
 */
public class ShadowTable extends JTable {
    private Color shadowColor = new Color(10, 0, 10, 100);
    private int shadowSize = 10;
    private Color borderColor = Color.BLACK;
    private int borderSize = 1;
    int borderWidth = 2; // Chiều rộng của đường viền

    Border borderLine = BorderFactory.createMatteBorder(0, borderWidth, 0, 0, Color.RED); // Tạo đường viền bên trái màu đỏ
    Border borderSpace = BorderFactory.createEmptyBorder(0, borderWidth, 0, 0); // Tạo khoảng cách giữa đường viền và nội dung
    Border compoundBorder = BorderFactory.createCompoundBorder(borderLine, borderSpace); // Kết hợp cả hai border
    Border emptyBorder = BorderFactory.createEmptyBorder(10, 0, 0, 0); // Tạo EmptyBorder với độ cao bằng 10
    Border centeredBorder = BorderFactory.createCompoundBorder(emptyBorder, compoundBorder); // Kết hợp emptyBorder với compoundBorder để căn giữa chiều cao

    public ShadowTable() {
//        super(model);
//        setOpaque(false);
//        setDefaultRenderer(Object.class, new BorderCellRenderer());
        setRowHeight(50);
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
                    //com.setBackground(Color.WHITE);
                    com.setForeground(Color.decode("#444343"));
                }
                if(i1 == 0)
                    ((JComponent) com).setBorder(centeredBorder);
                else    
                    ((JComponent) com).setBorder(BorderFactory.createEmptyBorder());
                //setBorder(centeredBorder);
                return com;
            }
        });
       //setDefaultRenderer(Object.class, new BorderCellRenderer());
    }

    public void setShadowColor(Color shadowColor) {
        this.shadowColor = shadowColor;
    }

    public void setShadowSize(int shadowSize) {
        this.shadowSize = shadowSize;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
    }
private BufferedImage imageShadow;
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int space = 12;
        int margin = space / 2;
        for (int i = 0; i < getRowCount(); i++) {
            int row = i;
            Rectangle r = getCellRect(row, 0, true);
            if (isRowSelected(i)) {
                g2.setColor(new Color(17, 164, 232));
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
                g2.fillRect(margin, r.getLocation().y + margin, getWidth() - margin * 2, rowHeight - space);
            }
            
            g2.setComposite(AlphaComposite.SrcOver);
            g2.drawImage(imageShadow, 0, r.getLocation().y, null);
            g2.setColor(new Color(79,98,203));
            g2.fillRect(0, r.getLocation().y + margin, 3, rowHeight - space);
        }
        g2.dispose();
    }

//    private class BorderCellRenderer extends DefaultTableCellRenderer {
//        @Override
//        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//            if (row == 0) {
//                ((JComponent) c).setBorder(BorderFactory.createMatteBorder(borderSize, borderSize, 0, 0, borderColor));
//            } else {
//                ((JComponent) c).setBorder(BorderFactory.createMatteBorder(0, borderSize, 0, 0, borderColor));
//            }
//            return c;
//        }
//    }
//    
    public void fixTable(JScrollPane scroll) {
        scroll.setBorder(null);
        scroll.getViewport().setBackground(new Color(250, 250, 250));
        ScrollBar sb = new ScrollBar();
        sb.setBackground(new Color(250, 250, 250));
        scroll.setVerticalScrollBar(sb);
        JPanel p = new JPanel();
        p.setBackground(new Color(250, 250, 250));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
    }
}
