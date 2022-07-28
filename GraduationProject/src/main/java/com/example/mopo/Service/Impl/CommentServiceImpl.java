package com.example.mopo.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mopo.Entity.CommentEntity;
import com.example.mopo.Entity.UserEntity;
import com.example.mopo.Mapper.CommentMapper;
import com.example.mopo.Mapper.UserMapper;
import com.example.mopo.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, CommentEntity> implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    public List<CommentEntity> getVideoCommentById(long videoId){
        //先获取评论内容
        List<CommentEntity> userComments = commentMapper.getUserComments(videoId);
        //根据最上层Id=0的评论先提取出来
        List<CommentEntity> comments = userComments.stream().filter(comment -> comment.getOriginId() == 0).collect(Collectors.toList());
        //再获取最上层评论下面的回复内容
        for (CommentEntity comment : comments){
            //如果comment的originId等于 最外层评论也就是comments内容 那么这个comment就是属于comments的child
            List<CommentEntity> child = userComments.stream().filter(allComment -> comment.getId() == allComment.getOriginId()).collect(Collectors.toList());
            comment.setChild(child);
        }
        return comments;
    }

    public Boolean delComment(long commentId){
        QueryWrapper<CommentEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",commentId);
        int delete = commentMapper.delete(queryWrapper);
        return delete!=0;
    }


}
