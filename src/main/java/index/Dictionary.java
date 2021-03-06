package index;

import java.io.*;
import java.util.*;

public class Dictionary implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String, Set<String>> termDictionary = new HashMap<>(300);

    public Dictionary() {

    }

    public void put(Map<String, String> allLines) {
        for(Map.Entry<String, String> entry : allLines.entrySet())
            put(entry.getKey(), entry.getValue());
    }

    // разбиваем строку на токены, каждому токену присваиваем множество id документов из индекса
    private void put(String id, String value) {
        String[] tokens = value.split("\\s");
        for (String token : tokens) {
            Set<String> documentsIds = termDictionary.get(token);
            if (documentsIds == null)
                documentsIds = new HashSet<>();
            documentsIds.add(id);
            termDictionary.put(token, documentsIds);
        }
    }

    public Map<String, Set<String>> getTermDictionary() {
        return termDictionary;
    }

    public void setTermDictionary(Map<String, Set<String>> termDictionary) {
        this.termDictionary = termDictionary;
    }
}
