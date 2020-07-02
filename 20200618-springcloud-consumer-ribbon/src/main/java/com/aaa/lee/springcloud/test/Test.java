package com.aaa.lee.springcloud.test;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/6/18 11:04
 * @Description
 **/
public class Test {

    /**
     * Randomly choose from all living servers
     */
    /*@edu.umd.cs.findbugs.annotations.SuppressWarnings(value = "RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE")
    public Server choose(ILoadBalancer lb, Object key) {
        // 1.严谨判断(就是判断ILoadBalancer是否为null，如果为null直接返回null)
        if (lb == null) {
            return null;
        }
        // 2.定义最终返回给consumer的provider
        Server server = null;

        // 3.选择最终的provider，循环触发条件是server == null，说明一直没有选择出来
        while (server == null) {
            // 4.多线程的判断(只要聊到负载均衡一定是并发量足够大了)
            // interrupted()--->线程是否被中断
            // 如果线程中断，说明访问中断，直接return
            if (Thread.interrupted()) {
                return null;
            }
            // 5.获取到存活到provider
            List<Server> upList = lb.getReachableServers();
            // 6.获取到所有的provider
            List<Server> allList = lb.getAllServers();(1,2,3,4,5,6,7,8)
            // 7.获取一共有多少个provider
            int serverCount = allList.size();
            // 8.严谨判断(一台provider都没有)
            if (serverCount == 0) {
                *//*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 *//*
                return null;
            }
            // 9.随机选择int类型的一个数字(2)
            int index = chooseRandomInt(serverCount);
            // 10.从存活的服务器中获取当前所随机出来的provider
            server = upList.get(index);
            // 11.严谨判断(如果server为null就说明是一个宕机的provider)
            if (server == null) {
                // 线程谦让
                线程一旦被激活都不会相互谦让，因为他们要抢夺资源
                // 会造成一种现象，叫做死锁
                当这些线程发现server为null的时候，会很失望，表示自己没事做了，睡觉吧(sleep(抱着锁睡))
                所以线程就会一直处于等待状态，所以就会造成一种线程，叫做服务积压--->最终会造成一种线程叫做服务器宕机
                一旦调用yield之后，线程无所事事的时候，就会直接处于就绪状态，等待下一次抢夺资源
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    为什么不用random？
    Random这个类是线程安全的，而且random是可以预测的
    ThreadLocalRandom:
        本地线程的随机数类:线程不安全
    这个随机场景是不需要线程安全的，而且效率非常好，并且不可预测(Thread.getId()--->这个线程的编码是永远不可能在同一个集群中重复的)
    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }*/
}
