package ioc.see_here;

import ioc.annotations.InjectObject;
import ioc.annotations.InjectProperty;
import lombok.extern.log4j.Log4j2;
import ioc.annotations.Component;

import java.util.List;

@Log4j2
@Component(name = "testPrinter")
public class TestBeanPrinter {

    @InjectProperty(value = "OLEG")
    private String value;
    @InjectProperty
    private Integer numValue;

    @InjectProperty
    private Long intNumValue;

    @InjectObject
    private SomeInterface testBeanDependency;
    @InjectObject
    private List<SomeInterface> testBeanDependencies;

    public TestBeanPrinter() {
        log.info("TestBeanPrinter created");
    }

    public void print(String message) {
        testBeanDependency.print(message + "from dependency 1");
        testBeanDependencies.forEach(e -> e.print("calling list of dependencies"));
        log.info("Injected value: " + value);
        log.info("Injected numValue: " + numValue);
        log.info("Injected numValue: " + intNumValue);
    }
}
