/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Swing.Table;

import Swing.Panel.PanelShadow;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author couni
 */
public class ShadowRenderer extends DefaultTableCellRenderer {
    private BufferedImage imageShadow;
int borderWidth = 2; // Chiều rộng của đường viền

    Border borderLine = BorderFactory.createMatteBorder(0, borderWidth, 0, 0, Color.RED); // Tạo đường viền bên trái màu đỏ
    Border borderSpace = BorderFactory.createEmptyBorder(0, borderWidth, 0, 0); // Tạo khoảng cách giữa đường viền và nội dung
    Border compoundBorder = BorderFactory.createCompoundBorder(borderLine, borderSpace); // Kết hợp cả hai border
    Border emptyBorder = BorderFactory.createEmptyBorder(10, 0, 0, 0); // Tạo EmptyBorder với độ cao bằng 10
    Border centeredBorder = BorderFactory.createCompoundBorder(emptyBorder, compoundBorder); // Kết hợp emptyBorder với compoundBorder để căn giữa chiều cao
 
    public ShadowRenderer() {
        createShadow();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setOpaque(true);
        label.setBackground(row % 2 == 0 ? Color.WHITE : new Color(240, 240, 240));
        label.setForeground(Color.BLACK);
        label.setFont(table.getFont().deriveFont(14f));
        if (isSelected) {
                label.setBackground(Color.decode("#4F62CB"));
                label.setForeground(Color.WHITE);
            } else {
                label.setBackground(Color.WHITE);
                label.setForeground(Color.decode("#444343"));
            }
            if(column == 0)
                label.setBorder(centeredBorder);
            else    
                label.setBorder(BorderFactory.createEmptyBorder());
            //setBorder(centeredBorder);
        return label;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.drawImage(imageShadow, 0, 0, null);
        super.paint(g2d);
        g2d.dispose();
    }

    private void createShadow() {
        int shadowSize = 10;
        int imageWidth = shadowSize + getPreferredSize().width;
        int imageHeight = shadowSize + getPreferredSize().height;
        imageShadow = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = imageShadow.createGraphics();
        g2d.setColor(new Color(0, 0, 0, 100));
        g2d.fillRoundRect(shadowSize, shadowSize, getPreferredSize().width, getPreferredSize().height, 5, 5);
        g2d.dispose();
    }
}
