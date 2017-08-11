/**
 * Created by danawacomputer on 2017-07-31.
 */

package saxparsing;

import model.Weather;
import org.xml.sax.InputSource;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLParserService_weather {

    public List<Weather> XMLParserSAX() {

        List<Weather> parsingResult = new ArrayList<>();

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();

            MyHandler_weather handler = new MyHandler_weather();

            File file = new File("src\\model\\parsingList\\weather\\yongdeok\\2017_03.xml");
            //File file = new File("C:\\Users\\danawacomputer\\IdeaProjects\\dbconnector\\src\\daily-weather.xml");

            InputStream inputStream= new FileInputStream(file);
            Reader reader = new InputStreamReader(inputStream,"UTF-8");

            InputSource is = new InputSource(reader);
            is.setEncoding("UTF-8");

            saxParser.parse(is, handler);
            System.out.println(handler.getWeatherList());

            parsingResult = handler.getWeatherList();

            for (Weather e : parsingResult) {

                try {
                    if (Integer.parseInt(e.getDate()) < 10) {
                        e.setDate("2017-03-0" + e.getDate());
                    } else if (Integer.parseInt(e.getDate()) >= 10) {
                        e.setDate("2017-03-" + e.getDate());
                    } else {}
                } catch (NumberFormatException ne) {}
            }

//            for (Weather e : parsingResult) {
//                System.out.println(e);
//            }

            System.out.println("파싱 끝!!!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return parsingResult;
    }//main
}
