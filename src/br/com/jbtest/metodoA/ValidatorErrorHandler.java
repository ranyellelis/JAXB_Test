package br.com.jbtest.metodoA;


import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class ValidatorErrorHandler implements ErrorHandler {

    public void warning(SAXParseException exception) throws SAXException {
        System.out.println("WARNING");
        System.out.println(exception.getMessage());
        exception.printStackTrace();
    }

    public void error(SAXParseException exception) throws SAXException {
        System.out.println("ERROR");
        System.out.println(exception.getMessage());
        exception.printStackTrace();
    }

    public void fatalError(SAXParseException exception) throws SAXException {
        System.out.println("FATAL ERROR");
        System.out.println(exception.getMessage());
        exception.printStackTrace();
    }
}