package br.com.jbtest.metodoB;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {
	 
    private static final String pattern = "dd/MM/yyyy";
 
    @Override
    public String marshal(Date v) throws Exception {
        return new SimpleDateFormat(pattern).format(v);
    }
    @Override
    public Date unmarshal(String v) throws Exception {
        return new SimpleDateFormat(pattern).parse(v);
    }
}
