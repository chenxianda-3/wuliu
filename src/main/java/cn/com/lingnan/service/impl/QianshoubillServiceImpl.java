package cn.com.lingnan.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.lingnan.mapper.QianshoubillMapper;
import cn.com.lingnan.mapper.WorkorderMapper;
import cn.com.lingnan.pojo.Qianshoubill;
import cn.com.lingnan.pojo.QianshoubillExample;
import cn.com.lingnan.pojo.QianshoubillExample.Criteria;
import cn.com.lingnan.pojo.QianshoubillKey;
import cn.com.lingnan.pojo.User;
import cn.com.lingnan.pojo.Workorder;
import cn.com.lingnan.service.QianshoubillService;
import cn.com.lingnan.utils.PageBean;

@Service(value="qianshoubillService")
public class QianshoubillServiceImpl  implements QianshoubillService{
	@Autowired
	private  QianshoubillMapper qianshoubillMapper;
	
	@Autowired
	private  WorkorderMapper workorderMapper;

	@Override
	public void pageQuery(PageBean pageBean,Qianshoubill qianshoubill,String station) {
		QianshoubillExample qianshoubillExample = new QianshoubillExample();
		Criteria createCriteria = qianshoubillExample.createCriteria();
		if(qianshoubill.getWorkorderId()!=null && ""!=qianshoubill.getWorkorderId() ){
			createCriteria.andWorkorderIdLike(qianshoubill.getWorkorderId()+"%");
		}
		createCriteria.andDeliveryunitLike("%"+station+"%");

		
		Page page = PageHelper.startPage(pageBean.getPage(), pageBean.getPageSize());
		List<Qianshoubill> qianshoubills = qianshoubillMapper.selectByExample(qianshoubillExample);
		if (!qianshoubills.isEmpty()) {
			pageBean.setRows(qianshoubills);
		}else{
			pageBean.setRows(new ArrayList<Qianshoubill>());
		}
		pageBean.setTotal(page.getTotal());
	}

	@Override
	public void deleteBatch(String ids) {
		QianshoubillExample qianshoubillExample = new QianshoubillExample();
		Criteria createCriteria = qianshoubillExample.createCriteria();
		String[] split = ids.split(",");
		for (int i = 0; i < split.length; i++) {
			createCriteria.andWorkorderIdEqualTo(split[i]);
			qianshoubillMapper.deleteByExample(qianshoubillExample);
		}
		
	}

	@Override
	public Qianshoubill findById(String id,User user) {
		
		return qianshoubillMapper.selectByPrimaryKey(new QianshoubillKey(id, user.getStation()));
	}
	
	
	@Override
	public List<Qianshoubill> findAll() {
		QianshoubillExample qianshoubillExample = new QianshoubillExample();
		return qianshoubillMapper.selectByExample(qianshoubillExample);
	}

	@Override
	public int update(Qianshoubill qianshoubill) {
		return qianshoubillMapper.updateByPrimaryKeySelective(qianshoubill);
		
	}



	@Transactional
	@Override
	public void save(String workorderIds, User user,String type) {
		String[] split = workorderIds.split(",");
		for (int i = 0; i < split.length; i++) {
			String id = split[i];
			Workorder workorder = workorderMapper.selectByPrimaryKey(id);
			Qianshoubill qianshoubill = new Qianshoubill(id, user.getStation(), workorder.getReceivername(), null, null, new Timestamp(System.currentTimeMillis()), type);
			qianshoubillMapper.insertSelective(qianshoubill);
			Workorder workorder2 = new Workorder();
			workorder2.setId(qianshoubill.getWorkorderId());
			if(qianshoubill.getType().equals("0")){
				workorder2.setState(Workorder.QIANSHOU);
			}else {
				workorder2.setState(Workorder.CANCELQIANSHOU);
			}
			workorderMapper.updateByPrimaryKeySelective(workorder2);
		}
		
	}

	@Transactional
	@Override
	public boolean saveQuick(Qianshoubill qianshoubill,User user) {
		Workorder workorder = workorderMapper.selectByPrimaryKey(qianshoubill.getWorkorderId());
		//不存在此工作单则返回
		if (workorder == null) {
			return false;
		}
		Qianshoubill qianshoubill2 = qianshoubillMapper.selectByPrimaryKey(new QianshoubillKey(qianshoubill.getWorkorderId(), user.getStation()));
		if(qianshoubill2==null){
			qianshoubillMapper.insertSelective(qianshoubill);
			//更改工作单的状态
			Workorder workorder2 = new Workorder();
			workorder2.setId(qianshoubill.getWorkorderId());
			if(qianshoubill.getType().equals("0")){
				workorder2.setState(Workorder.QIANSHOU);
			}else {
				workorder2.setState(Workorder.CANCELQIANSHOU);
			}
			workorderMapper.updateByPrimaryKeySelective(workorder2);
		}else{
			update(qianshoubill);
		}
		
		return true;
	}
	


}
