public class ArrayDictionary implements Dictionary {
    private int capacity;
    private int count;
    private KVEntry[] entries;

    public ArrayDictionary(int capacity) {
        this.capacity = capacity;
        entries = new KVEntry[capacity];
    }

    private int hashFunction(int key) {
        return key % capacity;
    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean add(int key, int value) {

        int hashedKey = hashFunction(key);

        // when there's no entry yet
        if (entries[hashedKey] == null) {
            if (count == capacity) {
                return false;
            }
            entries[hashedKey] = new KVEntry(key, value);
            count++;
            return true;
        }

        KVEntry ptr = entries[hashedKey];
        KVEntry pNewNode = null;
        while (ptr != null) {
            // update value if key already exists
            if (ptr.key == key) {
                ptr.value = value;
                return true;
            }
            pNewNode = ptr;
            ptr = ptr.next;
        }

        // add an entry to the end of the chain
        pNewNode.next = new KVEntry(key, value);
        return true;
    }

    // Delete the entry with the given key from the dictionary
    // Return true if an entry is deleted, false otherwise
    @Override
    public boolean remove(int key) {
        // homework
        if(contains(key)) {
            for(int i = 0; i < entries.length;i++) {
                KVEntry prev = null;
                KVEntry curr = entries[i];

                while(curr != null) {
                    if(curr.key == key) {
                        //deletes first node
                        if(prev == null) {
                            entries[i] = curr.next;
                        }
                        return true;
                    }
                    prev = curr;
                    curr = curr.next;
                }
            }
        }
        return false;
    }

    // Return true when the dictionary contains an entry
    // with the key
    @Override
    public boolean contains(int key) {
        // homework
        for(int j = 0; j < entries.length; j++) {
            KVEntry curr = entries[j];

            while(curr != null) {
                if(curr.key == key) {
                    return true;
                }
                curr = curr.next;
            }
        }
        return false;
    }

    // Return the entry value with the given key
    // Return null if no entry exists with the given key
    @Override
    public Integer get(int key) {
        // NOT IMPLEMENTED
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            if (entries[i] == null) {
                builder.append("dictionary["+ i + "] = null\n");
                continue;
            }
            KVEntry ptr = entries[i];
            builder.append("dictionary["+i+"] = {");
            while (ptr != null) {
                builder.append("(" + ptr.key + ", " + ptr.value + ")");
                ptr = ptr.next;
            }
            builder.append("}\n");
        }
        return builder.toString();
    }
}
