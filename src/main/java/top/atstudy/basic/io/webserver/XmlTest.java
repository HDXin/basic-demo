package top.atstudy.basic.io.webserver;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class XmlTest {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        //1、获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();

        //2、从解析工厂获取解析器
        SAXParser parser = factory.newSAXParser();

        //3、编写处理器
        //4、加载文档 Document 注册处理器
        PHandler handler = new PHandler();

        //5、解析
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("person.xml"), handler);


    }

}

class PHandler extends DefaultHandler {


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        System.out.println(" ==>> start qName: " + qName);

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(" ==>> end qName: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        String content = new String(ch, start, length);
        if(content != null){
            System.out.println(" ==>> content: " + content);
        }

    }

    @Override
    public void startDocument() throws SAXException {

        System.out.println(" ==>> start document ");

    }

    @Override
    public void endDocument() throws SAXException {

        System.out.println(" ==>> end document ");

    }
}


