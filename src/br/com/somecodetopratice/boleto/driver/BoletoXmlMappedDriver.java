package br.com.somecodetopratice.boleto.driver;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import com.thoughtworks.xstream.io.HierarchicalStreamDriver;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * Driver Xml - Formata um output no formato <propriedade>=valor
 * @author Valdilanio Cruz
 *
 */
public class BoletoXmlMappedDriver implements HierarchicalStreamDriver {

	@Override
	public HierarchicalStreamReader createReader(Reader arg0) {
		System.out.println("blue1");
		return new BoletoReader(arg0);
	}

	@Override
	public HierarchicalStreamReader createReader(InputStream arg0) {
		System.out.println("blue2");
		return null;
	}

	@Override
	public HierarchicalStreamWriter createWriter(Writer arg0) {
		return BoletoWriter.createFromStringWriter((StringWriter)arg0);
	}

	@Override
	public HierarchicalStreamWriter createWriter(OutputStream arg0) {
		System.out.println("aqui");
		return null;
	}

	
}