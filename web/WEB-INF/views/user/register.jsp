<%-- 
    Document   : register
    Created on : May 12, 2022, 10:37:30 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
    <div class="row">
        <div class="col-lg-10 col-xl-9 mx-auto">
            <div class="card flex-row my-5 border-0 shadow rounded-3 overflow-hidden">
                <div class="card-img-left d-none d-md-flex">
                    <!-- Background image for card set in CSS! -->
                </div>
                <div class="card-body p-4 p-sm-5">
                    <c:if test="${error != null}">
                        <div class="alert alert-danger alert-dismissible fade show mb-5" role="alert">
                            <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
                            <strong>Lỗi!</strong> ${error}.
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                    </c:if>
                    <h5 class="card-title text-center mb-5 fw-light fs-5">Register</h5>
                    <form action="${pageContext.request.contextPath}/user/createAccount.do" method="post" class="needs-validation" novalidate>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="floatingInputUsername" value="${username}" name="username" placeholder="myusername" required autofocus>
                            <label for="floatingInputUsername">Username</label>
                            <div class="invalid-feedback">
                                Please input a username.
                            </div>
                        </div>

                        <div class="form-floating mb-3">
                            <input type="email" class="form-control" id="floatingInputEmail" value="${email}" name="email" placeholder="name@example.com" required>
                            <label for="floatingInputEmail">Email address</label>
                            <div class="invalid-feedback">
                                Please input an email.
                            </div>
                        </div>

                        <hr>

                        <div class="form-floating mb-3">
                            <input type="password" class="form-control" id="floatingPassword" value="${password}" name="password" placeholder="Password" required autofocus>
                            <label for="floatingPassword">Password</label>
                            <div class="invalid-feedback">
                                Please input a password.
                            </div>
                        </div>

                        <div class="form-floating mb-3">
                            <input type="password" class="form-control" id="floatingPasswordConfirm" value="${confirmPassword}" name="confirmPassword" placeholder="Confirm Password" required autofocus>
                            <label for="floatingPasswordConfirm">Confirm Password</label>
                            <div class="invalid-feedback">
                                Please input a password.
                            </div>
                        </div>

                        <hr>

                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="floatingInputUsername" value="${fullname}" name="fullname" placeholder="myusername" required autofocus>
                            <label for="floatingInputUsername">Full Name</label>
                            <div class="invalid-feedback">
                                Please input a full name.
                            </div>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="floatingInputUsername" value="${phone}" name="phone" placeholder="myusername" required autofocus maxlength="10" minlength="10">
                            <label for="floatingInputUsername">Phone</label>
                            <div class="invalid-feedback">
                                Please input a phone.
                            </div>
                        </div>
                        <div class="form-floating mb-3">
                            <select id="selectBox" name="districtID" onchange="setWard()" class="form-select" id="floatingSelect" aria-label="Floating label select example" required>
                                <option selected disabled value="">Quận</option>
                                <c:forEach var="d" items="${listD}" >
                                    <option ${districtID == d.districtID?"selected":""} value="${d.districtID}">${d.districtName}</option>
                                </c:forEach>
                            </select>
                            <div class="invalid-feedback">
                                Please select a district.
                            </div>
                            <label for="floatingSelect">Quận:</label>
                        </div>
                        <div class="form-floating mb-3 col">
                            <select id="ward" name="ward" class="form-select" id="floatingSelect" aria-label="Floating label select example" required="">
                                <option selected disabled value="">Phường</option>
                                <c:forEach var="w" items="${listW}" >
                                    <option ${ward == w.wardID?"selected":""} value="${w.wardID}">${w.wardName}</option>
                                </c:forEach>
                            </select>
                            <div class="invalid-feedback">
                                Please select a ward.
                            </div>
                            <label for="floatingSelect">Phường:</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="floatingInputUsername" value="${address}" placeholder="myusername" name="address" required autofocus>
                            <label for="floatingInputUsername">Address</label>
                            <div class="invalid-feedback">
                                Please input a address.
                            </div>
                        </div>
                        <div class="d-grid mb-2">
                            <button class="btn btn-lg btn-primary btn-login fw-bold text-uppercase" type="submit">Register</button>
                        </div>

                        <a class="d-block text-center mt-2 small" href="${pageContext.request.contextPath}/user/login.do">Have an account? / Sign In</a>

                        <hr class="my-4">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    function setWard() {
        var selectBox = document.getElementById("selectBox");
        var selectedValue = selectBox.options[selectBox.selectedIndex].value;
        $.ajax({
            url: "${pageContext.request.contextPath}/home/ward.do",
            type: 'post',
            data: {
                districtID: selectedValue
            },
            success: function (responseData) {
                document.getElementById("ward").innerHTML
                        = responseData;
//                document.getElementById("districtID").innerHTML
//                        = "<input type=\"hidden\" name=\"districtID\" value=\"" + selectedValue + "\"/>";
            }
        });
    }

    (function () {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
                .forEach(function (form) {
                    form.addEventListener('submit', function (event) {
                        if (!form.checkValidity()) {
                            event.preventDefault()
                            event.stopPropagation()
                        }

                        form.classList.add('was-validated')
                    }, false)
                })
    })()
</script>
