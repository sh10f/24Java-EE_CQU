package Controler;

import View.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Action_Con implements ActionListener {
     MainView view;

    public void setView(MainView view){
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.button_Login){
            if(view.label_User.getText() == null)
                JOptionPane.showMessageDialog(view, "用户id输入为空！\n请您输入完整的用户id。","输入提示",JOptionPane.WARNING_MESSAGE);
            else if( view.label_PassWord.getText() == null)
                JOptionPane.showMessageDialog(view, "密码输入为空！\n请您输入完整的密码。","输入提示",JOptionPane.WARNING_MESSAGE);
            else{
                if(view.label_User.getText() == "123" && view.label_PassWord.getText() == "123")
                    System.out.println("good");
            }

        }

    }
}


