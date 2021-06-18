package eapli.base.formulario.gramatica;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLUtils {

    private List<String> strings = new ArrayList<>();

    public List<String> xml(String filename, String itemProcurar, String op) {
        org.w3c.dom.Document document = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;

        String path ="";

        switch (op) {
            case "preco":
                path = "/grupo4_2DL/produto[produtoid='" + itemProcurar + "']/preco/text()";
                break;
            case "categoria":
                path = "/grupo4_2DL/produto[produtoid='" + itemProcurar + "']/categoria/text()";
                break;
            case "nome":
                path = "/grupo4_2DL/produto[produtoid='" + itemProcurar + "']/nome/text()";
                break;
        }
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse("base.core/src/main/java/eapli/base/formulario/gramatica/" + filename);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            System.out.println("Ocorreu um erro na leitura do ficheiro");
        }

        XPathFactory xpathfactory = XPathFactory.newInstance();
        XPath xpath = xpathfactory.newXPath();

        XPathExpression expr;
        Object result = null;

        try {
            expr = xpath.compile(path);
            result = expr.evaluate(document, XPathConstants.NODESET);
        } catch (
                XPathExpressionException e) {
            e.printStackTrace();
        }

        NodeList nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            strings.add(nodes.item(i).getNodeValue());
        }

        return strings;
    }
}
