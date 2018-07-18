package cn.itcast.jk.controller.cargo.contract;

import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.domain.ContractProductC;
import cn.itcast.jk.domain.FactoryC;
import cn.itcast.jk.service.ContractProductService;
import cn.itcast.jk.service.FactoryService;
import cn.itcast.util.Arith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Controller
public class ContractProductController extends BaseController {

    @Autowired
    private ContractProductService contractProductService;

    @Autowired
    private FactoryService factoryService;

    @RequestMapping("/cargo/contractproduct/tocreate")
    public String tocreate(ContractProductC contractProductC, Model model, HttpServletRequest request){
        String contractId = request.getParameter("contractId");
        List<ContractProductC> list;
        if(contractId != null){
             list = contractProductService.findContractProductById(contractId);
            model.addAttribute("contractId",contractId);
        }else {
            list = contractProductService.findContractProductById(contractProductC.getContractId());
            model.addAttribute("contractId",contractProductC.getContractId());
        }
        //准备下拉框
        FactoryC factoryC = new FactoryC();
        factoryC.setState(1);
        List<FactoryC> factoryList = factoryService.findFactory(factoryC);

        model.addAttribute("factoryList",factoryList);

        model.addAttribute("dataList",list);
        return "cargo/contractproduct/jContractProductCreate";

    }

    @RequestMapping("/cargo/contractproduct/insert")
    public String insert(ContractProductC contractProductC, RedirectAttributes attr){
        System.out.println(contractProductC);
        contractProductC.setContractProductId(UUID.randomUUID().toString());
        contractProductC.setAmount(Arith.mul(contractProductC.getCnumber(),contractProductC.getPrice()));
        contractProductService.insertContractProductC(contractProductC);
        attr.addAttribute("contractId",contractProductC.getContractId());
        return "redirect:/cargo/contractproduct/tocreate";      //可以进行批量新增
    }

    @RequestMapping("/cargo/contractproduct/toupdate")
    public String toupdate(String contractProductId,Model model){
        ContractProductC contractProductC = contractProductService.getContractProductC(contractProductId);

        FactoryC factoryC = new FactoryC();
        factoryC.setState(1);
        List<FactoryC> factoryList = factoryService.findFactory(factoryC);

        model.addAttribute("factoryList",factoryList);
        model.addAttribute("obj",contractProductC);
        return "/cargo/contractproduct/jContractProductUpdate";
    }

    @RequestMapping("/cargo/contractproduct/update")
    public String update(ContractProductC contractProductC,RedirectAttributes attr){

        if(contractProductC.getCnumber() != null && contractProductC.getPrice() != null){
            contractProductC.setAmount(Arith.mul(contractProductC.getCnumber(),contractProductC.getPrice()));
        }
        contractProductService.updateContractProductC(contractProductC);
        attr.addAttribute("contractId",contractProductC.getContractId());
        return "redirect:/cargo/contractproduct/tocreate";

    }

    @RequestMapping("/cargo/contractproduct/delete")
    public String delete(String contractProductId,String contractId,RedirectAttributes attr){
        ContractProductC contractProductC = new ContractProductC();
        contractProductC.setContractProductId(contractProductId);
        contractProductService.deleteContractProductC(contractProductC);
        attr.addAttribute("contractId",contractId);
        return "redirect:/cargo/contractproduct/tocreate";
    }


}
