echo "------------------------------------------------------"
echo "Reading arg for GROUP_ID"
GROUP_ID=$1
if [ -z "$GROUP_ID" ]
then
  GROUP_ID="1"
  echo "GROUP_ID not informed. Assuming value 1"
else
  echo "GROUP_ID informed with value $GROUP_ID"
fi

echo "Compile and execute Consumer with GROUP_ID = $GROUP_ID"
echo "------------------------------------------------------"

mvn compile exec:java -Dexec.mainClass="br.wals.messaging.SimpleConsumer" -Dexec.args="teste grupo$GROUP_ID"

ERROR_ON_EXEC=$?

if [ ERROR_ON_EXEC != 0 ]
then
  echo "\n------------------------------------------------------"
  echo "> Error on compile and run: $ERROR_ON_EXEC"
  echo "------------------------------------------------------"
fi