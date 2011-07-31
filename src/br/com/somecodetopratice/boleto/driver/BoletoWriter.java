package br.com.somecodetopratice.boleto.driver;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.text.MessageFormat;

import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * Driver Xml - Formata um output no formato <propriedade>=valor
 * @author Valdilanio Cruz
 *
 */
public class BoletoWriter implements ExtendedHierarchicalStreamWriter {

	private static final String NAME_VALUE = "{0}=\"{1}\"";
	private static final String TAB = "\t";
	private static final String TAG = "<%s>";
	private int indent; 
	private StringWriter out;
	private String endRoot;

	private BoletoWriter(StringWriter out) { 
		this.out = out; 
	}
	
	public static BoletoWriter createFromStringWriter (StringWriter out){
		return new BoletoWriter(out);
	}
	
	public static BoletoWriter createFromOutputStream(OutputStream out){
		return null;
	}
	
	public void startNode(String name) { 
		if (indent > 0) { 
			out.append(""); 
		} 
		for (int i = 0; i < indent; i++) { 
			out.append(TAB); 
		} 
		out.append(String.format(TAG, name.toUpperCase())); 
		indent++; 
	} 
	
	public void addAttribute(String name, String value) { 
		out.append(MessageFormat.format(NAME_VALUE, name, value)); 
	} 
	
	public void setValue(String text) { 
		out.append(String.format("=%s\n", text));  
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
			out.append(endRoot);
		}
	}

	@Override
	public void close() {
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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