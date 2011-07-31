package br.com.somecodetopratice.boleto.driver;

import java.io.PrintWriter;
import java.io.Reader;
import java.text.MessageFormat;
import java.util.Iterator;

import com.thoughtworks.xstream.converters.ErrorWriter;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * Driver Xml - Formata um output no formato <propriedade>=valor
 * @author Valdilanio Cruz
 *
 */
public class BoletoReader implements HierarchicalStreamReader {

	private final Reader reader;

	public BoletoReader(Reader reader) {
		this.reader = reader;
	}
	
	@Override
	public void appendErrors(ErrorWriter arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAttribute(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAttribute(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAttributeCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getAttributeName(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNodeName() {
		return null;
	}

	@Override
	public String getValue() {
		return null;
	}

	@Override
	public boolean hasMoreChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HierarchicalStreamReader underlyingReader() {
		return this;
	}

	
}