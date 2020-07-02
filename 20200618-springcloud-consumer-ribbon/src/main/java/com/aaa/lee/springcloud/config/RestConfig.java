package com.aaa.lee.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/6/18 10:03
 * @Description
 *      ribbon的负载均衡策略默认和nginx的策略一样都是轮询
 *
 *      ribbon的负载均衡常用策略:
 *          1.BestAvailableRule:
 *              找到一个负载/并发最小的服务
 *              8081--->200
 *              8082--->1000
 *              8083--->35
 *
 *          2.RetryRule:(依然按照的是轮询规则)
 *              默认ribbon没有提供重新连接的尝试(ribbon默认所给的重新连接值为0)
 *              consumer--->8081(存活)--->数据正常
 *              consumer--->8082(宕机)
 *              consumer--->8082(宕机)--->抛异常
 *              consumer--->8083(存活)--->数据正常
 *              等下一次再进入轮询的时候，就会跳过8082
 *
 *           3.RandomRule
 *              随机算法
 *
 *           4.RoundRibbonRule
 *              轮询算法
 *
 **/
@Configuration
public class RestConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * @author Seven Lee
     * @description
     *      修改ribbon的负载均衡策略
     *
     *      IRule(I):
     *          choose(Object key):就是来选择出最终所需要的一台provider
     *          ILoadBalancer就决定了你所使用的负载均衡策略
     *
     *      ILoadBalancer(I):
     *          markServerDown:把该台provider标识为宕机状态
     *          (不停机更新)
     *          getServerList:获取所有的provider(有参数是必传的--->boolean类型:是否可用)
     *          getReachableServers:获取所有存活的provider
     *          getAllServers:获取到所有的provider
     *
     *      RandomRule去继承了AbstractLoadBalancerRule:
     *          AbstractLoadBalancerRule--->实现了IRule接口
     *          也就是说AbstractLoadBalancerRule这么一个类就是IRule一个实现类
     *          而且RandomRule又继承AbstractLoadBalancerRule
     *          最终RandomRule也是一个IRule接口的实现类
     *
     * @param []
     * @date 2020/6/18
     * @return com.netflix.loadbalancer.IRule
     * @throws
    **/
    @Bean
    public IRule mineRule() {
        return new RandomRule();
    }



}
