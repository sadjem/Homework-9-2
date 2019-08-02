package HomeWork92;

import java.util.ArrayList;
import java.util.List;

public class MyTreeMap implements MyMap {

    private Entry entry = null;
    private int size = 0;

    private class Entry implements MyMap.Entry {
        private String key;
        private String value;
        private Entry entry;
        private Entry left;
        private Entry right;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
            entry = null;
            left = null;
            right = null;
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public void setValue(String value) {
            this.value = value;
        }

        public boolean findKey(String key) {
            if (key.compareTo(this.key) == 0) {
                return true;
            }
            if (left != null && key.compareTo(this.key) < 0) {
                return left.findKey(key);
            }
            if (right != null) {
                return right.findKey(key);
            }
            return false;
        }

        public String putEntry(String key, String value) {
            if (key.compareTo(this.key) == 0) {
                String oldValue = this.value;
                this.value = value;
                return oldValue;
            }
            if (key.compareTo(this.key) < 0) {
                if (left != null) {
                    return left.putEntry(key, value);
                }
                left = new Entry(key, value);
            }
            if (right != null) {
                return right.putEntry(key, value);
            }
            right = new Entry(key, value);
            return null;
        }

        public String findValue(String key) {
            if (key.compareTo(this.key) == 0){
                return this.key;
            }
            if (left != null && key.compareTo(this.key) < 0 ){
                return left.findValue(key);
            }
            if (right != null && key.compareTo(this.key) > 0){
                return right.findValue(key);
            }
            return null;
        }
    }

    @Override
    public void clear() {
        entry = null;
        size = 0;
    }

    @Override
    public boolean containsKey(String key) {
        if (entry == null) {
            return false;
        }
        return entry.findKey(key);
    }

    @Override
    public String get(String key) {
        if (entry == null){
            return null;
        }
        return entry.findValue(key);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String remove(String key) {
        //TODO
        return null;
    }

    @Override
    public String put(String key, String value) {
        if (entry == null) {
            entry = new Entry(key, value);
            size++;
        }
        String oldValue = entry.putEntry(key, value);
        size++;
        return oldValue;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        List<String> list = createList();
        StringBuilder result = new StringBuilder("Tree{");
        boolean firstAdded = false;
        for (String value : list) {
            if (firstAdded) {
                result.append(", ");
            } else {
                firstAdded = true;
            }
            result.append(String.valueOf(value));
        }
        return result.append("}").toString();
    }

    private List<String> createList() {
        List<String> list = new ArrayList<>();
        addToList(entry, list);
        return list;
    }

    private void addToList(Entry entry, List<String> list) {
        if (entry == null) {
            return;
        }
        addToList(entry.left, list);
        list.add(entry.value);
        addToList(entry.right, list);
    }
}
