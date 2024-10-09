-----
## Documentation pour les 10 nouveaux tests unitaires ajoutés
-----
#1
```
testNewLicenseHolder() de la classe NewLicenseHolderTest 
```
- Vise à tester le comportement de la classe LicenseHolder, en particulier son interaction avec l’objet LicenseChecker et les propriétés liées à la validation d'une licence. Le test veille à ce que la logique de validation des licences soit correctement mise en œuvre. 
-----
#2
```
testDeletePassphrase() de la classe KeychainManagerTest 
```
- Aide à maintenir la fiabilité du KeychainManager en garantissant que la méthode deletePassphrase() supprime correctement la phrase d'authentification spécifiée du trousseau et confirme que la suppression d'un passphrase n'affecte pas les autres passphrases stockés.  Il teste aussi que l’appel de la méthode changePassphrase n’a aucun effet sur un passphrase déjà supprimé. 
-----
#3
```
testStorePassphrases() de la classe KeychainManagerTest 
```
- Assure que la méthode storePassphrase stocke et met à jour correctement les phrases de passe en vérifiant que la méthode gère différents cas de figure, tels que les phrases de passe vides et nulles tout en garantissant l’intégrité des données. 
-----
#4
```
testValidPasswordStrength() de la classe PasswordStrengthUtilTest 
```
- Assure que la méthode getStrengthDescription() récupère et renvoie correctement la description de qualité (strength) appropriée d’un mot de passe dans le but de garantir que les utilisateurs reçoivent un avis sur la robustesse de leurs mots de passe, 
ce qui est essentiel pour la sécurité de cryptomator. 
-----
#5
```
 testComputeRate( ) de la classe PasswordStrengthUtilTest 
```
- Vérifie que la méthode computeRate traite correctement différents cas d'entrée, notamment les mots de passe null, courts et longs, contribuant ainsi à la fiabilité globale de l'évaluation de la robustesse du mot de passe.  En gros, il garantit que les mots de passe faibles (par exemple, nuls ou trop courts) sont correctement identifiés pour renvoyer cette information à l’usager. 
-----
#6
```
testRunOnShutdownWithSpecificPriority()de la classe ShutdownHookTest
```
- Ce test garantit que la méthode runOnShutdown() permet de planifier des tâches avec une priorité donnée, ce qui permet de contrôler l'ordre d'exécution des tâches pendant l'arrêt du système. Les tâches avec une priorité plus élevée seront exécutées avant celles avec une priorité inférieure. 
-----
#7
```
testCreateCatchingScheduledThreadPoolExecutor() de la classe CatchingExecutorsTest 
```
- Ce test s'assure que le service d'exécution planifié est configuré correctement et qu'il permet la planification de tâches tout en gérant les exceptions. Il vérifie que l'initialisation du service d'exécution fonctionne sans erreurs et que les threads sont prêts à exécuter des tâches planifiées. 
-----
#8
```
testProvideCSPRNG() de la classe CommonsModuleTest 
```
- Ce test s'assure que la méthode provideCSPRNG() retourne une instance de SecureRandom avec une source de génération de nombres aléatoires cryptographiquement sûre. Cela est crucial pour garantir que les opérations de sécurité, comme la génération de clés, utilisent des nombres aléatoires de haute qualité. 
-----
#9
```
testProvideMasterkeyFileAccess() de la classe CommonsModuleTest 
```
- Ce test assure que la méthode provideMasterkeyFileAccess() crée une instance de MasterkeyFileAccess avec les paramètres appropriés pour gérer la sécurisation des clés de chiffrement. Cela garantit que les clés de chiffrement sont manipulées de manière sécurisée. 
-----
#10
```
testProvidesSemVerComparator() de la classe CommonsModuleTest
```
- Ce test vérifie que la méthode providesSemVerComparator() retourne un comparateur capable de comparer correctement les versions sémantiques. Il garantit que les opérations de comparaison des versions dans le système respectent les conventions de version sémantique, assurant ainsi la cohérence des mises à jour logicielles. 
-----
