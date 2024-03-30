package DB;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class LinkDatabase {
    private static String driverName="com.mysql.cj.jdbc.Driver";
    private static String dbURL="jdbc:mysql://localhost:3306/lms";
    private static String userName="root";
    private static String userPwd="123456";
    public static Connection conn=null;

    public static void DB_link() throws Exception {

        driverName = "com.mysql.cj.jdbc.Driver";
        dbURL = "jdbc:mysql://localhost:3306/lms";
        userName = "root";
        userPwd = "123456";
        conn = null;

        Class.forName(driverName);
        conn = DriverManager.getConnection(dbURL, userName, userPwd);
    }

    public static boolean DB_Login(int uid, String uPassWord, String uClass) throws Exception
    {
        boolean result;
        String sql;
        switch (uClass){
            case "客户" -> sql = "SELECT * from user WHERE Uid = ? and UPassWord = ? ";
            case "司机" -> sql = "SELECT * from driver WHERE Did = ? and DPassWord = ? ";
            case "管理员" -> sql = "SELECT * from manager WHERE Mid = ? and MPassWord = ? ";
            default -> sql = "";
        }
        if(sql.equals(""))
            return false;

        PreparedStatement prst = conn.prepareStatement(sql);

        prst.setInt(1, uid);
        prst.setString(2, uPassWord);

        ResultSet rs = prst.executeQuery();

        if(rs.next())
            result = true;
        else
            result = false;

        prst.close();
        return result;
    }

    public static void endDBConnect() throws SQLException {
        conn.close();
    }

    // ======= updatePW ======
    // ------ 忘记密码时重新设置密码 -------
    public static boolean updatePW(int uid, String uPassWord, String uClass) throws SQLException {
        boolean result;
        String sql;
        switch (uClass){
            case "客户" -> sql = "UPDATE user set UPassWord = ? WHERE Uid = ? ";
            case "司机" -> sql = "UPDATE driver set DPassWord = ? WHERE Did = ? ";
            case "管理员" -> sql = "UPDATE manager set MPassWord = ? WHERE Mid = ? ";
            default -> sql = "";
        }
        if(sql.equals(""))
            return false;

        PreparedStatement prst = conn.prepareStatement(sql);

        prst.setInt(2, uid);
        prst.setString(1, uPassWord);



        int count = prst.executeUpdate();

        if(count > 0)
            result = true;
        else
            result = false;

        prst.close();
        return result;
    }


    // ===== phone_check =====
    // ----- 检验手机号和用户是否对得上 ------
    // ----- 用于忘记密码时收取验证码 ------
    public static boolean phone_check(int uid, String phone, String uClass) throws SQLException {
        boolean result;
        String sql;
        switch (uClass){
            case "客户" -> sql = "SELECT * FROM user WHERE Uid = ? and UPhone = ?";
            case "司机" -> sql = "SELECT * FROM driver WHERE Did = ? and DPhone = ?";
            case "管理员" -> sql = "SELECT * FROM manager WHERE Mid = ? and MPhone = ?";
            default -> sql = "";
        }

        if(sql.equals(""))
            return false;

        PreparedStatement prst = conn.prepareStatement(sql);

        prst.setInt(1, uid);
        prst.setString(2, phone);



        ResultSet rs = prst.executeQuery();

        if(rs.next())
            result = true;
        else
            result = false;

        prst.close();
        return result;
    }


    public static int insertUser(String phone, String userPwd, String uName) throws SQLException {
        int result;
        if(!phone.equals("")){
            String sql_find = "SELECT * FROM user WHERE UPhone = ?";
            PreparedStatement prst_find = conn.prepareStatement(sql_find);
            prst_find.setString(1, phone);

            ResultSet rs = prst_find.executeQuery();
            int count_finded = 0;
            while(rs.next())
                count_finded ++;

            if(count_finded >= 2){
                prst_find.close();
                return -1;
            }
        }


        String sql = "INSERT INTO user(Uname, UPassWord, UPhone, UClass) values (?, ?, ?, ?)";

        PreparedStatement prst = conn.prepareStatement(sql);

        prst.setString(1, uName);
        prst.setString(2, userPwd);
        prst.setString(3, phone);
        prst.setString(4, "客户");

        int count = prst.executeUpdate();

        if(count > 0)
            result = 1;
        else
            result = 0;

        prst.close();
        return result;
    }


    public static int getCurrUid() throws SQLException {
            String sql_find = "SELECT *" +
                    "     FROM user " +
                    "     ORDER BY Uid DESC";
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql_find);
            rs.next();
            int result = rs.getInt("Uid");
            return result;
    }


    public static DefaultTableModel EO_query(int Uid) throws SQLException {
        String sql = "select * from expressorder eo where eo.EOid in (select EOid from userorder  uo where uo.Uid = " + Uid + ")";
        Statement st = conn.createStatement();

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
