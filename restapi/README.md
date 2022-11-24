### Rest-api-et

Et REST-API er et slags objekt som leser/skriver fra fil ved å bruke HTTP-forespørsler(typisk GET, POST, DELETE, og PUT). I denne klassen støttes bare GET og PUT da de er eneste som gir mening å ha med.

Den ene klassen i dette modulet, ValuesService.java, fungerer ved å sende HTTP-forespørsler til en server med URL definert i klassen. Nå er dette localhost:3030, men kan alltids endres på. Klassen har metodene :

* People getPeople(), som sender GET-request til localholt:3000/people til å få ut People-objektene, og returnere de.
* Tasks getTasks() fungerer på samme måte som getPeople() bare for Tasks istedenfor.
* void PostPeople(People people), som sender en POST-request til serveren og sender den argumentet.
* void PostTasks(Tasks tasks) fungerer på samme måte som PostPeople() bare for Tasks istedenfor.
