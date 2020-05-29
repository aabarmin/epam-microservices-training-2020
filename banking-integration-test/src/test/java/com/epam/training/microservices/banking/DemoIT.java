package com.epam.training.microservices.banking;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
        "classpath:endToEndTest.feature"
})
public class DemoIT {

}
