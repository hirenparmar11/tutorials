package com.learn.executables;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learn.basic.spring.autowire.TextEditor;
import com.learn.basic.spring.config.SpellCheckerConfig;

public class TextEditorApp {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpellCheckerConfig.class);
		
		TextEditor editor = context.getBean(TextEditor.class);
		editor.spellCheck();
	}
}
