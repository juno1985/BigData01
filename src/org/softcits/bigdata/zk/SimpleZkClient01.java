package org.softcits.bigdata.zk;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooKeeper.States;

public class SimpleZkClient01 {
	/**
	 * server.0=192.168.4.129:2888:3888
		server.1=192.168.4.130:2888:3888
		server.2=192.168.4.131:2888:3888

	 * @param args
	 */
	private static final String connectString = "192.168.4.130:2888,192.168.4.130:2888,192.168.4.131:2888";
	private static final int sessionTimeout = 60000;
	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		ZooKeeper zkClient = new  ZooKeeper(connectString, sessionTimeout, new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				//收到事件通知后的回调
				System.out.println(event.getType() + "---->" + event.getPath());
			}
		});
		/*CountDownLatch connectedLatch = new CountDownLatch(1);
        if (States.CONNECTING == zkClient.getState()) {  
            try {  
                connectedLatch.await();  
            } catch (InterruptedException e) {  
                throw new IllegalStateException(e);  
            }  
        }*/
		String node = zkClient.create("/eclipse", "hello world".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
	}

}
