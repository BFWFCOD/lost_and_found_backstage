<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户名" prop="userName">
      <el-input v-model="dataForm.userName" placeholder="用户名"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input v-model="dataForm.password" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item label="昵称" prop="nickName">
      <el-input v-model="dataForm.nickName" placeholder="昵称"></el-input>
    </el-form-item>
    <el-form-item label="状态" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="原始密码（0） 修改后（1）" prop="isNew">
      <el-input v-model="dataForm.isNew" placeholder="原始密码（0） 修改后（1）"></el-input>
    </el-form-item>
    <el-form-item label="最后一次登录时间" prop="lastloginTime">
      <el-input v-model="dataForm.lastloginTime" placeholder="最后一次登录时间"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          userName: '',
          password: '',
          nickName: '',
          status: '',
          createTime: '',
          isNew: '',
          lastloginTime: ''
        },
        dataRule: {
          userName: [
            { required: true, message: '用户名不能为空', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '密码不能为空', trigger: 'blur' }
          ],
          nickName: [
            { required: true, message: '昵称不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          isNew: [
            { required: true, message: '原始密码（0） 修改后（1）不能为空', trigger: 'blur' }
          ],
          lastloginTime: [
            { required: true, message: '最后一次登录时间不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/lost_and_found/user/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userName = data.user.userName
                this.dataForm.password = data.user.password
                this.dataForm.nickName = data.user.nickName
                this.dataForm.status = data.user.status
                this.dataForm.createTime = data.user.createTime
                this.dataForm.isNew = data.user.isNew
                this.dataForm.lastloginTime = data.user.lastloginTime
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/lost_and_found/user/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userName': this.dataForm.userName,
                'password': this.dataForm.password,
                'nickName': this.dataForm.nickName,
                'status': this.dataForm.status,
                'createTime': this.dataForm.createTime,
                'isNew': this.dataForm.isNew,
                'lastloginTime': this.dataForm.lastloginTime
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
