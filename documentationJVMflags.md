-----
## Documentation pour les JVM flags

À prendre note que nous avons dû disable le ```Sonar Cache``` dans le fichier build.yml à cause d'erreurs liés au token d'authentification. 
Nous avons aussi mis 2 flags de plus que demandé (pour aucune raison autre que notre fun).
-----
#1 
```
-XX:+UseG1GC
```
- Utilise le Garbage Collector G1 (G1GC) : un collecteur d’ordures optimisé pour les applications avec une taille de heap modérée à grande. Il est conçu pour équilibrer les temps de pause et le débit de l'application et c'est un bon choix pour les applications qui ont besoin d'une performance stable sans temps de pause trop longs (tel Cryptomator qui peut nécessiter de la mémoire de manière modérée à élevée, en fonction de la taille des fichiers chiffrés).
-----
#2
```
-Xmx2g
```
- Définit la taille maximale du tas à 2 Go, limitant ainsi la quantité de mémoire que la JVM peut utiliser pour éviter à l’application d’utiliser trop de mémoire système. Ça devrait être suffisant pour les opérations de cryptage et de gestion de fichiers de Cryptomator.
-----
#3
```
-XX:MaxGCPauseMillis=200 
```
-  Définit un objectif de temps de pause maximal pour le garbage collector à 200 millisecondes. Cette option est utile pour tester comment les pauses dues au garbage collector affectent la réactivité de l’application. Cryptomator pourrait nécessiter des réponses rapides et fluides lors des interactions avec les fichiers et les utilisateurs.
-----
#4
```
-XX:+HeapDumpOnOutOfMemoryError
```
- Demande à la JVM de générer un dump mémoire en cas d’erreur ```OutOfMemoryError```. C'est utile pour diagnostiquer les problèmes puisqu'il enregistre l’état de la mémoire lors d’une erreur donc on peut comprendre ce qui a causé la surcharge de mémoire.
-----
#5
```
-XX:+PrintGCDetails
```
- Active un journal détaillé du garbage collector (GC) qui permet de voir les détails des cycles de GC et fournit des informations utiles pour analyser le comportement de la gestion de la mémoire pour identifier des problèmes potentiels liés aux performances et à l'utilisation du tas.
-----
#6
```
-XX:+AlwaysPreTouch
```
- Demande à la JVM de pré-réserver les pages mémoire pour tout le tas au démarrage, au lieu de les allouer au fur et à mesure de l’utilisation. Ce flag pourrait être particulièrement utile pour Cryptomator, qui peut avoir besoin d'un accès rapide à la mémoire lors de la manipulation de fichiers volumineux.
-----
#7
```
-XX:+UnlockDiagnosticVMOptions
```
- Débloque les options de diagnostic de la JVM, ce qui permet d’activer des flags avancés pour un examen plus approfondi. Cela permet d’activer des options expérimentales ou de diagnostic supplémentaires, ce qui est utile pour tester et optimiser le comportement de la JVM.
-----
