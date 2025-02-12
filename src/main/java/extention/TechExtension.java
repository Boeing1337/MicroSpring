package extention;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.reflections.Reflections;
import ioc.annotations.Component;
import ioc.annotations.InjectProperty;
import ioc.infrastucture.resolver.ApplicationPropertiesResolver;
import ioc.infrastucture.resolver.PropertyResolver;

import java.lang.reflect.Field;

import static org.reflections.scanners.Scanners.SubTypes;

@Log4j2
public class TechExtension implements BeforeEachCallback {
    private final PropertyResolver propertyResolver;

    @SneakyThrows
    public TechExtension() {
        Reflections scanner = new Reflections("tech", SubTypes.filterResultsBy(e -> true));
        propertyResolver = new ApplicationPropertiesResolver(() -> scanner, "application-test.properties");
    }

    @SneakyThrows
    private void injectProperty(Object instance, Field field) {
        InjectProperty annotation = field.getAnnotation(InjectProperty.class);
        if (annotation != null) {
            String key = annotation.value();
            if (key.isEmpty()) {
                key = field.getName();
            }
            field.setAccessible(true);
            field.set(instance, propertyResolver.getPropertyAs(key, field.getType()));
        }
    }

    @Override
    @SneakyThrows
    public void beforeEach(ExtensionContext context) {
        for (Object testInstance : context.getRequiredTestInstances().getAllInstances()) {
            for (Field testField : testInstance.getClass().getDeclaredFields()) {
                injectProperty(testInstance, testField);
                testField.setAccessible(true);
                Object fieldValue = testField.get(testInstance);
                if (!fieldValue.getClass().isAnnotationPresent(Component.class)) {
                    continue;
                }
                for (Field field : fieldValue.getClass().getDeclaredFields()) {
                    injectProperty(fieldValue, field);
                }
            }
        }
    }
}
