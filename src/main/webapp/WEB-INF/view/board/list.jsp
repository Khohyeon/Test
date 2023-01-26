<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../layout/header.jsp" %>
        <h1>게시글 목록 페이지</h1>
        <hr />
        <c:choose>
                    <c:when test="${principal == null}">
                        <a href="/loginForm">로그인</a>
                        <a href="/joinForm">회원가입</a>
                    </c:when>

                    <c:otherwise>
                        <a href="/update">회원정보</a>
                        <a href="/logout">로그아웃</a>
                    </c:otherwise>
                </c:choose>

        <table border="1">
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성일</th>
            </tr>
            <c:forEach items="${boardList}" var="board">
                <tr>
                    <td>${board.id}</td>
                    <td>${board.title}</td>
                    <td>${board.createdAt}</td>
                </tr>
            </c:forEach>
        </table>
        <%@ include file="../layout/footer.jsp" %>