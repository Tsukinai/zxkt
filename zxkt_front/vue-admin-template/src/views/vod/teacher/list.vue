<template>
    <div class="app-container">
        讲师列表
        <!-- 表格 -->
        <el-table :data="list" border stripe @selection-change="handleSelectionChange">
            <el-table-column type="selection" />
            <el-table-column label="#" width="50">
                <template slot-scope="scope">
                    {{ (page - 1) * limit + scope.$index + 1 }}
                </template>
            </el-table-column>
            <el-table-column prop="name" label="名称" width="80" />
            <el-table-column label="头衔" width="90">
                <template slot-scope="scope">
                    <el-tag v-if="scope.row.level === 1" type="success" size="mini">高级讲师</el-tag>
                    <el-tag v-if="scope.row.level === 0" size="mini">首席讲师</el-tag>
                </template>
            </el-table-column>
            <el-table-column prop="intro" label="简介" />
            <el-table-column prop="sort" label="排序" width="60" />
            <el-table-column prop="joinDate" label="入驻时间" width="160" />
            <el-table-column label="操作" width="200" align="center">
                <template slot-scope="scope">
                    <el-button type="text" size="mini" @click="removeById(scope.row.id)">删除</el-button>
                    <router-link :to="'/vod/teacher/edit/' + scope.row.id">
                        <el-button type="text" size="mini">修改</el-button>
                    </router-link>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
//引入定义接口js文件
import teacherApi from '@/api/vod/teacher.js'
export default {
    data() {
        return {
            list: [], // 讲师列表
            total: 0, // 总记录数
            page: 1, // 当前页码
            limit: 10, // 每页记录数
            searchObj: {} // 查询条件
        }
    },
    created() {
        this.fetchData()
    },
    methods: {
        fetchData() {
            //ajax
            teacherApi.pageList(this.page, this.limit, this.searchObj)
                .then(response => {
                    this.list = response.data.records
                    this.total = response.data.total
                })
        }
    }
}
</script>