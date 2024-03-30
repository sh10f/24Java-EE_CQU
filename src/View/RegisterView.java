/*
 * Created by JFormDesigner on Thu Mar 28 22:17:39 CST 2024
 */

package View;

import DB.LinkDatabase;
import Model.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author Lenovo
 */
public class RegisterView extends JFrame {
    public RegisterView() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("客户注册");
        initComponents();

        setVisible(true);
    }

    private void initComponents() {
        actionCon = new ActionCon();

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel_East = new JPanel();
        panel_South = new JPanel();
        panel_Nort = new JPanel();
        label1 = new JLabel();
        panel_Center = new JPanel();
        label_UName = new JLabel();
        label_PW = new JLabel();
        label_Phone = new JLabel();
        textField_Uname = new JTextField();
        textField_PW = new JTextField();
        textField_Phone = new JTextField();
        label_Login = new JButton();
        button_Register = new JButton();
        label_NPW = new JLabel();
        textField_NPW = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel_East ========
        {
            panel_East.setPreferredSize(new Dimension(80, 10));
            panel_East.setBackground(Color.white);
            panel_East.setLayout(new FlowLayout());
        }
        contentPane.add(panel_East, BorderLayout.EAST);

        //======== panel_South ========
        {
            panel_South.setBackground(Color.white);
            panel_South.setLayout(new FlowLayout());
        }
        contentPane.add(panel_South, BorderLayout.SOUTH);

        //======== panel_Nort ========
        {
            panel_Nort.setBackground(Color.white);
            panel_Nort.setLayout(new FlowLayout());

            //---- label1 ----
            label1.setText("\u7269\u6d41\u7cfb\u7edf\u5ba2\u6237\u6ce8\u518c");
            label1.setBackground(Color.white);
            label1.setForeground(new Color(0x2e9bf3));
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 12f));
            panel_Nort.add(label1);
        }
        contentPane.add(panel_Nort, BorderLayout.NORTH);

        //======== panel_Center ========
        {
            panel_Center.setBackground(Color.white);
            panel_Center.setLayout(null);

            //---- label_UName ----
            label_UName.setText("\u7528\u6237\u540d\uff1a");
            label_UName.setFont(label_UName.getFont().deriveFont(label_UName.getFont().getStyle() | Font.BOLD, label_UName.getFont().getSize() + 8f));
            label_UName.setForeground(new Color(0x2e9bf3));
            label_UName.setBackground(new Color(0x2e9bf3));
            panel_Center.add(label_UName);
            label_UName.setBounds(new Rectangle(new Point(100, 20), label_UName.getPreferredSize()));

            //---- label_PW ----
            label_PW.setText("\u5bc6\u7801\uff1a");
            label_PW.setFont(label_PW.getFont().deriveFont(label_PW.getFont().getStyle() | Font.BOLD, label_PW.getFont().getSize() + 8f));
            label_PW.setForeground(new Color(0x2e9bf3));
            panel_Center.add(label_PW);
            label_PW.setBounds(new Rectangle(new Point(100, 100), label_PW.getPreferredSize()));

            //---- label_Phone ----
            label_Phone.setText("\u624b\u673a\u53f7\uff1a");
            label_Phone.setForeground(new Color(0x2e9bf3));
            label_Phone.setFont(label_Phone.getFont().deriveFont(label_Phone.getFont().getStyle() | Font.BOLD, label_Phone.getFont().getSize() + 8f));
            panel_Center.add(label_Phone);
            label_Phone.setBounds(new Rectangle(new Point(100, 285), label_Phone.getPreferredSize()));
            panel_Center.add(textField_Uname);
            textField_Uname.setBounds(165, 60, 290, 35);
            panel_Center.add(textField_PW);
            textField_PW.setBounds(165, 135, 290, 35);
            panel_Center.add(textField_Phone);
            textField_Phone.setBounds(165, 325, 290, 35);

            //---- label_Login ----
            label_Login.setText("\u53bb\u767b\u5f55");
            label_Login.setForeground(new Color(0x2e9bf3));
            label_Login.setFont(label_Login.getFont().deriveFont(label_Login.getFont().getStyle() | Font.BOLD, label_Login.getFont().getSize() + 1f));
            panel_Center.add(label_Login);
            label_Login.setBounds(245, 365, 80, 20);

            //---- button_Register ----
            button_Register.setText("\u6ce8\u518c");
            button_Register.setForeground(new Color(0x2e9bf3));
            button_Register.setFont(button_Register.getFont().deriveFont(button_Register.getFont().getStyle() | Font.BOLD, button_Register.getFont().getSize() + 5f));
            panel_Center.add(button_Register);
            button_Register.setBounds(100, 395, 360, 55);

            //---- label_NPW ----
            label_NPW.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
            label_NPW.setFont(label_NPW.getFont().deriveFont(label_NPW.getFont().getStyle() | Font.BOLD, label_NPW.getFont().getSize() + 8f));
            label_NPW.setForeground(new Color(0x2e9bf3));
            panel_Center.add(label_NPW);
            label_NPW.setBounds(100, 195, 105, 27);
            panel_Center.add(textField_NPW);
            textField_NPW.setBounds(165, 240, 290, 35);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel_Center.getComponentCount(); i++) {
                    Rectangle bounds = panel_Center.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel_Center.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel_Center.setMinimumSize(preferredSize);
                panel_Center.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel_Center, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on


        //===== Controller =====
        button_Register.addActionListener(actionCon);
        label_Login.addActionListener(actionCon);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel_East;
    private JPanel panel_South;
    private JPanel panel_Nort;
    private JLabel label1;
    private JPanel panel_Center;
    private JLabel label_UName;
    private JLabel label_PW;
    private JLabel label_Phone;
    private JTextField textField_Uname;
    private JTextField textField_PW;
    private JTextField textField_Phone;
    private JButton label_Login;
    private JButton button_Register;
    private JLabel label_NPW;
    private JTextField textField_NPW;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public ActionCon actionCon;


    private class ActionCon implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button_Register) {
                System.out.println(textField_Uname.getText());
                if (!textField_PW.getText().equals("") & !textField_NPW.getText().equals("") & textField_PW.getText().equals(textField_NPW.getText())) {
                    if (textField_Phone.getText().equals(""))
                        JOptionPane.showMessageDialog(panel_Center, "注册失败。\n请输入手机号。", "注册提示", JOptionPane.WARNING_MESSAGE);
                    else {
                        int result = register_check();
                        if (result == -1)
                            JOptionPane.showMessageDialog(panel_Center, "注册失败。\n该电话号可注册用户已达上限。", "注册提示", JOptionPane.WARNING_MESSAGE);
                        else if (result == 0)
                            JOptionPane.showMessageDialog(panel_Center, "注册失败。\n请稍后再试。", "注册提示", JOptionPane.WARNING_MESSAGE);
                        else if (result == 1) {
                            try {
                                JOptionPane.showMessageDialog(panel_Center, "注册成功。\n您的Uid为 " + LinkDatabase.getCurrUid() + "\n请妥善保存.", "注册提示", JOptionPane.INFORMATION_MESSAGE);
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                                }
                            }
                    }
                }

                else
                    JOptionPane.showMessageDialog( panel_Center,"注册失败。\n请确认两次密码相同。","注册提示",JOptionPane.WARNING_MESSAGE);



            }

            if(e.getSource() == label_Login){
                System.out.println("dafadf");
                dispose();

            }


        }


    }


    private int register_check(){
        try {
            return LinkDatabase.insertUser(textField_Phone.getText(), textField_PW.getText(), textField_Uname.getText());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}




