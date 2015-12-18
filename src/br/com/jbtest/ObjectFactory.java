package br.com.jbtest;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _Carro_QNAME = new QName("", "carro");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.jbtest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Carro }
     * 
     */
    public Carro createCarro() {
        return new Carro();
    }

    /**
     * Create an instance of {@link Motorista }
     * 
     */
    public Motorista createMotorista() {
        return new Motorista();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Carro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "carro")
    public JAXBElement<Carro> createCarro(Carro value) {
        return new JAXBElement<Carro>(_Carro_QNAME, Carro.class, null, value);
    }
}