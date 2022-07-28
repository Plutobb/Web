<template>
  <div id="micro" class="micro--3AMFh">
    <div id="garfish_app_for_data_fkxm0mwz">
      <div __garfishmockhtml__="">
        <div __garfishmockbody__="">
          <div id="root">
            <div class="container--2z-xy">
              <div class="title--16j4K">修改个人信息</div>
              <div class="table--1niyU semi-table-wrapper">
                <div class="semi-spin semi-spin-large semi-spin-block semi-spin-hidden">
                  <div class="semi-spin-children">
                    <div class="">
                      <div class="semi-table-container">
                        <div class="semi-table-body">
                          <table class="semi-table">
                            <colgroup class="semi-table-colgroup">
                              <col class="semi-table-col" style="width: 232px; min-width: 232px;">
                              <col class="semi-table-col" style="width: 406px; min-width: 406px;">
                              <col class="semi-table-col" style="width: 72px; min-width: 72px;">
                            </colgroup>
                            <tbody class="semi-table-tbody">
                            <div style="padding: 20px">
                              <el-upload
                                class="avatar-uploader"
                                action="http://localhost:9090/userInfo/uploadHeadImage"
                                :show-file-list="false"
                                :on-success="handleAvatarSuccess"
                                :before-upload="beforeAvatarUpload">
                                <img v-if="this.userInfo.headImage" :src="this.userInfo.headImage" class="avatar">
                                <i v-else class="el-icon-plus avatar-uploader-icon">
                                </i>
                              </el-upload>
                              <el-form :label-position="left" label-width="80px" ref="uploadFormRef" :model="uploadForm" :rules="rules">
                                <el-form-item label="用户名" prop="userName">
                                  <el-input style="width: 250px" v-model="userInfo.userName"></el-input>
                                </el-form-item>
                                <el-form-item label="账号" prop="userNum">
                                  <el-input style="width: 250px" v-model="userInfo.userNum"></el-input>
                                </el-form-item>
                                <el-form-item label="密码" prop="userNum">
                                  <el-input style="width: 250px" v-model="userInfo.password" show-password></el-input>
                                </el-form-item>
                                <el-form-item label="个人简介" prop="userIntroduce">
                                  <el-input style="width: 250px" v-model="userInfo.userIntroduce"></el-input>
                                </el-form-item>
                                <el-form-item label="年龄" prop="userAge">
                                  <el-input style="width: 250px" v-model="userInfo.userAge"></el-input>
                                </el-form-item>
                                <el-form-item style="margin-left: 70px">
                                  <el-button type="primary" @click="submitForm">确认修改</el-button>
                                </el-form-item>
                              </el-form>

                            </div>
                            </tbody>
                          </table>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "userInfoUpdate",
  data() {
    return{
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
      userInfo:{},
      headImageFile:'',
    }
  },
  created() {
    this.getUserInfo()
  },
  methods:{
    submitForm(){
      this.request.post("http://localhost:9090/userInfo/update",this.userInfo).then(res => {
        if (res.code === 200){
          this.$notify({
            title: '成功',
            message: '修改成功！',
            type: 'success',
            duration: 2000
          });
          this.getUserInfo()
        }else {
          alert("修改失败！")
        }
      })
    },
    getUserInfo(){
      const formData = new FormData;
      formData.append("userId",this.user.userId)
      this.request.post("http://localhost:9090/userInfo",formData).then(res=>{
        localStorage.setItem("user",JSON.stringify(res.data));
        this.userInfo = res.data;
      })
    },
    handleAvatarSuccess(res) {
      this.userInfo.headImage = res.data;
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg';
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!');
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
      }
      return isJPG && isLt2M;
    }
  }
}
</script>

<style scoped>

.el-upload-list__item-thumbnail{
  width: 178px;
  height: 178px;
  display: block;
}
.avatar-uploader{
  margin-left: 120px;
  display: inline-block;
}

.avatar-uploader-icon {
  margin-left: 110px;
  margin-bottom: 20px;
  border: 1px dashed #d9d9d9;
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 158px;
  height: 158px;
  display: block;
}

.micro--3AMFh {
  width: calc(100%);
  display: inline-block;
  min-height: 400px;
}

.micro--3AMFh > div {
  width: 100%;
}
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}


.semi-table-thead > .semi-table-row > .semi-table-row-head {
  background-color: transparent;
  color: rgb(35 28 31 / 60%);
  font-weight: 700;
  text-align: left;
  border-bottom: 2px solid rgb(35 28 31 / 8%);
  padding: 8px 16px;
  vertical-align: middle;
  word-break: break-all;
  word-wrap: break-word;
  position: relative;
  user-select: none;
}

.table--1niyU .semi-table-row > * {
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
  max-width: 450px;
}

.container--2z-xy {
  padding: 24px;
  background: #fff;
  border-radius: 8px;
  flex-direction: column;
  display: flex;
  margin-bottom: 20px;
  height: calc(100vh - 178px);
}

.container--2z-xy .title--16j4K {
  display: inline-block;
  font-style: normal;
  font-size: 24px;
  line-height: 34px;
  color: rgba(28, 31, 35, 0.9);
  margin-bottom: 16px;
  font-weight: 600;
}

.table--1niyU {
  width: 100%;
  font-size: 14px;
  line-height: 20px;
}

.semi-spin-block.semi-spin {
  height: auto;
  width: auto;
}

.semi-spin-block {
  display: block;
}

.semi-spin {
  position: relative;
}

.semi-spin-hidden > .semi-spin-children {
  opacity: 1;
  user-select: auto;
}

.semi-spin-hidden > .semi-spin-children {
  opacity: 1;
  user-select: auto;
}

.semi-table-container {
  position: relative;
}

.table--1niyU .semi-table-body {
  overflow-y: auto !important;
}

.semi-table-body {
  overflow: auto;
  width: 100%;
  box-sizing: border-box;
}

.semi-table {
  width: 100%;
  text-align: left;
  border-collapse: separate;
  border-spacing: 0;
  font-size: inherit;
  display: table;
}

用户代理样式表
table {
  display: table;
  border-collapse: separate;
  box-sizing: border-box;
  text-indent: initial;
  border-spacing: 2px;
  border-color: grey;
}

.semi-spin-hidden > .semi-spin-children {
  opacity: 1;
  user-select: auto;
}

.table--1niyU {
  line-height: 20px;
}

.semi-table-wrapper {
  font-family: PingFang SC, Arial, Microsoft YaHei, sans-serif;
  color: rgb(35 28 31);
  width: 100%;
}

thead {
  display: table-header-group;
  vertical-align: middle;
  border-color: inherit;
}

.semi-table-tbody {
  display: table-row-group;
}

.semi-table-tbody > .semi-table-row {
  display: table-row;
}

.semi-table-tbody > .semi-table-row > .semi-table-row-cell {
  display: table-cell;
  word-wrap: break-word;
  word-break: break-all;
  border-left: none;
  border-right: none;
  border-bottom: 1px solid rgb(35 28 31 / 8%);
  padding: 16px;
  box-sizing: border-box;
  position: relative;
  vertical-align: middle;
}

.table--1niyU .semi-table-row > * {
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
  max-width: 450px;
}

.semi-avatar-grey {
  background-color: rgba(var(176, 167, 168), 1);
  color: #fff;
}

.semi-avatar-circle {
  border-radius: 50%;
}

.semi-avatar-medium {
  width: 48px;
  height: 48px;
}
</style>
