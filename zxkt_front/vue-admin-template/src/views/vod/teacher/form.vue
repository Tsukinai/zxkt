<template>
    <div class="app-container">
        <!-- 输入表单 -->
        <el-form label-width="120px">
            <el-form-item label="讲师名称">
                <el-input v-model="teacher.name" />
            </el-form-item>
            <el-form-item label="入驻时间">
                <el-date-picker v-model="teacher.joinDate" value-format="yyyy-MM-dd" />
            </el-form-item>
            <el-form-item label="讲师排序">
                <el-input-number v-model="teacher.sort" :min="0" />
            </el-form-item>
            <el-form-item label="讲师头衔">
                <el-select v-model="teacher.level">
                    <!--
            数据类型一定要和取出的json中的一致，否则没法回填
            因此，这里value使用动态绑定的值，保证其数据类型是number
            -->
                    <el-option :value="1" label="高级讲师" />
                    <el-option :value="0" label="首席讲师" />
                </el-select>
            </el-form-item>
            <el-form-item label="讲师简介">
                <el-input v-model="teacher.intro" />
            </el-form-item>
            <el-form-item label="讲师资历">
                <el-input v-model="teacher.career" :rows="10" type="textarea" />
            </el-form-item>

            <!-- 讲师头像 -->
            <el-form-item label="讲师头像">
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="saveOrUpdate()">保存</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
import teacherApi from '@/api/vod/teacher'
export default {
    data() {
        return {
            teacher: {
                sort: 1,
                level: 0
            }
        }
    },
    created() {
        //获取路径中的id值
        if (this.$route.params.id) {
            const id = this.$route.params.id
            this.fetchDataById(id)
        }
    },
    methods: {
        //根据id查询讲师
        fetchDataById(id) {
            teacherApi.getById(id)
                .then(response => {
                    this.teacher = response.data
            })
        },
        //添加
        save() {
            teacherApi.addTeacher(this.teacher)
                .then(response => {
                    this.$message.success(response.message)
                });
            //重定向到教师列表
            this.$router.push({ path: '/vod/teacher/list' })
        },
        //修改
        update() {
            teacherApi.updateTeacher(this.teacher)
                .then(response => {
                    this.$message.success(response.message)
                });
            //重定向到教师列表
            this.$router.push({ path: '/vod/teacher/list' })
        },

        saveOrUpdate() {
            if (this.teacher.id) {//有id
                this.update()
            } else {//无id
                this.save()
            }
        }
    }
}
</script>