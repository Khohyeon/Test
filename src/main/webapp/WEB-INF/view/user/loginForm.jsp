<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>
        <h1>로그인 페이지</h1>
        <hr />
        <div class="flex_box">
            <c:choose>
                <c:when test="${principal == null}">
                    <a href="/loginForm">로그인</a>&nbsp;
                    <a href="/joinForm">회원가입</a>
                </c:when>

                <c:otherwise>
                    <a href="/updateForm">회원정보</a>&nbsp;

                    <a href="/logout">로그아웃</a>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="flex_box">
            <form action="/login" method="post">
                <input type="text" name="username" value="${remember}" placeholder="Enter username" required><br />
                <input type="password" name="password" placeholder="Enter password" required><br />
                <button type="submit">로그인</button>
            </form>
        </div>

        <%@ include file="../layout/footer.jsp" %>