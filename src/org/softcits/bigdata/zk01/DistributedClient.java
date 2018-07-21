package org.softcits.bigdata.zk01;

import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class DistributedClient {

	private static final String connectString = "mini1:2181,mini2:2181,mini3:2181";
	private static final int sessionTimeout = 2000;
	private static final String parentNode = "/servers";
	// ע��:��volatile��������ڣ�
	private volatile List<String> serverList;
	private ZooKeeper zk = null;

	/**
	 * ������zk�Ŀͻ�������
	 * 
	 * @throws Exception
	 */
	public void getConnect() throws Exception {

		zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				// �յ��¼�֪ͨ��Ļص�������Ӧ���������Լ����¼������߼���
				try {
					//���¸��·������б�����ע���˼���
					getServerList();

				} catch (Exception e) {
				}
			}
		});

	}

	/**
	 * ��ȡ��������Ϣ�б�
	 * 
	 * @throws Exception
	 */
	public void getServerList() throws Exception {

		// ��ȡ�������ӽڵ���Ϣ��!!!!!!!!!���ҶԸ��ڵ���м���
		List<String> children = zk.getChildren(parentNode, true);

		// �ȴ���һ���ֲ���list�����������Ϣ
		List<String> servers = new ArrayList<String>();
		for (String child : children) {
			// childֻ���ӽڵ�Ľڵ���
			byte[] data = zk.getData(parentNode + "/" + child, false, null);
			servers.add(new String(data));
		}
		// ��servers��ֵ����Ա����serverList�����ṩ����ҵ���߳�ʹ��
		serverList = servers;
		
		//��ӡ�������б�
		System.out.println(serverList);
		
	}

	/**
	 * ҵ����
	 * 
	 * @throws InterruptedException
	 */
	public void handleBussiness() throws InterruptedException {
		System.out.println("client start working.....");
		Thread.sleep(Long.MAX_VALUE);
	}
	
	
	
	
	public static void main(String[] args) throws Exception {

		// ��ȡzk����
		DistributedClient client = new DistributedClient();
		client.getConnect();
		// ��ȡservers���ӽڵ���Ϣ���������������л�ȡ��������Ϣ�б�
		client.getServerList();

		// ҵ���߳�����
		client.handleBussiness();
		
	}

}
