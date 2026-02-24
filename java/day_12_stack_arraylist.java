import java.util.ArrayList;

class StackList {
    ArrayList<Integer> list = new ArrayList<>();

    void push(int x) {
        list.add(x);
    }

    void pop() {
        if (!list.isEmpty())
            list.remove(list.size() - 1);
    }

    void peek() {
        if (!list.isEmpty())
            System.out.println(list.get(list.size() - 1));
    }
}
