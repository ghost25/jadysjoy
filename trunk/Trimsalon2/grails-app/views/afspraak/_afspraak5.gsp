<!-- grails-app/views/album/_albumList.gsp -->
<ul>
<g:each in="${afspraak}" var="afspraak">
<li>${afspraak.datum}, ${afspraak.hond}</li>
</g:each>
</ul>