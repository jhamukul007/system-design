package com.system.design.list.roundrobin;

public class RoundRobinTest {
    public static void main(String[] args) {
        RoundRobinAlgorithm<Integer> servers = new RoundRobinAlgorithm<>();
        servers.insert(1);
        servers.insert(2);
        servers.insert(3);

        System.out.println(servers.get());
        System.out.println(servers.get());
        System.out.println(servers.get());
        System.out.println(servers.get());
        System.out.println(servers.get());
        System.out.println(servers.get());

    }
}
