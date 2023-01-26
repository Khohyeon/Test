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
            <table border="1">
                <form action="/update" method="post">
                    <tr>
                        <th>유저이름</th>
                        <th>패스워드</th>
                        <th>이메일</th>
                    </tr>
                    <tr>
                        <td><input type="text" name="username" value="${user.username}"></td><br />
                        <td><input type="password" name="password" value="${user.password}"></td><br />
                        <td><input type="email" name="email" value="${user.email}"></td><br />
                        <button type="submit">회원수정완료</button>
                    </tr>
                </form>

            </table>
        </div>
        <%@ include file="../layout/footer.jsp" %>