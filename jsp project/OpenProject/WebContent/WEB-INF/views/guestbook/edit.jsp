<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${result eq '1'}">
<script>
	alert('수정되었습니다.');
	location.href = 'view.do?idx=${param.guestbookIdx}';  
	<!-- location.href: 문자열에서 파라미터 배열 가져오기 -->
</script>
</c:if>

<c:if test="${result ne '1'}">
<script>
	alert('문제가 발생했습니다. 다시 시도해주세요.');
	history.go(-1);  // 인자값으로 -1을 넣으면 location.reload(현재 웹페이지 새로고침 수행)와 같은 동작 수행
</script>
</c:if>