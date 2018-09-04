package com.hnq.study.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author henengqiang
 * @date 2018/9/4
 */
public class FileUtils {

    /**
     * 通过文件名，读取文件并缓冲
     * @param fileName  文件名
     * @return          String
     * @throws IOException
     *                  异常抛给调用者处理
     */
    public static String read(String fileName, String format) throws IOException {
        //通过行读取输入
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            sb.append(s).append(format);
        }
        //关闭文件
        in.close();
        return sb.toString();
    }

}
