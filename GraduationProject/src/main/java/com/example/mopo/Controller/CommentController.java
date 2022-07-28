package com.example.mopo.Controller;

import com.example.mopo.Common.Result;
import com.example.mopo.Entity.CommentEntity;
import com.example.mopo.Service.Impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentServiceImpl commentServiceImpl;

    @PostMapping("/comment")
    @ResponseBody
    public List<CommentEntity> getComment(@RequestBody CommentEntity commentEntity){
        List<CommentEntity> comments = commentServiceImpl.getVideoCommentById(commentEntity.getVideoId());
        return comments;
    }

    @PostMapping("/comment/saveComment")
    @ResponseBody
    public Result saveComment(@RequestBody CommentEntity commentEntity){
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        commentEntity.setTime(sdf.format(System.currentTimeMillis()));
        if (commentServiceImpl.save(commentEntity)){
            return new Result(200,"评论成功",null);
        }
        return new Result(501,"评论失败",null);
    }

    @PostMapping("/comment/delComment")
    @ResponseBody
    public Result delComment(@RequestBody CommentEntity commentEntity){
        if (commentServiceImpl.delComment(commentEntity.getId())){
            return new Result(200,"删除成功",null);
        }
        return new Result(501,"删除失败",null);
    }
}
