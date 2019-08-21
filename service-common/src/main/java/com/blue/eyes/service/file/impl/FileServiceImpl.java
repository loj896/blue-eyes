package com.blue.eyes.service.file.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blue.eyes.entity.file.TFile;
import com.blue.eyes.mapper.file.TFileMapper;
import com.blue.eyes.service.file.FileService;
import org.springframework.stereotype.Service;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-08-21 13:54
 *           '::::::::::::'           @description
 *             .:::::::::: 
 *        '::::::::::::::.. 
 *             ..::::::::::::. 
 *           ``:::::::::::::::: 
 *            ::::``:::::::::'        .:::. 
 *           ::::'   ':::::'       .::::::::. 
 *         .::::'      ::::     .:::::::'::::. 
 *        .:::'       :::::  .:::::::::' ':::::. 
 *       .::'        :::::.:::::::::'      ':::::. 
 *      .::'         ::::::::::::::'         ``::::. 
 *  ...:::           ::::::::::::'              ``::. 
 * ```` ':.          ':::::::::'                  ::::.. 
 *                    '.:::::'                    ':'````.. 
 */
@Service
public class FileServiceImpl extends ServiceImpl<TFileMapper, TFile> implements FileService {
}
