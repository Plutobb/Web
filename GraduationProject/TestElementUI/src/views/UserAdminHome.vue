<template>
  <el-container>
    <el-header>
      <UserAdminHeader></UserAdminHeader>
    </el-header>
    <el-container>

      <el-main style="height: 800px">
        <router-view/>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import UserAdminAside from "../components/UserAdminAside";
import UserAdminHeader from "../components/UserAdminHeader";
export default {
  name: "UserAdminHome",
  components: {UserAdminHeader, UserAdminAside}
}
</script>

<style scoped>

</style>
