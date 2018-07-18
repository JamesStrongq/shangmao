<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="view"><a href="#" onclick="formSubmit('toview','_self');this.blur();">查看</a></li>
<li id="new"><a href="#" onclick="formSubmit('tocreate','_self');this.blur();">新建</a></li>
<li id="update"><a href="#" onclick="formSubmit('toupdate','_self');this.blur();">修改</a></li>
<li id="delete"><a href="#" onclick="formSubmit('deletebatch','_self');this.blur();">删除</a></li>
<li id="print"><a href="#" onclick="formSubmit('print','_self');this.blur();">打印</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
    购销合同列表
  </div> 
  </div>
  </div>
  
<div>

<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">厂家</td>
		<td class="tableHeader">货号</td>
		<td class="tableHeader" width="200">货物描述</td>
		<td class="tableHeader">数量</td>
		<td class="tableHeader">包装单位</td>
		<td class="tableHeader">单价</td>
		<td class="tableHeader">总金额</td>
		<td class="tableHeader">操作</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${dataList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="id" value="${o.contractId}"/></td>
		<td>${status.index+1}</td>
		<td>${o.factoryName}</td>
		<td>${o.productNo}</td>
		<td width="200">${o.productDesc}</td>
		<td>${o.cnumber}</td>
		<td>${o.packingUnit}</td>
		<td>${o.totalAmount}</td>

		<td>
			<a href="${ctx}/cargo/contractproduct/tocreate?contractId=${o.contractId}">[货物]</a>
		</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

