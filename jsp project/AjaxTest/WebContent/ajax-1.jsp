<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax-1</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	

		//$.ajax(url, {});
		$.ajax({
			url: 'data,jsp?num=1000', // 통신 요청 경로 문자열
			success : function(data){
				$('div').append(data);
			
			}
		})
	});

</script>
</head>
<body>

	<h1>ajax-1.jsp</h1>
	<hr>
	<div></div>
	
</body>
</html>