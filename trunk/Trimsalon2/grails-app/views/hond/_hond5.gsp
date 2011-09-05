<!-- grails-app/views/album/_albumList.gsp -->
<ul>
<g:each in="${hond}" var="hond">
<li>Hond ${hond.naam} van klant ${hond.klant}</li>
</g:each>
</ul>