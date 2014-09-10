Copyright 2014 by Avid Technology, Inc.

UMS - MediaCentral | UX User Management System
===================================================

How to start the development:
-----------------------------
* Clone [repo] (http://ums-git/the-benders/ums)
* Install environment: `source ./setenv-git`
* Build artifacts: `mvn clean install -DskipTests`
* Enjoy coding using [IntelliJIDEA] (http://www.jetbrains.com/idea/), or just code using [Eclipse] (http://www.eclipse.org/)

To build an RPM use `mvn clean install -DskipTests -Prpm`
Install dependencies and feel free to setup UMS RPM, you should be able to find it here:
`uls-rpm/target/rpm/avid-ums/RPMS/noarch/`

How to install UMS dependencies:
-------------------------------

### Installing PostgreSQL

Install packages, they are available at build7's ics_Int repository.
`sudo yum install -c http://build7/repo/ics_Int.repo postgresql91 postgresql91-server postgresql91-libs postgresql91-contrib postgresql91-devel`

Initialize service:
`sudo service postgresql-9.1 initdb`


Replace configuration file `/var/lib/pgsql/9.1/data/pg_hba.conf` contents with:

    local   all         all                               trust
    host    all         all         0.0.0.0/0             trust


Start service:
`sudo service postgresql-9.1 start`

Make it starting automatically on boot:

    sudo chkconfig --add postgresql-9.1
    sudo chkconfig postgresql-9.1 on

Verify that everything is working:
`psql -U postgres` - should connect to PostgreSQL.

### Installing Redis

    sudo yum install redis -c http://build7/repo/ics_Int.repo
    sudo service redis start
    sudo chkconfig --add redis
    sudo chkconfig redis on


### Installing BUS

    sudo yum install tk unixODBC
    sudo yum -c http://build7/repo/ics_Int.repo install mongo-10gen-server mongo-10gen avid-acscontrollers avid-acsappserver avid-acsnodemodules avid-acsutils nodejs-modules rabbitmq-server -y
    sudo service mongod start
    sudo service rabbitmq-server start
    sudo service acs-ctrl-core stop
    avid-db-reset services
    sudo service avid-acs-ctrl-core start      
    sudo service avid-acs-ctrl-core status
    sudo service avid-acs-ctrl-core restart
    sudo service avid-acs-app-server start

    sudo chkconfig --add rabbitmq-server
    sudo chkconfig --add mongod
    sudo chkconfig rabbitmq-server on
    sudo chkconfig mongod on

### Fixing RabbitMQ issues

if you got error about RabbitMqBrokerClient, try to do next:
* goto [ReabbitMQ web ui] (http://localhost:15672/) and login as `guest/guest`
* in Virtual Host tab create VH `acs`
* in Admin tab create user `acs_user/acs` with administrator tag and grant him acces `.* .* .*` to `acs` VH
* in Exchanges tab create new exchanges (topics) for `acs` VH: `Local.Broadcasts`, `Local.Channels`, `Local.Requests`, `Zone.Replies`.
 
Also see RabbitMQ logs for any issues: `/var/log/rabbitmq/`

Cheers!
