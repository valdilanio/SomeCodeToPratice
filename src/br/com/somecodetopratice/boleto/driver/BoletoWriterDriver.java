package br.com.somecodetopratice.boleto.driver;

import java.io.PrintWriter;
import java.text.MessageFormat;

import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * Driver Xml - Formata um output no formato <propriedade>=valor
 * @author Valdilanio Cruz
 *
 */
public class BoletoWriterDriver implements ExtendedHierarchicalStreamWriter {

	private static final String NAME_VALUE = "{0}=\"{1}\"";
	private static final String TAB = "\t";
	private static final String TAG = "<%s>";
	private int indent; 
	private PrintWriter out;
	private String endRoot;

	public BoletoWriterDriver(PrintWriter out) { 
		this.out = out; 
	} 
	
	public void startNode(String name) { 
		if (indent > 0) { 
			out.println(); 
		} 
		for (int i = 0; i < indent; i++) { 
			out.print(TAB); 
		} 
		out.print(String.format(TAG, name.toUpperCase())); 
		indent++; 
	} 
	
	public void addAttribute(String name, String value) { 
		out.print(MessageFormat.format(NAME_VALUE, name, value)); 
	} 
	
	public void setValue(String text) { 
		out.print("=" + text);  
	} 
	
	public void endNode() { 
		indent--; 
		if (indent == 0) {
			endRoot();
			out.flush(); 
		} 
	}

	private void endRoot() {
		if(endRoot != null){
			out.print(endRoot);
		}
	}

	@Override
	public void close() {
		out.close();
	}

	@Override
	public void flush() {
		out.flush();
	}

	@Override
	public HierarchicalStreamWriter underlyingWriter() {
		return this;
	}

	@Override
	public void startNode(String name, @SuppressWarnings("rawtypes") Class arg1) {
		startNode(name);
	}

	public void setEndRoot(String endRoot) {
		this.endRoot = String.format(TAG, endRoot);
	}


	
}