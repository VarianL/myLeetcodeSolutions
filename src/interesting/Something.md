## 简述JAVA的垃圾回收机制原理
1.采用标记计数的方法：

给内存中的对象给打上标记，对象被引用一次，计数就加1，引用被释放了，计数就减一，当这个计数为0的时候，这个对象就可以被回收了。当然，这也就引发了一个问题：循环引用的对象是无法被识别出来并且被回收的。所以就有了第二种方法：

2.采用根搜索算法：

从一个根出发，搜索所有的可达对象，这样剩下的那些对象就是需要被回收的
判断完了哪些对象是没用的，这样就可以进行回收了
在之前的基础上将存活的对象给整理一下，使他们变成一个连续的内存，从而释放出连续的较大的内存空间。

3.采用复制的办法：

将内存分为2块，一块用来存放对象，另一块用来放着，当存放对象的那块满了以后就将上面存活的对象给复制过来，然后在这块内存上工作，并且将之前的内存清空，当自己这块满了以后再复制回去，如此反复。


## 	合并两个有序链表的递归算法
```
    ListNode mergeTwoListNode(ListNode l1, ListNode l2) {
        if (l1 == null ) {
            return l2;
        } else if ( l2 == null ) {
            return l1;
        }

        if ( l1.val < l2.val ) {
            ListNode ln = l1;
            return mergeTwoListNode(l1.next, l2);
        } else {
            ListNode ln = l2;
            return mergeTwoListNode(l1, l2.next);
        }
    }
```

## final,finally,finalize区别

final: 
    
    java关键字，如果一个变量被声明为final，他不能再派生新的子类，不能作为父类被继承，因此一个变量被声明为abstract又被成为被声明为final；
    将变量或方法声明为final，可以保证使用中不会被改变，声明变量是必须给初始值，而后的引用中只能被读取不能被改变，声明为final的方法同样也只能被使用

finally:

    异常处理机制的最后执行的操作（如果有的话），用来执行清除操作。如果抛出一个异常，先执行catch，然后finally中的代码

fianlize:

    方法名，Obejct的一个protected方法，返回值为空，当对象被垃圾回收器回收时会调用该方法。


## Error与Exception

    Error类一般是指与虚拟机相关的问题，如系统崩溃，虚拟机错误，内存空间不足，方法调用栈溢出等。如java.lang.StackOverFlowError和Java.lang.OutOfMemoryError。对于这类错误，Java编译器不去检查他们。对于这类错误的导致的应用程序中断，仅靠程序本身无法恢复和预防，遇到这样的错误，建议让程序终止。

    Exception表示程序可以处理的异常，可捕获可修复，应尽量处理，而不是终止；
    可以分为RuntimeException和CheckedException；

## 实例变量与静态变量

     在程序运行时的区别：实例变量属于某个对象的属性，必须创建了实例对象，其中的实例变量才会被分配空间，才能使用这个实例变量。静态变量不属于某个实例对象，而是属于类，所以也称为类变量，只要程序加载了类的字节码，不用创建任何实例对象，静态变量就会被分配空间，静态变量就可以被使用了

```
1，hashmap与hashtablede   的区别
2，HashMap和CurrentHashMap的区别
3，spring 事务传播行为及特点
4,   hashmap中hash冲突原理
5，synchronized与valitail区别
6,  Spring    切面在项目中的使用
7，项目中的一些名词注意理解
8，hashset 底层唯一性
9，redis数据同步
10，bean得生命周期
11，spring事务得隔离级别
12，main方法是否可以重写
13，Oracle关键字含义及使用
```