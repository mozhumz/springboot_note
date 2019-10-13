package com.hyj.demo.io;

import org.junit.Test;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class IOTest {
    @Test
    public void testPutStream() {
        FileInputStream fileInputStream = null;

        FileOutputStream fileOutputStream = null;
        try {

            String filePre = this.getClass().getClassLoader()
                    .getResource("").getPath();
            String fileStr = filePre + "io" + File.separator + "1.txt";

            String fileOutStr = filePre + "io" + File.separator + "2.txt";
            fileInputStream = new FileInputStream(fileStr);
            fileOutputStream = new FileOutputStream(fileOutStr, true);

            byte[] bytes = new byte[1];
            int len = -1;
            while ((len = fileInputStream.read(bytes, 0, bytes.length)) != -1) {
                String s = new String(bytes, 0, len);
                System.out.println(s);
                fileOutputStream.write(bytes, 0, len);

            }
            fileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testReader() throws Exception {
        String filePre = this.getClass().getClassLoader()
                .getResource("").getPath();
        String fileStr = filePre + "io" + File.separator + "1.txt";
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(fileStr)
        );
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
        bufferedReader.close();


    }


    @Test
    public void testEncode() throws Exception {
        System.out.println("系统默认编码为：" + System.getProperty("file.encoding"));
        File file = new File("g:" + File.separator + "hello.txt");
        OutputStream out = null;
        out = new FileOutputStream(file);
        byte[] bytes = "你好".getBytes("ISO8859-1");
        out.write(bytes);
        out.close();
        //输出结果为乱码，系统默认编码为UTF-8，而此处编码为ISO8859-1
    }

    public static void main(String[] args) throws Exception {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        // 设置Socket是非阻塞的
        socketChannel.configureBlocking(false);
        // 绑定到5555端口
        socketChannel.bind(new InetSocketAddress(5555));
        Selector selector = Selector.open();
        // 为服务器注册接收事件
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            int count = selector.select();
            if (count <= 0) continue;
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> iterable = selectionKeySet.iterator();
            while (iterable.hasNext()) {
                SelectionKey key = iterable.next();
                if (key.isAcceptable()) {
                    // 如果accept被激活，说明有客户端连接
                    SocketChannel newSocketChannel = socketChannel.accept();
                    newSocketChannel.configureBlocking(false);
                    // 为客户端连接添注册读事件
                    newSocketChannel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    // 如果读到客户端的数据
                    SocketChannel clientSocket = (SocketChannel) key.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    clientSocket.read(byteBuffer);
                    System.out.println(new String(byteBuffer.array()));
                    String text = "Hello: " + new String(byteBuffer.array()) + "\r\n";
                    // 将Hello + 客户端数据返回给用户
                    clientSocket.write(ByteBuffer.wrap(text.getBytes()));
                }
                iterable.remove();
            }
        }
    }
}
