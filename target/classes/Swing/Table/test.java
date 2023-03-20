/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Swing.Table;

import Swing.Scroll.ScrollBar;
import Swing.shadow.ShadowRenderer;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author couni
 */
public class test extends  JTable{
    private BufferedImage imageShadow;
    public test() {
        setRowHeight(50);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader h = new TableHeader(o + "");
                if (i1 == 0 || i1 == 4) {
                    h.setHorizontalAlignment(JLabel.CENTER);
                }
                return h;
            }
        });
       setDefaultRenderer(Object.class, new Swing.Table.ShadowRenderer());

    }
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

//    private void createShadow() {
//        int width = getWidth();
//        int height = rowHeight;
//        int space = 12;
//        int margin = space / 2;
//        imageShadow = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
//        Graphics2D g2 = imageShadow.createGraphics();
//        g2.fillRect(0, 0, width - margin, height - margin);
//        g2.drawImage(new ShadowRenderer(6, 0.3f, new Color(160, 160, 160)).createShadow(imageShadow), -4, -4, null);
//        g2.fillRect(margin, margin, width - space, height - space);
//        g2.setComposite(AlphaComposite.Clear);
//        g2.fillRect(margin, margin, width - space, height - space);
//        g2.dispose();
//    }
//
//
//
//    @Override
//    protected void paintComponent(Graphics grphcs) {
//        super.paintComponent(grphcs);
//        Graphics2D g2 = (Graphics2D) grphcs;
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        int space = 12;
//        int margin = space / 2;
//        for (int i = 0; i < getRowCount(); i++) {
//            int row = i;
//            Rectangle r = getCellRect(row, 0, true);
//            if (isRowSelected(i)) {
//                g2.setColor(new Color(17, 164, 232));
//                g2.drawRect(margin, r.getLocation().y + margin, getWidth() - margin * 2, rowHeight - space);
//            }
//            g2.drawImage(imageShadow, 0, r.getLocation().y, null);
//            g2.setColor(new Color(79,98,203));
//            g2.fillRect(margin, r.getLocation().y + margin, 3, rowHeight - space);
//        }
//        g2.dispose();
//    }

    

}
