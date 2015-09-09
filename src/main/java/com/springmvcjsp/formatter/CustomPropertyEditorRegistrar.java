package com.springmvcjsp.formatter;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

public final class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {

    public void registerCustomEditors(PropertyEditorRegistry registry) {
        // We want all strings to be trimmed and empty strings converted to null.
        registry.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
