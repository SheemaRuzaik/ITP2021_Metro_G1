<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.POS" %>
<%@ page import="com.service.POSImpl" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Add POS Payment</title>

    <!-- Custom fonts for this template-->
    <link href="css/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    
    <!-- Bootstrap link -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
    
    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    
    <!-- Form Style -->
    <link rel="stylesheet" href="css/form1.css">
     <link rel="stylesheet" href="css/listfoods.css">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Manager POS & Transaction<sup></sup></div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item">
                <a class="nav-link" href="POS_DashBoard.jsp">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Interface
            </div>            
            
            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item  active">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fab fa-paypal"></i>
                    <span>POS Payment</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Point Of Sales</h6>
                        <a class="collapse-item  active" href="AddPOS.jsp">Add POS Payment</a>
                        <a class="collapse-item" href="GetPOS.jsp">View POS Payment</a>
                        <a class="collapse-item" href="Incomes.jsp">Incomes</a>
                        
                    </div>
                </div>
            </li>
            
            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-comments-dollar"></i>
                    <span>Expenses</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Expenses:</h6>
                        <a class="collapse-item" href="AddExpense.jsp">Add Expense</a>
                        <a class="collapse-item" href="GetExpense.jsp">View Expense</a>
                        <a class="collapse-item" href="Expenses.jsp">Expenses</a>
                    </div>
                </div>
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
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Prajeeth K</span>
                                <img class="img-profile rounded-circle"
                                    src="images/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
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
                        <h1 class="h3 mb-0 text-gray-800" >Add POS Payment<br/></h1>                       
                    </div>

                    <!-- Content Row -->
                    
                    
                    
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                                               
                    </div>
                   		 <form action="./CalculatePrice" method="post">
                    
		                      <div class="row">
		                      <div class="col-half">
		                      <h4>Food Item</h4>	
		                      <div class="input-group input-group-icon">
								  <input type="text" name="fooddesc" id="fooddesc" placeholder="Food Description" />
								  <div class="input-icon"><i class="fas fa-pizza-slice"></i></div>
			                  </div>
		                      </div>
		                      
		                      
                       
						      <div class="col-half">
						      <h4>Quantity</h4>						      
						      <div class="input-group input-group-icon">
						        <input type="number" id="qty" name="qty" placeholder="Quantity" min="1" max="100">
						        <div class="input-icon"><i class="fas fa-boxes"></i></div>
						      </div>
						      </div>
						      </div>
						      
						      <div class="row">
                              <div class="col-half">
                              <h4>Price</h4>	
                              <div class="input-group input-group-icon">
					         	 <input type="text" name="price" id="price" placeholder="Rs." />
						         <div class="input-icon"><i class="far fa-money-bill-alt"></i></div>
	                          </div>
                              </div>
                       
                              
                             </div>
						      
						      
						      <br>
						      <div class="row">
                              <div class="col-half">
						      <button type="submit" class="submit" id="submitbtn">Add Item</button>
						      </div>
						      </div>
                          </form>                     
						   
						      
						      <br><br>
						      <table>
						         <tr>
						             <th>Id</th>
						             <th>Food Description</th>
						             <th>Quantity</th>
						             <th>Price</th>
						             <th>Total</th>
						             <th>Action</th>
						         </tr>
							   <% 
		                           ArrayList<POS> pos = new ArrayList<>(); 
		                           POSImpl ipos = new POSImpl();                          
		                  	       pos = ipos.POSpList();
		                           for(POS psp:pos) { 
		                        %>                        	
		                        
                        <tr>
                            <td><%=psp.getPosPayId()%></td>
                            <td><%=psp.getFoodDesc()%></td>
                            <td><%=psp.getQty()%></td>
                            <td><%=psp.getPrice()%></td>
                            <td><%=psp.getTotal()%></td>
                            
                            
                            <td>
                                <form action="./DeletepPOS" method="post">
								
					         <input type="hidden" name="pid" value="<%=psp.getPosPayId() %>">
								
						     <button type="submit" class="cancel" id="btn-remove" style="padding: 8px 20px;" >Delete</button>
			               	</form>
                                
                            </td>
                        </tr>
                        <% } %>
				   	          </table>
				   	          
						      
						       <br><br>
						       
						       <form action="./AddPOS" method="post" >
						      <div class="row">
						      <div class="col-half">
						      <h4>Category</h4>
						      <div class="">
						          	<select name="category" id="category" style="width: 413px;" required>
										<option value=""hidden>Select</option>
										<option value="Dine In">Dine In</option>
										<option value="Take Away">Take Away</option>										
									</select>
						        </div>
						    </div>
						    						    
						    
						      <div class="col-half">
						      <h4>Date</h4>
						      <div class="input-group input-group-icon">
						        <input type="date" name="date" id="date" placeholder="MM/DD/YYYY" required/>
						        <div class="input-icon"><i class="fa fa-calendar"></i></div>
						      </div>
						      </div>
						      </div>
						      
						      <div class="row">
						      <div class="col-half">
						      <h4>Method</h4>
						      <div class="">
						          	<select name="method" id="method" style="width: 413px;" required>
										<option value=""hidden>Select</option>
										<option value="Cash">Cash</option>
										<option value="Credit Card">Credit Card</option>
										<option value="Debit Card">Debit Card</option>
									</select>
						        </div>
						    </div>
						    </div>
						    	
							<br>
			                            
                            <div class="row">
						      <div class="col-half">
						      <h4>Card Type</h4>
						      <div class="">
						          	<select name="cardtype" id="cardtype" style="width: 413px;" >
										<option value=""hidden>Select</option>
										<option value="VISA">VISA</option>
										<option value="American Express">American Express</option>
										<option value="Master Card">Master Card</option>
									</select>
						        </div>
						    </div>
						    
						    
						    <div class="col-half">
						      <h4>Card Number</h4>						      
						      <div class="input-group input-group-icon">
						        <input type="text" name="cardno" id="cardno" placeholder="XXXX-XXXX-XXXX-XXXX" pattern="[0-9]{16}"  />
						        <div class="input-icon"><i class="far fa-credit-card"></i></div>
						      </div>
						      </div>
						      </div>
						      
			    		      <div class="row">
						      <div class="col-half">
						      <h4>Card Holder Name</h4>
						      <div class="input-group input-group-icon">
						        <input type="text" name="holdname" id="holdname" placeholder="Name"/>
						        <div class="input-icon"><i class="fa fa-lock"></i></div>
						      </div>
						      </div>
						      
						      <div class="col-half">
						      <h4>Total Amount</h4>
						      <div class="input-group input-group-icon">
						        <input type="text" name="totamo" id="totamo" placeholder="Rs." />
						        <div class="input-icon"><i class="far fa-money-bill-alt"></i></div>
						      </div>
						      </div>
						      </div>
						      
						      
						      
						     
			
                             <br><br>
						    
						    <div class="row">
						      <div class="col-half">
						      	<button type="reset" class="cancel" style="margin-left: 300px;"> Cancel </button>
						      </div>
						      
						      <div class="col-half">
						      	<button type="submit" class="submit" id="submitbtn"> Submit </button>
						      </div>
						      </div>

				 	</form>
				 	<br>
	            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span><br/><br/>Copyright &copy; Your Website 2020</span>
                    </div>
                </div>
            </footer>
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
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Core plugin JavaScript-->
    <script src="js/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>
    <script src="js/form.js"></script>

</body>

</html>