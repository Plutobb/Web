<template>
  <div>
    <el-table
      :data="tableData"
      border
      style="width: 100%">
      <el-table-column fixed prop="videoId" label="视频Id" v-if="false" width="150"></el-table-column>
      <el-table-column fixed prop="videoTitle" label="标题" width="150"></el-table-column>
      <el-table-column prop="videoType" label="分类" width="100"></el-table-column>
      <el-table-column prop="videoIntroduce" label="简介" width="120"></el-table-column>
      <el-table-column prop="videoUpNum" label="点赞" width="100"></el-table-column>
      <el-table-column prop="videoStar" label="收藏" width="100"></el-table-column>
      <el-table-column prop="videoUrl" label="视频url" width="auto"></el-table-column>
      <el-table-column prop="videoUploadTime" label="上传时间" width="150"></el-table-column>
      <el-table-column fixed="right" label="操作" width="150">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" size="small">查看</el-button>
          <el-button @click="deleteVideo(scope.row.videoId)" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>
<style>

</style>

<script>
export default {

  created() {
    this.getVideoInfo();
  },
  data() {
    return {
      user:localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
      tableData:[]
    }
  },
  methods: {
    getVideoInfo(){
      this.request.post("http://localhost:9090/video/getVideoInfo",this.user).then(res=>{
        this.tableData = res.data;
      })
    },
    deleteVideo(id) {
      this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        const formData = new FormData;
        formData.append("videoId",id)
        this.request.post("http://localhost:9090/video/deleteVideo",formData).then(res=>{
          if (res.code === 200){
            this.getVideoInfo();
          }
        })

        this.$message({
          type: 'success',
          message: '删除成功!'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    }
  },
}
</script>

