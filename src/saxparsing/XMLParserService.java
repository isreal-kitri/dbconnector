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

public class XMLParserService {

    public List<Weather> XMLParserSAX() {

        List<Weather> parsingResult = new ArrayList<>();

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();

            MyHandler handler = new MyHandler();

            File file = new File("src\\daily-weather.xml");
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
                        e.setDate("2016-09-0" + e.getDate());
                    } else if (Integer.parseInt(e.getDate()) >= 10) {
                        e.setDate("2016-09-" + e.getDate());
                    } else {}
                } catch (NumberFormatException ne) {}
            }

            for (Weather e : parsingResult) {
                System.out.println(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return parsingResult;
    }//main
}
