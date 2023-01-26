<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../layout/header.jsp" %>
        <h1>회원가입 페이지</h1>
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
            <form action="/join" method="post">
                <table border="1">
                    <tr>
                        <td>유저네임</td>
                        <td><input type="text" name="username" placeholder="Enter username" required></td><br />
                    </tr>
                    <tr>
                        <td>패스워드</td>
                        <td><input type="password" name="password" placeholder="Enter password" required></td><br />
                    </tr>
                    <tr>
                        <td>이메일</td>
                        <td><input type="email" name="email" placeholder="Enter email" required></td><br />
                    </tr>
                </table>
                <button type="submit">회원가입완료</button>
            </form>
        </div>


        <%@ include file="../layout/footer.jsp" %>