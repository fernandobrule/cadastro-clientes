
use mysql;

delete from user where user ='dbcadclidevusr';
flush privileges;

create user 'dbcadclidevusr'@'${env.IP_HOST}' identified by 'dbcadclidevpsw';
  
grant all on *.* to 'dbcadclidevusr'@'${env.IP_HOST}' with grant option;

flush privileges;


