import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBConnector_NationalParkCoordinate {
    public static void main(String[] args) {

        // 1.mySQL 데이터베이스 JDBC 드라이버를 로딩한다

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("driver loading ok..");

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }



        // 2.데이터베이스와 연결을 수행한다.

        // 즉, Connection 객체를 만든다.

        String dburl = "jdbc:mysql://192.168.0.23:3306/isreal?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        String username = "admin";

        String password = "kitri";

        try {

            Connection conn =

                    DriverManager.getConnection(dburl, username, password);

            System.out.println("Connection ok..");



            //3. SQL문을 DB로 전달한다.(열 이름과 삽입 값을 모두 지정)


                StringBuffer sql = new StringBuffer(" INSERT INTO coordinate" +
                        " (x_coordinate," +
                        " y_coordinate," +
                        "loc_name)" +
                        " VALUES (?, ?, ?) ");
                PreparedStatement psmt = conn.prepareStatement(sql.toString());

                psmt.setDouble(1, 33.381207);
                psmt.setDouble(2, 126.542284);
                psmt.setString(3, "한라산국립공원");



                psmt.executeUpdate();

                System.out.println("insert ok..");



            conn.close();


        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
}
