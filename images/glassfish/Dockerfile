FROM payara/server-full:5.193

MAINTAINER Crescence Yimnaing <crescence.yimnaingkamdem@heig-vd.ch>

ADD gestionCours.war /tmp/gestionCours.war
ADD drivers/ ${PAYARA_DIR}/glassfish/lib/
ADD script/post-boot-commands.asadmin /opt/payara/config/post-boot-commands.asadmin
