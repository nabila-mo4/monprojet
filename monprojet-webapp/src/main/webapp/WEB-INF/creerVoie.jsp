<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Création de la voie</title>
	<link type="text/css" rel="stylesheet" href="<c:url value="/css/bootstrap.css"></c:url>" />
	<link type="text/css" rel="stylesheet" href="<c:url value="/css/ajoutstyle.css"></c:url>" />
	
</head>
<body>
     <c:import url="/menu.jsp"></c:import>
     <div class="container">
    	<div class="row">
			<div class="col-md-12 ">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="col-md-12">
							<h3> AJOUTER UNE NOUVELLE VOIE </h3>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
     	
					     		<form method="post" action="<c:url value="/saveVoie"/>"
					     		enctype="multipart/form-data"
					            role="form" style="display: block;">
					       			<div class="form-group">
					       				<input type="text" name="nomVoie" id="nomVoie" value="<c:out value="${voie.nom}"></c:out>" tabindex="1" class="form-control" placeholder="Nom de la voie" />
					       			</div>
									
									<div class="form-group">	
										<input type="text" name="nomHauteurVoie" id="nomHauteurVoie" value="<c:out value="${voie.nomHauteur}"></c:out>" tabindex="1" class="form-control" placeholder="Nom de la hauteur de la voie" />
					       			</div>
									
									<div class="form-group">
										<input type="text" name="nbPointsVoie" id="nbPointsVoie" value="<c:out value="${voie.nbPoints}"></c:out>" tabindex="1" class="form-control" placeholder="Nombre de points de la vue" />
					       			</div>
					       			
					       			<div class="form-group">
					       				<input type="text" name="hauteurVoie" id="hauteurVoie" value="<c:out value="${voie.hauteur}"></c:out>" tabindex="1" class="form-control" placeholder="Hauteur de la voie" />
					       			</div>
					       			
					       			<p class="info">${ form.resultat }</p>
					       			
					       			<div class="form-group">
										<div class="row">
											<div class="col-md-12">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="VALIDER"/>
											</div>
										</div>
								    </div>
					            </form>
					       </div>
					    </div>
					</div>
			    </div>
			</div>
	    </div>
	  </div>

        <script src="<c:url value="/js/jquery-2.1.1.min.js"></c:url>"> </script>
		<script src="<c:url value="/js/bootstrap.min.js"> </c:url>"> </script>
    </body>
</html>

