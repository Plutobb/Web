<template>
  <div>
    <el-input class="searchInput"  v-model="input" placeholder="请输入内容">
      <el-button @click="searchVideo"  slot="append" icon="el-icon-search"></el-button>
    </el-input>
    <el-button v-if="!isLogin"   @click="dialogVisible = true" style="float: right;margin-top: 12px;background: #161722;color: white" >登录</el-button>
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
          <el-button type="primary" @click="login" style="background: #2E2F3B">登 录</el-button>
          <el-button type="primary" @click="dialogFormVisible = true" style="background: #2E2F3B">注 册</el-button>
        </span>
      </div>
    </el-dialog>

    <el-dialog title="注册" :visible.sync="dialogFormVisible" center width="30%">
      <el-form :model="form">
        <el-form-item label="用户名" :label-width="formLabelWidth">
          <el-input v-model="form.userName" style="width: 250px" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="手机号" :label-width="formLabelWidth">
          <el-input v-model="form.userNum" style="width: 250px" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" :label-width="formLabelWidth">
          <el-input v-model="form.password" style="width: 250px" autocomplete="off" show-password></el-input>
        </el-form-item>
        <el-form-item label="年龄" :label-width="formLabelWidth">
          <el-input v-model="form.userAge" style="width: 250px" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="简介" :label-width="formLabelWidth">
          <el-input type="textarea" v-model="form.userIntroduce" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
      </div>
    </el-dialog>
  </div>


</template>

<script>
export default {
  name: "Header",
  data() {
    return {
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
      dialogVisible: false,
      dialogFormVisible:false,
      visible: false,
      isLogin: localStorage.getItem("user"),
      input:'',
      form:{},
      formLabelWidth: '80px'
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
    register(){

    },
    searchVideo(){
      if (this.input !== '') {
        const {href} = this.$router.resolve({path: '/search', query: {searchInput: this.input}})
        window.open(href, '_blank')
      }
    }
    ,
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
>>>.el-input__inner{
  /*background: #161722;*/
}
.headUserInfo{
  display: inline-block;
  float: right;
  margin-top: 12px;
  margin-right: 20px;
  background: #161722;
}

</style>
