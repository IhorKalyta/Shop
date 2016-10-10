package ua.service.implementation.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Type;
import ua.service.TypeService;

public class TypeEditor extends PropertyEditorSupport{
	
	private final TypeService typeService;

	public TypeEditor(TypeService typeService) {
		
		this.typeService = typeService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Type type = typeService.findOne(Integer.valueOf(text));
		setValue(type);
	}

}
