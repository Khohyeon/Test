<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../layout/header.jsp" %>
        <h1>회원 수정 페이지</h1>
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
            <form action="/update" method="post">
                <table border="1">
                    <tr>
                        <td>유저네임</td>
                        <td><input type="text" name="username" value="${user.username}"></td><br />
                    </tr>
                    <tr>
                        <td>패스워드</td>
                        <td><input type="password" name="password" value="${user.password}"></td><br />
                    </tr>
                    <tr>
                        <td>이메일</td>
                        <td><input type="email" name="email" value="${user.email}"></td><br />
                    </tr>
                </table>
                <input type="submit" value="회원수정완료">
            </form>

        </div>
        <%@ include file="../layout/footer.jsp" %>