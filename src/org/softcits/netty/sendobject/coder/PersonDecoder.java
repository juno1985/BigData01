package org.softcits.netty.sendobject.coder;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

import org.softcits.netty.sendobject.utils.ByteBufToBytes;
import org.softcits.netty.sendobject.utils.ByteObjConverter;

 
 /**
  * 反序列化
  * 将Byte[]转换为Object
  * @author wilson
  *
  */
public class PersonDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
    	//工具类：将ByteBuf转换为byte[]
        ByteBufToBytes read = new ByteBufToBytes();
        byte[] bytes = read.read(in);
        //工具类：将byte[]转换为object
        Object obj = ByteObjConverter.byteToObject(bytes);
        out.add(obj);
    }
 
}
