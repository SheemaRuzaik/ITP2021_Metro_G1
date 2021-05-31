<%@page import="com.model.Inventory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>View Inventory</title>

<!-- Custom fonts for this template-->
<!-- Custom fonts for this template-->
<link href="css/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Bootstrap link -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!-- Form Style -->
<link rel="stylesheet" href="css/form.css">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">


</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">


		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="index.html">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</div>
				<div class="sidebar-brand-text mx-3">
					Manager-Inventory & Asset <sup></sup>
				</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item"><a class="nav-link" href="Inventory_dashboard.jsp">
					<i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Interface</div>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item  active"><a class="nav-link collapsed"
				href="#" data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-fw fa-cog"></i> <span>Inventory</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">INVENTORY:</h6>
						<a class="collapse-item  active" href="AddNewInventory.jsp">Add
							New Inventory</a> <a class="collapse-item" href="InventoryList.jsp">View
							Inventory</a>

					</div>
				</div></li>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapsePages"
				aria-expanded="true" aria-controls="collapsePages"> <i
					class="fas fa-fw fa-folder"></i> <span>Assets</span>
			</a>
				<div id="collapsePages" class="collapse"
					aria-labelledby="headingPages" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">ASSETS:</h6>
						<a class="collapse-item" href="AddNewAsset.jsp">Add Asset</a> <a
							class="collapse-item" href="AssetList.jsp">View Asset</a>
						<div class="collapse-divider"></div>
						<h6 class="collapse-header">ORDER:</h6>
						<a class="collapse-item" href="PlaceOrder_Asset.jsp">Place
							Asset Order</a> <a class="collapse-item" href="OrderList.jsp">View
							Asset Order</a>
					</div>
				</div></li>

			<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseUtilities"
				aria-expanded="true" aria-controls="collapseUtilities"> <i
					class="fas fa-fw fa-wrench"></i> <span>Product Costing</span>
			</a>
				<div id="collapseUtilities" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">COSTING:</h6>
						<a class="collapse-item" href="AddProductCost.jsp">Add Product
							Cost</a> <a class="collapse-item" href="ProductCostingList.jsp">View
							Product Cost</a>
					</div>
				</div></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

						<!-- Nav Monthly Salary Details --> 
 			<li class="nav-item"><a class="nav-link" 
				href="SupplierList.jsp"> <i class="fas fa-fw fa-table"></i>
 					<span> Suppliers</span></a></li> 

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
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>

					<!-- Topbar Search -->
					<form
						class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
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

					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<!-- Nav Item - Search Dropdown (Visible Only XS) -->
						<li class="nav-item dropdown no-arrow d-sm-none"><a
							class="nav-link dropdown-toggle" href="#" id="searchDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
								aria-labelledby="searchDropdown">
								<form class="form-inline mr-auto w-100 navbar-search">
									<div class="input-group">
										<input type="text"
											class="form-control bg-light border-0 small"
											placeholder="Search for..." aria-label="Search"
											aria-describedby="basic-addon2">
										<div class="input-group-append">
											<button class="btn btn-primary" type="button">
												<i class="fas fa-search fa-sm"></i>
											</button>
										</div>
									</div>
								</form>
							</div></li>

						<!-- Nav Item - Alerts -->
						<li class="nav-item dropdown no-arrow mx-1"><a
							class="nav-link dropdown-toggle" href="#" id="alertsDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-bell fa-fw"></i> <!-- Counter - Alerts -->
								<span class="badge badge-danger badge-counter"></span>
						</a> <!-- Dropdown - Alerts -->
							<div
								class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="alertsDropdown">
								<h6 class="dropdown-header">Alerts Center</h6>

								<!-- Nav Item - Messages -->
								<li class="nav-item dropdown no-arrow mx-1"><a
									class="nav-link dropdown-toggle" href="#" id="messagesDropdown"
									role="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"> <i class="fas fa-envelope fa-fw"></i>
										<!-- Counter - Messages --> <span
										class="badge badge-danger badge-counter"></span>
								</a> <!-- Dropdown - Messages -->
									<div
										class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
										aria-labelledby="messagesDropdown">
										<h6 class="dropdown-header">Message Center</h6>

										<a class="dropdown-item text-center small text-gray-500"
											href="#">Read More Messages</a>
									</div></li>

								<div class="topbar-divider d-none d-sm-block"></div>

								<!-- Nav Item - User Information -->
								<li class="nav-item dropdown no-arrow"><a
									class="nav-link dropdown-toggle" href="#" id="userDropdown"
									role="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"> <span
										class="mr-2 d-none d-lg-inline text-gray-600 small">Sheema
											Ruzaik</span> <img class="img-profile rounded-circle"
										src="images/undraw_profile.svg">
								</a> <!-- Dropdown - User Information -->
									<div
										class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
										aria-labelledby="userDropdown">
										<a class="dropdown-item" href="#"> <i
											class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
											Profile
										</a> <a class="dropdown-item" href="#"> <i
											class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
											Settings
										</a> <a class="dropdown-item" href="#"> <i
											class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
											Activity Log
										</a>
										<div class="dropdown-divider"></div>
										<a class="dropdown-item" href="#" data-toggle="modal"
											data-target="#logoutModal"> <i
											class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
											Logout
										</a>
									</div></li>
					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">View Inventory</h1>
						<a href="Select_Report.jsp"
							class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
							class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
					</div>


					<br></br>
					

					<%
						Inventory inv = (Inventory) request.getAttribute("inv");
					%>

					<!-- Search Inventory -->
					<form action="./RetrieveInventoryServlet" method="post">

						<div class="row">
							<div class="col-half">
								<div class="input-group input-group-icon">
									<input type="text" name="invID" id="invID"
										placeholder="Inventory ID" required>
									<div class="input-icon">
										<i class="fa fa-lock"></i>
									</div>
								</div>
							</div>
						</div>

						<button type="submit" class="cancel">Search</button>


					</form>

					<!-- End search Inventory -->
					<br> <br>
					<%
						if (inv != null) {
					%>

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">
							Details of Inventory ID :<%=inv.getInventoryID()%></h1>
					</div>


					<form action="./UpdateInventoryServlet" method="post">

						<br>

						<div class="row">
							<div class="col-half">
								<h4>Supplier ID:</h4>
								<div class="input-group input-group-icon">
									<input type="text" name="supplierid" id="supplierid"
										value="<%=inv.getSupplierID_inv()%>" placeholder="Supplier ID"
										pattern="[S]+[0-9]{4}" title="SXXXX" required />
									<div class="input-icon">
										<i class="fa fa-lock"></i>
									</div>
								</div>

							</div>

							<div class="col-half">
								<h4>Max Stock:</h4>
								<div class="input-group input-group-icon">
									<input type="text" name="maxstock_inv" id="maxstock_inv"
										value="<%=inv.getMaxStock_inv()%>" placeholder="Max Stock"
										required />
									<div class="input-icon">
										<i class="fa fa-lock"></i>
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-half">
								<h4>Description</h4>
								<div class="input-group input-group-icon">
									<input type="text" name="descp_inv" id="descp_inv"
										value="<%=inv.getInventory_desc()%>" placeholder="Description"
										required />
									<div class="input-icon">
										<i class="fa fa-key"></i>
									</div>
								</div>
							</div>



							<div class="col-half">
								<h4>Ordering Qty:</h4>
								<div class="input-group input-group-icon">
									<input type="text" name="orderqty" id="orderqty"
										value="<%=inv.getOrderQty_inv()%>" placeholder="Ordering Qty"
										required />
									<div class="input-icon">
										<i class="fa fa-key"></i>
									</div>
								</div>
							</div>
						</div>



						<div class="row">
							<div class="col-half">
								<h4>Unit Price(LKR):</h4>
								<div class="input-group input-group-icon">
									<input type="number" name="unitprice" id="unitprice"
										value="<%=inv.getUnitPrice_inv()%>" placeholder="Unit Price"
										pattern="[0-9]{10}" title="XXXXXXXXX" required />
									<div class="input-icon">
										<i class="fa fa-home"></i>
									</div>
								</div>
							</div>



							<div class="col-half">
								<h4>Order Frequency:</h4>
								<div class="">
									<select name="orderfrequency" id="orderfrequency" style="width: 425px;">
										<option selected><%=inv.getFrequency()%></option>
										<option value="Daily">Daily</option>
										<option value="Once a week">Once a week</option>
										<option value="Twice a week">Twice a week</option>
										<option value="Once in two weeks">Once in two weeks</option>
										<option value="Never">Never</option>
									</select>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-half">
								<h4>Remarks:</h4>
								<div class="input-group input-group-icon">
									<input type="text" name="remarks" id="remarks" value="<%=inv.getRemarks_inv()%>" placeholder="Remarks" />
									<div class="input-icon">
										<i class="fa fa-phone-square"></i>
									</div>
								</div>
							</div>


							<div class="col-half">
								<h4>Total Price:</h4>
								<div class="input-group input-group-icon">
									<input type="number" name="totprice" id="totprice"
										value="<%=inv.getTotalPrice()%>"  placeholder="Total Price"
										pattern="[0-9]{10}" title="XXXXXXXXX" readonly />
									<div class="input-icon">
										<i class="fa fa-home"></i>
									</div>
								</div>
							</div>
						</div>

							<div class="row">
								<div class="col-half">
									<h4>Available Status:</h4>
									<div class="input-group input-group-icon">
										<input type="text" name="status" id="status"
											value="<%=inv.getAvailableStatus()%>" placeholder="Status"
											readonly />
										<div class="input-icon">
											<i class="fa fa-phone-square"></i>
										</div>
									</div>
								</div>

							</div>
						<br>
						<br>
						
								
					<input type="hidden" name="invID" value="<%=inv.getInventoryID()%>">
								
						<button type="submit" class="btn btn-success">Save Changes</button>
										
				</form>
				<br>
							
				<form action="./DeleteInventoryServlet" method="post">
								
					<input type="hidden" name="invID" value="<%=inv.getInventoryID()%>">
								
						<button type="submit" class="btn btn-danger" id="deletebtn">Delete Now</button>
				</form>
						
				<%} %>
               

				</div>
				
				</div>
				<!-- End of Main Content -->

				<br> <br>


				<!-- Footer -->
				<footer class="sticky-footer bg-white">


					<div class="container my-auto">
						<div class="copyright text-left my-auto">
							<span><a href="AboutUs.jsp" target="_blank">About Us</a></span><br>
							<br></br> <span><a href="TermsAndConditions.jsp"
								target="_blank">Terms & Conditions</a></span><br> <br></br> <span><a
								href="PrivacyPolicy.jsp" target="_blank">Privacy Policy</a></span><br>
							<br></br>
						</div>

					</div>



					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Copyright &copy; Your Website 2020</span>
						</div>
					</div>
				</footer>
				<!-- End of Footer -->

			</div>
			<!-- End of Content Wrapper -->

		</div>
		<!-- End of Page Wrapper -->

		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fas fa-angle-up"></i>
		</a>

		<!-- Logout Modal-->
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Ready to
							Leave?</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">�</span>
						</button>
					</div>
					<div class="modal-body">Select "Logout" below if you are
						ready to end your current session.</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancel</button>
						<a class="btn btn-primary" href="Login.jsp">Logout</a>
					</div>
				</div>
			</div>
		</div>

		<!-- Core plugin JavaScript-->
		<script src="js/jquery.easing.min.js"></script>

		<!-- Custom scripts for all pages-->
		<script src="js/sb-admin-2.min.js"></script>
</body>

</html>