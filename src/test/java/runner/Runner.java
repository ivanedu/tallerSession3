package runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class Runner {

    @Before
    public void hookBeforeScenario(){
        // abrir app
        System.out.println("HOOK BEFORE .............");
    }

    @After
    public void hookAfterScenario(){
        // screenshot
        System.out.println("HOOK AFTER .............");
    }


}
