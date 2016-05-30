package com.myf.weixin.service.queue;

import com.google.gson.Gson;
import com.myf.weixin.entity.Account;
import com.myf.weixin.entity.MediaInfo;
import com.myf.weixin.entity.weixin.queue.MediaQueueInfo;
import com.myf.weixin.service.AccountService;
import com.myf.weixin.service.MediaInfoService;
import com.myf.weixin.service.weixin.AccessTokenService;
import com.myf.weixin.service.weixin.MediaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by myf on 2016/5/30.
 */
public class MediaDownloadService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AccessTokenService tokenService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private MediaInfoService mediaInfoService;

    @Value("${media.savePath}")
    private String savePath;

    public void downloadMedia(String mediaQueueInfo){
        try {
            logger.debug(mediaQueueInfo);
            Gson gson = new Gson();
            MediaQueueInfo info = gson.fromJson(mediaQueueInfo, MediaQueueInfo.class);
            if (info != null) {
                Account account = accountService.findOne(info.getAccountId());
                MediaInfo mediaInfo = mediaInfoService.findOne(info.getMediaId());
                if (account != null && mediaInfo!=null) {
                    String accessToken = tokenService.GetAccessToken(account.getAppid(), account.getAppsecret());
                    String filePath = MediaService.getMedia(accessToken, info.getWxMediaId(), savePath);
                    mediaInfo.setMediaurl(filePath);
                    mediaInfoService.updateMediaInfo(mediaInfo);
                }
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
}
