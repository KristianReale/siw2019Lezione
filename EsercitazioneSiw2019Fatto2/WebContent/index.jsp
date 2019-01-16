<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Segreteria</title>

<style type="text/css">
	section {
		color:brown;
		font-family: sans-serif;
	}
</style>


<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<!-- 
<link rel="stylesheet" href="css/common.css" type="text/css" />
 -->
 
 <script>
	$(window).on('load', function(){
		$.ajax({
			type: "GET",		
			url: "https://jsonplaceholder.typicode.com/posts/1",		
			success: function(data){
				alert("FRASE DEL GIORNO:\n" + data.body);
			}	
		});	
	});
</script>
 
 
 
</head>
<body bgcolor="cyan">

<script>
function jsonFlickrFeed(data) {
	$(window).on('load', function(){
		$("#flickr").html(data.items[0].description);
	});
};
</script>

<script type="text/javascript" src="https://api.flickr.com/services/feeds/photos_public.gne?format=json&tags=owl"></script>


<header class="row">
	<figure class="col-lg-2 col-md-2 col-sm-2">
		<a href="images/segreteria.jpg">
			<img src="images/segreteria.jpg" width="200"/>
		</a>
		<figcaption>La nostra segreteria studenti</figcaption>
	</figure>
	<figure id="flickr" class="col-lg-3 col-md-3 col-sm-2">			
	</figure>
	<div class="col-lg-2 col-md-2 col-sm-4">
		<h3>Portale segreteria studenti</h3>
		<h3>Portale gestione segreteria studenti</h3>
	</div>
	<aside class="col-lg-5 col-md-5 col-sm-4">
	<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d49396.325667490106!2d16.217289196661675!3d39.30479485437768!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x133f974acd5e5e29%3A0x5619c8633cc426fa!2s87100+Cosenza+CS!5e0!3m2!1sit!2sit!4v1516273585413" frameborder="0" style="border:0" allowfullscreen></iframe>
		<figure>
			<a href="http://www.unical.it">
				<img src="images/logo_unical.png" width="300"/>
			</a>
			<h2>			
				<c:if test="${username != null}">
					<p>Sei loggato come ${username}</p>
					<a href="doLogin?logout=true">Logout</a>
				</c:if>
				<c:if test="${username == null}">
					<a href="doLogin">Login</a>
				</c:if>				
			</h2>
		</figure>
	</aside>
</header>

<!-- commento -->
<nav class="navbar navbar-default">
	<ul class="nav navbar-nav">
		<li>Home</li>
		<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Studenti</a>
			<ul class="dropdown-menu">
				<li><a class="dropdown-item" href="ottieniStudenti">Elenco Studenti</a></li>
				<li>Studenti di un certo corso</li>
				<li><a  class="dropdown-item" href="gestioneStudenti/iscriviStudenti">Iscrivi uno studente</a></li>
				<li><a  class="dropdown-item" href="servizi/isee.html">Calcola ISEE</a></li>
			</ul>
		</li>
		<li class="nav-item dropdown">Corsi</li>
		<li>Corsi di laurea</li>
		<li>Dipartimenti</li>
	</ul>
</nav>
<h2>
	Benvenuti nel portale di gestione delle Segreterie Studenti
</h2>
<p>
	Utilizza il menu in alto per 
	<strong>
		navigare tra le <i>varie</i> sezioni della <u>pagina</u>
	</strong>
</p>
<p>
	Ti auguriamo una felice navigazione
</p>

<section class="row container">
	<article class="col-sm-5 jumbotron">
		<header>Dicono di noi</header>
		La segreteria è un servizio di riferimento che serve per...
	</article>	
	<div class="col-sm-2"></div>
	<article class="col-sm-5 jumbotron">
		<header>Centro ICT di Ateneo</header>
		Dalla pagine accessibile da <a href="www.unical.it">questo link</a>	
	</article>
</section>
<section class="row container">	
	<article class="col-sm-5 jumbotron">
		<header><h3>Dicono di noi</h3></header>
		La segreteria è un servizio di riferimento che serve per...
	</article>	
	<div class="col-sm-2"></div>
	<article class="col-sm-5 jumbotron">
		<header><h3>Centro ICT di Ateneo</h3></header>
		Dalla pagine accessibile da <a href="www.unical.it">questo link</a>	
	</article> 
</section>

<footer>
	<a href="http://www.unical.it">
		Clicca qui per accedere al sito dell'unical
	</a>
</footer>
</body>
</html>