import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.SQLException;




public class DBConnector {



    public static void main(String[] args) {



        // 1.mySQL 데이터베이스 JDBC 드라이버를 로딩한다

        try {

            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("driver loading ok..");

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }



        // 2.데이터베이스와 연결을 수행한다.

        // 즉, Connection 객체를 만든다.

        String dburl = "jdbc:mysql://localhost:3306/isreal?useUnicode=true&amp;characterEncoding=utf8";

        String username = "root";

        String password = "kitri";

        try {

            Connection conn =

                    DriverManager.getConnection(dburl, username, password);

            System.out.println("Connection ok..");



            //3. SQL문을 DB로 전달한다.(열 이름과 삽입 값을 모두 지정)

            StringBuffer sql = new StringBuffer(" INSERT INTO Namwon" +
                    " (Namwon_location_code," +
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

            for(int i = 0; i<16; i++) {
                psmt.setInt(1,i);
                psmt.setString(2, "");
                psmt.setString(3, "");
                psmt.setFloat(4, i);
                psmt.setFloat(5, i);
                psmt.setFloat(6, i);
                psmt.setFloat(7, i);
                psmt.setFloat(8, i);
                psmt.setFloat(9, i);
                psmt.addBatch();
                psmt.clearParameters();
            }
            psmt.executeBatch();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}
