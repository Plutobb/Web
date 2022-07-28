<template>
  <div id="micro" class="micro--3AMFh">
    <div id="garfish_app_for_data_fkxm0mwz">
      <div __garfishmockhtml__="">
        <div __garfishmockbody__="">
          <div id="root">
            <div class="container--2z-xy">
              <div class="title--16j4K">关注列表</div>
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
                            <thead class="semi-table-thead">
                            <tr class="semi-table-row">
                              <th class="semi-table-row-head" colspan="1" rowspan="1">头像/用户名称</th>
                              <th class="semi-table-row-head" colspan="1" rowspan="1">签名</th>
                              <th class="semi-table-row-head" colspan="1" rowspan="1">操作</th>
                            </tr>
                            </thead>
                            <tbody class="semi-table-tbody">
                            <tr v-for="item in follows" class="semi-table-row">
                              <td class="semi-table-row-cell">
                                <img class="semi-avatar semi-avatar-circle semi-avatar-medium semi-avatar-grey" :src="item.headImage"  style="background-size: cover;">
                                <span style="margin-left: 8px; vertical-align: top; color: rgb(28, 31, 35); line-height: 40px;">{{item.userName}}</span>
                              </td>
                              <td class="semi-table-row-cell">
                                <span style="width: 406px; white-space: normal;">{{ item.userIntroduce }}</span>
                              </td>
                              <td class="semi-table-row-cell"><a
                                style="color: rgb(22, 24, 35); font-weight: 600; cursor: pointer;">取消关注</a></td>
                            </tr>
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
  name: "UserFollowManage",
  data(){
    return {
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
      follows:[],
    }
  },
  created() {
    this.getFollows()
  },
  methods:{
    getFollows(){
      this.request.post("http://localhost:9090/getFollows",JSON.stringify({
        "userId":this.user.userId
      })).then(res=>{
        if (res.code === 200){
          this.follows = res.data;
        }
      })
    },
  }
}
</script>

<style scoped>
.micro--3AMFh {
  width: calc(100%);
  display: inline-block;
  min-height: 400px;
}

.micro--3AMFh > div {
  width: 100%;
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
