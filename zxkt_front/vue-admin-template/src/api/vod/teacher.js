import request from '@/utils/request'

const api_name = '/admin/vod/teacher'
export default {
    //讲师查询分页
    pageList(current, limit, searchObj) {
        return request({
            url: `${api_name}/findQueryPage/${current}/${limit}`,
            method: `post`,
            //使用json对象传递
            data: searchObj
        })
    },
    //讲师删除
    removeById(id) {
        return request({
            url: `${api_name}/remove/${id}`,
            method: `delete`,
        })
    },
    //添加讲师
    addTeacher(teacher) {
        return request({
            url: `${api_name}/saveTeacher`,
            method: `post`,
            //使用json对象传递
            data: teacher
        })
    }

}