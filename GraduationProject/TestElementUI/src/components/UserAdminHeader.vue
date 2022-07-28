<template>
  <div style="margin-right: 15%">
    <el-button v-if="!isLogin"   @click="dialogVisible = true" style="float: right;margin-top: 12px" >登录</el-button>
    <div v-if="isLogin" class="headUserInfo">
      <el-popover
        placement="bottom"
        width="200"
        trigger="hover"
        v-model="visible">
        <div style="text-align: center">
          <div style="margin-top: 12px"><span>{{user.userName}}</span></div>
          <div style="margin-top: 12px"><el-button type="text" @click="gotoUserAdmin">个人中心</el-button></div>
          <div style="margin-top: 12px"><el-button type="primary" size="mini" @click="logout">退出登录</el-button></div>
        </div>
        <el-image slot="reference" :src="user.headImage" style="width: 40px;height: 40px;border-radius: 50%"></el-image>
      </el-popover>
    </div>

    <el-dialog
      title="登录"
      :visible.sync="dialogVisible"
      width="20%"
      center>
      <div style="text-align: center">
        <el-input style="width: 200px;" v-model="user.username" placeholder="手机号"></el-input>
        <el-input style="width: 200px" placeholder="请输入密码" v-model="user.password" show-password></el-input>
      </div>
      <div  style="text-align: center">
        <span slot="footer" class="dialog-footer">
          <el-button type="primary" @click="login" style="background: red">登 录</el-button>
        </span>
      </div>
    </el-dialog>
  </div>


</template>

<script>
export default {
  name: "UserAdminHeader",
  data() {
    return {
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
      dialogVisible: false,
      visible: false,
      isLogin: localStorage.getItem("user")
    };
  },

  methods:{
    login(){
      this.request.post("http://localhost:9090/login",this.user).then(res=>{
        if (res.msg === '用户不存在'){
          alert("用户不存在！")
        }else if (res.msg === '密码错误') {
          alert("密码错误！")
        }else {
          localStorage.setItem("user",JSON.stringify(res.data));//存储用户信息到浏览器
          this.isLogin = true;//登录状态置为登录
          this.reloadPage();
        }
      })
    },
    reloadPage() {
      location.reload();
    },
    logout(){
      localStorage.clear();
      this.isLogin = false;
      this.reloadPage();
    },
    gotoUserAdmin(){
      const {href} = this.$router.resolve({path:'/videoManage'})
      window.open(href,'_blank')
    }
  }
}
</script>

<style scoped>

.headUserInfo{
  display: inline-block;
  float: right;
  margin-top: 12px;
  margin-right: 20px;
}

</style>
