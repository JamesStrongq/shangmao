package cn.itcast.jk.controller.cargo.contract;

import cn.itcast.jk.service.ContractService;
import cn.itcast.jk.vo.OutProduct;
import cn.itcast.util.DownloadUtil;
import cn.itcast.util.UtilFuns;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

@Controller
public class OutProductController {

    @Autowired
    private ContractService contractService;

    //转向出货表
    @RequestMapping("/cargo/outproduct/toedit")
    public String toedit(){
        return "cargo/outproduct/jOutProduct";
    }


    //打印
    @RequestMapping("/cargo/outproduct/outProductPrint")
    public void print(String inputDate, HttpServletResponse response) throws Exception{
        /**
         * 打印步骤:
         * 1.获取数据
         * 2.POI写数据到文件
         */
        System.out.println("得到的参数为:" + inputDate);
        List<OutProduct> resultList = contractService.findOutProduct(inputDate + "%");


        Workbook wb = new HSSFWorkbook(new FileInputStream(new File("")));    //打开模版文件

        Sheet sheet = wb.getSheetAt(0);         //打开第一个工作表
        Row nRow = null;
        Cell nCell = null;
        int rowNo = 2;              //行号
        int colNo = 1;              //列号

        //处理标题
        nRow = sheet.getRow(0);     //获取行对象
        nCell = nRow.getCell(1);    //获得单元格对象
        nCell.setCellValue(inputDate.replaceFirst("-0","-").replaceFirst("-","年") + "月份出货表");

        //获取模版文件中的样式
        nRow = sheet.getRow(2);
        nCell = nRow.getCell(1);
        CellStyle customNameStyle = nCell.getCellStyle();  //获取客户名称的样式

        nRow = sheet.getRow(2);
        nCell = nRow.getCell(2);
        CellStyle constractNoStyle = nCell.getCellStyle();

        nRow = sheet.getRow(2);
        nCell = nRow.getCell(3);
        CellStyle productNoStyle = nCell.getCellStyle();

        nRow = sheet.getRow(2);
        nCell = nRow.getCell(4);
        CellStyle cnumberStyle = nCell.getCellStyle();

        nRow = sheet.getRow(2);
        nCell = nRow.getCell(5);
        CellStyle factoryNameStyle = nCell.getCellStyle();

        nRow = sheet.getRow(2);
        nCell = nRow.getCell(6);
        CellStyle extStyle = nCell.getCellStyle();

        nRow = sheet.getRow(2);
        nCell = nRow.getCell(7);
        CellStyle dateStyle = nCell.getCellStyle();

        nRow = sheet.getRow(2);
        nCell = nRow.getCell(9);
        CellStyle tradeTermsStyle = nCell.getCellStyle();



        for(int i = 0;i < resultList.size();i++){
            colNo = 1;      //初始列号

            OutProduct outProduct = resultList.get(0);

            nRow = sheet.createRow(rowNo++);    //创建行
            nRow.setHeightInPoints(24);         //设置行高

            nCell = nRow.createCell(colNo++);   //创建单元格
            nCell.setCellValue(outProduct.getCustomName());
            nCell.setCellStyle(customNameStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(outProduct.getContractNo());
            nCell.setCellStyle(constractNoStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(outProduct.getProductNo());
            nCell.setCellStyle(productNoStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(outProduct.getCnumber());
            nCell.setCellStyle(cnumberStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(outProduct.getFactoryName());
            nCell.setCellStyle(factoryNameStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue("附件");
            nCell.setCellStyle(extStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(UtilFuns.dateTimeFormat(outProduct.getDeliveryPeriod()));
            nCell.setCellStyle(dateStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(UtilFuns.dateTimeFormat(outProduct.getShipTime()));
            nCell.setCellStyle(dateStyle);

            nCell = nRow.createCell(colNo++);
            nCell.setCellValue(outProduct.getTradeTerms());
            nCell.setCellStyle(tradeTermsStyle);


        }

        DownloadUtil util = new DownloadUtil();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        wb.write(byteArrayOutputStream);
        util.download(byteArrayOutputStream,response,"出货表.xls");


    }


}
