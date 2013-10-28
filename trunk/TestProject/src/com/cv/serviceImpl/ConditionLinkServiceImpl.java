package com.cv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cv.dao.ConditionLinkDao;
import com.cv.service.ConditionLinkService;
import com.cv.utils.DozerHelper;
import com.cv.utils.DozerUtil;
import com.cv.vo.ConditionLinkVO;

@Service
public class ConditionLinkServiceImpl implements ConditionLinkService {

	@Autowired
	private ConditionLinkDao conditionLinkDao;

	@Override
	public List<ConditionLinkVO> getConditionLinkList(Integer recId) {
		List<ConditionLinkVO> ConditionLinkVOs = DozerHelper.map(
				DozerUtil.xmlConfig(),
				this.conditionLinkDao.getConditionLinkList(recId),
				ConditionLinkVO.class, "conditionLink");

		return ConditionLinkVOs;
	}

}
