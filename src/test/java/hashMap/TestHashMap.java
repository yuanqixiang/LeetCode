package hashMap;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    static class People{
        private String name;
        private int age;
        public People(String name, int age){
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Map<People, String> map = new HashMap<>();
        People p1 = new People("zhangsan", 12);
        People p2 = new People("lisi", 18);
        People p3 = new People("wangwu", 20);
        People p4 = new People("wangwu", 20);
        map.put(p1, "zhangsan");
        map.put(p2, "lisi");
        map.put(p3, "wangwu");
        map.put(p4, "chenliu");

        for(People people : map.keySet()){
            System.out.println(map.get(people));
            //System.out.println(people.hashCode());
        }

        System.out.println(map.get(new People("zhangsan", 12)));
        System.out.println(map.get(new People("lisi", 18)));
        System.out.println(map.get(new People("wangwu", 20)));
        System.out.println(map.get(new People("chenliu", 20)));
    }
}
