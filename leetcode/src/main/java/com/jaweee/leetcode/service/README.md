主要就是使用策略模式，给出多种实现的算法。

service目录下是统一接口，impl是接口的实现层

在与service同目录下的对应类，调用接口，委托给service，service交给其实现类            