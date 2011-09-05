<!-- grails-app/views/album/_albumList.gsp -->
<ul>
<g:each in="${klant}" var="klant">
<li>${klant.naam}, ${klant.woonplaats}</li>
</g:each>
</ul>