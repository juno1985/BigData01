package org.softcits.rpc.customised.sample.server;

import org.softcits.rpc.customised.sample.client.HelloService;
import org.softcits.rpc.customised.sample.client.Person;
import org.softcits.rpc.customised.server.RpcService;

@RpcService(HelloService.class)
public class HelloServiceImpl implements HelloService {

    public String hello(String name) {
    	System.out.println("�Ѿ����÷���˽ӿ�ʵ�֣�ҵ������Ϊ��");
    	System.out.println("Hello! " + name);
        return "Hello! " + name;
    }

    public String hello(Person person) {
    	System.out.println("�Ѿ����÷���˽ӿ�ʵ�֣�ҵ����Ϊ��");
    	System.out.println("Hello! " + person.getFirstName() + " " + person.getLastName());
        return "Hello! " + person.getFirstName() + " " + person.getLastName();
    }
}
