package proyecto.struts.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.displaytag.decorator.ColumnDecorator;

public class DateColumnDecorator implements ColumnDecorator {

	/**
	 * Formateador de la fecha
	 */
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Transformamos la reprentacion actual de la fecha en un string
	 * 
	 * @param columnValue Object, el objeto date
	 * 
	 * @return String value, el objeto string
	 */
	public final String decorate(Object columnValue) {
		if (columnValue != null) {
			Date date = (Date) columnValue;
			return this.dateFormat.format(date);
		} else {
			return new String("");
		}
	}

}
