package DocumentSystem;

import java.util.HashMap;
import java.util.LinkedHashMap;

public interface Doc {
    String getName();
    String getContent();
    void LoadProperty(String key, String value);
    void saveAllProperties(LinkedHashMap<String, String> output);
    String toString();
    String getType();
}
