

import java.util.HashMap;

public class LRU {

    static class LRUCache {

        class Node {
            int key, value;
            Node prev, next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private int capacity;
        private HashMap<Integer, Node> map;
        private Node head, tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();

            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        private void add(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToFront(Node node) {
            remove(node);
            add(node);
        }

        private Node removeLRU() {
            Node lru = tail.prev;
            remove(lru);
            return lru;
        }

        public int get(int key) {
            if (!map.containsKey(key))
                return -1;

            Node node = map.get(key);
            moveToFront(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                moveToFront(node);
            } else {
                Node node = new Node(key, value);
                map.put(key, node);
                add(node);

                if (map.size() > capacity) {
                    Node lru = removeLRU();
                    map.remove(lru.key);
                }
            }
        }
    }
}