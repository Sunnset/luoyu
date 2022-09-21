package org.luoyu.boot;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import org.testng.annotations.Test;

/**
 * @author WangZhiBao
 * @program: sbootlearn
 * @description
 * @create: 2022-09-20 23:12
 */
public class OfdTest {
    @Test
    public void ofd(){
        //实例化Document类的对象
        Document document = new Document();

        //加载Word文档
        document.loadFromFile("/Users/zbwang/Documents/周一.docx");

        //保存为OFD格式
        document.saveToFile("/Users/zbwang/Documents/周一.ofd", FileFormat.OFD);
    }
}
