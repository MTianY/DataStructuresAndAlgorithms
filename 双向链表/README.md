# 双向链表

```java
public class LinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    
    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;
        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }
    
}
```

- node 获取某个节点

```java
private Node<E> node(int index) {
    rangeCheck(index);
    
    // 如果 index 小于 size 的一半, 在左边
    if(index < (size >> 1)) {
        Node<E> node = first;
        for(int i=0; i<index; i++) {
            node = node.next;
        }
        return node;
    } else {
        // 在右边
        Node<E> node = last;
        for(int i = size-1; i> index; i--) {
            node = node.prev;
        }
        return node;
    }
}
```

- get

```java
public E get(int index) {
    return node(index).element;
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

- add

```java
public void add(int index, E element) {
    
    rangeCheckForAdd(index);
    
    if(index == size) {
        // 最后面添加元素
        Node<E> oldLast = last;
        last = new Node<>(oldLast, element, null);
        if(oldLast == null) {
            // 链表添加的第一个元素
            first = last;
        } else {
            oldLast.next = last;
        }
    } else {
        // 新添加节点下一个
        Node<E> next = node(index);
        // 新添加节点上一个
        Node<E> prev = next.prev;
        // 新添加节点
        Node<E> node = new Node<>(prev, element, next);
        
        next.prev = node;
        
        if(prev == null) {
            // index = 0 位置
            first = node;
        } else {
            prev.next = node;
        }

    }
   
    size++;
    
}
```

- remove

```java
public E remove(int index) {
    rangeCheck(index);
    
    Node<E> node = node(index);
    Node<E> prev = node.prev;
    Node<E> next = node.next;
    
    if(prev == null) {
        // index == 0 
        first = next;
    } else {
        prev.next = next;
    }
    
    if (next == null) {
        // index == size-1
        last = prev;
    } else {
        next.prev = prev;
    }
    size--;
    return node.element;
}
```


