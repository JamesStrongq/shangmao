package cn.itcast.jk.controller.cargo.contract;

import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.domain.ContractProductC;
import cn.itcast.jk.domain.ExtCproductC;
import cn.itcast.jk.domain.FactoryC;
import cn.itcast.jk.service.ContractProductService;
import cn.itcast.jk.service.ExtCproductService;
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
public class ExtCproductController extends BaseController {

    @Autowired
    private ExtCproductService extCproductService;

    @Autowired
    private FactoryService factoryService;


    @RequestMapping("/cargo/extcproduct/tocreate")
    public String tocreate(ExtCproductC extCproductC,Model model){
        System.out.println("附件的对象为:" + extCproductC);
        FactoryC factoryC = new FactoryC();
        factoryC.setState(1);
        List<FactoryC> factoryList = factoryService.findFactory(factoryC);
        List<ExtCproductC> list = extCproductService.findExtCproductById(extCproductC.getContractProductId());

        model.addAttribute("contractProductId",extCproductC.getContractProductId());
        model.addAttribute("factoryList",factoryList);
        model.addAttribute("dataList",list);
        return "cargo/extcproduct/jExtCproductCreate";
    }

    @RequestMapping("/cargo/extcproduct/insert")
    public String insert(ExtCproductC extCproductC){
        extCproductC.setExtCproductId(UUID.randomUUID().toString());
        if(extCproductC.getCnumber() != null && extCproductC.getPrice() != null){
            extCproductC.setAmount(Arith.mul(extCproductC.getCnumber(),extCproductC.getPrice()));
        }
        extCproductService.insertExtCproductC(extCproductC);
        return "redirect:/cargo/extcproduct/tocreate?contractProductId=" + extCproductC.getContractProductId();
    }

    @RequestMapping("/cargo/extcproduct/toupdate")
    public String toupdate(String extCproductId,Model model){
        FactoryC factoryC = new FactoryC();
        factoryC.setState(1);
        List<FactoryC> factoryList = factoryService.findFactory(factoryC);
        ExtCproductC result = extCproductService.getExtCproductC(extCproductId);

        model.addAttribute("factoryList",factoryList);
        model.addAttribute("obj",result);
        return "cargo/extcproduct/jExtCproductUpdate";

    }

    @RequestMapping("/cargo/extcproduct/update")
    public String update(ExtCproductC extCproductC){
        if(extCproductC.getCnumber() != null && extCproductC.getPrice() != null){
            extCproductC.setAmount(Arith.mul(extCproductC.getCnumber(),extCproductC.getPrice()));
        }
        extCproductService.updateExtCproductC(extCproductC);
        return "redirect:/cargo/extcproduct/tocreate?contractProductId=" + extCproductC.getContractProductId();
    }

    @RequestMapping("/cargo/extcproduct/delete")
    public String delete(String extCproductId){
        ExtCproductC extCproductC = new ExtCproductC();
        extCproductC.setExtCproductId(extCproductId);
        extCproductService.deleteExtCproductC(extCproductC);
        return "redirect:/cargo/extcproduct/tocreate?contractProductId=" + extCproductC.getContractProductId();
    }


}
