package com.learn.basic.spring.config;

import org.springframework.context.annotation.Bean;

import com.learn.basic.spring.autowire.SpellChecker;
import com.learn.basic.spring.autowire.TextEditor;

public class SpellCheckerConfig {

	@Bean
	public TextEditor getTextEditor() {
		return new TextEditor();
	}
	
	@Bean
	public SpellChecker getSpellChecker() {
		return new SpellChecker();
	}
}
