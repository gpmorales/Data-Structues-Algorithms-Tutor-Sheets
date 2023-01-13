interface SimpleList{
    boolean isEmpty();
    void addFirst(String item);
    void addLast(String item);
    String getFirst();
    String getLast();
    String get(int pos);
    String removeFirst();
    void remove(String key);
}
