echo "use dbcadclidev;" > gendb/gen-populate-entities-all.sql
cat populate/populate-entity-cliente.sql \
   >> gendb/gen-populate-entities-all.sql 
