package org.softcits.netty.sendobject.coder;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

import org.softcits.netty.sendobject.utils.ByteBufToBytes;
import org.softcits.netty.sendobject.utils.ByteObjConverter;

 
 /**
  * �����л�
  * ��Byte[]ת��ΪObject
  * @author wilson
  *
  */
public class PersonDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
    	//�����ࣺ��ByteBufת��Ϊbyte[]
        ByteBufToBytes read = new ByteBufToBytes();
        byte[] bytes = read.read(in);
        //�����ࣺ��byte[]ת��Ϊobject
        Object obj = ByteObjConverter.byteToObject(bytes);
        out.add(obj);
    }
 
}
