<%@ taglib prefix="s" uri="/struts-tags" %>  
<%@ attribute name="id" required="true" %>
<%@ attribute name="label" required="true" %>

<s:set var="id">${id}</s:set>
<s:set var="label">${label}</s:set>

<s:textfield  id="%{id}" name="%{id}" label="%{label}" executeScripts="true" />

<script type="text/javascript">
$(document).ready(function(){
	 	$("#${id}").datepicker({
			dateFormat: 'dd/mm/yy',
			dayNames: ['Domingo','Segunda','Ter�a','Quarta','Quinta','Sexta','S�bado','Domingo'],
			dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
			dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','S�b','Dom'],
			monthNames: ['Janeiro','Fevereiro','Mar�o','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
			monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
			nextText: 'Pr�ximo',
			prevText: 'Anterior'
		});
});
</script>
