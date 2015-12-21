package br.com.jbtest.metodoB;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="carro")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarroB {
	
	@XmlElement(name="nome")
    protected String nome;
     
	@XmlElement(name="portas")
    protected int portas;
	
   @XmlJavaTypeAdapter(DateAdapter.class)
	protected Date data;
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@XmlElementWrapper(name="motoristas")
	@XmlElement(name="motorista")
    protected List<MotoristaB> motoristas;

    public String getNome() {
        return nome;
    }

	public void setNome(String value) {
        this.nome = value;
    }

    public int getPortas() {
        return portas;
    }
    
    public void setPortas(int value) {
        this.portas = value;
    }

    public List<MotoristaB> getMotoristas() {
        if (motoristas == null) {
            motoristas = new ArrayList<MotoristaB>();
        }
        return this.motoristas;
    }
    
    @Override
	public String toString() {
		String retorno = "nome=" + nome + ", portas=" + portas;
		retorno += " motoristas= ";
		for (MotoristaB mot : motoristas) {
			retorno+= mot.getNome()+", ";
		}
		retorno+= new SimpleDateFormat("dd/MM/yyyy").format(data);
		return retorno;
   	}
}