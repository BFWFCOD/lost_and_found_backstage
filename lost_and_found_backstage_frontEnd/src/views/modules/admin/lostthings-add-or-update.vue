<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible"
  >
    <el-form
      :model="dataForm"
      :rules="dataRule"
      ref="dataForm"
      @keyup.enter.native="dataFormSubmit()"
      label-width="80px"
    >
      <el-form-item label="物品名称" prop="thingsName">
        <el-input
          v-model="dataForm.thingsName"
          placeholder="物品名称"
        ></el-input>
      </el-form-item>
      <el-form-item label="丢失地点" prop="lostPlace">
        <el-input
          v-model="dataForm.lostPlace"
          placeholder="丢失地点"
        ></el-input>
      </el-form-item>
      <el-form-item label="丢失时间" prop="lostTime">
        <!-- <el-input v-model="dataForm.lostTime" placeholder="丢失时间"></el-input> -->
        <el-date-picker
          v-model="dataForm.lostTime"
          align="right"
          type="date"
          placeholder="选择日期"
          value-format="yyyy-MM-dd hh:mm:ss"
          :picker-options="pickerOptions"
        >
        </el-date-picker>
      </el-form-item>
      <el-form-item label="物品类型" prop="thingsType">
        <el-input
          v-model="dataForm.thingsType"
          placeholder="物品类型"
        ></el-input>
      </el-form-item>
      <el-form-item label="物品图片(可空)" prop="thingsImg">
        <!-- <el-input v-model="dataForm.thingsImg" placeholder="物品图片"></el-input> -->
        <single-upload v-model="dataForm.thingsImg"></single-upload>
      </el-form-item>
      <el-form-item label="物品描述" prop="thingsDes">
        <el-input
          v-model="dataForm.thingsDes"
          placeholder="物品描述"
        ></el-input>
      </el-form-item>
      <el-form-item label="联系电话" prop="phone">
        <el-input v-model="dataForm.phone" placeholder="联系电话"></el-input>
      </el-form-item>
      <el-form-item label="qq" prop="qq">
        <el-input v-model="dataForm.qq" placeholder="qq"></el-input>
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input v-model="dataForm.email" placeholder="邮箱"></el-input>
      </el-form-item>
      <el-form-item label="发布时间" prop="publishTime">
        <el-input
          v-model="dataForm.publishTime"
          placeholder="发布时间"
          :disabled="true"
        ></el-input>
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <!-- <el-input v-model="dataForm.status" placeholder="状态"></el-input> -->
        <el-switch
          v-model="dataForm.status"
          active-text="已认领"
          active-color="#13ce66"
          inactive-text="未认领"
          inactive-color="#ff4949"
          :active-value="0"
          :inactive-value="1"
          disabled
        >
        </el-switch>
      </el-form-item>
      <el-form-item label="联系人" prop="studentName">
        <el-input
          v-model="dataForm.studentName"
          placeholder="联系人"
        ></el-input>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
import SingleUpload from "@/components/upload/singleUpload";
export default {
  components: { SingleUpload },
  data() {
    return {
      visible: false,
      dataForm: {
        id: 0,
        thingsName: "",
        lostPlace: "",
        lostTime: "",
        thingsType: "",
        thingsImg: "",
        thingsDes: "",
        phone: "",
        qq: "",
        email: "",
        publishTime: new Date().format("yyyy-MM-dd hh:mm:ss"),
        status: "",
        studentName: "",
        studentNo: 0,
      },
      dataRule: {
        thingsName: [
          { required: true, message: "物品名称不能为空", trigger: "blur" },
        ],
        lostPlace: [
          { required: true, message: "丢失地点不能为空", trigger: "blur" },
        ],
        lostTime: [
          { required: true, message: "丢失时间不能为空", trigger: "blur" },
        ],
        thingsType: [
          { required: true, message: "物品类型不能为空", trigger: "blur" },
        ],
        thingsDes: [
          { required: true, message: "物品描述不能为空", trigger: "blur" },
        ],
        phone: [
          { required: true, message: "联系电话不能为空", trigger: "blur" },
        ],
        qq: [{ required: true, message: "qq不能为空", trigger: "blur" }],
        email: [{ required: true, message: "邮箱不能为空", trigger: "blur" }],
        publishTime: [
          { required: true, message: "发布时间不能为空", trigger: "blur" },
        ],
        status: [{ required: true, message: "状态不能为空", trigger: "blur" }],
        studentName: [
          { required: true, message: "用户名不能为空", trigger: "blur" },
        ],
      },
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
        shortcuts: [
          {
            text: "今天",
            onClick(picker) {
              picker.$emit("pick", new Date());
            },
          },
          {
            text: "昨天",
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24);
              picker.$emit("pick", date);
            },
          },
          {
            text: "一周前",
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit("pick", date);
            },
          },
        ],
      },
    };
  },
  methods: {
    init(id) {
      this.dataForm.id = id || 0;
      this.visible = true;
      this.$nextTick(() => {
        this.$refs["dataForm"].resetFields();
        if (this.dataForm.id) {
          this.$http({
            url: this.$http.adornUrl(
              `/lost_and_found/lostthings/info/${this.dataForm.id}`
            ),
            method: "get",
            params: this.$http.adornParams(),
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.dataForm.thingsName = data.lostThings.thingsName;
              this.dataForm.lostPlace = data.lostThings.lostPlace;
              this.dataForm.lostTime = data.lostThings.lostTime;
              this.dataForm.thingsType = data.lostThings.thingsType;
              this.dataForm.thingsImg = data.lostThings.thingsImg;
              this.dataForm.thingsDes = data.lostThings.thingsDes;
              this.dataForm.phone = data.lostThings.phone;
              this.dataForm.qq = data.lostThings.qq;
              this.dataForm.email = data.lostThings.email;
              this.dataForm.publishTime = data.lostThings.publishTime;
              this.dataForm.status = data.lostThings.status;
              this.dataForm.studentName = data.lostThings.studentName;
              this.dataForm.studentNo = data.pickThings.studentNo;
            }
          });
        }
      });
    },
    // 表单提交
    dataFormSubmit() {
      this.$refs["dataForm"].validate((valid) => {
        if (valid) {
          this.$http({
            url: this.$http.adornUrl(
              `/lost_and_found/lostthings/${
                !this.dataForm.id ? "save" : "update"
              }`
            ),
            method: "post",
            data: this.$http.adornData({
              id: this.dataForm.id || undefined,
              thingsName: this.dataForm.thingsName,
              lostPlace: this.dataForm.lostPlace,
              lostTime: this.dataForm.lostTime,
              thingsType: this.dataForm.thingsType,
              thingsImg: this.dataForm.thingsImg,
              thingsDes: this.dataForm.thingsDes,
              phone: this.dataForm.phone,
              qq: this.dataForm.qq,
              email: this.dataForm.email,
              publishTime: this.dataForm.publishTime,
              status: this.dataForm.status,
              studentName: this.dataForm.studentName,
              studentNo: this.dataForm.studentNo
            }),
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.visible = false;
                  this.$emit("refreshDataList");
                },
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },
  },
};
</script>
