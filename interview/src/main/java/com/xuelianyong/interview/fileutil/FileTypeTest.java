package com.xuelianyong.interview.fileutil;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.json.JSONUtil;
import eu.medsea.mimeutil.MimeType;
import eu.medsea.mimeutil.MimeUtil;
import eu.medsea.mimeutil.MimeUtil2;
import org.springframework.util.MimeTypeUtils;

import java.io.*;
import java.util.Collection;

/**
 * @author lijunpeng02
 * @date 2022年11月04日 14:33
 */
public class FileTypeTest {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/lijunpeng/Downloads/批量更换合同负责BD-20221101.xlsx");
        byte[] fileByte = IoUtil.readBytes(new FileInputStream(file));
        Collection mimeTypes = MimeUtil.getMimeTypes(fileByte);
        MimeType mimeType= null;
        if(CollectionUtil.isNotEmpty(mimeTypes)){
            mimeType= (MimeType) mimeTypes.stream().findFirst().get();
        }
        System.out.println(JSONUtil.toJsonStr(mimeType.getMediaType()));
    }
}
