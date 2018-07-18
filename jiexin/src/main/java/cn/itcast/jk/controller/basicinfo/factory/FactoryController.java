package cn.itcast.jk.controller.basicinfo.factory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import cn.itcast.jk.domain.FactoryC;
import cn.itcast.util.DownloadUtil;
import cn.itcast.util.file.FileUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.service.FactoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-3-12
 */
@Controller
public class FactoryController extends BaseController {
	@Autowired
	FactoryService factoryService;
	
	//列表
	@RequestMapping("/basicinfo/factory/list")
	public String list(FactoryC factory, Model model){
		List<FactoryC> dataList = factoryService.findFactory(factory);
		model.addAttribute("dataList", dataList);			//传递结果集到页面
		
		return "/basicinfo/factory/jFactoryList";			//逻辑名
	}

	@RequestMapping("/basicinfo/factory/tocreate")
	public String tocreate(){
		return "/basicinfo/factory/jFactoryCreate";
	}

	@RequestMapping("/basicinfo/factory/insert")
	public String insert(FactoryC factoryC){
		factoryService.insertFactory(factoryC);
		return "redirect:/basicinfo/factory/list";
	}

	//转向修改页面
	@RequestMapping("/basicinfo/factory/toupdate")
	public String toUpdate(String id,Model model){
		FactoryC factoryC = factoryService.getFactory(id);
		model.addAttribute("obj",factoryC);
		return "/basicinfo/factory/jFactoryUpdate";
	}

	//修改保存
	@RequestMapping("/basicinfo/factory/update")
	public String update(FactoryC factoryC){
		factoryService.updateFactory(factoryC);
		return "redirect:/basicinfo/factory/list";
	}

	@RequestMapping("/basicinfo/factory/delete")
	public String delete(String id){
		FactoryC factoryC = factoryService.getFactory(id);
		factoryService.deleteFactory(factoryC);
		return "redirect:/basicinfo/factory/list";
	}

	@RequestMapping("/basicinfo/factory/toview")
	public String toview(String id,Model model){
		FactoryC factoryC = factoryService.getFactory(id);
		model.addAttribute("obj",factoryC);
		return "/basicinfo/factory/jFactoryView";
	}

	//批量进行启用
	@RequestMapping("/basicinfo/factory/start")
	public String start(String[] factoryId){
		this.changeState(0,factoryId);
		return "redirect:/basicinfo/factory/list";

	}

	@RequestMapping("/basicinfo/factory/stop")
	public String stop(String[] factoryId){
		this.changeState(0,factoryId);
		return "redirect:/basicinfo/factory/list";
	}

	private void changeState(Integer state,String[] factoryId){
		factoryService.changeState(state,factoryId);
	}

	@RequestMapping("/basicinfo/factory/print")
	public void print(HttpServletRequest request, HttpServletResponse response){

		List<FactoryC> list = factoryService.findFactoryByState(1);

		String[] title = new String[]{"厂家名称","缩写","联系人","电话","手机","传真","备注"};

		Workbook workBook = new HSSFWorkbook();
		Sheet sheet = workBook.createSheet();
		sheet.setColumnWidth(0,30 * 256);			//设置列宽


		int rowNo = 0;				//行号
		int colNo = 0;				//列号

		Row nRow = sheet.createRow(rowNo);
		Cell nCell = null;

		sheet.addMergedRegion(new CellRangeAddress(rowNo,rowNo,0,6));		//合并单元格，新对象，不会覆盖合并的那些单元格，只是遮住
		rowNo++;
		nCell = nRow.createCell(colNo);
		nCell.setCellValue("生产厂家通讯录");
		nCell.setCellStyle(this.bigTitleStyle(workBook));


		//写标题
		nRow = sheet.createRow(rowNo++);
		nRow.setHeightInPoints(28);				//设置行高

		for(int i = 0;i < title.length;i++){
			nCell = nRow.createCell(i);
			nCell.setCellValue(title[i]);
			nCell.setCellStyle(this.titleStyle(workBook));
		}

		//写数据
		for(int j = 0;j < list.size();j++){
			colNo = 0;
			FactoryC factoryC = list.get(j);

			nRow = sheet.createRow(rowNo++);
			nRow.setHeightInPoints(21);
			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(factoryC.getFullName());
			nCell.setCellStyle(this.textStyle(workBook));

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(factoryC.getFactoryName());
			nCell.setCellStyle(this.textStyle(workBook));

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(factoryC.getContractor());
			nCell.setCellStyle(this.textStyle(workBook));

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(factoryC.getMobile());
			nCell.setCellStyle(this.textStyle(workBook));

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(factoryC.getPhone());
			nCell.setCellStyle(this.textStyle(workBook));

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(factoryC.getFax());
			nCell.setCellStyle(this.textStyle(workBook));

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(factoryC.getNote());
			nCell.setCellStyle(this.textStyle(workBook));

		}
		/*
		String realPath = request.getSession().getServletContext().getRealPath("/tempfile");		//获取虚拟路径对应的真实物理地址
		File file = new File(realPath);
		if(!file.exists()){
			file.mkdirs();		//创建多级目录
		}

		FileUtil fu = new FileUtil();
		String fileName = realPath + "/" +fu.newFile(realPath,"factory.xls");		//产生新的文件名，防止冲突
		*/
		try {
		//	FileOutputStream fos = new FileOutputStream(fileName);
		//	workBook.write(fos);
		//	fos.flush();
		//	fos.close();


			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			workBook.write(byteArrayOutputStream);

			DownloadUtil du = new DownloadUtil();
			//du.prototypeDownload(file,"",response,true);	//下载临时文件，下载后删除
			du.download(byteArrayOutputStream,response,"生产厂家通讯录.xls");		//弹出下载对话框，就可以直接下载


		}catch (Exception e){
			e.printStackTrace();
		}

	}

	//大样式
	private CellStyle bigTitleStyle(Workbook wb){
		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

		Font curFont = wb.createFont();
		curFont.setFontName("华文隶书");
		curFont.setFontHeightInPoints((short)30);

		cellStyle.setFont(curFont);



		return cellStyle;
	}

	//标题样式
	private CellStyle titleStyle(Workbook wb){
		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

		Font curFont = wb.createFont();
		curFont.setFontName("微软雅黑");
		curFont.setFontHeightInPoints((short)12);

		cellStyle.setFont(curFont);

		//画线
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);		//细实线
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);

		return cellStyle;
	}

	//设置文本样式
	private CellStyle textStyle(Workbook wb){
			CellStyle xStyle = wb.createCellStyle();
			Font xFont = wb.createFont();
			xStyle.setFont(xFont);

			xStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);	//纵向居中

			//画线
			xStyle.setBorderTop(CellStyle.BORDER_THIN);
			xStyle.setBorderBottom(CellStyle.BORDER_THIN);
			xStyle.setBorderRight(CellStyle.BORDER_THIN);
			xStyle.setBorderLeft(CellStyle.BORDER_THIN);

			return xStyle;
	}

	public void test(){
		try {
			//创建工作簿
			Workbook workBook = new HSSFWorkbook();
			//创建工作表sheet
			Sheet sheet = workBook.createSheet();

			//创建单元格的样式
			CellStyle cellStyle = workBook.createCellStyle();
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);				//横向居中
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);	//纵向居中

			Font font = workBook.createFont();							//创建字体对象
			font.setFontName("微软雅黑");								//设置字体
			font.setFontHeightInPoints((short) 48);						//设置字体大小
			cellStyle.setFont(font);									//将字体对象绑定到样式对象上

			//创建行对象
			Row nRow = sheet.createRow(3); 			//起始行为0,第四行
			//创建单元格对象
			Cell nCell = nRow.createCell(1);			//第二列

			nCell.setCellValue("传智播客!");			//设置单元格内容
			nCell.setCellStyle(cellStyle);				//绑定样式
			FileOutputStream fos = new FileOutputStream("d:\\factory.xls");
			workBook.write(fos);						//写入文件流
			fos.flush();								//清空缓存
			fos.close();								//关闭

		}catch (Exception e){
			e.printStackTrace();
		}

	}

}
