package saxparsing;

import model.NationalPark;
import org.xml.sax.InputSource;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLParserService_national {
    public List<NationalPark> XMLParserSAX() {

        List<NationalPark> parsingResult = new ArrayList<>();

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();

            MyHandler_national handler = new MyHandler_national();

            File file = new File("src\\model\\parsingList\\nationalPark\\jeonla.xml");
            //File file = new File("C:\\Users\\danawacomputer\\IdeaProjects\\dbconnector\\src\\daily-weather.xml");

            InputStream inputStream = new FileInputStream(file);
            Reader reader = new InputStreamReader(inputStream, "UTF-8");

            InputSource is = new InputSource(reader);
            is.setEncoding("UTF-8");

            saxParser.parse(is, handler);

            System.out.println(handler.getNationalParkList());

            parsingResult = handler.getNationalParkList();


            System.out.println("파싱 끝!!!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return parsingResult;
    }
}
