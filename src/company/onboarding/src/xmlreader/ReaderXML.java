package company.onboarding.src.xmlreader;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ReaderXML {

	private Document doc = null;

	public ReaderXML(String dbInfoXmlPath) throws ParserConfigurationException, IOException, SAXException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		doc = parser.parse(dbInfoXmlPath);
	}

	public Document getDocument() {
		return this.doc;
	}




}
