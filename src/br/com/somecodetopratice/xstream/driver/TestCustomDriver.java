package br.com.somecodetopratice.xstream.driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import br.com.somecodetopratice.beans.Boleto;
import br.com.somecodetopratice.boleto.driver.BoletoWriterDriver;

import com.thoughtworks.xstream.XStream;


public class TestCustomDriver{

	public static void main(String[] args) throws FileNotFoundException {
		   Boleto b = new Boleto();
		   b.setAssinatura("Uma assinatura shit");
		   b.setBanco("237");
		   b.setCedente("Bradesco");
		   b.setValordocumentoformatado("100,00");

		   BoletoWriterDriver writer = new BoletoWriterDriver(new PrintWriter(new File("./resources/boleto.xml")));
		   writer.setEndRoot("END_BOLETO_DESCRIPTION");
		   XStream xs = new XStream();
		   xs.alias("BEGIN_BOLETO_DESCRIPTION", Boleto.class);
		   xs.marshal(b, writer);
		   
		   /*
		   XStream teste = new XStream(new BoletoXmlMappedDriver());
		   teste.alias("BEGIN_BOLETO_DESCRIPTION", Boleto.class);
		   System.out.println(teste.toXML(b));
		   Boleto novo = (Boleto) teste.fromXML("<BEGIN_BOLETO_DESCRIPTION>	<CEDENTE>=Bradesco<BANCO>=237<ASSINATURA>=Uma assinatura shit<VALORDOCUMENTOFORMATADO>=100,00");
		   System.out.println(novo.getAssinatura());
		   */
	}

}
