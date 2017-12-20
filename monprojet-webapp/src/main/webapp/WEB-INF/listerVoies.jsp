<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8" />
        <title>Liste des voies</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/css/listestyle.css"></c:url>" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'/>
    </head>
    <body>
    
    
    <c:import url="/menu.jsp"></c:import>
 
		<div class="container">
    		<div class="row">
    			<div class="col-md-12">
					<div class="panel panel-default panel-table">
              			<div class="panel-heading">
                			<div class="row">
                  				<div class="col-md-12 text-center">
                    				<h3 class="panel-title">LA LISTE DES VOIES</h3>
                  				</div>
                  				<div class="col col-xs-6 text-right">
                    				<button type="button" class="btn btn-sm btn-primary btn-create">Creer une nouvelle voie</button>
                  				</div>
                			</div>
              			</div>
			 		    <br> 
              			<div class="panel-body">
               				 <table class="table table-striped table-bordered table-list">
                  					<thead>
                    						<tr>
                       							 <th>Action</th>
                       							 <th> Secteur </th>
                        						 <th>Nom</th>
                        						 <th>Hauteur </th>
                       						     <th>Nom de l'hauteur de la voie </th>
                       						     <th>Nombre de points </th>
												 <th>Etat </th>
                  							</tr> 
                 				    </thead>
                  					<tbody>
                  						<c:forEach items="${voies}" var="listeVoies">
                  						
                         					 <tr>
                            					 <td align="center">
                            						  <a href="editVoie/${listeVoies.id }" class="btn btn-primary"><em class="fa fa-pencil"></em></a>
                             						  <a href="deleteVoie/${listeVoies.id }" class="btn btn-primary"><em class="fa fa-trash"></em></a>
                           						 </td>
                           						 <td><c:out value="${listeVoies.secteur.nom }"></c:out></td>
                            				     <td><c:out value="${listeVoies.nom}"></c:out></td>
                          					     <td><c:out value="${listeVoies.hauteur}"></c:out></td>
                          					     <td><c:out value="${listeVoies.nomHauteurVoie}"></c:out></td>
                          					     <td><c:out value="${listeVoies.nbPoints}"></c:out></td>
                          					     <td><c:out value="${listeVoies.etat}"></c:out></td>
												 
                          					</tr>
                          				</c:forEach>
                     			    </tbody>
               			 </table>
             	   </div>
            	</div>
			</div>
		</div>
	</div>

<script src="js/jquery-2.1.1.min.js"> </script>
<script src="js/bootstrap.min.js"> </script>
</body>
</html>