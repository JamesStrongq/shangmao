package cn.itcast.jk.service.impl;

import cn.itcast.jk.dao.ExportCDao;
import cn.itcast.jk.dao.ExtCproductDao;
import cn.itcast.jk.domain.ExportC;
import cn.itcast.jk.domain.ExtCproductC;
import cn.itcast.jk.service.ExportCService;
import cn.itcast.jk.service.ExtCproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-3-12
 */
@Service
public class ExportCServiceImpl implements ExportCService {

	@Autowired
	private ExportCDao exportCDao;


	public List<ExportC> findExportC(ExportC exportC) {
		return exportCDao.find(exportC);
	}

	public ExportC getExportC(Serializable id) {
		return exportCDao.get(id);
	}

	public void insertExportC(ExportC exportC) {
		exportCDao.insert(exportC);
	}

	public void updateExportC(ExportC exportC) {
		exportCDao.update(exportC);
	}

	public void deleteExportC(ExportC exportC) {
		exportCDao.delete(exportC);
	}
}
