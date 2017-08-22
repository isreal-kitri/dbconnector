import model.NationalPark;
import parsing.MapParsing;
import saxparsing.XMLParserService_national;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DBConnector_coordination {


    public static void main(String[] args) {
        MapParsing XY = new MapParsing();

        // 1.mySQL 데이터베이스 JDBC 드라이버를 로딩한다

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("driver loading ok..");

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        //데이터 호출
        List<String> parsingResultList = XY.MapParsing();

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

            for (String e : parsingResultList) {
                String x;
                String y;
                System.out.println(e);
                int idx = e.indexOf(" ");
                System.out.println(idx);
                x = e.substring(0, idx);
                y = e.substring(idx+1);

                StringBuffer sql = new StringBuffer(" INSERT INTO coordinate_parsing" +
                        " (x_coordinate," +
                        " y_coordinate)" +
                        " VALUES (?, ?) ");
                PreparedStatement psmt = conn.prepareStatement(sql.toString());

                psmt.setDouble(1, Double.parseDouble(x));
                psmt.setDouble(2, Double.parseDouble(y));



                psmt.executeUpdate();

                System.out.println("insert ok..");


            }
            conn.close();


        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}
