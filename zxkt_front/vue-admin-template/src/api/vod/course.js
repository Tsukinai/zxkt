import request from '@/utils/request'

const api_name = '/admin/vod/course'

export default {
  // �γ��б�
  getPageList(page, limit, searchObj) {
    return request({
      url: `${api_name}/${page}/${limit}`,
      method: 'get',
      params: searchObj
    })
  }
}
