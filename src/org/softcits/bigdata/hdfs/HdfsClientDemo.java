package org.softcits.bigdata.hdfs;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author thinkpad
 *
 *	jvm参数
 *	-DHADOOP_USER_NAME=hadoop
 */
public class HdfsClientDemo {

	private FileSystem fs;
	@Before
	public void init() throws IOException, InterruptedException, URISyntaxException {
		Configuration conf = new Configuration();
//		conf.set("fs.defaultFS", "hdfs://host132:9000");
		//获得hdfs客户端
		fs = FileSystem.get(new URI("hdfs://host132:9000"),conf,"hdoop");
	}
	 @Test
	 public void testUpload() throws IllegalArgumentException, IOException {
		 fs.copyFromLocalFile(new Path("C:\\Users\\thinkpad\\Desktop\\SpringMVC拦截请求的方式.txt")
				 ,new Path("/SpringMVC拦截请求的方式.txt"));
		 fs.close();
	 }
}
