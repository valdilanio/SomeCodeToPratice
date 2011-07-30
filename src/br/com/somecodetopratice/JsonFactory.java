package br.com.somecodetopratice;

import java.lang.reflect.Field;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class JsonFactory {

	private final XStream xs;
	private String [] excludeProperties;
	private String [] onlyProperties;
	private String json;

	public JsonFactory() {
		xs = new XStream(new JettisonMappedXmlDriver());
	}

	public <T> void jsonOf(T bean, String alias){
		xs.aliasPackage("", alias);
		xs.alias(alias, bean.getClass());
		excludeProperties(bean);
		json = xs.toXML(bean);
	}

	private <T> void excludeProperties(T bean) {

		if(excludeProperties == null && onlyProperties != null){
			Field [] fields = bean.getClass().getDeclaredFields();
			for(Field field : fields){

			}
		}

		if(excludeProperties != null) {
			for(String property : excludeProperties){
				xs.omitField(bean.getClass(), property);
			}
		}
	}

	private <T> void onlyProperties(final T bean) {
		if(onlyProperties != null) {
			Field [] fields = bean.getClass().getDeclaredFields();
			for(String property : excludeProperties){
				xs.omitField(bean.getClass(), property);
			}
		}
	}

	public void setExcludeProperties(String [] excludeProperties) {
		this.excludeProperties = excludeProperties;
	}

	public void setOnlyProperties(String [] onlyProperties) {
		this.onlyProperties = onlyProperties;
	}

	public String getJson(){
		return json;
	}

}
