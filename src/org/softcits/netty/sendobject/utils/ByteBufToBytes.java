package org.softcits.netty.sendobject.utils;

import io.netty.buffer.ByteBuf;

public class ByteBufToBytes {
	/**
	 * ��ByteBufת��Ϊbyte[]
	 * @param datas
	 * @return
	 */
	public byte[] read(ByteBuf datas) {
		byte[] bytes = new byte[datas.readableBytes()];// ����byte[]
		datas.readBytes(bytes);// ��ByteBufת��Ϊbyte[]
		return bytes;
	}
}