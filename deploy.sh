#!/bin/sh
LOCAL_PATH=/Users/allan/Works/backend/fansz-backend
REMOTE_PATH=/home/applications

pssh -P -h hosts.txt $REMOTE_PATH/access-layer-2.0.0-RELEASE/bin/shutdown.sh 
pssh -P -h hosts.txt $REMOTE_PATH/fansz-auth-oauth-2.0.0-RELEASE/bin/shutdown.sh  
pssh -P -h hosts.txt $REMOTE_PATH/event-server-2.0.0-RELEASE/bin/shutdown.sh  
pssh -P -h hosts.txt $REMOTE_PATH/fansz-fandom-service-2.0.0-RELEASE/bin/shutdown.sh  
pssh -P -h hosts.txt $REMOTE_PATH/fansz-newsfeeds-service-2.0.0-RELEASE/bin/shutdown.sh  
pssh -P -h hosts.txt $REMOTE_PATH/fansz-relations-service-2.0.0-RELEASE/bin/shutdown.sh
pssh -P -h hosts.txt $REMOTE_PATH/fansz-token-service-2.0.0-RELEASE/bin/shutdown.sh

pssh -P -h hosts.txt rm -ri $REMOTE_PATH/*
pscp -h hosts.txt $LOCAL_PATH/fansz-access-layer/target/access-layer-2.0.0-RELEASE-package.tar.gz $REMOTE_PATH/
pscp -h hosts.txt $LOCAL_PATH/fansz-auth/fansz-auth-oauth/target/fansz-auth-oauth-2.0.0-RELEASE-package.tar.gz $REMOTE_PATH/
pscp -h hosts.txt $LOCAL_PATH/fansz-event-server/target/event-server-2.0.0-RELEASE-package.tar.gz $REMOTE_PATH/
pscp -h hosts.txt $LOCAL_PATH/fansz-fandom/fansz-fandom-service/target/fansz-fandom-service-2.0.0-RELEASE-package.tar.gz $REMOTE_PATH/
pscp -h hosts.txt $LOCAL_PATH/fansz-newsfeeds/fansz-newsfeeds-service/target/fansz-newsfeeds-service-2.0.0-RELEASE-package.tar.gz $REMOTE_PATH/
pscp -h hosts.txt $LOCAL_PATH/fansz-relations/fansz-relations-service/target/fansz-relations-service-2.0.0-RELEASE-package.tar.gz $REMOTE_PATH/
pscp -h hosts.txt $LOCAL_PATH/fansz-token/fansz-token-service/target/fansz-token-service-2.0.0-RELEASE-package.tar.gz $REMOTE_PATH/


pssh -P -h hosts.txt  tar -xvf $REMOTE_PATH/access-layer-2.0.0-RELEASE-package.tar.gz -C $REMOTE_PATH/
pssh -P -h hosts.txt  tar -xvf $REMOTE_PATH/fansz-auth-oauth-2.0.0-RELEASE-package.tar.gz -C $REMOTE_PATH/
pssh -P -h hosts.txt  tar -xvf $REMOTE_PATH/event-server-2.0.0-RELEASE-package.tar.gz -C $REMOTE_PATH/
pssh -P -h hosts.txt  tar -xvf $REMOTE_PATH/fansz-fandom-service-2.0.0-RELEASE-package.tar.gz -C $REMOTE_PATH/
pssh -P -h hosts.txt  tar -xvf $REMOTE_PATH/fansz-newsfeeds-service-2.0.0-RELEASE-package.tar.gz -C $REMOTE_PATH/
pssh -P -h hosts.txt  tar -xvf $REMOTE_PATH/fansz-relations-service-2.0.0-RELEASE-package.tar.gz -C $REMOTE_PATH/
pssh -P -h hosts.txt  tar -xvf $REMOTE_PATH/fansz-token-service-2.0.0-RELEASE-package.tar.gz -C $REMOTE_PATH/

pssh -P -h hosts.txt $REMOTE_PATH/fansz-relations-service-2.0.0-RELEASE/bin/startup.sh
pssh -P -h hosts.txt $REMOTE_PATH/fansz-newsfeeds-service-2.0.0-RELEASE/bin/startup.sh
pssh -P -h hosts.txt $REMOTE_PATH/fansz-fandom-service-2.0.0-RELEASE/bin/startup.sh
pssh -P -h hosts.txt $REMOTE_PATH/event-server-2.0.0-RELEASE/bin/startup.sh
pssh -P -h hosts.txt $REMOTE_PATH/fansz-auth-oauth-2.0.0-RELEASE/bin/startup.sh
pssh -P -h hosts.txt $REMOTE_PATH/fansz-token-service-2.0.0-RELEASE/bin/startup.sh
sleep 3s
pssh -P -h hosts.txt $REMOTE_PATH/access-layer-2.0.0-RELEASE/bin/startup.sh




