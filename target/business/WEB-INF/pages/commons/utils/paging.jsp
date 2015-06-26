<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
$(function(){
//------------------------分页 开始--------------------------------
	var count = ${count };	//总数
	var page = ${page };	//当前页码
	var pageCount = 1;	//总页码数
	var maxPerPage = 8;	//每页最多内容条数
	$('#total').html(count);
	$('#nowPage').html(page);
	$('#toFirstPage').attr("href", 1);
	
	//上一页
	if(page == 1){
		$('#toPrePage').attr("href", 1);
	}else{
		$('#toPrePage').attr("href", page - 1);
	}
	
	if(count%maxPerPage == 0){
		pageCount = count/maxPerPage;
	}else{
		pageCount = parseInt(count/maxPerPage + 1);
	}
	$('#totalPage').html(pageCount);
	$('#toEndPage').attr("href", pageCount);
	
	//下一页
	if(page == pageCount){
		$('#toNextPage').attr("href", pageCount);
	}else{
		$('#toNextPage').attr("href", page + 1);
	}
	
	//goToPage
	$('#goToPage').click(function(){
		var toPage = $('#goToPageText').val();
		if(toPage <= pageCount){
			$('#goToPage').attr("href", toPage);
		}else{
			$('#goToPage').attr("href", pageCount);
		}
	});
	//------------------------分页 结束--------------------------------
});
</script>