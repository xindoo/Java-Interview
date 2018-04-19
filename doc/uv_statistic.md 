## uv统计
UV是unique visitor的简写，是指通过互联网访问、浏览这个网页的自然人。---百度百科    
uv统计和pv统计有很大的不同，uv需要去除掉同一用户重复的访问，所以uv统计最重要的一步是去重，在分布式计算环境下（storm、flink）下，必然要有个全局去重的机制，比如全局cache。通过去重后流到最后汇总统计节点的就是uv了（如果没有去重就是pv了）。  
### 优化 
如果在计算过程中（比如storm中），对每条消息都通过中心cache去重，这对中心cache的压力其实非常大，所以可以通过计算节点的localcache先做一次初去重，击穿localcache的再到中心cache去重，这样可以减少中心cache的压力。  
可以对localcache做下优化，不用cache而是使用[Bloomfilter](https://blog.csdn.net/jiaomeng/article/details/1495500)来去重，但Bloomfilter有小概率会误判，最终会丢失一点点uv。  