package cn.itcast.jk.controller.cargo.contract;

import cn.itcast.jk.domain.ContractC;
import cn.itcast.jk.domain.ContractProductC;
import cn.itcast.jk.service.ContractProductService;
import cn.itcast.jk.service.ContractService;
import cn.itcast.jk.vo.OutProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class TestController {

        @Autowired
        private ContractProductService contractProductService;

        @Autowired
        private ContractService contractService;

        @RequestMapping("/test/contract")
        @ResponseBody
        public String testContract(){
            ContractProductC contractProductC = contractProductService.getContractProductC("4028817a3357462e0133591b86ec0003");
            System.out.println(contractProductC);
            return "123";

        }

        @RequestMapping("/test/outProduct")
        @ResponseBody
        public String outProduct(){
            List<OutProduct> resultList = contractService.findOutProduct("2011-12%");
            System.out.println("得到的结果集数量为:" + resultList.size());
            return "123";
        }

        @RequestMapping("/test/mapping")
        @ResponseBody
        public String getRealpath(HttpServletRequest request){
            String realPath = request.getSession().getServletContext().getRealPath("/tempfile");
            return realPath;

        }
}
