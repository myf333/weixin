package com.myf.weixin.service;

import com.myf.weixin.entity.MediaInfo;
import com.myf.weixin.repository.impl.MediaInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by myf on 2016/5/20.
 */
public class MediaInfoService {
    @Autowired
    private MediaInfoRepository mediaInfoRepository;

    @Transactional
    public MediaInfo AddMediaInfo(MediaInfo mediaInfo){
        return mediaInfoRepository.save(mediaInfo);
    }
    @Transactional
    public MediaInfo updateMediaInfo(MediaInfo mediaInfo){
        return mediaInfoRepository.save(mediaInfo);
    }

}
