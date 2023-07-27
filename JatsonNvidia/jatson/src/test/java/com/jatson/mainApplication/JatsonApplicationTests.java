package com.jatson.mainApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringWriter;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;



@SpringBootTest
class JatsonApplicationTests {

	@Test
	void contextLoads() {
		try {

	         // print a message
	         System.out.println("Executing notepad.exe");

	         // create a process and execute notepad.exe
	         Process process = Runtime.getRuntime().exec("mkdir D:/Directory1");

	         // print another message
	         System.out.println();

	      } catch (Exception ex) {
	         ex.printStackTrace();
	      }
	}
}
