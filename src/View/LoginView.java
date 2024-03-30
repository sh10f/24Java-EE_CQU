package View;

import com.sun.jdi.event.ExceptionEvent;

import javax.swing.*;

public class LoginView extends JFrame {
    JPanel jPanel_main;

    JLabel jLabel_UserName;
    JLabel jLabel_PassWord;

    JTextField jTextField_UserName;
    JPasswordField jPasswordField;

    JButton jButton_Register;
    JButton jButton_Login;

    LoginView(){
        setSize(660, 510);
        setTitle("Main");
        init();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void init(){
        // create components
        jPanel_main = new JPanel(null);
        jLabel_UserName = new JLabel("User: ");
        jLabel_PassWord = new JLabel("Password: ");

        jTextField_UserName = new JTextField();

        jPasswordField = new JPasswordField();
    }


}
