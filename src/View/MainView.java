/*
 * Created by JFormDesigner on Wed Mar 27 15:43:19 CST 2024
 */

package View;


import DB.LinkDatabase;
import Model.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.sound.sampled.Control;
import javax.swing.*;

/**
 * @author Lenovo
 */
public class MainView extends JFrame {
    public MainView() {
        setSize(1000, 340);
        setLayout(new BorderLayout());
        setTitle("用户登录");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();

        setVisible(true);



    }

    private void initComponents() {
        String [] strings_Class = {"客户", "管理员", "司机"};

        actionCon = new ActionCon();
        user = new User();

        // Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel_South = new JPanel();
        panel_East = new JPanel();
        panel_Center = new JPanel();
        checkBox_Rememer = new JCheckBox();
        textField_User = new JTextField();
        button_Login = new JButton();
        passwordField1 = new JPasswordField();
        label_User = new JLabel();
        label_PassWord = new JLabel();
        button_Forget = new JButton();
        button_Register = new JButton();
        label_Class = new JLabel();
        comboBox_Class = new JComboBox(strings_Class);
        panel_North = new JPanel();
        label_System = new JLabel();
        label_Left = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel_South ========
        {
            panel_South.setBackground(Color.white);
            panel_South.setPreferredSize(new Dimension(10, 50));
            panel_South.setLayout(new FlowLayout());
        }
        contentPane.add(panel_South, BorderLayout.SOUTH);

        //======== panel_East ========
        {
            panel_East.setBackground(Color.white);
            panel_East.setPreferredSize(new Dimension(50, 10));
            panel_East.setLayout(new FlowLayout());
        }
        contentPane.add(panel_East, BorderLayout.EAST);

        //======== panel_Center ========
        {
            panel_Center.setMinimumSize(new Dimension(500, 400));
            panel_Center.setBackground(Color.white);
            panel_Center.setLayout(null);

            //---- comboBox_Class ----
            // 默认选择 “ 客户 ” 进行登录
            comboBox_Class.setSelectedIndex(0);



            //---- checkBox_Rememer ----
            checkBox_Rememer.setText("\u8bb0\u4f4f\u5bc6\u7801");
            checkBox_Rememer.setBackground(Color.white);
            panel_Center.add(checkBox_Rememer);
            checkBox_Rememer.setBounds(140, 240, 85, 30);
            panel_Center.add(textField_User);
            textField_User.setBounds(200, 95, 180, 35);

            //---- button_Login ----
            button_Login.setText("\u767b\u5f55");
            button_Login.setBackground(Color.white);
            panel_Center.add(button_Login);
            button_Login.setBounds(105, 270, 155, 35);
            panel_Center.add(passwordField1);
            passwordField1.setBounds(200, 150, 180, 35);
            passwordField1.setEchoChar('*');

            //---- label_User ----
            label_User.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
            label_User.setIcon(new ImageIcon("D:\\CodeField\\Code_Java\\Project\\imgs\\Mainview\\User.png"));
            panel_Center.add(label_User);
            label_User.setBounds(125, 100, 75, 22);

            //---- label_PassWord ----
            label_PassWord.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
            label_PassWord.setIcon(new ImageIcon("D:\\CodeField\\Code_Java\\Project\\imgs\\Mainview\\Password.png"));
            panel_Center.add(label_PassWord);
            label_PassWord.setBounds(125, 150, 90, 22);

            //---- button_Forget ----
            button_Forget.setText("\u5fd8\u8bb0\u5bc6\u7801");
            button_Forget.setBackground(Color.white);
            panel_Center.add(button_Forget);
            button_Forget.setBounds(new Rectangle(new Point(290, 235), button_Forget.getPreferredSize()));

            //---- button_Register ----
            button_Register.setText("客户注册");
            button_Register.setBackground(Color.white);
            panel_Center.add(button_Register);
            button_Register.setBounds(285, 270, 98, 35);

            //---- label_Class ----
            label_Class.setText("Class");
            label_Class.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
            panel_Center.add(label_Class);
            label_Class.setBounds(130, 200, 75, 25);
            panel_Center.add(comboBox_Class);
            comboBox_Class.setBounds(200, 195, 175, comboBox_Class.getPreferredSize().height);

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

        //======== panel_North ========
        {
            panel_North.setPreferredSize(new Dimension(10, 50));
            panel_North.setBackground(Color.white);
            panel_North.setLayout(null);

            //---- label_System ----
            label_System.setText("\u7269\u6d41\u7ba1\u7406\u7cfb\u7edf");
            label_System.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 25));
            label_System.setForeground(new Color(0x4f8ed3));
            panel_North.add(label_System);
            label_System.setBounds(315, 15, 180, 30);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel_North.getComponentCount(); i++) {
                    Rectangle bounds = panel_North.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel_North.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel_North.setMinimumSize(preferredSize);
                panel_North.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel_North, BorderLayout.NORTH);

        //---- label_Left ----
        label_Left.setPreferredSize(new Dimension(350, 17));
        label_Left.setIcon(new ImageIcon("D:\\CodeField\\Code_Java\\Project\\imgs\\Mainview\\Left.png"));
        contentPane.add(label_Left, BorderLayout.WEST);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        //==== Control Event ====
        button_Login.addActionListener(actionCon);
        button_Forget.addActionListener(actionCon);
        button_Register.addActionListener(actionCon);


    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    public JPanel panel_South;
    public JPanel panel_East;
    public JPanel panel_Center;
    public JCheckBox checkBox_Rememer;
    public JTextField textField_User;
    public JButton button_Login;
    public JPasswordField passwordField1;
    public JLabel label_User;
    public JLabel label_PassWord;
    public JButton button_Forget;
    public JButton button_Register;
    public JLabel label_Class;
    public JComboBox comboBox_Class;
    public JPanel panel_North;
    public JLabel label_System;
    public JLabel label_Left;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    //==== Controller ====
    public ActionCon actionCon;

    //==== User ====
    public User user;
    public UserView userView;

    private class ActionCon implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button_Login){
                user.setUClass((String) comboBox_Class.getSelectedItem());


                if(textField_User.getText().equals(""))
                    JOptionPane.showMessageDialog( panel_Center,"用户id输入为空！\n请您输入完整的用户id。","输入提示",JOptionPane.WARNING_MESSAGE);

                else if( passwordField1.getText().equals(""))
                    JOptionPane.showMessageDialog(panel_Center,"密码输入为空！\n请您输入完整的密码。","输入提示",JOptionPane.WARNING_MESSAGE);

                else{
                    user.setUid(Integer.parseInt(textField_User.getText()));
                    user.setUPassWord(new String(passwordField1.getPassword()));

                    if(log_check(user)){
                        System.out.println("good");
                        if(user.getUClass() == "客户"){
                            userView = new UserView(user);
                            setVisible(false);
                            userView.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowClosed(WindowEvent e) {
                                    super.windowClosed(e);
                                    setVisible(true);
                                }
                            });
                        }

                    }

                    else
                        System.out.println("eoor");
                }
            }

            else if(e.getSource() == button_Forget){
                ForgetPassView t = new ForgetPassView((String) comboBox_Class.getSelectedItem());
                setVisible(false);

                t.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        super.windowClosed(e);
                        setVisible(true);
                    }
                });

            }

            else if(e.getSource() == button_Register){
                RegisterView registerView = new RegisterView();
                setVisible(false);

                registerView.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        super.windowClosed(e);
                        setVisible(true);
                    }
                });
            }

        }
    }

    private boolean log_check(User user){
        try {
            return LinkDatabase.DB_Login(user.getUid(), user.getUPassWord(), user.getUClass());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
