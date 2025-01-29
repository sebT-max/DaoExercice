### 1. C'est quoi une API Java standard :
c'est un ensemble de classes, d'interfaces et de bibliothèques fournies par le JDK pour pouvoir effectuer des tâches
courantes sans avoir à réécrire tout le code depuis 0.

### 2. C'est quoi JDBC
C'est API Java standard qui va agir comme intermédiaire entre une application Java et une base données.

### 3. Que nous permet JDBC
1. Se connecter à une base de données, une URL, un nom d'utilisateur et un mot de passe
2. Exécuter des requête SQL : SELECT , INSERT, UPDATE, ...
3. Manipuler les résultats : lorsqu'on va effectuer une requête, on va récupérer les résultats sous la forme d'un ResultSet -> qu'on va pouvoir parcourir et manipuler avec Java
4. Gérer des transactions : c'est s'assurer de l'atomicité de la base de données (au niveau de nos opérations) (TOUT OU RIEN)
5. Gérer les erreurs : lorsqu'un erreur survient que ce soit lors de l'execution d'une requête SQL ou de la connexion à la base de données. JDBC va lever une SQLException

### 4. En quoi JDBC est important? 
Car il est indépendant de la base de données utilisée. Comme il offre une couche d'abstraction, notre code pourra intéragir avec n'importe quelle base de données relationnelle
⚠️ A condition d'avoir le pilote JDBC adapté 

### 5. Les composants importants de JDBC : 
1. DriverManager : C'est la classe centrale qui va gérer les pilotes JDBC. Elle va nous permettre d'établir la connexion avec la base de données
2. Connection : Il représente une connexion active avec la base de données
3. Statement : utilisé pour exécuter des requête SQL
4. PreparedStatement : c'est une sous classe de Statement, elle va nous permettre de faire des requête préparée, plus sécurisée et plus performante qu'un Statement de base
5. ResultSet : Répresenter les résultats d'une requête SQL, on pourra le parcourir pour lire nos données

### 6. JDBC et les interfaces
Une grande force de JDBC c'est que son design est basé sur les interfaces. Ca signifie que le code JDBC est indépendant de la base de données
<strong> En pratique </strong>
Pilotes JDBC : Pour se connecter à une base de données spécifique (postgresql, mssql,...) -> utiliser le pilote approprié.
Le pilote il implemente les interfaces et la communication spécifique à la base de données relationnelle

### 7. Types de pilotes JDBC
1. Pilote de type 1 (pilote JDBC-OBDC)
ce pilote utilise un pont pour convertir nos appels JDBC en appels ODBC -> et ensuite il les traduit dans des requêtes spécifique à la base de données
--> plus utilisé aujourd'hui car obsolète.
2. Pilote de type 2 (pilote natif partiel)
il convertit les appels JDBC en appels natifs spécifique à une base de données, il utilise une bibliothèque native (en c et ou c++)
On ne l'utilise plus parce que il existe de pilotes plus performants
3. Pilote de type 3 (pilote réseau pur java)
il utilise des protocoles réseaux pour communiquer avec un serveur qui va faire le lien avec une base de données (le pilote est en full java)
de par la complexité qu'il apporte il est rarement utilisé
4. Pilote de type 4 (Pilote Java Pur -  Direct to database pure java driver)
Il convertit directement les appels JDBC en protocoles spécifiques à une base de données. (il est entièrement écrit en java)
<strong> avantages </strong>
Il est très performant et indépendant du système d'exploitation. C'est très facile à déployer (tout est en java)
C'est le type de pilote le plus utilisé aujourd'hui.

