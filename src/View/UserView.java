/*
 * Created by JFormDesigner on Fri Mar 29 14:12:17 CST 2024
 */

package View;

import DB.DBUser;
import DB.LinkDatabase;
import Model.Order;
import Model.User;

import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 * @author Lenovo
 */
public class UserView extends JFrame {
    public UserView(User user) {
        this.user = user;
        setTitle("物流管理系统用户界面");
        initComponents();

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents() {
        String [] strings_ItemClass = {"文件", "数码产品", "生活产品", "服饰", "食品", "其他"};
        actionCon = new ActionCon();
        order = new Order();


        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        tabbedPane1 = new JTabbedPane();
        panel_OManage = new JPanel();
        label_OM_order = new JLabel();
        textField_OM_Oid = new JTextField();
        button_OM_find = new JButton();
        scrollPane_OM = new JScrollPane();
        table_OM = new JTable();
        panel_AddO = new JPanel();
        label_North = new JLabel();
        panel_AddO_Center = new JPanel();
        panel_AddO_C_C = new JPanel();
        label_AddO_name = new JLabel();
        label_AddO_Phone = new JLabel();
        label_AddO_Addr = new JLabel();
        textField_AO_name = new JTextField();
        textField_AO_Phone = new JTextField();
        textField_AO_Addr = new JTextField();
        checkBox_AO = new JCheckBox();
        label_AO_Rname = new JLabel();
        label_AO_RPhone = new JLabel();
        label_AO_RAddr = new JLabel();
        textField_AO_Rname = new JTextField();
        textField_AO_RPhone = new JTextField();
        textField_AO_Raddr = new JTextField();

        comboBox_AO_ItemClass = new JComboBox(strings_ItemClass);
        label_AO_class = new JLabel();
        label_AO_weight = new JLabel();
        radioButton_AO_W1 = new JRadioButton();
        radioButton_AO_W2 = new JRadioButton();
        radioButton_AO_Wother = new JRadioButton();
        spinner_AO_w = new JSpinner();
        separator1 = new JSeparator();
        label_sendImg = new JLabel();
        label_receiveImg = new JLabel();
        button_AddO_South = new JButton();
        panel_CM = new JPanel();
        label_CM_order = new JLabel();
        label_CM_cm = new JLabel();
        scrollPane_CM = new JScrollPane();
        textArea_CM = new JTextArea();
        button_CM_sure = new JButton();
        textField_CM_order = new JTextField();
        button_CM_commit = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== tabbedPane1 ========
        {
            tabbedPane1.setTabPlacement(SwingConstants.LEFT);
            tabbedPane1.setFont(tabbedPane1.getFont().deriveFont(tabbedPane1.getFont().getStyle() | Font.BOLD, tabbedPane1.getFont().getSize() + 5f));
            tabbedPane1.setForeground(new Color(0x2e9bf3));

            //======== panel_OManage ========
            {
                panel_OManage.setLayout(null);

                //---- label_OM_order ----
                label_OM_order.setText("\u8ba2\u5355\u53f7\uff1a ");
                label_OM_order.setFont(label_OM_order.getFont().deriveFont(Font.PLAIN, label_OM_order.getFont().getSize() + 5f));
                panel_OManage.add(label_OM_order);
                label_OM_order.setBounds(65, 15, 85, 30);
                panel_OManage.add(textField_OM_Oid);
                textField_OM_Oid.setBounds(145, 20, 175, 25);

                //---- button_OM_find ----
                button_OM_find.setText("\u67e5\u8be2");
                button_OM_find.setToolTipText("\u9ed8\u8ba4\u67e5\u8be2\u5f53\u524d\u8d26\u6237\u8ba2\u5355");
                panel_OManage.add(button_OM_find);
                button_OM_find.setBounds(new Rectangle(new Point(345, 20), button_OM_find.getPreferredSize()));

                //======== scrollPane_OM ========
                {
                    scrollPane_OM.setViewportView(table_OM);
                    scrollPane_OM.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    scrollPane_OM.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                }
                panel_OManage.add(scrollPane_OM);
                scrollPane_OM.setBounds(65, 60, 700, 305);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel_OManage.getComponentCount(); i++) {
                        Rectangle bounds = panel_OManage.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel_OManage.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel_OManage.setMinimumSize(preferredSize);
                    panel_OManage.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u8ba2\u5355\u7ba1\u7406", panel_OManage);

            //======== panel_AddO ========
            {
                panel_AddO.setLayout(new BorderLayout());

                //---- label_North ----
                label_North.setText("\u9884\u7ea6\u5bc4\u4ef6");
                label_North.setIcon(new ImageIcon("D:\\CodeField\\Code_Java\\Project\\imgs\\UserView\\North_Left_System.png"));
                label_North.setFont(label_North.getFont().deriveFont(label_North.getFont().getStyle() | Font.BOLD, label_North.getFont().getSize() + 10f));
                label_North.setForeground(new Color(0x2e9bf3));
                panel_AddO.add(label_North, BorderLayout.NORTH);

                //======== panel_AddO_Center ========
                {
                    panel_AddO_Center.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel_AddO_Center.getLayout()).columnWidths = new int[] {0, 0};
                    ((GridBagLayout)panel_AddO_Center.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
                    ((GridBagLayout)panel_AddO_Center.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                    ((GridBagLayout)panel_AddO_Center.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0, 1.0E-4};

                    //======== panel_AddO_C_C ========
                    {
                        panel_AddO_C_C.setBackground(Color.white);
                        panel_AddO_C_C.setLayout(null);

                        //---- label_AddO_name ----
                        label_AddO_name.setText("\u59d3\u540d\uff1a");
                        label_AddO_name.setFont(label_AddO_name.getFont().deriveFont(label_AddO_name.getFont().getSize() + 5f));
                        panel_AddO_C_C.add(label_AddO_name);
                        label_AddO_name.setBounds(140, 20, 60, 20);

                        //---- label_AddO_Phone ----
                        label_AddO_Phone.setText("\u7535\u8bdd\uff1a");
                        label_AddO_Phone.setFont(label_AddO_Phone.getFont().deriveFont(label_AddO_Phone.getFont().getSize() + 5f));
                        panel_AddO_C_C.add(label_AddO_Phone);
                        label_AddO_Phone.setBounds(140, 50, 60, label_AddO_Phone.getPreferredSize().height);

                        //---- label_AddO_Addr ----
                        label_AddO_Addr.setText("\u8be6\u7ec6\u5730\u5740\uff1a");
                        label_AddO_Addr.setFont(label_AddO_Addr.getFont().deriveFont(label_AddO_Addr.getFont().getSize() + 4f));
                        panel_AddO_C_C.add(label_AddO_Addr);
                        label_AddO_Addr.setBounds(140, 90, 85, 25);
                        panel_AddO_C_C.add(textField_AO_name);
                        textField_AO_name.setBounds(225, 15, 170, 30);
                        panel_AddO_C_C.add(textField_AO_Phone);
                        textField_AO_Phone.setBounds(225, 50, 170, 30);
                        panel_AddO_C_C.add(textField_AO_Addr);
                        textField_AO_Addr.setBounds(225, 85, 220, 30);

                        //---- checkBox_AO ----
                        checkBox_AO.setText("\u5f53\u524d\u8d26\u6237");
                        checkBox_AO.setBackground(Color.white);
                        panel_AddO_C_C.add(checkBox_AO);
                        checkBox_AO.setBounds(new Rectangle(new Point(410, 55), checkBox_AO.getPreferredSize()));

                        //---- label_AO_Rname ----
                        label_AO_Rname.setText("\u59d3\u540d\uff1a");
                        label_AO_Rname.setFont(label_AO_Rname.getFont().deriveFont(label_AO_Rname.getFont().getSize() + 5f));
                        panel_AddO_C_C.add(label_AO_Rname);
                        label_AO_Rname.setBounds(140, 165, 60, 25);

                        //---- label_AO_RPhone ----
                        label_AO_RPhone.setText("\u7535\u8bdd\uff1a");
                        label_AO_RPhone.setFont(label_AO_RPhone.getFont().deriveFont(label_AO_RPhone.getFont().getSize() + 5f));
                        panel_AddO_C_C.add(label_AO_RPhone);
                        label_AO_RPhone.setBounds(140, 200, 55, 30);

                        //---- label_AO_RAddr ----
                        label_AO_RAddr.setText("\u8be6\u7ec6\u5730\u5740\uff1a");
                        label_AO_RAddr.setFont(label_AO_RAddr.getFont().deriveFont(label_AO_RAddr.getFont().getSize() + 4f));
                        panel_AddO_C_C.add(label_AO_RAddr);
                        label_AO_RAddr.setBounds(135, 225, 90, 45);
                        panel_AddO_C_C.add(textField_AO_Rname);
                        textField_AO_Rname.setBounds(225, 165, 175, 30);
                        panel_AddO_C_C.add(textField_AO_RPhone);
                        textField_AO_RPhone.setBounds(225, 200, 175, 30);
                        panel_AddO_C_C.add(textField_AO_Raddr);
                        textField_AO_Raddr.setBounds(225, 235, 220, 30);
                        panel_AddO_C_C.add(comboBox_AO_ItemClass);

                        comboBox_AO_ItemClass.setBounds(515, 165, 150, comboBox_AO_ItemClass.getPreferredSize().height);
                        comboBox_AO_ItemClass.setSelectedIndex(1);
                        //---- label_AO_class ----
                        label_AO_class.setText("\u7269\u54c1\u7c7b\u578b\uff1a");
                        label_AO_class.setFont(label_AO_class.getFont().deriveFont(label_AO_class.getFont().getSize() + 4f));
                        panel_AddO_C_C.add(label_AO_class);
                        label_AO_class.setBounds(new Rectangle(new Point(435, 165), label_AO_class.getPreferredSize()));

                        //---- label_AO_weight ----
                        label_AO_weight.setText("\u9884\u4f30\u91cd\u91cf\uff1a");
                        label_AO_weight.setFont(label_AO_weight.getFont().deriveFont(label_AO_weight.getFont().getSize() + 4f));
                        panel_AddO_C_C.add(label_AO_weight);
                        label_AO_weight.setBounds(new Rectangle(new Point(435, 200), label_AO_weight.getPreferredSize()));

                        //---- radioButton_AO_W1 ----
                        radioButton_AO_W1.setText("1KG");
                        radioButton_AO_W1.setBackground(Color.white);
                        panel_AddO_C_C.add(radioButton_AO_W1);
                        radioButton_AO_W1.setBounds(540, 200, 65, radioButton_AO_W1.getPreferredSize().height);

                        //---- radioButton_AO_W2 ----
                        radioButton_AO_W2.setText("2KG");
                        radioButton_AO_W2.setBackground(Color.white);
                        panel_AddO_C_C.add(radioButton_AO_W2);
                        radioButton_AO_W2.setBounds(610, 200, 60, radioButton_AO_W2.getPreferredSize().height);

                        //---- radioButton_AO_Wother ----
                        radioButton_AO_Wother.setText("\u5176\u4ed6");
                        radioButton_AO_Wother.setBackground(Color.white);
                        panel_AddO_C_C.add(radioButton_AO_Wother);
                        radioButton_AO_Wother.setBounds(540, 235, 60, radioButton_AO_Wother.getPreferredSize().height);

                        //---- spinner_AO_w ----
                        spinner_AO_w.setBackground(Color.white);
                        spinner_AO_w.setEnabled(false);
                        panel_AddO_C_C.add(spinner_AO_w);
                        spinner_AO_w.setBounds(610, 235, 73, spinner_AO_w.getPreferredSize().height);
                        panel_AddO_C_C.add(separator1);
                        separator1.setBounds(170, 140, 430, 23);

                        //---- label_sendImg ----
                        label_sendImg.setIcon(new ImageIcon("D:\\CodeField\\Code_Java\\Project\\imgs\\UserView\\Send_Sig.png"));
                        panel_AddO_C_C.add(label_sendImg);
                        label_sendImg.setBounds(new Rectangle(new Point(70, 5), label_sendImg.getPreferredSize()));

                        //---- label_receiveImg ----
                        label_receiveImg.setIcon(new ImageIcon("D:\\CodeField\\Code_Java\\Project\\imgs\\UserView\\Get_Sig.png"));
                        panel_AddO_C_C.add(label_receiveImg);
                        label_receiveImg.setBounds(new Rectangle(new Point(65, 145), label_receiveImg.getPreferredSize()));

                        {
                            // compute preferred size
                            Dimension preferredSize = new Dimension();
                            for(int i = 0; i < panel_AddO_C_C.getComponentCount(); i++) {
                                Rectangle bounds = panel_AddO_C_C.getComponent(i).getBounds();
                                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                            }
                            Insets insets = panel_AddO_C_C.getInsets();
                            preferredSize.width += insets.right;
                            preferredSize.height += insets.bottom;
                            panel_AddO_C_C.setMinimumSize(preferredSize);
                            panel_AddO_C_C.setPreferredSize(preferredSize);
                        }
                    }
                    panel_AddO_Center.add(panel_AddO_C_C, new GridBagConstraints(0, 0, 1, 2, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));

                    //---- button_AddO_South ----
                    button_AddO_South.setText("\u7acb\u5373\u4e0b\u5355");
                    panel_AddO_Center.add(button_AddO_South, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                panel_AddO.add(panel_AddO_Center, BorderLayout.CENTER);
            }
            tabbedPane1.addTab("\u6dfb\u52a0\u8ba2\u5355", panel_AddO);

            //======== panel_CM ========
            {
                panel_CM.setLayout(null);

                //---- label_CM_order ----
                label_CM_order.setText("\u8ba2\u5355\u53f7\uff1a");
                label_CM_order.setFont(label_CM_order.getFont().deriveFont(label_CM_order.getFont().getStyle() | Font.BOLD, label_CM_order.getFont().getSize() + 5f));
                panel_CM.add(label_CM_order);
                label_CM_order.setBounds(115, 50, 75, label_CM_order.getPreferredSize().height);

                //---- label_CM_cm ----
                label_CM_cm.setText("\u53cd\u9988\uff1a");
                label_CM_cm.setFont(label_CM_cm.getFont().deriveFont(label_CM_cm.getFont().getStyle() | Font.BOLD, label_CM_cm.getFont().getSize() + 5f));
                panel_CM.add(label_CM_cm);
                label_CM_cm.setBounds(115, 120, 70, label_CM_cm.getPreferredSize().height);

                //======== scrollPane_CM ========
                {
                    scrollPane_CM.setViewportView(textArea_CM);
                }
                panel_CM.add(scrollPane_CM);
                scrollPane_CM.setBounds(150, 150, 390, 170);

                //---- button_CM_sure ----
                button_CM_sure.setText("\u9a8c\u8bc1");
                panel_CM.add(button_CM_sure);
                button_CM_sure.setBounds(new Rectangle(new Point(420, 50), button_CM_sure.getPreferredSize()));
                panel_CM.add(textField_CM_order);
                textField_CM_order.setBounds(195, 50, 215, 30);

                //---- button_CM_commit ----
                button_CM_commit.setText("\u63d0\u4ea4");
                panel_CM.add(button_CM_commit);
                button_CM_commit.setBounds(155, 345, 385, 35);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel_CM.getComponentCount(); i++) {
                        Rectangle bounds = panel_CM.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel_CM.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel_CM.setMinimumSize(preferredSize);
                    panel_CM.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u8ba2\u5355\u53cd\u9988", panel_CM);
        }
        contentPane.add(tabbedPane1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on


        //===== Controller =====
        button_CM_sure.addActionListener(actionCon);
        button_CM_commit.addActionListener(actionCon);
        button_OM_find.addActionListener(actionCon);
        button_AddO_South.addActionListener(actionCon);

        checkBox_AO.addActionListener(actionCon);
        radioButton_AO_W1.addActionListener(actionCon);
        radioButton_AO_W2.addActionListener(actionCon);
        radioButton_AO_Wother.addActionListener(actionCon);



        //---- 设置表格内容的鼠标悬停提示  ---------
        table_OM.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Point p = e.getPoint();
                int row = table_OM.rowAtPoint(p);
                int col = table_OM.columnAtPoint(p);
                if (row >= 0 && col >= 0) {
                    Object value = table_OM.getValueAt(row, col);
                    if (value != null) {
                        String tooltip = value.toString();
                        table_OM.setToolTipText(tooltip);
                    }
                }
            }
        });

        //---- set tableHeader Controller ------
        jTableHeader = table_OM.getTableHeader();
        jTableHeader.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Point p = e.getPoint();
                int col = table_OM.columnAtPoint(p);
                if (col >= 0) {
                    TableColumn column = jTableHeader.getColumnModel().getColumn(col);
                    String tooltip = column.getHeaderValue().toString();
                    jTableHeader.setToolTipText(tooltip);
                }
            }
        });

        // -------- 为订单反馈 中的订单号设置焦点监视器 ------
        textField_CM_order.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                vertified = false;
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JTabbedPane tabbedPane1;
    private JPanel panel_OManage;
    private JLabel label_OM_order;
    private JTextField textField_OM_Oid;
    private JButton button_OM_find;
    private JScrollPane scrollPane_OM;
    private JTable table_OM;
    private JPanel panel_AddO;
    private JLabel label_North;
    private JPanel panel_AddO_Center;
    private JPanel panel_AddO_C_C;
    private JLabel label_AddO_name;
    private JLabel label_AddO_Phone;
    private JLabel label_AddO_Addr;
    private JTextField textField_AO_name;
    private JTextField textField_AO_Phone;
    private JTextField textField_AO_Addr;
    private JCheckBox checkBox_AO;
    private JLabel label_AO_Rname;
    private JLabel label_AO_RPhone;
    private JLabel label_AO_RAddr;
    private JTextField textField_AO_Rname;
    private JTextField textField_AO_RPhone;
    private JTextField textField_AO_Raddr;
    private JComboBox comboBox_AO_ItemClass;
    private JLabel label_AO_class;
    private JLabel label_AO_weight;
    private JRadioButton radioButton_AO_W1;
    private JRadioButton radioButton_AO_W2;
    private JRadioButton radioButton_AO_Wother;
    private JSpinner spinner_AO_w;
    private JSeparator separator1;
    private JLabel label_sendImg;
    private JLabel label_receiveImg;
    private JButton button_AddO_South;
    private JPanel panel_CM;
    private JLabel label_CM_order;
    private JLabel label_CM_cm;
    private JScrollPane scrollPane_CM;
    private JTextArea textArea_CM;
    private JButton button_CM_sure;
    private JTextField textField_CM_order;
    private JButton button_CM_commit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public User user;
    public ActionCon actionCon;
    public JTableHeader jTableHeader;
    public Order order;
    public boolean   vertified = false;


    private class ActionCon implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            // ===== 订单管理页面进行订单查询 =====
            if(e.getSource() == button_OM_find){
                DefaultTableModel model;
                if(textField_OM_Oid.getText().equals("")){
                    try {
                        model = LinkDatabase.EO_query(user.getUid());
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    table_OM.setModel(model);
                }

                else {
                    boolean exist_EOid = false;
                    try {
                        if(DBUser.exist_EOid(Integer.parseInt(textField_OM_Oid.getText())))
                            exist_EOid = true;
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    if(!exist_EOid)
                        JOptionPane.showMessageDialog( panel_OManage,"查询失败！\n请您检查订单号是否正确。","输入提示",JOptionPane.WARNING_MESSAGE);
                    else{
                        try {
                            model = DBUser.check_EOid(Integer.parseInt(textField_OM_Oid.getText()));
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }

                        table_OM.setModel(model);
                    }

                }
            }

            // ===== 添加订单页面 ======
            // user 只有 uid， upw， uclass

            // ---- 一键设置寄件人姓名和电话， 根据当前账号 ---------
            if(e.getSource() == checkBox_AO && checkBox_AO.isSelected()){
                String temp_UPhone;
                String temp_Uname;

                try {
                    temp_Uname = DBUser.find_uname(user.getUid());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                textField_AO_name.setText(temp_Uname);

                try {
                    temp_UPhone = DBUser.find_phone(user.getUid());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                textField_AO_Phone.setText(temp_UPhone);
            }

            if(e.getSource() == checkBox_AO && !checkBox_AO.isSelected()){
                textField_AO_name.setText("");
                textField_AO_Phone.setText("");
            }

            //------- 立即下单 ----------
            if(e.getSource() == button_AddO_South){
                System.out.println("sddafaf");
                if(textField_AO_name.getText().equals("") | textField_AO_Phone.equals("") | textField_AO_Addr.equals("")
                | textField_AO_Rname.equals("") | textField_AO_RPhone.equals("") | textField_AO_Raddr.equals("")
                | !(radioButton_AO_W1.isSelected() || radioButton_AO_W2.isSelected() || radioButton_AO_Wother.isSelected())){
                    JOptionPane.showMessageDialog(panel_AddO,"下单失败！\n请您检查输入是否完整。","输入提示",JOptionPane.WARNING_MESSAGE);
                }

                else{
                    // 定义正则表达式
                    String pattern = "^.*省.*市.*区.*街道.*$";

                    Pattern p = Pattern.compile(pattern);
                    Matcher m_addrSender = p.matcher(textField_AO_Addr.getText());
                    Matcher m_addrReceiver = p.matcher(textField_AO_Raddr.getText());

                    if(!m_addrSender.matches() | !m_addrReceiver.matches())
                        JOptionPane.showMessageDialog(panel_AddO,"下单失败！\n请您检查地址是否符合规范。\n规范为： xxx省xxx市xxx区xxx街道xxxx ","输入提示",JOptionPane.WARNING_MESSAGE);

                    if(!(textField_AO_Phone.getText().length()==11) | !(textField_AO_RPhone.getText().length()==11))
                        JOptionPane.showMessageDialog(panel_AddO,"下单失败！\n请您检查电话号码是否符合规范。\n规范为：长度为11 ","输入提示",JOptionPane.WARNING_MESSAGE);

                    if(m_addrSender.matches() && m_addrReceiver.matches() && textField_AO_Phone.getText().length()==11 &&textField_AO_RPhone.getText().length()==11)
                    {
                        setOrder();
                        try {
                            if(DBUser.insertOrder(order, user.getUid())){
                                JOptionPane.showMessageDialog(panel_AddO,"已成功下单！\n请您注意快递信息。","下单提示",JOptionPane.INFORMATION_MESSAGE);
                            }
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }

                    }
                }

            }

            // ----- 重量选择 -----
            // ----- 限制只能选择一个重量------
            if(e.getSource() == radioButton_AO_W1 && radioButton_AO_W1.isSelected()){
                radioButton_AO_W2.setSelected(false);
                radioButton_AO_Wother.setSelected(false);
                spinner_AO_w.setEnabled(false);
            }

            if(e.getSource() == radioButton_AO_W2 && radioButton_AO_W2.isSelected()){
                radioButton_AO_W1.setSelected(false);
                radioButton_AO_Wother.setSelected(false);
                spinner_AO_w.setEnabled(false);
            }

            if(e.getSource() == radioButton_AO_Wother && radioButton_AO_Wother.isSelected()){
                spinner_AO_w.setEnabled(true);
                radioButton_AO_W1.setSelected(false);
                radioButton_AO_W2.setSelected(false);
            }




            //======= 订单反馈页面 =======

            // ------- 验证 订单号与账号的关系 -------
            if(e.getSource() == button_CM_sure){
                vertified = false;
                if(!textField_CM_order.getText().equals(""))
                {
                    try {
                        if(!DBUser.exist_EOid(Integer.parseInt(textField_CM_order.getText())))
                            JOptionPane.showMessageDialog(panel_CM,"验证失败！\n您输入的订单号不存在。","验证提示",JOptionPane.WARNING_MESSAGE);
                        else
                            if(!DBUser.exist_EOid_uid(user.getUid(), Integer.parseInt(textField_CM_order.getText())))
                                JOptionPane.showMessageDialog(panel_CM,"验证失败！\n该订单与您没有联系，您无法为该订单反馈消息。","验证提示",JOptionPane.WARNING_MESSAGE);
                            else{
                                JOptionPane.showMessageDialog(panel_CM,"验证成功！\n","验证提示",JOptionPane.INFORMATION_MESSAGE);
                                vertified = true;
                            }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                }
                else
                    JOptionPane.showMessageDialog(panel_CM,"验证失败！\n。未输入订单号","下单提示",JOptionPane.WARNING_MESSAGE);
            }

            // ------ 提交反馈 ------
            if(e.getSource() == button_CM_commit){
                if(textArea_CM.getText().equals(""))
                    JOptionPane.showMessageDialog(panel_CM,"提交反馈失败！\n。反馈内容为空","提交反馈提示",JOptionPane.WARNING_MESSAGE);
                else{
                    if(vertified) {
                        try {
                            if(DBUser.insert_Comment(Integer.parseInt(textField_CM_order.getText()), textArea_CM.getText()))
                                JOptionPane.showMessageDialog(panel_CM,"提交反馈成功！","提交反馈提示",JOptionPane.INFORMATION_MESSAGE);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    else
                        JOptionPane.showMessageDialog(panel_CM,"提交反馈失败！\n。请您点击验证按钮验证订单号是否符合规范","提交反馈提示",JOptionPane.WARNING_MESSAGE);




                }

            }





        }
    }


    public void setOrder(){
        order.setEOsender(textField_AO_name.getText());
        order.setEOPhoneS(textField_AO_Phone.getText());
        order.setEOSenderAddr(textField_AO_Addr.getText());

        order.setEOReceiver(textField_AO_Rname.getText());
        order.setEOPhoneReceiver(textField_AO_RPhone.getText());
        order.setEOReceiverAddr(textField_AO_Raddr.getText());

        order.setItemClass((String) comboBox_AO_ItemClass.getSelectedItem());

        if(radioButton_AO_W1.isSelected())
            order.setEOWeight(1);
        else if(radioButton_AO_W2.isSelected())
            order.setEOWeight(2);
        else if(radioButton_AO_Wother.isSelected())
            order.setEOWeight((Integer) spinner_AO_w.getValue());

    }



}
