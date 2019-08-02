package HomeWork92;

public interface MyMap {
    interface Entry {
        String getKey();
        String getValue();
        void setValue(String value);
    }
    void clear();
    boolean containsKey(String key);
    String get(String key);
    boolean isEmpty();
    String remove(String key);
    String put(String key, String value);
    int size();
}
