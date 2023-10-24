package tmData;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Config {
    public static String inTMI;
    public static String outTMI;
    public static String inDatxml;
    public static String outDatxml;
    public static String inDim;
    public static String outDim;

    public void run() throws ParserConfigurationException, IOException, SAXException {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("config.xml");

            // Получаем корневой элемент
            Element rootElement = document.getDocumentElement();

            // Получаем все элементы tmi
            NodeList tmiElements = rootElement.getElementsByTagName("tmi");
            for (int i = 0; i < tmiElements.getLength(); i++) {
                Element tmiElement = (Element) tmiElements.item(i);
                inTMI = tmiElement.getAttribute("in");
                outTMI = tmiElement.getAttribute("out");
            }

            // Получаем все элементы datxml
            NodeList datxmlElements = rootElement.getElementsByTagName("datxml");
            for (int i = 0; i < datxmlElements.getLength(); i++) {
                Element datxmlElement = (Element) datxmlElements.item(i);
                inDatxml = datxmlElement.getAttribute("in");
                outDatxml = datxmlElement.getAttribute("out");
            }

            // Получаем все элементы dim
            NodeList dimElements = rootElement.getElementsByTagName("dim");
            for (int i = 0; i < dimElements.getLength(); i++) {
                Element dimElement = (Element) dimElements.item(i);
                inDim = dimElement.getAttribute("in");
                outDim = dimElement.getAttribute("out");
            }
    }

    public void print(){
        System.out.println(Config.inTMI);
        System.out.println(Config.outTMI);
        System.out.println(Config.inDatxml);
        System.out.println(Config.outDatxml);
        System.out.println(Config.inDim);
        System.out.println(Config.outDim);
    }
}

