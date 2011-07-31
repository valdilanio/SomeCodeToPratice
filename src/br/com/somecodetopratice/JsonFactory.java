package br.com.somecodetopratice;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class JsonFactory {

	private final XStream xs;
	private String [] excludeFields;
	private String [] onlyFields;
	private String json;

	public JsonFactory() {
		xs = new XStream(new JettisonMappedXmlDriver());
		xs.setMode(XStream.NO_REFERENCES);
	}

	public <T> void jsonOf(T bean, String alias){
		xs.aliasPackage("", alias);
		xs.alias(alias, bean.getClass());
		excludeFields(bean);
		onlyFields(bean);
		setJson(xs.toXML(bean));
	}

	private <T> void excludeFields(T bean) {
		if(excludeFields != null) {
			System.out.println("aqui");
			for(String field : excludeFields){
				xs.omitField(bean.getClass(), field);
			}
		}
	}

	private <T> void onlyFields(T bean) {
		if(onlyFields != null) {
			String name;
			Field [] fields = bean.getClass().getDeclaredFields();
			List <String> fieldsToOmit = Arrays.asList(onlyFields);
			for (Field field : fields) {
				name = field.getName();
				if(!fieldsToOmit.contains(name)){
					xs.omitField(bean.getClass(), name);
				}
			}
			
		}
	}

	public String getJson(){
		return json;
	}

	public void setExcludeFields(String [] excludeFields) {
		this.excludeFields = excludeFields;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public void setOnlyFields(String [] onlyFields) {
		this.onlyFields = onlyFields;
	}

}
