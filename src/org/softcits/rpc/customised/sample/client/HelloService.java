package org.softcits.rpc.customised.sample.client;

public interface HelloService {

    String hello(String name);

    String hello(Person person);
}