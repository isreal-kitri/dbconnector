/**
 * Created by danawacomputer on 2017-07-31.
 */
package saxparsing;

import model.Weather;
import model.WeatherLoc;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyHandler_weather extends DefaultHandler {

    private List<Weather> weatherList = null;
    private Weather weather = null;
    private WeatherLoc weatherLoc = null;

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    private boolean bstnid = false;
    private boolean bstnen = false;
    private boolean btm = false;
    private boolean bta = false;
    private boolean btamax = false;
    private boolean btamin = false;
    private boolean bhm = false;
    private boolean bws = false;
    private boolean brnday = false;

    private String tempString;

    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes) throws SAXException {

        System.out.println("Start Element :" + qName);

        if (qName.equalsIgnoreCase("stn_id")) {
            weatherLoc = new WeatherLoc();
            bstnid = true;
        } else if (qName.equalsIgnoreCase("stn_en")) {
            bstnen = true;
        } else if (qName.equalsIgnoreCase("info")) {
            weather = new Weather();
            if (weatherList == null) {
                weatherList = new ArrayList<>();
            }
        } else if (qName.equalsIgnoreCase("stn_id")) {
            bstnid = true;
        } else if (qName.equalsIgnoreCase("stn_en")) {
            bstnen = true;
        } else if (qName.equalsIgnoreCase("tm")) {
            btm = true;
        } else if (qName.equalsIgnoreCase("ta")) {
            bta = true;
        } else if (qName.equalsIgnoreCase("ta_max")) {
            btamax = true;
        } else if (qName.equalsIgnoreCase("ta_min")) {
            btamin = true;
        } else if (qName.equalsIgnoreCase("hm")) {
            bhm = true;
        } else if (qName.equalsIgnoreCase("ws")) {
            bws = true;
        } else if (qName.equalsIgnoreCase("rn_day")) {
            brnday = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        System.out.println("End Element :" + qName);

        if (qName.equalsIgnoreCase("info")) {
            weather.setLocNumber(weatherLoc.getLocNumber());
            weather.setLocName(weatherLoc.getLocName());
            weatherList.add(weather);
            System.out.println(weatherList);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        tempString = new String(ch, start, length).trim();

        double doubleStr = 0;
        try {
            doubleStr = Double.parseDouble(tempString);
        } catch (NumberFormatException e) {

        }

        if (bstnid) {
            System.out.println("지역코드: " + tempString);
            weatherLoc.setLocNumber(Integer.parseInt(tempString));
            System.out.println(weatherLoc);
            bstnid = false;
        } else if (bstnen) {
            System.out.println("지역이름: " + tempString);
            if (tempString.equals("")) {
                bstnen = true;
            } else {
                weatherLoc.setLocName(tempString);
                System.out.println(weatherLoc);
                bstnen = false;
            }
        } else if (btm) {
            System.out.println("날짜(일) : " + tempString);
            if (tempString.equals("")) {
                btm = true;
            } else {
                weather.setDate(tempString);
                System.out.println(weather);
                btm = false;
            }
        } else if (bta) {
            System.out.println("평균기온 : " + tempString);
            if (tempString.equals("")) {
                bta = true;
            } else {
                if (tempString.equals("null")) {
                    weather.setAvgTemp(0);
                    System.out.println(weather);
                    bta = false;
                } else {
                    weather.setAvgTemp(doubleStr);
                    System.out.println(weather);
                    bta = false;
                }
            }
            if (btamax) {
                System.out.println("최고기온 : " + tempString);
                if (tempString.equals("")) {
                    btamax = true;
                } else {
                    weather.setMaxTemp(doubleStr);
                    System.out.println(weather);
                    btamax = false;
                }
            } else if (btamin) {
                System.out.println("최소기온 : " + tempString);
                if (tempString.equals("")) {
                    btamin = true;
                } else {
                    weather.setMinTemp(doubleStr);
                    System.out.println(weather);
                    btamin = false;
                }
            } else if (bhm) {
                System.out.println("평균상대습도 : " + tempString);
                if (tempString.equals("")) {
                    bhm = true;
                } else {
                    weather.setAvgHumidity(doubleStr);
                    System.out.println(weather);
                    bhm = false;
                }
            } else if (bws) {
                System.out.println("평균풍속 : " + tempString);
                if (tempString.equals("")) {
                    bws = true;
                } else {
                    weather.setAvgWind(doubleStr);
                    System.out.println(weather);
                    bws = false;
                }
            } else if (brnday) {
                System.out.println("강수량 : " + tempString);
                if (tempString.equals("")) {
                    brnday = true;
                } else {
                    if (tempString.equals("null")) {
                        weather.setAvgRain(0);
                        System.out.println(weather);
                        brnday = false;
                    } else {
                        weather.setAvgRain(doubleStr);
                        System.out.println(weather);
                        brnday = false;
                    }
                }
            }
        }//characters

    }
}
