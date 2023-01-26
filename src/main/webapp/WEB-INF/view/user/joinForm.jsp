<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../layout/header.jsp" %>
        <h1>회원가입 페이지</h1>
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

        <form action="/join" method="post">
            <input type="text" name="username" placeholder="Enter username" required><br />
            <input type="password" name="password" placeholder="Enter password" required><br />
            <input type="email" name="email" placeholder="Enter email" required><br />
            <button type="submit">회원가입완료</button>
        </form>

        <%@ include file="../layout/footer.jsp" %>