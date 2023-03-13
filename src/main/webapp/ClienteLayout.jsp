<%@page import=" java.util.List"%>
<%@page import=" datos.ClienteDato"%>
<%@page import="entidad.LayoutCliente"%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Exportación cliente</title>
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

<link href="css/style.css" rel="stylesheet">

<%
	String alerta = request.getParameter("alerta");
	System.out.println("Valor de alerta: " + alerta);
%>




</head>
<body onload="alerta()">

	<input type="hidden" value="<%=alerta%>" id="proceso">


	<header id="header">
	<div class="container-fluid">
		<div class="row align-items-center pt-2 pb-2">
			<div class="col-12 col-sm-12 col-md-4 col-lg-2 col-xl-3">
				<!--  <a class="navbar-brand" href="/"> <img src="img/pld.png"
				width="90px" class="img-fluid float-left logo mr-auto"
				style="maxwidth:398px" alt="Logo Pld"></a>-->
				<div class="col-12 col-sm-12 col-md-5 col-lg-8 col-xl-7"></div>
				<div class="row">
					<div class="col-12 header-contact-numbers">
						<h1 class="title title-contrata-ahora">Exportación de
							clientes</h1>

					</div>

				</div>
			</div>
		</div>
	</div>
	</header>




	<div class="containers">
		<div class="abs-center">
			<!--  <div class="col-md-9 table-responsive">-->
			<form id="frmClientes" method="get" action="ServeletControlador"
				autocomplete="off" name="frmClientes">

				<tr>



					<div class="form-group">

						<!--  <button type="submit" id="submite" value="exportar clientes"
							class="btn btn-primary btn-lg active" name="submit"
							onClick="llamada();">
							<i class="bi bi-filetype-xls"></i>&nbsp;Exportacin clientes
						</button>-->


						<button type="submit" id="submite" name="submit"
							value="exportar clientes" class="btn btn-primary btn-lg active"
							data-bs-toggle="modal" data-bs-target="#ModalUpload"
							class="btn btn-primary btn-lg active" onClick="exit();">
							<i class="bi bi-file-zip"></i>&nbsp;Exportación clientes
						</button>



					</div>

				</tr>

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
					<img src="img/loading6.gif" class="text-center" width="100%">
					<h5 class="text-center">
						<b>Exportando Excel...</b>
					</h5>
					<br>
				</div>
			</div>
		</div>
	</div>








	<script src="js/jquery.js"></script>
	<script src="js/validaciones.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.33/dist/sweetalert2.all.min.js"></script>
	<script src="js/mdb.min.js.descarga"></script>





	<script>
		function exit() {
			$('#ModalUpload').modal('show');
			setTimeout(function() {
				console.log("proceso de salida modal");
				$('#ModalUpload').modal('hide');
				/*$('#ModalUpload').on('hide.bs.modal', function(e) {
					e.preventDefault();
					e.stopPropagation();
					return false;
				});*/

			}, 15000);

			cosole.log("el proceso ha sido concluido");
			document.getElementById("submite").click();

		}

		function bloqueo() {

			$('#ModalUpload').on('hide.bs.modal', function(e) {
				e.preventDefault();
				e.stopPropagation();
				console.log("forma de bloqueeeo");
				keyboard: false;

				return false;
			});

		}

		function bloqueo2() {
			/*$('#ModalUpload').modal({
				backdrop : 'static',
				keyboard : false
				});*/
			$('#ModalUpload').on('hide.bs.modal', function(e) {
				e.preventDefault();
				e.stopPropagation();
				console.log("forma de bloqueeeo");
				keyboard: false;

				return false;
			});

			setTimeout(function() {
				console.log("bloqueo..of..timee..");
				$('#ModalUpload').on('hide.bs.modal');

			}, 10000);

			console.log("bloqueo por 10 seg..");

		}

		function bloqueo3() {
			$(document).ready(function() {
				$('#ModalUpload').modal("show");

				document.getElementById("submite").click(function() {
					$('#ModalUpload').modal('hide');
				});

				/*setTime(function(){
					console.log("bloqueo");
					
				},10000);*/

				$('#ModalUpload').on('hide.bs.modal', function(e) {
					//alert('the modal is about');
					//e.preventDefault();
					//e.stopPropagation();
					console.log("hola");
				});
			});
		}

		function llamada() {

			exit();
			alerta();
			console.log("proceso de llamada");
		}
	</script>



	<script>
		function alerta() {

			var valida = document.getElementById("proceso").value;
			console.log(valida);

			if (valida === "OK") {

				Swal.fire({

					position : 'center',
					icon : 'success',
					title : 'se ha completado la exportacion',
					showConfirmButton : false,
					timer : 1500

				});

				console.log("se realiza el proceso de alerta!!!:...");
			} else {
				console.log("proceso de alerta realizado");

			}

		}
	</script>



	<script>
		function formSubmitXls(formulario) {
			var setForm = document.getElementById(formulario);
			SentForm.action = "XlsLayoutCliente";
			SentForm.submit();
		}
	</script>





	<script>
		var Tabla2Excel = (function() {
			var uri = 'data:application/vnd.ms-excel;base64,', template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>', base64 = function(
					s) {
				return window.btoa(unescape(encodeURIComponent(s)))
			}, format = function(s, c) {
				return s.replace(/{(\w+)}/g, function(m, p) {
					return c[p];
				})
			}
			return function(table, nombre) {
				if (!table.nodeType)
					table = document.getElementById(table)
				var ctx = {
					worksheet : nombre || 'Worksheet',
					table : table.innerHTML
				}
				window.location.href = uri + base64(format(template, ctx))
			}
		})();
	</script>
</body>
</html>