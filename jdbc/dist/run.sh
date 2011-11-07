for ((  i = 0 ;  i < 50;  i++  ))
do
  java -jar PostgreSQLTest.jar >> main.txt
  echo -ne $i
done

echo ""
