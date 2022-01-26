package app;

import java.util.Iterator;

public class RecursiveList<T> implements ListInterface<T> {

  private int size;
  private Node<T> head = null;

  public RecursiveList() {
    this.head = null;
    this.size = 0;
  }

  public RecursiveList(Node<T> first) {
    this.head = first;
    this.size = 1;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void insertFirst(T elem) throws NullPointerException{
      //TODO: Implement this method.
    Node <T> insertNode = new Node <T> (elem, null);
    if (elem == null) {
      throw new NullPointerException("...");
    }
    if (head == null) {
      head = insertNode;
    }
    else {
      insertNode.setNext(head);
      head = insertNode;
    }
    size++;
  }

  @Override
  public void insertLast(T elem) throws NullPointerException{
      //TODO: Implement this method.
      Node <T> insertNode = new Node <T> (elem, null);
      if (elem == null) {
        throw new NullPointerException("...");
      }
      if (head == null) {
        head = insertNode;
      }
      else {
        Node <T> tail = nodeHelper(0, size-1, head);
        tail.setNext(insertNode);
      }
      size++;
  }

  @Override
  public void insertAt(int index, T elem) throws IndexOutOfBoundsException{
      //TODO: Implement this method.
      Node <T> insertNode = new Node <T> (elem, null);
      Node <T> sucNode = nodeHelper(0, index, head);
      //Node <T> tail = nodeHelper(0, size-1, head);
      if (elem == null) {
        throw new NullPointerException("terrible");
      }
      if (index < 0 || index > size) {
        throw new IndexOutOfBoundsException("again!!");
      }
      if (index == 0){
        insertFirst(elem);
      }
      else if (index == size) {
        insertLast(elem);
      }
      else {
        Node <T> prevNode = nodeHelper(0, index-1, head);
        prevNode.setNext(insertNode);
        insertNode.setNext(sucNode);
        size++;
      }
    }

  private Node <T> nodeHelper(int i, int index, Node<T> node){
      if (i == index) {
        return node;
      }
      else if (i >= size) {
        return null;
      }
      else {
        i++;
        return nodeHelper(i, index, node.getNext());
      }
  }

  @Override
  public T removeFirst() throws IllegalStateException{
    T removedItem = null;
      //TODO: Implement this method.
    if (isEmpty()){
      throw new IllegalStateException(".");
    }
    removedItem = head.getData();
    Node <T> sucNode = head.getNext();
    head = sucNode;
    size--;
    return removedItem;
  }

  @Override
  public T removeLast() throws IllegalStateException{
    T removedItem = null;
      //TODO: Implement this method.
    if (isEmpty()){
      throw new IllegalStateException(".");
    }
    if (size == 1) {
      removedItem = removeFirst();
    }
    else {
      Node <T> prevTail = nodeHelper(0, size-2, head);
      removedItem = nodeHelper(0, size-1, head).getData();
      prevTail.setNext(null);
      size--;
    }
    return removedItem;
  }

  @Override
  public T removeAt(int i) throws IndexOutOfBoundsException {
    T removedItem = null;
      //TODO: Implement this method.
    removedItem = get(i);
    Node <T> curNode = nodeHelper(0, i, head);
    if (i < 0 || i >= size){
      throw new IndexOutOfBoundsException(".");
    } 
    else if (curNode == head){
      removedItem = removeFirst();
    }
    else if (curNode.getNext() == null) {
      removedItem = removeLast();
    }
    else {
      Node <T> prevNode = nodeHelper(0, i-1, head);
      Node <T> sucNode = nodeHelper(0, i+1, head);
      prevNode.setNext(sucNode);
      size--;
    }
    return removedItem;
  }

  @Override
  public T getFirst() throws IllegalStateException {
    T item = null;
      //TODO: Implement this method.
    if (head == null) {
        throw new IllegalStateException("bruh");
      }
    item = head.getData();
    return item;
  }

  @Override
  public T getLast() throws IllegalStateException {
    T item = null;
      //TODO: Implement this method.
    if (head == null) {
      throw new IllegalStateException("bruh");
    }
    item = getHelper(0, size-1, head);
    return item;
  }

  @Override
  public T get(int i) throws IndexOutOfBoundsException {
    T item = null;
      //TODO: Implement this method.
    if (i < 0 || i >= size) {
      throw new IndexOutOfBoundsException("bruh");
    }
    item = getHelper(0, i, head);
    return item;
  }

  private T getHelper(int i, int index, Node<T> node){
    if (i == index) {
      return node.getData();
    }
    i++;
    return getHelper(i, index, node.getNext());
  }

  @Override
  public void remove(T elem) throws ItemNotFoundException{
      //TODO: Implement this method.
      int index = indexOf(elem);
      if (elem == null) {
        throw new NullPointerException("nah nah");
      }
      if (index == -1) {
        throw new ItemNotFoundException ("bad");
      }
      removeAt(index);
  }

  @Override
  public int indexOf(T elem) throws NullPointerException{
    int index = 0;
      //TODO: Implement this method.
    if (elem == null){
      throw new NullPointerException("nah nah");
    }
    return indexOfHelper(elem, index, head);
  }

  private int indexOfHelper(T elem, int index, Node<T> node){
    if (node.getData() == elem){
      return index;  
    }
    else if (index == size-1){
      return -1;
    }
    else {
      index++;
      return indexOfHelper(elem, index, node.getNext());
    }
  }

  @Override
  public boolean isEmpty() {
    boolean empty = false;
      //TODO: Implement this method.
    empty = (head == null);
    return empty;
  }

  public Iterator<T> iterator() {
    Iterator<T> iter = null;
      //TODO: Implement this method.
   iter = new LinkedNodeIterator <T> (head);
   return iter;
  }
}
