package com.chatRobot.Util;

/**
 * Created by XuPengFei on 2017/8/3.
 */
public class ImgeUtil {

    /**
     * 判断文件是否为图片文件
     * @param fileName
     * @return
     */
    public static Boolean isImageFile(String fileName) {
        String [] imgType = new String[]{Constant.IMG_FILE_JPG,Constant.IMG_FILE_JPEG,Constant.IMG_FILE_PNG,Constant.IMG_FILE_BMP,Constant.IMG_FILE_GIF};
        if(fileName==null) {
            return false;
        }
        fileName = fileName.toLowerCase();
        for(String type : imgType) {
            if(fileName.endsWith(type)) {
                return true;
            }
        }
        return false;
    }
}
