# GESTION DES COURS

Application qui permet de gérer les cours, pour des utilisateurs(professeurs, étudiants) qui souhaitent suivre ou donner des cours.Un utilisateur est défini par son username(clé primaire), ses noms et son role( 1:admin, 2:Professeur, 3:étudiant).


## Dépendances

PostgreSQL 9.6.12 <br/>
Java JDK 11 <br/>
Payara 5.193.1 <br/>
Maven <br/>
Lombock <br/>

## Starter le projet

Le point de départ du projet se trouve à la racine. il s'agit du script **start.sh** qui nous permet d'automatiser le lancement de l'application. En l'exécutant à l aide de la commande `./start.sh` le .war de l'application est généré et copié dans le dosier glassfish d'image, puis le docker compose est executé.

## Adaptation

Nous avons rencontré des soucis lors de la création de notre ressource en ligne de commande a travers le Dockerfile de payara, pour le résoudre nous avons créé un script du même nom que celui dans lequel les applications sont déployées dans la version 5.183 de payara, à savoir **post-boot-commands.asadmin**, ce dernier a pour rôle de créer notre ressource, notre pool de connexion et déployer notre application.

## Documentation 

[wiki](https://github.com/CrescenceK/HEIGVD-2019-AMT-Project-One/wiki)