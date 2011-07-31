package br.com.somecodetopratice;

import java.io.PrintWriter;

import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class BoletoWriterDriver implements ExtendedHierarchicalStreamWriter {

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
			out.print("  "); 
		} 
		out.print(String.format("<%s>", name)); 
		indent++; 
	} 
	
	public void addAttribute(String name, String value) { 
		out.print("[" + name + "=" + value + "]"); 
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
		
	}

	@Override
	public void flush() {
		endNode();
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
		this.endRoot = String.format("<%s>", endRoot);
	}


	
}