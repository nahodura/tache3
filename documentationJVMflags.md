-----
## Documentation pour les JVM flags
-----
#1 
```
-XX:+UseG1GC
```
- Utilise le Garbage Collector G1 (G1GC) : un collecteur d’ordures optimisé pour les applications avec une taille de tas (heap) modérée à grande. Il est conçu pour équilibrer les temps de pause et le débit de l'application. Bon choix pour les applications qui ont besoin d'une performance stable sans temps de pause trop longs (tels que les environnements de production).
-----
#2
```
-XX:+UseZGC 
```
- Utilise le Garbage Collector Z (ZGC) : un collecteur de mémoire faible latence optimisé pour les grandes tailles de tas qui vise à maintenir les temps de pause en dessous de 10 ms.  Idéal pour les applications qui manipulent de grandes quantités de mémoire et nécessitent des réponses rapides. Tester ZGC permet d'évaluer les performances dans des scénarios nécessitant une faible latence.
-----
#3
```
-Xms512m
```
- Définit la taille initiale du tas à 512 Mo. pour réduire les redimensionnements de mémoire à l'initialisation. Ça améliore les performances en permettant à la JVM de démarrer avec suffisamment de mémoire, ce qui réduit les ralentissements liés aux redimensionnements initiaux.
-----
#4
```
-Xmx2g
```
- Définit la taille maximale du tas à 2 Go, limitant ainsi la quantité de mémoire que la JVM peut utiliser pour éviter à l’application d’utiliser trop de mémoire système; utile dans des environnements CI/CD pour garantir la stabilité des builds.
-----
#5
```
-XX:MaxGCPauseMillis=200 
```
-  Définit un objectif de temps de pause maximal pour le garbage collector à 200 millisecondes. Cette option est utile pour tester comment les pauses dues au garbage collector affectent la réactivité de l’application, surtout si le temps de réponse est important.
-----
#6
```
-XX:+HeapDumpOnOutOfMemoryError
```
- Demande à la JVM de générer un dump mémoire en cas d’erreur ```OutOfMemoryError```. C'est utile pour diagnostiquer les problèmes puisqu'il enregistre l’état de la mémoire lors d’une erreur donc on peut comprendre ce qui a causé la surcharge de mémoire.
-----
#7
```
-XX:+PrintGCDetails
```
- Active un journal détaillé du garbage collector (GC) qui permet de voir les détails des cycles de GC et fournit des informations utiles pour analyser le comportement de la gestion de la mémoire pour identifier des problèmes potentiels liés aux performances et à l'utilisation du tas.
-----
#8
```
-XX:+AlwaysPreTouch
```
- Demande à la JVM de pré-réserver les pages mémoire pour tout le tas au démarrage, au lieu de les allouer au fur et à mesure de l’utilisation. C'est particulièrement utile dans des environnements avec de grandes quantités de mémoire puisqu'au final, ça améliore l'accès en mémoire, tout en évitant les latences liées à l'allocation des pages mémoire au premier accès. 
-----
#9
```
-XX:+ExitOnOutOfMemoryError 
```
- Demande à la JVM de terminer immédiatement l'application en cas d’erreur ```OutOfMemoryError```. Dans des environnements CI/CD, cela permet de "fail fast" en cas de manque de mémoire, plutôt que de continuer dans un état instable. Cela garantit que le build échoue rapidement, facilitant le débogage.
-----
#10
```
-XX:+UnlockDiagnosticVMOptions
```
- Débloque les options de diagnostic de la JVM, ce qui permet d’activer des flags avancés pour un examen plus approfondi. Cela permet d’activer des options expérimentales ou de diagnostic supplémentaires, ce qui est utile pour tester et optimiser le comportement de la JVM.
-----
