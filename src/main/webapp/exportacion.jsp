<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Exportación Archivos</title>
<meta name="viewport"
	content="widht=device-widht, user-scalable=no, initial-scale=1.0, minimun-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<!-- Boostrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->

<link href="css/style2.css" rel="stylesheet">

<%
	String alerta = request.getParameter("alerta");
	System.out.println("imprime alerta:  " + alerta);
%>



</head>
<body onload="alerta()">

	<div class="container-fluid">

		<input type="hidden" value="<%=alerta%>" id="chapa">

		<header id="header">
		<div class="container-fluid">
			<div class="row align-items-center pt-2 pb-2">
				<div class="col-12 col-sm-12 col-md-4 col-lg-2 col-xl-3">
					<!--  <a class="navbar-brand" href="/"> <img src="img/pld.png"
					width="90px" class="img-fluid float-left logo mr-auto"
					style="maxwidth: 90px" alt="Logo Pld"></a>-->

					<div class="col-12 col-sm-12 col-md-5 col-lg-8 col-xl-7"></div>
					<div class="row">
						<div class="col-12 header-contact-numbers">
							<h1 class="title title-contrata-ahora">Exportación de
								archivos</h1>

						</div>

					</div>
				</div>
			</div>
		</div>
		</header>




		<div class="containers">
			<div class="abs-center">

				<form id="frmArchives" method="get" action="ServeletArchiCliente"
					autocomplete="off">

					<div class="btn-toolbar">

						<button type="submit" id="submite" name="submit"
							value="exportar archivos" class="btn btn-primary btn-lg active"
							data-bs-toggle="modal" data-bs-target="#ModalUpload"
							class="btn btn-primary btn-lg active" onClick="bloqueo();">
							<i class="bi bi-file-zip"></i>&nbsp;Exportación archivos
						</button>




						<!--  <button type="submit" id="submite2" name="submit"
						value="excel archivos" class="btn btn-primary btn-lg active"
						onClick="llamarSpinner();">
						<i class="bi bi-file-earmark-excel"></i>&nbsp;Excel archivos
					</button>-->


					</div>



				</form>

			</div>

		</div>



		<div class="modal fade " id="ModalUpload" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true"
			data-backdrop="static" data-keyboard="false">
			<div class="modal-dialog modal-dialog-centered " role="document">
				<div class="modal-content"
					style="background-color: rgba(0, 0, 0, 1) !important; border: none; color: #fff; margin-top: 15px;">
					<div class="modal-body" style="border: none;">
						<img src="img/loading29.gif" class="text-center" width="100%">
						<h5 class="text-center">
							<b>Exportando archivos...</b>
							<!-- rgba(255, 99, 71, 0);  -->
							<!-- rgba(0,0,0, 0.9) !important; -->
						</h5>
						<br>
					</div>
				</div>
			</div>
		</div>





		<script src="js/jquery.js"></script>
		<script src="js/validaciones.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.33/dist/sweetalert2.all.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/mdb.min.js.descarga"></script>



		<script>
			function alerta() {

				var valida = document.getElementById("chapa").value;
				console.log(valida);

				if (valida === "OK") {

					Swal.fire({

						position : 'center',
						icon : 'success',
						title : 'se ha completado el proceso',
						showConfirmButton : false,
						timer : 1500

					});

					console.log("se ha realizado el proceso");
				} else {
					console.log("proceso no se ha realizado");

				}

			}
		</script>







		<script>
			function bloqueo() {
				$('#ModalUpload').on('hide.bs.modal', function(e) {
					e.preventDefault();
					e.stopPropagation();
					console.log("prueba de bloqueo");
					return false;
				});
			}
		</script>



	</div>
</body>
</html>