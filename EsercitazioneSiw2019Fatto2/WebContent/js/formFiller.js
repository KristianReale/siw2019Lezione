function Studente(matricola, nome, cognome){
	this.matricola = matricola;
	this.nome = nome;
	this.cognome = cognome;	
}

function enableCorso(){	
	var valSel = $("#dip").val();
	if (valSel == "---"){
		$("#cLaurea").attr("disabled", true);
		$("#cLaurea").empty();
		$("#cLaurea").html("<option>---</option>");
	}else{
		$("#cLaurea").removeAttr("disabled");		
		$.ajax({
			type: "GET",		
			url: "dammiCorsiDiLaurea",					
			data: {dipartimento: valSel},
			success: function(data){				
				$("#cLaurea").html(data); 
			}	
		});		
	}
}

function caricaDettagliScuola(studente){		
	var studente = {
			matricola : studente.matricola,
			nome : studente.nome,
			cognome : studente.cognome,
			dataNascita : studente.dataNascita				
		};	
	$.ajax({
		type: "POST",		
		url: "dettagliScuola",		
		datatype : "json",
		data: JSON.stringify(studente),
		success: function(data){
			alert(data);
			var scuola = JSON.parse(data);
			$("#dettagliScuola").text("Nome Scuola : " + scuola.nome); 
		}	
	});	
}