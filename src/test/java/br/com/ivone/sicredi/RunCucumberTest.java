package br.com.ivone.sicredi;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cucumber/features", 
                 plugin = { "json:target/cucumber.json", "pretty", "html:target/cucumber-reports.html" })
public class RunCucumberTest {}