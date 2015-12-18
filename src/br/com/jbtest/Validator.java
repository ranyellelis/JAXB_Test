package br.com.jbtest;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public class Validator {

    public void validator(String xsdFile, Object object) {
        try {
            JAXBContext jc = JAXBContext.newInstance(object.getClass());
            JAXBSource source = new JAXBSource(jc, object);

            SchemaFactory sf = SchemaFactory.newInstance(
                    XMLConstants.W3C_XML_SCHEMA_NS_URI
            );
            Schema schema = sf.newSchema(new File(xsdFile));

            javax.xml.validation.Validator validator = schema.newValidator();
            validator.setErrorHandler(new ValidatorErrorHandler());
            validator.validate(source);

            System.out.println("Validado com Sucesso!");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}