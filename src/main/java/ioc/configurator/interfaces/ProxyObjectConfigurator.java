package ioc.configurator.interfaces;

import ioc.annotations.Component;
import ioc.dto.BeanContainer;
import ioc.infrastucture.ApplicationContext;

/**
 * Реализовав этот интерфейс вы можете добавить свою настройку компонентов.
 * Все конфигураторы применяются ко всем {@link Component}
 * Отличается от {@link ObjectConfigurator} тем что оборачивает настоящий объект свойм
 */
public interface ProxyObjectConfigurator {
    void configure(BeanContainer container, ApplicationContext context);
}
