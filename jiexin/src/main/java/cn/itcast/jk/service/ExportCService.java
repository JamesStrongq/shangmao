package cn.itcast.jk.service;

import cn.itcast.jk.domain.ExportC;
import cn.itcast.jk.domain.ExtCproductC;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-3-12
 */
public interface ExportCService {
	 List<ExportC> findExportC(ExportC exportC);
	 ExportC getExportC(Serializable id);
	 void insertExportC(ExportC exportC);
	 void updateExportC(ExportC exportC);
	 void deleteExportC(ExportC exportC);


}

