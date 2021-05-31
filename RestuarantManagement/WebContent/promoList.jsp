<%@page import="com.service.*"%>
<%@page import="com.model.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Promotion</title>

    <link href="css/sb-admin-2.min.css" rel="stylesheet">
	
    <!-- Custom fonts for this template-->
    <link href="css/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    
	
    <!-- Custom styles for this template-->
    
    <!-- Calendar template -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.7/semantic.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.1.0/fullcalendar.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.7/semantic.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.17.1/moment.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.1.0/fullcalendar.min.js"></script>
	<script src="js/calendar.js"></script>

    <script src="assets/js/jquery.easydropdown.js"></script>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <script src="assets/js/sweetalert.min.js"></script>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.js"></script>
<script src="assets/js/core/jquery.3.2.1.min.js"></script>

	<link rel="stylesheet" type="text/css" href="assets/css/jquery.dataTables.css">

	<script charset="utf8" src="assets/js/jquery.dataTables.js"></script>
	
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/croppie.js"></script>
    <link rel="stylesheet" href="assets/css/croppie.css" />

    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
	<style type="text/css">
        .my-error-class {
            color:red;
        }
        .my-valid-class {
            color:green;
        }
    </style>

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="User&PayrollDashboard.jsp">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Promotion<sup></sup></div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="User&PayrollDashboard.jsp">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Interface
            </div>
            
            <!-- Nav Departments Details -->
            <li class="nav-item">
                <a class="nav-link" href="promotion.jsp">
                    <i class="fas fa-fw fa-home"></i>
                    <span>Promotion Details</span></a>
            </li>
            
            <li class="nav-item">
                <a class="nav-link" href="promoList.jsp">
                    <i class="fas fa-fw fa-home"></i>
                    <span>Used Promotion List</span></a>
            </li>
            
            <li class="nav-item">
                <a class="nav-link" href="promoAdd.jsp">
                    <i class="fas fa-fw fa-home"></i>
                    <span>Add Promotion</span></a>
            </li>

            
            <li class="nav-item">
                <a class="nav-link" href="promoList.jsp">
                    <i class="fas fa-fw fa-home"></i>
                    <span>Edit/Delete Promotion</span></a>
            </li>
            

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Search -->
                    <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                                aria-label="Search" aria-describedby="basic-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="button">
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
                        </div>
                    </form>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small"
                                            placeholder="Search for..." aria-label="Search"
                                            aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>

                        <!-- Nav Item - Alerts -->
                        <li class="nav-item dropdown no-arrow mx-1">
                            <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-bell fa-fw"></i>
                                <!-- Counter - Alerts -->
                                <span class="badge badge-danger badge-counter"></span>
                            </a>
                            <!-- Dropdown - Alerts -->
                            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="alertsDropdown">
                                <h6 class="dropdown-header">
                                    Alerts Center
                                </h6>
                                
                        <!-- Nav Item - Messages -->
                        <li class="nav-item dropdown no-arrow mx-1">
                            <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-envelope fa-fw"></i>
                                <!-- Counter - Messages -->
                                <span class="badge badge-danger badge-counter"></span>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="messagesDropdown">
                                <h6 class="dropdown-header">
                                    Message Center
                                </h6>
                                
                                <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
                            </div>
                        </li>

                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">kk</span>
                                <img class="img-profile rounded-circle"
                                    src="images/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-home fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Home
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Settings
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Activity Log
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">
                	
                	<!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Promotion List</h1>
                        <a href="promoReport.jsp" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                    </div>
                    
                    <br><br>
                    
                    <!-- Content Row -->
                    <div class="row">
					<div class="col">
                        <table id="table1">
		            <thead>
		            <tr>
		                <th class="tableTh">ID</th>
		                <th class="tableTh">P. Code</th>
		                <th class="tableTh">Unique Name</th>
		                <th class="tableTh">State Date</th>
		                <th class="tableTh">End Date</th>
		                <th class="tableTh">P. Type</th>
		                <th class="tableTh">Real Price (Rs.)</th>
		                <th class="tableTh">Discount Price (Rs.)</th>
		                <th class="tableTh">Description</th>
		                <th class="tableTh">Action</th>
		            </tr>
		            </thead>
		            <tbody>
		            <%
		            	PromoService promo = new PromoService();
						ArrayList<Promotion> arrayList1 = promo.getAllPromotion();
						
						for (Promotion promotion : arrayList1) {
							
					%><tr>
						<td class="tableTh"><%=promotion.getId() %></td>
						<td class="tableTh"><%=promotion.getCode() %></td>
						<td class="tableTh"><%=promotion.getU_name() %></td>
						<td class="tableTh"><%=promotion.getSdate() %></td>
						<td class="tableTh"><%=promotion.getEdate() %></td>
						<td class="tableTh"><%=promotion.getType() %></td>
						<td class="tableTh"><%=promotion.getR_price() %></td>
						<td class="tableTh"><%=promotion.getD_price() %></td>
						<td class="tableTh"><%=promotion.getDescription() %></td>
						<td class="tableTh"><button type="button" name="edit" id="<%=promotion.getId() %>" class="edit btn btn-primary btn-sm">Edit</button>
							<button type="button" name="delete" id="<%=promotion.getId() %>" class="delete btn btn-danger btn-sm">Delete</button></td>
					  </tr>
					<%
						}
					%>
		            </tbody>
		        </table>
                        
					<br>
						<hr style="background-color: solid black; height: 5px;">
					<br>
					</div>
                    </div>
                	
	            </div>
	            <!-- End of Main Content -->

            <!-- Footer -->
            
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="Login.jsp">Logout</a>
                </div>
            </div>
        </div>
    </div>
    </div>

    <!-- Core plugin JavaScript-->
    <script src="js/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>
    
    <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2021</span>
                    </div>
                </div>
            </footer>

</body>

</html>
<div id="reloadDiv">
    <div id="formModal_edit" class="modal fade" style="margin-top: 5%;" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Edit Record</h4>
                </div>
                <div class="modal-body">
                    <span id="form_result"></span>
                    <form method="post" id="edit_sample_form" action="promoUpdate" class="form-horizontal" >
                        
                        <div class="form-group">
                            <label class="control-label col-md-4" >Promotion Code : </label>
                            <div class="col-md-8">
                                <input type="text" name="code" id="code" class="form-control" required>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="control-label col-md-4" >Unique Name : </label>
                            <div class="col-md-8">
                                <input type="text" name="uname" id="uname" class="form-control" required>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="control-label col-md-4" >Promotion State Date : </label>
                            <div class="col-md-8">
                                <input type="date" name="sdate" id="sdate" class="form-control" required>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="control-label col-md-4" >Promotion End Date : </label>
                            <div class="col-md-8">
                                <input type="date" name="edate" id="edate" class="form-control" required>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="control-label col-md-4" >Promotion Type : </label>
                            <div class="col-md-8">
                                <select name="type" id="type" class="form-control" required>
										<option value="">Select Type</option>
										<option>Type 1</option>
										<option>Type 2</option>
										<option>Type 3</option>
										<option>Type 4</option>
									</select>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="control-label col-md-4" >Real Price : </label>
                            <div class="col-md-8">
                                <input type="number" name="rprice" id="rprice" step="0.01" class="form-control" required>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="control-label col-md-4" >Discount Price : </label>
                            <div class="col-md-8">
                                <input type="number" name="dprice" id="dprice" step="0.01" class="form-control" required>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="control-label col-md-4" >Description : </label>
                            <div class="col-md-8">
                                <input type="text" name="description" id="description"  class="form-control" required>
                            </div>
                        </div>
                        
                        <br />
                        <div class="form-group" align="center">
                            <input type="hidden" name="id" id="hidden_id" />
                            <input type="submit" name="action_button" id="action_button" class="btn btn-success" value="Edit" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
$(document).ready( function () {
    $('#table1').DataTable();
} );
$(document).ready(function(){
	
	$(document).on('click', '.delete', function(){
        var id = $(this).attr('id');
        
        swal({
            title: "Are You Sure?",
            text: "If You Want Delete This!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
            .then((willDelete) => {
                if (willDelete) {
                	$.ajax({
                    	url:"http://localhost:8080/Restaurant/promoDelete",
                        data:{"id": id},
                        success:function(data)
                        {
                            setTimeout(function(){
                            	location.reload();
                            }, 500);
                        }
                    })
                }
            });
        
    });

    $(document).on('click', '.edit', function(){
        var id = $(this).attr('id');
        $('#form_result').html('');
        $.ajax({
            url:"http://localhost:8080/Restaurant/promoGet",
            data:{"id": id},
            success:function(html){
                var str = html;
                var data = str.split("***");
                $('#hidden_id').val(data[1]);
                $('#code').val(data[2]);
                $('#uname').val(data[3]);
                $('#sdate').val(data[4]);
                $('#edate').val(data[5]);
                $('#type').val(data[6]);
                $('#rprice').val(data[7]);
                $('#dprice').val(data[8]);
                $('#description').val(data[9]);
                $('#formModal_edit').modal('show');
            }
        })
    });
    
        $('#image').on('change', function(){
            var form_data = new FormData($('#sample_form')[0]);
        	$.ajax({
                type: "POST",
                enctype: 'multipart/form-data',
            	url:"http://localhost:8080/buyNsell/imageUploadServlet",
                data: form_data,
                processData: false,
                contentType: false,
                success:function(data)
                {
                    $('#imagePath').val(data);
                }
            })
        });
        
        $('#edit_image').on('change', function(){
            var form_data = new FormData($('#edit_sample_form')[0]);
        	$.ajax({
                type: "POST",
                enctype: 'multipart/form-data',
            	url:"http://localhost:8080/buyNsell/imageUploadServlet",
                data: form_data,
                processData: false,
                contentType: false,
                success:function(data)
                {
                    $('#edit_imagePath').val(data);
                }
            })
        });

    });
    
    function checkUpload(){
    	
    	if($('#imagePath').val()==""){
    		swal({
	            title: "Error",
	            text: "Please Upload Image!",
	            icon: "warning",
	            dangerMode: true,
	        });
    		return false;
    	}else{
    		return true;
    	}
    }
</script>