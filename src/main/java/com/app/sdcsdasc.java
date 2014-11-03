//
//package com.app;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
//import javax.naming.*;
//import javax.sql.DataSource;
//import java.sql.*;
//
//import org.jbpm.services.task.identity.DBUserGroupCallbackImpl;
//
//
//public class sdcsdasc {
//	
//	public static void main(String[] args){
//		
//		Properties properties = new Properties();
//		try {
//		  properties.load(new FileInputStream("jbpm.usergroup.callback.properties"));
//		  for(String key : properties.stringPropertyNames()) {
//			  String value = properties.getProperty(key);
//			  System.out.println(key + " => " + value);
//			}
//		} catch (IOException e) {
//			  System.out.println("err");
//		}
//}}
//
//

//<?xml version='1.0' encoding='UTF-8'?>
//
//<server xmlns="urn:jboss:domain:1.6">
//
//    <extensions>
//        <extension module="org.jboss.as.clustering.infinispan"/>
//        <extension module="org.jboss.as.connector"/>
//        <extension module="org.jboss.as.deployment-scanner"/>
//        <extension module="org.jboss.as.ee"/>
//        <extension module="org.jboss.as.ejb3"/>
//        <extension module="org.jboss.as.jaxrs"/>
//        <extension module="org.jboss.as.jdr"/>
//        <extension module="org.jboss.as.jmx"/>
//        <extension module="org.jboss.as.jpa"/>
//        <extension module="org.jboss.as.jsf"/>
//        <extension module="org.jboss.as.logging"/>
//        <extension module="org.jboss.as.mail"/>
//        <extension module="org.jboss.as.naming"/>
//        <extension module="org.jboss.as.pojo"/>
//        <extension module="org.jboss.as.remoting"/>
//        <extension module="org.jboss.as.sar"/>
//        <extension module="org.jboss.as.security"/>
//        <extension module="org.jboss.as.threads"/>
//        <extension module="org.jboss.as.transactions"/>
//        <extension module="org.jboss.as.web"/>
//        <extension module="org.jboss.as.webservices"/>
//        <extension module="org.jboss.as.weld"/>
//    </extensions>
//
//
//    <management>
//        <security-realms>
//            <security-realm name="ManagementRealm">
//                <authentication>
//                    <local default-user="$local" skip-group-loading="true"/>
//                    <properties path="mgmt-users.properties" relative-to="jboss.server.config.dir"/>
//                </authentication>
//                <authorization map-groups-to-roles="false">
//                    <properties path="mgmt-groups.properties" relative-to="jboss.server.config.dir"/>
//                </authorization>
//            </security-realm>
//            <security-realm name="ApplicationRealm">
//                <authentication>
//                    <local default-user="$local" allowed-users="*" skip-group-loading="true"/>
//                    <properties path="application-users.properties" relative-to="jboss.server.config.dir"/>
//                </authentication>
//                <authorization>
//                    <properties path="application-roles.properties" relative-to="jboss.server.config.dir"/>
//                </authorization>
//            </security-realm>
//        </security-realms>
//        <audit-log>
//            <formatters>
//                <json-formatter name="json-formatter"/>
//            </formatters>
//            <handlers>
//                <file-handler name="file" formatter="json-formatter" path="audit-log.log" relative-to="jboss.server.data.dir"/>
//            </handlers>
//            <logger log-boot="true" log-read-only="false" enabled="false">
//                <handlers>
//                    <handler name="file"/>
//                </handlers>
//            </logger>
//        </audit-log>
//        <management-interfaces>
//            <native-interface security-realm="ManagementRealm">
//                <socket-binding native="management-native"/>
//            </native-interface>
//            <http-interface security-realm="ManagementRealm">
//                <socket-binding http="management-http"/>
//            </http-interface>
//        </management-interfaces>
//        <access-control provider="simple">
//            <role-mapping>
//                <role name="SuperUser">
//                    <include>
//                        <user name="$local"/>
//                    </include>
//                </role>
//            </role-mapping>
//        </access-control>
//    </management>
//
//    <profile>
//        <subsystem xmlns="urn:jboss:domain:logging:1.4">
//            <console-handler name="CONSOLE">
//                <level name="INFO"/>
//                <formatter>
//                    <named-formatter name="COLOR-PATTERN"/>
//                </formatter>
//            </console-handler>
//            <periodic-rotating-file-handler name="FILE" autoflush="true">
//                <formatter>
//                    <named-formatter name="PATTERN"/>
//                </formatter>
//                <file relative-to="jboss.server.log.dir" path="server.log"/>
//                <suffix value=".yyyy-MM-dd"/>
//                <append value="true"/>
//            </periodic-rotating-file-handler>
//            <logger category="com.arjuna">
//                <level name="WARN"/>
//            </logger>
//            <logger category="org.apache.tomcat.util.modeler">
//                <level name="WARN"/>
//            </logger>
//            <logger category="org.jboss.as.config">
//                <level name="DEBUG"/>
//            </logger>
//            <logger category="sun.rmi">
//                <level name="WARN"/>
//            </logger>
//            <logger category="jacorb">
//                <level name="WARN"/>
//            </logger>
//            <logger category="jacorb.config">
//                <level name="ERROR"/>
//            </logger>
//            <root-logger>
//                <level name="INFO"/>
//                <handlers>
//                    <handler name="CONSOLE"/>
//                    <handler name="FILE"/>
//                </handlers>
//            </root-logger>
//            <formatter name="PATTERN">
//                <pattern-formatter pattern="%d{HH:mm:ss,SSS} %-5p [%c] (%t) %s%E%n"/>
//            </formatter>
//            <formatter name="COLOR-PATTERN">
//                <pattern-formatter pattern="%K{level}%d{HH:mm:ss,SSS} %-5p [%c] (%t) %s%E%n"/>
//            </formatter>
//        </subsystem>
//        <subsystem xmlns="urn:jboss:domain:datasources:1.2">
//            <datasources>
//                <datasource jndi-name="java:jboss/datasources/ExampleDS" pool-name="ExampleDS" enabled="true" use-java-context="true">
//                    <connection-url>jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE</connection-url>
//                    <driver>h2</driver>
//                    <security>
//                        <user-name>sa</user-name>
//                        <password>sa</password>
//                    </security>
//                </datasource>
//                <datasource jta="true" jndi-name="java:/jdbc/jbpm-ds" pool-name="java:/jbpm-ds" enabled="true" use-ccm="false">
//                    <connection-url>jdbc:h2:mem:jbpm-db;MVCC=true</connection-url>
//                    <driver-class>org.h2.Driver</driver-class>
//                    <datasource-class>bitronix.tm.resource.jdbc.lrc.LrcXADataSource</datasource-class>
//                    <driver>h2</driver>
//                    <pool>
//                        <max-pool-size>50</max-pool-size>
//                    </pool>
//                    <security>
//                        <user-name>sa</user-name>
//                    </security>
//                    <validation>
//                        <validate-on-match>false</validate-on-match>
//                        <background-validation>false</background-validation>
//                    </validation>
//                    <timeout>
//                        <set-tx-query-timeout>false</set-tx-query-timeout>
//                        <blocking-timeout-millis>0</blocking-timeout-millis>
//                        <idle-timeout-minutes>0</idle-timeout-minutes>
//                        <query-timeout>0</query-timeout>
//                        <use-try-lock>0</use-try-lock>
//                        <allocation-retry>0</allocation-retry>
//                        <allocation-retry-wait-millis>0</allocation-retry-wait-millis>
//                    </timeout>
//                    <statement>
//                        <share-prepared-statements>false</share-prepared-statements>
//                    </statement>
//                </datasource>
//                <datasource jta="false" jndi-name="java:/mysqlDS" pool-name="mysqlDs" enabled="true" use-ccm="false">
//                    <connection-url>jdbc:mysql://128.199.189.44:3306/hellosocial</connection-url>
//                    <driver-class>com.mysql.jdbc.Driver</driver-class>
//                    <driver>mysql</driver>
//                    <security>
//                        <user-name>pras_khanal</user-name>
//                        <password>MyNewPass</password>
//                    </security>
//                    <validation>
//                        <validate-on-match>false</validate-on-match>
//                        <background-validation>false</background-validation>
//                    </validation>
//                    <timeout>
//                        <set-tx-query-timeout>false</set-tx-query-timeout>
//                        <blocking-timeout-millis>0</blocking-timeout-millis>
//                        <idle-timeout-minutes>0</idle-timeout-minutes>
//                        <query-timeout>0</query-timeout>
//                        <use-try-lock>0</use-try-lock>
//                        <allocation-retry>0</allocation-retry>
//                        <allocation-retry-wait-millis>0</allocation-retry-wait-millis>
//                    </timeout>
//                    <statement>
//                        <share-prepared-statements>false</share-prepared-statements>
//                    </statement>
//                </datasource>
//                <datasource jta="false" jndi-name="java:/mysqlCredential" pool-name="mysqlCredential" enabled="true" use-ccm="false">
//                    <connection-url>jdbc:mysql://128.199.189.44:3306/hellosocial2</connection-url>
//                    <driver-class>com.mysql.jdbc.Driver</driver-class>
//                    <driver>mysql</driver>
//                    <security>
//                        <user-name>pras_khanal</user-name>
//                        <password>MyNewPass</password>
//                    </security>
//                    <validation>
//                        <validate-on-match>false</validate-on-match>
//                        <background-validation>false</background-validation>
//                    </validation>
//                    <timeout>
//                        <set-tx-query-timeout>false</set-tx-query-timeout>
//                        <blocking-timeout-millis>0</blocking-timeout-millis>
//                        <idle-timeout-minutes>0</idle-timeout-minutes>
//                        <query-timeout>0</query-timeout>
//                        <use-try-lock>0</use-try-lock>
//                        <allocation-retry>0</allocation-retry>
//                        <allocation-retry-wait-millis>0</allocation-retry-wait-millis>
//                    </timeout>
//                    <statement>
//                        <share-prepared-statements>false</share-prepared-statements>
//                    </statement>
//                </datasource>
//<!--                 <datasource jta="true" jndi-name="java:/SpringDS" pool-name="SpringDS" enabled="true" use-ccm="false"> -->
//<!--                     <connection-url>jdbc:mysql://localhost:3306/new</connection-url> -->
//<!--                     <driver-class>com.mysql.jdbc.Driver</driver-class> -->
//<!--                     <driver>mysql</driver> -->
//<!--                     <pool> -->
//<!--                         <prefill>true</prefill> -->
//<!--                         <use-strict-min>false</use-strict-min> -->
//<!--                     </pool> -->
//<!--                     <security> -->
//<!--                         <user-name>root</user-name> -->
//<!--                         <password>MyNewPass</password> -->
//<!--                     </security> -->
//<!--                     <validation> -->
//<!--                         <validate-on-match>false</validate-on-match> -->
//<!--                         <background-validation>false</background-validation> -->
//<!--                     </validation> -->
//<!--                     <timeout> -->
//<!--                         <set-tx-query-timeout>false</set-tx-query-timeout> -->
//<!--                         <blocking-timeout-millis>0</blocking-timeout-millis> -->
//<!--                         <idle-timeout-minutes>0</idle-timeout-minutes> -->
//<!--                         <query-timeout>0</query-timeout> -->
//<!--                         <use-try-lock>0</use-try-lock> -->
//<!--                         <allocation-retry>0</allocation-retry> -->
//<!--                         <allocation-retry-wait-millis>0</allocation-retry-wait-millis> -->
//<!--                     </timeout> -->
//<!--                     <statement> -->
//<!--                         <share-prepared-statements>false</share-prepared-statements> -->
//<!--                     </statement> -->
//<!--                 </datasource> -->
//                <drivers>
//                    <driver name="mysql" module="com.mysql"/>
//                    <driver name="h2" module="com.h2database.h2">
//                        <xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
//                    </driver>
//                </drivers>
//            </datasources>
//        </subsystem>
//        <subsystem xmlns="urn:jboss:domain:deployment-scanner:1.1">
//            <deployment-scanner path="deployments" relative-to="jboss.server.base.dir" scan-interval="5000"/>
//        </subsystem>
//        <subsystem xmlns="urn:jboss:domain:ee:1.2">
//            <spec-descriptor-property-replacement>false</spec-descriptor-property-replacement>
//            <jboss-descriptor-property-replacement>true</jboss-descriptor-property-replacement>
//            <annotation-property-replacement>false</annotation-property-replacement>
//        </subsystem>
//        <subsystem xmlns="urn:jboss:domain:ejb3:1.4">
//            <session-bean>
//                <stateless>
//                    <bean-instance-pool-ref pool-name="slsb-strict-max-pool"/>
//                </stateless>
//                <stateful default-access-timeout="5000" cache-ref="simple"/>
//                <singleton default-access-timeout="5000"/>
//            </session-bean>
//            <pools>
//                <bean-instance-pools>
//                    <strict-max-pool name="slsb-strict-max-pool" max-pool-size="20" instance-acquisition-timeout="5" instance-acquisition-timeout-unit="MINUTES"/>
//                    <strict-max-pool name="mdb-strict-max-pool" max-pool-size="20" instance-acquisition-timeout="5" instance-acquisition-timeout-unit="MINUTES"/>
//                </bean-instance-pools>
//            </pools>
//            <caches>
//                <cache name="simple" aliases="NoPassivationCache"/>
//                <cache name="passivating" passivation-store-ref="file" aliases="SimpleStatefulCache"/>
//            </caches>
//            <passivation-stores>
//                <file-passivation-store name="file"/>
//            </passivation-stores>
//            <async thread-pool-name="default"/>
//            <timer-service thread-pool-name="default">
//                <data-store path="timer-service-data" relative-to="jboss.server.data.dir"/>
//            </timer-service>
//            <remote connector-ref="remoting-connector" thread-pool-name="default"/>
//            <thread-pools>
//                <thread-pool name="default">
//                    <max-threads count="10"/>
//                    <keepalive-time time="100" unit="milliseconds"/>
//                </thread-pool>
//            </thread-pools>
//            <default-security-domain value="other"/>
//            <default-missing-method-permissions-deny-access value="true"/>
//        </subsystem>
//        <subsystem xmlns="urn:jboss:domain:infinispan:1.5">
//            <cache-container name="web" aliases="standard-session-cache" default-cache="local-web" module="org.jboss.as.clustering.web.infinispan">
//                <local-cache name="local-web" batching="true">
//                    <file-store passivation="false" purge="false"/>
//                </local-cache>
//            </cache-container>
//            <cache-container name="hibernate" default-cache="local-query" module="org.jboss.as.jpa.hibernate:4">
//                <local-cache name="entity">
//                    <transaction mode="NON_XA"/>
//                    <eviction strategy="LRU" max-entries="10000"/>
//                    <expiration max-idle="100000"/>
//                </local-cache>
//                <local-cache name="local-query">
//                    <transaction mode="NONE"/>
//                    <eviction strategy="LRU" max-entries="10000"/>
//                    <expiration max-idle="100000"/>
//                </local-cache>
//                <local-cache name="timestamps">
//                    <transaction mode="NONE"/>
//                    <eviction strategy="NONE"/>
//                </local-cache>
//            </cache-container>
//        </subsystem>
//        <subsystem xmlns="urn:jboss:domain:jaxrs:1.0"/>
//        <subsystem xmlns="urn:jboss:domain:jca:1.1">
//            <archive-validation enabled="true" fail-on-error="true" fail-on-warn="false"/>
//            <bean-validation enabled="true"/>
//            <default-workmanager>
//                <short-running-threads>
//                    <core-threads count="50"/>
//                    <queue-length count="50"/>
//                    <max-threads count="50"/>
//                    <keepalive-time time="10" unit="seconds"/>
//                </short-running-threads>
//                <long-running-threads>
//                    <core-threads count="50"/>
//                    <queue-length count="50"/>
//                    <max-threads count="50"/>
//                    <keepalive-time time="10" unit="seconds"/>
//                </long-running-threads>
//            </default-workmanager>
//            <cached-connection-manager/>
//        </subsystem>
//        <subsystem xmlns="urn:jboss:domain:jdr:1.0"/>
//        <subsystem xmlns="urn:jboss:domain:jmx:1.3">
//            <expose-resolved-model/>
//            <expose-expression-model/>
//            <remoting-connector/>
//        </subsystem>
//        <subsystem xmlns="urn:jboss:domain:jpa:1.1">
//            <jpa default-datasource="" default-extended-persistence-inheritance="DEEP"/>
//        </subsystem>
//        <subsystem xmlns="urn:jboss:domain:jsf:1.0"/>
//        <subsystem xmlns="urn:jboss:domain:mail:1.1">
//            <mail-session jndi-name="java:jboss/mail/Default">
//                <smtp-server outbound-socket-binding-ref="mail-smtp"/>
//            </mail-session>
//        </subsystem>
//        <subsystem xmlns="urn:jboss:domain:naming:1.4">
//            <remote-naming/>
//        </subsystem>
//        <subsystem xmlns="urn:jboss:domain:pojo:1.0"/>
//        <subsystem xmlns="urn:jboss:domain:remoting:1.1">
//            <connector name="remoting-connector" socket-binding="remoting" security-realm="ApplicationRealm"/>
//        </subsystem>
//        <subsystem xmlns="urn:jboss:domain:resource-adapters:1.1"/>
//        <subsystem xmlns="urn:jboss:domain:sar:1.0"/>
//        <subsystem xmlns="urn:jboss:domain:security:1.2">
//            <security-domains>
//                <security-domain name="other" cache-type="default">
//                    <authentication>
//                        <login-module code="Disabled" flag="required"/>
//                    </authentication>
//                </security-domain>
//                <security-domain name="DBAuthTest">
//                    <authentication>
//                        <login-module code="org.jboss.security.auth.spi.DatabaseServerLoginModule" flag="required">
//                            <module-option name="dsJndiName" value="java:/mysqlCredential"/>
//                            <module-option name="principalsQuery" value="select password from  PRINCIPLES where principal_id=?"/>
//                            <module-option name="rolesQuery" value="select user_role, 'Roles' from  ROLES where  principal_id=?"/>
//                        </login-module>
//                        <login-module code="org.jboss.security.auth.spi.RoleMappingLoginModule" flag="optional">
//                            <module-option name="rolesProperties" value="/home/userone/jboss-as-7.0.1.Final/standalone/configuration/test-roles.properties"/>
//                            <module-option name="replaceRole" value="false"/>
//                        </login-module>
//                    </authentication>
//                </security-domain>
//            </security-domains>
//        </subsystem>
//        <subsystem xmlns="urn:jboss:domain:threads:1.1"/>
//        <subsystem xmlns="urn:jboss:domain:transactions:1.5">
//            <core-environment>
//                <process-id>
//                    <uuid/>
//                </process-id>
//            </core-environment>
//            <recovery-environment socket-binding="txn-recovery-environment" status-socket-binding="txn-status-manager"/>
//            <coordinator-environment default-timeout="300"/>
//        </subsystem>
//        <subsystem xmlns="urn:jboss:domain:web:2.1" default-virtual-server="default-host" native="false">
//            <connector name="http" protocol="HTTP/1.1" scheme="http" socket-binding="http"/>
//            <virtual-server name="default-host" enable-welcome-root="true">
//                <alias name="localhost"/>
//                <alias name="example.com"/>
//            </virtual-server>
//        </subsystem>
//        <subsystem xmlns="urn:jboss:domain:webservices:1.2">
//            <modify-wsdl-address>true</modify-wsdl-address>
//            <wsdl-host>${jboss.bind.address:127.0.0.1}</wsdl-host>
//            <endpoint-config name="Standard-Endpoint-Config"/>
//            <endpoint-config name="Recording-Endpoint-Config">
//                <pre-handler-chain name="recording-handlers" protocol-bindings="##SOAP11_HTTP ##SOAP11_HTTP_MTOM ##SOAP12_HTTP ##SOAP12_HTTP_MTOM">
//                    <handler name="RecordingHandler" class="org.jboss.ws.common.invocation.RecordingServerHandler"/>
//                </pre-handler-chain>
//            </endpoint-config>
//            <client-config name="Standard-Client-Config"/>
//        </subsystem>
//        <subsystem xmlns="urn:jboss:domain:weld:1.0"/>
//    </profile>
//
//    <interfaces>
//        <interface name="management">
//            <inet-address value="${jboss.bind.address.management:127.0.0.1}"/>
//        </interface>
//        <interface name="public">
//            <inet-address value="${jboss.bind.address:127.0.0.1}"/>
//        </interface>
//        <interface name="unsecure">
//            <inet-address value="${jboss.bind.address.unsecure:127.0.0.1}"/>
//        </interface>
//    </interfaces>
//
//    <socket-binding-group name="standard-sockets" default-interface="public" port-offset="${jboss.socket.binding.port-offset:0}">
//        <socket-binding name="management-native" interface="management" port="${jboss.management.native.port:9999}"/>
//        <socket-binding name="management-http" interface="management" port="${jboss.management.http.port:9990}"/>
//        <socket-binding name="management-https" interface="management" port="${jboss.management.https.port:9443}"/>
//        <socket-binding name="ajp" port="8009"/>
//        <socket-binding name="http" port="8080"/>
//        <socket-binding name="https" port="8443"/>
//        <socket-binding name="remoting" port="4447"/>
//        <socket-binding name="txn-recovery-environment" port="4712"/>
//        <socket-binding name="txn-status-manager" port="4713"/>
//        <outbound-socket-binding name="mail-smtp">
//            <remote-destination host="localhost" port="25"/>
//        </outbound-socket-binding>
//    </socket-binding-group>
//</server>
//GRANT ALL ON hellosocial2.* TO pras_khanal@'202.161.110.40' IDENTIFIED BY 'MyNewPass';