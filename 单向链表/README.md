# 单向链表

```java
public class SingleLinkedList<E> {
    private int size;
    private Node<E> first;
    
    // 内部类, 私有化
    private static class Node<E> {
        E element;
        Node<E> next;
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
    
}
```

- 获取某个节点

```java
private Node<E> node(int index) {
    rangeCheck(index);  // 边界检测
    
    Node<E> node = first;
    for(int i = 0; i< index; i++) {
        node = node.next;
    }
    return node;
    
}
```

- add

```java
public void add(int index, E element) {
    if(index == 0) {
        first = new Node<E>(element, first);
    } else {
        Node<E> prev = node(index-1);
        prev.next = new Node<E>(element, prev.next);
    }
    
    size++;
}
```

- set

```java
public E set(int index, E element) {
	Node<E> node = node(index);
	E old = node.element;
	node.element = element;
	return old;
}
```

- get

```java
public E get(int index) {
	return node(index).element;
}
```

- clear

```java
public void clear() {
	// TODO Auto-generated method stub
	size = 0;
	first = null;
}
```

- remove 

```java
public E remove(int index) {
    Node<E> node = first;
    if(index == 0) {
        first = first.next;
    } else {
        Node<E> prev = node(index-1);
        node = prev.next;
        prev.next = prev.next.next;
    }
    size--;
    return node.element;
}
```

- indexOf 

```java
public int indexOf(E element) {
    if(element == null) {
        Node<E> node = first;
        for(int i = 0; i < size; i++) {
            if(node.element == null) {
                return i;
            }
            node = node.next;
        } 
    } else {
        Node<E> node = first;
        for(int i=0; i<size; i++) {
            if(element.equals(node.element)){
                return i;
            }
            node = node.next;
        }
    }
    return -1;
}
```

