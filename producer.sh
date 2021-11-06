echo "------------------------------------------------------"
echo "Compile and execute Producer"
echo "------------------------------------------------------"
mvn compile exec:java -Dexec.mainClass="br.wals.messaging.SimpleProducer" -Dexec.args="teste"

ERROR_ON_EXEC=$?

if [ ERROR_ON_EXEC != 0 ]
then
  echo "\n------------------------------------------------------"
  echo "> Error on compile and run: $ERROR_ON_EXEC"
  echo "------------------------------------------------------"
fi