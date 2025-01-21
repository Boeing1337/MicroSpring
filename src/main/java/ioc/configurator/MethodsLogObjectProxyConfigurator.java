package ioc.configurator;

import ioc.configurator.interfaces.ProxyObjectConfigurator;
import ioc.infrastucture.ApplicationContext;
import lombok.extern.log4j.Log4j2;
import ioc.dto.BeanContainer;

@Log4j2
public class MethodsLogObjectProxyConfigurator implements ProxyObjectConfigurator {

    public MethodsLogObjectProxyConfigurator(ApplicationContext context) {
    }

    @Override
    public void configure(BeanContainer container, ApplicationContext context) {
//        Object oldProxy = container.getProxy();
//        container.setProxy(Enhancer.create(container.getImplClass(), new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                log.debug(method.getName() + " " + Arrays.toString(args));
//                return method.invoke(oldProxy, args);
//            }
//                }
//        ));
    }
}
