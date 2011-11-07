for ((  i = 0 ;  i < 50;  i++  ))
do
  java -jar PostgreSQLHibernateTest.jar >> main.txt
  echo -ne $i
done

echo ""
