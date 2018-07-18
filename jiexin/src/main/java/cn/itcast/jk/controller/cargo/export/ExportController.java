package cn.itcast.jk.controller.cargo.export;

import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.domain.ContractC;
import cn.itcast.jk.domain.ContractProductC;
import cn.itcast.jk.domain.ExportC;
import cn.itcast.jk.service.ContractProductService;
import cn.itcast.jk.service.ContractService;
import cn.itcast.jk.service.ExportCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class ExportController extends BaseController {

        @Autowired
        private ExportCService exportCService;

        @Autowired
        private ContractService contractService;

        @Autowired
        private ContractProductService contractProductService;

        @RequestMapping("/cargo/export/list")
        public String list(ExportC exportC,Model model){
            List<ExportC> list = exportCService.findExportC(exportC);
            model.addAttribute("dataList",list);
            return "cargo/export/jExportList";

        }

        //购销合同查询
        @RequestMapping("/cargo/export/contractList")
        public String contractList(ContractC contract,Model model){
            contract.setState(1);   //已上报的
            List<ContractC> list = contractService.findContract(contract);
            model.addAttribute("dataList",list);
            return "cargo/export/jContractList";

        }

        //新增保存
        //springmvc中从页面传过来是数组，然后用逗号分隔转换成字符串
        @RequestMapping("/cargo/export/insert")
        public String insert(String contractId){
            ExportC export = new ExportC();
            export.setContractIds(contractId);
            export.setExportId(UUID.randomUUID().toString());
            String[] contractIds = contractId.split(",");
            String _contractNo = "";
            for(int i = 0;i < contractIds.length;i++){
                ContractC contractC = contractService.getContract(contractIds[i]);
                _contractNo += contractC.getContractNo() + " ";
            }
            export.setCustomerContract(_contractNo);
            export.setState(0);         //0代表的为草稿
            exportCService.insertExportC(export);

            //将合同中的货物信息进行搬家
            String _tmpstr = "";
            _tmpstr = "'" + contractId.replaceAll(",","','") + "'";
            List<ContractProductC> resultList = contractProductService.findForExport(_tmpstr);
            return "redirect:/cargo/export/list";

        }

        @RequestMapping("/cargo/export/toupdate")
        public String toupdate(String exportId,Model model){
            ExportC exportC = exportCService.getExportC(exportId);
            model.addAttribute("obj",exportC);
            return "cargo/export/jExportUpdate";

        }

        @RequestMapping("/cargo/export/update")
        public String update(ExportC exportC){
            exportCService.updateExportC(exportC);
            return "redirect:/cargo/export/list";
        }

}
