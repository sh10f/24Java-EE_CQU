/*
 * Created by JFormDesigner on Thu Mar 28 20:07:11 CST 2024
 */

package View;

import DB.LinkDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Random;

/**
 * @author Lenovo
 */
public class UnsubscribeView extends JFrame {
    private String UClass;

    public UnsubscribeView() {
        setTitle("账户注销");
        initComponents();

        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void initComponents() {
        actionCon = new ActionCon();
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel_East = new JPanel();
        panel_North = new JPanel();
        panel_South = new JPanel();
        panel_Center = new JPanel();
        label_ID = new JLabel();

        label_Phone = new JLabel();
        label_YZM = new JLabel();
        textField_Phone = new JTextField();
        textField_YZM = new JTextField();

        textField_ID = new JTextField();
        button_Sure = new JButton();
        button_Cancel = new JButton();
        checkBox_YZM = new JCheckBox();
        button_Send = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel_East ========
        {
            panel_East.setMinimumSize(new Dimension(30, 10));
            panel_East.setLayout(new FlowLayout());
        }
        contentPane.add(panel_East, BorderLayout.EAST);

        //======== panel_North ========
        {
            panel_North.setLayout(new FlowLayout());
        }
        contentPane.add(panel_North, BorderLayout.NORTH);

        //======== panel_South ========
        {
            panel_South.setLayout(new FlowLayout());
        }
        contentPane.add(panel_South, BorderLayout.SOUTH);

        //======== panel_Center ========
        {
            panel_Center.setLayout(null);

            //---- label_ID ----
            label_ID.setText("ID: ");
            label_ID.setFont(label_ID.getFont().deriveFont(label_ID.getFont().getSize() + 10f));
            label_ID.setForeground(Color.darkGray);
            panel_Center.add(label_ID);
            label_ID.setBounds(85, 45, 85, 35);




            //---- label_Phone ----
            label_Phone.setText("\u624b\u673a\u53f7\uff1a");
            label_Phone.setFont(label_Phone.getFont().deriveFont(label_Phone.getFont().getSize() + 10f));
            panel_Center.add(label_Phone);
            label_Phone.setBounds(new Rectangle(new Point(85, 100), label_Phone.getPreferredSize()));

            //---- label_YZM ----
            label_YZM.setText("\u9a8c\u8bc1\u7801\uff1a");
            label_YZM.setFont(label_YZM.getFont().deriveFont(label_YZM.getFont().getSize() + 10f));
            panel_Center.add(label_YZM);
            label_YZM.setBounds(new Rectangle(new Point(85, 145), label_YZM.getPreferredSize()));
            panel_Center.add(textField_Phone);
            textField_Phone.setBounds(215, 100, 175, 30);
            panel_Center.add(textField_YZM);
            textField_YZM.setBounds(215, 145, 175, 30);

            panel_Center.add(textField_ID);
            textField_ID.setBounds(215, 45, 175, 30);

            //---- button_Sure ----
            button_Sure.setText("\u786e\u5b9a");
            panel_Center.add(button_Sure);
            button_Sure.setBounds(125, 285, 105, 35);

            //---- button_Cancel ----
            button_Cancel.setText("\u53d6\u6d88");
            panel_Center.add(button_Cancel);
            button_Cancel.setBounds(255, 285, 105, 35);

            //---- checkBox_YZM ----
            checkBox_YZM.setEnabled(false);
            checkBox_YZM.setVisible(false);
            panel_Center.add(checkBox_YZM);
            checkBox_YZM.setBounds(390, 145, 30, 35);


            //---- button_Send ----
            button_Send.setText("\u53d1\u9001");
            panel_Center.add(button_Send);
            button_Send.setBounds(new Rectangle(new Point(390, 100), button_Send.getPreferredSize()));

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

        //==== Controller ====
        button_Send.addActionListener(actionCon);
        button_Sure.addActionListener(actionCon);
        button_Cancel.addActionListener(actionCon);


        panel_Center.addFocusListener(actionCon);

        textField_YZM.addFocusListener(actionCon);


    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel_East;
    private JPanel panel_North;
    private JPanel panel_South;
    private JPanel panel_Center;
    private JLabel label_ID;

    private JLabel label_Phone;
    private JLabel label_YZM;
    private JTextField textField_Phone;
    private JTextField textField_YZM;

    private JTextField textField_ID;
    private JButton button_Sure;
    private JButton button_Cancel;
    private JCheckBox checkBox_YZM;

    private JButton button_Send;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public ActionCon actionCon;



    private class ActionCon implements ActionListener, FocusListener {
        private static int YZM;

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button_Send){
                if(textField_Phone.getText().equals("")){
                    JOptionPane.showMessageDialog(panel_Center, "手机号为空！\n请您输入完整的手机号。","输入提示",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if(phone_check()){
                    Random random = new Random();
                    int newYZM = random.nextInt(10000) + 10000;
                    YZM = newYZM;
                    System.out.println("验证码为：" + newYZM);
                }
                else {
                    JOptionPane.showMessageDialog( panel_Center,"发送失败。\n请检查ID和电话号码是否匹配！","发送提示",JOptionPane.WARNING_MESSAGE);

                }

            }

            else if(e.getSource() == button_Sure){
                if(checkBox_YZM.isShowing() ){
                        int n = JOptionPane.showConfirmDialog(panel_Center, "请考虑是否确认注销账户！","注销确认",
                                JOptionPane.OK_CANCEL_OPTION);
                        if(n == JOptionPane.OK_OPTION){
                            int delete_count = delete_check();
                            if(delete_count == 1)
                                JOptionPane.showMessageDialog( panel_Center,"已成功注销该账户","注销提示",JOptionPane.WARNING_MESSAGE);
                            else if(delete_count == 0)
                                JOptionPane.showMessageDialog( panel_Center,"注销失败。\n请检查ID是否符合规范！数据库中无此ID。","注销提示",JOptionPane.WARNING_MESSAGE);
                            else if(delete_count == -1)
                                JOptionPane.showMessageDialog( panel_Center,"注销失败。\n数据库删除数据失败","注销提示",JOptionPane.WARNING_MESSAGE);
                            dispose();
                        }

                    }

                }


            else if(e.getSource() == button_Cancel)
                dispose();


        }

        @Override
        public void focusGained(FocusEvent e) {

        }

        @Override
        public void focusLost(FocusEvent e) {
            if(e.getSource() == textField_YZM)
                if(!textField_YZM.getText().equals("") & Integer.parseInt(textField_YZM.getText()) == YZM){
                    checkBox_YZM.setVisible(true);
//                    checkBox_YZM.setEnabled(true);
                    checkBox_YZM.setSelected(true);
                }


            if(e.getSource() == panel_Center)
                    System.out.println("Center");
        }
    }


    private int delete_check(){
        try {
            return LinkDatabase.deleteUser(Integer.parseInt(textField_ID.getText()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private boolean phone_check(){
        try {
            return LinkDatabase.phone_check(Integer.parseInt(textField_ID.getText()),
                    textField_Phone.getText(), "客户");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


