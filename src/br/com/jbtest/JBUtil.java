package br.com.jbtest;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JBUtil {
	public static void main(String[] args) throws JAXBException {
		Carro carro = criaCarro();
		objetoParaXml(carro);
		xmlParaObjeto();
		
//		Validator validator = new Validator();
//		validator.validator("resources/carro.xsd", carro);
	}

	public static void objetoParaXml(Carro carro) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance("br.com.jbtest");
		Marshaller marshaller = context.createMarshaller();
		JAXBElement<Carro> element = new ObjectFactory().createCarro(carro);
		marshaller.marshal(element, new File("resources/carro.xml"));
		marshaller.marshal(element, System.out);
	}

	@SuppressWarnings("unchecked")
	public static void xmlParaObjeto() throws JAXBException {
		JAXBContext context = JAXBContext.newInstance("br.com.jbtest");
		Unmarshaller unmarshaller = context.createUnmarshaller();
		JAXBElement<Carro> element = (JAXBElement<Carro>) unmarshaller
				.unmarshal(new File("resources/carro.xml"));
		Carro carro = element.getValue();
		System.out.println(carro.toString());
	}

	public static Carro criaCarro() {
		Motorista motorista = new Motorista();
		motorista.setNome("Joseph");
		Carro carro = new Carro();
		carro.setNome("Fusca");
		carro.setPortas(4);
		carro.getMotoristas().add(motorista);
		return carro;
	}
}