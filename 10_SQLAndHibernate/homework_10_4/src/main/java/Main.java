import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    private static String url = "jdbc:mysql://localhost:3306/skillbox?serverTimezone=Europe/Moscow";
    private static String user = "mysqlUser";
    private static String pass = "Test1234";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();

            String sql = "SELECT course_name, monthname(subscription_date) AS month, count(*) AS count FROM purchaselist GROUP BY course_name, month(subscription_date);";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String courseName = resultSet.getString("course_name");
                String month = resultSet.getString("month");
                String count = resultSet.getString("count");
                System.out.printf("%-40s\t|\t%-10s\t|\t%s\n", courseName, month, count);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
