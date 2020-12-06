第一周学习总结：
一.数组、链表、跳表：
1.特性：
数组：顺序存储结构，内存连续地址（长度的增加会引起内存数据的复制）
java代码分析：
http://developer.classpath.org/doc/java/util/ArrayList-source.html

时间复杂度：
prepend O(n)：
正常情况下为O(n)的，可以通过放大空间，移动下标0的位置来实现O(1)的复杂度效果
append  O(1)
lookup  O(1)
insert  O(n)
delete  O(n)

链表：链式存储结构，需要定义node节点对象
通过链表中的指针链接次序实现。
基本概念：
链表的第一个节点存储位置叫做头指针；（必要）
头一个节点前附加的一个头节点；（非必要，数值无意义，可以存储长度数据）
头节点不是第一节点，头结点的头指针指向第一节点
类型分为：
单链表：每个节点包含一个指针域，尾节点指针指向空
静态链表：数组表示的链表（使用游标控制较大空间的数组）
循环链表：将尾指针的指向空改为指向头节点，形成一个环，单循环链表；
如果有头节点的话，空链表为头节点指向自己
双向链表：每个节点里再多加一个前驱节点指针域，如果有头节点的话，
头结点的空链表为两个指针都指向自己
双向循环链表

class LinkedList { 
    Node head; // head of list 

    /* Linked list Node*/
    class Node { 
        int data; 
        Node next; 
  
        // Constructor to create a new node 
        // Next is by default initialized 
        // as null 
        Node(int d) { data = d; } 
    } 
}
时间复杂度：
prepend O(1)
append  O(1)
lookup  O(n)
insert  O(1)
delete  O(1)

跳表：升维度，空间换时间
前提：有序
只能用于元素有序的情况。
对标的事平衡树（AVL Tree）和二分查找
插入、删除、搜索都是O(log n)的数据机构，出现较晚。

最大的优势：
原理简单，实现容易，扩展方便，效果较高
问题：
多次的改动节点，会导致多级索引的跨度不工整，增加了多级索引的维护成本，增删的时间复杂度变为了O(logn)

可以用了替代平衡树，使用场景：redis，levelDB
多级索引
时间复杂度O（logn）
空间复杂度O（n）

2.实例：
移动零：
盛水最多的容器：
爬楼梯：
3数之和：
环形链表：

二.栈、队列、优先队列、双端队列：
1.特性：
栈：先入后出，增加和删除O(1),查询O(n)
代码实现：一般用数组实现相关特性

队列：先入先出，增加和删除O(1),查询O(n)


双端队列 deque（double ended queue）：
实践中用双端队列（栈 + 队列）
两端可以进出的Queue
插入和删除都是O(1)操作
查询是O(n)



2.实例：
有效的括号：
最小栈：