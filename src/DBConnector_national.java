import model.NationalPark;
import saxparsing.XMLParserService_national;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DBConnector_national {
    public static void main(String[] args) {

        // 1.mySQL 데이터베이스 JDBC 드라이버를 로딩한다

        try {

            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("driver loading ok..");

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        //파싱된 데이터 호출
        List<NationalPark> nationalParkList = new XMLParserService_national().XMLParserSAX();

        // 2.데이터베이스와 연결을 수행한다.

        // 즉, Connection 객체를 만든다.

        String dburl = "jdbc:mysql://localhost:3306/isreal?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        String username = "admin";

        String password = "kitri";

        try {

            Connection conn =

                    DriverManager.getConnection(dburl, username, password);

            System.out.println("Connection ok..");



            //3. SQL문을 DB로 전달한다.(열 이름과 삽입 값을 모두 지정)

            for (NationalPark e : nationalParkList) {
                StringBuffer sql = new StringBuffer(" INSERT INTO naejangsan" +
                        " (najangsan_code," +
                        " mount_name," +
                        " location," +
                        " altitude," +
                        " top100_fm_sel_reason," +
                        " mnt_infor," +
                        " transport)" +
                        " VALUES (?, ? ,? ,? ,? ,? ,?) ");
                PreparedStatement psmt = conn.prepareStatement(sql.toString());

                psmt.setInt(1, e.getLocNumber());
                psmt.setString(2, e.getLocName());
                psmt.setString(3, e.getLocation());
                psmt.setDouble(4, e.getAltitude());
                psmt.setString(5, e.getTop100Reason());
                psmt.setString(6, e.getMntInf());
                psmt.setString(7, e.getTransport());


                psmt.executeUpdate();

                System.out.println("insert ok..");


            }
            conn.close();


        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
}
