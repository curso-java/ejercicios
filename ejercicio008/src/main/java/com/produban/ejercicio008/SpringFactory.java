package com.produban.ejercicio008;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringFactory {	
	@Bean @Qualifier("out")
	public PrintStream out() {
		return System.out;
	}
}