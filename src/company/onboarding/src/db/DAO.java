package company.onboarding.src.db;

import company.onboarding.src.CommonConstant;
import company.onboarding.src.xmlreader.ReaderXML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

	public String className;
	public String userName;
	public String password;
	private Document doc = null;

	public DAO() throws IOException, SAXException, ParserConfigurationException, TransformerException {
		StringBuffer xmlPathText = new StringBuffer();
		xmlPathText.append(CommonConstant.DEFAULT_DIR_PATH);
		xmlPathText.append(CommonConstant.DB_INFO_XML_PATH);
		String dbInfoXmlPath = String.valueOf(xmlPathText);
		ReaderXML readerXML = new ReaderXML(dbInfoXmlPath);
		this.doc = readerXML.getDocument();
	}

	/**
	 * DB connection 정보 가지고 오기.
	 * @return Connection
	 */
	public void getConnection() {
		doc.getDocumentElement().normalize();
		NodeList nodes = doc.getElementsByTagName("info");

		for (int k = 0; k < nodes.getLength(); k++) {
			Node node = nodes.item(k);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				this.className = getValue("className", element);
				this.userName = getValue("username", element);
				this.password = getValue("password", element);
			}
		}

		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(className, userName,password);

			System.out.println("정상적으로 연결되었습니다.");
		} catch (ClassNotFoundException e) {
			System.err.println(" !! <JDBC 오류> Driver load 오류: " + e.getMessage());
			throw new RuntimeException(e);
		} catch (SQLException e) {
			System.err.println(" SQL Exception connection 에러: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	//select
	//insert
	//delete
	//update

	/**
	 * xml 파일 node 파싱
	 * @param tag
	 * @param element
	 * @return
	 */
	private static String getValue(String tag, Element element) {
		NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodes.item(0);
		return node.getNodeValue();
	}

	/*------------------Query---------------*/




}
