package org.softcits.rpc.customised.sample.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.softcits.rpc.customised.client.RpcProxy;
import org.softcits.rpc.customised.sample.client.HelloService;
import org.softcits.rpc.customised.sample.client.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-rpc-client.xml")
public class HelloServiceTest {

	@Autowired
	private RpcProxy rpcProxy;

	@Test
	public void helloTest1() {
		// 调用代理的create方法，代理HelloService接口
		HelloService helloService = rpcProxy.create(HelloService.class);
		
		// 调用代理的方法，执行invoke
		String result = helloService.hello("World");
		System.out.println("服务端返回结果：");
		System.out.println(result);
	}

	@Test
	public void helloTest2() {
		HelloService helloService = rpcProxy.create(HelloService.class);
		String result = helloService.hello(new Person("Yong", "Huang"));
		System.out.println("服务端返回结果：");
		System.out.println(result);
	}
}
