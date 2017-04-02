package ua.nenya.parser;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import ua.nenya.domain.HoverData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TableParser {

    private static final String URL = "https://almsaeedstudio.com/themes/AdminLTE/pages/tables/data.html";

    public List<HoverData> parseHtmlTable() {
        List<HoverData> hoverDatas = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(URL).get();
            Elements tableElements = doc.select("table#example2 > tbody");

            Elements tableRowElements = tableElements.select("tr");

            for (int i = 0; i < tableRowElements.size(); i++) {
                Element row = tableRowElements.get(i);
                Elements rowItems = row.select("td");
                HoverData hoverData = new HoverData();

                for (int j = 0; j < rowItems.size(); j++) {
                    fillHoverData(rowItems.get(j), j, hoverData);
                }
                hoverDatas.add(hoverData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return hoverDatas;
    }

    private void fillHoverData(Element element, int j, HoverData hoverData) {
        switch (j) {
            case 0:
                hoverData.setRenderingEngine(element.text());
                break;
            case 1:
                hoverData.setBrowser(element.text());
                break;
            case 2:
                hoverData.setPlatform(element.text());
                break;
            case 3:
                hoverData.setEngineVersion(element.text());
                break;
            case 4:
                hoverData.setCssGrade(element.text());
                break;
        }
    }

}
