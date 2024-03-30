import DB.LinkDatabase;
import View.MainView;

import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
            MainView mainView = new MainView();

        try {
            LinkDatabase.DB_link();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}