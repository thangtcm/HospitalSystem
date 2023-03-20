/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Components;

import Swing.Panel.PanelShadow;
import java.awt.Color;

/**
 *
 * @author YAN
 */
public class Welcome extends PanelShadow {

    /**
     * Creates new form Welcome
     */
    public Welcome() {
        initComponents();
        init();
    }
    
    public void setlbName(String Name)
    {
        lbName.setText(Name);
    }
    
    private void init()
    {
        setRadius(20);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        imgAvatar1 = new Swing.Img.ImgAvatar();
        AvatarUser = new Swing.Img.ImgAvatar();
        imgAvatar2 = new Swing.Img.ImgAvatar();
        imgAvatar5 = new Swing.Img.ImgAvatar();
        imgAvatar3 = new Swing.Img.ImgAvatar();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Inter", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(85, 85, 85));
        jLabel2.setText("Welcome!");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        lbName.setFont(new java.awt.Font("Inter", 1, 28)); // NOI18N
        lbName.setForeground(new java.awt.Color(243, 195, 101));
        lbName.setText("Dr. Jonny!");
        add(lbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(107, 107, 107));
        jLabel4.setText("Have a nice day at work.");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        AvatarUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Avatar/Avatar.png"))); // NOI18N
        imgAvatar1.add(AvatarUser);
        AvatarUser.setBounds(60, 10, 150, 150);

        imgAvatar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Shape/CircleLarge.png"))); // NOI18N
        imgAvatar1.add(imgAvatar2);
        imgAvatar2.setBounds(170, 80, 70, 80);

        imgAvatar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Shape/CircleLarge.png"))); // NOI18N
        imgAvatar1.add(imgAvatar5);
        imgAvatar5.setBounds(10, 60, 100, 110);

        imgAvatar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Shape/CircleSmall.png"))); // NOI18N
        imgAvatar1.add(imgAvatar3);
        imgAvatar3.setBounds(170, 10, 40, 50);

        add(imgAvatar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 250, 180));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Swing.Img.ImgAvatar AvatarUser;
    private Swing.Img.ImgAvatar imgAvatar1;
    private Swing.Img.ImgAvatar imgAvatar2;
    private Swing.Img.ImgAvatar imgAvatar3;
    private Swing.Img.ImgAvatar imgAvatar5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbName;
    // End of variables declaration//GEN-END:variables
}
