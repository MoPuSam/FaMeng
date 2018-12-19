package com.oulam.controller;

import com.oulam.bean.FMForm;
import com.oulam.entry.Entry;
import com.oulam.service.FormService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Oulam on 2018/12/18.
 */
@Controller
@RequestMapping(value = "/form")
public class FormCotroller {
    private static final Logger log = LoggerFactory.getLogger(FormCotroller.class);
    @Resource(name="formService")
    FormService service;
    @Value("${file.path}")
    private String filePath;
    @ResponseBody
    @RequestMapping(value = "/insert/form", produces = {"application/json;multipart/form-data;charset=UTF-8"},method = RequestMethod.POST)
    public String getInstance(HttpServletRequest request) throws ParseException {
        MultipartHttpServletRequest p = ((MultipartHttpServletRequest) request);
        FMForm form = new FMForm();

        String f_messgae=p.getParameter("valve");
        log.info("阀门信息:"+f_messgae);
        form.setfMessgae(f_messgae);
        String f_material=p.getParameter("para174");
        log.info("主体材质:"+f_material);
        form.setfMaterial(f_material);
        String f_inno_material=p.getParameter("para175");
        log.info("内件材质:"+f_inno_material);
        form.setfInnoMaterial(f_inno_material);
        String f_temp =p.getParameter("para176");
        log.info("工作温度:"+f_temp);
        form.setfTemp(f_temp);
        String f_media =p.getParameter("para177");
        log.info("使用介质:"+f_media);
        form.setfMedia(f_media);
        String f_num =p.getParameter("para178");
        log.info("数量"+f_num);
        form.setfNum(Integer.parseInt(f_num));
        String f_address =p.getParameter("para179");
        log.info("收货地址"+f_address);
        form.setfAddress(f_address);
        String f_explain =p.getParameter("para164");
        log.info("补充说明"+f_explain);
        form.setfExplain(f_explain);
        //其他要求
        String f_ask_way =p.getParameter("price");
        log.info("询价方式"+f_ask_way);
        form.setfAskWay(f_ask_way);
        String[] f_ask_form =p.getParameterValues("worth");
        log.info("询价形式"+f_ask_form);
        form.setfAskForm(f_ask_form[0]+" "+f_ask_form[1]);
        String f_date =p.getParameter("para183");
        log.info("交货日期"+f_date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date ff_date = sdf.parse(f_date);
        form.setfDate(ff_date);
        String f_pay_way =p.getParameter("pay");
        log.info("询价方式"+f_pay_way);
        form.setfPayWay(f_pay_way);
        String f_yourname =p.getParameter("yourname");
        log.info("你的名称"+f_yourname);
        form.setfYourname(f_yourname);
        String f_yourphone =p.getParameter("phone");
        log.info("你的名称"+f_yourphone);
        form.setfYourphone(f_yourphone);
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if(multipartResolver.isMultipart(request)) {
           // MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
            List<MultipartFile> files = p.getFiles("file");
            MultipartFile file = null;
            BufferedOutputStream stream = null;
            for (int i = 0; i < files.size(); ++i) {
                file = files.get(i);
                if (!file.isEmpty()) {
                    try {
                        byte[] bytes = file.getBytes();
                        String fileName = filePath + file.getOriginalFilename();
                        log.info("fileName="+fileName);
                        //附件文件地址
                        form.setfFile(fileName);
                        stream = new BufferedOutputStream(new FileOutputStream(
                                new File(fileName)));
                        stream.write(bytes);
                        stream.close();
                    } catch (Exception e) {
                        stream = null;
                        return "You failed to upload " + i + " => "
                                + e.getMessage();
                    }
                } else {
                    return "You failed to upload " + i
                            + " because the file was empty.";
                }
            }
        }
        service.insert(form);
        return "表单提交成功";
    }
    @RequestMapping("/goto")
    public String go(HttpServletRequest request){
        return "index";
    }
    /**
     * 文件上传具体实现方法;
     *
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                /*
                 * 这段代码执行完毕之后，图片上传到了工程的跟路径； 大家自己扩散下思维，如果我们想把图片上传到
                 * d:/files大家是否能实现呢？ 等等;
                 * 这里只是简单一个例子,请自行参考，融入到实际中可能需要大家自己做一些思考，比如： 1、文件路径； 2、文件名；
                 * 3、文件格式; 4、文件大小的限制;
                 */
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(
                                file.getOriginalFilename())));
                System.out.println(file.getName());
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }

            return "上传成功";

        } else {
            return "上传失败，因为文件是空的.";
        }
    }
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setResolveLazily(true);//resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
        resolver.setMaxInMemorySize(40960);
        resolver.setMaxUploadSize(10*1024*1024);//上传文件大小 50M 50*1024*1024
        return resolver;
    }
}
