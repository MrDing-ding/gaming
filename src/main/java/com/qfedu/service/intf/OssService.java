package com.qfedu.service.intf;

import com.qfedu.kataba.vo.R;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @program: Kataba
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-10-21 16:00
 */
public interface OssService {
    //资源上传
    R upload(String token, MultipartFile file) throws IOException;
}
