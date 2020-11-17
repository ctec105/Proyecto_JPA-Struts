package proyecto.struts.bean;

import java.io.Serializable;

public class UtilBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String id;
	String desc;

	public UtilBean(String i, String string) {
		// TODO Auto-generated constructor stubt
		this.id = i;
		this.desc = string;
	}

	public UtilBean() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
