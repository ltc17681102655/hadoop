package hadoop;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.junit.Before;
import org.junit.Test;

public class HdfsUtil2 {

    org.apache.hadoop.fs.FileSystem fs = null;


    @Before
    public void init() throws Exception{

        //��ȡclasspath�µ�xxx-site.xml �����ļ��������������ݣ���װ��conf������
        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();

        //Ҳ�����ڴ����ж�conf�е�������Ϣ�����ֶ����ã��Ḳ�ǵ������ļ��еĶ�ȡ��ֵ
        conf.set("fs.defaultFS", "hdfs://39.106.208.40:9000/");

        //����������Ϣ��ȥ��ȡһ�������ļ�ϵͳ�Ŀͻ��˲���ʵ������
        fs = org.apache.hadoop.fs.FileSystem.get(new URI("hdfs://39.106.208.40:9000/"),conf,"root");


    }



    /**
     * �ϴ��ļ����Ƚϵײ��д��
     *
     * @throws Exception
     */
    @Test
    public void upload() throws Exception {

        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://weekend110:9000/");

        FileSystem fs = FileSystem.get(conf);

        Path dst = new Path("hdfs://weekend110:9000/aa/qingshu.txt");

        FSDataOutputStream os = fs.create(dst);

        FileInputStream is = new FileInputStream("c:/qingshu.txt");

        IOUtils.copy(is, os);


    }

    /**
     * �ϴ��ļ�����װ�õ�д��
     * @throws Exception
     * @throws IOException
     */
    @Test
    public void upload2() throws Exception, IOException{

//        fs.copyFromLocalFile(new Path("c:/qingshu.txt"), new Path("hdfs://weekend110:9000/aaa/bbb/ccc/qingshu2.txt"));
        fs.copyFromLocalFile(new Path("C:/Users/Administrator/Desktop/密码.txt"), new Path("hdfs://39.106.208.40:9000/mima.txt"));

    }


    /**
     * �����ļ�
     * @throws Exception
     * @throws IllegalArgumentException
     */
    @Test
    public void download() throws Exception {

        fs.copyToLocalFile(new Path("hdfs://39.106.208.40:9000/密码.txt"), new Path("c:/mima.txt"));

    }

    /**
     * �鿴�ļ���Ϣ
     * @throws IOException
     * @throws IllegalArgumentException
     * @throws FileNotFoundException
     *
     */
    @Test
    public void listFiles() throws FileNotFoundException, IllegalArgumentException, IOException {

        // listFiles�г������ļ���Ϣ�������ṩ�ݹ����
        RemoteIterator<LocatedFileStatus> files = fs.listFiles(new Path("/"), true);

        while(files.hasNext()){

            LocatedFileStatus file = files.next();
            Path filePath = file.getPath();
            String fileName = filePath.getName();
            System.out.println(fileName);

        }

        System.out.println("---------------------------------");

        //listStatus �����г��ļ����ļ��е���Ϣ�����ǲ��ṩ�Դ��ĵݹ����
        FileStatus[] listStatus = fs.listStatus(new Path("/"));
        for(FileStatus status: listStatus){

            String name = status.getPath().getName();
            System.out.println(name + (status.isDirectory()?" is dir":" is file"));

        }

    }

    /**
     * �����ļ���
     * @throws Exception
     * @throws IllegalArgumentException
     */
    @Test
    public void mkdir() throws IllegalArgumentException, Exception {

        fs.mkdirs(new Path("/aaa/bbb/ccc"));


    }

    /**
     * ɾ���ļ����ļ���
     * @throws IOException
     * @throws IllegalArgumentException
     */
    @Test
    public void rm() throws IllegalArgumentException, IOException {

        fs.delete(new Path("/aa"), true);

    }


    public static void main(String[] args) throws Exception {

        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://weekend110:9000/");

        org.apache.hadoop.fs.FileSystem fs = org.apache.hadoop.fs.FileSystem.get(conf);

        FSDataInputStream is = fs.open(new Path("/jdk-7u65-linux-i586.tar.gz"));

        FileOutputStream os = new FileOutputStream("c:/jdk7.tgz");

        IOUtils.copy(is, os);
    }



}

