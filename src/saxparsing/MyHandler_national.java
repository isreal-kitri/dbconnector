package saxparsing;

import model.NationalPark;
import model.NationalParkLoc;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyHandler_national extends DefaultHandler {

    private List<NationalPark> nationalParkList;
    private NationalPark nationalPark;
    private NationalParkLoc nationalParkLoc;

    public List<NationalPark> getNationalParkList() {
        return nationalParkList;
    }

    private boolean bmntncd = false;
    private boolean bmntnm = false;
    private boolean bareanm = false;
    private boolean bmntheight = false;
    private boolean baeatreason = false;
    private boolean bdetails = false;
    private boolean btransport = false;

    private String tempString;

    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes) throws SAXException {

        System.out.println("Start Element :" + qName);

        if (qName.equalsIgnoreCase("item")) {
            nationalPark = new NationalPark();
            if (nationalParkList == null) {
                nationalParkList = new ArrayList<>();
            }
        } else if (qName.equalsIgnoreCase("mntncd")) {
            bmntncd = true;
        } else if (qName.equalsIgnoreCase("mntnm")) {
            bmntnm = true;
        } else if (qName.equalsIgnoreCase("areanm")) {
            bareanm = true;
        } else if (qName.equalsIgnoreCase("mntheight")) {
            bmntheight = true;
        } else if (qName.equalsIgnoreCase("aeatreason")) {
            nationalParkLoc = new NationalParkLoc();
            baeatreason = true;
        } else if (qName.equalsIgnoreCase("details")) {
            bdetails = true;
        } else if (qName.equalsIgnoreCase("transport")) {
            btransport = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        System.out.println("End Element :" + qName);

        if (qName.equalsIgnoreCase("item")) {
            nationalPark.setLocNumber(nationalParkLoc.getLocNumber());
            nationalPark.setLocName(nationalParkLoc.getLocName());
            nationalParkList.add(nationalPark);
            System.out.println(nationalParkList);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        tempString = new String(ch, start, length).trim();

//        int intStr = 0;
//        try {
//            intStr = Integer.parseInt(tempString.trim());
//        } catch (NumberFormatException e) {
//            intStr = 0;
//        }

        if (bmntncd) {
            System.out.println("산코드: " + tempString);
            if (tempString.equals("")) {
                bmntncd = true;
            } else {
                    nationalParkLoc.setLocNumber(Long.parseLong(tempString.trim()));
                    //nationalParkLoc.setLocNumber(intStr);
                    System.out.println(nationalParkLoc);
                    bmntncd = false;
                }
            }
            if (bmntnm) {
                System.out.println("산이름 : " + tempString);
                if (tempString.equals("")) {
                    bmntnm = true;
                } else {
                    nationalParkLoc.setLocName(tempString);
                    System.out.println(nationalParkLoc);
                    bmntnm = false;
                }
            } else if (bareanm) {
                System.out.println("위치정보 : " + tempString);
                if (tempString.equals("")) {
                    bareanm = true;
                } else {
                    nationalPark.setLocation(tempString);
                    System.out.println(nationalPark);
                    bareanm = false;
                }
            } else if (bmntheight) {
                System.out.println("해발고도 : " + tempString);
                if (tempString.equals("")) {
                    bmntheight = true;
                } else {
                    nationalPark.setAltitude(Double.parseDouble(tempString));
                    System.out.println(nationalPark);
                    bmntheight = false;
                }
            } else if (baeatreason) {
                System.out.println("100대 명산 선정 이유 : " + tempString);
                if (tempString.equals("")) {
                    baeatreason = true;
                } else {
                        nationalPark.setTop100Reason(tempString);
                        System.out.println(nationalPark);
                        baeatreason = false;
                    }
                }
                if (bdetails) {
                    System.out.println("산 정보 : " + tempString);
                    if (tempString.equals("")) {
                        bdetails = true;
                    } else {
                        nationalPark.setMntInf(tempString);
                        System.out.println(nationalPark);
                        bdetails = false;
                    }
                } else if (btransport) {
                    System.out.println("대중교통 : " + tempString);
                    if (tempString.equals("")) {
                        btransport = true;
                    } else {
                        nationalPark.setTransport(tempString);
                        System.out.println(nationalPark);
                        btransport = false;

                    }
                }
            }
        }//characters



