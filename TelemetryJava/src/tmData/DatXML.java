package tmData;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

public class DatXML {
    public final TreeMap<Integer, String> map = new TreeMap<>();

    public void run(String inNameF) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Чтение XML-файла и создание объекта документа
        Document document = builder.parse(new File(inNameF));

        // Получение корневого элемента
        Element rootElement = document.getDocumentElement();

        NodeList paramElements = rootElement.getElementsByTagName("Param");
        for (int i = 0; i < paramElements.getLength(); i++) {
            Element elem = (Element) paramElements.item(i);
            map.put(Integer.parseInt(elem.getAttribute("number")), elem.getAttribute("name"));
        }

    }

    public void print() {
        map.forEach((key, value) -> System.out.println(key + " " + value));
    }

}