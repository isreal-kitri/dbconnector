import model.Weather;
import saxparsing.XMLParserService_weather;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.List;


public class DBConnector_weather {



    public static void main(String[] args) {

        // 1.mySQL 데이터베이스 JDBC 드라이버를 로딩한다

        try {

            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("driver loading ok..");

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        //파싱된 데이터 호출
        List<Weather> weatherList = new XMLParserService_weather().XMLParserSAX();

        // 2.데이터베이스와 연결을 수행한다.

        // 즉, Connection 객체를 만든다.

        //String dburl = "jdbc:mysql://localhost:3306/isreal?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        String dburl = "jdbc:mysql://192.168.0.23:3306/isreal?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "admin";

        String password = "kitri";

        try {

            Connection conn =

                    DriverManager.getConnection(dburl, username, password);

            System.out.println("Connection ok..");



            //3. SQL문을 DB로 전달한다.(열 이름과 삽입 값을 모두 지정)

            for (Weather e : weatherList) {
                StringBuffer sql = new StringBuffer(" INSERT INTO name" +
                        " (name_location_code," +
                        " location_engname," +
                        " date," +
                        " temp_avg," +
                        " temp_max," +
                        " temp_min," +
                        " humidity_avg," +
                        " ws_avg," +
                        " rainfall)" +
                        " VALUES (?, ? ,? ,? ,? ,? ,? ,? ,?) ");

                PreparedStatement psmt = conn.prepareStatement(sql.toString());

                psmt.setInt(1, e.getLocNumber());
                psmt.setString(2, e.getLocName());
                psmt.setString(3, e.getDate());
                psmt.setDouble(4, e.getAvgTemp());
                psmt.setDouble(5, e.getMaxTemp());
                psmt.setDouble(6, e.getMinTemp());
                psmt.setDouble(7, e.getAvgHumidity());
                psmt.setDouble(8, e.getAvgWind());
                psmt.setDouble(9, e.getAvgRain());

                psmt.executeUpdate();

                System.out.println("insert ok..");


            }
            conn.close();
//            for(int i = 0; i<16; i++) {
//                psmt.setInt(1,i);
//                psmt.setString(2, "");
//                psmt.setString(3, "");
//                psmt.setFloat(4, i);
//                psmt.setFloat(5, i);
//                psmt.setFloat(6, i);
//                psmt.setFloat(7, i);
//                psmt.setFloat(8, i);
//                psmt.setFloat(9, i);
//                psmt.addBatch();
//                psmt.clearParameters();
//            }
//            psmt.executeBatch();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}
