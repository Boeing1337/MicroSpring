package ioc.see_here;

import ioc.annotations.Component;
import ioc.annotations.InjectObject;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component(name = "dep2")
public class TestBeanDependency2 implements SomeInterface {

    @InjectObject("dep2")
    private SomeInterface someInterface;

    public TestBeanDependency2() {
        log.info("TestBeanDependency2 created");
    }

    @Override
    public void print(String msg) {
        log.info(msg + "FROM TestBeanDependency2");
    }
}
