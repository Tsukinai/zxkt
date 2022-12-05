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
    }
}