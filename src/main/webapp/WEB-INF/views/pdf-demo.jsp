<!doctype html>
<html>
<head>
    <title>Create PDF from form with signature</title>
</head>
<body>
<div id="header">
    <%@ include file="../../static/header.jsp" %>
</div>
<%@include file="../../static/includes.jsp" %>

<!-- jSignature -->
<style>
    #signature {
        width: 48%;
        text-align: center;
        height: 12%;
        border: 2px solid black;
    }
</style>

<div class="container" style="min-height: 500px">

    <div class="starter-template">
        <h1>Defendant Details</h1>
        <br>

        <div id="feedback"></div>

        <form class="form-horizontal center-allign" id="search-form">
            <div class="form-group form-group-lg">
                <label class="col-sm-3 control-label">Select Device: </label>
                <div class="col-sm-3">
                    <select class="col-sm-6 form-control" name="deviceSelected" id="deviceSelected">
                        <option value="Device 1">Device 1</option>
                        <option value="Device 2">Device 2</option>
                        <option value="Device 3">Device 3</option>
                        <option value="Device 4">Device 4</option>
                    </select>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-3 control-label" required>First Name: </label>
                <div class="col-sm-6">
                    <input type=text class="form-control" id="firstName" value="Thor" required>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-3 control-label" required>Last Name: </label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="lastName" value="Odinson" required>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-3 control-label" required>Date of Birth: </label>
                <div class="col-sm-6">
                    <input type=text class="form-control" id="dateOfBirth" value="07-04-1985" required>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-3 control-label" required>Sex: </label>
                <div class="col-sm-6">
                    <select class="col-sm-6 form-control" name="sex" id="sex">
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                    </select>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-3 control-label" required>Height: </label>
                <div class="col-sm-6">
                    <input type=text class="form-control" id="height" value="195">
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-3 control-label" required>Phone Number: </label>
                <div class="col-sm-6">
                    <input type=text class="form-control" id="phoneNum" value="8008467634">
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-3 control-label" required>Email: </label>
                <div class="col-sm-6">
                    <input type=text class="form-control" id="email" value="thor@avengers.com" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-3 control-label">Driving License Number: </label>
                <div class="col-sm-6">
                    <input type=text class="form-control" id="dLicenseNum" value="1357924680" required>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-3 control-label">Social Security Number: </label>
                <div class="col-sm-6">
                    <input type=text class="form-control" id="sSecurityNum" value="87654321" required>
                </div>
            </div>
            <h3 style="text-align: center;font-weight: bold">Defendant Residential Address</h3>
            <div class="form-group form-group-lg">
                <label class="col-sm-3 control-label">Address Line 1: </label>
                <div class="col-sm-6">
                    <input type=text class="form-control" id="addLine1" value="1000 Royal Palace" required>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-3 control-label">Apt Number: </label>
                <div class="col-sm-6">
                    <input type=text class="form-control" id="addLine2" value="6502">
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-3 control-label" required>City: </label>
                <div class="col-sm-6">
                    <input type=text class="form-control" id="city" value="Asgard">
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-3 control-label" required>State: </label>
                <div class="col-sm-6">
                    <input type=text class="form-control" id="state" value="Yothenheim">
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-3 control-label" required>Zipcode: </label>
                <div class="col-sm-6">
                    <input type=text class="form-control" id="zipCode" value="12345">
                </div>
            </div>
            <h3 style="text-align: center;font-weight: bold">Employer Info</h3>
            <div class="form-group form-group-lg">
                <label class="col-sm-3 control-label">Employer Name: </label>
                <div class="col-sm-6">
                    <input type=text class="form-control" id="empName" value="Avengers">
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-3 control-label">Supervisor Name: </label>
                <div class="col-sm-6">
                    <input type=text class="form-control" id="empSupName" value="Captain America">
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-3 control-label">Accept Terms: </label>
                <div class="col-sm-6" style="font-size: medium">By signing this document, I acknowledge that all of the
                    information that I have
                    provided to be
                    true and accurate. I agree that I will hold harmless the
                    service provider, installer, and the manufacturer of the aforementioned device in the occurrence of
                    any of the following; physiological adverse effects,
                    claims, attorney fees, cost, manufacturing defects, or any other injured resulting from the
                    monitoring device, wearing the monitoring device, harming the
                    monitoring device installed, and the like. I further agree the monitoring device is only being used
                    for services related to my bond, parole, probation, and
                    the like. Thus, the service provider, installer, and manufacturer possess no duty to maintain my
                    safety, health, or well-being with the monitoring device.
                </div>

            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-3 control-label"></label>
                <div class="col-sm-3">
                    <select class="col-sm-6 form-control" name="acceptTerms" id="acceptTerms">
                        <option value="I Accept">Accept</option>
                        <option value="I Decline">Decline</option>
                    </select>
                </div>
            </div>


            <!-- Signature area -->
            <div class="row">
                <div class="col-sm-3"></div>
                <div class="col-sm-5" style="align-content: center" id="signature"></div>

            </div>
            <br/>

            <div class="row center-allign" style="text-align: center">
                <button class="btn btn-submit submit" id="click" type="submit"
                        style="background-color: #31d331;">
                    <a style="color: white;font-weight: bold;">Create PDF</a>
                </button>
                <button class="btn btn-submit submit" type="submit"
                        style="background-color: red;">
                    <a href="${pageContext.request.contextPath}/signPdfDemo" style="color: white;font-weight: bold;">Reset</a>
                </button>
            </div>

            <br>

        </form>
        <div class="row center-allign" style="text-align: center">
            <button class="btn btn-submit submit" id="downloadPdf" type="submit"
                    style="background-color: dodgerblue; color: white;font-weight: bold;">
                <a href="${pageContext.request.contextPath}/downloadPrevious" style="color: white;font-weight: bold;">Download
                    Generated PDF</a>
            </button>
        </div>
    </div>

</div>

<!-- Script -->
<script>
    $(document).ready(function () {
        $("input").prop('required', true);
        // Initialize jSignature
        var $sigdiv = $("#signature").jSignature({'UndoButton': true});


        $('#click').click(function () {
            createViaAjax();
        });

        function createViaAjax() {
            var customer = {};
            $("input").prop('required', true);
            customer["deviceSelected"] = $("#deviceSelected").val();
            customer["firstName"] = $("#firstName").val();
            customer["lastName"] = $("#lastName").val();
            customer["dateOfBirth"] = $("#dateOfBirth").val();
            customer["sex"] = $("#sex").val();
            customer["height"] = $("#height").val();
            customer["phoneNum"] = $("#phoneNum").val();
            customer["email"] = $("#email").val();
            customer["dLicenseNum"] = $("#dLicenseNum").val();
            customer["sSecurityNum"] = $("#sSecurityNum").val();
            customer["addLine1"] = $("#addLine1").val();
            customer["addLine2"] = $("#addLine2").val();
            customer["city"] = $("#city").val();
            customer["state"] = $("#state").val();
            customer["zipCode"] = $("#zipCode").val();
            customer["empName"] = $("#empName").val();
            customer["empSupName"] = $("#empSupName").val();
//            customer["typeOfWork"] = $("#typeOfWork").val();
//            customer["empAddLine1"] = $("#empAddLine1").val();
//            customer["empAddLine2"] = $("#empAddLine2").val();
//            customer["empCity"] = $("#empCity").val();
//            customer["empState"] = $("#empState").val();
//            customer["empZipCode"] = $("#empZipCode").val();
            customer["acceptTerms"] = $("#acceptTerms").val();
            customer["signature"] = $sigdiv.jSignature('getData', 'image')[1];

            $.ajax({
                type: "POST",
                contentType: "application/json",
//                url: "http://www.thebtnco.com:8080/thebtnco/api/createPdf",
                url: "/api/createPdf",
                data: JSON.stringify(customer),
                dataType: 'json',
                timeout: 100000,
                success: function (data) {
                    console.log("SUCCESS: ", data);
                },
                error: function (e) {
                    console.log("ERROR: ", e);
                },
                done: function (e) {
                    console.log("DONE");
                }
            });
        }
    });

</script>
</body>
</html>