package collectionFramework;

import java.util.Iterator;

public class MyIterator {
    public static void main(String[] args) {
        String[] names = {"Char0_n", "John", "Monu", "Sonu", "Pintu"};
        NameContainer container = new NameContainer(names);

//        Iterator<String> it = container.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }

        // Sugar Quoting on Iterator using Enhanced for loop / for each loop
        // internally works using iterator only
        for(String name: container){
            System.out.println(name);
        }
    }
}

// holds many names
class NameContainer implements Iterable<String>{
    private String[] names;
    private int size;

    NameContainer(String[] names){
        this.names = names;
        this.size = this.names.length;
    }

    @Override
    public Iterator<String> iterator() {
//        return new NameContainerIterator();
        return new Iterator<String>() {
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < size;
            }

            @Override
            public String next() {
                return names[pos++];
            }
        };
    }

//    private class NameContainerIterator implements Iterator<String>{
//        private int pos = 0;
//
//        @Override
//        public boolean hasNext() {
//            return pos < size;
//        }
//
//        @Override
//        public String next() {
//            return names[pos++];
//        }
//    }

    // get(name), set(name), insert(index, name)
}

//class NameContainer{
//    private String[] names;
//    private int size;
//
//    NameContainer(String[] names) {
//        this.names = names;
//        this.size = this.names.length;
//    }
//}