<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible"
    width="470px">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="学号" prop="studentNo">
      <el-input v-model="dataForm.studentNo" placeholder="学号"></el-input>
    </el-form-item>
    <el-form-item label="姓名" prop="studentName">
      <el-input v-model="dataForm.studentName" placeholder="姓名"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input v-model="dataForm.password" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item label="班级" prop="className">
      <el-input v-model="dataForm.className" placeholder="班级"></el-input>
    </el-form-item>
    <el-form-item label="年级" prop="specialtyName">
      <el-input v-model="dataForm.specialtyName" placeholder="年级"></el-input>
    </el-form-item>
    <el-form-item label="电话" prop="phone">
      <el-input v-model="dataForm.phone" placeholder="电话"></el-input>
    </el-form-item>
    <el-form-item label="qq" prop="qq">
      <el-input v-model="dataForm.qq" placeholder="qq"></el-input>
    </el-form-item>
    <el-form-item label="邮箱" prop="email">
      <el-input v-model="dataForm.email" placeholder="邮箱"></el-input>
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
          studentNo: 0,
          studentName: '',
          password: '',
          className: '',
		  specialtyName: '',
          phone: '',
          qq: '',
          email: '',
          isNew: ''
        },
        dataRule: {
          studentNo: [
            { required: true, message: '学号不能为空', trigger: 'blur' }
          ],
          studentName: [
            { required: true, message: '姓名不能为空', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '密码不能为空', trigger: 'blur' }
          ],
          className: [
            { required: true, message: '班级不能为空', trigger: 'blur' }
          ],
          specialtyName: [
            { required: true, message: '年级不能为空', trigger: 'blur' }
          ],
          phone: [
            { required: true, message: '电话不能为空', trigger: 'blur' }
          ],
          qq: [
            { required: true, message: 'qq不能为空', trigger: 'blur' }
          ],
          email: [
            { required: true, message: '邮箱不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        // console.log(this.dataForm.id)
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/lost_and_found/student/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.studentNo = data.student.studentNo
                this.dataForm.studentName = data.student.studentName
                this.dataForm.password = data.student.password
                this.dataForm.className = data.student.className
                this.dataForm.specialtyName = data.student.specialtyName
                this.dataForm.phone = data.student.phone
                this.dataForm.qq = data.student.qq
                this.dataForm.email = data.student.email
                this.dataForm.isNew = data.student.isNew
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
              url: this.$http.adornUrl(`/lost_and_found/student/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'studentNo': this.dataForm.studentNo,
                'studentName': this.dataForm.studentName,
                'password': this.dataForm.password,
                'className': this.dataForm.className,
                'specialtyName': this.dataForm.specialtyName,
                'phone': this.dataForm.phone,
                'qq': this.dataForm.qq,
                'email': this.dataForm.email,
                'isNew': this.dataForm.isNew
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
