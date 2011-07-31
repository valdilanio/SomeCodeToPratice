package br.com.somecodetopratice.xstream.driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import br.com.somecodetopratice.BoletoWriterDriver;
import br.com.somecodetopratice.beans.Boleto;

import com.thoughtworks.xstream.XStream;


public class TestCustomDriver{

	public static void main(String[] args) throws FileNotFoundException {
		   BoletoWriterDriver writer = new BoletoWriterDriver(new PrintWriter(new File("./resources/boleto.xml")));
		   writer.setEndRoot("END_BOLETO_DESCRIPTION");
		   XStream xs = new XStream();
		   xs.alias("BEGIN_BOLETO_DESCRIPTION", Boleto.class);
		   Boleto b = new Boleto();
		   b.setAssinatura("Uma assinatura");
		   b.setBanco("237");
		   b.setCedente("Bradesco");
		   xs.marshal(b, writer);
	}

}
