package ioc.infrastucture.resolver;

public interface PropertyResolver {
    <T> T getPropertyAs(String propName, Class<T> type);

    String getProperty(String propName);
}
