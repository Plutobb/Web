<template>
  <div >
    <div style="padding: 60px;background: white">
      <el-form :label-position="left" label-width="80px" ref="uploadFormRef" :model="uploadForm" :rules="rules">
        <el-form-item label="视频标题" prop="title">
          <el-input style="width: 250px" v-model="uploadForm.title"></el-input>
        </el-form-item>
        <el-form-item label="视频分类" prop="type">
          <el-select v-model="uploadForm.type" clearable placeholder="请选择分类">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="视频标签" prop="title">
          <el-input style="width: 250px" v-model="uploadForm.tag" placeholder="请输入标签使用，隔开"></el-input>
        </el-form-item>
        <el-form-item label="视频简介" prop="introduce">
          <el-input type="textarea"
                    :rows="4"
                    placeholder="请输入视频简介"
                    style="width: 360px"
                    v-model="uploadForm.introduce"></el-input>
        </el-form-item>
        <el-form-item label="上传视频">
          <el-upload
            class="upload-demo"
            ref="upload"
            drag
            action=""
            multiple='false'
            :http-request="httpRequest"
            :before-upload="beforeUpload"
            :on-exceed="handleExceed"
            :limit="1">
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
            <div class="el-upload__tip" slot="tip">只能上传mp4、webm文件</div>
          </el-upload>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitImportForm">开始上传</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  name: "VideoUpload",
  data() {
    return {
      user:localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
      uploadForm:{
        title:'',
        introduce:'',
        type:'',
        tag:'',
      },
      videoFile:{},
      rules: {
        title: [
          { required: true, message: '请输入视频标题', trigger: 'blur' },
        ],
        type: [
          { required: true, message: '请输入视频分区', trigger: 'blur' }
        ],
        introduce: [
          {required: true, message: '请输入视频简介', trigger: 'blur' }
        ]
      },
      options: [{
        value: 'music',
        label: '音乐'
      }, {
        value: 'sports',
        label: '体育'
      }, {
        value: 'entertainment',
        label: '娱乐'
      }, {
        value: 'game',
        label: '游戏'
      }],
      value: ''
    }
  },
  methods:{
    httpRequest(option){
      this.videoFile = option.file;
    },
    // 上传前处理
    beforeUpload(file) {
      let fileSize = file.size
      const FIVE_M= 200*1024*1024;
      //大于200M，不允许上传
      if(fileSize>FIVE_M){
        this.$message.error("最大上传200M")
        return  false
      }
      //判断文件类型，必须是xlsx格式
      let fileName = file.name
      let reg = /^.+(\.mp4)$/
      if(!reg.test(fileName)){
        this.$message.error("只能上传mp4!")
        return false
      }
      return true
    },
    // 文件数量过多时提醒
    handleExceed() {
      this.$message({ type: 'error', message: '最多支持1个视频上传' })
    },
    //导入Excel病种信息数据
    submitImportForm() {
      // 使用form表单的数据格式
      const params = new FormData()
      // 将输入表单数据添加到params表单中
      params.append('userId',this.user.userId)
      params.append('file', this.videoFile)
      params.append('title', this.uploadForm.title)
      params.append('introduce', this.uploadForm.introduce)
      params.append('type', this.uploadForm.type)
      params.append('tag', this.uploadForm.tag)

      //这里根据自己封装的axios来进行调用后端接口
      this.request.post("http://localhost:9090/video/upload",params).then(res => {
        if (res.code === 200) {
          this.$message({
            message: "上传成功",
            type: "success"
          })
        }else{
          this.$message({
            message: "上传失败",
            type: "error"
          })
        }
        this.$refs.uploadFormRef.resetFields()//清除表单信息
        this.$refs.upload.clearFiles()//清空上传列表
        this.file = {}//文件清空
      })
    }
  }
}
</script>

<style scoped>

</style>
