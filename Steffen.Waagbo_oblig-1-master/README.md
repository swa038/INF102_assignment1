#Oppgave 1
Her har jeg valgt å bruke ArrayList siden jeg benyttet meg av get()-metoden ofte. Tankegangen er at hver gang en jobb 
blir registrert, så legges den til i listen over jobber med mindre den allerede ligger der. Antall ledige roboter blir 
telt opp hver gang metoden kalles, og hvis det antallet er større eller likt det som trengs for å gjøre jobben, så 
legges det til en og en tilfeldig robot til den jobben har nok roboter. Jobben fjernes deretter fra jobblisten. Dersom 
det ikke var nok ledige roboter, så legges jobben til i en annen jobbliste, som deretter blir forsøkt gjort hver gang 
en annen jobb er fullført. Uansett om jobben kunne bli gjort eller ikke skal den altså fjernes fra første listen.

Alle jobber som ikke kan bli gjort burde havne i jobList2, så hver gang en jobb er fullført sjekker jeg bare om jobbList2
er er tom. Hvis den ikke er det så blir første jobben i listen kalt inn i registerJob() slik at den kan bli forsøkt 
gjort igjen, og fjernes fra jobList2() så den ikke ender opp med å bli "gjort" flere ganger.


#Oppgave 2
Valgte ArrayList igjen fordi jeg brukte både get og set metodene. Løste oppgaven likt den første, med unntak av at det 
var de k nærmeste robotene som skulle sendes til en jobb i stedet for k random roboter, og dermed måtte robotList sorteres.
Gjorde det kun dårligere enn den tilfeldige strategien på input 06.in, men tror den hadde gjort det dårlige i et tilfelle
til dersom jeg ikke beholdt kriteriet om at robotene som ble sendt ikke skulle være busy. Da kunne roboter endt opp med å
bruke mye tid på å gå mellom forskjellige jobber og dermed kunne det tatt veldig lang tid å faktisk fullføre enkelte jobber. 
Dersom det var mange flere roboter, og feks. bare en var ledig og den trengtes til en jobb, så kunne det tatt lengre tid å 
finne den ved å lete etter en random ledig robot enn ved å bare finne den nærmeste eller den nærmeste ledige.
Når det kommer til sorteringen kunne jeg potensielt brukt heap sort for å få ned kjøretiden.

#Oppgave 3
Ser for meg at closest kunne gjort det veldig dårlig dersom den var en av de k nærmeste robotene hos to forskjellige jobber
som ble opprettet samtidig og hadde lang avstand mellom seg.



