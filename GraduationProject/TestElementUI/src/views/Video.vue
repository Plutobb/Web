<template>
  <div style="background: #161722;margin-top: 0">
    <div id="videoDiv" class="videoDiv">
      <div class="videoData">
        <p style="margin-top: 5px;color:white;font-size: 18px">{{ videoInfo.videoTitle}}</p>
        <div class="videoIntroduce">
          <span style="color: hsla(0,0%,100%,.8);font-size: 16px">{{videoInfo.videoIntroduce}}</span>
          <span class="uploadTime">{{ videoInfo.videoUploadTime}}</span>
        </div>
      </div>
      <div style="height: 550px">
        <video style="height: 550px;object-fit: contain;background: black" :src="videoInfo.videoUrl" class="videos" autoplay playsinline controls="controls"></video>
      </div>
      <!--动画引入animate.css库,icon引入font-awesome图标库  -->
      <div class="huDongDiv">
        <div class="thumbsUpDiv">
          <vue-star id="star" animate="animated bounceIn" >
            <i slot="icon" class="fa fa-thumbs-o-up fa-2x" @click="thumbsUp(videoId)" >{{videoInfo.videoUpNum}}</i>
          </vue-star>
        </div>

        <div class="starDiv">
          <vue-star animate="animated bounceIn" >
            <i slot="icon" class="fa fa-star-o fa-2x" >{{videoInfo.videoStar}}</i>
          </vue-star>
        </div>
      </div>
      <div id="commentDiv" class="commentDiv">
        <el-input  v-model="content" placeholder="评论一下吧" class="commentInput">
          <el-button @click="saveComment()" slot="append" style="height: 60px;background: #161722;color: aliceblue;border-radius: 0px" icon="el-icon-top"></el-button>
        </el-input>
      </div>
    </div>
    <div class="commentAreaDiv">
      <div style=";color: #f7f8f9;padding: 10px">全部评论</div>
      <div v-for="item in Comments" :key="item.userId">
        <div class="userCommentArea">
          <el-image :src="item.headImage" style="width: 40px;height: 40px;border-radius: 50%"></el-image>
          <div style="flex: 1;display: inline-block;vertical-align: top">
            <div>
              <b style="color:hsl(0deg 0% 100% / 70%);padding: 10px">{{item.userName}} </b>
              <a style="font-size: 3px;color:hsl(0deg 0% 100% / 50%)">{{item.time}}</a>
            </div>
            <div style="margin-top: 10px;margin-left: 10px">
              <span style="color: white">{{item.content}}</span>
            </div>
            <div style="margin-top: 10px;margin-left: 300px">
              <el-button type="text" class="huifu"  style="color: hsl(0deg 0% 100% / 70%);font-size: 12px" @click="saveReplay(item.id,item.userName)">回复</el-button>
              <el-button v-if="user.userId===item.userId" type="text" style="color: hsl(0deg 0% 100% / 70%);font-size: 12px;margin-left: 10px" @click="delComment(item.id)">删除</el-button>
            </div>
            <div v-if="item.child.length" v-for="subItem in item.child" :key="subItem.id">
              <div class="replayCommentArea">
                <el-image :src="subItem.headImage" style="width: 30px;height: 30px;border-radius: 50%"></el-image>
                <div style="flex: 1;display: inline-block;vertical-align: top">
                  <div>
                    <b style="color:hsl(0deg 0% 100% / 70%);padding: 10px">{{subItem.userName}} </b>
                    <a style="font-size: 3px;color:hsl(0deg 0% 100% / 50%)">{{subItem.time}}</a>
                  </div>
                  <div style="margin-top: 10px;margin-left: 10px">
                    <span style="color: white">{{subItem.content}}</span>
                  </div>
                  <div style="margin-top: 10px;margin-left: 225px">
                    <el-button type="text" class="huifu"  style="color: hsl(0deg 0% 100% / 70%);font-size: 12px" @click="saveReplay(item.id,subItem.userName)">回复</el-button>
                    <el-button v-if="user.userId===subItem.userId" type="text" style="color: hsl(0deg 0% 100% / 70%);font-size: 12px;margin-left: 10px" @click="delComment(subItem.id)">删除</el-button>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="fenGeXian"></div>
        </div>
      </div>
<!--      <div id="commentDiv" class="commentDiv">-->
<!--        <el-input  v-model="CommentForm.content" placeholder="评论一下吧" class="commentInput">-->
<!--          <el-button @click="saveComment" slot="append" style="height: 40px;background: #161722;color: aliceblue;border-radius: 0px" icon="el-icon-top"></el-button>-->
<!--        </el-input>-->
<!--      </div>-->
      <div>&nbsp;</div>
      <div>&nbsp;</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Video",
  data(){
    return {
      input: '',
      content:'',
      Comments:[],
      videoInfo:{},
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
      pid:'',
      toName:'',
      videoId:this.$route.query.videoId,
      isUp:0,
    }
  },
  created() {
    this.load()
    this.loadComments()
    this.isThumbsUp()
  },

  methods:{
    load() {
      this.request.get("http://localhost:9090/video/"+this.videoId).then(res=>{
        this.videoInfo = res.data;
      })
    },
    loadComments(){
      this.request.post("http://localhost:9090/comment",JSON.stringify({
        "videoId": this.videoId
      })).then(res =>{
        this.Comments = res;
      })
    },
    saveComment(){
      let content = this.content;
      if (content.replace(/^\s+|\s+$/g, "").length ===0) {
        alert('评论不能为空');
        return;
      }
      let strings = this.content.split("：");
      //判断是否是回复
      if (strings[0] === '@'+this.toName){
        //是回复就加入pid
        this.request.post("http://localhost:9090/comment/saveComment",JSON.stringify({
          "videoId":this.videoInfo.videoId,
          "userId":this.user.userId,
          "content":this.content,
          "pid":this.pid,
          "originId":this.pid
        })).then(res =>{
          if (res.code === 200){
            this.content='';
            this.$notify({
              title: '成功',
              message: '回复成功！',
              type: 'success',
              duration: 2000
            });
            this.loadComments();
          }
        })
      }else {
        //不是回复就不加入pid
        this.request.post("http://localhost:9090/comment/saveComment",JSON.stringify({
          "videoId":this.videoInfo.videoId,
          "userId":this.user.userId,
          "content":this.content,
        })).then(res =>{
          if (res.code === 200){
            this.content='';
            this.$notify({
              title: '成功',
              message: '评论成功！',
              type: 'success',
              duration: 2000
            });
            this.loadComments();
          }
        })
      }
      //把评论输入框和pid清空
      this.content = ''
      this.toName = ''
      this.pid = ''
    },
    saveReplay(pid,toName){
      this.content = '@'+toName+'：'
      this.toName = toName
      this.pid = pid
    },
    delComment(id){
      this.request.post("http://localhost:9090/comment/delComment",JSON.stringify({
        "id":id
      })).then(res =>{
        if (res.code === 200){
          this.$notify({
            title: '成功',
            message: '删除成功！',
            type: 'success',
            duration: 2000
          });
          this.loadComments();
        }
      })
    },
    thumbsUp(videoId){
      if (this.isUp === 0) {
        //没有点赞过
        this.request.post("http://localhost:9090/video/upVideo", JSON.stringify({
          "videoId": videoId,
          "userId": this.user.userId
        })).then(res => {
          if (res.code === 200) {
            var div = document.getElementById('star');
            div.style.color = "#F05654";
            this.isUp = 1;
            this.load();
          }
        })
      }else if (this.isUp === 1){
        //点赞过，再次点击就是取消点赞
        this.request.post("http://localhost:9090/video/delUpVideo", JSON.stringify({
          "videoId": videoId,
          "userId": this.user.userId
        })).then(res => {
          if (res.code === 200) {
            var div = document.getElementById('star');
            div.style.color = "#000000";
            this.isUp = 0;
            this.load();
          }
        })
      }
    },
    isThumbsUp(){
      //判断是否已经点赞过了
      this.request.post("http://localhost:9090/video/isUp",JSON.stringify({
        "videoId":this.videoId,
        "userId":this.user.userId
      })).then(res =>{
        if (res.code === 502){
          //如果点赞过就把点赞初始为红色
          this.isUp = 1;
          var div = document.getElementById('star');
          div.style.color = "#F05654";
        }
      })
    }
  }
}
</script>

<style scoped>
.videoData{
  color: #2E2F3B;
}
.videoIntroduce{
  align-items: center;
  display: flex;
  margin-bottom: 8px;
  margin-left: 40px;
}
.uploadTime{
  color:hsl(0deg 0% 100% / 50%);
  font-size: 12px;
  flex: 1 0;
  text-align: right;
}
.videoDiv{
  width: 1000px;
  height: 100px;
  display: inline-block;
}
.videos{
  width: 100%;
}
.huDongDiv{
  align-items: center;
  display: flex;
}
.thumbsUpDiv{
  display: inline-block;
  font-size: 20px;
  margin-left: 40px;
}
.starDiv{
  font-size: 20px;
  margin-left: 200px;
}

.replayCommentArea{
  margin-left: 40px;
}
.commentAreaDiv{
  background: #2E2F3B;
  display: inline-block;
  vertical-align: top;
  width: 450px;
  height: 690px;
  min-height: 690px;
  padding: 10px 10px 10px 10px;
  position: relative;
  overflow: auto;
}
.userCommentArea{
  margin-top: 12px;
  max-height: 600px;
}
.commentDiv{
  position: fixed;
  bottom: 20px;
  margin-top: 10px;
  margin-left: 400px;
}
.fenGeXian{
  display: block;
  position: relative;
  background: hsl(0deg 0% 100% / 3%);
  height: 2px;
  min-height: 1px;
  width: 80%;
  margin-top: 5px;
  margin-left: 40px;
}

.commentInput{

}
>>>.el-input__inner{
  background: #000000;
  height: 50px;
  width: 500px;
  border: #060716;
}
>>>.el-input-group__append{
  background: #161722;
}

</style>
