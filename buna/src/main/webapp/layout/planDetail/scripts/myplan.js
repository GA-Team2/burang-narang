function like(rownum) {
	
	$.ajax({
		url : "likeUpdate.jsp",
		type : "post",
		data : {"rownum" : rownum},
		success : function(result){
			if (result==1) {
				
			} else {
				
			}
		},
		error : function() {
			alert("서버 요청 실패");
		}
	});
}