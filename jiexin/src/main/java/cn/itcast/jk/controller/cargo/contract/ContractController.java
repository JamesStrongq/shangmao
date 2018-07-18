package cn.itcast.jk.controller.cargo.contract;

import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.domain.ContractC;
import cn.itcast.jk.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@Controller
public class ContractController extends BaseController {

    @Autowired
    private ContractService contractService;

    @RequestMapping("/cargo/contract/list")
    public String list(ContractC contract,Model model){

        List<ContractC> result = contractService.findContract(contract);
        for (ContractC c : result){
            BigInteger[] str = contractService.getNum(c.getContractId());
            System.out.println("查询到的数量为" + str[0] + "," + str[1]);
            c.setCpnum(str[0]);
            c.setEpnum(str[1]);
        }
//        BigInteger[] str = contractService.getNum("4028817a3357462e0133591b86ec0002");
//        System.out.println("查询到的数量为:" + str[0] + "," + str[1]);
//        model.addAttribute("cpnum",str[0]);
//        model.addAttribute("epnum",str[1]);
        model.addAttribute("dataList",result);
        return "cargo/contract/jContractList";
    }

    //转向新增页面
    @RequestMapping("/cargo/contract/tocreate")
    public String tocreate(){
        return "cargo/contract/jContractCreate";
    }

    //新增保存
    @RequestMapping("/cargo/contract/insert")
    public String insert(ContractC contractC){
        contractC.setContractId(UUID.randomUUID().toString());
        contractC.setState(0);  //新增状态默认为0草稿
        contractService.insertContract(contractC);
        return "redirect:/cargo/contract/list";
    }

    //转向修改页面
    @RequestMapping("/cargo/contract/toupdate")
    public String toupdate(String contractId,Model model){
        ContractC contractC = contractService.getContract(contractId);
        model.addAttribute("obj",contractC);
        return "cargo/contract/jContractUpdate";
    }

    //修改保存
    @RequestMapping("/cargo/contract/update")
    public String update(ContractC contractC){
        contractService.updateContract(contractC);
        return "redirect:/cargo/contract/list";
    }

    @RequestMapping("/cargo/contract/deletebatch")
    public String deletebath(String[] contractId){
        contractService.deleteBatch(contractId);
        return "redirect:/cargo/contract/list";
    }

    @RequestMapping("/cargo/contract/toview")
    public String toview(String contractId,Model model){
        ContractC contractC = contractService.getContract(contractId);
        model.addAttribute("obj",contractC);
        return "cargo/contract/jContractView";

    }

    @RequestMapping("/cargo/contract/submit")
    public String submit(String[] id){
        changeState(1,id);
        return "redirect:/cargo/constract/list";
    }

    @RequestMapping("/cargo/contract/cancel")
    public String cancel(String[] id){
        changeState(0,id);
        return "redirect:/cargo/constract/list";
    }

    //归档
    @RequestMapping("/cargo/contract/pigeonhole")
    public String pigeonhole(String id){
        String[] contractIds = id.split(",");
        contractService.pigeonhole(contractIds);
        return "redirect:/cargo/contract/list";
    }

    //修改状态 0草稿 1上报
    public void changeState(Integer stateValue,String[] ids){
        contractService.updateState(stateValue,ids);


    }


}
