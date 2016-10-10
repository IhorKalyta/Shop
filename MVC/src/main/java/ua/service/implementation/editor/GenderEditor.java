package ua.service.implementation.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Gender;
import ua.service.GenderService;

public class GenderEditor extends PropertyEditorSupport{
	private final GenderService genderService;

	public GenderEditor(GenderService genderService) {
		
		this.genderService = genderService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Gender gender = genderService.findOne(Integer.valueOf(text));
		setValue(gender);
	}
	
	

}
