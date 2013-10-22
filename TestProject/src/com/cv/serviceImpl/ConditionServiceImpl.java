package com.cv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cv.dao.ConditionDao;
import com.cv.model.Condition;
import com.cv.service.ConditionService;
import com.cv.utils.DozerHelper;
import com.cv.utils.DozerUtil;
import com.cv.vo.ConditionVO;

@Service
public class ConditionServiceImpl implements ConditionService {

	@Autowired
	private ConditionDao conditionDao;

	@Override
	public void addCondition(ConditionVO conditionVO) {
		// TODO Auto-generated method stub
		// dozer convertio
		Condition condition = DozerUtil.xmlConfig().map(conditionVO,
				Condition.class, "condition");

		this.conditionDao.addCondition(condition);

	}

	@Override
	public List<ConditionVO> listCondition() {
		// TODO Auto-generated method stub
		// dozer convertion
		List<ConditionVO> conditionVOs = DozerHelper.map(DozerUtil.xmlConfig(),
				this.conditionDao.listCondition(), ConditionVO.class,
				"condition");
		return conditionVOs;
	}

}
