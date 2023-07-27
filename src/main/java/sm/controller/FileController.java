package sm.controller;

import cn.hutool.extra.servlet.ServletUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class FileController {
    private String filePath = "E:/springboot_save_file/";


    @RequestMapping("/zpx/toUpload")
    public String toUpload(){

        return "zpx/upload";
    }
    /**
     *  将文件保存到指定文件夹
     * @param file  单个文件
     * @param files 多个文件
     * @return      重定向到controller层中前往下载页面的url
     * @throws IOException
     */
    @PostMapping("/zpx/upload")
    public String uploadAndGoDownLoad(@RequestPart("file") MultipartFile file,
                                      @RequestPart("files") List<MultipartFile> files) throws IOException {

        //判断文件夹是否存在，不存在时，创建文件夹
        File directoryFile = new File(filePath);
        if (!directoryFile.exists()) {
            //创建多个文件夹
            directoryFile.mkdirs();
        }

        //判断文件是否为空，不为空时，保存文件
        if (!file.isEmpty()) {
            saveFile(file);
        }

        //判断上传文件个数是否为0
        if (files.size() > 0) {
            for (MultipartFile multipartFile : files) {
                if (!multipartFile.isEmpty()) {
                    saveFile(multipartFile);
                }
            }
        }
        return "redirect:/zpx/list";
    }

    /**
     * 保存所有的所有上传的文件名称，前往下载页面
     * @param model
     * @return 页面名称
     */
    @GetMapping("/zpx/download")
    public String goDownload(Model model) {
        File file = new File(filePath);
        //判断文件夹是否存在
        if (file.exists()) {
            //获取文件夹下面的所有名称
            String[] list = file.list();
            model.addAttribute("fileNames", list);
        }

        return "/zpx/download";
    }
    /**
     * 使用Hutool实现文件下载
     * @param fileName 要下载的文件名
     * @param response
     */
    @GetMapping("/download/hutool")
    @ResponseBody
    public void downloadByHutool(@RequestParam(value = "fileName") String fileName,
                                 HttpServletResponse response) {
        //防止中文乱码
        response.setCharacterEncoding("UTF-8");
        ServletUtil.write(response,new File(filePath + fileName));
    }

    /**
     * 保存文件到指定位置
     * @param file 需要上传的文件
     * @throws IOException
     */
    public void saveFile(MultipartFile file) throws IOException {
        //获取文件名
        String name = file.getOriginalFilename();
        file.transferTo(new File(filePath + name));
    }
}