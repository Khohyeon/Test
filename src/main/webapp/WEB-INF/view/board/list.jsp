<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../layout/header.jsp" %>
        <h1>게시글 목록 페이지</h1>
        <hr />

        <table border="1">
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성일</th>
            </tr>
            <c:forEach items="${board.id}" var="board">
                <tr>
                    <td>${board.id}</td>
                    <td>${board.title}</td>
                    <td>${board.created_at}</td>
                </tr>
            </c:forEach>
        </table>
        <%@ include file="../layout/footer.jsp" %>