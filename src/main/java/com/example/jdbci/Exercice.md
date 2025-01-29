## Exercice de gestion d'une bibliothèque
Objectif : Etendre le projet existant pour y ajouter une gestion de livres et d'emprunts
### Partie 1 : 
<strong>Création d'un modèle pour le livre<strong>
Un livre sera défini par les attributs suivants : 
- id
- title
- author
- isbn
- available
<strong> Création d'un modèle pour les emprunts
les emprunts serront défini avec les attributs suivants (⚠️ il faut réfléchir à une gestion de dates)
- id
- userId
- bookId
- returned
### partie 2 - implementation des DAO
1. création des interfaces spécifiques pour nos deux nouveaux modèles (avec les opérations CRUD standard)
2. ajout de méthode spécifiques :
Pour le livre : 
   - une méthode qui va nous permettre de trouver les livres sur base d'un auteur
   - une méthode qui va nous permettre de trouver les livres qui sont disponibles (ceux qui ne sont pas déjà emprunté)
Pour l'emprunt
   - une méthode qui va nous permettre de trouver les emprunts qu'à fait un utilisateur
   - une méthode qui va nous permettre de trouver les livres qui n'ont pas été retournés après 14jours
### points importants
1. utilisation de PreparedStatement pour les requêtes
2. mettre en place des regions afin d'organiser le code
### bonus
mettre en place des commentaires afin de rendre les fonctions plus lisibles