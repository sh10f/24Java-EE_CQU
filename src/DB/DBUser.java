package DB;

import Model.Order;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;

public class DBUser {
    // ------- 向 expressorder 中指定订单插入评论 -------
    public static boolean insert_Comment(int EOid, String comment) throws SQLException {
        String sql = "UPDATE expressorder SET EOComment = ? WHERE EOid = ?";
        PreparedStatement pstmt = LinkDatabase.conn.prepareStatement(sql);
        pstmt.setString(1, comment);
        pstmt.setInt(2, EOid);

        int count = pstmt.executeUpdate();
        pstmt.close();
        if(count > 0)
            return true;
        else
            return false;
    }

    // ------- 检验 expressorder 中是否存在该订单 -------
    public static boolean exist_EOid(int EOid) throws SQLException {
        String sql = "select * FROM expressorder where EOid  = " + EOid;
        Statement st = LinkDatabase.conn.createStatement();

        ResultSet rs = st.executeQuery(sql);

        return rs.next();
    }

    // ------- 检验 userorder 中是否存在该订单 --------
    public static boolean exist_EOid_uid(int uid, int EOid) throws SQLException {
        String sql = "select * FROM userorder where EOid  = " + EOid + " and Uid = " + uid;
        Statement st = LinkDatabase.conn.createStatement();

        ResultSet rs = st.executeQuery(sql);

        return rs.next();
    }

    //----- 返回 uid 对应的电话号码 -----
    // ----- 用于 一键导入数据 ------
    public static String find_phone(int uid) throws SQLException {
        String sql = "select UPhone FROM user where Uid  = " + uid;
        Statement st = LinkDatabase.conn.createStatement();

        ResultSet rs = st.executeQuery(sql);
        rs.next();
        return rs.getString("UPhone");
    }

    //----- 返回 uid 对应的name -----
    // ----- 用于 一键导入数据 ------
    public static String find_uname(int uid) throws SQLException {
        String sql = "select Uname FROM user where Uid  = " + uid;
        Statement st = LinkDatabase.conn.createStatement();

        ResultSet rs = st.executeQuery(sql);
        rs.next();
        return rs.getString("Uname");
    }

    // ------- 向 expressorder 中插入数据 --------
    public static boolean insertOrder(Order order, int uid) throws SQLException {
        boolean result = true;
        String sql = "INSERT INTO expressorder(EOSender, EOPhoneSender, EOSenderAddr, EOWeight, EOtime, " +
                "EOReceiver, EOPhoneReceiver, EOReceiverAddr, EOItemClass, EOState) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // 获取当前时间, 定义日期时间格式, 格式化当前时间
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        PreparedStatement prst = LinkDatabase.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        prst.setString(1, order.getEOsender());
        prst.setString(2, order.getEOPhoneS());
        prst.setString(3, order.getEOSenderAddr());
        prst.setInt(4, order.getEOWeight());
        prst.setTimestamp(5, Timestamp.valueOf(formattedDateTime));
        prst.setString(6, order.getEOReceiver());
        prst.setString(7, order.getEOPhoneReceiver());
        prst.setString(8, order.getEOReceiverAddr());
        prst.setString(9, order.getItemClass());
        prst.setString(10, "已下订单");


        int count = prst.executeUpdate();
        int generatedEOId = 0;

        if(count > 0){
            ResultSet generatedKeys = prst.getGeneratedKeys();
            if (generatedKeys.next()) {
                generatedEOId = generatedKeys.getInt(1);
                result = true;}
        }
        else
            result = false;

        prst.close();

        return result && insertUserOrder(uid, generatedEOId);

    }

    // ------- 向 Userorder 中插入数据 -------
    public static boolean insertUserOrder(int uid, int eoid) throws SQLException {
        boolean result;
        if(eoid == 0)
            return false;

        String sql = "INSERT INTO userorder(Uid, EOid) values (?, ?)";

        PreparedStatement prst = LinkDatabase.conn.prepareStatement(sql);

        prst.setInt(1, uid);
        prst.setInt(2, eoid);

        int count = prst.executeUpdate();

        if(count > 0)
            result = true;
        else
            result = false;

        prst.close();
        return result;
    }



    public static DefaultTableModel check_EOid(int EOid) throws SQLException {
        String sql = "select EOid, RIGHT(EOPhoneSender, 4), EOSenderAddr, EOWeight, EOtime, " +
                "RIGHT(EOPhoneReceiver, 4), EOReceiverAddr, EOItemClass, EOState" +
                " from expressorder eo where eo.EOid  = " + EOid;
        Statement st = LinkDatabase.conn.createStatement();

        ResultSet rs = st.executeQuery(sql);
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        String[] columnNames = new String[columnCount];

        for (int i = 1; i <= columnCount; i++) {
            columnNames[i - 1] = metaData.getColumnName(i);
        }

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        while (rs.next()) {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = rs.getObject(i);
            }
            model.addRow(rowData);
        }

        return model;


    }

}
