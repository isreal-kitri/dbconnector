package parsing;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MapParsing {

    public List<String> MapParsing() {
        List<String> LatLng = new ArrayList<>();
        String corSample = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader
                    ("src\\model/parsingList/coordination/태백산.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                corSample = line;
                String aa = corSample.replaceAll("courseArr.push", "");
                String aaa = aa.substring(1, aa.length() - 2);
                String aaaa = aaa.substring(aaa.indexOf("37"));
                String aaaaa = aaaa.replace("'", "");
                String aaaaaa= aaaaa.replace(",", "");
                LatLng.add(aaaaaa);
                br.readLine();
                br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return LatLng;
    }

}
