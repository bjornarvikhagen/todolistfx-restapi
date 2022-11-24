# Kjernemodulen (Core)

Denne modulen inneholder domenelaget og persistenslaget for [cleane](../README.md).

## Domenelaget

Domenelaget inneholer alle klasser og all logikk knyttet til hele prosjektet. Det er fullstendig uavhengig av brukergrensesnitt og restapi. Vår applikasjon handler om å opprette **Person** objekter med feltet name, og **Task** objekter med feltene description, deadline, og person. Kildekode for laget finnes i **[cleane.core](src/main/java/cleane/core/README.md)**-pakken.

## Persistenslaget

Persistenslaget inneholder en klasse som bruker [Jackson](https://github.com/FasterXML/jackson)-biblioteket for å parse objekter til JSon. Persistenslaget befinner seg i **[cleane.json](src/main/java/cleane/json/README.md)**-pakken.

## Bygging med maven

Vi implementerer diverse kodekvalitetsverktøy, [jacoco](https://github.com/jacoco/jacoco) for å sjekke testdekning, [spotbugs](https://spotbugs.readthedocs.io/en/latest/maven.html) for å finne bugs, og [checkstyle](https://checkstyle.sourceforge.io/) for å passe på at all koden er skrevet etter standard kvalitet.
