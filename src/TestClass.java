import model.Weather;
import saxparsing.XMLParserService;

import java.util.List;

/**
 * Created by danawacomputer on 2017-08-02.
 */
public class TestClass {
    public static void main(String[] args) {

        List<Weather> weatherList = new XMLParserService().XMLParserSAX();

        for (Weather e : weatherList) {
            System.out.println(e);
        }
    }//main
}
