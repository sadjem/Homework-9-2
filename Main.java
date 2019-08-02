package HomeWork92;

public class Main {
    public static void main(String[] args) {
        MyTreeMap treeMap = new MyTreeMap();
        treeMap.put("11", "sdfsdf");
        treeMap.put("13", "sdfsfdf");
        treeMap.put("2", "dfdf");
        treeMap.put("8", "sdsd");
        treeMap.put("1", "sdf");
        treeMap.put("17", "sdgfhh");
        System.out.println(treeMap);
        System.out.println(treeMap.containsKey("8"));
        System.out.println(treeMap);
    }
}
