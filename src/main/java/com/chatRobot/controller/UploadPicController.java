package com.chatRobot.controller;

import com.chatRobot.Util.FtpUtil;
import com.chatRobot.Util.ImgeUtil;
import com.chatRobot.domain.UploadPicInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by XuPengFei on 2017/8/3.
 */

@Controller
@RequestMapping("/upload")
public class UploadPicController {

    @Value("${FTP_uploadPath}")  //FTP_uploadPath=ftp://10.100.50.43/
    private String ftpUploadPath;

    @Value("${FTP_ADDRESS}") //FTP_ADDRESS=10.100.50.43
    private String ftpAddress;

    @Value("${FTP_PORT}")  // FTP_PORT=21
    private String ftpPort;

    @Value("${FTP_USERNAME}")  // FTP_USERNAME=xupengfei
    private String ftpUserName;

    @Value("${FTP_PASSWORD}") //FTP_PASSWORD=19880913
    private String ftpPassWord;

    @Value("${FTP_BASEPATH}")    //FTP_BASEPATH=/
    private String ftpBasePath;  // 下载地址地基础url


    @Value("${IMAGE_BASE_URL}") //IMAGE_BASE_URL=ftp://10.100.50.43/
    private String imageBaseUrl;

    @Value("${localUploadPath}") // E:/TEST/upload
    private String localUploadPath;


    /**
     * 上传图片到ＦＴＰ服务
     * @param MultipartFile file
     * @return
     */
    @RequestMapping(value = "/loadToFTP", method = RequestMethod.POST)
    public ModelAndView loadPicFile(@RequestParam(value = "file", required = false) MultipartFile file){
         //file = ((MultipartHttpServletRequest) request).getFile("file");
        UploadPicInfo upload = new UploadPicInfo();
        String fileName = file.getOriginalFilename();// 获得原始文件名
        if( ! ImgeUtil.isImageFile(fileName)){
            String ftpMsg ="你的图片格式不是要求的格式！";
            return new ModelAndView("success","ftpMsg",ftpMsg);
        }
        // 获取图片的扩展名
        String extensionName = fileName.substring(fileName.lastIndexOf(".")+1); //png ;jpg
        System.out.println("-------extensionName----->>>" + extensionName);
        // 生成新的图片文件名
        String newFileName = UUID.randomUUID() + "." + extensionName;
        upload.setFileName(newFileName);
        upload.setType(extensionName);
        upload.setUrl(extensionName+ File.separator+newFileName);
        upload.setBaseUrl(ftpBasePath);  // 下载地址地基础url
        try {
            BufferedImage sourceImg = ImageIO.read(file.getInputStream());
            upload.setSize(sourceImg.getWidth()+"*"+sourceImg.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //端口号
        int port = Integer.parseInt(ftpPort);
        //调用方法，上传文件
        try {
           /* boolean result = FtpUtil.uploadFile(ftpAddress, port,
                    ftpUserName, ftpPassWord, ftpBasePath, extensionName,
                    newFileName, file.getInputStream());*/
            boolean result = FtpUtil.uploadFile(ftpAddress, port,
                    ftpUserName, ftpPassWord, ftpBasePath,
                    newFileName, file.getInputStream());
            System.out.println("-FtpUtil-result------------->"+result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("uploadPic","upload",upload);
    }


    /**
     * 采用file.Transto 来保存上传的文件
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/loadToLocal", method = RequestMethod.POST)
    public  ModelAndView uploadPicToLocal(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        UploadPicInfo upload = new UploadPicInfo();
        long  startTime=System.currentTimeMillis();
        String fileName = file.getOriginalFilename();// 获得原始文件名
        if( ! ImgeUtil.isImageFile(fileName)){
            String localMsg ="你的图片格式不是要求的格式！";
            return new ModelAndView("success","localMsg",localMsg);
        }
        String extensionName = fileName.substring(fileName.lastIndexOf(".")+1);
        String newFileName = UUID.randomUUID() + "." + extensionName;
        //String path=localUploadPath +File.separator+ newFileName;
        String tomcatPath = request.getSession().getServletContext().getRealPath("upload");
        File newFile=new File(tomcatPath,newFileName);
        if (!newFile.exists()){
            newFile.mkdirs();
        }
        System.out.println("------tomcatPath-----"+tomcatPath + "---newFile==="+newFile);
        upload.setFileName(newFileName);
        upload.setType(extensionName);
        upload.setUrl(extensionName+ File.separator+newFileName);
        upload.setBaseUrl(tomcatPath);  // 下载地址地基础url
    try {
        BufferedImage sourceImg = ImageIO.read(file.getInputStream());
        upload.setSize(sourceImg.getWidth()+"*"+sourceImg.getHeight());
    } catch (IOException e) {
        e.printStackTrace();
    }
        file.transferTo(newFile);//通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        long  endTime=System.currentTimeMillis();
        System.out.println("方法二的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return new ModelAndView("uploadPic","upload",upload);
    }


    /*
     * 通过流的方式上传文件： 时间太久
     * @RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
     */
    @RequestMapping("/ioUpload")
    public ModelAndView  fileUpload(@RequestParam("file") CommonsMultipartFile file) throws IOException {
        //用来检测程序运行时间
        long  startTime=System.currentTimeMillis();
        System.out.println("-------file.getOriginalFilename()---"+file.getOriginalFilename());
        String path = "E:\\TEST\\upload\\"+file.getOriginalFilename();//new Date().getTime()+file.getOriginalFilename()
        try {
            //获取输出流
            OutputStream os=new FileOutputStream(path);
            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream is=file.getInputStream();
            int temp;
            //一个一个字节的读取并写入
            while((temp=is.read())!=(-1))
            {
                os.write(temp);
            }
            os.flush();
            os.close();
            is.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        UploadPicInfo upload = new UploadPicInfo();
        upload.setFileName(file.getOriginalFilename());
        String extensionName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        upload.setType(extensionName);
        upload.setUrl(extensionName+ File.separator+file.getOriginalFilename());
        upload.setBaseUrl(path);  // 下载地址地基础url
        try {// BufferedImage 只能是图片了，传其他文件就报 空指针
            BufferedImage sourceImg = ImageIO.read(file.getInputStream());
            upload.setSize(sourceImg.getWidth()+"*"+sourceImg.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }

        long  endTime=System.currentTimeMillis();
        System.out.println("方法IO的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return new ModelAndView("uploadPic","upload",upload);
    }


    /*
     *采用spring提供的上传文件的方法
     */
    @RequestMapping("/springUpload")
    public String  springUpload(HttpServletRequest request) throws IllegalStateException, IOException
    {
        long  startTime=System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {   //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
            while(iter.hasNext())
            {   //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String path="E:/TEST/upload/"+file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }
            }
        }
        long  endTime=System.currentTimeMillis();
        System.out.println("方法springUpload的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "success";
    }
}
