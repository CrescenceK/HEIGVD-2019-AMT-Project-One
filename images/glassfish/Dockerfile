FROM payara/server-full:5.183

MAINTAINER Francine Youndzo <francine.youndzokengne@heig-vd.ch>

COPY gestionCours.war /opt/payara5/glassfish/domains/domain1/autodeploy/gestionCours.war
ADD drivers/postgresql-42.2.8.jar /opt/payara5/glassfish/lib/
		  
ENTRYPOINT ${PAYARA_PATH}/generate_deploy_commands.sh && echo 'create-jdbc-connection-pool --datasourceclassname org.postgresql.ds.PGConnectionPoolDataSource --restype javax.sql.ConnectionPoolDataSource --property user=amtprojet1:password=pswrd:DatabaseName=GestionDesCours:ServerName=postgres:port=5432 GestionDesCours-pool' > mycommands.asadmin && echo 'create-jdbc-ressource --connectionpoolid GestionDesCours_pool jdbc/GestionDesCours' >> mycommands.asadmin && cat ${DEPLOY_COMMANDS} >> mycommands.asadmin && ${PAYARA_PATH}/bin/asadmin start-domain -v --postbootcommandfile mycommands.asadmin ${PAYARA_DOMAIN}