package cn.edu.hit.zxkt.vo.live;

import cn.edu.hit.zxkt.vo.activity.live.LiveCourseConfig;
import cn.edu.hit.zxkt.vo.activity.live.LiveCourseGoods;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "LiveCourseConfig")
public class LiveCourseConfigVo extends LiveCourseConfig {

	@ApiModelProperty(value = "ๅๅๅ่กจ")
	private List<LiveCourseGoods> liveCourseGoodsList;
}