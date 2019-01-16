<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="../bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<script src="../js/formFiller.js"></script>
<link rel="stylesheet" href="../css/common.css" type="text/css" />

</head>
<body>
	<header>
		<h1>Iscrivi un nuovo studente</h1>
		<c:if test="${studenteCreato != null}">
		Studente creato con successo, nel form sono presenti i dati inseriti
	</c:if>
		<h2>Compila il seguente form</h2>
		<form id="modulo1" class="form-horizontal" method="post"
			action="inviaDatiStudente">
			<div class="form-group">
				<label class="control-label col-sm-2" for="matricola">Matricola</label>
				<div class="col-sm-5">
					<input class="form-control" name="matricola" type="text"
						value="${studenteCreato.matricola}" " />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="nome">Nome</label>
				<div class="col-sm-5">
					<input class="form-control" name="nome" type="text"
						value="${studenteCreato.nome}" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="nome">cognome</label>
				<div class="col-sm-5">
					<input class="form-control" name="cognome" type="text"
						value="${studenteCreato.cognome}" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="dataNascita">Data
					di nascita</label>
				<div class="col-sm-5">
					<input class="form-control" name="dataNascita" type="date"
						value="${studenteCreato.dataNascita}" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="password">Password</label>
				<div class="col-sm-5">
					<input class="form-control" name="password" type="password" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="password2">Conferma
					Password</label>
				<div class="col-sm-5">
					<input class="form-control" name="password2" type="password" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="dipartimento">Dipartimento</label>
				<div class="col-sm-5">
					<select id="dip" class="form-control" name="dipartimento"
						onchange="enableCorso()";>
						<option>---</option>
						<c:forEach items="${dipartimenti}" var="dipartimento">
							<option value="${dipartimento.codice}">
								${dipartimento.nome}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="corsoDiLaurea">Corso
					di Laurea</label>
				<div class="col-sm-5">
					<select id="cLaurea" class="form-control" name="corsoDiLaurea"
						disabled=true>
						<option>---</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="scuola">Scuola di
					Diploma</label>
				<div class="col-sm-5">
					<select class="form-control" name="scuola">
						<option>---</option>
						<c:forEach items="${scuole}" var="scuola">
							<option value="${scuola.id}"
								${studenteCreato.scuolaDiDiploma.id == scuola.id ? 'selected' : ''}>${scuola.nome}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<input class="btn btn-success" type="submit" /> <input
				class="btn btn-warning" type="reset" />
		</form>


	</header>
</body>
</html>