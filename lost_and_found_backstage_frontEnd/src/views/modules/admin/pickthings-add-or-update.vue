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
      <el-form-item label="寻到地点" prop="pickPlace">
        <el-input
          v-model="dataForm.pickPlace"
          placeholder="寻到地点"
        ></el-input>
      </el-form-item>
      <el-form-item label="寻到时间" prop="pickTime">
        <!-- <el-input v-model="dataForm.pickTime" placeholder="寻到时间"></el-input> -->
        <!-- <span>{{ dataForm.pickTime }}</span> -->
        <el-date-picker
          v-model="dataForm.pickTime"
          align="right"
          type="date"
          placeholder="选择日期"
          value-format="yyyy-MM-dd hh:mm:ss"
          default-time="00:00:00"
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
      <el-form-item label="暂存地点" prop="storagePlace">
        <el-input
          v-model="dataForm.storagePlace"
          placeholder="暂存地点"
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
        >
        </el-input>
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
        pickPlace: "",
        pickTime: "",
        thingsType: "",
        thingsImg: "",
        thingsDes: "",
        storagePlace: "",
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
        pickPlace: [
          { required: true, message: "丢失地点不能为空", trigger: "blur" },
        ],
        pickTime: [
          { required: true, message: "丢失时间不能为空", trigger: "blur" },
        ],
        thingsType: [
          { required: true, message: "物品类型不能为空", trigger: "blur" },
        ],
        thingsDes: [
          { required: true, message: "物品描述不能为空", trigger: "blur" },
        ],
        storagePlace: [
          { required: true, message: "暂存地点不能为空", trigger: "blur" },
        ],
        phone: [
          { required: true, message: "联系电话不能为空", trigger: "blur" },
        ],
        qq: [{ required: true, message: "qq不能为空", trigger: "blur" }],
        email: [{ required: true, message: "邮箱不能为空", trigger: "blur" }],
        studentName: [
          { required: true, message: "联系人不能为空", trigger: "blur" },
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
              `/lost_and_found/pickthings/info/${this.dataForm.id}`
            ),
            method: "get",
            params: this.$http.adornParams(),
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.dataForm.thingsName = data.pickThings.thingsName;
              this.dataForm.pickPlace = data.pickThings.pickPlace;
              this.dataForm.pickTime = data.pickThings.pickTime;
              this.dataForm.thingsType = data.pickThings.thingsType;
              this.dataForm.thingsImg = data.pickThings.thingsImg;
              this.dataForm.thingsDes = data.pickThings.thingsDes;
              this.dataForm.storagePlace = data.pickThings.storagePlace;
              this.dataForm.phone = data.pickThings.phone;
              this.dataForm.qq = data.pickThings.qq;
              this.dataForm.email = data.pickThings.email;
              this.dataForm.publishTime = data.pickThings.publishTime;
              this.dataForm.status = data.pickThings.status;
              this.dataForm.studentName = data.pickThings.studentName;
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
              `/lost_and_found/pickthings/${
                !this.dataForm.id ? "save" : "update"
              }`
            ),
            method: "post",
            data: this.$http.adornData({
              id: this.dataForm.id || undefined,
              thingsName: this.dataForm.thingsName,
              pickPlace: this.dataForm.pickPlace,
              pickTime: this.dataForm.pickTime,
              thingsType: this.dataForm.thingsType,
              thingsImg: this.dataForm.thingsImg,
              thingsDes: this.dataForm.thingsDes,
              storagePlace: this.dataForm.storagePlace,
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
