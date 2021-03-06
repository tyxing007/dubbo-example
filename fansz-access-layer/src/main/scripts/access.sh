MAIN_CLASS="com.fansz.access.AccessStarter"
  
#  
cd `dirname $0`/..  
BASE_DIR="`pwd`"
echo  "$BASE_DIR"

  
# cat 
export JAVA_HOME="/usr/local/jdk1.7.0_79"
   
  
JAVA_OPTS="$JAVA_OPTS -server -Xms2048m -Xmx2048m -XX:PermSize=256m -XX:MaxPermSize=512m"
#JAVA_OPTS="$JAVA_OPTS -XX:+UseConcMarkSweepGC"
JAVA_OPTS="$JAVA_OPTS -XX:+UseG1GC -XX:MaxGCPauseMillis=200"  
#JAVA_OPTS="$JAVA_OPTS -XX:+UnlockExperimentalVMOptions -XX:G1LogLevel=finest -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCApplicationStoppedTime"
  
JAVA_OPTS="$JAVA_OPTS -XX:+HeapDumpOnOutOfMemoryError"  
JAVA_OPTS="$JAVA_OPTS -Xloggc:$BASE_DIR/logs/gc.log"
ACCESS_PID="$BASE_DIR/logs/access.pid"

if [ ! -f "$JAVA_HOME/bin/java" ]; then  
  echo "please set JAVA_HOME"  
  exit 1;  
fi  
  
LOG_PATH="$BASE_DIR/logs" 
ACCESS_OUT="$LOG_PATH/access.out"
  
if [ ! -d "$LOG_PATH" ]; then                                                                                                                                                   
    mkdir $LOG_PATH  
fi  

#star access server
nohup "$JAVA_HOME"/bin/java  $JAVA_OPTS  -Dapplication.root="$BASE_DIR" -Dlog4j.configuration="file:$BASE_DIR/conf/log4j.xml" -classpath "$BASE_DIR/lib/*" "$MAIN_CLASS"  >> "$ACCESS_OUT" 2>&1 &

echo $! > "$ACCESS_PID"



