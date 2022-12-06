import request from '@/utils/request'

const api_name = '/admin/vod/course'

export default {
  // ©нЁлап╠М
  getPageList(page, limit, searchObj) {
    return request({
      url: `${api_name}/${page}/${limit}`,
      method: 'get',
      params: searchObj
    })
  }
}
