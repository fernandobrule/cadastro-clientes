echo "use dbcadclidev;" > gendb/gen-create-entities-all.sql
cat create/create-entity-cliente.sql \
   >> gendb/gen-create-entities-all.sql 
