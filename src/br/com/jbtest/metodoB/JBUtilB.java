package br.com.jbtest.metodoB;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JBUtilB {
	public static void main(String[] args) throws JAXBException {
		CarroB carroB = criaCarroB();
		objetoParaXml(carroB);
		carroB = (CarroB) xmlParaObjeto(criaXml(), carroB);
	}

	public static void objetoParaXml(Object obj) throws JAXBException {
		Writer writer = new StringWriter();
		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(obj, writer);
		System.out.println(writer.toString());
	}

	public static Object xmlParaObjeto(String xml, Object obj) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Object retorno = unmarshaller.unmarshal(new StringReader(xml.toString()));
		System.out.println(retorno.toString());
		return retorno;
	}

	
	@SuppressWarnings("deprecation")
	public static CarroB criaCarroB() {
		MotoristaB motorista = new MotoristaB();
		motorista.setNome("Joseph");
		CarroB carro = new CarroB();
		carro.setNome("Fusca");
		carro.setPortas(4);
		carro.setData(new Date(115, 11, 1));
		carro.getMotoristas().add(motorista);
		return carro;
	}
	
	public static String criaXml(){
		StringBuilder xml = new StringBuilder();
		xml.append("<carro>");
		xml.append("<nome>Fusca</nome>");
		xml.append("<portas>4</portas>");
		xml.append("<data>01/12/2015</data>");
		xml.append("<motoristas>");
		xml.append("<motorista nome=\"Joseph\"/>");
		xml.append("</motoristas>");
		xml.append("</carro>");
		return xml.toString();
	}
}