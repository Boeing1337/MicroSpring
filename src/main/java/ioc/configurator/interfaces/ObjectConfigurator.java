package ioc.configurator.interfaces;

import ioc.annotations.Component;
import ioc.infrastucture.ApplicationContext;

/**
 * Реализовав этот интерфейс вы можете добавить свою настройку компонентов.
 * Все конфигураторы применяются ко всем {@link Component}
 */
public interface ObjectConfigurator {
    void configure(Object t, ApplicationContext context);
}
