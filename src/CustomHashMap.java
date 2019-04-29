
public class CustomHashMap<K, V> {

	Node[] table;
	int size;
	int capacity;
	static final int DEFAULT_CAPACITY = 16;

	static final int MAX_CAPACITY = 1 >>> 30;

	CustomHashMap(int capacity) {
		this.capacity = capacity;
		table = new Node[tableSize(this.capacity)];
	}

	CustomHashMap() {
		this.capacity = DEFAULT_CAPACITY;
		table = new Node[this.capacity];
	}

	private int tableSize(int capacity) {
		int n = capacity - 1;

		n |= n >> 1;
		n |= n >> 2;
		n |= n >> 4;
		n |= n >> 8;
		n |= n >> 16;

		return n < 0 ? 0 : n > MAX_CAPACITY ? MAX_CAPACITY : n + 1;
	}

	private int hash(K key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ h >>> 16;

	}

	public void put(K key, V value) {
		int hash = hash(key);
		int n = capacity;
		Node<K, V> node = table[hash & n - 1];

		if (node == null) {
			table[hash & n - 1] = new Node<K, V>(hash, key, value);
			size++;
		} else {
			if ((node.hash == hash && key == null) || (key != null && key.equals(node.key))) {
				node.value = value;
			} else {
				while (node != null) {

					if ((node.hash == hash && key == null) || (key != null && key.equals(node.key))) {
						node.value = value;
						break;
					} else if (node.next == null) {
						node.next = new Node<K, V>(hash, key, value);
						size++;
						break;
					}
					node = node.next;
				}
			}
		}
	}

	public V get(K key) {

		int hash = hash(key);
		int n = capacity;
		Node<K, V> node = table[hash & n - 1];
		if (node == null) {
			return null;
		} else {
			if ((node.hash == hash && key == null) || (key != null && key.equals(node.key))) {
				return node.value;
			} else {
				while (node != null) {

					if ((node.hash == hash && key == null) || (key != null && key.equals(node.key))) {
						return node.value;
					} 
					node = node.next;
				}
			}
		}
		return null;
	}

	static class Node<K, V> {
		K key;
		V value;
		int hash;
		Node next;

		Node(int hash, K key, V value) {
			this.hash = hash;
			this.key = key;
			this.value = value;

		}
	}

}
