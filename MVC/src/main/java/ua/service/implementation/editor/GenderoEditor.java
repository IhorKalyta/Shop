package ua.service.implementation.editor;

import java.beans.PropertyEditorSupport;



import org.apache.commons.lang3.StringUtils;

import ua.entity.enums.Gendero;



public class GenderoEditor extends PropertyEditorSupport{

	@Override
	public String getAsText() {
		 if(getValue() == null)
             return "";

         return ((Gendero) getValue()).name();
	}

	@Override
	public void setAsText(String value) throws IllegalArgumentException {
		  if(StringUtils.isBlank(value))
              return;

          setValue(Gendero.valueOf(value));
	}

	
}
