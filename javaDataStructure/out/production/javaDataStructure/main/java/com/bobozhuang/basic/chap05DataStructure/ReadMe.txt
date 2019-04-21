Java 数据结构
Java工具包提供了强大的数据结构。在Java中的数据结构主要包括以下几种接口和类：

枚举（Enumeration）
位集合（BitSet）
向量（Vector）
栈（Stack）
字典（Dictionary）
哈希表（Hashtable）
属性（Properties）

枚举（Enumeration）接口虽然它本身不属于数据结构,但它在其他数据结构的范畴里应用很广。 枚举（The Enumeration）接口定义了
一种从数据结构中取回连续元素的方式。
这种传统接口已被迭代器取代，虽然Enumeration 还未被遗弃，但在现代代码中已经被很少使用了。尽管如此，它还是使用在
诸如Vector和Properties这些传统类所定义的方法中，除此之外，还用在一些API类，并且在应用程序中也广泛被使用。
Enumeration声明的方法：
1	boolean hasMoreElements( )  测试此枚举是否包含更多的元素。
2	Object nextElement( )
    如果此枚举对象至少还有一个可提供的元素，则返回此枚举的下一个元素(用来得到一个包含多元素的数据结构的下一个元素)。

Java Vector 类
Vector 类实现了一个动态数组。和 ArrayList 很相似，但是两者是不同的：

Vector 是同步访问的。
Vector 包含了许多传统的方法，这些方法不属于集合框架。
Vector 主要用在事先不知道数组的大小，或者只是需要一个可以改变大小的数组的情况。

Vector 类支持 4 种构造方法。

第一种构造方法创建一个默认的向量，默认大小为 10：
